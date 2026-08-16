package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ee */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ee.class */
public class C0283ee extends AbstractC0223dX {

    /* JADX INFO: renamed from: he */
    @NotNull
    private static final Component f2227he = Component.translatable("bf.message.no");

    /* JADX INFO: renamed from: hf */
    @NotNull
    private static final Component f2228hf = Component.translatable("bf.message.yes");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final InterfaceC0220dU f2229a;

    public C0283ee(@Nullable Screen screen, @NotNull Component component, @NotNull InterfaceC0220dU interfaceC0220dU) {
        super(screen, component);
        this.f2229a = interfaceC0220dU;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: a */
    public C0283ee mo1323a() {
        this.f1777bN = false;
        return this;
    }

    /* JADX INFO: renamed from: t */
    protected void m1548t(boolean z) {
        this.f2229a.onResult(z);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.f1773D.size()) + 6;
        addRenderableWidget(new C0085bB(i + 2, size, 80, 20, f2227he, button -> {
            if (this.f1777bN) {
                m1327N();
            }
            m1548t(false);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        addRenderableWidget(new C0085bB(((i + AbstractC0223dX.f1766ij) - 80) - 2, size, 80, 20, f2228hf, button2 -> {
            if (this.f1777bN) {
                m1327N();
            }
            m1548t(true);
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = (this.width / 2) - 95;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        m1326c(guiGraphics, i3, 80);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: I */
    protected int mo913I() {
        return 0;
    }
}
