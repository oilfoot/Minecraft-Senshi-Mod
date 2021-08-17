package com.oilfoot.senshi.items.throwables.shuriken;

import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class shurikenItem extends Item {
    public shurikenItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), Senshi.SHURIKEN_THROW_EVENT, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
        if (!world.isClient) {
            shurikenEntity entity = new shurikenEntity(world, user);
            entity.setOwner(user);
            entity.setProperties(user, user.pitch, user.yaw, 0.0F, 3.5F, 0.1F);
            world.spawnEntity(entity); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.abilities.creativeMode) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}

