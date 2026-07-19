package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bW.class */
public class bW extends bV<rV, rX> {
    @Override // com.boehmod.blockfront.AbstractC0063cg
    public /* bridge */ /* synthetic */ void a(@NotNull Minecraft minecraft, @NotNull oF oFVar, @NotNull oI oIVar, @NotNull oG oGVar, @NotNull LocalPlayer localPlayer) {
        a(minecraft, (rV) oFVar, (rX) oIVar, (oG<rV, rX>) oGVar, localPlayer);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull rV rVVar, @NotNull rX rXVar, @NotNull oG<rV, rX> oGVar, @NotNull LocalPlayer localPlayer) {
        a((Component) Component.literal("$" + C0637xp.a(oR.a((oF<?, ?, ?>) rVVar, localPlayer.getUUID(), C0529tp.s))).withStyle(ChatFormatting.GREEN));
    }
}
