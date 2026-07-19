package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qK.class */
public interface qK {
    int bs();

    void a(@NotNull mB mBVar, @NotNull Level level);

    void a(@NotNull mB mBVar, @Nullable ServerPlayer serverPlayer, @NotNull UUID uuid);

    boolean a(@NotNull Level level, @NotNull Player player, @NotNull mB mBVar);

    boolean a(@NotNull Level level, @NotNull Player player);

    void a(@NotNull Level level, @NotNull Player player, @NotNull ItemStack itemStack);
}
