package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cU.class */
public abstract class cU extends C0080cx {
    private static final ResourceLocation bd = C0265jv.d("textures/gui/stopwatch.png");
    private static final MutableComponent g = Component.translatable("bf.message.game.match.summary.button.skip");
    private static final MutableComponent h = Component.translatable("bf.message.game.match.summary.button.skip.tip");
    private static final int fx = 256;
    private static final int fy = 30;
    private final int fz;
    private int ei;
    private int fA;
    private boolean bj;
    private boolean bk;

    @NotNull
    private final UUID e;

    @NotNull
    protected abstract SoundEvent a();

    protected abstract int G();

    @NotNull
    protected abstract Component g();

    @NotNull
    protected abstract Component h();

    @NotNull
    protected abstract Component i();

    public cU(@NotNull UUID uuid) {
        super(Component.empty());
        this.fz = G();
        this.bj = false;
        this.bk = false;
        this.e = uuid;
    }

    @NotNull
    public cU a(boolean z) {
        this.bj = z;
        return this;
    }

    public boolean x() {
        return this.ei >= this.fz;
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, float f) {
        float fE = (C0634xm.e(this.ei, this.fA, f) / this.fz) * this.width;
        C0040bk.a(poseStack, guiGraphics, 0.0f, 30.0f, this.width, 2.0f, ColorReferences.COLOR_BLACK_SOLID, 0.25f);
        C0040bk.a(poseStack, guiGraphics, 0.0f, 30.0f, fE, 2.0f, ColorReferences.COLOR_STOPWATCH_SOLID);
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G, reason: collision with other method in class */
    public void mo280G() {
        super.mo280G();
        if (!this.bj) {
            addRenderableWidget(new C0048bs((this.width - 5) - 50, (this.height - 5) - 20, 50, 20, g, button -> {
                Y();
            }).a((Component) h).a(C0048bs.c.SHADOW).a(C0048bs.a.NONE));
        }
    }

    @OverridingMethodsMustInvokeSuper
    public void Y() {
        this.ei = this.fz;
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    @OverridingMethodsMustInvokeSuper
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        PoseStack poseStackPose = guiGraphics.pose();
        Font font = this.b.font;
        if (!this.bj) {
            a(guiGraphics, poseStackPose, f);
        }
        oG<?, ?> oGVarM593a = this.e.m593a();
        if (oGVarM593a != null) {
            oP oPVarA = oGVarM593a.a();
            C0040bk.a(poseStackPose, guiGraphics, bd, 10, 7, 16, 16);
            C0040bk.b(poseStackPose, font, guiGraphics, (Component) oPVarA.d(), 30.0f, 10.0f, ColorReferences.COLOR_WHITE, 1.5f);
        }
        C0040bk.b(poseStackPose, font, guiGraphics, g(), i3, 6, 2.0f);
        Window window = this.b.getWindow();
        MouseHandler mouseHandler = this.b.mouseHandler;
        this.b.gui.getChat().render(guiGraphics, this.b.gui.getGuiTicks(), Mth.floor((mouseHandler.xpos() * ((double) window.getGuiScaledWidth())) / ((double) window.getScreenWidth())), Mth.floor((mouseHandler.ypos() * ((double) window.getGuiScaledHeight())) / ((double) window.getScreenHeight())), false);
        boolean zIsKeyDown = InputConstants.isKeyDown(this.b.getWindow().getWindow(), this.b.options.keyPlayerList.getKey().getValue());
        if (oGVarM593a != null && this.b.player != null && zIsKeyDown) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 1200.0f);
            oGVarM593a.a(poseStackPose, guiGraphics, font, this.b, this.e, this.b.player, ((fV) this.e.a()).m404a(this.b), this.width, this.height, f);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0040bk.b(this.b, f);
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p(), 0.25f);
        C0040bk.a(guiGraphics, 0, 0, this.width, 30, C0040bk.p(), 0.35f);
    }

    @Override // com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        if (oFVarM591a == null || !oFVarM591a.m757e().equals(this.e)) {
            this.b.setScreen((Screen) null);
            return;
        }
        this.b.gui.getChat().tick();
        if (!this.bk) {
            this.bk = true;
            this.b.getSoundManager().play(SimpleSoundInstance.forUI(a(), (float) (0.800000011920929d + (0.4000000059604645d * Math.random())), 1.5f));
        }
        this.fA = this.ei;
        this.ei++;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean keyPressed(int i, int i2, int i3) {
        if (i == this.b.options.keyChat.getKey().getValue()) {
            if (iC.f(this.b)) {
                this.b.setScreen(new cW(this));
                return false;
            }
            if (iC.X()) {
                iC.c(this.b, iC.hL);
                return false;
            }
            return false;
        }
        if (i == 256) {
            this.b.setScreen(new cE(this));
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }
}
