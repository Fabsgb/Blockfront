package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cd.class */
public class C0060cd<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0063cg<G, P> {

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private final int f411de;
    private int df;

    @NotNull
    private final String B;

    @NotNull
    private final ResourceLocation al;

    @NotNull
    private FormattedCharSequence d;
    private final boolean aQ;

    public C0060cd(int i, int i2, @NotNull String str, boolean z) {
        super(i2);
        this.d = FormattedCharSequence.EMPTY;
        this.f411de = i;
        this.B = str;
        this.aQ = z;
        this.al = C0265jv.d("textures/gui/game/topelement/scores/progress_" + this.B.toLowerCase(Locale.ROOT) + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull oG<G, P> oGVar, @NotNull LocalPlayer localPlayer) {
        this.df = 0;
        oO oOVarA = p.a(this.B);
        if (oOVarA != null) {
            int i = this.B.equals(C0529tp.da) ? ColorReferences.COLOR_TEAM_AXIS_CHAT : ColorReferences.COLOR_TEAM_ALLIES_CHAT;
            this.df = oOVarA.a(C0529tp.l);
            this.d = Component.literal(Integer.toString(this.df)).withColor(i).getVisualOrderText();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        int iWidth;
        int i3;
        super.a(guiGraphics, poseStack, font, i, i2, f);
        int i4 = i + 2;
        int i5 = i2 + 2;
        int iA = a(font) - 4;
        int iRound = Math.round(Mth.clamp(this.df / this.f411de, 0.0f, 1.0f) * (iA - 2));
        C0040bk.a(guiGraphics, i4 + 1, i5, iA - 2, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, i4, i5 + 1, iA, 9, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(guiGraphics, i4 + 1, i5 + 9 + 1, iA - 2, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(poseStack, guiGraphics, this.al, i4 + 1, i5 + 1, iA - 2, 9, 0.5f);
        if (iRound > 0) {
            if (this.aQ) {
                i3 = ((i4 + iA) - iRound) - 1;
            } else {
                i3 = i4 + 1;
            }
            C0040bk.a(guiGraphics, i3, i5 + 1, iRound, 9);
            C0040bk.a(poseStack, guiGraphics, this.al, i4 + 1, i5 + 1, iA - 2, 9);
            guiGraphics.disableScissor();
        }
        int i6 = i2 + 4;
        if (this.aQ) {
            iWidth = i4 + 2;
        } else {
            iWidth = ((i4 + iA) - font.width(this.d)) - 2;
        }
        C0040bk.b(font, guiGraphics, this.d, iWidth, i6, ColorReferences.COLOR_WHITE_SOLID);
    }
}
