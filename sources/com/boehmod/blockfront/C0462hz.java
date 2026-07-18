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

/* JADX INFO: renamed from: com.boehmod.blockfront.hz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hz.class */
public final class C0462hz extends AbstractC0461hy {

    /* JADX INFO: renamed from: jm */
    private static final int f2868jm = 50;

    /* JADX INFO: renamed from: jn */
    private static final int f2869jn = 8;

    /* JADX INFO: renamed from: hI */
    @NotNull
    private static final Component f2870hI = C0029a.f252c.copy().withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: hJ */
    @NotNull
    private static final Component f2871hJ = Component.translatable("bf.message.gameplay").withStyle(C0565jw.f3201b);

    @Override // com.boehmod.blockfront.AbstractC0461hy
    /* JADX INFO: renamed from: a */
    public void mo1948a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, LocalPlayer localPlayer, ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0622l c0622l, @NotNull C0482iS c0482iS, C0324fT c0324fT, AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, boolean z, float f, float f2) {
        if (minecraft.options.hideGui || minecraft.getDebugOverlay().showDebugScreen() || !C0029a.f250a.shouldDisplayDisclaimer()) {
            return;
        }
        int i3 = ((i - 50) - 8) + 8 + 25;
        int iM7833a = C1290xm.m7833a(ColorReferences.COLOR_WHITE, 0.105f);
        C0119bk.m385c(font, guiGraphics, f2870hI, i3, 8, iM7833a);
        C0119bk.m392c(poseStack, font, guiGraphics, f2871hJ, i3, 18.0f, iM7833a, 0.5f);
    }
}
