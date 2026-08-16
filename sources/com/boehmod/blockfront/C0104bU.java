package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bU.class */
public final class C0104bU implements InterfaceC0102bS {

    /* JADX INFO: renamed from: Z */
    private static final ResourceLocation f690Z = C0532jO.m2378d("textures/gui/emitter/shine.png");

    /* JADX INFO: renamed from: dm */
    private final float f691dm;

    /* JADX INFO: renamed from: dn */
    private final float f692dn;

    /* JADX INFO: renamed from: dh */
    private float f694dh;

    /* JADX INFO: renamed from: aQ */
    private boolean f693aQ = false;

    /* JADX INFO: renamed from: di */
    private float f695di = 0.0f;

    public C0104bU(float f, float f2) {
        this.f691dm = f;
        this.f692dn = f2;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: n */
    public void mo394n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public boolean mo395a(float f) {
        this.f695di = this.f694dh;
        if (this.f693aQ) {
            if (this.f694dh > 0.0f) {
                this.f694dh -= 0.05f;
                return false;
            }
            return true;
        }
        if (this.f694dh < 1.0f) {
            this.f694dh += 0.25f;
            return false;
        }
        this.f693aQ = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: a */
    public void mo396a(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    /* JADX INFO: renamed from: b */
    public void mo397b(@NotNull Minecraft minecraft, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f, float f2) {
        float f3 = this.f695di + ((this.f694dh - this.f695di) * f2);
        C0129bt.m544b(poseStack, guiGraphics, f690Z, this.f691dm, this.f692dn, 15.0f * f3, 15.0f * f3, 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f), f3);
    }

    @Override // com.boehmod.blockfront.InterfaceC0102bS
    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0102bS.a mo398a() {
        return InterfaceC0102bS.a.BACKGROUND;
    }
}
