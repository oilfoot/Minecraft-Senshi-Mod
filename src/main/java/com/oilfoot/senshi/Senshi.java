package com.oilfoot.senshi;

import com.oilfoot.senshi.generation.SenshiTreeGeneration;
import com.oilfoot.senshi.generation.SenshiWorldGen;
import com.oilfoot.senshi.registry.*;
import com.oilfoot.senshi.world.feature.SenshiConfiguredFeatures;
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

    public static final Identifier KAPPA_AMBIENT = new Identifier("senshi:kappa_ambient");
    public static SoundEvent KAPPA_AMBIENT_EVENT = new SoundEvent(KAPPA_AMBIENT);

    public static final Identifier KAPPA_HURT = new Identifier("senshi:kappa_hurt");
    public static SoundEvent KAPPA_HURT_EVENT = new SoundEvent(KAPPA_HURT);

    public static final Identifier KAPPA_DEATH = new Identifier("senshi:kappa_death");
    public static SoundEvent KAPPA_DEATH_EVENT = new SoundEvent(KAPPA_DEATH);

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitialize() {

        GeckoLib.initialize();
        SenshiItems.RegisterItems();
        new SenshiEntities();
        SenshiEntities.init();
        SenshiBlocks.registerBlocks();
        EntitySpawns.init();
        SenshiConfiguredFeatures.registerConfiguredFeatures();
        //TODO EnhancementOreGeneration.GenerateEnhacementOre();
        //SenshiStructures.RegisterStructures();
        //SenshiTreeGeneration.generateTrees();
    }
}
