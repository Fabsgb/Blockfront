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

/* JADX INFO: renamed from: com.boehmod.blockfront.ms */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ms.class */
public class C0720ms extends AbstractC0716mo {

    /* JADX INFO: renamed from: im */
    private static final Component f3862im = Component.translatable("bf.message.gamemode.victory").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: in */
    private static final Component f3863in = Component.translatable("bf.message.gamemode.defeat").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: il */
    public static final float f3864il = 0.05f;

    /* JADX INFO: renamed from: im */
    public static final float f3865im = 0.05f;

    /* JADX INFO: renamed from: in */
    public static final float f3866in = 0.025f;

    /* JADX INFO: renamed from: io */
    public static final float f3867io = 4.0f;

    /* JADX INFO: renamed from: ip */
    public static final float f3868ip = 1.5f;

    /* JADX INFO: renamed from: kD */
    private int f3869kD = 20;

    /* JADX INFO: renamed from: kE */
    private int f3870kE = 140;

    /* JADX INFO: renamed from: ij */
    private float f3871ij = 0.0f;

    /* JADX INFO: renamed from: ik */
    private float f3872ik = 0.0f;

    /* JADX INFO: renamed from: iq */
    private float f3873iq = 0.0f;

    /* JADX INFO: renamed from: ir */
    private float f3874ir = 0.0f;

    /* JADX INFO: renamed from: io */
    private final Component f3875io;

    /* JADX INFO: renamed from: ip */
    private final Component f3876ip;

    public C0720ms(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Component component, boolean z) {
        MutableComponent mutableComponentWithColor = Component.literal(C1293xp.m7917p(component.getString())).withColor(ColorReferences.TROPHY_COLOR_GOLD);
        this.f3875io = z ? f3862im : f3863in;
        this.f3876ip = mutableComponentWithColor;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: a */
    public boolean mo3254a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3872ik = this.f3871ij;
        this.f3874ir = this.f3873iq;
        int i = this.f3869kD;
        this.f3869kD = i - 1;
        if (i <= 0) {
            int i2 = this.f3870kE;
            this.f3870kE = i2 - 1;
            if (i2 <= 0) {
                this.f3871ij = C1290xm.m7835d(this.f3871ij, 0.0f, 0.05f);
            } else {
                this.f3871ij = C1290xm.m7835d(this.f3871ij, 1.0f, 0.05f);
            }
        }
        if (this.f3870kE <= 0 && this.f3871ij <= 0.0f) {
            this.f3873iq = C1290xm.m7835d(this.f3873iq, 1.0f, 0.025f);
        }
        if (this.f3873iq >= 1.0f && this.f3874ir >= 1.0f) {
            AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622l.m2692a();
            if (abstractC0788oGM2692a != null) {
                abstractC0788oGM2692a.m3746a().m6015V(false);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: d */
    public void mo3255d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        float fM7843e = C1290xm.m7843e(this.f3871ij, this.f3872ik, f);
        if (fM7843e >= 0.04f) {
            C0119bk.m445b(poseStack, guiGraphics, C0195cx.f1566aJ, i3, i4, 200, 200, 0.0f, 0.25f * fM7843e);
            int iM7833a = C1290xm.m7833a(ColorReferences.COLOR_WHITE, fM7843e);
            C0119bk.m392c(poseStack, font, guiGraphics, this.f3875io, i3, i4 - 30, iM7833a, 4.0f);
            C0119bk.m395d(poseStack, font, guiGraphics, this.f3876ip, i3 + 0.5f, i4 + 10, iM7833a, 1.5f);
        }
        C0119bk.m417a(guiGraphics, 0, 0, i, i2, 0, C1290xm.m7843e(this.f3873iq, this.f3874ir, f));
    }
}
