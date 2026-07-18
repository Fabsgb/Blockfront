package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ce */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ce.class */
public class C0166ce<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0168cg<G, P> {

    /* JADX INFO: renamed from: e */
    @NotNull
    private FormattedCharSequence f1334e;

    /* JADX INFO: renamed from: f */
    @NotNull
    private FormattedCharSequence f1335f;

    public C0166ce() {
        super(1);
        this.f1334e = FormattedCharSequence.EMPTY;
        this.f1335f = FormattedCharSequence.EMPTY;
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo319a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0788oG<G, P> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        if (p.m3806a(C1089tp.f5730da) != null) {
            this.f1334e = Component.literal(C1293xp.m7912a(r0.m3866a(C1089tp.f5695l))).withColor(ColorReferences.COLOR_TEAM_AXIS).getVisualOrderText();
        }
        if (p.m3806a(C1089tp.f5729cZ) != null) {
            this.f1335f = Component.literal(C1293xp.m7912a(r0.m3866a(C1089tp.f5695l))).withColor(ColorReferences.COLOR_TEAM_ALLIES).getVisualOrderText();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        C0119bk.m416a(poseStack, guiGraphics, (i + (mo322a(font) / 2)) - 0.5f, i2 + 2, 1.0f, 11.0f, ColorReferences.COLOR_WHITE_SOLID, 0.25f);
        C0119bk.m409a(poseStack, font, guiGraphics, this.f1335f, i + 1 + (r0 / 2), i2 + 4);
        C0119bk.m409a(poseStack, font, guiGraphics, this.f1334e, r0 + (r0 / 2), i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        return 48;
    }
}
