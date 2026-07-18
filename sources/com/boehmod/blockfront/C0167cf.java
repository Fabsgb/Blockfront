package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cf.class */
public class C0167cf<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> extends AbstractC0168cg<G, P> {

    /* JADX INFO: renamed from: am */
    @NotNull
    private static final ResourceLocation f1336am = C0564jv.m2555d("textures/gui/stopwatch.png");

    /* JADX INFO: renamed from: g */
    @NotNull
    private FormattedCharSequence f1337g;

    public C0167cf() {
        super(1);
        this.f1337g = FormattedCharSequence.EMPTY;
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo319a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0788oG<G, P> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        this.f1337g = abstractC0788oG.m3678a().m3894d().getVisualOrderText();
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        int i3 = i + 3;
        C0119bk.m431a(poseStack, guiGraphics, f1336am, i3, i2 + 2, 11, 11);
        C0119bk.m404b(font, guiGraphics, this.f1337g, i3 + 11 + 2, i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        return 45;
    }
}
