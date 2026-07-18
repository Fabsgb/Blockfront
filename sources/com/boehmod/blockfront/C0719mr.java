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

/* JADX INFO: renamed from: com.boehmod.blockfront.mr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mr.class */
public class C0719mr extends AbstractC0716mo {

    /* JADX INFO: renamed from: ic */
    public static final float f3849ic = 0.05f;

    /* JADX INFO: renamed from: id */
    public static final float f3850id = 0.05f;

    /* JADX INFO: renamed from: ie */
    public static final float f3851ie = 0.025f;

    /* JADX INFO: renamed from: if */
    public static final float f3852if = 4.0f;

    /* JADX INFO: renamed from: ig */
    public static final float f3853ig = 1.5f;

    /* JADX INFO: renamed from: ik */
    private final Component f3860ik;

    /* JADX INFO: renamed from: il */
    private final Component f3861il;

    /* JADX INFO: renamed from: kD */
    private int f3856kD = 40;

    /* JADX INFO: renamed from: kE */
    private int f3857kE = 160;

    /* JADX INFO: renamed from: ih */
    private float f3854ih = 1.0f;

    /* JADX INFO: renamed from: ii */
    private float f3855ii = 1.0f;

    /* JADX INFO: renamed from: ij */
    private float f3858ij = 0.0f;

    /* JADX INFO: renamed from: ik */
    private float f3859ik = 0.0f;

    public C0719mr(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        MutableComponent mutableComponentWithColor = Component.literal(C1293xp.m7917p(abstractC0787oF.getDisplayName().getString())).withColor(ColorReferences.TROPHY_COLOR_GOLD);
        this.f3860ik = Component.literal(abstractC0787oF.m3591a().getName()).copy().withStyle(C0565jw.f3201b);
        this.f3861il = mutableComponentWithColor;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: a */
    public boolean mo3254a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3855ii = this.f3854ih;
        this.f3859ik = this.f3858ij;
        this.f3854ih = C1290xm.m7835d(this.f3854ih, 0.0f, 0.025f);
        int i = this.f3856kD;
        this.f3856kD = i - 1;
        if (i <= 0) {
            int i2 = this.f3857kE;
            this.f3857kE = i2 - 1;
            if (i2 <= 0) {
                this.f3858ij = C1290xm.m7835d(this.f3858ij, 0.0f, 0.05f);
            } else {
                this.f3858ij = C1290xm.m7835d(this.f3858ij, 1.0f, 0.05f);
            }
        }
        return this.f3857kE <= 0 && this.f3858ij <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: d */
    public void mo3255d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fM7843e = C1290xm.m7843e(this.f3858ij, this.f3859ik, f);
        if (fM7843e >= 0.04f) {
            C0119bk.m445b(poseStack, guiGraphics, C0195cx.f1566aJ, i3, i4, 200, 200, 0.0f, 0.25f * fM7843e);
            int iM7833a = C1290xm.m7833a(ColorReferences.COLOR_WHITE, fM7843e);
            C0119bk.m392c(poseStack, font, guiGraphics, this.f3860ik, i3, i4 - 30, iM7833a, 4.0f);
            C0119bk.m395d(poseStack, font, guiGraphics, this.f3861il, i3 + 0.5f, i4 + 10, iM7833a, 1.5f);
        }
        C0119bk.m417a(guiGraphics, 0, 0, i, i2, 0, C1290xm.m7843e(this.f3854ih, this.f3855ii, f));
    }
}
