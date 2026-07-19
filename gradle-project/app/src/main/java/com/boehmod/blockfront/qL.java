package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qL.class */
public interface qL {
    void e(@NotNull ServerLevel serverLevel);

    void a(@NotNull mE mEVar, @NotNull Level level);

    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull mE mEVar, @NotNull DamageSource damageSource);

    void a(@NotNull mE mEVar, @NotNull Player player);

    void a(@NotNull mE mEVar);

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    BlockPos mo920a(@NotNull mE mEVar);

    boolean a(@NotNull mE mEVar, @NotNull DamageSource damageSource);

    int b(@NotNull oO oOVar);
}
