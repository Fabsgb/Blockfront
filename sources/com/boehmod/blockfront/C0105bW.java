package com.boehmod.blockfront;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bW.class */
public class C0105bW extends AbstractC0104bV<C0962rV, C0964rX> {
    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m330a(minecraft, (C0962rV) abstractC0787oF, (C0964rX) abstractC0790oI, (AbstractC0788oG<C0962rV, C0964rX>) abstractC0788oG, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m330a(@NotNull Minecraft minecraft, @NotNull C0962rV c0962rV, @NotNull C0964rX c0964rX, @NotNull AbstractC0788oG<C0962rV, C0964rX> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m329a((Component) Component.literal("$" + C1293xp.m7912a(C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) c0962rV, localPlayer.getUUID(), C1089tp.f5702s))).withStyle(ChatFormatting.GREEN));
    }
}
