package com.oilfoot.senshi.armor.takeda;

import com.oilfoot.senshi.armor.takeda.TakedaSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TakedaSamuraiArmorRenderer extends GeoArmorRenderer<TakedaSamuraiArmorItem> {
    public TakedaSamuraiArmorRenderer() {
        super(new TakedaSamuraiArmorModel());
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
