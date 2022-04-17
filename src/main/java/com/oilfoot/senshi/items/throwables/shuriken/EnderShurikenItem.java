package com.oilfoot.senshi.items.throwables.shuriken;

import com.oilfoot.senshi.Senshi;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class EnderShurikenItem extends Item {
    public EnderShurikenItem(Settings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText("text.senshi.enderShurikenText"));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), Senshi.SHURIKEN_THROW_EVENT, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
        if (!world.isClient) {
            EnderShurikenEntity entity = new EnderShurikenEntity(world, user);
            entity.setOwner(user);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.5F, 0.1F);
            world.spawnEntity(entity); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.isCreative()) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }


        return TypedActionResult.success(itemStack, world.isClient());
    }
}

