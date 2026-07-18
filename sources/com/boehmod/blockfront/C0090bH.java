package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0092bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bH.class */
public final class C0090bH implements InterfaceC0092bJ {

    /* JADX INFO: renamed from: X */
    private static final ResourceLocation f590X = C0564jv.m2555d("textures/gui/emitter/flash.png");

    /* JADX INFO: renamed from: Y */
    private static final ResourceLocation f591Y = C0564jv.m2555d("textures/gui/emitter/bat.png");

    /* JADX INFO: renamed from: cZ */
    private final float f592cZ;

    /* JADX INFO: renamed from: da */
    private final float f593da;

    /* JADX INFO: renamed from: db */
    private float f595db;

    /* JADX INFO: renamed from: aL */
    private boolean f594aL = false;

    /* JADX INFO: renamed from: dc */
    private float f596dc = 0.0f;

    public C0090bH(float f, float f2) {
        this.f592cZ = f;
        this.f593da = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: m */
    public void mo289m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public boolean mo290a(float f) {
        this.f596dc = this.f595db;
        if (this.f594aL) {
            if (this.f595db > 0.0f) {
                this.f595db -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.f595db < 1.0f) {
            this.f595db += 0.25f;
            return false;
        }
        this.f594aL = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public void mo291a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: b */
    public void mo292b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float fHashCode = f + (hashCode() / 200.0f);
        float fSin = Mth.sin(fHashCode / 5.0f);
        float fSin2 = Mth.sin(fHashCode / 8.0f);
        float fSin3 = Mth.sin(fHashCode / 10.0f);
        poseStack.pushPose();
        poseStack.translate(3.0f * fSin * fSin2, 3.0f * fSin * fSin3, 0.0f);
        float f3 = this.f596dc + ((this.f595db - this.f596dc) * f2);
        float fSin4 = 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f);
        C0119bk.m444b(poseStack, guiGraphics, f590X, this.f592cZ, this.f593da, 25.0f * f3, 25.0f * f3, fSin4, f3 / 2.0f);
        C0119bk.m444b(poseStack, guiGraphics, f591Y, this.f592cZ, this.f593da, 15.0f * f3, 15.0f * f3, fSin4, f3);
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0092bJ.a mo293a() {
        return InterfaceC0092bJ.a.BACKGROUND;
    }
}
