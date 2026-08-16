package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.news.NewsArticleSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dJ.class */
public final class C0209dJ extends AbstractC0141cE {

    /* JADX INFO: renamed from: hL */
    private static final int f1614hL = 300;

    /* JADX INFO: renamed from: hM */
    private static final int f1615hM = 20;

    /* JADX INFO: renamed from: hN */
    private static final int f1616hN = 5;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final NewsArticleSummary f1618a;

    /* JADX INFO: renamed from: b */
    private C0289ek<AbstractC0298et> f1619b;

    /* JADX INFO: renamed from: W */
    private String f1620W;

    /* JADX INFO: renamed from: bD */
    private boolean f1621bD;

    /* JADX INFO: renamed from: fj */
    @NotNull
    private static final Component f1613fj = Component.translatable("bf.container.news.loading").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final SimpleDateFormat f1617a = new SimpleDateFormat("MMM d, yyyy", Locale.ROOT);

    public C0209dJ(@Nullable Screen screen, @NotNull NewsArticleSummary newsArticleSummary) {
        super(screen, Component.literal(newsArticleSummary.title()));
        this.f1620W = null;
        this.f1621bD = false;
        this.f1618a = newsArticleSummary;
    }

    /* JADX INFO: renamed from: S */
    private int m1245S() {
        return (this.width - 300) / 2;
    }

    /* JADX INFO: renamed from: T */
    private int m1246T() {
        return this.height - 40;
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    protected boolean mo437a(double d, double d2) {
        return !C0129bt.m573b((double) m1245S(), 20.0d, 300.0d, (double) m1246T(), d, d2);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo775a(@NotNull GuiGraphics guiGraphics, float f) {
        super.mo775a(guiGraphics, f);
        C0129bt.m591c(guiGraphics, m1245S(), 20, 300, m1246T(), C0129bt.m465t());
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        this.f1619b = new C0289ek<>(m1245S() + 5, 25, Token.RSH_EQ, m1246T() - 10, this);
        m794a(this.f1619b);
        this.f1057f.m2863a().m1532b(this.f1618a.m0id());
        m1247ai();
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f1619b == null) {
            return;
        }
        C0276eX c0276eXM2863a = this.f1057f.m2863a();
        String strM1535a = c0276eXM2863a.m1535a(this.f1618a.m0id());
        C0276eX.a aVarM1534a = c0276eXM2863a.m1534a(this.f1618a.m0id());
        boolean z = (aVarM1534a == null || aVarM1534a.m1540j() == null) ? false : true;
        if (!Objects.equals(this.f1620W, strM1535a) || this.f1621bD != z) {
            m1247ai();
        }
    }

    /* JADX INFO: renamed from: ai */
    private void m1247ai() {
        C0276eX c0276eXM2863a = this.f1057f.m2863a();
        String strM1535a = c0276eXM2863a.m1535a(this.f1618a.m0id());
        C0276eX.a aVarM1534a = c0276eXM2863a.m1534a(this.f1618a.m0id());
        this.f1620W = strM1535a;
        this.f1621bD = (aVarM1534a == null || aVarM1534a.m1540j() == null) ? false : true;
        this.f1619b.m1578ar();
        this.f1619b.m1577a(new C0291em(Component.literal(this.f1618a.title()).withStyle(ChatFormatting.BOLD)).m1590b());
        this.f1619b.m1577a(new C0291em(Component.translatable("bf.menu.news.byline", new Object[]{Component.literal(this.f1618a.author()).withColor(ColorReferences.COLOR_STOPWATCH), Component.literal(f1617a.format(new Date(this.f1618a.timestamp()))).withStyle(ChatFormatting.DARK_GRAY)}).withStyle(ChatFormatting.GRAY)).m1589a().m1590b());
        this.f1619b.m1577a(new C0291em(Component.empty()));
        if (this.f1621bD) {
            this.f1619b.m1577a(new a(this.f1618a.m0id()));
            this.f1619b.m1577a(new C0291em(Component.empty()));
        }
        if (strM1535a == null) {
            this.f1619b.m1577a(new C0291em(f1613fj).m1590b());
            return;
        }
        for (String str : strM1535a.split("\n", -1)) {
            this.f1619b.m1577a(new C0291em(C1265xE.m7140b(str)).m1590b());
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dJ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dJ$a.class */
    private static final class a extends AbstractC0298et {

        /* JADX INFO: renamed from: hO */
        private static final int f1622hO = 90;

        /* JADX INFO: renamed from: g */
        private final long f1623g;

        /* JADX INFO: renamed from: bE */
        static final /* synthetic */ boolean f1624bE;

        static {
            f1624bE = !C0209dJ.class.desiredAssertionStatus();
        }

        private a(long j) {
            this.f1623g = j;
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: o */
        public void mo864o(@NotNull Minecraft minecraft) {
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: w */
        public boolean mo865w() {
            return false;
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: a */
        public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
            super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
            C0276eX.a aVarM1534a = c0623l.m2863a().m1534a(this.f1623g);
            if (aVarM1534a == null || aVarM1534a.m1540j() == null) {
                return;
            }
            float fM1249a = m1249a(aVarM1534a.m1541x(), aVarM1534a.height());
            int iMax = Math.max(1, Math.round(aVarM1534a.m1541x() * fM1249a));
            int iMax2 = Math.max(1, Math.round(aVarM1534a.height() * fM1249a));
            C0129bt.m593c(guiGraphics, this.f2339iY + 2, this.f2340iZ, iMax, iMax2, 0, 0.4f);
            C0129bt.m531a(poseStack, guiGraphics, aVarM1534a.m1540j(), this.f2339iY + 2, this.f2340iZ, iMax, iMax2);
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        public int height() {
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f1624bE && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null!");
            }
            C0276eX.a aVarM1534a = c0623lM2852b.m2863a().m1534a(this.f1623g);
            if (aVarM1534a == null || aVarM1534a.m1540j() == null) {
                return 0;
            }
            return Math.max(1, Math.round(aVarM1534a.height() * m1249a(aVarM1534a.m1541x(), aVarM1534a.height())));
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: x */
        public int mo866x() {
            return this.f2338a.m374x();
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: U */
        public int mo1248U() {
            return 2;
        }

        /* JADX INFO: renamed from: a */
        private float m1249a(int i, int i2) {
            return Math.min((mo866x() - 19) / i, 90.0f / i2);
        }
    }
}
