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

/* JADX INFO: renamed from: com.boehmod.blockfront.ll */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ll.class */
public final class C0661ll extends C0588kR implements InterfaceC0650la, SimpleWaterloggedBlock {

    /* JADX INFO: renamed from: n */
    @NotNull
    private static final DirectionProperty f3681n = BlockStateProperties.HORIZONTAL_FACING;

    /* JADX INFO: renamed from: p */
    @NotNull
    private static final BooleanProperty f3682p = BlockStateProperties.WATERLOGGED;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0717mo f3683g;

    /* JADX INFO: renamed from: g */
    @Nullable
    private final DeferredHolder<SoundEvent, SoundEvent> f3684g;

    public C0661ll(float f, float f2, float f3, float f4, float f5, float f6, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder, @NotNull BlockBehaviour.Properties properties) {
        super(properties);
        this.f3683g = new C0717mo(f, f2, f3, f4, f5, f6);
        this.f3684g = deferredHolder;
        registerDefaultState((BlockState) ((BlockState) getStateDefinition().any().setValue(f3681n, Direction.NORTH)).setValue(f3682p, Boolean.FALSE));
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return this.f3683g.m3266a((Direction) blockState.getValue(f3681n));
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (level.isClientSide) {
            Vec3 center = blockPos.getCenter();
            if (randomSource.nextInt(3) == 0) {
                level.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1312xz.f8154sT.get(), SoundSource.BLOCKS, 0.1f, 1.0f, false);
            }
            if (this.f3684g != null) {
                if (randomSource.nextInt(64) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, (SoundEvent) C1312xz.f8155sU.get(), SoundSource.BLOCKS, 0.1f, 1.0f, false);
                }
                if (randomSource.nextInt(64) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, (SoundEvent) this.f3684g.get(), SoundSource.BLOCKS, 0.25f, 0.9f + (randomSource.nextFloat() * 0.2f), false);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        C0658li.m2934a(minecraft, c0623l, clientLevel, blockPos, clientLevel.random, 2, 8);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return true;
    }
}
