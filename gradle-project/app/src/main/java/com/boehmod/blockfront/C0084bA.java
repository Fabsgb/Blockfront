package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bA.class */
public final class C0084bA extends C0085bB {

    /* JADX INFO: renamed from: dp */
    public static final int f517dp = 24;

    /* JADX INFO: renamed from: dq */
    public static final int f518dq = 100;

    /* JADX INFO: renamed from: cV */
    private static final float f521cV = 10.0f;

    /* JADX INFO: renamed from: cW */
    private static float f523cW;

    /* JADX INFO: renamed from: aD */
    private static boolean f525aD;

    /* JADX INFO: renamed from: cY */
    private static float f526cY;

    /* JADX INFO: renamed from: ds */
    private int f528ds;

    /* JADX INFO: renamed from: Q */
    @NotNull
    private static final ResourceLocation f519Q = C0532jO.m2378d("textures/gui/menu/button_gloss.png");

    /* JADX INFO: renamed from: R */
    @NotNull
    private static final ResourceLocation f520R = C0532jO.m2378d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: dr */
    private static int f522dr = 0;

    /* JADX INFO: renamed from: cX */
    private static float f524cX = 0.0f;

    /* JADX INFO: renamed from: cZ */
    private static float f527cZ = 0.0f;

    public C0084bA(@NotNull Component component, int i, int i2, int i3, int i4, @NotNull Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
        this.f528ds = ColorReferences.COLOR_TEAM_ALLIES_SOLID;
    }

    /* JADX INFO: renamed from: b */
    public void m310b(int i) {
        this.f528ds = i;
    }

    public static void onUpdate() {
        f524cX = f523cW;
        int i = f522dr;
        f522dr = i - 1;
        if (i <= 0) {
            f523cW += 10.0f;
            if (f523cW >= 292.0f) {
                f522dr = 10;
                f524cX = -96.0f;
                f523cW = -96.0f;
            }
        }
        f527cZ = f526cY;
        f526cY = Mth.lerp(0.6f, f526cY, f525aD ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: a */
    public void mo311a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX();
        int y = getY();
        float fM7170f = C1270xJ.m7170f(f526cY, f527cZ, f2);
        float f3 = this.width * 1.5f;
        C0129bt.m546b(poseStack, guiGraphics, f520R, x + i3, y + i4, f3, f3, 0.0f, fM7170f * 0.5f, this.f528ds);
        super.mo311a(guiGraphics, poseStack, i, i2, f, f2);
        f525aD = this.isHovered;
        float fM7170f2 = C1270xJ.m7170f(f523cW, f524cX, f2);
        C0129bt.m618a(guiGraphics, x, y, this.width, this.height);
        C0129bt.m544b(poseStack, guiGraphics, f519Q, x + i4 + fM7170f2, y + i4, 96.0f, 96.0f, 45.0f, 0.75f);
        guiGraphics.disableScissor();
    }

    @Override // com.boehmod.blockfront.C0085bB
    /* JADX INFO: renamed from: v */
    public int mo312v() {
        if (isHoveredOrFocused()) {
            return -6250336;
        }
        return ColorReferences.COLOR_WHITE_SOLID;
    }
}
