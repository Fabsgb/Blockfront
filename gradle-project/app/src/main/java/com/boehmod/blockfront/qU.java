package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qU.class */
public interface qU {
    boolean a(@NotNull Player player, @NotNull C0408pc c0408pc);

    void a(@NotNull ServerPlayer serverPlayer, @NotNull C0408pc c0408pc);

    @Nullable
    C0408pc a(@NotNull Player player, @NotNull Item item);
}
