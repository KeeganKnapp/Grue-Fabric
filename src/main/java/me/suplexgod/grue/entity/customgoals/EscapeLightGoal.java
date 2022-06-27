package me.suplexgod.grue.entity.customgoals;


import net.minecraft.entity.ai.goal.EscapeSunlightGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Random;

public class EscapeLightGoal extends Goal {
    private final PathAwareEntity mob;
    private final int lightLevel;
    private final World world;
    private final double speed;
    private double targetX;
    private double targetY;
    private double targetZ;

    public EscapeLightGoal(PathAwareEntity mob, int lightLevel, double speed) {
        this.speed = speed;
        this.mob = mob;
        this.world = mob.world;
        this.lightLevel = lightLevel;

    }

    @Override
    public boolean canStart()
    {
        return mob.getWorld().getLightLevel(LightType.BLOCK, mob.getBlockPos()) > lightLevel;
    }

    public void start() {
        this.mob.getNavigation().startMovingTo(this.targetX, this.targetY, this.targetZ, this.speed);
    }

    public boolean shouldContinue() {
        return !this.mob.getNavigation().isIdle();
    }

    protected boolean targetDarkPos() {
        Vec3d vec3d = this.locateDarkPos();
        if (vec3d == null) {
            return false;
        } else {
            this.targetX = vec3d.x;
            this.targetY = vec3d.y;
            this.targetZ = vec3d.z;
            return true;
        }
    }

    @Nullable
    protected Vec3d locateDarkPos() {
        Random random = this.mob.getRandom();
        BlockPos blockPos = this.mob.getBlockPos();

        for(int i = 0; i < 10; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(20) - 10, random.nextInt(10) - 5, random.nextInt(20) - 10);
            if ((this.world.getLightLevel(blockPos2) <= this.mob.getWorld().getLightLevel(this.mob.getBlockPos())) && this.mob.getPathfindingFavor(blockPos2) < 0.0F) {
                return Vec3d.ofBottomCenter(blockPos2);
            }
        }

        return null;
    }
}
