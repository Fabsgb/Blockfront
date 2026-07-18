package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cU.class */
public abstract class AbstractC0156cU extends C0195cx {

    /* JADX INFO: renamed from: bd */
    private static final ResourceLocation f1274bd = C0564jv.m2555d("textures/gui/stopwatch.png");

    /* JADX INFO: renamed from: g */
    private static final MutableComponent f1275g = Component.translatable("bf.message.game.match.summary.button.skip");

    /* JADX INFO: renamed from: h */
    private static final MutableComponent f1276h = Component.translatable("bf.message.game.match.summary.button.skip.tip");

    /* JADX INFO: renamed from: fx */
    private static final int f1277fx = 256;

    /* JADX INFO: renamed from: fy */
    private static final int f1278fy = 30;

    /* JADX INFO: renamed from: fz */
    private final int f1279fz;

    /* JADX INFO: renamed from: ei */
    private int f1280ei;

    /* JADX INFO: renamed from: fA */
    private int f1281fA;

    /* JADX INFO: renamed from: bj */
    private boolean f1282bj;

    /* JADX INFO: renamed from: bk */
    private boolean f1283bk;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final UUID f1284e;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract SoundEvent mo982a();

    /* JADX INFO: renamed from: G */
    protected abstract int mo983G();

    @NotNull
    /* JADX INFO: renamed from: g */
    protected abstract Component mo984g();

    @NotNull
    /* JADX INFO: renamed from: h */
    protected abstract Component mo985h();

    @NotNull
    /* JADX INFO: renamed from: i */
    protected abstract Component mo986i();

    public AbstractC0156cU(@NotNull UUID uuid) {
        super(Component.empty());
        this.f1279fz = mo983G();
        this.f1282bj = false;
        this.f1283bk = false;
        this.f1284e = uuid;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0156cU m991a(boolean z) {
        this.f1282bj = z;
        return this;
    }

    /* JADX INFO: renamed from: x */
    public boolean mo992x() {
        return this.f1280ei >= this.f1279fz;
    }

    /* JADX INFO: renamed from: a */
    private void m993a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
        float fM7843e = (C1290xm.m7843e(this.f1280ei, this.f1281fA, f) / this.f1279fz) * this.width;
        C0119bk.m416a(poseStack, guiGraphics, 0.0f, 30.0f, this.width, 2.0f, ColorReferences.COLOR_BLACK_SOLID, 0.25f);
        C0119bk.m414a(poseStack, guiGraphics, 0.0f, 30.0f, fM7843e, 2.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        if (!this.f1282bj) {
            addRenderableWidget(new C0127bs((this.width - 5) - 50, (this.height - 5) - 20, 50, 20, f1275g, button -> {
                mo994Y();
            }).m651a((Component) f1276h).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.NONE));
        }
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: Y */
    public void mo994Y() {
        this.f1280ei = this.f1279fz;
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    @OverridingMethodsMustInvokeSuper
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = this.f1587b.font;
        if (!this.f1282bj) {
            m993a(guiGraphics, poseStackPose, f);
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = this.f1586e.m2692a();
        if (abstractC0788oGM2692a != null) {
            C0797oP c0797oPM3678a = abstractC0788oGM2692a.m3678a();
            C0119bk.m431a(poseStackPose, guiGraphics, f1274bd, 10, 7, 16, 16);
            C0119bk.m389b(poseStackPose, font, guiGraphics, (Component) c0797oPM3678a.m3894d(), 30.0f, 10.0f, ColorReferences.COLOR_WHITE, 1.5f);
        }
        C0119bk.m391b(poseStackPose, font, guiGraphics, mo984g(), i3, 6, 2.0f);
        Window window = this.f1587b.getWindow();
        MouseHandler mouseHandler = this.f1587b.mouseHandler;
        this.f1587b.gui.getChat().render(guiGraphics, this.f1587b.gui.getGuiTicks(), Mth.floor((mouseHandler.xpos() * ((double) window.getGuiScaledWidth())) / ((double) window.getScreenWidth())), Mth.floor((mouseHandler.ypos() * ((double) window.getGuiScaledHeight())) / ((double) window.getScreenHeight())), false);
        boolean zIsKeyDown = InputConstants.isKeyDown(this.f1587b.getWindow().getWindow(), this.f1587b.options.keyPlayerList.getKey().getValue());
        if (abstractC0788oGM2692a != null && this.f1587b.player != null && zIsKeyDown) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 1200.0f);
            abstractC0788oGM2692a.m3712a(poseStackPose, guiGraphics, font, this.f1587b, this.f1586e, this.f1587b.player, ((C0326fV) this.f1586e.m2670a()).m1676a(this.f1587b), this.width, this.height, f);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0119bk.m526b(this.f1587b, f);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p(), 0.25f);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, 30, C0119bk.m365p(), 0.35f);
    }

    @Override // com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        if (abstractC0787oFM2688a == null || !abstractC0787oFM2688a.m3628e().equals(this.f1284e)) {
            this.f1587b.setScreen((Screen) null);
            return;
        }
        this.f1587b.gui.getChat().tick();
        if (!this.f1283bk) {
            this.f1283bk = true;
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(mo982a(), (float) (0.800000011920929d + (0.4000000059604645d * Math.random())), 1.5f));
        }
        this.f1281fA = this.f1280ei;
        this.f1280ei++;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean keyPressed(int i, int i2, int i3) {
        if (i == this.f1587b.options.keyChat.getKey().getValue()) {
            if (C0466iC.m2100f(this.f1587b)) {
                this.f1587b.setScreen(new C0158cW(this));
                return false;
            }
            if (C0466iC.m2101X()) {
                C0466iC.m2099c(this.f1587b, C0466iC.f2882hL);
                return false;
            }
            return false;
        }
        if (i == 256) {
            this.f1587b.setScreen(new C0140cE(this));
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }
}
