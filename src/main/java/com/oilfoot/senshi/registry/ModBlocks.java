package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.Senshi;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CHAINS = new Block(FabricBlockSettings.of(Material.DECORATION)
            //TODO add tool tag in data
            .strength(1.0F, 15.0F)
            .sounds(BlockSoundGroup.CHAIN)
            .nonOpaque());

    public static final Block KATANABLOCK = new Block(FabricBlockSettings.of(Material.DECORATION)
            //TODO add tool tag in data
            .breakInstantly()
            .sounds(BlockSoundGroup.METAL)
            .strength(0.0F,0.0F)
            .nonOpaque());

    public static final Block ENHANCEMENT_ORE = new Block(FabricBlockSettings.of(Material.METAL)
            //TODO add tool tag in data
            .requiresTool()
            .strength(3.0F, 15.0F)
            .sounds(BlockSoundGroup.METAL)
            .luminance(6));

    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "chains"), CHAINS);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "katanablock"), KATANABLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "enhancement_ore"), ENHANCEMENT_ORE);

    }

}
