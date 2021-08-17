package com.oilfoot.senshi.items.throwables.shuriken;

import com.google.common.collect.Sets;
import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.UUID;

public class shurikenEntity extends PersistentProjectileEntity {
    public boolean isStopped = false;

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.SHURIKEN);
    }

    public shurikenEntity(EntityType<? extends shurikenEntity> entityType, World world) {
        super(entityType, world);
    }
    public shurikenEntity(World world, double x, double y, double z) {
        super(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, x, y, z, world);
    }
    public shurikenEntity(World world) {
        super(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, world);
    }
    public shurikenEntity(World world, LivingEntity owner) {
        super(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, owner, world);
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