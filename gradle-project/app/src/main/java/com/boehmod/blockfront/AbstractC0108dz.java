package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.boehmod.blockfront.C0115ef;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dz.class */
public abstract class AbstractC0108dz extends C0093dj {
    private static final Component fe = Component.translatable("bf.screen.menu.scoreboard");
    private static final Component ff = Component.translatable("bf.menu.button.nav.text.scoreboard");
    private static final Component fg = Component.translatable("bf.menu.button.scoreboard.players");
    private static final Component fh = Component.translatable("bf.menu.button.scoreboard.clans");

    @NotNull
    private static final ResourceLocation bI = C0265jv.d("textures/gui/menu/icons/armory_filter_armor.png");

    @NotNull
    private static final ResourceLocation bJ = C0265jv.d("textures/gui/menu/icons/armory_filter_card.png");

    @NotNull
    private static final ResourceLocation bK = C0265jv.d("textures/gui/menu/icons/refresh_black.png");
    private static final Component fi = Component.translatable("bf.message.achievement.nodata").withStyle(ChatFormatting.RED).withStyle(C0266jw.b);
    private static final int gF = 64;
    private static final int gG = 16;
    public dY<C0115ef> c;

    @NotNull
    public abstract Object2IntMap<UUID> a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract C0115ef.a mo317a();

    public AbstractC0108dz() {
        super(fe, ff);
        ((C0163g) this.e.b()).a().a(RequestType.CLOUD_STATS);
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        int i = ((this.width / 2) - C0093dj.gc) + C0097dn.gq + C0097dn.gs + 3;
        addRenderableWidget(new C0048bs(i, 56, 16, 16, Component.empty(), button -> {
            this.b.setScreen(new dB());
        }).a(C0048bs.a.NONE).a(fg).a(bI).d(16).a(c0048bs -> {
            return this.b.screen instanceof dA;
        }));
        addRenderableWidget(new C0048bs(i, 75, 16, 16, Component.empty(), button2 -> {
            this.b.setScreen(new dA());
        }).a(C0048bs.a.NONE).a(fh).a(bJ).d(16).a(c0048bs2 -> {
            return this.b.screen instanceof dB;
        }));
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        long time = hN.f161f - Calendar.getInstance().getTime().getTime();
        if (time < 0) {
            time = 0;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        String strB = C0637xp.b(time);
        int iN = this.c.n();
        int iO = this.c.o() + this.c.height() + 3;
        int iT = this.c.t();
        C0040bk.c(guiGraphics, iN, iO, iT, 12, ColorReferences.COLOR_THEME_YELLOW_SOLID);
        int iWidth = this.font.width(strB);
        int i3 = iN + (iT / 2) + 6;
        C0040bk.c(this.font, guiGraphics, (Component) Component.literal(strB), i3, iO + 2, 0);
        C0040bk.a(poseStackPose, guiGraphics, bK, ((i3 - (iWidth / 2)) - 12) - 3, iO, 12, 12);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        float fG = C0040bk.g();
        PoseStack poseStackPose = guiGraphics.pose();
        C0040bk.c(guiGraphics, this.c.n(), this.c.o(), this.c.t(), this.c.height(), C0040bk.p());
        if (this.c.V() <= 0) {
            int iN = this.c.n();
            int iO = this.c.o();
            int iT = (int) (iN + (this.c.t() / 2.0f));
            C0040bk.a(poseStackPose, guiGraphics, iT - 32.0f, (((int) (iO + (this.c.height() / 2.0f))) - 32.0f) - 10.0f, 64, C0040bk.bC, fG);
            C0040bk.c(poseStackPose, this.font, guiGraphics, fi, iT, r0 + 30);
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        this.c = new dZ(((this.width / 2) - C0093dj.gc) + C0097dn.gs, 56, C0097dn.gq, 121, this);
        a(this.c);
        ae();
    }

    public void ae() {
        this.c.am();
        C0115ef.a aVarMo317a = mo317a();
        boolean z = false;
        int i = 0;
        for (Map.Entry entry : iH.a((Map) a())) {
            dY<C0115ef> dYVar = this.c;
            i++;
            C0115ef c0115ef = new C0115ef((UUID) entry.getKey(), ((Integer) entry.getValue()).intValue(), i, aVarMo317a);
            boolean z2 = !z;
            z = z2;
            dYVar.a(c0115ef.a(z2));
        }
    }
}
