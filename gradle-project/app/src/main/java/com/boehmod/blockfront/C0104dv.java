package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dv.class */
public class C0104dv extends AbstractC0100dr {
    private static final int gz = 5;
    private static final int gA;

    @NotNull
    private static final ResourceLocation bE;
    private static final int gB = 854;
    private static final int gC = 480;
    static final /* synthetic */ boolean by;

    static {
        by = !C0104dv.class.desiredAssertionStatus();
        gA = ThreadLocalRandom.current().nextInt(5);
        bE = C0265jv.d("textures/gui/background/menu/" + gA + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i2 / 2;
        int i6 = i / 2;
        C0297l c0297lB = C0297l.b();
        if (!by && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        float fMax = Math.max(i / 854.0f, i2 / 480.0f);
        C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.c(poseStack, guiGraphics, bE, i6, i5, 854.0f, 480.0f, fMax, 0.5f);
        C0040bk.a(minecraft, f2, 3);
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, iS iSVar, @NotNull C0080cx c0080cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, float f) {
    }
}
