package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cf.class */
public class C0062cf<G extends oF<G, P, ?>, P extends oI<G>> extends AbstractC0063cg<G, P> {

    @NotNull
    private static final ResourceLocation am = C0265jv.d("textures/gui/stopwatch.png");

    @NotNull
    private FormattedCharSequence g;

    public C0062cf() {
        super(1);
        this.g = FormattedCharSequence.EMPTY;
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull oG<G, P> oGVar, @NotNull LocalPlayer localPlayer) {
        this.g = oGVar.a().d().getVisualOrderText();
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.a(guiGraphics, poseStack, font, i, i2, f);
        int i3 = i + 3;
        C0040bk.a(poseStack, guiGraphics, am, i3, i2 + 2, 11, 11);
        C0040bk.b(font, guiGraphics, this.g, i3 + 11 + 2, i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public int a(@NotNull Font font) {
        return 45;
    }
}
