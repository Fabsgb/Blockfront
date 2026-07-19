package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ce, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ce.class */
public class C0061ce<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0063cg<G, P> {

    @NotNull
    private FormattedCharSequence e;

    @NotNull
    private FormattedCharSequence f;

    public C0061ce() {
        super(1);
        this.e = FormattedCharSequence.EMPTY;
        this.f = FormattedCharSequence.EMPTY;
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull oG<G, P> oGVar, @NotNull LocalPlayer localPlayer) {
        if (p.a(C0529tp.da) != null) {
            this.e = Component.literal(C0637xp.a(r0.a(C0529tp.l))).withColor(ColorReferences.COLOR_TEAM_AXIS).getVisualOrderText();
        }
        if (p.a(C0529tp.cZ) != null) {
            this.f = Component.literal(C0637xp.a(r0.a(C0529tp.l))).withColor(ColorReferences.COLOR_TEAM_ALLIES).getVisualOrderText();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.a(guiGraphics, poseStack, font, i, i2, f);
        C0040bk.a(poseStack, guiGraphics, (i + (a(font) / 2)) - 0.5f, i2 + 2, 1.0f, 11.0f, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        C0040bk.a(poseStack, font, guiGraphics, this.f, i + 1 + (r0 / 2), i2 + 4);
        C0040bk.a(poseStack, font, guiGraphics, this.e, r0 + (r0 / 2), i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public int a(@NotNull Font font) {
        return 48;
    }
}
