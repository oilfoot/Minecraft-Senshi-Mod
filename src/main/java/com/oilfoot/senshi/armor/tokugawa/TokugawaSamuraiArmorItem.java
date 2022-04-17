package com.oilfoot.senshi.armor.tokugawa;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
public class TokugawaSamuraiArmorItem extends ArmorItem implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);



    public TokugawaSamuraiArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Item.Settings builder) {
        super(materialIn, slot, builder);
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0); //<--- Get some livingentity(player) data
        if (livingEntity instanceof PlayerEntity) { // <-- if the living entity is a player
            PlayerEntity player = (PlayerEntity) livingEntity; // <-- Actually making the living enitity a player
            if (!(player.lastLimbDistance > -0.15F && player.lastLimbDistance < 0.15F)) { //<--- Check if the players limbs are moving


                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tokugawa_armor.run", true)); //<-- get the animation, true to loop
                return PlayState.CONTINUE;  //<-- play the animation continously
            }


        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tokugawa_armor.idle", true)); //<-- if the players libs are not moving, use the idle animation (which doesn't do anything)
        return PlayState.CONTINUE; //<-- play the idle animation contrinously
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