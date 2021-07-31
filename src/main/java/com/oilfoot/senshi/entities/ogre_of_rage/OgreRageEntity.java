package com.oilfoot.senshi.entities.ogre_of_rage;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class OgreRageEntity extends PathAwareEntity implements IAnimatable {
    AnimationFactory factory = new AnimationFactory(this);



    public OgreRageEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);

    }
        private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {//This is where we choose what animations to play in the animation.json and during what conditions. for example one animation for walking and one for punching
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ogre_rage.idle", true));
            return PlayState.CONTINUE;
        }

        @Override
        public void registerControllers(AnimationData data) {//This method register the animation controller
            data.addAnimationController(new AnimationController<OgreRageEntity>(this, "controller", 0, this::predicate));
        }

        @Override
        public AnimationFactory getFactory() {
            return this.factory;
        }

        @Override
        protected void initGoals() {//This is the AI, the 6 is which priority the specific goal has, SwimGoal is usually at priority 1 to make the enities always try to swim. LookAtEntityGoal is at a lower priority because it shouldnt always look at the entity
            this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
            super.initGoals();
        }

    public static DefaultAttributeContainer.Builder createAttrubites() {
        return MobEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.24D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 52.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0D);
    }

    }