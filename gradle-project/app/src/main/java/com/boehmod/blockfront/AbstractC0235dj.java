package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dj.class */
public abstract class AbstractC0235dj extends C0144cH {

    /* JADX INFO: renamed from: gM */
    protected static final int f1892gM = 80;

    /* JADX INFO: renamed from: gN */
    protected static final int f1893gN = 20;

    /* JADX INFO: renamed from: gO */
    protected static final int f1894gO = 5;

    /* JADX INFO: renamed from: bg */
    @NotNull
    private static final ResourceLocation f1895bg;

    /* JADX INFO: renamed from: bh */
    @NotNull
    private static final ResourceLocation f1896bh;

    /* JADX INFO: renamed from: bi */
    @NotNull
    private static final ResourceLocation f1897bi;

    /* JADX INFO: renamed from: bj */
    @NotNull
    private static final ResourceLocation f1898bj;

    /* JADX INFO: renamed from: dB */
    @NotNull
    private static final Component f1899dB;

    /* JADX INFO: renamed from: dC */
    @NotNull
    private static final Component f1900dC;

    /* JADX INFO: renamed from: gP */
    private static final int f1901gP = 1920;

    /* JADX INFO: renamed from: gQ */
    private static final int f1902gQ = 1080;

    /* JADX INFO: renamed from: gR */
    public static final int f1903gR = 854;

    /* JADX INFO: renamed from: gS */
    public static final int f1904gS = 480;

    /* JADX INFO: renamed from: gT */
    public static final int f1905gT = 1155850964;

    /* JADX INFO: renamed from: gU */
    protected static final int f1906gU = 5;

    /* JADX INFO: renamed from: br */
    static final /* synthetic */ boolean f1907br;

    @NotNull
    /* JADX INFO: renamed from: g */
    protected abstract List<C0239dn> mo1354g();

    @Nullable
    /* JADX INFO: renamed from: b */
    protected abstract SoundEvent mo1355b();

    @Nullable
    /* JADX INFO: renamed from: i */
    protected abstract ResourceLocation mo1356i();

    static {
        f1907br = !AbstractC0235dj.class.desiredAssertionStatus();
        f1895bg = C0532jO.m2378d("textures/gui/background/introduction.png");
        f1896bh = C0532jO.m2378d("textures/gui/background/introduction_character.png");
        f1897bi = C0532jO.m2378d("textures/gui/background/introduction_shadow.png");
        f1898bj = C0532jO.m2378d("textures/gui/cornershadow.png");
        f1899dB = Component.translatable("bf.screen.introduction.disclaimer", new Object[]{C0030a.f263a});
        f1900dC = Component.translatable("bf.screen.menu.intro.mod", new Object[]{C0030a.f263a});
    }

    public AbstractC0235dj() {
        super(f1900dC);
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @OverridingMethodsMustInvokeSuper
    protected void init() {
        super.init();
        SoundEvent soundEventMo1355b = mo1355b();
        if (soundEventMo1355b != null) {
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(soundEventMo1355b, 1.0f, 1.0f));
        }
        m1357a(mo1354g());
    }

    @Override // com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStackPose, this.font, guiGraphics, i, i2, fM466g);
            }
        }
    }

    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        float f2 = (i - i3) / i3;
        C0129bt.m515a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        ResourceLocation resourceLocationMo1356i = mo1356i();
        if (resourceLocationMo1356i != null) {
            float fMax = Math.max(this.width / 854.0f, this.height / 480.0f) * 1.1f;
            C0129bt.m544b(poseStackPose, guiGraphics, resourceLocationMo1356i, i3, i4, 854.0f * fMax, 480.0f * fMax, 0.0f, 0.25f);
            C0129bt.m628b(this.f1058a, f);
        } else {
            float fMax2 = Math.max(this.width / 1920.0f, this.height / 1080.0f) * 1.1f;
            float f3 = 1920.0f * fMax2;
            float f4 = 1080.0f * fMax2;
            C0129bt.m546b(poseStackPose, guiGraphics, f1895bg, i3 + (1.5f * f2), i4, f3, f4, 0.0f, 0.4f, 15000276);
            C0129bt.m546b(poseStackPose, guiGraphics, f1896bh, i3 + (2.5f * f2), i4, f3, f4, 0.0f, 1.0f, 15000276);
            C0129bt.m531a(poseStackPose, guiGraphics, f1897bi, 0, 0, this.width, this.height);
        }
        C0129bt.m467a(poseStackPose, guiGraphics, 6, 6, this.width - 12, this.height - 12);
        C0129bt.m531a(poseStackPose, guiGraphics, f1898bj, 0, 0, this.width, this.height);
        C0129bt.m484c(poseStackPose, this.font, guiGraphics, f1899dB, i3, this.height - 24, f1905gT);
    }

    /* JADX INFO: renamed from: a */
    private void m1357a(@NotNull List<C0239dn> list) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        int size = (85 * list.size()) - 5;
        int i3 = 0;
        for (C0239dn c0239dn : list) {
            C0085bB c0085bBM314a = new C0085bB((i - (size / 2)) + (i3 * 85), i2 + 30, 80, 20, c0239dn.m1370c(), c0239dn.m1375a()).m314a(C0085bB.c.SHADOW);
            Component componentM1371j = c0239dn.m1371j();
            if (componentM1371j != null) {
                c0085bBM314a.m326a(componentM1371j);
            }
            int iM1372L = c0239dn.m1372L();
            if (iM1372L != -1) {
                c0085bBM314a.m335e(iM1372L);
            }
            int iM1373M = c0239dn.m1373M();
            if (iM1373M != -1) {
                c0085bBM314a.m341f(iM1373M);
            }
            int iM1374N = c0239dn.m1374N();
            if (iM1374N != -1) {
                c0085bBM314a.m315b(iM1374N);
            }
            c0085bBM314a.m328a(C0085bB.a.SHADOW);
            Consumer<C0085bB> consumerM1369a = c0239dn.m1369a();
            if (consumerM1369a != null) {
                consumerM1369a.accept(c0085bBM314a);
            }
            addRenderableWidget(c0085bBM314a);
            i3++;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Screen m1358b() {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f1907br && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0358g c0358g = (C0358g) c0623lM2852b.m2852b();
        switch (c0358g.m1722a()) {
            case UNDECIDED:
                return new C0240do();
            case ONLINE:
                if (!C0495ie.f3065R.m2230U()) {
                    return new C0238dm();
                }
                if (!C0495ie.f3066S.m2230U()) {
                    return new C0243dr();
                }
                if (!C0495ie.f3067T.m2230U()) {
                    return new C0236dk();
                }
                if (!C0495ie.f3068U.m2230U()) {
                    return new C0237dl();
                }
                if (!C0495ie.f3069V.m2230U()) {
                    return new C0242dq();
                }
                c0358g.m1722a().bumpReconnectTick();
                return new C0245dt();
            default:
                return new C0245dt();
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m1359b(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int i3 = (this.width / 2) - (((37 * i2) - 5) / 2);
        int i4 = this.height - 32;
        int i5 = 0;
        while (i5 < i2) {
            C0129bt.m515a(guiGraphics, i3 + (i5 * 37), i4, 32, 1, i5 < i ? -8617656 : -1);
            i5++;
        }
    }
}
