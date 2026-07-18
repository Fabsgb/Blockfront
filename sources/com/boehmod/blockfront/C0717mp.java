package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mp.class */
public class C0717mp extends AbstractC0716mo {

    /* JADX INFO: renamed from: hU */
    private final float f3833hU;

    /* JADX INFO: renamed from: hV */
    private final float f3834hV;

    /* JADX INFO: renamed from: hW */
    private final float f3835hW;

    /* JADX INFO: renamed from: hX */
    private final float f3836hX;

    /* JADX INFO: renamed from: aD */
    private float f3838aD;

    /* JADX INFO: renamed from: Y */
    private int f3837Y = 0;

    /* JADX INFO: renamed from: aE */
    private float f3839aE = 0.0f;

    /* JADX INFO: renamed from: hY */
    private float f3840hY = 0.0f;

    /* JADX INFO: renamed from: es */
    private boolean f3841es = false;

    public C0717mp(float f, float f2, float f3) {
        this.f3833hU = f;
        this.f3834hV = f2;
        this.f3835hW = f3;
        this.f3836hX = f + f3 + f2;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: a */
    public boolean mo3254a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3839aE = this.f3838aD;
        if (this.f3841es) {
            return true;
        }
        this.f3840hY += 0.05f;
        if (this.f3840hY <= this.f3833hU) {
            this.f3838aD = this.f3840hY / this.f3833hU;
        } else if (this.f3840hY <= this.f3833hU + this.f3835hW) {
            this.f3838aD = 1.0f;
        } else if (this.f3840hY <= this.f3836hX) {
            this.f3838aD = 1.0f - ((this.f3840hY - (this.f3833hU + this.f3835hW)) / this.f3834hV);
        } else {
            this.f3838aD = 0.0f;
            this.f3841es = true;
            return true;
        }
        this.f3838aD = Math.max(0.0f, Math.min(1.0f, this.f3838aD));
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: d */
    public void mo3255d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        C0119bk.m417a(guiGraphics, 0, 0, i, i2, this.f3837Y, C1290xm.m7843e(this.f3838aD, this.f3839aE, f));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0717mp m3256a(int i) {
        this.f3837Y = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public float m3257b() {
        return this.f3838aD;
    }

    /* JADX INFO: renamed from: p */
    public float m3258p(float f) {
        return this.f3839aE + ((this.f3838aD - this.f3839aE) * f);
    }

    /* JADX INFO: renamed from: r */
    public float m3259r() {
        return Math.min(1.0f, this.f3840hY / this.f3836hX);
    }
}
