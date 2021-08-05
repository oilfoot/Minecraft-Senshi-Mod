package com.oilfoot.senshi;

import com.oilfoot.senshi.generation.ores.EnhancementOreGeneration;
import com.oilfoot.senshi.registry.ModBlocks;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;

public class Senshi implements ModInitializer {

    public static final String MOD_ID = "senshi";

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitialize() {
        GeckoLib.initialize();
        ModItems.RegisterItems();
        new ModEntities();
        ModEntities.init();
        ModBlocks.registerBlocks();
        EnhancementOreGeneration.GenerateEnhacementOre();
    }
}
