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

/* JADX INFO: renamed from: com.boehmod.blockfront.kP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kP.class */
public final class C0585kP extends C0617kv implements InterfaceC0574kE, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final DirectionProperty f3269n = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final BooleanProperty f3270p = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0641lS f3271g;

    /* JADX INFO: renamed from: g */
    @Nullable
    private final DeferredHolder<SoundEvent, SoundEvent> f3272g;

    public C0585kP(float f, float f2, float f3, float f4, float f5, float f6, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3271g = new C0641lS(f, f2, f3, f4, f5, f6);
        this.f3272g = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3269n, Direction.NORTH)).setValue(f3270p, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.f3271g.m2835a((Direction) blockState.getValue(f3269n));
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level.isClientSide) {
            Vec3 center = blockPos.getCenter();
            if (randomSource.nextInt(3) == 0) {
                level.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1280xc.f7743sS.get(), SoundSource.BLOCKS, 0.1f, 1.0f, false);
            }
            if (this.f3272g != null) {
                if (randomSource.nextInt(64) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1280xc.f7744sT.get(), SoundSource.BLOCKS, 0.1f, 1.0f, false);
                }
                if (randomSource.nextInt(64) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, (SoundEvent) this.f3272g.get(), SoundSource.BLOCKS, 0.25f, 0.9f + (randomSource.nextFloat() * 0.2f), false);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        C0582kM.m2606a(minecraft, c0622l, clientLevel, blockPos, clientLevel.random, 2, 8);
    }

    @Override // com.boehmod.blockfront.InterfaceC0574kE
    /* JADX INFO: renamed from: ak */
    public boolean mo2602ak() {
        return true;
    }
}
