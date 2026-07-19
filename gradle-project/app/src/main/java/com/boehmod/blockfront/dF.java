package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.mm.report.MatchResult;
import com.boehmod.bflib.cloud.common.mm.report.MatchSummary;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0041bl;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dF.class */
public final class dF extends dG {
    private static final Component fG = Component.translatable("bf.message.matches.tab.matches");
    private static final Component fH = Component.translatable("bf.message.matches.tab.performance");
    private static final Component fI = Component.translatable("bf.message.matches.refresh");
    private static final Component fJ = Component.translatable("bf.message.matches.fetching").withStyle(C0266jw.b);
    private static final Component fK = Component.translatable("bf.message.matches.nodata").withStyle(ChatFormatting.RED).withStyle(C0266jw.b);
    private static final Component fL = Component.translatable("bf.message.matches.nofilter").withStyle(ChatFormatting.RED).withStyle(C0266jw.b);
    private static final ResourceLocation bL = C0265jv.d("textures/gui/menu/icons/refresh.png");
    private static final int gO = 16;
    private static final int gP = 3;
    private static final int gQ = 100;

    @NotNull
    private final dZ<AbstractC0116eg> c;

    @NotNull
    private c a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private a f108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private b f109a;
    private boolean bz;
    private boolean bA;
    private boolean bB;
    private boolean bC;
    private int gR;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private C0041bl f110a;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dF$c.class */
    private enum c {
        MATCHES,
        PERFORMANCE
    }

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
            this.icon = C0265jv.d("textures/gui/menu/icons/" + str + ".png");
            this.tooltip = Component.translatable("bf.message.matches.filter." + str);
            this.result = matchResult;
        }

        private boolean accepts(@NotNull MatchSummary matchSummary) {
            return this.result == null || matchSummary.result() == this.result;
        }
    }

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
            ResourceLocation resourceLocationD;
            if ("all".equals(str)) {
                resourceLocationD = C0265jv.d("textures/gui/menu/icons/all.png");
            } else {
                resourceLocationD = C0265jv.d("textures/gui/menu/icons/" + str + ".png");
            }
            this.icon = resourceLocationD;
            this.label = Component.translatable("bf.message.matches.stat." + str);
            this.color = i;
            this.extractor = toDoubleFunction;
        }

        public int getColor() {
            return this.color;
        }
    }

    public dF(@NotNull Screen screen, @NotNull iS iSVar) {
        super(screen, iSVar, Component.translatable("bf.screen.profile.matches", new Object[]{iSVar.getUsername()}));
        this.c = new dZ<>(0, 84, 235, 148, this);
        this.a = c.MATCHES;
        this.f108a = a.ALL;
        this.f109a = b.ALL;
        this.bz = false;
        this.bA = false;
        this.bB = false;
        this.bC = false;
        this.gR = 0;
        this.f110a = null;
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        if (!this.bC) {
            this.bC = true;
            z();
        }
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        int iN = (N() - 4) / 2;
        int iL = L();
        addRenderableWidget(new C0048bs(iL, 58, iN, 12, fG, button -> {
            a(c.MATCHES);
        }).a(0.0f, 1.0f).a(C0048bs.a.SHADOW).a(c0048bs -> {
            return this.a != c.MATCHES;
        }));
        addRenderableWidget(new C0048bs(iL + iN + 4, 58, iN, 12, fH, button2 -> {
            a(c.PERFORMANCE);
        }).a(0.0f, 1.0f).a(C0048bs.a.SHADOW).a(c0048bs2 -> {
            return this.a != c.PERFORMANCE;
        }));
        af();
    }

    private void af() {
        int iL = L() + N() + 4;
        addRenderableWidget(new C0048bs(iL, M() - 19, 16, 16, Component.empty(), button -> {
            ag();
        }).a(C0048bs.a.NONE).a(fI).a(bL).d(16).a(c0048bs -> {
            return this.gR == 0;
        }));
        int iM = M() + 19;
        if (this.a == c.MATCHES) {
            int i = 0;
            for (a aVar : a.values()) {
                int i2 = i;
                i++;
                addRenderableWidget(new C0048bs(iL, iM + (19 * i2), 16, 16, Component.empty(), button2 -> {
                    a(aVar);
                }).a(C0048bs.a.NONE).a(aVar.tooltip).a(aVar.icon).d(16).a(c0048bs2 -> {
                    return this.f108a != aVar;
                }));
            }
            return;
        }
        int i3 = 0;
        for (b bVar : b.values()) {
            int i4 = i3;
            i3++;
            addRenderableWidget(new C0048bs(iL, iM + (19 * i4), 16, 16, Component.empty(), button3 -> {
                a(bVar);
            }).a(C0048bs.a.NONE).a(bVar.label).a(bVar.icon).d(16).a(c0048bs3 -> {
                return this.f109a != bVar;
            }));
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        ObjectList<MatchSummary> objectListD = this.playerCloudData.d();
        this.bA = objectListD != null;
        this.bB = (objectListD == null || objectListD.isEmpty()) ? false : true;
        this.f110a = null;
        if (this.bB) {
            if (this.a == c.MATCHES) {
                this.c.am();
                this.c.c(L());
                this.c.d(M());
                this.c.e(N());
                this.c.f(O());
                this.c.g(true);
                a(this.c);
                ObjectListIterator it = objectListD.iterator();
                while (it.hasNext()) {
                    MatchSummary matchSummary = (MatchSummary) it.next();
                    if (this.f108a.accepts(matchSummary)) {
                        this.c.a(new C0114ee(matchSummary));
                    }
                }
                return;
            }
            this.f110a = new C0041bl(objectListD, b(), L(), M(), N(), O());
        }
    }

    @NotNull
    private ObjectList<C0041bl.b> b() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f109a == b.ALL) {
            for (b bVar : b.values()) {
                if (bVar.extractor != null) {
                    objectArrayList.add(new C0041bl.b(bVar.label, bVar.color, bVar.extractor));
                }
            }
        } else if (this.f109a.extractor != null) {
            objectArrayList.add(new C0041bl.b(this.f109a.label, this.f109a.color, this.f109a.extractor));
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.dG, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        if (this.gR > 0) {
            this.gR--;
        }
        if (this.f110a != null) {
            this.f110a.l(this.b);
        }
        if (this.playerCloudData.d() == null) {
            if (!this.bz) {
                ah();
            }
        } else if (!this.bA) {
            rebuildWidgets();
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        C0040bk.c(guiGraphics, L(), M(), N(), O(), C0040bk.p());
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        float fG2 = C0040bk.g();
        int i3 = this.width / 2;
        int iM = M() + (O() / 2);
        ObjectList<MatchSummary> objectListD = this.playerCloudData.d();
        if (objectListD == null) {
            C0040bk.a(guiGraphics, i3 - 24, (iM - 24) - 12, 48, ColorReferences.COLOR_WHITE_SOLID, fG2);
            C0040bk.c(this.font, guiGraphics, (Component) Component.empty().append(fJ).append(C0037bh.a(fG2)).withStyle(C0266jw.b), i3, iM + 22);
        } else {
            if (objectListD.isEmpty()) {
                C0040bk.c(this.font, guiGraphics, fK, i3, iM);
                return;
            }
            if (this.a == c.PERFORMANCE) {
                if (this.f110a != null) {
                    this.f110a.a(guiGraphics, this.b, this.font, i, i2, f);
                }
            } else if (this.c.g().isEmpty()) {
                C0040bk.c(this.font, guiGraphics, fL, i3, iM);
            }
        }
    }

    private void a(@NotNull c cVar) {
        if (this.a == cVar) {
            return;
        }
        this.a = cVar;
        rebuildWidgets();
    }

    private void a(@NotNull a aVar) {
        if (this.f108a == aVar) {
            return;
        }
        this.f108a = aVar;
        rebuildWidgets();
    }

    private void a(@NotNull b bVar) {
        if (this.f109a == bVar) {
            return;
        }
        this.f109a = bVar;
        rebuildWidgets();
    }

    private void ag() {
        if (z()) {
            rebuildWidgets();
        }
    }

    private boolean z() {
        if (this.gR > 0) {
            return false;
        }
        this.gR = 100;
        this.c.am();
        this.bA = false;
        this.bB = false;
        this.playerCloudData.aZ();
        this.bz = false;
        ah();
        return true;
    }

    private void ah() {
        this.bz = true;
        ((C0163g) this.e.b()).a().b(RequestType.PLAYER_MATCHES, this.playerCloudData.getUUID());
    }

    private int L() {
        return (this.width / 2) - 143;
    }

    private int M() {
        return 74;
    }

    private int N() {
        return Token.NUMBER;
    }

    private int O() {
        return (this.height - M()) - 55;
    }
}
