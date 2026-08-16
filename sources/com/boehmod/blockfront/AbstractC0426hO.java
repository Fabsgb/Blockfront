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

/* JADX INFO: renamed from: com.boehmod.blockfront.hO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hO.class */
public abstract class AbstractC0426hO {
    /* JADX INFO: renamed from: a */
    public abstract void mo1973a(@NotNull RenderFrameEvent.Post post, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull PoseStack poseStack, @NotNull Font font, @Nullable GuiGraphics guiGraphics, C0623l c0623l, @NotNull C0555jl c0555jl, C0394gj c0394gj, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, boolean z, float f, float f2);
}
