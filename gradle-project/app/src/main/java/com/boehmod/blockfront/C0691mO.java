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

/* JADX INFO: renamed from: com.boehmod.blockfront.mO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mO.class */
public class C0691mO extends AbstractC0687mK {

    /* JADX INFO: renamed from: iy */
    private static final Component f3814iy = Component.translatable("bf.message.gamemode.victory").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: iz */
    private static final Component f3815iz = Component.translatable("bf.message.gamemode.defeat").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: jd */
    public static final float f3816jd = 0.05f;

    /* JADX INFO: renamed from: je */
    public static final float f3817je = 0.05f;

    /* JADX INFO: renamed from: jf */
    public static final float f3818jf = 0.025f;

    /* JADX INFO: renamed from: jg */
    public static final float f3819jg = 4.0f;

    /* JADX INFO: renamed from: jh */
    public static final float f3820jh = 1.5f;

    /* JADX INFO: renamed from: my */
    private int f3821my = 20;

    /* JADX INFO: renamed from: mz */
    private int f3822mz = 140;

    /* JADX INFO: renamed from: jb */
    private float f3823jb = 0.0f;

    /* JADX INFO: renamed from: jc */
    private float f3824jc = 0.0f;

    /* JADX INFO: renamed from: ji */
    private float f3825ji = 0.0f;

    /* JADX INFO: renamed from: jj */
    private float f3826jj = 0.0f;

    /* JADX INFO: renamed from: iA */
    private final Component f3827iA;

    /* JADX INFO: renamed from: iB */
    private final Component f3828iB;

    public C0691mO(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Component component, boolean z) {
        MutableComponent mutableComponentWithColor = Component.literal(C1273xM.m7244p(component.getString())).withColor(ColorReferences.TROPHY_COLOR_GOLD);
        this.f3827iA = z ? f3814iy : f3815iz;
        this.f3828iB = mutableComponentWithColor;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: a */
    public boolean mo3087a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3824jc = this.f3823jb;
        this.f3826jj = this.f3825ji;
        int i = this.f3821my;
        this.f3821my = i - 1;
        if (i <= 0) {
            int i2 = this.f3822mz;
            this.f3822mz = i2 - 1;
            if (i2 <= 0) {
                this.f3823jb = C1270xJ.m7161d(this.f3823jb, 0.0f, 0.05f);
            } else {
                this.f3823jb = C1270xJ.m7161d(this.f3823jb, 1.0f, 0.05f);
            }
        }
        if (this.f3822mz <= 0 && this.f3823jb <= 0.0f) {
            this.f3825ji = C1270xJ.m7161d(this.f3825ji, 1.0f, 0.025f);
        }
        if (this.f3825ji >= 1.0f && this.f3826jj >= 1.0f) {
            AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623l.m2878a();
            if (abstractC0864pcM2878a != null) {
                abstractC0864pcM2878a.m4182a().m5901W(false);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: d */
    public void mo3088d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fM7170f = C1270xJ.m7170f(this.f3823jb, this.f3824jc, f);
        if (fM7170f >= 0.04f) {
            C0129bt.m545b(poseStack, guiGraphics, C0143cG.f1039aJ, i3, i4, 200, 200, 0.0f, 0.25f * fM7170f);
            int iM7159a = C1270xJ.m7159a(ColorReferences.COLOR_WHITE, fM7170f);
            C0129bt.m492c(poseStack, font, guiGraphics, this.f3827iA, i3, i4 - 30, iM7159a, 4.0f);
            C0129bt.m495d(poseStack, font, guiGraphics, this.f3828iB, i3 + 0.5f, i4 + 10, iM7159a, 1.5f);
        }
        C0129bt.m517a(guiGraphics, 0, 0, i, i2, 0, C1270xJ.m7170f(this.f3825ji, this.f3826jj, f));
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: r */
    public float mo3089r(float f) {
        return C1270xJ.m7170f(this.f3825ji, this.f3826jj, f);
    }
}
