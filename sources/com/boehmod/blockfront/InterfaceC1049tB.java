package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tB.class */
public interface InterfaceC1049tB {
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    default boolean mo5829a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    default boolean mo5830b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    default boolean mo5831c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    default boolean mo5832d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        return false;
    }
}
