package me.suplexgod.grue.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.pathing.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AvoidBlockLightNavigation extends MobNavigation {
    public AvoidBlockLightNavigation(MobEntity mobEntity, World world) {
        super(mobEntity, world);
    }


    protected PathNodeNavigator createPathNodeNavigator(int range) {
        this.nodeMaker = new LandPathNodeMaker();
        this.nodeMaker.setCanEnterOpenDoors(true);
        return new PathNodeNavigator(this.nodeMaker, range);
    }


    protected Vec3d getPos() {
        Vec3d p = new Vec3d(1,1,1);
        return p;
    }


    protected boolean isAtValidPosition() {
        return this.entity.isOnGround() || this.isInLiquid() || this.entity.hasVehicle();
    }

    protected void adjustPathLL(int currentLightLevel) {
        super.adjustPath();
            for(int i = 0; i < this.currentPath.getLength(); ++i) {
                PathNode pathNode = this.currentPath.getNode(i);
                if (this.world.getLightLevel(new BlockPos(pathNode.x, pathNode.y, pathNode.z)) < currentLightLevel) {
                    this.currentPath.setLength(i);
                    return;
                }
            }
        }

    }

