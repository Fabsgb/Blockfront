package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.br, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/br.class */
public final class C0047br extends C0048bs {
    public static final int cx = 24;
    public static final int cy = 100;
    private static final float cP = 10.0f;
    private static float cQ;
    private static boolean ay;
    private static float cS;
    private int cA;

    @NotNull
    private static final ResourceLocation Q = C0265jv.d("textures/gui/menu/button_gloss.png");

    @NotNull
    private static final ResourceLocation R = C0265jv.d("textures/gui/backshadow_white.png");
    private static int cz = 0;
    private static float cR = 0.0f;
    private static float cT = 0.0f;

    public C0047br(@NotNull Component component, int i, int i2, int i3, int i4, @NotNull Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
        this.cA = ColorReferences.COLOR_TEAM_ALLIES_SOLID;
    }

    public void b(int i) {
        this.cA = i;
    }

    public static void onUpdate() {
        cR = cQ;
        int i = cz;
        cz = i - 1;
        if (i <= 0) {
            cQ += 10.0f;
            if (cQ >= 292.0f) {
                cz = 10;
                cR = -96.0f;
                cQ = -96.0f;
            }
        }
        cT = cS;
        cS = Mth.lerp(0.6f, cS, ay ? 1.0f : 0.0f);
    }

    @Override // com.boehmod.blockfront.C0048bs
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int x = getX();
        int y = getY();
        float f3 = this.width * 1.5f;
        C0040bk.b(poseStack, guiGraphics, R, x + i3, y + i4, f3, f3, 0.0f, C0634xm.e(cS, cT, f2) * 0.5f, this.cA);
        super.a(guiGraphics, poseStack, i, i2, f, f2);
        ay = this.isHovered;
        float fE = C0634xm.e(cQ, cR, f2);
        C0040bk.a(guiGraphics, x, y, this.width, this.height);
        C0040bk.b(poseStack, guiGraphics, Q, x + i4 + fE, y + i4, 96.0f, 96.0f, 45.0f, 0.75f);
        guiGraphics.disableScissor();
    }

    @Override // com.boehmod.blockfront.C0048bs
    public int r() {
        if (isHoveredOrFocused()) {
            return -6250336;
        }
        return ColorReferences.COLOR_WHITE_SOLID;
    }
}
