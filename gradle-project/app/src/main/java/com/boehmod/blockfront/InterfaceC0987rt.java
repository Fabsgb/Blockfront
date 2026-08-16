package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rt.class */
public interface InterfaceC0987rt {
    /* JADX INFO: renamed from: a */
    void mo5560a(@NotNull C0768nm c0768nm, @NotNull Level level);

    /* JADX INFO: renamed from: a */
    void mo5561a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull C0768nm c0768nm, @NotNull DamageSource damageSource);

    /* JADX INFO: renamed from: a */
    void mo5562a(@NotNull C0768nm c0768nm, @NotNull Player player);

    /* JADX INFO: renamed from: a */
    void mo5563a(@NotNull ServerLevel serverLevel, @NotNull C0768nm c0768nm);

    /* JADX INFO: renamed from: a */
    boolean mo5564a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C0768nm c0768nm, @NotNull DamageSource damageSource, float f);

    /* JADX INFO: renamed from: bI */
    int mo5565bI();
}
