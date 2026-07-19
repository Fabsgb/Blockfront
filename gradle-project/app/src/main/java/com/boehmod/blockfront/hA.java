package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hA.class */
public final class hA extends AbstractC0215hy {
    private static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fE = C0634xm.e(aU.bl, aU.bm, f);
        if (fE >= 0.1f) {
            C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_WHITE, Math.min(fE, 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0215hy
    public void a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0297l c0297l, @NotNull iS iSVar, fT fTVar, oF<?, ?, ?> oFVar, int i, int i2, boolean z, float f, float f2) {
        if (localPlayer != null && minecraft.options.getCameraType().isFirstPerson()) {
            a(guiGraphics, i, i2, f2);
        }
    }
}
