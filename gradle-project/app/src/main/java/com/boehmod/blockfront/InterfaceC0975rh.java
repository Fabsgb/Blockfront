package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rh.class */
public interface InterfaceC0975rh {
    /* JADX INFO: renamed from: bH */
    int m5545bH();

    /* JADX INFO: renamed from: a */
    void m5546a(@NotNull C0700mX c0700mX, @NotNull Level level);

    /* JADX INFO: renamed from: a */
    void m5547a(@NotNull C0700mX c0700mX, @Nullable ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    boolean m5548a(@NotNull Level level, @NotNull Player player, @NotNull C0700mX c0700mX);

    /* JADX INFO: renamed from: a */
    boolean m5549a(@NotNull Level level, @NotNull Player player);

    /* JADX INFO: renamed from: a */
    void m5550a(@NotNull Level level, @NotNull Player player, @NotNull ItemStack itemStack);
}
