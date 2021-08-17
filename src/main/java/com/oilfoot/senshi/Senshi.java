package com.oilfoot.senshi;

import com.oilfoot.senshi.generation.ores.EnhancementOreGeneration;
import com.oilfoot.senshi.registry.ModBlocks;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import com.oilfoot.senshi.registry.ModStructures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;

public class Senshi implements ModInitializer {

    public static final String MOD_ID = "senshi";
    public static final Identifier SHURIKEN_THROW = new Identifier("senshi:shuriken_throw");
    public static SoundEvent SHURIKEN_THROW_EVENT = new SoundEvent(SHURIKEN_THROW);

    public static final Identifier SHURIKEN_LAND = new Identifier("senshi:shuriken_land");
    public static SoundEvent SHURIKEN_LAND_EVENT = new SoundEvent(SHURIKEN_LAND);

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitialize() {

        GeckoLib.initialize();
        ModItems.RegisterItems();
        new ModEntities();
        ModEntities.init();
        ModBlocks.registerBlocks();
        EnhancementOreGeneration.GenerateEnhacementOre();
        ModStructures.RegisterStructures();
    }
}
