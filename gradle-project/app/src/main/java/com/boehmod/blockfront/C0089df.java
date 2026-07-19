package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.df, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/df.class */
public class C0089df extends AbstractC0084da {
    private static final int fV = 936;
    private static final int fW = 156;
    public static final int fX = 16;
    public static final int fY = 32;
    public static final int fZ = 32;
    public static final int gb = 150;

    @Nullable
    private C0048bs d;

    @Nullable
    private C0048bs e;

    @Nullable
    private C0048bs f;
    private boolean bo = true;

    @NotNull
    private static final Component dU = Component.translatable("bf.screen.introduction.online");

    @NotNull
    private static final Component dV = Component.translatable("bf.screen.introduction.offline");

    @NotNull
    private static final Component dW = Component.translatable("bf.screen.introduction.offline.tip");

    @NotNull
    private static final Component dX = Component.translatable("bf.screen.introduction.online.tip");

    @NotNull
    private static final Component dY = Component.translatable("bf.screen.introduction.online.cancel.tip", new Object[]{C0002a.a});

    @NotNull
    private static final Component dZ = Component.translatable("bf.message.cancel");

    @NotNull
    private static final Component ea = Component.translatable("bf.menu.text.anticheat.detected.par1").withColor(ColorReferences.COLOR_THEME_RED);

    @NotNull
    private static final Component eb = Component.translatable("bf.cloud.popup.update.button");

    @NotNull
    private static final Component ec = Component.translatable("bf.cloud.popup.update.button.tip");

    @NotNull
    private static final ResourceLocation bp = C0265jv.d("textures/gui/logo/blockfront.png");

    @NotNull
    private static final ResourceLocation bq = C0265jv.d("textures/gui/intro/stage_background.png");

    @NotNull
    private static final ResourceLocation br = C0265jv.d("textures/gui/intro/stage_background_complete.png");

    @NotNull
    private static final ResourceLocation bs = C0265jv.d("textures/gui/intro/stage_background_incomplete.png");
    public static final int ga = EnumC0090dg.values().length;

