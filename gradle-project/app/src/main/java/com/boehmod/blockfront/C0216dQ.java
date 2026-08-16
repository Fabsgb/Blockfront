package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p001mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.p001mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.function.ToDoubleFunction;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dQ.class */
public final class C0216dQ extends AbstractC0217dR {

    /* JADX INFO: renamed from: fM */
    private static final Component f1671fM = Component.translatable("bf.message.matches.tab.matches");

    /* JADX INFO: renamed from: fN */
    private static final Component f1672fN = Component.translatable("bf.message.matches.tab.performance");

    /* JADX INFO: renamed from: fO */
    private static final Component f1673fO = Component.translatable("bf.message.matches.refresh");

    /* JADX INFO: renamed from: fP */
    private static final Component f1674fP = Component.translatable("bf.message.matches.fetching").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: fQ */
    private static final Component f1675fQ = Component.translatable("bf.message.matches.nodata").withStyle(ChatFormatting.RED).withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: fR */
    private static final Component f1676fR = Component.translatable("bf.message.matches.nofilter").withStyle(ChatFormatting.RED).withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bJ */
    private static final ResourceLocation f1677bJ = C0532jO.m2378d("textures/gui/menu/icons/refresh.png");

    /* JADX INFO: renamed from: hY */
    private static final int f1678hY = 16;

    /* JADX INFO: renamed from: hZ */
    private static final int f1679hZ = 3;

    /* JADX INFO: renamed from: ia */
    private static final int f1680ia = 100;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0289ek<AbstractC0298et> f1681d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private c f1682a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f1683a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private b f1684a;

    /* JADX INFO: renamed from: bF */
    private boolean f1685bF;

    /* JADX INFO: renamed from: bG */
    private boolean f1686bG;

    /* JADX INFO: renamed from: bH */
    private boolean f1687bH;

    /* JADX INFO: renamed from: bI */
    private boolean f1688bI;

    /* JADX INFO: renamed from: ib */
    private int f1689ib;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0130bu f1690a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.dQ$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dQ$c.class */
    private enum c {
        MATCHES,
        PERFORMANCE
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dQ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dQ$a.class */
    private enum a {
        ALL("all", null),
        WINS("wins", MatchResult.WIN),
        LOSSES("losses", MatchResult.LOSS),
        DRAWS("draws", MatchResult.DRAW);


        @NotNull
        private final ResourceLocation icon;

        @NotNull
        private final Component tooltip;

        @Nullable
        private final MatchResult result;

        a(String str, MatchResult matchResult) {
            this.icon = C0532jO.m2378d("textures/gui/menu/icons/" + str + ".png");
            this.tooltip = Component.translatable("bf.message.matches.filter." + str);
            this.result = matchResult;
        }

