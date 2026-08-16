package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cq.class */
public class C0189cq extends AbstractC0167ce<C1018sX, C1020sZ> {
    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1187a(minecraft, (C1018sX) abstractC0863pb, (C1020sZ) abstractC0866pe, (AbstractC0864pc<C1018sX, C1020sZ>) abstractC0864pc, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1187a(@NotNull Minecraft minecraft, @NotNull C1018sX c1018sX, @NotNull C1020sZ c1020sZ, @NotNull AbstractC0864pc<C1018sX, C1020sZ> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1054a((Component) Component.translatable("bf.message.gamemode.ttt.points", new Object[]{Component.literal(C1273xM.m7239b(C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) c1018sX, localPlayer.getUUID(), C1062tN.f5755s))).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.GRAY));
    }
}
