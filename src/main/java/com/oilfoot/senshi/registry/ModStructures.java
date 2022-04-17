package com.oilfoot.senshi.registry;

import com.oilfoot.senshi.generation.structures.katanaHort.KatanaHort;
import com.oilfoot.senshi.generation.structures.katanaHort.KatanaHortPiece;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class ModStructures {

    //Katana Hort
    //public static final StructurePieceType KATANAHORT_PIECE = KatanaHortPiece::new;
    //private static final StructureFeature<DefaultFeatureConfig> KATANAHORT_STRUCTURE = new KatanaHort(DefaultFeatureConfig.CODEC);
    //private static final ConfiguredStructureFeature<?, ?> KATANAHORT_CONFIGURED = KATANAHORT_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);

    public static void RegisterStructures() {
/*
        //Katana Hort
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier("senshi", "katanahort_piece"), KATANAHORT_PIECE);
        FabricStructureBuilder.create(new Identifier("senshi","katanahort_structure"), KATANAHORT_STRUCTURE)
        .step(GenerationStep.Feature.SURFACE_STRUCTURES)
        .defaultConfig(32, 8, 123456)
        .adjustsSurface()
        .register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> katanahortConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier("senshi", "katanahort_structure"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, katanahortConfigured.getValue(), KATANAHORT_CONFIGURED);

        BiomeModifications.addStructure(BiomeSelectors.all(), katanahortConfigured);

        }

 */

    }
}