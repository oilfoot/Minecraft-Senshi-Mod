package com.oilfoot.senshi;

import com.oilfoot.senshi.armor.fallen.FallenSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.kumo_no_ashi.knaArmorRenderer;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorRenderer;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorRenderer;
import com.oilfoot.senshi.entities.kappa.KappaRenderer;
import com.oilfoot.senshi.entities.kumocrawler.KumoCrawlerRenderer;
import com.oilfoot.senshi.entities.kumotoko.KumotokoRenderer;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageRenderer;
import com.oilfoot.senshi.items.katana.KatanaModel;
import com.oilfoot.senshi.items.katana.KatanaRenderer;
import com.oilfoot.senshi.items.mortalblade.MortalBladeRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EnderShurikenRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EntitySpawnPacket;
import com.oilfoot.senshi.items.throwables.shuriken.ShurikenRenderer;
import com.oilfoot.senshi.registry.ModBlocks;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import com.oilfoot.senshi.world.feature.SenshiConfiguredFeatures;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class SenshiClient implements ClientModInitializer {

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {

        SenshiConfiguredFeatures.registerConfiguredFeatures();

        //Armor
        GeoArmorRenderer.registerArmorRenderer(new MappleSamuraiArmorRenderer(), ModItems.MAPPLE_KABUTO, ModItems.MAPPLE_DO, ModItems.MAPPLE_HAIDATE, ModItems.MAPPLE_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new TakedaSamuraiArmorRenderer(), ModItems.TAKEDA_KABUTO, ModItems.TAKEDA_DO, ModItems.TAKEDA_HAIDATE, ModItems.TAKEDA_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new ShinobiArmorRenderer(), ModItems.SHINOBI_HOOD, ModItems.SHINOBI_ROBE, ModItems.SHINOBI_HAIDATE, ModItems.SHINOBI_SHOES);
        GeoArmorRenderer.registerArmorRenderer(new TokugawaSamuraiArmorRenderer(), ModItems.TOKUGAWA_KABUTO, ModItems.TOKUGAWA_DO, ModItems.TOKUGAWA_HAIDATE, ModItems.TOKUGAWA_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new FallenSamuraiArmorRenderer(), ModItems.FALLEN_KABUTO, ModItems.FALLEN_DO, ModItems.FALLEN_HAIDATE, ModItems.FALLEN_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new knaArmorRenderer(), ModItems.KUMO_NO_ASHI);

        //Items
        GeoItemRenderer.registerItemRenderer(ModItems.KATANA, new KatanaRenderer());
        GeoItemRenderer.registerItemRenderer(ModItems.MORTAL_BLADE, new MortalBladeRenderer());

        //Blocks

        //Entity
        EntityRendererRegistry.INSTANCE.register(ModEntities.OGRE_RAGE_ENTITY, OgreRageRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.KAPPA_ENTITY, KappaRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.KUMOTOKO_ENTITY, KumotokoRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.KUMOCRAWLER_ENTITY, KumoCrawlerRenderer::new);


        EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, ShurikenRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, EnderShurikenRenderer::new);
        receiveEntityPacket();

        //Blocks
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAINS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAKURA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAKURA_SAPLING, RenderLayer.getCutout());

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

        instance.add(ModBlocks.SAKURA_LOG, 5, 5);
        instance.add(ModBlocks.SAKURA_LEAVES, 30, 60);
        instance.add(ModBlocks.SAKURA_SAPLING, 30, 50);
        //planks 5 20

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