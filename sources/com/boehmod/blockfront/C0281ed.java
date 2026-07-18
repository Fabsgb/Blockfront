package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ed */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ed.class */
public final class C0281ed extends AbstractC0284eg {

    /* JADX INFO: renamed from: R */
    @NotNull
    private final String f2138R;

    /* JADX INFO: renamed from: cM */
    public int f2139cM;

    /* JADX INFO: renamed from: cN */
    public int f2140cN;

    public C0281ed(@NotNull String str, int i, int i2) {
        this.f2138R = str;
        this.f2139cM = i;
        this.f2140cN = i2;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: an */
    protected void mo1490an() {
        super.mo1490an();
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        C0119bk.m431a(poseStack, guiGraphics, C0118bj.m363a(minecraft, this.f2138R), this.f2166hI + 5, this.f2167hJ, this.f2139cM, this.f2140cN);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return this.f2140cN;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return this.f2165a.m699t();
    }
}
