package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rr.class */
public interface InterfaceC0985rr {
    /* JADX INFO: renamed from: a */
    boolean mo5557a(@NotNull Player player, @NotNull C0886py c0886py);

    /* JADX INFO: renamed from: a */
    void mo5558a(@NotNull ServerPlayer serverPlayer, @NotNull C0886py c0886py);

    @Nullable
    /* JADX INFO: renamed from: a */
    C0886py mo5559a(@NotNull Player player, @NotNull Item item);
}
