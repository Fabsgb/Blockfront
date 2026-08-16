package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.profile.PacketSkipBootcamp;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dv.class */
public class C0247dv extends AbstractC0141cE {

    /* JADX INFO: renamed from: eK */
    private static final Component f2030eK = Component.translatable("bf.screen.overlay.skip.bootcamp");

    /* JADX INFO: renamed from: eL */
    private static final Component f2031eL = Component.translatable("bf.screen.overlay.skip.bootcamp.play");

    /* JADX INFO: renamed from: eM */
    private static final Component f2032eM = Component.translatable("bf.screen.overlay.skip.bootcamp.play.tip");

    /* JADX INFO: renamed from: eN */
    private static final Component f2033eN = Component.translatable("bf.screen.overlay.skip.bootcamp.skip");

    /* JADX INFO: renamed from: eO */
    private static final Component f2034eO = Component.translatable("bf.screen.overlay.skip.bootcamp.skip.tip");

    /* JADX INFO: renamed from: eP */
    private static final Component f2035eP = Component.translatable("bf.screen.overlay.skip.bootcamp.title").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: eQ */
    private static final Component f2036eQ = Component.translatable("bf.screen.overlay.skip.bootcamp.message");

    public C0247dv(@Nullable Screen screen) {
        super(screen, f2030eK);
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    protected boolean mo437a(double d, double d2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        List listSplit = this.font.split(f2036eQ, 300);
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 50;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0129bt.m491b(poseStackPose, this.font, guiGraphics, f2035eP, i3, i4, 2.0f);
        C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) this.f1058a.renderBuffers().bufferSource(), (List<FormattedCharSequence>) listSplit, i3, i4 + 30, 10, false);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        int i = (this.height / 2) + 20;
        addRenderableWidget(new C0085bB(((this.width / 2) - 100) - 5, i, 100, 20, f2031eL, button -> {
            C0530jM.log("Starting search for bootcamp match", new Object[0]);
            C0293eo.m1601a(this.f1058a, this.f1057f, C1094tt.f5907b);
            m782N();
        }).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m326a(f2032eM).m328a(C0085bB.a.SHADOW).m315b(0));
        addRenderableWidget(new C0085bB((this.width / 2) + 5, i, 100, 20, f2033eN, button2 -> {
            C0530jM.log("Sending request to skip bootcamp", new Object[0]);
            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketSkipBootcamp());
            m782N();
        }).m326a(f2034eO).m328a(C0085bB.a.SHADOW));
    }
}
