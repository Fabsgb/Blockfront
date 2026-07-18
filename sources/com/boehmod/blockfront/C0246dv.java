package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dv.class */
public class C0246dv extends AbstractC0242dr {

    /* JADX INFO: renamed from: gz */
    private static final int f2026gz = 5;

    /* JADX INFO: renamed from: gA */
    private static final int f2027gA;

    /* JADX INFO: renamed from: bE */
    @NotNull
    private static final ResourceLocation f2028bE;

    /* JADX INFO: renamed from: gB */
    private static final int f2029gB = 854;

    /* JADX INFO: renamed from: gC */
    private static final int f2030gC = 480;

    /* JADX INFO: renamed from: by */
    static final /* synthetic */ boolean f2031by;

    static {
        f2031by = !C0246dv.class.desiredAssertionStatus();
        f2027gA = ThreadLocalRandom.current().nextInt(5);
        f2028bE = C0564jv.m2555d("textures/gui/background/menu/" + f2027gA + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1410a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i2 / 2;
        int i6 = i / 2;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2031by && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        float fMax = Math.max(i / 854.0f, i2 / 480.0f);
        C0119bk.m415a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m449c(poseStack, guiGraphics, f2028bE, i6, i5, 854.0f, 480.0f, fMax, 0.5f);
        C0119bk.m527a(minecraft, f2, 3);
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1411a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0482iS c0482iS, @NotNull C0195cx c0195cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1412a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1413a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, float f) {
    }
}
