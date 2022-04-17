package com.oilfoot.senshi.items.throwables.shuriken;

import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EnderShurikenEntity extends PersistentProjectileEntity {
    public boolean isStopped = false;

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.ENDER_SHURIKEN);
    }

    public EnderShurikenEntity(EntityType<? extends EnderShurikenEntity> entityType, World world) {
        super(entityType, world);
    }
    public EnderShurikenEntity(World world, double x, double y, double z) {
        super(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, x, y, z, world);
    }
    public EnderShurikenEntity(World world) {
        super(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, world);
    }
    public EnderShurikenEntity(World world, LivingEntity owner) {
        super(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, owner, world);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, Senshi.PacketID);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entityHit = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) // sets i to 3 if the Entity instance is an instance of BlazeEntity
        {
            entityHit.damage(DamageSource.thrownProjectile(this, this.getOwner()), 0f); // deals damage

            ((LivingEntity) entityHit).addStatusEffect((new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 3, 0))); // applies a status effect
            ((LivingEntity) entityHit).addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 2))); // applies a status effect
            entityHit.playSound(Senshi.SHURIKEN_LAND_EVENT, 2F, 1F); // plays a sound for the entity hit only

            if (!this.world.isClient && !this.isRemoved()) {
                if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                    if (serverPlayerEntity.networkHandler.getConnection().isOpen() && serverPlayerEntity.world == this.world) {
                        serverPlayerEntity.isSleeping();
                    }

                    if (entity.hasVehicle()) {
                        entity.stopRiding();
                    }

                    entity.requestTeleport(this.getX(), this.getY(), this.getZ());
                    entity.fallDistance = 0.0F;
                    entity.damage(DamageSource.FALL, 0.0F);
                }
            } else {
                entity.requestTeleport(this.getX(), this.getY(), this.getZ());
                entity.fallDistance = 0.0F;
            }
        }
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
    }

    @Override
    protected void onBlockCollision(BlockState state) {
        super.onBlockCollision(state);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.isStopped = true;
        this.playSound(Senshi.SHURIKEN_LAND_EVENT, 2F, 1F);
        Entity entity = this.getOwner();

        for(int i = 0; i < 32; ++i) {
            this.world.addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (!this.world.isClient && !this.isRemoved()) {
            if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                if (serverPlayerEntity.networkHandler.getConnection().isOpen() && serverPlayerEntity.world == this.world) {
                    serverPlayerEntity.isSleeping();
                }

                if (entity.hasVehicle()) {
                    entity.stopRiding();
                }

                entity.requestTeleport(this.getX(), this.getY(), this.getZ());
                entity.fallDistance = 0.0F;
                entity.damage(DamageSource.FALL, 0.0F);
            }
        } else if (entity != null) {
            entity.requestTeleport(this.getX(), this.getY(), this.getZ());
            entity.fallDistance = 0.0F;
        }

        this.discard();
    }


    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof PlayerEntity && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }

    }

    @Nullable
    public Entity moveToWorld(ServerWorld destination) {
        Entity entity = this.getOwner();

        return super.moveToWorld(destination);
    }

}