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

/* JADX INFO: renamed from: com.boehmod.blockfront.kl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kl.class */
public final class C0607kl extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: hr */
    public static final float f3319hr = 0.5f;

    public C0607kl(@NotNull BlockBehaviour.Properties properties) {
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
