package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dT.class */
public class dT extends dM {

    @NotNull
    private static final Component gY = Component.translatable("bf.message.no");

    @NotNull
    private static final Component gZ = Component.translatable("bf.message.yes");

    @NotNull
    private final dJ a;

    public dT(@Nullable Screen screen, @NotNull Component component, @NotNull dJ dJVar) {
        super(screen, component);
        this.a = dJVar;
    }

    @Override // com.boehmod.blockfront.dM
    public dT a() {
        this.bG = false;
        return this;
    }

    protected void t(boolean z) {
        this.a.onResult(z);
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.B.size()) + 6;
        addRenderableWidget(new C0048bs(i + 2, size, 80, 20, gY, button -> {
            if (this.bG) {
                J();
            }
            t(false);
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
        addRenderableWidget(new C0048bs(((i + dM.gZ) - 80) - 2, size, 80, 20, gZ, button2 -> {
            if (this.bG) {
                J();
            }
            t(true);
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = (this.width / 2) - 95;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        c(guiGraphics, i3, 80);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.dM
    protected int E() {
        return 0;
    }
}
