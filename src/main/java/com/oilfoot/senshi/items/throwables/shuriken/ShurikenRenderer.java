package com.oilfoot.senshi.items.throwables.shuriken;

import com.oilfoot.senshi.Senshi;
import com.oilfoot.senshi.registry.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

public class ShurikenRenderer extends ShurikenProjectileRenderer<ShurikenEntity> {

    public static final ItemStack STACK = new ItemStack(ModItems.SHURIKEN);

    public ShurikenRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(ShurikenEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
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
    public Identifier getTexture(ShurikenEntity entity) {
        return new Identifier(Senshi.MOD_ID, "textures/items/shuriken.png");
    }
}