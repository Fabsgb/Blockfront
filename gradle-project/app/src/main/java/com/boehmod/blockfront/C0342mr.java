package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mr.class */
public class C0342mr extends AbstractC0339mo {
    public static final float ic = 0.05f;
    public static final float id = 0.05f;
    public static final float ie = 0.025f;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static final float f248if = 4.0f;
    public static final float ig = 1.5f;

    /* JADX INFO: renamed from: ik, reason: collision with other field name */
    private final Component f249ik;
    private final Component il;
    private int kD = 40;
    private int kE = 160;
    private float ih = 1.0f;
    private float ii = 1.0f;
    private float ij = 0.0f;
    private float ik = 0.0f;

    public C0342mr(@NotNull oF<?, ?, ?> oFVar) {
        MutableComponent mutableComponentWithColor = Component.literal(C0637xp.p(oFVar.getDisplayName().getString())).withColor(ColorReferences.TROPHY_COLOR_GOLD);
        this.f249ik = Component.literal(oFVar.m751a().getName()).copy().withStyle(C0266jw.b);
        this.il = mutableComponentWithColor;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.ii = this.ih;
        this.ik = this.ij;
        this.ih = C0634xm.d(this.ih, 0.0f, 0.025f);
        int i = this.kD;
        this.kD = i - 1;
        if (i <= 0) {
            int i2 = this.kE;
            this.kE = i2 - 1;
            if (i2 <= 0) {
                this.ij = C0634xm.d(this.ij, 0.0f, 0.05f);
            } else {
                this.ij = C0634xm.d(this.ij, 1.0f, 0.05f);
            }
        }
        return this.kE <= 0 && this.ij <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public void d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fE = C0634xm.e(this.ij, this.ik, f);
        if (fE >= 0.04f) {
            C0040bk.b(poseStack, guiGraphics, C0080cx.aJ, i3, i4, 200, 200, 0.0f, 0.25f * fE);
            int iA = C0634xm.a(ColorReferences.COLOR_WHITE, fE);
            C0040bk.c(poseStack, font, guiGraphics, this.f249ik, i3, i4 - 30, iA, 4.0f);
            C0040bk.d(poseStack, font, guiGraphics, this.il, i3 + 0.5f, i4 + 10, iA, 1.5f);
        }
        C0040bk.a(guiGraphics, 0, 0, i, i2, 0, C0634xm.e(this.ih, this.ii, f));
    }
}
