package com.oilfoot.senshi.armor.shinobi;

import com.oilfoot.senshi.Senshi;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShinobiArmorModel extends AnimatedGeoModel<ShinobiArmorItem> {
    @Override
    public Identifier getModelLocation(ShinobiArmorItem object) {
        return new Identifier(Senshi.MOD_ID, "geo/shinobi_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ShinobiArmorItem object) {
        return new Identifier(Senshi.MOD_ID, "textures/models/armor/shinobi_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ShinobiArmorItem animatable) {
        return new Identifier(Senshi.MOD_ID, "animations/animation.shinobi_armor.json");
    }
}