package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ch */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ch.class */
public class C0169ch extends AbstractC0104bV<C0994sA, C0996sC> {
    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m1000a(minecraft, (C0994sA) abstractC0787oF, (C0996sC) abstractC0790oI, (AbstractC0788oG<C0994sA, C0996sC>) abstractC0788oG, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1000a(@NotNull Minecraft minecraft, @NotNull C0994sA c0994sA, @NotNull C0996sC c0996sC, @NotNull AbstractC0788oG<C0994sA, C0996sC> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m329a((Component) Component.translatable("bf.message.gamemode.ttt.points", new Object[]{Component.literal(C1293xp.m7912a(C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) c0994sA, localPlayer.getUUID(), C1089tp.f5702s))).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.GRAY));
    }
}
