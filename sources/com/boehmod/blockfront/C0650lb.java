package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lb.class */
public class C0650lb extends C0618kw {
    public C0650lb(@NotNull BlockBehaviour.Properties properties) {
        super(properties, C1216wJ.f6371bK);
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);
        if (randomSource.nextInt(24) == 0) {
            level.playLocalSound(blockPos, (SoundEvent) C1280xc.f7765to.get(), SoundSource.BLOCKS, 0.5f, 0.8f + (0.2f * randomSource.nextFloat()), false);
        }
    }
}
