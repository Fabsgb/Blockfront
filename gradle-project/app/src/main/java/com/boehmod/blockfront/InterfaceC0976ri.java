package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ri */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ri.class */
public interface InterfaceC0976ri {
    /* JADX INFO: renamed from: e */
    void mo5332e(@NotNull ServerLevel serverLevel);

    /* JADX INFO: renamed from: a */
    void mo5333a(@NotNull C0756na c0756na, @NotNull Level level);

    /* JADX INFO: renamed from: a */
    void mo5334a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull C0756na c0756na, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: a */
    void mo5335a(@NotNull C0756na c0756na, @NotNull Player player);

    /* JADX INFO: renamed from: a */
    void mo5336a(@NotNull C0756na c0756na);

    @Nullable
    /* JADX INFO: renamed from: a */
    BlockPos mo5337a(@NotNull C0756na c0756na);

    /* JADX INFO: renamed from: a */
    boolean mo5338a(@NotNull C0756na c0756na, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: b */
    int mo5339b(@NotNull C0872pk c0872pk);
}
