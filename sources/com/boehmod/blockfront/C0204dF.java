package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.p000mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.p000mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0120bl;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dF.class */
public final class C0204dF extends AbstractC0205dG {

    /* JADX INFO: renamed from: fG */
    private static final Component f1642fG = Component.translatable("bf.message.matches.tab.matches");

    /* JADX INFO: renamed from: fH */
    private static final Component f1643fH = Component.translatable("bf.message.matches.tab.performance");

    /* JADX INFO: renamed from: fI */
    private static final Component f1644fI = Component.translatable("bf.message.matches.refresh");

    /* JADX INFO: renamed from: fJ */
    private static final Component f1645fJ = Component.translatable("bf.message.matches.fetching").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: fK */
    private static final Component f1646fK = Component.translatable("bf.message.matches.nodata").withStyle(ChatFormatting.RED).withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: fL */
    private static final Component f1647fL = Component.translatable("bf.message.matches.nofilter").withStyle(ChatFormatting.RED).withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: bL */
    private static final ResourceLocation f1648bL = C0564jv.m2555d("textures/gui/menu/icons/refresh.png");

    /* JADX INFO: renamed from: gO */
    private static final int f1649gO = 16;

    /* JADX INFO: renamed from: gP */
    private static final int f1650gP = 3;

    /* JADX INFO: renamed from: gQ */
    private static final int f1651gQ = 100;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0224dZ<AbstractC0284eg> f1652c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private c f1653a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f1654a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private b f1655a;

    /* JADX INFO: renamed from: bz */
    private boolean f1656bz;

    /* JADX INFO: renamed from: bA */
    private boolean f1657bA;

    /* JADX INFO: renamed from: bB */
    private boolean f1658bB;

    /* JADX INFO: renamed from: bC */
    private boolean f1659bC;

    /* JADX INFO: renamed from: gR */
    private int f1660gR;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0120bl f1661a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.dF$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dF$c.class */
    private enum c {
        MATCHES,
        PERFORMANCE
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dF$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dF$a.class */
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

        a(@NotNull String str, @Nullable MatchResult matchResult) {
            this.icon = C0564jv.m2555d("textures/gui/menu/icons/" + str + ".png");
            this.tooltip = Component.translatable("bf.message.matches.filter." + str);
            this.result = matchResult;
        }

        private boolean accepts(@NotNull MatchSummary matchSummary) {
            return this.result == null || matchSummary.result() == this.result;
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dF$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dF$b.class */
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

        b(@NotNull String str, int i, @Nullable ToDoubleFunction toDoubleFunction) {
            ResourceLocation resourceLocationM2555d;
            if ("all".equals(str)) {
                resourceLocationM2555d = C0564jv.m2555d("textures/gui/menu/icons/all.png");
            } else {
                resourceLocationM2555d = C0564jv.m2555d("textures/gui/menu/icons/" + str + ".png");
            }
            this.icon = resourceLocationM2555d;
            this.label = Component.translatable("bf.message.matches.stat." + str);
            this.color = i;
            this.extractor = toDoubleFunction;
        }

        public int getColor() {
            return this.color;
        }
    }

