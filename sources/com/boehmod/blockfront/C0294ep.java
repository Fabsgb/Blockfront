package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ep */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ep.class */
public final class C0294ep extends AbstractC0298et {

    /* JADX INFO: renamed from: Y */
    @NotNull
    private final String f2303Y;

    /* JADX INFO: renamed from: dE */
    public int f2304dE;

    /* JADX INFO: renamed from: dF */
    public int f2305dF;

    public C0294ep(@NotNull String str, int i, int i2) {
        this.f2303Y = str;
        this.f2304dE = i;
        this.f2305dF = i2;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: as */
    protected void mo1606as() {
        super.mo1606as();
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        C0129bt.m531a(poseStack, guiGraphics, C0128bs.m463a(minecraft, this.f2303Y), this.f2339iY + 5, this.f2340iZ, this.f2304dE, this.f2305dF);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return this.f2305dF;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x();
    }
}
