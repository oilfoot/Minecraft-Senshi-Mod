package com.oilfoot.senshi.generation.ores;

import com.oilfoot.senshi.registry.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EnhancementOreGeneration extends ModBlocks {

    private static ConfiguredFeature<?,?> ENHANCEMENT_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ENHANCEMENT_ORE.getDefaultState(), 9)).decorate(Decorator.RANGE.configure
            (new RangeDecoratorConfig(0,0,20))).spreadHorizontally().repeat(5);

    public static void GenerateEnhacementOre(){
        RegistryKey<ConfiguredFeature<?,?>> enhancementOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("senshi","enhancement_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, enhancementOreOverworld.getValue(),ENHANCEMENT_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, enhancementOreOverworld);
    }

}
