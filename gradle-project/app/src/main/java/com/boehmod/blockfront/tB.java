package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tB.class */
public interface tB {
    @OnlyIn(Dist.CLIENT)
    default boolean a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    default boolean b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    default boolean c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    default boolean d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }
}
