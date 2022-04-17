package com.oilfoot.senshi.armor.mapple;


import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MappleSamuraiArmorRenderer extends GeoArmorRenderer<MappleSamuraiArmorItem> {
    public MappleSamuraiArmorRenderer() {
        super(new MappleSamuraiArmorModel());
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