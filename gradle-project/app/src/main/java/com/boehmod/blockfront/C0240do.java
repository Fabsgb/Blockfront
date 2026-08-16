package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.do */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/do.class */
public class C0240do extends AbstractC0235dj {

    /* JADX INFO: renamed from: gV */
    private static final int f1937gV = 936;

    /* JADX INFO: renamed from: gW */
    private static final int f1938gW = 156;

    /* JADX INFO: renamed from: gX */
    public static final int f1952gX = 16;

    /* JADX INFO: renamed from: gY */
    public static final int f1953gY = 32;

    /* JADX INFO: renamed from: gZ */
    public static final int f1954gZ = 32;

    /* JADX INFO: renamed from: hb */
    public static final int f1956hb = 150;

    /* JADX INFO: renamed from: d */
    @Nullable
    private C0085bB f1957d;

    /* JADX INFO: renamed from: e */
    @Nullable
    private C0085bB f1958e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private C0085bB f1959f;

    /* JADX INFO: renamed from: bs */
    private boolean f1960bs = true;

    /* JADX INFO: renamed from: dW */
    @NotNull
    private static final Component f1939dW = Component.translatable("bf.screen.introduction.online");

    /* JADX INFO: renamed from: dX */
    @NotNull
    private static final Component f1940dX = Component.translatable("bf.screen.introduction.offline");

    /* JADX INFO: renamed from: dY */
    @NotNull
    private static final Component f1941dY = Component.translatable("bf.screen.introduction.offline.tip");

    /* JADX INFO: renamed from: dZ */
    @NotNull
    private static final Component f1942dZ = Component.translatable("bf.screen.introduction.online.tip");

