package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.df */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/df.class */
public class C0230df extends AbstractC0225da {

    /* JADX INFO: renamed from: fV */
    private static final int f1877fV = 936;

    /* JADX INFO: renamed from: fW */
    private static final int f1878fW = 156;

    /* JADX INFO: renamed from: fX */
    public static final int f1892fX = 16;

    /* JADX INFO: renamed from: fY */
    public static final int f1893fY = 32;

    /* JADX INFO: renamed from: fZ */
    public static final int f1894fZ = 32;

    /* JADX INFO: renamed from: gb */
    public static final int f1896gb = 150;

    /* JADX INFO: renamed from: d */
    @Nullable
    private C0127bs f1897d;

    /* JADX INFO: renamed from: e */
    @Nullable
    private C0127bs f1898e;

    /* JADX INFO: renamed from: f */
    @Nullable
    private C0127bs f1899f;

    /* JADX INFO: renamed from: bo */
    private boolean f1900bo = true;

    /* JADX INFO: renamed from: dU */
    @NotNull
    private static final Component f1879dU = Component.translatable("bf.screen.introduction.online");

    /* JADX INFO: renamed from: dV */
    @NotNull
    private static final Component f1880dV = Component.translatable("bf.screen.introduction.offline");

    /* JADX INFO: renamed from: dW */
    @NotNull
    private static final Component f1881dW = Component.translatable("bf.screen.introduction.offline.tip");

    /* JADX INFO: renamed from: dX */
    @NotNull
    private static final Component f1882dX = Component.translatable("bf.screen.introduction.online.tip");

