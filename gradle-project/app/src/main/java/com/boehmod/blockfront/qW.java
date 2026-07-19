package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qW.class */
public interface qW {
    void a(@NotNull mQ mQVar, @NotNull Level level);

    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull mQ mQVar, @NotNull DamageSource damageSource);

    void a(@NotNull mQ mQVar, @NotNull Player player);

    void a(@NotNull ServerLevel serverLevel, @NotNull mQ mQVar);

    boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull mQ mQVar, @NotNull DamageSource damageSource, float f);

    int bt();
}
