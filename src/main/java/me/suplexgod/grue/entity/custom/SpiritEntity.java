package me.suplexgod.grue.entity.custom;

import me.suplexgod.grue.entity.customgoals.EscapeLightGoal;
import me.suplexgod.grue.entity.customgoals.MoveTowardEntityGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static me.suplexgod.grue.sound.SpiritSounds.SPIRIT_AMBIENT;

public class SpiritEntity extends HostileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public SpiritEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        return PlayState.CONTINUE;
    }

    protected void initGoals() {
        int lightLevel = 0;

        this.goalSelector.add(2, new SwimGoal(this));

        this.goalSelector.add(1, new EscapeLightGoal(this, lightLevel, 3));
        //this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, false));


        //this.goalSelector.add(1, new FleeEntityGoal(this, PlayerEntity.class, 10.0f, 0.2, 0.4));

        this.goalSelector.add(2, new MoveTowardEntityGoal(this, lightLevel, 1.0, false));

    }


    public static DefaultAttributeContainer.Builder setAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0d);
    }

    @Override
    public SoundEvent getAmbientSound() {return SPIRIT_AMBIENT;}



    @Override
    public void registerControllers(AnimationData animationData) {

    }
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
