package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.CheckForNull;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.re, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/re.class */
public interface InterfaceC0464re {
    @CheckForNull
    Component a(@NotNull ServerPlayer serverPlayer);

    void b(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    int bx();
}
