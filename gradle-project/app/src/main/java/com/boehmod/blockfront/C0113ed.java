package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ed, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ed.class */
public final class C0113ed extends AbstractC0116eg {

    @NotNull
    private final String R;
    public int cM;
    public int cN;

    public C0113ed(@NotNull String str, int i, int i2) {
        this.R = str;
        this.cM = i;
        this.cN = i2;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    protected void an() {
        super.an();
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        C0040bk.a(poseStack, guiGraphics, C0039bj.a(minecraft, this.R), this.hI + 5, this.hJ, this.cM, this.cN);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return this.cN;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t */
    public int mo265t() {
        return this.a.t();
    }
}
