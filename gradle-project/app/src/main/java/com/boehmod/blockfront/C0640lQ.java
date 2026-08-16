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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lQ.class */
public class C0640lQ extends C0588kR implements InterfaceC0650la {

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final VoxelShape f3631r = Block.box(5.0d, 3.0d, 5.0d, 11.0d, 16.0d, 11.0d);

    public C0640lQ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    /* JADX INFO: renamed from: a */
    private static void m2908a(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        level.playLocalSound(blockPos, (SoundEvent) C1312xz.f8177tq.get(), SoundSource.BLOCKS, 0.3f, 0.98f + (randomSource.nextFloat() * 0.02f), false);
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return f3631r;
    }

    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);
        if (randomSource.nextInt(40) == 0) {
            m2908a(level, blockPos, randomSource);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        m2908a(clientLevel, blockPos, clientLevel.getRandom());
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
