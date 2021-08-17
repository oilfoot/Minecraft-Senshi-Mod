package com.oilfoot.senshi.items.katana;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;


public class kazeshiniKatana extends SwordItem {
    public kazeshiniKatana(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText("text.senshi.kazenshiText"));
    }


}
