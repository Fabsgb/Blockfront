package com.boehmod.blockfront;

import com.boehmod.blockfront.bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bM.class */
public final class bM implements bJ {
    public static final ResourceLocation aa = C0265jv.d("textures/gui/emitter/flash.png");
    public static final ResourceLocation ab = C0265jv.d("textures/gui/emitter/snowflake.png");
    private final float di;
    private final float dj;
    private float db;
    private boolean aL = false;
    private float dc = 0.0f;

    public bM(float f, float f2) {
        this.di = f;
        this.dj = f2;
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
        float f3 = this.dc + ((this.db - this.dc) * f2);
        float fSin = 20.0f * Mth.sin((f + ((f3 * 100.0f) / 30.0f)) / 15.0f);
        C0040bk.b(poseStack, guiGraphics, aa, this.di, this.dj, 25.0f * f3, 25.0f * f3, fSin, f3 / 2.0f);
        C0040bk.b(poseStack, guiGraphics, ab, this.di, this.dj, 15.0f * f3, 15.0f * f3, fSin, f3);
    }

    @Override // com.boehmod.blockfront.bJ
    @NotNull
    public bJ.a a() {
        return bJ.a.BACKGROUND;
    }
}
