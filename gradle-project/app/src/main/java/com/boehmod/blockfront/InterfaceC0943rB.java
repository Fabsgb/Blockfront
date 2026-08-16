package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.CheckForNull;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rB.class */
public interface InterfaceC0943rB {
    @CheckForNull
    /* JADX INFO: renamed from: a */
    Component mo5178a(@NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: b */
    void mo5179b(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: bM */
    int mo5180bM();
}
