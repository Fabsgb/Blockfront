package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cB.class */
public class C0137cB extends Screen {

    /* JADX INFO: renamed from: bS */
    private static final Component f1017bS = Component.translatable("bf.configurable_geo.title");

    /* JADX INFO: renamed from: bT */
    private static final Component f1018bT = Component.translatable("bf.configurable_geo.field.model");

    /* JADX INFO: renamed from: bU */
    private static final Component f1019bU = Component.translatable("bf.configurable_geo.field.animation_file");

    /* JADX INFO: renamed from: bV */
    private static final Component f1020bV = Component.translatable("bf.configurable_geo.field.animation_name");

    /* JADX INFO: renamed from: bW */
    private static final Component f1021bW = Component.translatable("bf.configurable_geo.field.texture");

    /* JADX INFO: renamed from: bX */
    private static final Component f1022bX = Component.translatable("bf.configurable_geo.field.rotation");

    /* JADX INFO: renamed from: bY */
    private static final Component f1023bY = Component.translatable("bf.configurable_geo.field.realtime");

    /* JADX INFO: renamed from: bZ */
    private static final Component f1024bZ = Component.translatable("bf.configurable_geo.realtime.on");

    /* JADX INFO: renamed from: ca */
    private static final Component f1025ca = Component.translatable("bf.configurable_geo.realtime.off");

    /* JADX INFO: renamed from: cb */
    private static final Component f1026cb = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: cc */
    private static final Component f1027cc = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: cd */
    private static final Component f1028cd = Component.translatable("bf.configurable_geo.error.invalid_resource").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: ce */
    private static final Component f1029ce = Component.translatable("bf.configurable_geo.error.invalid_rotation").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: dY */
    private static final int f1030dY = 5;

    /* JADX INFO: renamed from: dZ */
    private static final int f1031dZ = 360;

    /* JADX INFO: renamed from: ea */
    private static final int f1032ea = 18;

    /* JADX INFO: renamed from: eb */
    private static final int f1033eb = 10;

    /* JADX INFO: renamed from: ec */
    private static final int f1034ec = 8;

    /* JADX INFO: renamed from: ed */
    private static final int f1035ed = 80;

    /* JADX INFO: renamed from: ee */
    private static final int f1036ee = 20;

    /* JADX INFO: renamed from: ef */
    private static final int f1037ef = 20;

    /* JADX INFO: renamed from: eg */
    private static final int f1038eg = 38;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BlockPos f1039a;

    /* JADX INFO: renamed from: G */
    @NotNull
    private final String f1040G;

    /* JADX INFO: renamed from: H */
    @NotNull
    private final String f1041H;

    /* JADX INFO: renamed from: I */
    @NotNull
    private final String f1042I;

    /* JADX INFO: renamed from: J */
    @NotNull
    private final String f1043J;

    /* JADX INFO: renamed from: K */
    @NotNull
    private final String f1044K;

    /* JADX INFO: renamed from: aY */
    private boolean f1045aY;

    /* JADX INFO: renamed from: a */
    private EditBox f1046a;

    /* JADX INFO: renamed from: b */
    private EditBox f1047b;

    /* JADX INFO: renamed from: c */
    private EditBox f1048c;

    /* JADX INFO: renamed from: d */
    private EditBox f1049d;

    /* JADX INFO: renamed from: e */
    private EditBox f1050e;

    /* JADX INFO: renamed from: c */
    private C0127bs f1051c;

    /* JADX INFO: renamed from: cf */
    @Nullable
    private Component f1052cf;

    public C0137cB(@NotNull C0637lO c0637lO) {
        super(f1017bS);
        this.f1052cf = null;
        this.f1039a = c0637lO.getBlockPos();
        this.f1040G = c0637lO.m2821o().toString();
        this.f1041H = c0637lO.m2822p().toString();
        this.f1042I = c0637lO.m2823D();
        this.f1043J = c0637lO.m2824q().toString();
        this.f1044K = m764b(c0637lO.m2825p());
        this.f1045aY = c0637lO.m2826ao();
    }

