package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bQ.class */
public final class C0100bQ implements InterfaceC0102bS {

    /* JADX INFO: renamed from: X */
    private static final ResourceLocation f659X = C0532jO.m2378d("textures/gui/emitter/flash.png");

    /* JADX INFO: renamed from: Y */
    private static final ResourceLocation f660Y = C0532jO.m2378d("textures/gui/emitter/bat.png");

    /* JADX INFO: renamed from: df */
    private final float f661df;

    /* JADX INFO: renamed from: dg */
    private final float f662dg;

    /* JADX INFO: renamed from: dh */
    private float f664dh;

    /* JADX INFO: renamed from: aQ */
    private boolean f663aQ = false;

    /* JADX INFO: renamed from: di */
    private float f665di = 0.0f;

    public C0100bQ(float f, float f2) {
        this.f661df = f;
        this.f662dg = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: n */
    public void mo394n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public boolean mo395a(float f) {
        this.f665di = this.f664dh;
        if (this.f663aQ) {
            if (this.f664dh > 0.0f) {
                this.f664dh -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.f664dh < 1.0f) {
            this.f664dh += 0.25f;
            return false;
        }
        this.f663aQ = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public void mo396a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: b */
    public void mo397b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 200.0f);
        float fSin = Mth.sin(fHashCode / 5.0f);
        float fSin2 = Mth.sin(fHashCode / 8.0f);
        float fSin3 = Mth.sin(fHashCode / 10.0f);
        poseStack.pushPose();
        poseStack.translate(3.0f * fSin * fSin2, 3.0f * fSin * fSin3, 0.0f);
        float f3 = this.f665di + ((this.f664dh - this.f665di) * f2);
        float fSin4 = 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f);
        C0129bt.m544b(poseStack, guiGraphics, f659X, this.f661df, this.f662dg, 25.0f * f3, 25.0f * f3, fSin4, f3 / 2.0f);
        C0129bt.m544b(poseStack, guiGraphics, f660Y, this.f661df, this.f662dg, 15.0f * f3, 15.0f * f3, fSin4, f3);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0102bS.a mo398a() {
        return InterfaceC0102bS.a.BACKGROUND;
    }
}
