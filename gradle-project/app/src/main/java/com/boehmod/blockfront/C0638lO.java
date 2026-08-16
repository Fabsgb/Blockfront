package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lO.class */
public final class C0638lO extends C0588kR implements InterfaceC0650la, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: E */
    @NotNull
    private static final DirectionProperty f3626E = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: B */
    @NotNull
    private static final BooleanProperty f3627B = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: w */
    @NotNull
    private static final C0717mo f3628w = new C0717mo(4.0f, 2.0f, 13.0f, 12.0f, 11.0f, 16.0f);

    public C0638lO(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3626E, Direction.NORTH)).setValue(f3627B, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3628w.m3266a((Direction) blockState.getValue(f3626E));
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        clientLevel.playLocalSound(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f, (SoundEvent) C1312xz.f8178tr.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.1f * clientLevel.random.nextInt(4)), false);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return true;
    }
}
