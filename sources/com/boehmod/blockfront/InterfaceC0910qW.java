package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qW.class */
public interface InterfaceC0910qW {
    /* JADX INFO: renamed from: a */
    void mo4689a(@NotNull C0692mQ c0692mQ, @NotNull Level level);

    /* JADX INFO: renamed from: a */
    void mo4690a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull C0692mQ c0692mQ, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: a */
    void mo4691a(@NotNull C0692mQ c0692mQ, @NotNull Player player);

    /* JADX INFO: renamed from: a */
    void mo4692a(@NotNull ServerLevel serverLevel, @NotNull C0692mQ c0692mQ);

    /* JADX INFO: renamed from: a */
    boolean mo4693a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C0692mQ c0692mQ, @NotNull DamageSource damageSource, float f);

    /* JADX INFO: renamed from: bt */
    int mo4694bt();
}
