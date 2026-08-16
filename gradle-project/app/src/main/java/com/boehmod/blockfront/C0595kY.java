package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kY.class */
public final class C0595kY extends C0588kR implements InterfaceC0650la {
    public C0595kY(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected boolean isPathfindable(@NotNull BlockState blockState, @NotNull PathComputationType pathComputationType) {
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        clientLevel.playLocalSound(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f, (SoundEvent) C1312xz.f8159sY.get(), SoundSource.BLOCKS, 2.0f, 0.8f + (0.1f * clientLevel.random.nextInt(4)), false);
    }

    @Override // com.boehmod.blockfront.InterfaceC0650la
    /* JADX INFO: renamed from: au */
    public boolean mo2616au() {
        return false;
    }
}
