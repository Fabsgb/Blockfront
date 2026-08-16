package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cj.class */
public class C0172cj extends AbstractC0167ce<C1001sG, C1005sK> {
    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1060a(minecraft, (C1001sG) abstractC0863pb, (C1005sK) abstractC0866pe, (AbstractC0864pc<C1001sG, C1005sK>) abstractC0864pc, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public void m1060a(@NotNull Minecraft minecraft, @NotNull C1001sG c1001sG, @NotNull C1005sK c1005sK, @NotNull AbstractC0864pc<C1001sG, C1005sK> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.of.waves", new Object[]{Component.literal(String.valueOf(c1001sG.m5642bV())).withStyle(ChatFormatting.WHITE)});
        C0872pk c0872pkM5637f = c1001sG.m5637f();
        mutableComponentTranslatable.withColor(c0872pkM5637f != null ? c0872pkM5637f.getColor() : ColorReferences.COLOR_WHITE);
        m1054a((Component) mutableComponentTranslatable);
    }
}
