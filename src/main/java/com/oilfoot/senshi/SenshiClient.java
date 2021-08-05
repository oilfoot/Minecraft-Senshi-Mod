package com.oilfoot.senshi;

import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorRenderer;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorItem;
import com.oilfoot.senshi.armor.shinobi.ShinobiArmorRenderer;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorRenderer;
import com.oilfoot.senshi.entities.ogre_of_rage.OgreRageRenderer;
import com.oilfoot.senshi.items.throwables.shuriken.EntitySpawnPacket;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
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

        //Entity
        EntityRendererRegistry.INSTANCE.register(ModEntities.OGRE_RAGE_ENTITY,
                (entityRenderDispatcher, context) -> new OgreRageRenderer(entityRenderDispatcher));

        EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, (entityType, factory) ->
                new shurikenRenderer(entityType, factory));
        receiveEntityPacket();

        EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY_ENTITY_TYPE, (entityType, factory) ->
                new shurikenRenderer(entityType, factory));

       //  EntityRendererRegistry.INSTANCE.register(ModEntities.SHURIKEN_ENTITY,
        //    (entityRenderDispatcher, context) -> new shurikenRenderer(entityRenderDispatcher));

        //Blocks
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAINS, RenderLayer.getCutout());

       /*//Packets
        ClientSidePacketRegistryImpl.INSTANCE.register(shurikenEntity.SPAWN_PACKET, ((context, packet) -> {

            double x = packet.readDouble();
            double y = packet.readDouble();
            double z = packet.readDouble();

          int entityID = packet.readInt();
          UUID entityUUID = packet.readUuid();

          context.getTaskQueue().execute(() -> {
                shurikenEntity shuriken = new shurikenEntity(MinecraftClient.getInstance().world, x, y, z, entityID, entityUUID);
                MinecraftClient.getInstance().world.addEntity(entityID, shuriken);

          });
        }));*/

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