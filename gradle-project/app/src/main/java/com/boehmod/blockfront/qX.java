package com.boehmod.blockfront;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qX.class */
public interface qX {
    boolean a(@NotNull Level level, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack);

    void a(@NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack);
}
