package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tM.class */
public class tM {
    @NotNull
    public static HitResult a(@NotNull Entity entity, double d, float f) {
        Vec3 lookAngle = entity.getLookAngle();
        Vec3 eyePosition = entity.getEyePosition(f);
        return a(entity.level(), new ClipContext(eyePosition, eyePosition.add(lookAngle.x * d, lookAngle.y * d, lookAngle.z * d), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity));
    }

    @NotNull
    public static BlockHitResult a(Level level, ClipContext clipContext) {
        return (BlockHitResult) BlockGetter.traverseBlocks(clipContext.getFrom(), clipContext.getTo(), clipContext, (clipContext2, blockPos) -> {
            BlockState blockState = level.getBlockState(blockPos);
            InterfaceC0320lw block = blockState.getBlock();
            if ((block instanceof InterfaceC0320lw) && !block.b(blockState)) {
                return null;
            }
            FluidState fluidState = level.getFluidState(blockPos);
            Vec3 from = clipContext.getFrom();
            Vec3 to = clipContext.getTo();
            BlockHitResult blockHitResultClipWithInteractionOverride = level.clipWithInteractionOverride(from, to, blockPos, block instanceof kE ? blockState.getShape(level, blockPos) : clipContext.getBlockShape(blockState, level, blockPos), blockState);
            BlockHitResult blockHitResultClip = clipContext.getFluidShape(fluidState, level, blockPos).clip(from, to, blockPos);
            Vec3 from2 = clipContext.getFrom();
            return (blockHitResultClipWithInteractionOverride == null ? Double.MAX_VALUE : from2.distanceToSqr(blockHitResultClipWithInteractionOverride.getLocation())) <= (blockHitResultClip == null ? Double.MAX_VALUE : from2.distanceToSqr(blockHitResultClip.getLocation())) ? blockHitResultClipWithInteractionOverride : blockHitResultClip;
        }, clipContext3 -> {
            Vec3 vec3Subtract = clipContext3.getFrom().subtract(clipContext3.getTo());
            return BlockHitResult.miss(clipContext3.getTo(), Direction.getNearest(vec3Subtract.x, vec3Subtract.y, vec3Subtract.z), BlockPos.containing(clipContext3.getTo()));
        });
    }
}
