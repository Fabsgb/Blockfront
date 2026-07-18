package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dU.class */
public class C0219dU extends C0195cx {

    /* JADX INFO: renamed from: ha */
    private static final Component f1789ha = Component.translatable("bf.message.okay");

    /* JADX INFO: renamed from: hb */
    private static final Component f1790hb = Component.translatable("bf.settings.save.prompt.title").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: hc */
    private static final Component f1791hc = Component.translatable("bf.settings.save.prompt.message");

    /* JADX INFO: renamed from: hd */
    private static final Component f1792hd = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: he */
    private static final Component f1793he = Component.translatable("bf.settings.save");

    /* JADX INFO: renamed from: hf */
    private static final Component f1794hf = Component.translatable("bf.settings.discard");

    /* JADX INFO: renamed from: hg */
    private static final Component f1795hg = Component.translatable("bf.settings.save.message");

    /* JADX INFO: renamed from: hh */
    private static final Component f1796hh = Component.translatable("bf.settings.discard.message");

    /* JADX INFO: renamed from: l */
    @NotNull
    protected final Screen f1797l;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0224dZ<AbstractC0284eg> f1798b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0426hP f1799a;

    /* JADX INFO: renamed from: l */
    @Nullable
    private C0127bs f1800l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private C0127bs f1801m;

    public C0219dU(@NotNull Screen screen) {
        this(screen, C0425hO.f2775b);
    }

    public C0219dU(@NotNull Screen screen, @NotNull C0426hP c0426hP) {
        super(Component.translatable(c0426hP.getName()));
        this.f1798b = null;
        this.f1797l = screen;
        this.f1799a = c0426hP;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        int i = this.width / 2;
        int width = 0;
        ObjectArrayList<C0127bs> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0127bs(i, 40, 0, 7, Component.literal("Minecraft").withStyle(ChatFormatting.BOLD), button -> {
            this.f1587b.setScreen(new OptionsScreen(this, this.f1587b.options));
        }).m647a(12, 12).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE));
        for (C0426hP c0426hP : C0425hO.f2774S) {
            if (c0426hP.m2003s()) {
                objectArrayList.add(new C0127bs(i, 40, 0, 7, Component.translatable(c0426hP.getName()).withStyle(ChatFormatting.BOLD), button2 -> {
                    this.f1587b.setScreen(new C0219dU(this.f1797l, c0426hP));
                }).m647a(12, 12).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE));
            }
        }
        objectArrayList.add(new C0127bs(i, 40, 0, 7, Component.translatable("bf.settings.update").withStyle(ChatFormatting.BOLD), button3 -> {
            this.f1587b.setScreen(new C0123bo(this));
        }).m647a(12, 12).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE));
        for (C0127bs c0127bs : objectArrayList) {
            c0127bs.setWidth(((this.font.width(c0127bs.getMessage().getString()) + 15) / 2) + 4);
            width += c0127bs.getWidth() + 2;
        }
        int i2 = i - (width / 2);
        int width2 = 0;
        for (C0127bs c0127bs2 : objectArrayList) {
            c0127bs2.setX(i2 + width2);
            addRenderableWidget(c0127bs2);
            width2 += c0127bs2.getWidth() + 2;
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        if (this.f1800l != null) {
            this.f1800l.visible = C0424hN.f2773cI;
        }
        if (this.f1801m != null) {
            this.f1801m.visible = C0424hN.f2773cI;
        }
        if (m1188b(this.f1587b)) {
            m1291J();
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        if (this.f1798b != null) {
            C0119bk.m491c(guiGraphics, this.f1798b.m709n(), this.f1798b.m710o(), this.f1798b.m699t(), this.f1798b.height(), C0119bk.m365p());
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        C0127bs c0127bs = new C0127bs(5, 18, 20, 20, Component.empty(), button -> {
            if (C0424hN.f2773cI) {
                C0622l.m2668a(f1790hb, f1791hc, PopupType.FAIL, new C0121bm(f1789ha, null, button -> {
                    this.f1587b.setScreen(this);
                }));
            } else {
                m1291J();
            }
        });
        addRenderableWidget(c0127bs);
        c0127bs.m645a(f1564aH);
        c0127bs.m647a(20, 20);
        c0127bs.m653a(C0127bs.a.NONE);
        c0127bs.m651a(f1792hd);
        addRenderableWidget(c0127bs);
        int i = this.width / 2;
        int i2 = (this.height - 43) - 11;
        C0127bs c0127bsM653a = new C0127bs(i - 67, i2, 65, 11, f1794hf, button2 -> {
            m1290ak();
        }).m649a(0.0f, 1.0f).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW);
        this.f1801m = c0127bsM653a;
        addRenderableWidget(c0127bsM653a);
        this.f1801m.visible = C0424hN.f2773cI;
        C0127bs c0127bsM666f = new C0127bs(i + 2, i2, 65, 11, f1793he, button3 -> {
            m1289aj();
        }).m649a(0.0f, 1.0f).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);
        this.f1800l = c0127bsM666f;
        addRenderableWidget(c0127bsM666f);
        this.f1800l.visible = C0424hN.f2773cI;
    }

    /* JADX INFO: renamed from: aj */
    private void m1289aj() {
        C0427hQ.m2004d(this.f1586e);
        C0424hN.f2773cI = false;
        C0287ej.m1507a(this.f1587b, f1795hg);
    }

    /* JADX INFO: renamed from: ak */
    private void m1290ak() {
        C0427hQ.m2005e(this.f1586e);
        C0424hN.f2773cI = false;
        C0287ej.m1507a(this.f1587b, f1796hh);
    }

    /* JADX INFO: renamed from: J */
    public void m1291J() {
        C0427hQ.m2005e(this.f1586e);
        C0427hQ.m2004d(this.f1586e);
        Screen screen = this.f1797l;
        if (screen instanceof AbstractC0193cv) {
            ((AbstractC0193cv) screen).f1557aU = true;
        }
        this.f1587b.setScreen(this.f1797l);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        this.f1798b = new C0224dZ<>(((this.width / 2) - 160) + 25 + 4, 51, Token.NUMBER, this.height - 108, this);
        this.f1798b.m708g(true);
        Iterator<C0423hM> it = this.f1799a.m2002l().iterator();
        while (it.hasNext()) {
            this.f1798b.m1316a(new C0220dV(it.next()));
        }
        m1195a(this.f1798b);
    }
}
