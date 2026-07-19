package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/da.class */
public abstract class AbstractC0084da extends C0081cy {
    protected static final int fM = 80;
    protected static final int fN = 20;
    protected static final int fO = 5;

    @NotNull
    private static final ResourceLocation bi;

    @NotNull
    private static final ResourceLocation bj;

    @NotNull
    private static final ResourceLocation bk;

    @NotNull
    private static final ResourceLocation bl;

    @NotNull
    private static final Component dz;

    @NotNull
    private static final Component dA;
    private static final int fP = 1920;
    private static final int fQ = 1080;
    public static final int fR = 854;
    public static final int fS = 480;
    public static final int fT = 1155850964;
    protected static final int fU = 5;
    static final /* synthetic */ boolean bn;

    @NotNull
    protected abstract List<C0088de> f();

    @Nullable
    protected abstract SoundEvent b();

    @Nullable
    protected abstract ResourceLocation i();

    static {
        bn = !AbstractC0084da.class.desiredAssertionStatus();
        bi = C0265jv.d("textures/gui/background/introduction.png");
        bj = C0265jv.d("textures/gui/background/introduction_character.png");
        bk = C0265jv.d("textures/gui/background/introduction_shadow.png");
        bl = C0265jv.d("textures/gui/cornershadow.png");
        dz = Component.translatable("bf.screen.introduction.disclaimer", new Object[]{C0002a.a});
        dA = Component.translatable("bf.screen.menu.intro.mod", new Object[]{C0002a.a});
    }

    public AbstractC0084da() {
        super(dA);
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @OverridingMethodsMustInvokeSuper
    protected void init() {
        super.init();
        SoundEvent soundEventB = b();
        if (soundEventB != null) {
            this.b.getSoundManager().play(SimpleSoundInstance.forUI(soundEventB, 1.0f, 1.0f));
        }
        a(f());
    }

    @Override // com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, fG);
            }
        }
    }

    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        float f2 = (i - i3) / i3;
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        ResourceLocation resourceLocationI = i();
        if (resourceLocationI != null) {
            float fMax = Math.max(this.width / 854.0f, this.height / 480.0f) * 1.1f;
            C0040bk.b(poseStackPose, guiGraphics, resourceLocationI, i3, i4, 854.0f * fMax, 480.0f * fMax, 0.0f, 0.25f);
            C0040bk.b(this.b, f);
        } else {
            float fMax2 = Math.max(this.width / 1920.0f, this.height / 1080.0f) * 1.1f;
            float f3 = 1920.0f * fMax2;
            float f4 = 1080.0f * fMax2;
            C0040bk.b(poseStackPose, guiGraphics, bi, i3 + (1.5f * f2), i4, f3, f4, 0.0f, 0.4f, 15000276);
            C0040bk.b(poseStackPose, guiGraphics, bj, i3 + (2.5f * f2), i4, f3, f4, 0.0f, 1.0f, 15000276);
            C0040bk.a(poseStackPose, guiGraphics, bk, 0, 0, this.width, this.height);
        }
        C0040bk.a(poseStackPose, guiGraphics, 6, 6, this.width - 12, this.height - 12);
        C0040bk.a(poseStackPose, guiGraphics, bl, 0, 0, this.width, this.height);
        C0040bk.c(poseStackPose, this.font, guiGraphics, dz, i3, this.height - 24, fT);
    }

    private void a(@NotNull List<C0088de> list) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        int size = (85 * list.size()) - 5;
        int i3 = 0;
        for (C0088de c0088de : list) {
            C0048bs c0048bsA = new C0048bs((i - (size / 2)) + (i3 * 85), i2 + 30, 80, 20, c0088de.c(), c0088de.m346a()).a(C0048bs.c.SHADOW);
            Component componentJ = c0088de.j();
            if (componentJ != null) {
                c0048bsA.a(componentJ);
            }
            int iH = c0088de.H();
            if (iH != -1) {
                c0048bsA.e(iH);
            }
            int I = c0088de.I();
            if (I != -1) {
                c0048bsA.f(I);
            }
            int iJ = c0088de.J();
            if (iJ != -1) {
                c0048bsA.b(iJ);
            }
            c0048bsA.a(C0048bs.a.SHADOW);
            Consumer<C0048bs> consumerA = c0088de.a();
            if (consumerA != null) {
                consumerA.accept(c0048bsA);
            }
            addRenderableWidget(c0048bsA);
            i3++;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static Screen m341b() {
        C0297l c0297lB = C0297l.b();
        if (!bn && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0163g c0163g = (C0163g) c0297lB.b();
        switch (c0163g.a()) {
            case UNDECIDED:
                return new C0089df();
            case ONLINE:
                if (!hN.f157R.T()) {
                    return new C0087dd();
                }
                if (!hN.S.T()) {
                    return new C0092di();
                }
                if (!hN.T.T()) {
                    return new C0085db();
                }
                if (!hN.U.T()) {
                    return new C0086dc();
                }
                if (!hN.V.T()) {
                    return new C0091dh();
                }
                c0163g.a().bumpReconnectTick();
                return new C0094dk();
            default:
                return new C0094dk();
        }
    }

    protected void b(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int i3 = (this.width / 2) - (((37 * i2) - 5) / 2);
        int i4 = this.height - 32;
        int i5 = 0;
        while (i5 < i2) {
            C0040bk.a(guiGraphics, i3 + (i5 * 37), i4, 32, 1, i5 < i ? -8617656 : -1);
            i5++;
        }
    }
}
