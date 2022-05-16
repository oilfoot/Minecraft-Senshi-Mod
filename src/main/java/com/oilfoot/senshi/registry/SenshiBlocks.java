package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.blocks.*;
import com.oilfoot.senshi.world.feature.tree.SakuraSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;

public class SenshiBlocks {

    public static final Block CHAINS = new Block(FabricBlockSettings.of(Material.DECORATION)
            //TODO add tool tag in data
            .strength(1.0F, 15.0F)
            .sounds(BlockSoundGroup.CHAIN)
            .nonOpaque());

    public static final Block TATAMI = new TatamiBlock(FabricBlockSettings.of(Material.DECORATION)
            //TODO add tool tag in data
            .breakInstantly()
            .sounds(BlockSoundGroup.WOOL)
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

    public static final Block RICE_WALL = new RiceWallBlock(FabricBlockSettings.of(Material.WOOD)
            //TODO add tool tag in data
            .sounds(BlockSoundGroup.WOOL)
            .strength(0.5F, 2)
            .nonOpaque());

    public static final Block RICE_DOOR = new RiceDoorBlock(FabricBlockSettings.of(Material.WOOD)
            //TODO add tool tag in data
            .sounds(BlockSoundGroup.WOOL)
            .strength(0.5F, 2)
            .nonOpaque());

    public static final Block GROUND_LANTERN = new GroundLanternBlock(FabricBlockSettings.of(Material.WOOD)
            //TODO add tool tag in data
            .sounds(BlockSoundGroup.LANTERN)
            .strength(1.0F, 5)
            .luminance(15)
            .nonOpaque());

    public static final Block SHRINE = new ShrineBlock(FabricBlockSettings.of(Material.STONE)
            //TODO add tool tag in data
            .sounds(BlockSoundGroup.STONE)
            .strength(2.5F)
            .nonOpaque());

    public static final Block ROCK_PATH = new RockPathBlock(FabricBlockSettings.of(Material.STONE)
            .sounds(BlockSoundGroup.STONE)
            .strength(2.5F)
            .nonOpaque());


    public static final Block SAKURA_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG));
    public static final Block SAKURA_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
    public static final Block SAKURA_SAPLING = new SakuraSaplingBlock(new SakuraSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING));
    public static final Block SAKURA_PLANKS = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS));
    public static final Block WAXED_SAKURA_PLANKS = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS));
    public static final Block SAKURA_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB));
    public static final Block JAPANESE_LANTERN = new JapaneseLanternBlock(FabricBlockSettings.copy(Blocks.LANTERN));
    public static final Block TRADITIONAL_LANTERN = new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN));


    public static void registerBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "chains"), CHAINS);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "katanablock"), KATANABLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "enhancement_ore"), ENHANCEMENT_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "tatami"), TATAMI);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "rice_wall"), RICE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "rice_door"), RICE_DOOR);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "sakura_log"), SAKURA_LOG);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "sakura_leaves"), SAKURA_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "sakura_sapling"), SAKURA_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "sakura_planks"), SAKURA_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "waxed_sakura_planks"), WAXED_SAKURA_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "sakura_slabs"), SAKURA_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "japanese_lantern"), JAPANESE_LANTERN);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "traditional_lantern"), TRADITIONAL_LANTERN);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "ground_lantern"), GROUND_LANTERN);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "shrine"), SHRINE);
        Registry.register(Registry.BLOCK, new Identifier(Senshi.MOD_ID, "rock_path"), ROCK_PATH);

    }

}
