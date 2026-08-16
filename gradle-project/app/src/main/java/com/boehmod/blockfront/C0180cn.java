package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cn.class */
public class C0180cn<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0188cp<G, P> {

    /* JADX INFO: renamed from: e */
    @NotNull
    private FormattedCharSequence f1384e;

    /* JADX INFO: renamed from: f */
    @NotNull
    private FormattedCharSequence f1385f;

    /* JADX INFO: renamed from: eb */
    private int f1386eb;

    /* JADX INFO: renamed from: ec */
    private int f1387ec;

    public C0180cn() {
        super(1);
        this.f1384e = FormattedCharSequence.EMPTY;
        this.f1385f = FormattedCharSequence.EMPTY;
        this.f1386eb = Integer.MIN_VALUE;
        this.f1387ec = Integer.MIN_VALUE;
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1042a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0864pc<G, P> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        int iM4302a;
        int iM4302a2;
        C0872pk c0872pkM4242a = p.m4242a(C1062tN.f5783dl);
        if (c0872pkM4242a != null && (iM4302a2 = c0872pkM4242a.m4302a(C1062tN.f5748l)) != this.f1386eb) {
            this.f1386eb = iM4302a2;
            this.f1384e = Component.literal(C1273xM.m7239b(iM4302a2)).withColor(ColorReferences.COLOR_TEAM_AXIS).getVisualOrderText();
        }
        C0872pk c0872pkM4242a2 = p.m4242a(C1062tN.f5782dk);
        if (c0872pkM4242a2 != null && (iM4302a = c0872pkM4242a2.m4302a(C1062tN.f5748l)) != this.f1387ec) {
            this.f1387ec = iM4302a;
            this.f1385f = Component.literal(C1273xM.m7239b(iM4302a)).withColor(ColorReferences.COLOR_TEAM_ALLIES).getVisualOrderText();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        int iMo1045a = mo1045a(font) / 2;
        int i3 = i + iMo1045a;
        C0129bt.m516a(poseStack, guiGraphics, i3 - 0.5f, i2 + 2, 1.0f, 11.0f, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        C0129bt.m509a(poseStack, font, guiGraphics, this.f1385f, i + 1 + (iMo1045a / 2), i2 + 4);
        C0129bt.m509a(poseStack, font, guiGraphics, this.f1384e, i3 + (iMo1045a / 2), i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        return 48;
    }
}
