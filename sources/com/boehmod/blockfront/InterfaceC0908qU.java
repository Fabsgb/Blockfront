package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qU.class */
public interface InterfaceC0908qU {
    /* JADX INFO: renamed from: a */
    boolean mo4683a(@NotNull Player player, @NotNull C0863pc c0863pc);

    /* JADX INFO: renamed from: a */
    void mo4684a(@NotNull ServerPlayer serverPlayer, @NotNull C0863pc c0863pc);

    @Nullable
    /* JADX INFO: renamed from: a */
    C0863pc mo4685a(@NotNull Player player, @NotNull Item item);
}
