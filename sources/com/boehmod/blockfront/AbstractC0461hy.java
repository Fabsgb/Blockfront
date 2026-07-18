package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hy.class */
public abstract class AbstractC0461hy {
    /* JADX INFO: renamed from: a */
    public abstract void mo1948a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, @Nullable GuiGraphics guiGraphics, C0622l c0622l, @NotNull C0482iS c0482iS, C0324fT c0324fT, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, boolean z, float f, float f2);
}
