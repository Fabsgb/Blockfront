package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hB.class */
public final class C0412hB extends AbstractC0461hy {
    @Override // com.boehmod.blockfront.AbstractC0461hy
    /* JADX INFO: renamed from: a */
    public void mo1948a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, LocalPlayer localPlayer, ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, GuiGraphics guiGraphics, C0622l c0622l, @NotNull C0482iS c0482iS, C0324fT c0324fT, AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, boolean z, float f, float f2) {
        float fM2595b = c0622l.m2699a().m2595b(f2);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        C0119bk.m417a(guiGraphics, 0, 0, i, i2, 0, fM2595b);
        poseStack.popPose();
    }
}
