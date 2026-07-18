package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.CheckForNull;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.re */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/re.class */
public interface InterfaceC0971re {
    @CheckForNull
    /* JADX INFO: renamed from: a */
    Component mo5161a(@NotNull ServerPlayer serverPlayer);

    /* JADX INFO: renamed from: b */
    void mo5162b(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: bx */
    int mo5163bx();
}
