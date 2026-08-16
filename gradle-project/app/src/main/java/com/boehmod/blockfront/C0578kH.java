package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kH.class */
public final class C0578kH extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: ij */
    public static final float f3351ij = 0.5f;

    public C0578kH(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public void entityInside(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Entity entity) {
        entity.makeStuckInBlock(blockState, new Vec3(0.45d, 0.65d, 0.45d));
        if (entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().cactus(), 0.5f);
        }
    }
}