    public boolean y() {
        return ((fV) this.e.a()).m404a(this.b).y();
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    protected void init() {
        super.init();
        this.f = new C0048bs((this.width / 2) - 50, (this.height / 2) + 54, 100, 20, dZ, button -> {
            C0163g c0163g = (C0163g) this.e.b();
            c0163g.a(EnumC0190h.UNDECIDED);
            c0163g.a().disconnect("User cancelled connection", false);
        }).a(dY).a(C0048bs.c.DEFAULT).a(C0048bs.a.SHADOW);
        this.f.active = false;
        this.f.visible = false;
        addRenderableWidget(this.f);
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @NotNull
    protected List<C0088de> f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0459r c0459r = (C0459r) this.e.b();
        objectArrayList.add(new C0088de(dU, button -> {
            if (this.e.m588a().ad()) {
                this.b.setScreen(new C0044bo(this));
                return;
            }
            C0163g c0163g = (C0163g) this.e.b();
            c0163g.a(EnumC0190h.ONLINE);
            if (this.bo) {
                this.bo = false;
                c0163g.a().bumpReconnectTick();
            }
        }).a(c0048bs -> {
            this.d = c0048bs;
            c0048bs.a(c0048bs -> {
                return (c0459r.i() || ((C0163g) this.e.b()).a() == EnumC0190h.ONLINE) ? false : true;
            });
        }).a(ColorReferences.COLOR_TEAM_ALLIES_SOLID, ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID).a(ColorReferences.COLOR_WHITE).a(dX));
        objectArrayList.add(new C0088de(dV, button2 -> {
            ((C0163g) this.e.b()).a(EnumC0190h.OFFLINE);
            this.b.setScreen(b());
        }).a(c0048bs2 -> {
            this.e = c0048bs2;
            c0048bs2.a(c0048bs2 -> {
                return ((C0163g) this.e.b()).a() != EnumC0190h.ONLINE;
            });
        }).a(dW));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected SoundEvent b() {
        return null;
    }

    public void tick() {
        super.tick();
        C0163g c0163g = (C0163g) this.e.b();
        boolean z = c0163g.a() == EnumC0190h.ONLINE;
        ConnectionStatus connectionStatusA = c0163g.a();
        C0459r c0459r = (C0459r) this.e.b();
        C0405p c0405pM588a = this.e.m588a();
        if (z && connectionStatusA.isConnected() && connectionStatusA.isVerified() && y()) {
            this.b.setScreen(b());
        }
        if (this.f != null) {
            this.f.active = z;
            this.f.visible = z;
        }
        if (this.d != null) {
            this.d.visible = !z;
        }
        if (this.e != null) {
            this.e.visible = !z;
        }
        if (c0405pM588a.ad()) {
            if (this.d != null) {
                this.d.a(C0048bs.c.DEFAULT);
                this.d.a(0);
                this.d.b(0);
                this.d.setMessage(eb);
                this.d.e(c0405pM588a.e());
                this.d.f(ColorReferences.COLOR_WHITE_SOLID);
                this.d.a(ec);
                return;
            }
            return;
        }
        if (c0459r.i() && this.d != null) {
            this.d.e(ColorReferences.COLOR_THEME_RED_SOLID);
            this.d.f(ColorReferences.COLOR_THEME_RED_HOVERED_SOLID);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0084da
    @Nullable
    protected ResourceLocation i() {
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // com.boehmod.blockfront.AbstractC0084da
    public void renderBackground(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) throws MatchException {
        super.renderBackground(guiGraphics, i, i2, f);
        C0405p c0405pM588a = this.e.m588a();
        C0459r c0459r = (C0459r) this.e.b();
        boolean z = ((C0163g) this.e.b()).a() == EnumC0190h.ONLINE;
        boolean zI = c0459r.i();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(poseStackPose, guiGraphics, bp, i3, i4 - 20, 936.0f, 156.0f, 0.25f);
        if (c0405pM588a.ad()) {
            C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(Component.translatable("bf.cloud.popup.update.message", new Object[]{Component.literal(c0405pM588a.s()).withColor(c0405pM588a.d()), C0002a.a}), Token.CCOMMENT), i3, i4 + 60, 10, true);
        } else if (zI) {
            C0040bk.a(poseStackPose, this.font, (MultiBufferSource) guiGraphics.bufferSource(), (List<FormattedCharSequence>) this.font.split(ea, Token.LSH_EQ), i3, i4 + 60, 10, true);
        }
        if (z) {
            b(poseStackPose, guiGraphics, i3, i4, i, i2);
        }
        int iE = zI ? ColorReferences.COLOR_THEME_RED_SOLID : c0405pM588a.ad() ? c0405pM588a.e() : ColorReferences.COLOR_TEAM_ALLIES_SOLID;
        C0040bk.a(guiGraphics, 0, this.height - 150, this.width, 150, iE, iE, 0.0f, 0.25f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4) throws MatchException {
        C0163g c0163g = (C0163g) this.e.b();
        ModConnection modConnectionA = c0163g.a();
        ConnectionStatus connectionStatusA = c0163g.a();
        Component componentLiteral = Component.literal(C0002a.a);
        float fG = C0040bk.g();
        Component componentWithColor = Component.literal(C0637xp.a(Math.max(modConnectionA.getReconnectTickCount() / 20, 0))).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        Component componentWithColor2 = Component.literal(C0637xp.a(Math.max(modConnectionA.getLoginSendTimer() / 20, 0))).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);
        EnumC0090dg currentStage = EnumC0090dg.getCurrentStage(connectionStatusA);
        int iOrdinal = currentStage.ordinal();
        Pair<Component, Component> displayComponents = currentStage.getDisplayComponents(componentLiteral, (connectionStatusA == ConnectionStatus.CLOSED || connectionStatusA == ConnectionStatus.CONNECTED_NOT_ENCRYPTED) ? componentWithColor : componentWithColor2, fG);
        int i5 = i2 + 38;
        Component component = (Component) displayComponents.first();
        Component component2 = (Component) displayComponents.second();
        int iWidth = this.font.width(component) + 4;
        int i6 = i - (iWidth / 2);
        int i7 = i5 - 3;
        C0040bk.a(guiGraphics, i6 + 1, i7, iWidth - 2, 1, C0040bk.p());
        C0040bk.a(guiGraphics, i6, i7 + 1, iWidth, 11, C0040bk.p());
        C0040bk.a(guiGraphics, i6 + 1, (i7 + 13) - 1, iWidth - 2, 1, C0040bk.p());
        C0040bk.a(poseStack, this.font, guiGraphics, component, i, i5);
        if (C0040bk.b(i6, i7, iWidth, 13.0d, i3, i4)) {
            guiGraphics.renderTooltip(this.font, component2, i3, i4);
        }
        int i8 = ga;
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
                C0040bk.a(guiGraphics, i13, i14, 36, 2, i15);
            }
            if (!z3 && !z2 && z) {
                C0040bk.b(poseStack, guiGraphics, i13, i14, 36.0f, 2.0f, ColorReferences.COLOR_TEAM_ALLIES_SOLID, i15);
            }
            C0040bk.b(poseStack, guiGraphics, bq, i12, i10, 32);
            C0040bk.b(poseStack, guiGraphics, z ? br : bs, i12, i10, 32);
            C0040bk.b(poseStack, guiGraphics, EnumC0090dg.values()[i11].getIconTexture(), i12, i10, 16);
            i11++;
        }
    }
}
