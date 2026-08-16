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

/* JADX INFO: renamed from: com.boehmod.blockfront.hQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hQ.class */
public final class C0428hQ extends AbstractC0426hO {
    /* JADX INFO: renamed from: a */
    private static void m1974a(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM7170f = C1270xJ.m7170f(C0112bc.f733br, C0112bc.f734bs, f);
        if (fM7170f >= 0.1f) {
            C0129bt.m517a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_WHITE, Math.min(fM7170f, 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0426hO
    /* JADX INFO: renamed from: a */
    public void mo1973a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0623l c0623l, @NotNull C0555jl c0555jl, C0394gj c0394gj, AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, boolean z, float f, float f2) {
        if (localPlayer != null && minecraft.options.getCameraType().isFirstPerson()) {
            m1974a(guiGraphics, i, i2, f2);
        }
    }
}
