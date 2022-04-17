package com.oilfoot.senshi.items.throwables.shuriken;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.PersistentProjectileEntity;


@Environment(EnvType.CLIENT)
public abstract class ShurikenProjectileRenderer<T extends PersistentProjectileEntity> extends EntityRenderer<T> {
    public ShurikenProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    public void render(T persistentProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

    }
}