    public C0204dF(@NotNull Screen screen, @NotNull C0482iS c0482iS) {
        super(screen, c0482iS, Component.translatable("bf.screen.profile.matches", new Object[]{c0482iS.getUsername()}));
        this.f1652c = new C0224dZ<>(0, 84, 235, 148, this);
        this.f1653a = c.MATCHES;
        this.f1654a = a.ALL;
        this.f1655a = b.ALL;
        this.f1656bz = false;
        this.f1657bA = false;
        this.f1658bB = false;
        this.f1659bC = false;
        this.f1660gR = 0;
        this.f1661a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        if (!this.f1659bC) {
            this.f1659bC = true;
            m1224z();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        int iM1228N = (m1228N() - 4) / 2;
        int iM1226L = m1226L();
        addRenderableWidget(new C0127bs(iM1226L, 58, iM1228N, 12, f1642fG, button -> {
            m1220a(c.MATCHES);
        }).m649a(0.0f, 1.0f).m653a(C0127bs.a.SHADOW).m642a(c0127bs -> {
            return this.f1653a != c.MATCHES;
        }));
        addRenderableWidget(new C0127bs(iM1226L + iM1228N + 4, 58, iM1228N, 12, f1643fH, button2 -> {
            m1220a(c.PERFORMANCE);
        }).m649a(0.0f, 1.0f).m653a(C0127bs.a.SHADOW).m642a(c0127bs2 -> {
            return this.f1653a != c.PERFORMANCE;
        }));
        m1218af();
    }

    /* JADX INFO: renamed from: af */
    private void m1218af() {
        int iM1226L = m1226L() + m1228N() + 4;
        addRenderableWidget(new C0127bs(iM1226L, m1227M() - 19, 16, 16, Component.empty(), button -> {
            m1223ag();
        }).m653a(C0127bs.a.NONE).m651a(f1644fI).m645a(f1648bL).m646d(16).m642a(c0127bs -> {
            return this.f1660gR == 0;
        }));
        int iM1227M = m1227M() + 19;
        if (this.f1653a == c.MATCHES) {
            int i = 0;
            for (a aVar : a.values()) {
                int i2 = i;
                i++;
                addRenderableWidget(new C0127bs(iM1226L, iM1227M + (19 * i2), 16, 16, Component.empty(), button2 -> {
                    m1221a(aVar);
                }).m653a(C0127bs.a.NONE).m651a(aVar.tooltip).m645a(aVar.icon).m646d(16).m642a(c0127bs2 -> {
                    return this.f1654a != aVar;
                }));
            }
            return;
        }
        int i3 = 0;
        for (b bVar : b.values()) {
            int i4 = i3;
            i3++;
            addRenderableWidget(new C0127bs(iM1226L, iM1227M + (19 * i4), 16, 16, Component.empty(), button3 -> {
                m1222a(bVar);
            }).m653a(C0127bs.a.NONE).m651a(bVar.label).m645a(bVar.icon).m646d(16).m642a(c0127bs3 -> {
                return this.f1655a != bVar;
            }));
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        ObjectList<MatchSummary> objectListM2201d = this.playerCloudData.m2201d();
        this.f1657bA = objectListM2201d != null;
        this.f1658bB = (objectListM2201d == null || objectListM2201d.isEmpty()) ? false : true;
        this.f1661a = null;
        if (this.f1658bB) {
            if (this.f1653a == c.MATCHES) {
                this.f1652c.m1317am();
                this.f1652c.m700c(m1226L());
                this.f1652c.m701d(m1227M());
                this.f1652c.m1314e(m1228N());
                this.f1652c.m703f(m1229O());
                this.f1652c.m708g(true);
                m1195a(this.f1652c);
                ObjectListIterator it = objectListM2201d.iterator();
                while (it.hasNext()) {
                    MatchSummary matchSummary = (MatchSummary) it.next();
                    if (this.f1654a.accepts(matchSummary)) {
                        this.f1652c.m1316a(new C0282ee(matchSummary));
                    }
                }
                return;
            }
            this.f1661a = new C0120bl(objectListM2201d, m1219b(), m1226L(), m1227M(), m1228N(), m1229O());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private ObjectList<C0120bl.b> m1219b() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f1655a == b.ALL) {
            for (b bVar : b.values()) {
                if (bVar.extractor != null) {
                    objectArrayList.add(new C0120bl.b(bVar.label, bVar.color, bVar.extractor));
                }
            }
        } else if (this.f1655a.extractor != null) {
            objectArrayList.add(new C0120bl.b(this.f1655a.label, this.f1655a.color, this.f1655a.extractor));
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0205dG, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        if (this.f1660gR > 0) {
            this.f1660gR--;
        }
        if (this.f1661a != null) {
            this.f1661a.m595l(this.f1587b);
        }
        if (this.playerCloudData.m2201d() == null) {
            if (!this.f1656bz) {
                m1225ah();
            }
        } else if (!this.f1657bA) {
            rebuildWidgets();
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0119bk.m491c(guiGraphics, m1226L(), m1227M(), m1228N(), m1229O(), C0119bk.m365p());
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        float fM366g = C0119bk.m366g();
        int i3 = this.width / 2;
        int iM1227M = m1227M() + (m1229O() / 2);
        ObjectList<MatchSummary> objectListM2201d = this.playerCloudData.m2201d();
        if (objectListM2201d == null) {
            C0119bk.m487a(guiGraphics, i3 - 24, (iM1227M - 24) - 12, 48, ColorReferences.COLOR_WHITE_SOLID, fM366g);
            C0119bk.m383c(this.font, guiGraphics, (Component) Component.empty().append(f1645fJ).append(C0116bh.m346a(fM366g)).withStyle(C0565jw.f3201b), i3, iM1227M + 22);
        } else {
            if (objectListM2201d.isEmpty()) {
                C0119bk.m383c(this.font, guiGraphics, f1646fK, i3, iM1227M);
                return;
            }
            if (this.f1653a == c.PERFORMANCE) {
                if (this.f1661a != null) {
                    this.f1661a.m596a(guiGraphics, this.f1587b, this.font, i, i2, f);
                }
            } else if (this.f1652c.m1324g().isEmpty()) {
                C0119bk.m383c(this.font, guiGraphics, f1647fL, i3, iM1227M);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1220a(@NotNull c cVar) {
        if (this.f1653a == cVar) {
            return;
        }
        this.f1653a = cVar;
        rebuildWidgets();
    }

    /* JADX INFO: renamed from: a */
    private void m1221a(@NotNull a aVar) {
        if (this.f1654a == aVar) {
            return;
        }
        this.f1654a = aVar;
        rebuildWidgets();
    }

    /* JADX INFO: renamed from: a */
    private void m1222a(@NotNull b bVar) {
        if (this.f1655a == bVar) {
            return;
        }
        this.f1655a = bVar;
        rebuildWidgets();
    }

    /* JADX INFO: renamed from: ag */
    private void m1223ag() {
        if (m1224z()) {
            rebuildWidgets();
        }
    }

    /* JADX INFO: renamed from: z */
    private boolean m1224z() {
        if (this.f1660gR > 0) {
            return false;
        }
        this.f1660gR = 100;
        this.f1652c.m1317am();
        this.f1657bA = false;
        this.f1658bB = false;
        this.playerCloudData.m2202aZ();
        this.f1656bz = false;
        m1225ah();
        return true;
    }

    /* JADX INFO: renamed from: ah */
    private void m1225ah() {
        this.f1656bz = true;
        ((C0357g) this.f1586e.m2667b()).m1716a().m2165b(RequestType.PLAYER_MATCHES, this.playerCloudData.getUUID());
    }

    /* JADX INFO: renamed from: L */
    private int m1226L() {
        return (this.width / 2) - 143;
    }

    /* JADX INFO: renamed from: M */
    private int m1227M() {
        return 74;
    }

    /* JADX INFO: renamed from: N */
    private int m1228N() {
        return Token.NUMBER;
    }

    /* JADX INFO: renamed from: O */
    private int m1229O() {
        return (this.height - m1227M()) - 55;
    }
}
