package com.oilfoot.senshi;

import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorItem;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorRenderer;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorItem;
import com.oilfoot.senshi.armor.tokugawa.TokugawaSamuraiArmorRenderer;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EntitySpawnPacket;
import com.oilfoot.senshi.items.throwables.shuriken.enderShurikenRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.shurikenEntity;
import com.oilfoot.senshi.items.throwables.shuriken.shurikenRenderer;
import com.oilfoot.senshi.registry.ModBlocks;
import com.oilfoot.senshi.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class SenshiClient implements ClientModInitializer {

    public static final Identifier PacketID = new Identifier(Senshi.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {
        //Samurai Armor
        GeoArmorRenderer.registerArmorRenderer(MappleSamuraiArmorItem.class, new MappleSamuraiArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(TakedaSamuraiArmorItem.class, new TakedaSamuraiArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(ShinobiArmorItem.class, new ShinobiArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(TokugawaSamuraiArmorItem.class, new TokugawaSamuraiArmorRenderer());

        //Entity
        EntityRendererRegistry.INSTANCE.register(ModEntities.OGRE_RAGE_ENTITY,
                (entityRenderDispatcher, context) -> new OgreRageRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, (entityRenderDispatcher, factory) ->
                new shurikenRenderer(entityRenderDispatcher));
        receiveEntityPacket();

        EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, (entityRenderDispatcher, factory) ->
                new shurikenRenderer(entityRenderDispatcher) {});

        EntityRendererRegistry.INSTANCE.register(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, (entityRenderDispatcher, factory) ->
                new enderShurikenRenderer(entityRenderDispatcher));
        receiveEntityPacket();

        EntityRendererRegistry.INSTANCE.register(ModEntities.ENDER_SHURIKEN_ENTITY_ENTITY_TYPE, (entityRenderDispatcher, factory) ->
                new enderShurikenRenderer(entityRenderDispatcher) {});

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
                e.pitch = pitch;
                e.yaw = yaw;
                e.setEntityId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }

}