package com.boehmod.blockfront;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qK.class */
public interface InterfaceC0898qK {
    /* JADX INFO: renamed from: bs */
    int m4650bs();

    /* JADX INFO: renamed from: a */
    void m4651a(@NotNull C0677mB c0677mB, @NotNull Level level);

    /* JADX INFO: renamed from: a */
    void m4652a(@NotNull C0677mB c0677mB, @Nullable ServerPlayer serverPlayer, @NotNull UUID uuid);

    /* JADX INFO: renamed from: a */
    boolean m4653a(@NotNull Level level, @NotNull Player player, @NotNull C0677mB c0677mB);

    /* JADX INFO: renamed from: a */
    boolean m4654a(@NotNull Level level, @NotNull Player player);

    /* JADX INFO: renamed from: a */
    void m4655a(@NotNull Level level, @NotNull Player player, @NotNull ItemStack itemStack);
}
