package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cm.class */
public class C0179cm<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0188cp<G, P> {

    /* JADX INFO: renamed from: dX */
    private final int f1376dX;

    /* JADX INFO: renamed from: dY */
    private int f1377dY;

    /* JADX INFO: renamed from: G */
    @NotNull
    private final String f1378G;

    /* JADX INFO: renamed from: al */
    @NotNull
    private final ResourceLocation f1379al;

    /* JADX INFO: renamed from: d */
    @NotNull
    private FormattedCharSequence f1380d;

    /* JADX INFO: renamed from: dZ */
    private int f1381dZ;

    /* JADX INFO: renamed from: ea */
    private int f1382ea;

    /* JADX INFO: renamed from: aV */
    private final boolean f1383aV;

    public C0179cm(int i, int i2, @NotNull String str, boolean z) {
        super(i2);
        this.f1380d = FormattedCharSequence.EMPTY;
        this.f1381dZ = Integer.MIN_VALUE;
        this.f1382ea = 0;
        this.f1376dX = i;
        this.f1378G = str;
        this.f1383aV = z;
        this.f1379al = C0532jO.m2378d("textures/gui/game/topelement/scores/progress_" + this.f1378G.toLowerCase(Locale.ROOT) + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1042a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0864pc<G, P> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        this.f1377dY = 0;
        C0872pk c0872pkM4242a = p.m4242a(this.f1378G);
        if (c0872pkM4242a != null) {
            this.f1377dY = c0872pkM4242a.m4302a(C1062tN.f5748l);
            if (this.f1377dY != this.f1381dZ) {
                this.f1381dZ = this.f1377dY;
                this.f1380d = Component.literal(Integer.toString(this.f1377dY)).withColor(this.f1378G.equals(C1062tN.f5783dl) ? ColorReferences.COLOR_TEAM_AXIS_CHAT : ColorReferences.COLOR_TEAM_ALLIES_CHAT).getVisualOrderText();
                this.f1382ea = minecraft.font.width(this.f1380d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        int i3;
        int i4;
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        int i5 = i + 2;
        int i6 = i2 + 2;
        int iA = mo1045a(font) - 4;
        int iRound = Math.round(Mth.clamp(this.f1377dY / this.f1376dX, 0.0f, 1.0f) * (iA - 2));
        C0129bt.m518b(guiGraphics, i5, i6, iA, 11, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m533a(poseStack, guiGraphics, this.f1379al, i5 + 1, i6 + 1, iA - 2, 9, 0.5f);
        if (iRound > 0) {
            if (this.f1383aV) {
                i4 = ((i5 + iA) - iRound) - 1;
            } else {
                i4 = i5 + 1;
            }
            C0129bt.m618a(guiGraphics, i4, i6 + 1, iRound, 9);
            C0129bt.m531a(poseStack, guiGraphics, this.f1379al, i5 + 1, i6 + 1, iA - 2, 9);
            guiGraphics.disableScissor();
        }
        int i7 = i2 + 4;
        if (this.f1383aV) {
            i3 = i5 + 2;
        } else {
            i3 = ((i5 + iA) - this.f1382ea) - 2;
        }
        C0129bt.m505b(font, guiGraphics, this.f1380d, i3, i7, ColorReferences.COLOR_WHITE_SOLID);
    }
}
