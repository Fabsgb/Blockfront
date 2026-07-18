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

/* JADX INFO: renamed from: com.boehmod.blockfront.kX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kX.class */
public final class C0593kX extends C0617kv implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final DirectionProperty f3287r = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final BooleanProperty f3288s = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final C0641lS f3289m = new C0641lS(1.0f, 1.0f, 15.0f, 15.0f, 15.0f, 16.0f);

    public C0593kX(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3287r, Direction.NORTH)).setValue(f3288s, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3289m.m2835a((Direction) blockState.getValue(f3287r));
    }
}