        private boolean accepts(@NotNull MatchSummary matchSummary) {
            return this.result == null || matchSummary.result() == this.result;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dQ$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dQ$b.class */
    public enum b {
        ALL("all", -1, null),
        KILLS("kills", -10504203, (v0) -> {
            return v0.kills();
        }),
        DEATHS("deaths", -1739917, (v0) -> {
            return v0.deaths();
        }),
        KD("kd", -669617, (v0) -> {
            return v0.killDeathRatio();
        }),
        SCORE("score", -8402305, (v0) -> {
            return v0.score();
        });


        @NotNull
        private final ResourceLocation icon;

        @NotNull
        private final Component label;
        private final int color;

        @Nullable
        private final ToDoubleFunction<MatchSummary> extractor;

        b(@Nullable String str, int i, ToDoubleFunction toDoubleFunction) {
            ResourceLocation resourceLocationM2378d;
            if ("all".equals(str)) {
                resourceLocationM2378d = C0532jO.m2378d("textures/gui/menu/icons/all.png");
            } else {
                resourceLocationM2378d = C0532jO.m2378d("textures/gui/menu/icons/" + str + ".png");
            }
            this.icon = resourceLocationM2378d;
            this.label = Component.translatable("bf.message.matches.stat." + str);
            this.color = i;
            this.extractor = toDoubleFunction;
        }

        public int getColor() {
            return this.color;
        }
    }

    public C0216dQ(@NotNull Screen screen, @NotNull C0555jl c0555jl) {
        super(screen, c0555jl, Component.translatable("bf.screen.profile.matches", new Object[]{c0555jl.getUsername()}));
        this.f1681d = new C0289ek<>(0, 84, 235, 148, this);
        this.f1682a = c.MATCHES;
        this.f1683a = a.ALL;
        this.f1684a = b.ALL;
        this.f1685bF = false;
        this.f1686bG = false;
        this.f1687bH = false;
        this.f1688bI = false;
        this.f1689ib = 0;
        this.f1690a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        if (!this.f1688bI) {
            this.f1688bI = true;
            m1275A();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        int iM1279X = (m1279X() - 4) / 2;
        int iM1277V = m1277V();
        addRenderableWidget(new C0085bB(iM1277V, 58, iM1279X, 12, f1671fM, button -> {
            m1271a(c.MATCHES);
        }).m324a(0.0f, 1.0f).m328a(C0085bB.a.SHADOW).m317a(c0085bB -> {
            return this.f1682a != c.MATCHES;
        }));
        addRenderableWidget(new C0085bB(iM1277V + iM1279X + 4, 58, iM1279X, 12, f1672fN, button2 -> {
            m1271a(c.PERFORMANCE);
        }).m324a(0.0f, 1.0f).m328a(C0085bB.a.SHADOW).m317a(c0085bB2 -> {
            return this.f1682a != c.PERFORMANCE;
        }));
        m1269ak();
    }

    /* JADX INFO: renamed from: ak */
    private void m1269ak() {
        int iM1277V = m1277V() + m1279X() + 4;
        addRenderableWidget(new C0085bB(iM1277V, m1278W() - 19, 16, 16, Component.empty(), button -> {
            m1274al();
        }).m328a(C0085bB.a.NONE).m326a(f1673fO).m320a(f1677bJ).m321d(16).m317a(c0085bB -> {
            return this.f1689ib == 0;
        }));
        int iM1278W = m1278W() + 19;
        if (this.f1682a == c.MATCHES) {
            int i = 0;
            for (a aVar : a.values()) {
                int i2 = i;
                i++;
                addRenderableWidget(new C0085bB(iM1277V, iM1278W + (19 * i2), 16, 16, Component.empty(), button2 -> {
                    m1272a(aVar);
                }).m328a(C0085bB.a.NONE).m326a(aVar.tooltip).m320a(aVar.icon).m321d(16).m317a(c0085bB2 -> {
                    return this.f1683a != aVar;
                }));
            }
            return;
        }
        int i3 = 0;
        for (b bVar : b.values()) {
            int i4 = i3;
            i3++;
            addRenderableWidget(new C0085bB(iM1277V, iM1278W + (19 * i4), 16, 16, Component.empty(), button3 -> {
                m1273a(bVar);
            }).m328a(C0085bB.a.NONE).m326a(bVar.label).m320a(bVar.icon).m321d(16).m317a(c0085bB3 -> {
                return this.f1684a != bVar;
            }));
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        ObjectList<MatchSummary> objectListM2528h = this.playerCloudData.m2528h();
        this.f1686bG = objectListM2528h != null;
        this.f1687bH = (objectListM2528h == null || objectListM2528h.isEmpty()) ? false : true;
        this.f1690a = null;
        if (this.f1687bH) {
            if (this.f1682a == c.MATCHES) {
                this.f1681d.m1578ar();
                this.f1681d.m375c(m1277V());
                this.f1681d.m376d(m1278W());
                this.f1681d.m1575e(m1279X());
                this.f1681d.m378f(m1280Y());
                this.f1681d.m383g(true);
                m794a(this.f1681d);
                ObjectListIterator it = objectListM2528h.iterator();
                while (it.hasNext()) {
                    MatchSummary matchSummary = (MatchSummary) it.next();
                    if (this.f1683a.accepts(matchSummary)) {
                        this.f1681d.m1577a(new C0295eq(matchSummary));
                    }
                }
                return;
            }
            this.f1690a = new C0130bu(objectListM2528h, m1270f(), m1277V(), m1278W(), m1279X(), m1280Y());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private ObjectList<C0130bu.b> m1270f() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f1684a == b.ALL) {
            for (b bVar : b.values()) {
                if (bVar.extractor != null) {
                    objectArrayList.add(new C0130bu.b(bVar.label, bVar.color, bVar.extractor));
                }
            }
        } else if (this.f1684a.extractor != null) {
            objectArrayList.add(new C0130bu.b(this.f1684a.label, this.f1684a.color, this.f1684a.extractor));
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0217dR, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f1689ib > 0) {
            this.f1689ib--;
        }
        if (this.f1690a != null) {
            this.f1690a.m700m(this.f1058a);
        }
        if (this.playerCloudData.m2528h() == null) {
            if (!this.f1685bF) {
                m1276am();
            }
        } else if (!this.f1686bG) {
            rebuildWidgets();
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0129bt.m591c(guiGraphics, m1277V(), m1278W(), m1279X(), m1280Y(), C0129bt.m465t());
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        float fM466g = C0129bt.m466g();
        int i3 = this.width / 2;
        int iM1278W = m1278W() + (m1280Y() / 2);
        ObjectList<MatchSummary> objectListM2528h = this.playerCloudData.m2528h();
        if (objectListM2528h == null) {
            C0129bt.m587a(guiGraphics, i3 - 24, (iM1278W - 24) - 12, 48, ColorReferences.COLOR_WHITE_SOLID, fM466g);
            C0129bt.m483c(this.font, guiGraphics, (Component) Component.empty().append(f1674fP).append(C0125bp.m439a(fM466g)).withStyle(C0533jP.f3185b), i3, iM1278W + 22);
        } else {
            if (objectListM2528h.isEmpty()) {
                C0129bt.m483c(this.font, guiGraphics, f1675fQ, i3, iM1278W);
                return;
            }
            if (this.f1682a == c.PERFORMANCE) {
                if (this.f1690a != null) {
                    this.f1690a.m701a(guiGraphics, this.f1058a, this.font, i, i2, f);
                }
            } else if (this.f1681d.m1585h().isEmpty()) {
                C0129bt.m483c(this.font, guiGraphics, f1676fR, i3, iM1278W);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1271a(@NotNull c cVar) {
        if (this.f1682a == cVar) {
            return;
        }
        this.f1682a = cVar;
        rebuildWidgets();
    }

    /* JADX INFO: renamed from: a */
    private void m1272a(@NotNull a aVar) {
        if (this.f1683a == aVar) {
            return;
        }
        this.f1683a = aVar;
        rebuildWidgets();
    }

    /* JADX INFO: renamed from: a */
    private void m1273a(@NotNull b bVar) {
        if (this.f1684a == bVar) {
            return;
        }
        this.f1684a = bVar;
        rebuildWidgets();
    }

    /* JADX INFO: renamed from: al */
    private void m1274al() {
        if (m1275A()) {
            rebuildWidgets();
        }
    }

    /* JADX INFO: renamed from: A */
    private boolean m1275A() {
        if (this.f1689ib > 0) {
            return false;
        }
        this.f1689ib = 100;
        this.f1681d.m1578ar();
        this.f1686bG = false;
        this.f1687bH = false;
        this.playerCloudData.m2529bl();
        this.f1685bF = false;
        m1276am();
        return true;
    }

    /* JADX INFO: renamed from: am */
    private void m1276am() {
        this.f1685bF = true;
        ((C0358g) this.f1057f.m2852b()).m1722a().m2492b(RequestType.PLAYER_MATCHES, this.playerCloudData.getUUID());
    }

    /* JADX INFO: renamed from: V */
    private int m1277V() {
        return (this.width / 2) - 143;
    }

    /* JADX INFO: renamed from: W */
    private int m1278W() {
        return 74;
    }

    /* JADX INFO: renamed from: X */
    private int m1279X() {
        return Token.NUMBER;
    }

    /* JADX INFO: renamed from: Y */
    private int m1280Y() {
        return (this.height - m1278W()) - 55;
    }
}
