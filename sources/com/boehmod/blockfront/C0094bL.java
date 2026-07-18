package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0092bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bL.class */
public final class C0094bL implements InterfaceC0092bJ {

    /* JADX INFO: renamed from: Z */
    private static final ResourceLocation f621Z = C0564jv.m2555d("textures/gui/emitter/shine.png");

    /* JADX INFO: renamed from: dg */
    private final float f622dg;

    /* JADX INFO: renamed from: dh */
    private final float f623dh;

    /* JADX INFO: renamed from: db */
    private float f625db;

    /* JADX INFO: renamed from: aL */
    private boolean f624aL = false;

    /* JADX INFO: renamed from: dc */
    private float f626dc = 0.0f;

    public C0094bL(float f, float f2) {
        this.f622dg = f;
        this.f623dh = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: m */
    public void mo289m(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public boolean mo290a(float f) {
        this.f626dc = this.f625db;
        if (this.f624aL) {
            if (this.f625db > 0.0f) {
                this.f625db -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.f625db < 1.0f) {
            this.f625db += 0.25f;
            return false;
        }
        this.f624aL = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: a */
    public void mo291a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    /* JADX INFO: renamed from: b */
    public void mo292b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float f3 = this.f626dc + ((this.f625db - this.f626dc) * f2);
        C0119bk.m444b(poseStack, guiGraphics, f621Z, this.f622dg, this.f623dh, 15.0f * f3, 15.0f * f3, 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f), f3);
    }

    @Override // com.boehmod.blockfront.InterfaceC0092bJ
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0092bJ.a mo293a() {
        return InterfaceC0092bJ.a.BACKGROUND;
    }
}