    protected void init() {
        super.init();
        int iM763v = m763v();
        int i = (this.width - 360) / 2;
        int i2 = ((this.height - iM763v) / 2) + 20;
        this.f1046a = m759a(i, i2 + 10, f1018bT, this.f1040G);
        int i3 = i2 + 36;
        this.f1047b = m759a(i, i3 + 10, f1019bU, this.f1041H);
        int i4 = i3 + 36;
        this.f1048c = m759a(i, i4 + 10, f1020bV, this.f1042I);
        int i5 = i4 + 36;
        this.f1049d = m759a(i, i5 + 10, f1021bW, this.f1043J);
        int i6 = i5 + 36;
        this.f1050e = m759a(i, i6 + 10, f1022bX, this.f1044K);
        int i7 = i6 + 36;
        this.f1051c = new C0127bs(i, i7 + 10, 360, 20, m762f(), button -> {
            m761O();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW);
        addRenderableWidget(this.f1051c);
        int i8 = i7 + 46;
        addRenderableWidget(new C0127bs(i, i8, 80, 20, f1027cc, button2 -> {
            onClose();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        addRenderableWidget(new C0127bs((i + 360) - 80, i8, 80, 20, f1026cb, button3 -> {
            m760N();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
        setInitialFocus(this.f1046a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m759a(int i, int i2, @NotNull Component component, @NotNull String str) {
        EditBox editBox = new EditBox(this.font, i, i2, 360, f1032ea, component);
        editBox.setMaxLength(256);
        editBox.setValue(str);
        addRenderableWidget(editBox);
        return editBox;
    }

    /* JADX INFO: renamed from: N */
    private void m760N() {
        ResourceLocation resourceLocationTryParse = ResourceLocation.tryParse(this.f1046a.getValue().trim());
        ResourceLocation resourceLocationTryParse2 = ResourceLocation.tryParse(this.f1047b.getValue().trim());
        ResourceLocation resourceLocationTryParse3 = ResourceLocation.tryParse(this.f1049d.getValue().trim());
        String strTrim = this.f1048c.getValue().trim();
        if (resourceLocationTryParse == null || resourceLocationTryParse2 == null || resourceLocationTryParse3 == null || strTrim.isEmpty()) {
            this.f1052cf = f1028cd;
            return;
        }
        try {
            C1194vo.m6653c(new C1195vp(this.f1039a, resourceLocationTryParse, resourceLocationTryParse2, strTrim, resourceLocationTryParse3, m765i(Float.parseFloat(this.f1050e.getValue().trim())), this.f1045aY));
            onClose();
        } catch (NumberFormatException e) {
            this.f1052cf = f1029ce;
        }
    }

    /* JADX INFO: renamed from: O */
    private void m761O() {
        this.f1045aY = !this.f1045aY;
        if (this.f1051c != null) {
            this.f1051c.setMessage(m762f());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private Component m762f() {
        return this.f1045aY ? f1024bZ : f1025ca;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        renderBackground(guiGraphics, i, i2, f);
        super.render(guiGraphics, i, i2, f);
        int iM763v = m763v();
        int i3 = (this.width - 360) / 2;
        int i4 = (this.height - iM763v) / 2;
        C0119bk.m385c(this.font, guiGraphics, f1017bS, this.width / 2, i4, -1);
        int i5 = i4 + 20;
        C0119bk.m371a(this.font, guiGraphics, f1018bT, i3, i5, -5592406);
        int i6 = i5 + 36;
        C0119bk.m371a(this.font, guiGraphics, f1019bU, i3, i6, -5592406);
        int i7 = i6 + 36;
        C0119bk.m371a(this.font, guiGraphics, f1020bV, i3, i7, -5592406);
        int i8 = i7 + 36;
        C0119bk.m371a(this.font, guiGraphics, f1021bW, i3, i8, -5592406);
        int i9 = i8 + 36;
        C0119bk.m371a(this.font, guiGraphics, f1022bX, i3, i9, -5592406);
        C0119bk.m371a(this.font, guiGraphics, f1023bY, i3, i9 + 36, -5592406);
        if (this.f1052cf != null) {
            C0119bk.m385c(this.font, guiGraphics, this.f1052cf, this.width / 2, ((this.height - iM763v) / 2) + iM763v + 8, -1);
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    /* JADX INFO: renamed from: v */
    private static int m763v() {
        return Token.ARROW;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static String m764b(float f) {
        return ((double) f) == Math.floor((double) f) ? Integer.toString((int) f) : Float.toString(f);
    }

    /* JADX INFO: renamed from: i */
    private static float m765i(float f) {
        float fWrapDegrees = Mth.wrapDegrees(f);
        if (fWrapDegrees < 0.0f) {
            fWrapDegrees += 360.0f;
        }
        return fWrapDegrees;
    }
}
