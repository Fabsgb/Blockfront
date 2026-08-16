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

/* JADX INFO: renamed from: com.boehmod.blockfront.lm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lm.class */
public final class C0662lm extends C0588kR implements SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: o */
    @NotNull
    private static final DirectionProperty f3685o = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: q */
    @NotNull
    private static final BooleanProperty f3686q = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0717mo f3687h;

    public C0662lm(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3687h = new C0717mo(5.0f, 5.0f, 12.0f, 11.0f, 11.0f, 16.0f);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3685o, Direction.NORTH)).setValue(f3686q, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.f3687h.m3266a((Direction) blockState.getValue(f3685o));
    }
}
