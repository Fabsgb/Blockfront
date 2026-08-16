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

/* JADX INFO: renamed from: com.boehmod.blockfront.lt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lt.class */
public final class C0669lt extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final DirectionProperty f3699r = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final BooleanProperty f3700s = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: m */
    @NotNull
    private static final C0717mo f3701m = new C0717mo(1.0f, 1.0f, 15.0f, 15.0f, 15.0f, 16.0f);

    public C0669lt(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3699r, Direction.NORTH)).setValue(f3700s, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3701m.m3266a((Direction) blockState.getValue(f3699r));
    }
}
