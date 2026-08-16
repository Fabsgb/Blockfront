package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mL.class */
public class C0688mL extends AbstractC0687mK {

    /* JADX INFO: renamed from: iM */
    private final float f3785iM;

    /* JADX INFO: renamed from: iN */
    private final float f3786iN;

    /* JADX INFO: renamed from: iO */
    private final float f3787iO;

    /* JADX INFO: renamed from: iP */
    private final float f3788iP;

    /* JADX INFO: renamed from: aI */
    private float f3790aI;

    /* JADX INFO: renamed from: aM */
    private int f3789aM = 0;

    /* JADX INFO: renamed from: aJ */
    private float f3791aJ = 0.0f;

    /* JADX INFO: renamed from: iQ */
    private float f3792iQ = 0.0f;

    /* JADX INFO: renamed from: eM */
    private boolean f3793eM = false;

    public C0688mL(float f, float f2, float f3) {
        this.f3785iM = f;
        this.f3786iN = f2;
        this.f3787iO = f3;
        this.f3788iP = f + f3 + f2;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: a */
    public boolean mo3087a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3791aJ = this.f3790aI;
        if (this.f3793eM) {
            return true;
        }
        this.f3792iQ += 0.05f;
        if (this.f3792iQ <= this.f3785iM) {
            this.f3790aI = this.f3792iQ / this.f3785iM;
        } else if (this.f3792iQ <= this.f3785iM + this.f3787iO) {
            this.f3790aI = 1.0f;
        } else if (this.f3792iQ <= this.f3788iP) {
            this.f3790aI = 1.0f - ((this.f3792iQ - (this.f3785iM + this.f3787iO)) / this.f3786iN);
        } else {
            this.f3790aI = 0.0f;
            this.f3793eM = true;
            return true;
        }
        this.f3790aI = Math.max(0.0f, Math.min(1.0f, this.f3790aI));
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: d */
    public void mo3088d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        C0129bt.m517a(guiGraphics, 0, 0, i, i2, this.f3789aM, C1270xJ.m7170f(this.f3790aI, this.f3791aJ, f));
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: r */
    public float mo3089r(float f) {
        return C1270xJ.m7170f(this.f3790aI, this.f3791aJ, f);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0688mL m3090a(int i) {
        this.f3789aM = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public float m3091b() {
        return this.f3790aI;
    }

    /* JADX INFO: renamed from: s */
    public float m3092s(float f) {
        return this.f3791aJ + ((this.f3790aI - this.f3791aJ) * f);
    }

    /* JADX INFO: renamed from: r */
    public float m3093r() {
        return Math.min(1.0f, this.f3792iQ / this.f3788iP);
    }
}
