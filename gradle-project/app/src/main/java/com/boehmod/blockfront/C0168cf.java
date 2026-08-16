package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cf.class */
public class C0168cf extends AbstractC0167ce<C1040ss, C1042su> {
    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1055a(minecraft, (C1040ss) abstractC0863pb, (C1042su) abstractC0866pe, (AbstractC0864pc<C1040ss, C1042su>) abstractC0864pc, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1055a(@NotNull Minecraft minecraft, @NotNull C1040ss c1040ss, @NotNull C1042su c1042su, @NotNull AbstractC0864pc<C1040ss, C1042su> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1054a((Component) Component.literal("$" + C1273xM.m7239b(C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) c1040ss, localPlayer.getUUID(), C1062tN.f5755s))).withStyle(ChatFormatting.GREEN));
    }
}
