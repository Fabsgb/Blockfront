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

/* JADX INFO: renamed from: com.boehmod.blockfront.lw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lw.class */
public final class C0672lw extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: s */
    @NotNull
    private static final DirectionProperty f3709s = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: x */
    @NotNull
    private static final BooleanProperty f3710x = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final C0717mo f3711n = new C0717mo(6.0f, 4.0f, 15.0f, 10.0f, 12.0f, 16.0f);

    public C0672lw(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3709s, Direction.NORTH)).setValue(f3710x, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3711n.m3266a((Direction) blockState.getValue(f3709s));
    }
}
