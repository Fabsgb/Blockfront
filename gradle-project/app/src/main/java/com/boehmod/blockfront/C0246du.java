package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.SearchRegion;
import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.du */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/du.class */
public final class C0246du extends AbstractC0141cE {

    /* JADX INFO: renamed from: eF */
    private static final Component f2015eF = Component.translatable("bf.screen.menu.lobby.edit");

    /* JADX INFO: renamed from: eG */
    private static final Component f2016eG = Component.translatable("bf.menu.button.nav.text.lobby");

    /* JADX INFO: renamed from: eH */
    private static final Component f2017eH = Component.translatable("bf.message.server.all");

    /* JADX INFO: renamed from: eI */
    private static final Component f2018eI = Component.translatable("bf.message.server.us");

    /* JADX INFO: renamed from: eJ */
    private static final Component f2019eJ = Component.translatable("bf.message.server.eu");

    /* JADX INFO: renamed from: by */
    private static final ResourceLocation f2020by = C0532jO.m2378d("textures/gui/flag_all.png");

    /* JADX INFO: renamed from: bz */
    private static final ResourceLocation f2021bz = C0532jO.m2378d("textures/gui/flag_us.png");

    /* JADX INFO: renamed from: bA */
    private static final ResourceLocation f2022bA = C0532jO.m2378d("textures/gui/flag_eu.png");

    /* JADX INFO: renamed from: hp */
    private static final int f2023hp = 20;

    /* JADX INFO: renamed from: hq */
    private static final int f2024hq = 25;

    /* JADX INFO: renamed from: hr */
    private static final int f2025hr = 185;

    /* JADX INFO: renamed from: hs */
    private static final int f2026hs = 75;

    /* JADX INFO: renamed from: ht */
    private static final int f2027ht = 16;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1094tt.a f2028a;

    /* JADX INFO: renamed from: b */
    private AbstractC0288ej<C0293eo> f2029b;

    public C0246du(@NotNull Screen screen) {
        super(screen, f2015eF);
        this.f2028a = C1094tt.a.ALL;
        this.f1055bl = f2016eG;
        mo783a(true);
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    protected boolean mo437a(double d, double d2) {
        return d2 > 210.0d && !C0129bt.m573b((double) m1407Q(), (double) m1408R(), 75.0d, 16.0d, d, d2);
    }

    /* JADX INFO: renamed from: Q */
    private int m1407Q() {
        return (this.width / 2) - 37;
    }

    /* JADX INFO: renamed from: R */
    private int m1408R() {
        return (this.height - 16) - 10;
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        this.f2029b = new C0287ei(0, 25, this.width, f2025hr, this);
        m794a(this.f2029b);
        m1412a(this.f2028a);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        m1410af();
        addRenderableWidget(new C0085bB(m1407Q(), m1408R(), f2026hs, 16, Component.translatable("bf.menu.button.cancel"), button -> {
            m782N();
        }).m328a(C0085bB.a.SHADOW));
    }

    /* JADX INFO: renamed from: ae */
    private void m1409ae() {
        SearchRegion searchRegionM2575a = this.f1057f.m2885a().m2575a();
        C0396gl c0396gl = (C0396gl) this.f1057f.m2855a();
        int i = this.width / 2;
        int i2 = this.height - 56;
        int width = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0085bB(i, i2, 35, 14, Component.empty(), button -> {
            m1411a(c0396gl, SearchRegion.ALL);
        }).m330b(f2020by).m333a(searchRegionM2575a != SearchRegion.ALL).m326a(f2017eH));
        objectArrayList.add(new C0085bB(i, i2, 35, 14, Component.empty(), button2 -> {
            m1411a(c0396gl, SearchRegion.US);
        }).m330b(f2021bz).m333a(searchRegionM2575a != SearchRegion.US).m326a(f2018eI));
        objectArrayList.add(new C0085bB(i, i2, 35, 14, Component.empty(), button3 -> {
            m1411a(c0396gl, SearchRegion.EU);
        }).m330b(f2022bA).m333a(searchRegionM2575a != SearchRegion.EU).m326a(f2019eJ));
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            width += ((C0085bB) it.next()).getWidth() + 3;
        }
        int i3 = (i - (width / 2)) + 1;
        int width2 = 0;
        ObjectListIterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            C0085bB c0085bB = (C0085bB) it2.next();
            c0085bB.setX(i3 + width2);
            addRenderableWidget(c0085bB);
            width2 += c0085bB.getWidth() + 3;
        }
    }

    /* JADX INFO: renamed from: af */
    public void m1410af() {
        int length = (this.width / 2) - (((C1094tt.a.values().length * 50) - 2) / 2);
        for (C1094tt.a aVar : C1094tt.a.values()) {
            addRenderableWidget(new C0085bB(length, 2, 48, 20, aVar.getTitle().copy(), button -> {
                m1412a(aVar);
            }).m326a(aVar.getTip()).m327a(C0085bB.b.CENTER).m328a(C0085bB.a.NONE));
            length += 50;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1411a(@NotNull C0396gl c0396gl, @NotNull SearchRegion searchRegion) {
        this.f1057f.m2885a().m2576a(searchRegion);
        ((C0358g) this.f1057f.m2852b()).m1724a(c0396gl, this.f1058a, this.f1057f);
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7963pk.get(), 1.0f));
        this.f1058a.setScreen(new C0246du(this.f1035c));
    }

    /* JADX INFO: renamed from: a */
    private void m1412a(@NotNull C1094tt.a aVar) {
        this.f2028a = aVar;
        this.f2029b.m1578ar();
        if (!this.f1056a.m1886a(this.f1058a).hasCompletedBootcamp()) {
            C0293eo c0293eo = new C0293eo(C1094tt.f5907b);
            c0293eo.m1611c(Component.translatable("bf.container.gamemode.click", new Object[]{C1094tt.f5907b.getDisplayName().copy().withColor(ColorReferences.COLOR_TEAM_ALLIES)}));
            this.f2029b.m1577a(c0293eo);
            return;
        }
        for (C1094tt c1094tt : C1094tt.m6020a(aVar)) {
            if (!c1094tt.m6029cg()) {
                C0293eo c0293eo2 = new C0293eo(c1094tt);
                MutableComponent mutableComponentWithColor = c1094tt.getDisplayName().copy().withColor(ColorReferences.COLOR_TEAM_ALLIES);
                MutableComponent mutableComponentEmpty = Component.empty();
                if (c1094tt.m6027cf()) {
                    mutableComponentEmpty.append(" (").append(Component.translatable("bf.container.gamemode.experimental")).append(")").withStyle(ChatFormatting.GRAY);
                }
                c0293eo2.m1611c(Component.translatable("bf.container.gamemode.click", new Object[]{mutableComponentWithColor}).append(mutableComponentEmpty));
                this.f2029b.m1577a(c0293eo2);
            }
        }
        this.f1055bl = aVar.getTitle();
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo775a(@NotNull GuiGraphics guiGraphics, float f) {
        super.mo775a(guiGraphics, f);
        C0129bt.m591c(guiGraphics, 0, 0, this.width, 20, C0129bt.m465t());
    }
}
