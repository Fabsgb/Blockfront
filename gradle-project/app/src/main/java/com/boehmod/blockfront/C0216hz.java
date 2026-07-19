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

/* JADX INFO: renamed from: com.boehmod.blockfront.hz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hz.class */
public final class C0216hz extends AbstractC0215hy {
    private static final int jm = 50;
    private static final int jn = 8;

    @NotNull
    private static final Component hI = C0002a.f31c.copy().withStyle(C0266jw.b);

    @NotNull
    private static final Component hJ = Component.translatable("bf.message.gameplay").withStyle(C0266jw.b);

    @Override // com.boehmod.blockfront.AbstractC0215hy
    public void a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, LocalPlayer localPlayer, ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0297l c0297l, @NotNull iS iSVar, fT fTVar, oF<?, ?, ?> oFVar, int i, int i2, boolean z, float f, float f2) {
        if (minecraft.options.hideGui || minecraft.getDebugOverlay().showDebugScreen() || !C0002a.f29a.shouldDisplayDisclaimer()) {
            return;
        }
        int i3 = ((i - 50) - 8) + 8 + 25;
        int iA = C0634xm.a(ColorReferences.COLOR_WHITE, 0.105f);
        C0040bk.c(font, guiGraphics, hI, i3, 8, iA);
        C0040bk.c(poseStack, font, guiGraphics, hJ, i3, 18.0f, iA, 0.5f);
    }
}
