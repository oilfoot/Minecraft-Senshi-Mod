package com.oilfoot.senshi.items.throwables.shuriken;

import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.registry.SenshiItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

public class EnderShurikenRenderer extends ShurikenProjectileRenderer<EnderShurikenEntity> {

    public static final ItemStack STACK = new ItemStack(SenshiItems.ENDER_SHURIKEN);

    public EnderShurikenRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(EnderShurikenEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        if (!entity.isStopped)
        {
            matrices.multiply(Vec3f.POSITIVE_Y.getRadialQuaternion(entity.age));
        }

        MinecraftClient.getInstance().getItemRenderer().renderItem(
                STACK,
                ModelTransformation.Mode.FIXED,
                light,
                OverlayTexture.DEFAULT_UV,
                matrices,
                vertexConsumers, 0
        );
        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(EnderShurikenEntity entity) {
        return new Identifier(Senshi.MOD_ID, "textures/items/ender_shuriken.png");
    }
}
