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

/* JADX INFO: renamed from: com.boehmod.blockfront.hA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hA.class */
public final class C0411hA extends AbstractC0461hy {
    /* JADX INFO: renamed from: a */
    private static void m1947a(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM7843e = C1290xm.m7843e(C0050aU.f319bl, C0050aU.f320bm, f);
        if (fM7843e >= 0.1f) {
            C0119bk.m417a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_WHITE, Math.min(fM7843e, 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0461hy
    /* JADX INFO: renamed from: a */
    public void mo1948a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0622l c0622l, @NotNull C0482iS c0482iS, C0324fT c0324fT, AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, boolean z, float f, float f2) {
        if (localPlayer != null && minecraft.options.getCameraType().isFirstPerson()) {
            m1947a(guiGraphics, i, i2, f2);
        }
    }
}
