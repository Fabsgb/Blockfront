package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ch, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ch.class */
public class C0064ch extends bV<sA, sC> {
    @Override // com.boehmod.blockfront.AbstractC0063cg
    public /* bridge */ /* synthetic */ void a(@NotNull Minecraft minecraft, @NotNull oF oFVar, @NotNull oI oIVar, @NotNull oG oGVar, @NotNull LocalPlayer localPlayer) {
        a(minecraft, (sA) oFVar, (sC) oIVar, (oG<sA, sC>) oGVar, localPlayer);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull sA sAVar, @NotNull sC sCVar, @NotNull oG<sA, sC> oGVar, @NotNull LocalPlayer localPlayer) {
        a((Component) Component.translatable("bf.message.gamemode.ttt.points", new Object[]{Component.literal(C0637xp.a(oR.a((oF<?, ?, ?>) sAVar, localPlayer.getUUID(), C0529tp.s))).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.GRAY));
    }
}
