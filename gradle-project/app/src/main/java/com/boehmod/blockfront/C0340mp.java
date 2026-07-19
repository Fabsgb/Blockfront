package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mp.class */
public class C0340mp extends AbstractC0339mo {
    private final float hU;
    private final float hV;
    private final float hW;
    private final float hX;
    private float aD;
    private int Y = 0;
    private float aE = 0.0f;
    private float hY = 0.0f;
    private boolean es = false;

    public C0340mp(float f, float f2, float f3) {
        this.hU = f;
        this.hV = f2;
        this.hW = f3;
        this.hX = f + f3 + f2;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.aE = this.aD;
        if (this.es) {
            return true;
        }
        this.hY += 0.05f;
        if (this.hY <= this.hU) {
            this.aD = this.hY / this.hU;
        } else if (this.hY <= this.hU + this.hW) {
            this.aD = 1.0f;
        } else if (this.hY <= this.hX) {
            this.aD = 1.0f - ((this.hY - (this.hU + this.hW)) / this.hV);
        } else {
            this.aD = 0.0f;
            this.es = true;
            return true;
        }
        this.aD = Math.max(0.0f, Math.min(1.0f, this.aD));
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public void d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        C0040bk.a(guiGraphics, 0, 0, i, i2, this.Y, C0634xm.e(this.aD, this.aE, f));
    }

    @NotNull
    public C0340mp a(int i) {
        this.Y = i;
        return this;
    }

    public float b() {
        return this.aD;
    }

    public float p(float f) {
        return this.aE + ((this.aD - this.aE) * f);
    }

    public float r() {
        return Math.min(1.0f, this.hY / this.hX);
    }
}
