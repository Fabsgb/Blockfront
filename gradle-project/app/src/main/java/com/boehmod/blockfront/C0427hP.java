package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hP.class */
public final class C0427hP extends AbstractC0426hO {

    /* JADX INFO: renamed from: kH */
    private static final int f2698kH = 50;

    /* JADX INFO: renamed from: kI */
    private static final int f2699kI = 8;

    /* JADX INFO: renamed from: hR */
    @NotNull
    private static final Component f2700hR = C0030a.f269c.copy().withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: hS */
    @NotNull
    private static final Component f2701hS = Component.translatable("bf.message.gameplay").withStyle(C0533jP.f3185b);

    @Override // com.boehmod.blockfront.AbstractC0426hO
    /* JADX INFO: renamed from: a */
    public void mo1973a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, LocalPlayer localPlayer, ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0623l c0623l, @NotNull C0555jl c0555jl, C0394gj c0394gj, AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, boolean z, float f, float f2) {
        if (minecraft.options.hideGui || minecraft.getDebugOverlay().showDebugScreen() || !C0030a.f267a.shouldDisplayDisclaimer()) {
            return;
        }
        int i3 = ((i - 50) - 8) + 8 + 25;
        int iM7159a = C1270xJ.m7159a(ColorReferences.COLOR_WHITE, 0.105f);
        C0129bt.m485c(font, guiGraphics, f2700hR, i3, 8, iM7159a);
        C0129bt.m492c(poseStack, font, guiGraphics, f2701hS, i3, 18.0f, iM7159a, 0.5f);
    }
}
