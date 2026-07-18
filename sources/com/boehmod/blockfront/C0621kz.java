package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kz.class */
public final class C0621kz extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final C0641lS f3353d = new C0641lS(0.0f, 7.0f, 9.0f, 16.0f, 15.0f, 16.0f);

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final DirectionProperty f3354h = BlockStateProperties.HORIZONTAL_FACING;

    public C0621kz(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3353d.m2835a((Direction) blockState.getValue(f3354h));
    }
}
