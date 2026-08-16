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

/* JADX INFO: renamed from: com.boehmod.blockfront.lM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lM.class */
public final class C0636lM extends C0588kR implements InterfaceC0650la, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: C */
    @NotNull
    private static final DirectionProperty f3621C = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: A */
    @NotNull
    private static final BooleanProperty f3622A = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: u */
    @NotNull
    private static final C0717mo f3623u = new C0717mo(4.0f, 1.0f, 12.0f, 12.0f, 14.0f, 16.0f);

    public C0636lM(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3621C, Direction.NORTH)).setValue(f3622A, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3623u.m3266a((Direction) blockState.getValue(f3621C));
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
