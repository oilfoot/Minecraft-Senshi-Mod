package com.oilfoot.senshi.armor.takeda;

import com.oilfoot.senshi.senshi;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TakedaSamuraiArmorModel extends AnimatedGeoModel<TakedaSamuraiArmorItem> {
    @Override
    public Identifier getModelLocation(TakedaSamuraiArmorItem object) {
        return new Identifier(senshi.MOD_ID, "geo/takeda_samurai_armor_model.geo.json");
    }

    @Override
    public Identifier getTextureLocation(TakedaSamuraiArmorItem object) {
        return new Identifier(senshi.MOD_ID, "textures/models/armor/takeda_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(TakedaSamuraiArmorItem animatable) {
        return new Identifier(senshi.MOD_ID, "animations/takeda_samurai_armor.animation.json");
    }
}