    /* JADX INFO: renamed from: ea */
    @NotNull
    private static final Component f1943ea = Component.translatable("bf.screen.introduction.online.cancel.tip", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: eb */
    @NotNull
    private static final Component f1944eb = Component.translatable("bf.message.cancel");

    /* JADX INFO: renamed from: ec */
    @NotNull
    private static final Component f1945ec = Component.translatable("bf.menu.text.anticheat.detected.par1").withColor(ColorReferences.COLOR_THEME_RED);

    /* JADX INFO: renamed from: ed */
    @NotNull
    private static final Component f1946ed = Component.translatable("bf.cloud.popup.update.button");

    /* JADX INFO: renamed from: ee */
    @NotNull
    private static final Component f1947ee = Component.translatable("bf.cloud.popup.update.button.tip");

    /* JADX INFO: renamed from: bn */
    @NotNull
    private static final ResourceLocation f1948bn = C0532jO.m2378d("textures/gui/logo/blockfront.png");

    /* JADX INFO: renamed from: bo */
    @NotNull
    private static final ResourceLocation f1949bo = C0532jO.m2378d("textures/gui/intro/stage_background.png");

    /* JADX INFO: renamed from: bp */
    @NotNull
    private static final ResourceLocation f1950bp = C0532jO.m2378d("textures/gui/intro/stage_background_complete.png");

    /* JADX INFO: renamed from: bq */
    @NotNull
    private static final ResourceLocation f1951bq = C0532jO.m2378d("textures/gui/intro/stage_background_incomplete.png");

    /* JADX INFO: renamed from: ha */
    public static final int f1955ha = EnumC0241dp.values().length;

    /* JADX INFO: renamed from: z */
    public boolean m1376z() {
        return ((C0396gl) this.f1057f.m2855a()).m1886a(this.f1058a).m2511z();
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    protected void init() {
        super.init();
        this.f1959f = new C0085bB((this.width / 2) - 50, (this.height / 2) + 54, 100, 20, f1944eb, button -> {
            C0358g c0358g = (C0358g) this.f1057f.m2852b();
            c0358g.m1723a(EnumC0411h.UNDECIDED);
            c0358g.m1722a().disconnect("User cancelled connection", false);
        }).m326a(f1943ea).m314a(C0085bB.c.DEFAULT).m328a(C0085bB.a.SHADOW);
        this.f1959f.active = false;
        this.f1959f.visible = false;
        addRenderableWidget(this.f1959f);
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @NotNull
    /* JADX INFO: renamed from: g */
    protected List<C0239dn> mo1354g() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0994s c0994s = (C0994s) this.f1057f.m2852b();
        objectArrayList.add(new C0239dn(f1939dW, button -> {
            if (this.f1057f.m2870a().m2382ah()) {
                this.f1058a.setScreen(new C0133bx(this));
                return;
            }
            C0358g c0358g = (C0358g) this.f1057f.m2852b();
            c0358g.m1723a(EnumC0411h.ONLINE);
            if (this.f1960bs) {
                this.f1960bs = false;
                c0358g.m1722a().bumpReconnectTick();
            }
        }).m1365a(c0085bB -> {
            this.f1957d = c0085bB;
            c0085bB.m317a(c0085bB -> {
                return (c0994s.m5570i() || ((C0358g) this.f1057f.m2852b()).m1722a() == EnumC0411h.ONLINE) ? false : true;
            });
        }).m1368a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1366a(ColorReferences.COLOR_WHITE).m1367a(f1942dZ));
        objectArrayList.add(new C0239dn(f1940dX, button2 -> {
            ((C0358g) this.f1057f.m2852b()).m1723a(EnumC0411h.OFFLINE);
            this.f1058a.setScreen(mo1355b());
        }).m1365a(c0085bB2 -> {
            this.f1958e = c0085bB2;
            c0085bB2.m317a(c0085bB2 -> {
                return ((C0358g) this.f1057f.m2852b()).m1722a() != EnumC0411h.ONLINE;
            });
        }).m1367a(f1941dY));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1355b() {
        return null;
    }

    public void tick() {
        super.tick();
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        boolean z = c0358g.m1722a() == EnumC0411h.ONLINE;
        ConnectionStatus connectionStatusA = c0358g.m1722a();
        C0994s c0994s = (C0994s) this.f1057f.m2852b();
        C0835p c0835pM2870a = this.f1057f.m2870a();
        if (z && connectionStatusA.isConnected() && connectionStatusA.isVerified() && m1376z()) {
            this.f1058a.setScreen(mo1355b());
        }
        if (this.f1959f != null) {
            this.f1959f.active = z;
            this.f1959f.visible = z;
        }
        if (this.f1957d != null) {
            this.f1957d.visible = !z;
        }
        if (this.f1958e != null) {
            this.f1958e.visible = !z;
        }
        if (c0835pM2870a.m2382ah()) {
            if (this.f1957d != null) {
                this.f1957d.m314a(C0085bB.c.DEFAULT);
                this.f1957d.m313a(0);
                this.f1957d.m315b(0);
                this.f1957d.setMessage(f1946ed);
                this.f1957d.m335e(c0835pM2870a.mo2390e());
                this.f1957d.m341f(ColorReferences.COLOR_WHITE_SOLID);
                this.f1957d.m326a(f1947ee);
                return;
            }
            return;
        }
        if (c0994s.m5570i() && this.f1957d != null) {
            this.f1957d.m335e(ColorReferences.COLOR_THEME_RED_SOLID);
            this.f1957d.m341f(ColorReferences.COLOR_THEME_RED_HOVERED_SOLID);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0235dj
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1356i() {
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0235dj
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) throws MatchException {
        int iMo2390e;
        super.renderBackground(guiGraphics, i, i2, f);
        C0835p c0835pM2870a = this.f1057f.m2870a();
        C0994s c0994s = (C0994s) this.f1057f.m2852b();
        boolean z = ((C0358g) this.f1057f.m2852b()).m1722a() == EnumC0411h.ONLINE;
        boolean zM5570i = c0994s.m5570i();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m548c(poseStackPose, guiGraphics, f1948bn, i3, i4 - 20, 936.0f, 156.0f, 0.25f);
        if (c0835pM2870a.m2382ah()) {
            C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(Component.translatable("bf.cloud.popup.update.message", new Object[]{Component.literal(c0835pM2870a.m2383w()).withColor(c0835pM2870a.mo2389d()), C0030a.f263a}), Token.CCOMMENT), i3, i4 + 60, 10, true);
        } else if (zM5570i) {
            C0129bt.m475a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1945ec, Token.LSH_EQ), i3, i4 + 60, 10, true);
        }
        if (z) {
            m1377b(poseStackPose, guiGraphics, i3, i4, i, i2);
        }
        if (zM5570i) {
            iMo2390e = ColorReferences.COLOR_THEME_RED_SOLID;
        } else {
            iMo2390e = c0835pM2870a.m2382ah() ? c0835pM2870a.mo2390e() : ColorReferences.COLOR_TEAM_ALLIES_SOLID;
        }
        int i5 = iMo2390e;
        C0129bt.m527a(guiGraphics, 0, this.height - 150, this.width, 150, i5, i5, 0.0f, 0.25f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    /* JADX INFO: renamed from: b */
    private void m1377b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) throws MatchException {
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        ModConnection modConnectionA = c0358g.m1722a();
        ConnectionStatus connectionStatusA = c0358g.m1722a();
        Component componentLiteral = Component.literal(C0030a.f263a);
        float fM466g = C0129bt.m466g();
        Component componentWithColor = Component.literal(C1273xM.m7239b(Math.max(modConnectionA.getReconnectTickCount() / 20, 0))).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        Component componentWithColor2 = Component.literal(C1273xM.m7239b(Math.max(modConnectionA.getLoginSendTimer() / 20, 0))).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        EnumC0241dp currentStage = EnumC0241dp.getCurrentStage(connectionStatusA);
        int iOrdinal = currentStage.ordinal();
        Pair<Component, Component> displayComponents = currentStage.getDisplayComponents(componentLiteral, (connectionStatusA == ConnectionStatus.CLOSED || connectionStatusA == ConnectionStatus.CONNECTED_NOT_ENCRYPTED) ? componentWithColor : componentWithColor2, fM466g);
        int i5 = i2 + 38;
        Component component = (Component) displayComponents.first();
        Component component2 = (Component) displayComponents.second();
        int iWidth = this.font.width(component) + 4;
        int i6 = i - (iWidth / 2);
        int i7 = i5 - 3;
        C0129bt.m518b(guiGraphics, i6, i7, iWidth, 13, C0129bt.m465t());
        C0129bt.m499a(poseStack, this.font, guiGraphics, component, i, i5);
        if (C0129bt.m573b(i6, i7, iWidth, 13.0d, i3, i4)) {
            guiGraphics.renderTooltip(this.font, component2, i3, i4);
        }
        int i8 = f1955ha;
        int i9 = i - (((32 * i8) + (32 * (i8 - 1))) / 2);
        int i10 = (i5 - 16) - 6;
        int i11 = 0;
        while (i11 < i8) {
            int i12 = i9 + (64 * i11) + 16;
            boolean z = iOrdinal + 1 > i11 + 1;
            boolean z2 = iOrdinal + 1 > i11 + 2;
            boolean z3 = i11 == i8 - 1;
            int i13 = (i12 + 16) - 2;
            int i14 = i10 - 1;
            int i15 = z2 ? ColorReferences.COLOR_TEAM_ALLIES_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            if (!z3) {
                C0129bt.m515a(guiGraphics, i13, i14, 36, 2, i15);
            }
            if (!z3 && !z2 && z) {
                C0129bt.m524b(poseStack, guiGraphics, i13, i14, 36.0f, 2.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, i15);
            }
            C0129bt.m539b(poseStack, guiGraphics, f1949bo, i12, i10, 32);
            C0129bt.m539b(poseStack, guiGraphics, z ? f1950bp : f1951bq, i12, i10, 32);
            C0129bt.m539b(poseStack, guiGraphics, EnumC0241dp.values()[i11].getIconTexture(), i12, i10, 16);
            i11++;
        }
    }
}
