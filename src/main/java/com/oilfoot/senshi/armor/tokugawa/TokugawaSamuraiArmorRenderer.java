package com.oilfoot.senshi.armor.tokugawa;


import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TokugawaSamuraiArmorRenderer extends GeoArmorRenderer<TokugawaSamuraiArmorItem> {
    public TokugawaSamuraiArmorRenderer() {
        super(new TokugawaSamuraiArmorModel());
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