package com.oilfoot.senshi.entities.ogre_of_rage;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class OgreRageRenderer extends GeoEntityRenderer<OgreRageEntity> {
    public OgreRageRenderer(EntityRenderDispatcher renderDispatcher) {
        super(renderDispatcher, new OgreRageEntityModel());
    }

    @Override
    public RenderLayer getRenderType(OgreRageEntity animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }

}