package com.oilfoot.senshi.armor.shinobi;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ShinobiArmorItem extends ArmorItem implements IAnimatable {

        private final AnimationFactory factory = new AnimationFactory(this);

        public ShinobiArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Settings builder) {
            super(materialIn, slot, builder);
        }

        private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
            return PlayState.STOP;
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
        }

        @Override
        public AnimationFactory getFactory() {
            return this.factory;
        }
}



