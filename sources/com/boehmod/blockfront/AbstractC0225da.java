package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.da */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/da.class */
public abstract class AbstractC0225da extends C0196cy {

    /* JADX INFO: renamed from: fM */
    protected static final int f1832fM = 80;

    /* JADX INFO: renamed from: fN */
    protected static final int f1833fN = 20;

    /* JADX INFO: renamed from: fO */
    protected static final int f1834fO = 5;

    /* JADX INFO: renamed from: bi */
    @NotNull
    private static final ResourceLocation f1835bi;

    /* JADX INFO: renamed from: bj */
    @NotNull
    private static final ResourceLocation f1836bj;

    /* JADX INFO: renamed from: bk */
    @NotNull
    private static final ResourceLocation f1837bk;

    /* JADX INFO: renamed from: bl */
    @NotNull
    private static final ResourceLocation f1838bl;

    /* JADX INFO: renamed from: dz */
    @NotNull
    private static final Component f1839dz;

    /* JADX INFO: renamed from: dA */
    @NotNull
    private static final Component f1840dA;

    /* JADX INFO: renamed from: fP */
    private static final int f1841fP = 1920;

    /* JADX INFO: renamed from: fQ */
    private static final int f1842fQ = 1080;

    /* JADX INFO: renamed from: fR */
    public static final int f1843fR = 854;

    /* JADX INFO: renamed from: fS */
    public static final int f1844fS = 480;

    /* JADX INFO: renamed from: fT */
    public static final int f1845fT = 1155850964;

    /* JADX INFO: renamed from: fU */
    protected static final int f1846fU = 5;

    /* JADX INFO: renamed from: bn */
    static final /* synthetic */ boolean f1847bn;

    @NotNull
    /* JADX INFO: renamed from: f */
    protected abstract List<C0229de> mo1328f();

    @Nullable
    /* JADX INFO: renamed from: b */
    protected abstract SoundEvent mo1329b();

    @Nullable
    /* JADX INFO: renamed from: i */
    protected abstract ResourceLocation mo1330i();

    static {
        f1847bn = !AbstractC0225da.class.desiredAssertionStatus();
        f1835bi = C0564jv.m2555d("textures/gui/background/introduction.png");
        f1836bj = C0564jv.m2555d("textures/gui/background/introduction_character.png");
        f1837bk = C0564jv.m2555d("textures/gui/background/introduction_shadow.png");
        f1838bl = C0564jv.m2555d("textures/gui/cornershadow.png");
        f1839dz = Component.translatable("bf.screen.introduction.disclaimer", new Object[]{C0029a.f246a});
        f1840dA = Component.translatable("bf.screen.menu.intro.mod", new Object[]{C0029a.f246a});
    }

    public AbstractC0225da() {
        super(f1840dA);
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @OverridingMethodsMustInvokeSuper
    protected void init() {
        super.init();
        SoundEvent soundEventMo1329b = mo1329b();
        if (soundEventMo1329b != null) {
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(soundEventMo1329b, 1.0f, 1.0f));
        }
        m1331a(mo1328f());
    }

    @Override // com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, fM366g);
            }
        }
    }

    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        float f2 = (i - i3) / i3;
        C0119bk.m415a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        ResourceLocation resourceLocationMo1330i = mo1330i();
        if (resourceLocationMo1330i != null) {
            float fMax = Math.max(this.width / 854.0f, this.height / 480.0f) * 1.1f;
            C0119bk.m444b(poseStackPose, guiGraphics, resourceLocationMo1330i, i3, i4, 854.0f * fMax, 480.0f * fMax, 0.0f, 0.25f);
            C0119bk.m526b(this.f1587b, f);
        } else {
            float fMax2 = Math.max(this.width / 1920.0f, this.height / 1080.0f) * 1.1f;
            float f3 = 1920.0f * fMax2;
            float f4 = 1080.0f * fMax2;
            C0119bk.m446b(poseStackPose, guiGraphics, f1835bi, i3 + (1.5f * f2), i4, f3, f4, 0.0f, 0.4f, 15000276);
            C0119bk.m446b(poseStackPose, guiGraphics, f1836bj, i3 + (2.5f * f2), i4, f3, f4, 0.0f, 1.0f, 15000276);
            C0119bk.m431a(poseStackPose, guiGraphics, f1837bk, 0, 0, this.width, this.height);
        }
        C0119bk.m367a(poseStackPose, guiGraphics, 6, 6, this.width - 12, this.height - 12);
        C0119bk.m431a(poseStackPose, guiGraphics, f1838bl, 0, 0, this.width, this.height);
        C0119bk.m384c(poseStackPose, this.font, guiGraphics, f1839dz, i3, this.height - 24, f1845fT);
    }

    /* JADX INFO: renamed from: a */
    private void m1331a(@NotNull List<C0229de> list) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        int size = (85 * list.size()) - 5;
        int i3 = 0;
        for (C0229de c0229de : list) {
            C0127bs c0127bsM639a = new C0127bs((i - (size / 2)) + (i3 * 85), i2 + 30, 80, 20, c0229de.m1344c(), c0229de.m1349a()).m639a(C0127bs.c.SHADOW);
            Component componentM1345j = c0229de.m1345j();
            if (componentM1345j != null) {
                c0127bsM639a.m651a(componentM1345j);
            }
            int iM1346H = c0229de.m1346H();
            if (iM1346H != -1) {
                c0127bsM639a.m660e(iM1346H);
            }
            int iM1347I = c0229de.m1347I();
            if (iM1347I != -1) {
                c0127bsM639a.m666f(iM1347I);
            }
            int iM1348J = c0229de.m1348J();
            if (iM1348J != -1) {
                c0127bsM639a.m640b(iM1348J);
            }
            c0127bsM639a.m653a(C0127bs.a.SHADOW);
            Consumer<C0127bs> consumerM1343a = c0229de.m1343a();
            if (consumerM1343a != null) {
                consumerM1343a.accept(c0127bsM639a);
            }
            addRenderableWidget(c0127bsM639a);
            i3++;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Screen m1332b() {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1847bn && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0357g c0357g = (C0357g) c0622lM2667b.m2667b();
        switch (c0357g.m1716a()) {
            case UNDECIDED:
                return new C0230df();
            case ONLINE:
                if (!C0424hN.f2764R.m1996T()) {
                    return new C0228dd();
                }
                if (!C0424hN.f2765S.m1996T()) {
                    return new C0233di();
                }
                if (!C0424hN.f2766T.m1996T()) {
                    return new C0226db();
                }
                if (!C0424hN.f2767U.m1996T()) {
                    return new C0227dc();
                }
                if (!C0424hN.f2768V.m1996T()) {
                    return new C0232dh();
                }
                c0357g.m1716a().bumpReconnectTick();
                return new C0235dk();
            default:
                return new C0235dk();
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m1333b(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int i3 = (this.width / 2) - (((37 * i2) - 5) / 2);
        int i4 = this.height - 32;
        int i5 = 0;
        while (i5 < i2) {
            C0119bk.m415a(guiGraphics, i3 + (i5 * 37), i4, 32, 1, i5 < i ? -8617656 : -1);
            i5++;
        }
    }
}
