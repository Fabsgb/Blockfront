package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kU.class */
public class C0590kU extends C0617kv {

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final VoxelShape f3285j = Block.box(1.0d, 0.0d, 1.0d, 15.0d, 16.0d, 15.0d);

    public C0590kU(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3285j;
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);
        if (randomSource.nextInt(48) == 0) {
            level.playLocalSound(blockPos, (SoundEvent) C1280xc.f7764tn.get(), SoundSource.BLOCKS, 1.0f + randomSource.nextFloat(), (randomSource.nextFloat() * 0.7f) + 0.3f, false);
        }
    }
}
