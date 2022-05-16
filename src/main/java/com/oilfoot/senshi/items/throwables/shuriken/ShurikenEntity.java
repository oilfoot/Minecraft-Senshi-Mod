package com.oilfoot.senshi.items.throwables.shuriken;

import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.registry.SenshiEntities;
import com.oilfoot.senshi.registry.SenshiItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ShurikenEntity extends PersistentProjectileEntity {
    public boolean isStopped = false;

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(SenshiItems.SHURIKEN);
    }

    public ShurikenEntity(EntityType<? extends ShurikenEntity> entityType, World world) {
        super(entityType, world);
    }
    public ShurikenEntity(World world, double x, double y, double z) {
        super(SenshiEntities.SHURIKEN_ENTITY_ENTITY_TYPE, x, y, z, world);
    }
    public ShurikenEntity(World world) {
        super(SenshiEntities.SHURIKEN_ENTITY_ENTITY_TYPE, world);
    }
    public ShurikenEntity(World world, LivingEntity owner) {
        super(SenshiEntities.SHURIKEN_ENTITY_ENTITY_TYPE, owner, world);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, Senshi.PacketID);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        if (entity instanceof LivingEntity) // sets i to 3 if the Entity instance is an instance of BlazeEntity
        {
            entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 2f); // deals damage

            //((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 3, 0))); // applies a status effect
            //((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 3, 2))); // applies a status effect
            //((LivingEntity) entity).addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 1))); // applies a status effect
            entity.playSound(Senshi.SHURIKEN_LAND_EVENT, 2F, 1F); // plays a sound for the entity hit only
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
        this.playSound(Senshi.SHURIKEN_LAND_EVENT, 0.5F, 1F);
    }


}