    /* JADX INFO: renamed from: dY */
    @NotNull
    private static final Component f1883dY = Component.translatable("bf.screen.introduction.online.cancel.tip", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: dZ */
    @NotNull
    private static final Component f1884dZ = Component.translatable("bf.message.cancel");

    /* JADX INFO: renamed from: ea */
    @NotNull
    private static final Component f1885ea = Component.translatable("bf.menu.text.anticheat.detected.par1").withColor(ColorReferences.COLOR_THEME_RED);

    /* JADX INFO: renamed from: eb */
    @NotNull
    private static final Component f1886eb = Component.translatable("bf.cloud.popup.update.button");

    /* JADX INFO: renamed from: ec */
    @NotNull
    private static final Component f1887ec = Component.translatable("bf.cloud.popup.update.button.tip");

    /* JADX INFO: renamed from: bp */
    @NotNull
    private static final ResourceLocation f1888bp = C0564jv.m2555d("textures/gui/logo/blockfront.png");

    /* JADX INFO: renamed from: bq */
    @NotNull
    private static final ResourceLocation f1889bq = C0564jv.m2555d("textures/gui/intro/stage_background.png");

    /* JADX INFO: renamed from: br */
    @NotNull
    private static final ResourceLocation f1890br = C0564jv.m2555d("textures/gui/intro/stage_background_complete.png");

    /* JADX INFO: renamed from: bs */
    @NotNull
    private static final ResourceLocation f1891bs = C0564jv.m2555d("textures/gui/intro/stage_background_incomplete.png");

    /* JADX INFO: renamed from: ga */
    public static final int f1895ga = EnumC0231dg.values().length;

    /* JADX INFO: renamed from: y */
    public boolean m1350y() {
        return ((C0326fV) this.f1586e.m2670a()).m1676a(this.f1587b).m2184y();
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    protected void init() {
        super.init();
        this.f1899f = new C0127bs((this.width / 2) - 50, (this.height / 2) + 54, 100, 20, f1884dZ, button -> {
            C0357g c0357g = (C0357g) this.f1586e.m2667b();
            c0357g.m1717a(EnumC0410h.UNDECIDED);
            c0357g.m1716a().disconnect("User cancelled connection", false);
        }).m651a(f1883dY).m639a(C0127bs.c.DEFAULT).m653a(C0127bs.a.SHADOW);
        this.f1899f.active = false;
        this.f1899f.visible = false;
        addRenderableWidget(this.f1899f);
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @NotNull
    /* JADX INFO: renamed from: f */
    protected List<C0229de> mo1328f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0940r c0940r = (C0940r) this.f1586e.m2667b();
        objectArrayList.add(new C0229de(f1879dU, button -> {
            if (this.f1586e.m2684a().m2558ad()) {
                this.f1587b.setScreen(new C0123bo(this));
                return;
            }
            C0357g c0357g = (C0357g) this.f1586e.m2667b();
            c0357g.m1717a(EnumC0410h.ONLINE);
            if (this.f1900bo) {
                this.f1900bo = false;
                c0357g.m1716a().bumpReconnectTick();
            }
        }).m1339a(c0127bs -> {
            this.f1897d = c0127bs;
            c0127bs.m642a(c0127bs -> {
                return (c0940r.m5133i() || ((C0357g) this.f1586e.m2667b()).m1716a() == EnumC0410h.ONLINE) ? false : true;
            });
        }).m1342a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).m1340a(ColorReferences.COLOR_WHITE).m1341a(f1882dX));
        objectArrayList.add(new C0229de(f1880dV, button2 -> {
            ((C0357g) this.f1586e.m2667b()).m1717a(EnumC0410h.OFFLINE);
            this.f1587b.setScreen(mo1329b());
        }).m1339a(c0127bs2 -> {
            this.f1898e = c0127bs2;
            c0127bs2.m642a(c0127bs2 -> {
                return ((C0357g) this.f1586e.m2667b()).m1716a() != EnumC0410h.ONLINE;
            });
        }).m1341a(f1881dW));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: b */
    protected SoundEvent mo1329b() {
        return null;
    }

    public void tick() {
        super.tick();
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        boolean z = c0357g.m1716a() == EnumC0410h.ONLINE;
        ConnectionStatus connectionStatusA = c0357g.m1716a();
        C0940r c0940r = (C0940r) this.f1586e.m2667b();
        C0834p c0834pM2684a = this.f1586e.m2684a();
        if (z && connectionStatusA.isConnected() && connectionStatusA.isVerified() && m1350y()) {
            this.f1587b.setScreen(mo1329b());
        }
        if (this.f1899f != null) {
            this.f1899f.active = z;
            this.f1899f.visible = z;
        }
        if (this.f1897d != null) {
            this.f1897d.visible = !z;
        }
        if (this.f1898e != null) {
            this.f1898e.visible = !z;
        }
        if (c0834pM2684a.m2558ad()) {
            if (this.f1897d != null) {
                this.f1897d.m639a(C0127bs.c.DEFAULT);
                this.f1897d.m638a(0);
                this.f1897d.m640b(0);
                this.f1897d.setMessage(f1886eb);
                this.f1897d.m660e(c0834pM2684a.m4208e());
                this.f1897d.m666f(ColorReferences.COLOR_WHITE_SOLID);
                this.f1897d.m651a(f1887ec);
                return;
            }
            return;
        }
        if (c0940r.m5133i() && this.f1897d != null) {
            this.f1897d.m660e(ColorReferences.COLOR_THEME_RED_SOLID);
            this.f1897d.m666f(ColorReferences.COLOR_THEME_RED_HOVERED_SOLID);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    @Nullable
    /* JADX INFO: renamed from: i */
    protected ResourceLocation mo1330i() {
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0225da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) throws MatchException {
        super.renderBackground(guiGraphics, i, i2, f);
        C0834p c0834pM2684a = this.f1586e.m2684a();
        C0940r c0940r = (C0940r) this.f1586e.m2667b();
        boolean z = ((C0357g) this.f1586e.m2667b()).m1716a() == EnumC0410h.ONLINE;
        boolean zM5133i = c0940r.m5133i();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m448c(poseStackPose, guiGraphics, f1888bp, i3, i4 - 20, 936.0f, 156.0f, 0.25f);
        if (c0834pM2684a.m2558ad()) {
            C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(Component.translatable("bf.cloud.popup.update.message", new Object[]{Component.literal(c0834pM2684a.m2559s()).withColor(c0834pM2684a.mo2566d()), C0029a.f246a}), Token.CCOMMENT), i3, i4 + 60, 10, true);
        } else if (zM5133i) {
            C0119bk.m375a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(f1885ea, Token.LSH_EQ), i3, i4 + 60, 10, true);
        }
        if (z) {
            m1351b(poseStackPose, guiGraphics, i3, i4, i, i2);
        }
        int iM4208e = zM5133i ? ColorReferences.COLOR_THEME_RED_SOLID : c0834pM2684a.m2558ad() ? c0834pM2684a.m4208e() : ColorReferences.COLOR_TEAM_ALLIES_SOLID;
        C0119bk.m427a(guiGraphics, 0, this.height - 150, this.width, 150, iM4208e, iM4208e, 0.0f, 0.25f);
    }

    /* JADX INFO: renamed from: b */
    private void m1351b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) throws MatchException {
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        ModConnection modConnectionA = c0357g.m1716a();
        ConnectionStatus connectionStatusA = c0357g.m1716a();
        Component componentLiteral = Component.literal(C0029a.f246a);
        float fM366g = C0119bk.m366g();
        Component componentWithColor = Component.literal(C1293xp.m7912a(Math.max(modConnectionA.getReconnectTickCount() / 20, 0))).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        Component componentWithColor2 = Component.literal(C1293xp.m7912a(Math.max(modConnectionA.getLoginSendTimer() / 20, 0))).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        EnumC0231dg currentStage = EnumC0231dg.getCurrentStage(connectionStatusA);
        int iOrdinal = currentStage.ordinal();
        Pair<Component, Component> displayComponents = currentStage.getDisplayComponents(componentLiteral, (connectionStatusA == ConnectionStatus.CLOSED || connectionStatusA == ConnectionStatus.CONNECTED_NOT_ENCRYPTED) ? componentWithColor : componentWithColor2, fM366g);
        int i5 = i2 + 38;
        Component component = (Component) displayComponents.first();
        Component component2 = (Component) displayComponents.second();
        int iWidth = this.font.width(component) + 4;
        int i6 = i - (iWidth / 2);
        int i7 = i5 - 3;
        C0119bk.m415a(guiGraphics, i6 + 1, i7, iWidth - 2, 1, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, i6, i7 + 1, iWidth, 11, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, i6 + 1, (i7 + 13) - 1, iWidth - 2, 1, C0119bk.m365p());
        C0119bk.m399a(poseStack, this.font, guiGraphics, component, i, i5);
        if (C0119bk.m473b(i6, i7, iWidth, 13.0d, i3, i4)) {
            guiGraphics.renderTooltip(this.font, component2, i3, i4);
        }
        int i8 = f1895ga;
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
                C0119bk.m415a(guiGraphics, i13, i14, 36, 2, i15);
            }
            if (!z3 && !z2 && z) {
                C0119bk.m424b(poseStack, guiGraphics, i13, i14, 36.0f, 2.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, i15);
            }
            C0119bk.m439b(poseStack, guiGraphics, f1889bq, i12, i10, 32);
            C0119bk.m439b(poseStack, guiGraphics, z ? f1890br : f1891bs, i12, i10, 32);
            C0119bk.m439b(poseStack, guiGraphics, EnumC0231dg.values()[i11].getIconTexture(), i12, i10, 16);
            i11++;
        }
    }
}
