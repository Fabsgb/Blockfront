package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.PopupType;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ef */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ef.class */
public class C0284ef extends C0143cG {

    /* JADX INFO: renamed from: hg */
    private static final Component f2230hg = Component.translatable("bf.message.okay");

    /* JADX INFO: renamed from: hh */
    private static final Component f2231hh = Component.translatable("bf.settings.save.prompt.title").withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: hi */
    private static final Component f2232hi = Component.translatable("bf.settings.save.prompt.message");

    /* JADX INFO: renamed from: hj */
    private static final Component f2233hj = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: hk */
    private static final Component f2234hk = Component.translatable("bf.settings.save");

    /* JADX INFO: renamed from: hl */
    private static final Component f2235hl = Component.translatable("bf.settings.discard");

    /* JADX INFO: renamed from: hm */
    private static final Component f2236hm = Component.translatable("bf.settings.save.message");

    /* JADX INFO: renamed from: hn */
    private static final Component f2237hn = Component.translatable("bf.settings.discard.message");

    /* JADX INFO: renamed from: k */
    @NotNull
    protected final Screen f2238k;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0289ek<AbstractC0298et> f2239b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0497ig f2240a;

    /* JADX INFO: renamed from: l */
    @Nullable
    private C0085bB f2241l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private C0085bB f2242m;

    public C0284ef(@NotNull Screen screen) {
        this(screen, C0496if.f3077b);
    }

    public C0284ef(@NotNull Screen screen, @NotNull C0497ig c0497ig) {
        super(Component.translatable(c0497ig.getName()));
        this.f2239b = null;
        this.f2238k = screen;
        this.f2240a = c0497ig;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        int i = this.width / 2;
        int width = 0;
        ObjectArrayList<C0085bB> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0085bB(i, 40, 0, 7, Component.literal("Minecraft").withStyle(ChatFormatting.BOLD), button -> {
            this.f1058a.setScreen(new OptionsScreen(this, this.f1058a.options));
        }).m322a(12, 12).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE));
        for (C0497ig c0497ig : C0496if.f3076V) {
            if (c0497ig.m2237t()) {
                objectArrayList.add(new C0085bB(i, 40, 0, 7, Component.translatable(c0497ig.getName()).withStyle(ChatFormatting.BOLD), button2 -> {
                    this.f1058a.setScreen(new C0284ef(this.f2238k, c0497ig));
                }).m322a(12, 12).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE));
            }
        }
        objectArrayList.add(new C0085bB(i, 40, 0, 7, Component.translatable("bf.settings.update").withStyle(ChatFormatting.BOLD), button3 -> {
            this.f1058a.setScreen(new C0133bx(this));
        }).m322a(12, 12).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE));
        for (C0085bB c0085bB : objectArrayList) {
            c0085bB.setWidth(((this.font.width(c0085bB.getMessage().getString()) + 15) / 2) + 4);
            width += c0085bB.getWidth() + 2;
        }
        int i2 = i - (width / 2);
        int width2 = 0;
        for (C0085bB c0085bB2 : objectArrayList) {
            c0085bB2.setX(i2 + width2);
            addRenderableWidget(c0085bB2);
            width2 += c0085bB2.getWidth() + 2;
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f2241l != null) {
            this.f2241l.visible = C0495ie.f3075cR;
        }
        if (this.f2242m != null) {
            this.f2242m.visible = C0495ie.f3075cR;
        }
        if (m787b(this.f1058a)) {
            m1553N();
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        if (this.f2239b != null) {
            C0129bt.m591c(guiGraphics, this.f2239b.m381r(), this.f2239b.m385s(), this.f2239b.m374x(), this.f2239b.height(), C0129bt.m465t());
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        C0085bB c0085bB = new C0085bB(5, 18, 20, 20, Component.empty(), button -> {
            if (C0495ie.f3075cR) {
                C0623l.m2853a(f2231hh, f2232hi, PopupType.FAIL, new C0131bv(f2230hg, null, button -> {
                    this.f1058a.setScreen(this);
                }));
            } else {
                m1553N();
            }
        });
        addRenderableWidget(c0085bB);
        c0085bB.m320a(f1037aH);
        c0085bB.m322a(20, 20);
        c0085bB.m328a(C0085bB.a.NONE);
        c0085bB.m326a(f2233hj);
        addRenderableWidget(c0085bB);
        int i = this.width / 2;
        int i2 = (this.height - 43) - 11;
        C0085bB c0085bBM328a = new C0085bB(i - 67, i2, 65, 11, f2235hl, button2 -> {
            m1552ap();
        }).m324a(0.0f, 1.0f).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW);
        this.f2242m = c0085bBM328a;
        addRenderableWidget(c0085bBM328a);
        this.f2242m.visible = C0495ie.f3075cR;
        C0085bB c0085bBM341f = new C0085bB(i + 2, i2, 65, 11, f2234hk, button3 -> {
            m1551ao();
        }).m324a(0.0f, 1.0f).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID);
        this.f2241l = c0085bBM341f;
        addRenderableWidget(c0085bBM341f);
        this.f2241l.visible = C0495ie.f3075cR;
    }

    /* JADX INFO: renamed from: ao */
    private void m1551ao() {
        C0498ih.m2238e(this.f1057f);
        C0495ie.f3075cR = false;
        C0301ew.m1623a(this.f1058a, f2236hm);
    }

    /* JADX INFO: renamed from: ap */
    private void m1552ap() {
        C0498ih.m2239f(this.f1057f);
        C0495ie.f3075cR = false;
        C0301ew.m1623a(this.f1058a, f2237hn);
    }

    /* JADX INFO: renamed from: N */
    public void m1553N() {
        C0498ih.m2239f(this.f1057f);
        C0498ih.m2238e(this.f1057f);
        this.f1058a.setScreen(this.f2238k);
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        this.f2239b = new C0289ek<>(((this.width / 2) - 160) + 25 + 4, 51, Token.NUMBER, this.height - 108, this);
        this.f2239b.m383g(true);
        Iterator<C0494id> it = this.f2240a.m2236n().iterator();
        while (it.hasNext()) {
            this.f2239b.m1577a(new C0285eg(it.next()));
        }
        m794a(this.f2239b);
    }
}
