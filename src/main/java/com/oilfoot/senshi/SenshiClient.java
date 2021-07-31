package com.oilfoot.senshi;

import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorRenderer;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageRenderer;
import com.oilfoot.senshi.registry.ModBlocks;
import com.oilfoot.senshi.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

@Environment(EnvType.CLIENT)
public class SenshiClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        //Samurai Armor
        GeoArmorRenderer.registerArmorRenderer(MappleSamuraiArmorItem.class, new MappleSamuraiArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(TakedaSamuraiArmorItem.class, new TakedaSamuraiArmorRenderer());
        EntityRendererRegistry.INSTANCE.register(ModEntities.OGRE_RAGE_ENTITY,
                (entityRenderDispatcher, context) -> new OgreRageRenderer(entityRenderDispatcher));
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAINS, RenderLayer.getCutout());
    }
}