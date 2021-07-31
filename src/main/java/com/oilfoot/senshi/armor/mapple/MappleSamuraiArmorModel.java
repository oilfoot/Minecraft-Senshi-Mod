package com.oilfoot.senshi.armor.mapple;

import com.oilfoot.senshi.senshi;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MappleSamuraiArmorModel extends AnimatedGeoModel<MappleSamuraiArmorItem> {
    @Override
    public Identifier getModelLocation(MappleSamuraiArmorItem object) {
        return new Identifier(senshi.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MappleSamuraiArmorItem object) {
        return new Identifier(senshi.MOD_ID, "textures/models/armor/samurai_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(MappleSamuraiArmorItem animatable) {
        return new Identifier(senshi.MOD_ID, "animations/animation.samurai_armor.json");
    }
}