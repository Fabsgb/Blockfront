package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bV.class */
public final class C0105bV implements InterfaceC0102bS {

    /* JADX INFO: renamed from: aa */
    public static final ResourceLocation f696aa = C0532jO.m2378d("textures/gui/emitter/flash.png");

    /* JADX INFO: renamed from: ab */
    public static final ResourceLocation f697ab = C0532jO.m2378d("textures/gui/emitter/snowflake.png");

    /* JADX INFO: renamed from: do */
    private final float f698do;

    /* JADX INFO: renamed from: dp */
    private final float f699dp;

    /* JADX INFO: renamed from: dh */
    private float f701dh;

    /* JADX INFO: renamed from: aQ */
    private boolean f700aQ = false;

    /* JADX INFO: renamed from: di */
    private float f702di = 0.0f;

    public C0105bV(float f, float f2) {
        this.f698do = f;
        this.f699dp = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: n */
    public void mo394n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public boolean mo395a(float f) {
        this.f702di = this.f701dh;
        if (this.f700aQ) {
            if (this.f701dh > 0.0f) {
                this.f701dh -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.f701dh < 1.0f) {
            this.f701dh += 0.25f;
            return false;
        }
        this.f700aQ = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public void mo396a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: b */
    public void mo397b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float f3 = this.f702di + ((this.f701dh - this.f702di) * f2);
        float fSin = 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f);
        C0129bt.m544b(poseStack, guiGraphics, f696aa, this.f698do, this.f699dp, 25.0f * f3, 25.0f * f3, fSin, f3 / 2.0f);
        C0129bt.m544b(poseStack, guiGraphics, f697ab, this.f698do, this.f699dp, 15.0f * f3, 15.0f * f3, fSin, f3);
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0102bS.a mo398a() {
        return InterfaceC0102bS.a.BACKGROUND;
    }
}
