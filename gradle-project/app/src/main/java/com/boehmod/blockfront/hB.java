package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hB.class */
public final class hB extends AbstractC0215hy {
    @Override // com.boehmod.blockfront.AbstractC0215hy
    public void a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, LocalPlayer localPlayer, ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0297l c0297l, @NotNull iS iSVar, fT fTVar, oF<?, ?, ?> oFVar, int i, int i2, boolean z, float f, float f2) {
        float fB = c0297l.m596a().b(f2);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        C0040bk.a(guiGraphics, 0, 0, i, i2, 0, fB);
        poseStack.popPose();
    }
}
