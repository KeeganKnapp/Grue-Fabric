package me.suplexgod.grue.entity.customgoals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;

public class MoveTowardEntityGoal extends MeleeAttackGoal {
    private final int lightLevel;
    private boolean pauseWhenMobIdle;
    private long lastUpdateTime;
    private Path path;

    public MoveTowardEntityGoal(PathAwareEntity mob, int lightLevel, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.lightLevel = lightLevel;
    }

    @Override
    public boolean canStart() {
        long l = this.mob.world.getTime();
        if (l - this.lastUpdateTime < 5L) {
            return false;
        } else {
            this.lastUpdateTime = l;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else {
                this.path = this.mob.getNavigation().findPathTo(livingEntity, 0);
                if (this.path != null) {
                    return isPathDark();
                }
                return false;
            }
        }
    }

    @Override
    public boolean shouldContinue() {
        LivingEntity livingEntity = this.mob.getTarget();
        if (livingEntity == null) {
            return false;
      //  } else if (!livingEntity.isAlive()) {
      //      return false;
        } else if (!this.pauseWhenMobIdle) {
            return !this.mob.getNavigation().isIdle();
        } else if (!this.mob.isInWalkTargetRange(livingEntity.getBlockPos())) {
            return false;
        } else {
            //  if is a player OR is not spectator and is not creative
            if(!livingEntity.isSpectator() && !((PlayerEntity)livingEntity).isCreative())
            {
                return isPathDark();
            }
            return false;
        }
}

    public boolean isPathDark()
    {
        for(int c = path.getCurrentNodeIndex(); c < path.getLength(); c++)
        {
            if(this.mob.getWorld().getLightLevel(path.getNode(c).getBlockPos()) > lightLevel)
            {
                return false;
            }
        }
        return true;
    }

}

