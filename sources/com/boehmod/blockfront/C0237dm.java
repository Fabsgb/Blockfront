package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.profile.PacketSkipBootcamp;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dm.class */
public class C0237dm extends AbstractC0193cv {

    /* JADX INFO: renamed from: eH */
    private static final Component f1966eH = Component.translatable("bf.screen.overlay.skip.bootcamp");

    /* JADX INFO: renamed from: eI */
    private static final Component f1967eI = Component.translatable("bf.screen.overlay.skip.bootcamp.play");

    /* JADX INFO: renamed from: eJ */
    private static final Component f1968eJ = Component.translatable("bf.screen.overlay.skip.bootcamp.play.tip");

    /* JADX INFO: renamed from: eK */
    private static final Component f1969eK = Component.translatable("bf.screen.overlay.skip.bootcamp.skip");

    /* JADX INFO: renamed from: eL */
    private static final Component f1970eL = Component.translatable("bf.screen.overlay.skip.bootcamp.skip.tip");

    /* JADX INFO: renamed from: eM */
    private static final Component f1971eM = Component.translatable("bf.screen.overlay.skip.bootcamp.title").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: eN */
    private static final Component f1972eN = Component.translatable("bf.screen.overlay.skip.bootcamp.message");

    public C0237dm(@Nullable Screen screen) {
        super(screen, f1966eH);
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    protected boolean mo344a(double d, double d2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        List listSplit = this.font.split(f1972eN, 300);
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 50;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0119bk.m391b(poseStackPose, this.font, guiGraphics, f1971eM, i3, i4, 2.0f);
        C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) this.f1587b.renderBuffers().bufferSource(), (List<FormattedCharSequence>) listSplit, i3, i4 + 30, 10, false);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        int i = (this.height / 2) + 20;
        addRenderableWidget(new C0127bs(((this.width / 2) - 100) - 5, i, 100, 20, f1967eI, button -> {
            C0562jt.log("Starting search for bootcamp match", new Object[0]);
            C0280ec.m1485a(this.f1587b, this.f1586e, C1016sW.f5343b);
            m1184J();
        }).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m651a(f1968eJ).m653a(C0127bs.a.SHADOW).m640b(0));
        addRenderableWidget(new C0127bs((this.width / 2) + 5, i, 100, 20, f1969eK, button2 -> {
            C0562jt.log("Sending request to skip bootcamp", new Object[0]);
            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketSkipBootcamp());
            m1184J();
        }).m651a(f1970eL).m653a(C0127bs.a.SHADOW));
    }
}
