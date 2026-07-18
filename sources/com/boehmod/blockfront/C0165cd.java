package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cd.class */
public class C0165cd<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0168cg<G, P> {

    /* JADX INFO: renamed from: de */
    private final int f1328de;

    /* JADX INFO: renamed from: df */
    private int f1329df;

    /* JADX INFO: renamed from: B */
    @NotNull
    private final String f1330B;

    /* JADX INFO: renamed from: al */
    @NotNull
    private final ResourceLocation f1331al;

    /* JADX INFO: renamed from: d */
    @NotNull
    private FormattedCharSequence f1332d;

    /* JADX INFO: renamed from: aQ */
    private final boolean f1333aQ;

    public C0165cd(int i, int i2, @NotNull String str, boolean z) {
        super(i2);
        this.f1332d = FormattedCharSequence.EMPTY;
        this.f1328de = i;
        this.f1330B = str;
        this.f1333aQ = z;
        this.f1331al = C0564jv.m2555d("textures/gui/game/topelement/scores/progress_" + this.f1330B.toLowerCase(Locale.ROOT) + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo319a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0788oG<G, P> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        this.f1329df = 0;
        C0796oO c0796oOM3806a = p.m3806a(this.f1330B);
        if (c0796oOM3806a != null) {
            int i = this.f1330B.equals(C1089tp.f5730da) ? ColorReferences.COLOR_TEAM_AXIS_CHAT : ColorReferences.COLOR_TEAM_ALLIES_CHAT;
            this.f1329df = c0796oOM3806a.m3866a(C1089tp.f5695l);
            this.f1332d = Component.literal(Integer.toString(this.f1329df)).withColor(i).getVisualOrderText();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        int iWidth;
        int i3;
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        int i4 = i + 2;
        int i5 = i2 + 2;
        int iA = mo322a(font) - 4;
        int iRound = Math.round(Mth.clamp(this.f1329df / this.f1328de, 0.0f, 1.0f) * (iA - 2));
        C0119bk.m415a(guiGraphics, i4 + 1, i5, iA - 2, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, i4, i5 + 1, iA, 9, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m415a(guiGraphics, i4 + 1, i5 + 9 + 1, iA - 2, 1, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m433a(poseStack, guiGraphics, this.f1331al, i4 + 1, i5 + 1, iA - 2, 9, 0.5f);
        if (iRound > 0) {
            if (this.f1333aQ) {
                i3 = ((i4 + iA) - iRound) - 1;
            } else {
                i3 = i4 + 1;
            }
            C0119bk.m517a(guiGraphics, i3, i5 + 1, iRound, 9);
            C0119bk.m431a(poseStack, guiGraphics, this.f1331al, i4 + 1, i5 + 1, iA - 2, 9);
            guiGraphics.disableScissor();
        }
        int i6 = i2 + 4;
        if (this.f1333aQ) {
            iWidth = i4 + 2;
        } else {
            iWidth = ((i4 + iA) - font.width(this.f1332d)) - 2;
        }
        C0119bk.m405b(font, guiGraphics, this.f1332d, iWidth, i6, ColorReferences.COLOR_WHITE_SOLID);
    }
}
