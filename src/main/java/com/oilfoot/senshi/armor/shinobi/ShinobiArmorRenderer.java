package com.oilfoot.senshi.armor.shinobi;

import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorItem;
import com.oilfoot.senshi.armor.mapple.MappleSamuraiArmorModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ShinobiArmorRenderer extends GeoArmorRenderer<ShinobiArmorItem> {
    public ShinobiArmorRenderer() {
        super(new ShinobiArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}