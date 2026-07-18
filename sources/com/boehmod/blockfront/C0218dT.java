package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dT.class */
public class C0218dT extends AbstractC0211dM {

    /* JADX INFO: renamed from: gY */
    @NotNull
    private static final Component f1786gY = Component.translatable("bf.message.no");

    /* JADX INFO: renamed from: gZ */
    @NotNull
    private static final Component f1787gZ = Component.translatable("bf.message.yes");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final InterfaceC0208dJ f1788a;

    public C0218dT(@Nullable Screen screen, @NotNull Component component, @NotNull InterfaceC0208dJ interfaceC0208dJ) {
        super(screen, component);
        this.f1788a = interfaceC0208dJ;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: a */
    public C0218dT mo1272a() {
        this.f1748bG = false;
        return this;
    }

    /* JADX INFO: renamed from: t */
    protected void m1286t(boolean z) {
        this.f1788a.onResult(z);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.f1744B.size()) + 6;
        addRenderableWidget(new C0127bs(i + 2, size, 80, 20, f1786gY, button -> {
            if (this.f1748bG) {
                mo1276J();
            }
            m1286t(false);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        addRenderableWidget(new C0127bs(((i + AbstractC0211dM.f1737gZ) - 80) - 2, size, 80, 20, f1787gZ, button2 -> {
            if (this.f1748bG) {
                mo1276J();
            }
            m1286t(true);
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = (this.width / 2) - 95;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        m1275c(guiGraphics, i3, 80);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: E */
    protected int mo859E() {
        return 0;
    }
}
