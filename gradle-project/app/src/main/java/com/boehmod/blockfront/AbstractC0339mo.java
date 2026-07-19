package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mo.class */
public abstract class AbstractC0339mo {
    public abstract boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel);

    public abstract void d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f);
}
