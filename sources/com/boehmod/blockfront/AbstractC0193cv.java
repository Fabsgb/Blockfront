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

/* JADX INFO: renamed from: com.boehmod.blockfront.cv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cv.class */
public abstract class AbstractC0193cv extends C0195cx {

    /* JADX INFO: renamed from: dB */
    protected static float f1555dB = 0.0f;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final Screen f1556c;

    /* JADX INFO: renamed from: aU */
    public boolean f1557aU;

    /* JADX INFO: renamed from: dC */
    protected float f1558dC;

    /* JADX INFO: renamed from: dD */
    protected float f1559dD;

    /* JADX INFO: renamed from: cS */
    protected float f1560cS;

    /* JADX INFO: renamed from: cT */
    protected float f1561cT;

    /* JADX INFO: renamed from: aV */
    private boolean f1562aV;

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo344a(double d, double d2);

    public AbstractC0193cv(@Nullable Screen screen, @NotNull Component component) {
        super(component);
        this.f1557aU = true;
        this.f1559dD = 0.0f;
        this.f1561cT = 0.0f;
        this.f1562aV = false;
        this.f1556c = screen;
    }

    public AbstractC0193cv(@NotNull Screen screen, @NotNull Component component, boolean z) {
        this(screen, component);
        this.f1557aU = z;
    }

    @Nonnull
    /* JADX INFO: renamed from: a */
    public AbstractC0193cv m1182a(boolean z) {
        this.f1562aV = z;
        return this;
    }

    /* JADX INFO: renamed from: I */
    private void m1183I() {
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7554pl.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        m1184J();
    }

    /* JADX INFO: renamed from: h */
    public float mo1178h(float f) {
        return C1290xm.m7843e(this.f1558dC, this.f1559dD, f);
    }

    /* JADX INFO: renamed from: a */
    public void mo743a(@NotNull GuiGraphics guiGraphics, float f) {
    }

    /* JADX INFO: renamed from: J */
    public void m1184J() {
        Screen screen = this.f1556c;
        if (screen instanceof AbstractC0193cv) {
            ((AbstractC0193cv) screen).f1557aU = true;
        }
        this.f1587b.setScreen(this.f1556c);
    }

    @Override // com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void init() {
        super.init();
        f1555dB = this.width / 4.0f;
        if (!this.f1557aU) {
            float f = f1555dB;
            this.f1559dD = f;
            this.f1558dC = f;
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        C0326fV c0326fV = (C0326fV) this.f1586e.m2670a();
        C0482iS c0482iSM1676a = c0326fV.m1676a(this.f1587b);
        if (this.f1556c != null && (this.f1556c.width != this.width || this.f1556c.height != this.height)) {
            this.f1556c.init(this.f1587b, this.width, this.height);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, -400.0f);
        if (this.f1556c != null) {
            this.f1556c.render(guiGraphics, i, i2, f);
            if (this.f1562aV) {
                C0119bk.m526b(this.f1587b, f);
            }
        }
        poseStackPose.popPose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        renderBackground(guiGraphics, i, i2, f);
        poseStackPose.pushPose();
        poseStackPose.translate(mo1178h(f), 0.0f, 0.0f);
        mo743a(guiGraphics, f);
        this.renderables.forEach(renderable -> {
            renderable.render(guiGraphics, i, i2, f);
        });
        m1192a(this.f1587b, c0326fV, poseStackPose, guiGraphics, c0482iSM1676a, i, i2, fM366g, f);
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, fM366g);
            }
        }
        poseStackPose.popPose();
        poseStackPose.translate(0.0f, 0.0f, -400.0f);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7843e = C1290xm.m7843e(this.f1560cS, this.f1561cT, f);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p(), fM7843e * 0.5f);
        C0119bk.m433a(poseStackPose, guiGraphics, f1577aU, 0, 0, this.width, this.height, fM7843e * 2.0f);
    }

    @Override // com.boehmod.blockfront.C0195cx
    @OverridingMethodsMustInvokeSuper
    public void tick() {
        super.tick();
        this.f1561cT = this.f1560cS;
        this.f1560cS = Mth.lerp(0.2f, this.f1560cS, 1.0f);
        this.f1559dD = this.f1558dC;
        this.f1558dC = Mth.lerp(0.2f, this.f1558dC, 0.0f);
        if (this.f1558dC <= 0.0f) {
            this.f1557aU = true;
        }
        if (this.f1557aU) {
            this.f1558dC = 0.0f;
        }
        if (this.f1556c != null) {
            this.f1556c.tick();
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        if (i == 0 && mo344a(d, d2)) {
            m1183I();
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean keyPressed(int i, int i2, int i3) {
        if (i == 256) {
            m1183I();
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }
}
