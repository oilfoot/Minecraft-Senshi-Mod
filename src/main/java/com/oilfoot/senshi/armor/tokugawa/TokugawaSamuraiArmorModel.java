package com.oilfoot.senshi.armor.tokugawa;

import com.oilfoot.senshi.Senshi;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TokugawaSamuraiArmorModel extends AnimatedGeoModel<TokugawaSamuraiArmorItem> {
    @Override
    public Identifier getModelLocation(TokugawaSamuraiArmorItem object) {
        return new Identifier(Senshi.MOD_ID, "geo/tokugawa_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(TokugawaSamuraiArmorItem object) {
        return new Identifier(Senshi.MOD_ID, "textures/models/armor/tokugawa_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(TokugawaSamuraiArmorItem animatable) {
        return new Identifier(Senshi.MOD_ID, "animations/tokugawa_armor.animation.json");
    }
}