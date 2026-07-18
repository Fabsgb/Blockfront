package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.boehmod.blockfront.C0283ef;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dz.class */
public abstract class AbstractC0250dz extends C0234dj {

    /* JADX INFO: renamed from: fe */
    private static final Component f2044fe = Component.translatable("bf.screen.menu.scoreboard");

    /* JADX INFO: renamed from: ff */
    private static final Component f2045ff = Component.translatable("bf.menu.button.nav.text.scoreboard");

    /* JADX INFO: renamed from: fg */
    private static final Component f2046fg = Component.translatable("bf.menu.button.scoreboard.players");

    /* JADX INFO: renamed from: fh */
    private static final Component f2047fh = Component.translatable("bf.menu.button.scoreboard.clans");

    /* JADX INFO: renamed from: bI */
    @NotNull
    private static final ResourceLocation f2048bI = C0564jv.m2555d("textures/gui/menu/icons/armory_filter_armor.png");

    /* JADX INFO: renamed from: bJ */
    @NotNull
    private static final ResourceLocation f2049bJ = C0564jv.m2555d("textures/gui/menu/icons/armory_filter_card.png");

    /* JADX INFO: renamed from: bK */
    @NotNull
    private static final ResourceLocation f2050bK = C0564jv.m2555d("textures/gui/menu/icons/refresh_black.png");

    /* JADX INFO: renamed from: fi */
    private static final Component f2051fi = Component.translatable("bf.message.achievement.nodata").withStyle(ChatFormatting.RED).withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: gF */
    private static final int f2052gF = 64;

    /* JADX INFO: renamed from: gG */
    private static final int f2053gG = 16;

    /* JADX INFO: renamed from: c */
    public AbstractC0223dY<C0283ef> f2054c;

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Object2IntMap<UUID> mo1204a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract C0283ef.a mo1205a();

    public AbstractC0250dz() {
        super(f2044fe, f2045ff);
        ((C0357g) this.f1586e.m2667b()).m1716a().m2164a(RequestType.CLOUD_STATS);
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        int i = ((this.width / 2) - C0234dj.f1918gc) + C0238dn.f1976gq + C0238dn.f1978gs + 3;
        addRenderableWidget(new C0127bs(i, 56, 16, 16, Component.empty(), button -> {
            this.f1587b.setScreen(new C0200dB());
        }).m653a(C0127bs.a.NONE).m651a(f2046fg).m645a(f2048bI).m646d(16).m642a(c0127bs -> {
            return this.f1587b.screen instanceof C0199dA;
        }));
        addRenderableWidget(new C0127bs(i, 75, 16, 16, Component.empty(), button2 -> {
            this.f1587b.setScreen(new C0199dA());
        }).m653a(C0127bs.a.NONE).m651a(f2047fh).m645a(f2049bJ).m646d(16).m642a(c0127bs2 -> {
            return this.f1587b.screen instanceof C0200dB;
        }));
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        long time = C0424hN.f2772f - Calendar.getInstance().getTime().getTime();
        if (time < 0) {
            time = 0;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        String strM7916b = C1293xp.m7916b(time);
        int iN = this.f2054c.m709n();
        int iO = this.f2054c.m710o() + this.f2054c.height() + 3;
        int iT = this.f2054c.m699t();
        C0119bk.m491c(guiGraphics, iN, iO, iT, 12, ColorReferences.COLOR_THEME_YELLOW_SOLID);
        int iWidth = this.font.width(strM7916b);
        int i3 = iN + (iT / 2) + 6;
        C0119bk.m385c(this.font, guiGraphics, (Component) Component.literal(strM7916b), i3, iO + 2, 0);
        C0119bk.m431a(poseStackPose, guiGraphics, f2050bK, ((i3 - (iWidth / 2)) - 12) - 3, iO, 12, 12);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        float fM366g = C0119bk.m366g();
        PoseStack poseStackPose = guiGraphics.pose();
        C0119bk.m491c(guiGraphics, this.f2054c.m709n(), this.f2054c.m710o(), this.f2054c.m699t(), this.f2054c.height(), C0119bk.m365p());
        if (this.f2054c.m1323V() <= 0) {
            int iN = this.f2054c.m709n();
            int iO = this.f2054c.m710o();
            int iT = (int) (iN + (this.f2054c.m699t() / 2.0f));
            C0119bk.m486a(poseStackPose, guiGraphics, iT - 32.0f, (((int) (iO + (this.f2054c.height() / 2.0f))) - 32.0f) - 10.0f, 64, C0119bk.f726bC, fM366g);
            C0119bk.m382c(poseStackPose, this.font, guiGraphics, f2051fi, iT, r0 + 30);
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        this.f2054c = new C0224dZ(((this.width / 2) - C0234dj.f1918gc) + C0238dn.f1978gs, 56, C0238dn.f1976gq, 121, this);
        m1195a(this.f2054c);
        m1418ae();
    }

    /* JADX INFO: renamed from: ae */
    public void m1418ae() {
        this.f2054c.m1317am();
        C0283ef.a aVarMo1205a = mo1205a();
        boolean z = false;
        int i = 0;
        for (Map.Entry entry : C0471iH.m2133a((Map) mo1204a())) {
            AbstractC0223dY<C0283ef> abstractC0223dY = this.f2054c;
            i++;
            C0283ef c0283ef = new C0283ef((UUID) entry.getKey(), ((Integer) entry.getValue()).intValue(), i, aVarMo1205a);
            boolean z2 = !z;
            z = z2;
            abstractC0223dY.m1316a(c0283ef.m1494a(z2));
        }
    }
}
