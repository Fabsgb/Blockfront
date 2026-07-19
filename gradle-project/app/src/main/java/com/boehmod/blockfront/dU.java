package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dU.class */
public class dU extends C0080cx {
    private static final Component ha = Component.translatable("bf.message.okay");
    private static final Component hb = Component.translatable("bf.settings.save.prompt.title").withColor(ColorReferences.COLOR_WHITE);
    private static final Component hc = Component.translatable("bf.settings.save.prompt.message");
    private static final Component hd = Component.translatable("bf.menu.button.back");
    private static final Component he = Component.translatable("bf.settings.save");
    private static final Component hf = Component.translatable("bf.settings.discard");
    private static final Component hg = Component.translatable("bf.settings.save.message");
    private static final Component hh = Component.translatable("bf.settings.discard.message");

    @NotNull
    protected final Screen l;

    @Nullable
    private dZ<AbstractC0116eg> b;

    @NotNull
    private final hP a;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    @Nullable
    private C0048bs f114l;

    @Nullable
    private C0048bs m;

    public dU(@NotNull Screen screen) {
        this(screen, hO.b);
    }

    public dU(@NotNull Screen screen, @NotNull hP hPVar) {
        super(Component.translatable(hPVar.getName()));
        this.b = null;
        this.l = screen;
        this.a = hPVar;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        int i = this.width / 2;
        int width = 0;
        ObjectArrayList<C0048bs> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0048bs(i, 40, 0, 7, Component.literal("Minecraft").withStyle(ChatFormatting.BOLD), button -> {
            this.b.setScreen(new OptionsScreen(this, this.b.options));
        }).a(12, 12).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE));
        for (hP hPVar : hO.S) {
            if (hPVar.s()) {
                objectArrayList.add(new C0048bs(i, 40, 0, 7, Component.translatable(hPVar.getName()).withStyle(ChatFormatting.BOLD), button2 -> {
                    this.b.setScreen(new dU(this.l, hPVar));
                }).a(12, 12).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE));
            }
        }
        objectArrayList.add(new C0048bs(i, 40, 0, 7, Component.translatable("bf.settings.update").withStyle(ChatFormatting.BOLD), button3 -> {
            this.b.setScreen(new C0044bo(this));
        }).a(12, 12).a(C0048bs.b.CENTER_BOTTOM).b(0.5f).a(0.0f, 4.0f).a(C0048bs.a.NONE));
        for (C0048bs c0048bs : objectArrayList) {
            c0048bs.setWidth(((this.font.width(c0048bs.getMessage().getString()) + 15) / 2) + 4);
            width += c0048bs.getWidth() + 2;
        }
        int i2 = i - (width / 2);
        int width2 = 0;
        for (C0048bs c0048bs2 : objectArrayList) {
            c0048bs2.setX(i2 + width2);
            addRenderableWidget(c0048bs2);
            width2 += c0048bs2.getWidth() + 2;
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        if (this.f114l != null) {
            this.f114l.visible = hN.cI;
        }
        if (this.m != null) {
            this.m.visible = hN.cI;
        }
        if (b(this.b)) {
            J();
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        if (this.b != null) {
            C0040bk.c(guiGraphics, this.b.n(), this.b.o(), this.b.t(), this.b.height(), C0040bk.p());
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        C0048bs c0048bs = new C0048bs(5, 18, 20, 20, Component.empty(), button -> {
            if (hN.cI) {
                C0297l.a(hb, hc, PopupType.FAIL, new C0042bm(ha, null, button -> {
                    this.b.setScreen(this);
                }));
            } else {
                J();
            }
        });
        addRenderableWidget(c0048bs);
        c0048bs.a(aH);
        c0048bs.a(20, 20);
        c0048bs.a(C0048bs.a.NONE);
        c0048bs.a(hd);
        addRenderableWidget(c0048bs);
        int i = this.width / 2;
        int i2 = (this.height - 43) - 11;
        C0048bs c0048bsA = new C0048bs(i - 67, i2, 65, 11, hf, button2 -> {
            ak();
        }).a(0.0f, 1.0f).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW);
        this.m = c0048bsA;
        addRenderableWidget(c0048bsA);
        this.m.visible = hN.cI;
        C0048bs c0048bsF = new C0048bs(i + 2, i2, 65, 11, he, button3 -> {
            aj();
        }).a(0.0f, 1.0f).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);
        this.f114l = c0048bsF;
        addRenderableWidget(c0048bsF);
        this.f114l.visible = hN.cI;
    }

    private void aj() {
        hQ.d(this.e);
        hN.cI = false;
        C0119ej.a(this.b, hg);
    }

    private void ak() {
        hQ.e(this.e);
        hN.cI = false;
        C0119ej.a(this.b, hh);
    }

    public void J() {
        hQ.e(this.e);
        hQ.d(this.e);
        Screen screen = this.l;
        if (screen instanceof AbstractC0078cv) {
            ((AbstractC0078cv) screen).aU = true;
        }
        this.b.setScreen(this.l);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        this.b = new dZ<>(((this.width / 2) - 160) + 25 + 4, 51, Token.NUMBER, this.height - 108, this);
        this.b.g(true);
        Iterator<hM> it = this.a.l().iterator();
        while (it.hasNext()) {
            this.b.a(new dV(it.next()));
        }
        a(this.b);
    }
}
