package com.boehmod.blockfront;

import com.boehmod.blockfront.bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bH.class */
public final class bH implements bJ {
    private static final ResourceLocation X = C0265jv.d("textures/gui/emitter/flash.png");
    private static final ResourceLocation Y = C0265jv.d("textures/gui/emitter/bat.png");
    private final float cZ;
    private final float da;
    private float db;
    private boolean aL = false;
    private float dc = 0.0f;

    public bH(float f, float f2) {
        this.cZ = f;
        this.da = f2;
    }

    @Override // com.boehmod.blockfront.bJ
    public void m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.bJ
    /* JADX INFO: renamed from: a */
    public boolean mo206a(float f) {
        this.dc = this.db;
        if (this.aL) {
            if (this.db > 0.0f) {
                this.db -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.db < 1.0f) {
            this.db += 0.25f;
            return false;
        }
        this.aL = true;
        return false;
    }

    @Override // com.boehmod.blockfront.bJ
    public void a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.bJ
    public void b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 200.0f);
        float fSin = Mth.sin(fHashCode / 5.0f);
        float fSin2 = Mth.sin(fHashCode / 8.0f);
        float fSin3 = Mth.sin(fHashCode / 10.0f);
        poseStack.pushPose();
        poseStack.translate(3.0f * fSin * fSin2, 3.0f * fSin * fSin3, 0.0f);
        float f3 = this.dc + ((this.db - this.dc) * f2);
        float fSin4 = 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f);
        C0040bk.b(poseStack, guiGraphics, X, this.cZ, this.da, 25.0f * f3, 25.0f * f3, fSin4, f3 / 2.0f);
        C0040bk.b(poseStack, guiGraphics, Y, this.cZ, this.da, 15.0f * f3, 15.0f * f3, fSin4, f3);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.bJ
    @NotNull
    public bJ.a a() {
        return bJ.a.BACKGROUND;
    }
}
