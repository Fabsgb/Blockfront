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

/* JADX INFO: renamed from: com.boehmod.blockfront.mN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mN.class */
public class C0690mN extends AbstractC0687mK {

    /* JADX INFO: renamed from: iU */
    public static final float f3801iU = 0.05f;

    /* JADX INFO: renamed from: iV */
    public static final float f3802iV = 0.05f;

    /* JADX INFO: renamed from: iW */
    public static final float f3803iW = 0.025f;

    /* JADX INFO: renamed from: iX */
    public static final float f3804iX = 4.0f;

    /* JADX INFO: renamed from: iY */
    public static final float f3805iY = 1.5f;

    /* JADX INFO: renamed from: iw */
    private final Component f3812iw;

    /* JADX INFO: renamed from: ix */
    private final Component f3813ix;

    /* JADX INFO: renamed from: my */
    private int f3808my = 40;

    /* JADX INFO: renamed from: mz */
    private int f3809mz = 160;

    /* JADX INFO: renamed from: iZ */
    private float f3806iZ = 1.0f;

    /* JADX INFO: renamed from: ja */
    private float f3807ja = 1.0f;

    /* JADX INFO: renamed from: jb */
    private float f3810jb = 0.0f;

    /* JADX INFO: renamed from: jc */
    private float f3811jc = 0.0f;

    public C0690mN(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        MutableComponent mutableComponentWithColor = Component.literal(C1273xM.m7244p(abstractC0863pb.getDisplayName().getString())).withColor(ColorReferences.TROPHY_COLOR_GOLD);
        this.f3812iw = Component.literal(abstractC0863pb.m4027a().getName()).copy().withStyle(C0533jP.f3185b);
        this.f3813ix = mutableComponentWithColor;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: a */
    public boolean mo3087a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3807ja = this.f3806iZ;
        this.f3811jc = this.f3810jb;
        this.f3806iZ = C1270xJ.m7161d(this.f3806iZ, 0.0f, 0.025f);
        int i = this.f3808my;
        this.f3808my = i - 1;
        if (i <= 0) {
            int i2 = this.f3809mz;
            this.f3809mz = i2 - 1;
            if (i2 <= 0) {
                this.f3810jb = C1270xJ.m7161d(this.f3810jb, 0.0f, 0.05f);
            } else {
                this.f3810jb = C1270xJ.m7161d(this.f3810jb, 1.0f, 0.05f);
            }
        }
        return this.f3809mz <= 0 && this.f3810jb <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: d */
    public void mo3088d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fM7170f = C1270xJ.m7170f(this.f3810jb, this.f3811jc, f);
        if (fM7170f >= 0.04f) {
            C0129bt.m545b(poseStack, guiGraphics, C0143cG.f1039aJ, i3, i4, 200, 200, 0.0f, 0.25f * fM7170f);
            int iM7159a = C1270xJ.m7159a(ColorReferences.COLOR_WHITE, fM7170f);
            C0129bt.m492c(poseStack, font, guiGraphics, this.f3812iw, i3, i4 - 30, iM7159a, 4.0f);
            C0129bt.m495d(poseStack, font, guiGraphics, this.f3813ix, i3 + 0.5f, i4 + 10, iM7159a, 1.5f);
        }
        C0129bt.m517a(guiGraphics, 0, 0, i, i2, 0, C1270xJ.m7170f(this.f3806iZ, this.f3807ja, f));
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: r */
    public float mo3089r(float f) {
        return C1270xJ.m7170f(this.f3806iZ, this.f3807ja, f);
    }
}
