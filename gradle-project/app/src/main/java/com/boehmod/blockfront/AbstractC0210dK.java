package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dK.class */
public abstract class AbstractC0210dK extends C0244ds {

    /* JADX INFO: renamed from: fk */
    private static final Component f1625fk = Component.translatable("bf.screen.menu.scoreboard");

    /* JADX INFO: renamed from: fl */
    private static final Component f1626fl = Component.translatable("bf.menu.button.nav.text.scoreboard");

    /* JADX INFO: renamed from: fm */
    private static final Component f1627fm = Component.translatable("bf.menu.button.scoreboard.players");

    /* JADX INFO: renamed from: fn */
    private static final Component f1628fn = Component.translatable("bf.menu.button.scoreboard.clans");

    /* JADX INFO: renamed from: bG */
    @NotNull
    private static final ResourceLocation f1629bG = C0532jO.m2378d("textures/gui/menu/icons/armory_filter_armor.png");

    /* JADX INFO: renamed from: bH */
    @NotNull
    private static final ResourceLocation f1630bH = C0532jO.m2378d("textures/gui/menu/icons/armory_filter_card.png");

    /* JADX INFO: renamed from: bI */
    @NotNull
    private static final ResourceLocation f1631bI = C0532jO.m2378d("textures/gui/menu/icons/refresh_black.png");

    /* JADX INFO: renamed from: fo */
    private static final Component f1632fo = Component.translatable("bf.message.achievement.nodata").withStyle(ChatFormatting.RED).withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: hP */
    private static final int f1633hP = 64;

    /* JADX INFO: renamed from: hQ */
    private static final int f1634hQ = 16;

    /* JADX INFO: renamed from: c */
    public AbstractC0288ej<C0297es> f1635c;

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Object2IntMap<UUID> mo1251a();

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract C0297es.a mo1252a();

    public AbstractC0210dK() {
        super(f1625fk, f1626fl);
        ((C0358g) this.f1057f.m2852b()).m1722a().m2491a(RequestType.CLOUD_STATS);
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        int i = ((this.width / 2) - C0244ds.f1978hc) + C0248dw.f2040hv + C0248dw.f2042hx + 3;
        addRenderableWidget(new C0085bB(i, 56, 16, 16, Component.empty(), button -> {
            this.f1058a.setScreen(new C0212dM());
        }).m328a(C0085bB.a.NONE).m326a(f1627fm).m320a(f1629bG).m321d(16).m317a(c0085bB -> {
            return this.f1058a.screen instanceof C0211dL;
        }));
        addRenderableWidget(new C0085bB(i, 75, 16, 16, Component.empty(), button2 -> {
            this.f1058a.setScreen(new C0211dL());
        }).m328a(C0085bB.a.NONE).m326a(f1628fn).m320a(f1630bH).m321d(16).m317a(c0085bB2 -> {
            return this.f1058a.screen instanceof C0212dM;
        }));
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        long time = C0495ie.f3074k - Calendar.getInstance().getTime().getTime();
        if (time < 0) {
            time = 0;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        String strM7243c = C1273xM.m7243c(time);
        int iR = this.f1635c.m381r();
        int iS = this.f1635c.m385s() + this.f1635c.height() + 3;
        int iX = this.f1635c.m374x();
        C0129bt.m591c(guiGraphics, iR, iS, iX, 12, ColorReferences.COLOR_THEME_YELLOW_SOLID);
        int iWidth = this.font.width(strM7243c);
        int i3 = iR + (iX / 2) + 6;
        C0129bt.m485c(this.font, guiGraphics, (Component) Component.literal(strM7243c), i3, iS + 2, 0);
        C0129bt.m531a(poseStackPose, guiGraphics, f1631bI, ((i3 - (iWidth / 2)) - 12) - 3, iS, 12, 12);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        float fM466g = C0129bt.m466g();
        PoseStack poseStackPose = guiGraphics.pose();
        C0129bt.m591c(guiGraphics, this.f1635c.m381r(), this.f1635c.m385s(), this.f1635c.m374x(), this.f1635c.height(), C0129bt.m465t());
        if (this.f1635c.m1584ae() <= 0) {
            int iR = this.f1635c.m381r();
            int iS = this.f1635c.m385s();
            int iX = (int) (iR + (this.f1635c.m374x() / 2.0f));
            int iHeight = (int) (iS + (this.f1635c.height() / 2.0f));
            C0129bt.m586a(poseStackPose, guiGraphics, iX - 32.0f, (iHeight - 32.0f) - 10.0f, 64, C0129bt.f861cu, fM466g);
            C0129bt.m482c(poseStackPose, this.font, guiGraphics, f1632fo, iX, iHeight + 30);
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        this.f1635c = new C0289ek(((this.width / 2) - C0244ds.f1978hc) + C0248dw.f2042hx, 56, C0248dw.f2040hv, 121, this);
        m794a(this.f1635c);
        m1250aj();
    }

    /* JADX INFO: renamed from: aj */
    public void m1250aj() {
        this.f1635c.m1578ar();
        C0297es.a aVarMo1252a = mo1252a();
        boolean z = false;
        int i = 0;
        for (Map.Entry entry : C0544ja.m2460a((Map) mo1251a())) {
            AbstractC0288ej<C0297es> abstractC0288ej = this.f1635c;
            i++;
            C0297es c0297es = new C0297es((UUID) entry.getKey(), ((Integer) entry.getValue()).intValue(), i, aVarMo1252a);
            boolean z2 = !z;
            z = z2;
            abstractC0288ej.m1577a(c0297es.m1610a(z2));
        }
    }
}
