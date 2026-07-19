package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.profile.PacketSkipBootcamp;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dm.class */
public class C0096dm extends AbstractC0078cv {
    private static final Component eH = Component.translatable("bf.screen.overlay.skip.bootcamp");
    private static final Component eI = Component.translatable("bf.screen.overlay.skip.bootcamp.play");
    private static final Component eJ = Component.translatable("bf.screen.overlay.skip.bootcamp.play.tip");
    private static final Component eK = Component.translatable("bf.screen.overlay.skip.bootcamp.skip");
    private static final Component eL = Component.translatable("bf.screen.overlay.skip.bootcamp.skip.tip");
    private static final Component eM = Component.translatable("bf.screen.overlay.skip.bootcamp.title").withStyle(C0266jw.b);
    private static final Component eN = Component.translatable("bf.screen.overlay.skip.bootcamp.message");

    public C0096dm(@Nullable Screen screen) {
        super(screen, eH);
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv
    protected boolean a(double d, double d2) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0078cv, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        List listSplit = this.font.split(eN, 300);
        int i3 = this.width / 2;
        int i4 = (this.height / 2) - 50;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        C0040bk.b(poseStackPose, this.font, guiGraphics, eM, i3, i4, 2.0f);
        C0040bk.a(poseStackPose, this.font, (MultiBufferSource) this.b.renderBuffers().bufferSource(), (List<FormattedCharSequence>) listSplit, i3, i4 + 30, 10, false);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        int i = (this.height / 2) + 20;
        addRenderableWidget(new C0048bs(((this.width / 2) - 100) - 5, i, 100, 20, eI, button -> {
            C0263jt.log("Starting search for bootcamp match", new Object[0]);
            C0112ec.a(this.b, this.e, sW.b);
            J();
        }).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).a(eJ).a(C0048bs.a.SHADOW).b(0));
        addRenderableWidget(new C0048bs((this.width / 2) + 5, i, 100, 20, eK, button2 -> {
            C0263jt.log("Sending request to skip bootcamp", new Object[0]);
            ((C0163g) this.e.b()).sendPacket(new PacketSkipBootcamp());
            J();
        }).a(eL).a(C0048bs.a.SHADOW));
    }
}
