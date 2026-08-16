package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hR.class */
public final class C0429hR extends AbstractC0426hO {
    @Override // com.boehmod.blockfront.AbstractC0426hO
    /* JADX INFO: renamed from: a */
    public void mo1973a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, LocalPlayer localPlayer, ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0623l c0623l, @NotNull C0555jl c0555jl, C0394gj c0394gj, AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, boolean z, float f, float f2) {
        float fM2584b = c0623l.m2885a().m2584b(f2);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        C0129bt.m517a(guiGraphics, 0, 0, i, i2, 0, fM2584b);
        poseStack.popPose();
    }
}
