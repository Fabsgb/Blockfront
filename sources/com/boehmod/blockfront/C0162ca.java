package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ca */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ca.class */
public class C0162ca extends AbstractC0104bV<C1030sj, C1034sn> {
    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m999a(minecraft, (C1030sj) abstractC0787oF, (C1034sn) abstractC0790oI, (AbstractC0788oG<C1030sj, C1034sn>) abstractC0788oG, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m999a(@NotNull Minecraft minecraft, @NotNull C1030sj c1030sj, @NotNull C1034sn c1034sn, @NotNull AbstractC0788oG<C1030sj, C1034sn> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.of.waves", new Object[]{Component.literal(String.valueOf(c1030sj.m5754bG())).withStyle(ChatFormatting.WHITE)});
        C0796oO c0796oOM5749f = c1030sj.m5749f();
        mutableComponentTranslatable.withColor(c0796oOM5749f != null ? c0796oOM5749f.getColor() : ColorReferences.COLOR_WHITE);
        m329a((Component) mutableComponentTranslatable);
    }
}
