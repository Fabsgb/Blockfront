package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cv.class */
public abstract class AbstractC0078cv extends C0080cx {
    protected static float dB = 0.0f;

    @Nullable
    public final Screen c;
    public boolean aU;
    protected float dC;
    protected float dD;
    protected float cS;
    protected float cT;
    private boolean aV;

    protected abstract boolean a(double d, double d2);

    public AbstractC0078cv(@Nullable Screen screen, @NotNull Component component) {
        super(component);
        this.aU = true;
        this.dD = 0.0f;
        this.cT = 0.0f;
        this.aV = false;
        this.c = screen;
    }

    public AbstractC0078cv(@NotNull Screen screen, @NotNull Component component, boolean z) {
        this(screen, component);
        this.aU = z;
    }

    @Nonnull
    public AbstractC0078cv a(boolean z) {
        this.aV = z;
        return this;
    }

    private void I() {
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pl.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        J();
    }

    public float h(float f) {
        return C0634xm.e(this.dC, this.dD, f);
    }

    public void a(@NotNull GuiGraphics guiGraphics, float f) {
    }

    public void J() {
        Screen screen = this.c;
        if (screen instanceof AbstractC0078cv) {
            ((AbstractC0078cv) screen).aU = true;
        }
        this.b.setScreen(this.c);
    }

    @Override // com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void init() {
        super.init();
        dB = this.width / 4.0f;
        if (!this.aU) {
            float f = dB;
            this.dD = f;
            this.dC = f;
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        fV fVVar = (fV) this.e.a();
        iS iSVarM404a = fVVar.m404a(this.b);
        if (this.c != null && (this.c.width != this.width || this.c.height != this.height)) {
            this.c.init(this.b, this.width, this.height);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, -400.0f);
        if (this.c != null) {
            this.c.render(guiGraphics, i, i2, f);
            if (this.aV) {
                C0040bk.b(this.b, f);
            }
        }
        poseStackPose.popPose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        renderBackground(guiGraphics, i, i2, f);
        poseStackPose.pushPose();
        poseStackPose.translate(h(f), 0.0f, 0.0f);
        a(guiGraphics, f);
        this.renderables.forEach(renderable -> {
            renderable.render(guiGraphics, i, i2, f);
        });
        a(this.b, fVVar, poseStackPose, guiGraphics, iSVarM404a, i, i2, fG, f);
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, fG);
            }
        }
        poseStackPose.popPose();
        poseStackPose.translate(0.0f, 0.0f, -400.0f);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fE = C0634xm.e(this.cS, this.cT, f);
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p(), fE * 0.5f);
        C0040bk.a(poseStackPose, guiGraphics, aU, 0, 0, this.width, this.height, fE * 2.0f);
    }

    @Override // com.boehmod.blockfront.C0080cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        this.cT = this.cS;
        this.cS = Mth.lerp(0.2f, this.cS, 1.0f);
        this.dD = this.dC;
        this.dC = Mth.lerp(0.2f, this.dC, 0.0f);
        if (this.dC <= 0.0f) {
            this.aU = true;
        }
        if (this.aU) {
            this.dC = 0.0f;
        }
        if (this.c != null) {
            this.c.tick();
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean mouseClicked(double d, double d2, int i) {
        if (i == 0 && a(d, d2)) {
            I();
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean keyPressed(int i, int i2, int i3) {
        if (i == 256) {
            I();
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }
}
