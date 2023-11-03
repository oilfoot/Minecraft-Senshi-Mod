package com.oilfoot.senshi;

import com.oilfoot.senshi.armor.fallen.FallenSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.hood.HoodArmorRenderer;
import com.oilfoot.senshi.armor.kumo_no_ashi.knaArmorRenderer;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorRenderer;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorRenderer;
import com.oilfoot.senshi.entities.kappa.KappaRenderer;
import com.oilfoot.senshi.entities.kumocrawler.KumoCrawlerRenderer;
import com.oilfoot.senshi.entities.kumotoko.KumotokoRenderer;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageRenderer;
import com.oilfoot.senshi.entities.samurai.SamuraiRenderer;
import com.oilfoot.senshi.items.katana.KatanaRenderer;
import com.oilfoot.senshi.items.mortalblade.MortalBladeRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EnderShurikenRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EntitySpawnPacket;
import com.oilfoot.senshi.items.throwables.shuriken.ShurikenRenderer;
import com.oilfoot.senshi.registry.SenshiBlocks;
import com.oilfoot.senshi.registry.SenshiEntities;
import com.oilfoot.senshi.registry.SenshiItems;
import com.oilfoot.senshi.world.feature.SenshiConfiguredFeatures;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class SenshiClient implements ClientModInitializer {

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {

        SenshiConfiguredFeatures.registerConfiguredFeatures();

        //Armor
        GeoArmorRenderer.registerArmorRenderer(new MappleSamuraiArmorRenderer(), SenshiItems.MAPPLE_KABUTO, SenshiItems.MAPPLE_DO, SenshiItems.MAPPLE_HAIDATE, SenshiItems.MAPPLE_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new TakedaSamuraiArmorRenderer(), SenshiItems.TAKEDA_KABUTO, SenshiItems.TAKEDA_DO, SenshiItems.TAKEDA_HAIDATE, SenshiItems.TAKEDA_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new ShinobiArmorRenderer(), SenshiItems.SHINOBI_HOOD, SenshiItems.SHINOBI_ROBE, SenshiItems.SHINOBI_HAIDATE, SenshiItems.SHINOBI_SHOES);
        GeoArmorRenderer.registerArmorRenderer(new TokugawaSamuraiArmorRenderer(), SenshiItems.TOKUGAWA_KABUTO, SenshiItems.TOKUGAWA_DO, SenshiItems.TOKUGAWA_HAIDATE, SenshiItems.TOKUGAWA_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new FallenSamuraiArmorRenderer(), SenshiItems.FALLEN_KABUTO, SenshiItems.FALLEN_DO, SenshiItems.FALLEN_HAIDATE, SenshiItems.FALLEN_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new knaArmorRenderer(), SenshiItems.KUMO_NO_ASHI);
        GeoArmorRenderer.registerArmorRenderer(new HoodArmorRenderer(), SenshiItems.HOOD);

        //Items
        GeoItemRenderer.registerItemRenderer(SenshiItems.KATANA, new KatanaRenderer());
        GeoItemRenderer.registerItemRenderer(SenshiItems.MORTAL_BLADE, new MortalBladeRenderer());

        //Blocks

        //Entity
        EntityRendererRegistry.INSTANCE.register(SenshiEntities.OGRE_RAGE_ENTITY, OgreRageRenderer::new);
        EntityRendererRegistry.INSTANCE.register(SenshiEntities.KAPPA_ENTITY, KappaRenderer::new);
        EntityRendererRegistry.INSTANCE.register(SenshiEntities.KUMOTOKO_ENTITY, KumotokoRenderer::new);
        EntityRendererRegistry.INSTANCE.register(SenshiEntities.KUMOCRAWLER_ENTITY, KumoCrawlerRenderer::new);
        EntityRendererRegistry.INSTANCE.register(SenshiEntities.SAMURAI_ENTITY, SamuraiRenderer::new);


        EntityRendererRegistry.INSTANCE.register(SenshiEntities.SHURIKEN_ENTITY_ENTITY_TYPE, ShurikenRenderer::new);
        EntityRendererRegistry.INSTANCE.register(SenshiEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, EnderShurikenRenderer::new);
        receiveEntityPacket();

        //Blocks
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.CHAINS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.SAKURA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.SAKURA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.RICE_WALL, RenderLayer.getCutout().getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.TRADITIONAL_LANTERN, RenderLayer.getCutout().getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.JAPANESE_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.GROUND_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SenshiBlocks.SHRINE, RenderLayer.getCutout());

        //Sounds
        Registry.register(Registry.SOUND_EVENT, Senshi.SHURIKEN_THROW, Senshi.SHURIKEN_THROW_EVENT);
        Registry.register(Registry.SOUND_EVENT, Senshi.SHURIKEN_LAND, Senshi.SHURIKEN_LAND_EVENT);
        Registry.register(Registry.SOUND_EVENT, Senshi.KAPPA_AMBIENT, Senshi.KAPPA_AMBIENT_EVENT);
        Registry.register(Registry.SOUND_EVENT, Senshi.KAPPA_HURT, Senshi.KAPPA_HURT_EVENT);
        Registry.register(Registry.SOUND_EVENT, Senshi.KAPPA_DEATH, Senshi.KAPPA_DEATH_EVENT);

        registerFlammableBlock();

    }

    private static void registerFlammableBlock(){
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(SenshiBlocks.SAKURA_LOG, 5, 5);
        instance.add(SenshiBlocks.SAKURA_LEAVES, 30, 60);
        instance.add(SenshiBlocks.SAKURA_SAPLING, 30, 50);
        instance.add(SenshiBlocks.SAKURA_PLANKS, 5, 20);
    }

    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.setPitch(pitch);
                e.getYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }
}