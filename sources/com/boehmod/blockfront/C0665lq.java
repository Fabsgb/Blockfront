package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lq.class */
public final class C0665lq extends C0617kv implements InterfaceC0574kE, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: C */
    @NotNull
    private static final DirectionProperty f3580C = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: A */
    @NotNull
    private static final BooleanProperty f3581A = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static final C0641lS f3582u = new C0641lS(4.0f, 1.0f, 12.0f, 12.0f, 14.0f, 16.0f);

    public C0665lq(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3580C, Direction.NORTH)).setValue(f3581A, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3582u.m2835a((Direction) blockState.getValue(f3580C));
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: a */
    public void mo2601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: ak */
    public boolean mo2602ak() {
        return false;
    }
}
