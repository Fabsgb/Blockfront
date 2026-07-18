package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.br */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/br.class */
public final class C0126br extends C0127bs {

    /* JADX INFO: renamed from: cx */
    public static final int f878cx = 24;

    /* JADX INFO: renamed from: cy */
    public static final int f879cy = 100;

    /* JADX INFO: renamed from: cP */
    private static final float f882cP = 10.0f;

    /* JADX INFO: renamed from: cQ */
    private static float f884cQ;

    /* JADX INFO: renamed from: ay */
    private static boolean f886ay;

    /* JADX INFO: renamed from: cS */
    private static float f887cS;

    /* JADX INFO: renamed from: cA */
    private int f889cA;

    /* JADX INFO: renamed from: Q */
    @NotNull
    private static final ResourceLocation f880Q = C0564jv.m2555d("textures/gui/menu/button_gloss.png");

    /* JADX INFO: renamed from: R */
    @NotNull
    private static final ResourceLocation f881R = C0564jv.m2555d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: cz */
    private static int f883cz = 0;

    /* JADX INFO: renamed from: cR */
    private static float f885cR = 0.0f;

    /* JADX INFO: renamed from: cT */
    private static float f888cT = 0.0f;

    public C0126br(@NotNull Component component, int i, int i2, int i3, int i4, @NotNull Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
        this.f889cA = ColorReferences.COLOR_TEAM_ALLIES_SOLID;
    }

    /* JADX INFO: renamed from: b */
    public void m635b(int i) {
        this.f889cA = i;
    }

    public static void onUpdate() {
        f885cR = f884cQ;
        int i = f883cz;
        f883cz = i - 1;
        if (i <= 0) {
            f884cQ += 10.0f;
            if (f884cQ >= 292.0f) {
                f883cz = 10;
                f885cR = -96.0f;
                f884cQ = -96.0f;
            }
        }
        f888cT = f887cS;
        f887cS = Mth.lerp(0.6f, f887cS, f886ay ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: a */
    public void mo636a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX();
        int y = getY();
        float f3 = this.width * 1.5f;
        C0119bk.m446b(poseStack, guiGraphics, f881R, x + i3, y + i4, f3, f3, 0.0f, C1290xm.m7843e(f887cS, f888cT, f2) * 0.5f, this.f889cA);
        super.mo636a(guiGraphics, poseStack, i, i2, f, f2);
        f886ay = this.isHovered;
        float fM7843e = C1290xm.m7843e(f884cQ, f885cR, f2);
        C0119bk.m517a(guiGraphics, x, y, this.width, this.height);
        C0119bk.m444b(poseStack, guiGraphics, f880Q, x + i4 + fM7843e, y + i4, 96.0f, 96.0f, 45.0f, 0.75f);
        guiGraphics.disableScissor();
    }

    @Override // com.boehmod.blockfront.C0127bs
    /* JADX INFO: renamed from: r */
    public int mo637r() {
        if (isHoveredOrFocused()) {
            return -6250336;
        }
        return ColorReferences.COLOR_WHITE_SOLID;
    }
}
