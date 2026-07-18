package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qL.class */
public interface InterfaceC0899qL {
    /* JADX INFO: renamed from: e */
    void mo4656e(@NotNull ServerLevel serverLevel);

    /* JADX INFO: renamed from: a */
    void mo4657a(@NotNull C0680mE c0680mE, @NotNull Level level);

    /* JADX INFO: renamed from: a */
    void mo4658a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull C0680mE c0680mE, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: a */
    void mo4659a(@NotNull C0680mE c0680mE, @NotNull Player player);

    /* JADX INFO: renamed from: a */
    void mo4660a(@NotNull C0680mE c0680mE);

    @Nullable
    /* JADX INFO: renamed from: a */
    BlockPos mo4661a(@NotNull C0680mE c0680mE);

    /* JADX INFO: renamed from: a */
    boolean mo4662a(@NotNull C0680mE c0680mE, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: b */
    int mo4663b(@NotNull C0796oO c0796oO);
}
