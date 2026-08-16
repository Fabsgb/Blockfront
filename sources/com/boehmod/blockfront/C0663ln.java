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

/* JADX INFO: renamed from: com.boehmod.blockfront.ln */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ln.class */
public final class C0663ln extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final DirectionProperty f3688p = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final BooleanProperty f3689r = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final C0717mo f3690i;

    public C0663ln(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3690i = new C0717mo(1.0f, 3.0f, 15.0f, 15.0f, 14.0f, 16.0f);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3688p, Direction.NORTH)).setValue(f3689r, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.f3690i.m3266a((Direction) blockState.getValue(f3688p));
    }
}
