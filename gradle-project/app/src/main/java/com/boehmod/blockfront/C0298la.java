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

/* JADX INFO: renamed from: com.boehmod.blockfront.la, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/la.class */
public final class C0298la extends C0292kv implements SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty s = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty x = BlockStateProperties.WATERLOGGED;

    @NotNull
    private static final lS n = new lS(6.0f, 4.0f, 15.0f, 10.0f, 12.0f, 16.0f);

    public C0298la(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(s, Direction.NORTH)).setValue(x, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return n.a((Direction) blockState.getValue(s));
    }
}
