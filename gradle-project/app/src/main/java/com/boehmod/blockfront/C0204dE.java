package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dE.class */
public class C0204dE extends AbstractC0200dA {

    /* JADX INFO: renamed from: hE */
    private static final int f1591hE = 5;

    /* JADX INFO: renamed from: hF */
    private static final int f1592hF;

    /* JADX INFO: renamed from: bC */
    @NotNull
    private static final ResourceLocation f1593bC;

    /* JADX INFO: renamed from: hG */
    private static final int f1594hG = 854;

    /* JADX INFO: renamed from: hH */
    private static final int f1595hH = 480;

    /* JADX INFO: renamed from: bC */
    static final /* synthetic */ boolean f1596bC;

    static {
        f1596bC = !C0204dE.class.desiredAssertionStatus();
        f1592hF = ThreadLocalRandom.current().nextInt(5);
        f1593bC = C0532jO.m2378d("textures/gui/background/menu/" + f1592hF + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1236a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i2 / 2;
        int i6 = i / 2;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f1596bC && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        float fMax = Math.max(i / 854.0f, i2 / 480.0f);
        C0129bt.m515a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m549c(poseStack, guiGraphics, f1593bC, i6, i5, 854.0f, 480.0f, fMax, 0.5f);
        C0129bt.m629a(minecraft, f2, 3);
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1237a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0555jl c0555jl, @NotNull C0143cG c0143cG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1238a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1239a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, float f) {
    }
}
