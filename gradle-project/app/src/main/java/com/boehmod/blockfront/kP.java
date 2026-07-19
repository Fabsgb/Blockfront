package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kP.class */
public final class kP extends C0292kv implements kE, SimpleWaterloggedBlock {

    @NotNull
    private static final DirectionProperty n = BlockStateProperties.HORIZONTAL_FACING;

    @NotNull
    private static final BooleanProperty p = BlockStateProperties.WATERLOGGED;

    @NotNull
    private final lS g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @Nullable
    private final DeferredHolder<SoundEvent, SoundEvent> f196g;

    public kP(float f, float f2, float f3, float f4, float f5, float f6, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.g = new lS(f, f2, f3, f4, f5, f6);
        this.f196g = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(n, Direction.NORTH)).setValue(p, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.g.a((Direction) blockState.getValue(n));
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level.isClientSide) {
            Vec3 center = blockPos.getCenter();
            if (randomSource.nextInt(3) == 0) {
                level.playLocalSound(center.x, center.y, center.z, (SoundEvent) C0624xc.sS.get(), SoundSource.BLOCKS, 0.1f, 1.0f, false);
            }
            if (this.f196g != null) {
                if (randomSource.nextInt(64) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, (SoundEvent) C0624xc.sT.get(), SoundSource.BLOCKS, 0.1f, 1.0f, false);
                }
                if (randomSource.nextInt(64) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, (SoundEvent) this.f196g.get(), SoundSource.BLOCKS, 0.25f, 0.9f + (randomSource.nextFloat() * 0.2f), false);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        kM.a(minecraft, c0297l, clientLevel, blockPos, clientLevel.random, 2, 8);
    }

    @Override // com.boehmod.blockfront.kE
    public boolean ak() {
        return true;
    }
}
