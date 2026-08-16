package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tZ.class */
public interface InterfaceC1074tZ {
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    default boolean mo5943a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    default boolean mo5944b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    default boolean mo5945c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    default boolean mo5946d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }
}
