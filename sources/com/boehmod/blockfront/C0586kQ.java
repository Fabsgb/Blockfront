package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kQ.class */
public final class C0586kQ extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final DirectionProperty f3273o = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final BooleanProperty f3274q = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0641lS f3275h;

    public C0586kQ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3275h = new C0641lS(5.0f, 5.0f, 12.0f, 11.0f, 11.0f, 16.0f);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3273o, Direction.NORTH)).setValue(f3274q, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.f3275h.m2835a((Direction) blockState.getValue(f3273o));
    }
}
