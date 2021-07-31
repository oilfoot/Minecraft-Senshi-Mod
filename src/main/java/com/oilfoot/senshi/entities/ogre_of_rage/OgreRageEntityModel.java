package com.oilfoot.senshi.entities.ogre_of_rage;

import com.oilfoot.senshi.Senshi;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OgreRageEntityModel extends AnimatedGeoModel<OgreRageEntity> {
    @Override
    public Identifier getAnimationFileLocation(OgreRageEntity entity) {
        return new Identifier(Senshi.MOD_ID, "animations/ogre_rage.animation.json");
    }

    @Override
    public Identifier getModelLocation(OgreRageEntity entity) {
        return new Identifier(Senshi.MOD_ID, "geo/ogre_of_rage.geo.json");
    }

    @Override
    public Identifier getTextureLocation(OgreRageEntity entity) {
        return new Identifier(Senshi.MOD_ID, "textures/models/entity/ogre_rage.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(OgreRageEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}