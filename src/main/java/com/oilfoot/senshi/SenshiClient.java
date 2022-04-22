package com.oilfoot.senshi;

import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorRenderer;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorRenderer;
import com.oilfoot.senshi.entities.kappa.KappaRenderer;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EnderShurikenRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EntitySpawnPacket;
import com.oilfoot.senshi.items.throwables.shuriken.ShurikenRenderer;
import com.oilfoot.senshi.registry.ModBlocks;
import com.oilfoot.senshi.registry.ModEntities;
import com.oilfoot.senshi.registry.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class SenshiClient implements ClientModInitializer {

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {
        //Samurai Armor

        GeoArmorRenderer.registerArmorRenderer(new MappleSamuraiArmorRenderer(), ModItems.MAPPLE_KABUTO, ModItems.MAPPLE_DO, ModItems.MAPPLE_HAIDATE, ModItems.MAPPLE_WARAJI);

        GeoArmorRenderer.registerArmorRenderer(new TakedaSamuraiArmorRenderer(), ModItems.TAKEDA_KABUTO, ModItems.TAKEDA_DO, ModItems.TAKEDA_HAIDATE, ModItems.TAKEDA_WARAJI);
        GeoArmorRenderer.registerArmorRenderer(new ShinobiArmorRenderer(), ModItems.SHINOBI_HOOD, ModItems.SHINOBI_ROBE, ModItems.SHINOBI_HAIDATE, ModItems.SHINOBI_SHOES);
        GeoArmorRenderer.registerArmorRenderer(new TokugawaSamuraiArmorRenderer(), ModItems.TOKUGAWA_KABUTO, ModItems.TOKUGAWA_DO, ModItems.TOKUGAWA_HAIDATE, ModItems.TOKUGAWA_WARAJI);

        //Entity
        EntityRendererRegistry.INSTANCE.register(ModEntities.OGRE_RAGE_ENTITY, OgreRageRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.KAPPA_ENTITY, KappaRenderer::new);


        EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, ShurikenRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, EnderShurikenRenderer::new);
        receiveEntityPacket();

        //Blocks
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAINS, RenderLayer.getCutout());

        //Sounds
        Registry.register(Registry.SOUND_EVENT, Senshi.SHURIKEN_THROW, Senshi.SHURIKEN_THROW_EVENT);
        Registry.register(Registry.SOUND_EVENT, Senshi.SHURIKEN_LAND, Senshi.SHURIKEN_LAND_EVENT);

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