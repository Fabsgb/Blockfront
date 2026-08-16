package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cK.class */
public class C0147cK extends Screen {

    /* JADX INFO: renamed from: bU */
    private static final Component f1107bU = Component.translatable("bf.configurable_geo.title");

    /* JADX INFO: renamed from: bV */
    private static final Component f1108bV = Component.translatable("bf.configurable_geo.field.model");

    /* JADX INFO: renamed from: bW */
    private static final Component f1109bW = Component.translatable("bf.configurable_geo.field.animation_file");

    /* JADX INFO: renamed from: bX */
    private static final Component f1110bX = Component.translatable("bf.configurable_geo.field.animation_name");

    /* JADX INFO: renamed from: bY */
    private static final Component f1111bY = Component.translatable("bf.configurable_geo.field.texture");

    /* JADX INFO: renamed from: bZ */
    private static final Component f1112bZ = Component.translatable("bf.configurable_geo.field.rotation");

    /* JADX INFO: renamed from: ca */
    private static final Component f1113ca = Component.translatable("bf.configurable_geo.field.realtime");

    /* JADX INFO: renamed from: cb */
    private static final Component f1114cb = Component.translatable("bf.configurable_geo.realtime.on");

    /* JADX INFO: renamed from: cc */
    private static final Component f1115cc = Component.translatable("bf.configurable_geo.realtime.off");

    /* JADX INFO: renamed from: cd */
    private static final Component f1116cd = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: ce */
    private static final Component f1117ce = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: cf */
    private static final Component f1118cf = Component.translatable("bf.configurable_geo.error.invalid_resource").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: cg */
    private static final Component f1119cg = Component.translatable("bf.configurable_geo.error.invalid_rotation").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: eY */
    private static final int f1120eY = 5;

    /* JADX INFO: renamed from: eZ */
    private static final int f1121eZ = 360;

    /* JADX INFO: renamed from: fa */
    private static final int f1122fa = 18;

    /* JADX INFO: renamed from: fb */
    private static final int f1123fb = 10;

    /* JADX INFO: renamed from: fc */
    private static final int f1124fc = 8;

    /* JADX INFO: renamed from: fd */
    private static final int f1125fd = 80;

    /* JADX INFO: renamed from: fe */
    private static final int f1126fe = 20;

    /* JADX INFO: renamed from: ff */
    private static final int f1127ff = 20;

    /* JADX INFO: renamed from: fg */
    private static final int f1128fg = 38;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final BlockPos f1129a;

    /* JADX INFO: renamed from: M */
    @NotNull
    private final String f1130M;

    /* JADX INFO: renamed from: N */
    @NotNull
    private final String f1131N;

    /* JADX INFO: renamed from: O */
    @NotNull
    private final String f1132O;

    /* JADX INFO: renamed from: P */
    @NotNull
    private final String f1133P;

    /* JADX INFO: renamed from: Q */
    @NotNull
    private final String f1134Q;

    /* JADX INFO: renamed from: bc */
    private boolean f1135bc;

    /* JADX INFO: renamed from: a */
    private EditBox f1136a;

    /* JADX INFO: renamed from: b */
    private EditBox f1137b;

    /* JADX INFO: renamed from: c */
    private EditBox f1138c;

    /* JADX INFO: renamed from: d */
    private EditBox f1139d;

    /* JADX INFO: renamed from: e */
    private EditBox f1140e;

    /* JADX INFO: renamed from: c */
    private C0085bB f1141c;

    /* JADX INFO: renamed from: ch */
    @Nullable
    private Component f1142ch;

    public C0147cK(@NotNull C0713mk c0713mk) {
        super(f1107bU);
        this.f1142ch = null;
        this.f1129a = c0713mk.getBlockPos();
        this.f1130M = c0713mk.m3252p().toString();
        this.f1131N = c0713mk.m3253q().toString();
        this.f1132O = c0713mk.m3254K();
        this.f1133P = c0713mk.m3255r().toString();
        this.f1134Q = m819b(c0713mk.m3256p());
        this.f1135bc = c0713mk.m3257ay();
    }

    protected void init() {
        super.init();
        int iM818z = m818z();
        int i = (this.width - 360) / 2;
        int i2 = ((this.height - iM818z) / 2) + 20;
        this.f1136a = m814a(i, i2 + 10, f1108bV, this.f1130M);
        int i3 = i2 + 36;
        this.f1137b = m814a(i, i3 + 10, f1109bW, this.f1131N);
        int i4 = i3 + 36;
        this.f1138c = m814a(i, i4 + 10, f1110bX, this.f1132O);
        int i5 = i4 + 36;
        this.f1139d = m814a(i, i5 + 10, f1111bY, this.f1133P);
        int i6 = i5 + 36;
        this.f1140e = m814a(i, i6 + 10, f1112bZ, this.f1134Q);
        int i7 = i6 + 36;
        this.f1141c = new C0085bB(i, i7 + 10, 360, 20, m817f(), button -> {
            m816S();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW);
        addRenderableWidget(this.f1141c);
        int i8 = i7 + 46;
        addRenderableWidget(new C0085bB(i, i8, 80, 20, f1117ce, button2 -> {
            onClose();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        addRenderableWidget(new C0085bB((i + 360) - 80, i8, 80, 20, f1116cd, button3 -> {
            m815R();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
        setInitialFocus(this.f1136a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private EditBox m814a(int i, int i2, @NotNull Component component, @NotNull String str) {
        EditBox editBox = new EditBox(this.font, i, i2, 360, f1122fa, component);
        editBox.setMaxLength(256);
        editBox.setValue(str);
        addRenderableWidget(editBox);
        return editBox;
    }

    /* JADX INFO: renamed from: R */
    private void m815R() {
        ResourceLocation resourceLocationTryParse = ResourceLocation.tryParse(this.f1136a.getValue().trim());
        ResourceLocation resourceLocationTryParse2 = ResourceLocation.tryParse(this.f1137b.getValue().trim());
        ResourceLocation resourceLocationTryParse3 = ResourceLocation.tryParse(this.f1139d.getValue().trim());
        String strTrim = this.f1138c.getValue().trim();
        if (resourceLocationTryParse == null || resourceLocationTryParse2 == null || resourceLocationTryParse3 == null || strTrim.isEmpty()) {
            this.f1142ch = f1118cf;
            return;
        }
        try {
            C1169vO.m6648c(new C1170vP(this.f1129a, resourceLocationTryParse, resourceLocationTryParse2, strTrim, resourceLocationTryParse3, m820h(Float.parseFloat(this.f1140e.getValue().trim())), this.f1135bc));
            onClose();
        } catch (NumberFormatException e) {
            this.f1142ch = f1119cg;
        }
    }

    /* JADX INFO: renamed from: S */
    private void m816S() {
        this.f1135bc = !this.f1135bc;
        if (this.f1141c != null) {
            this.f1141c.setMessage(m817f());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private Component m817f() {
        return this.f1135bc ? f1114cb : f1115cc;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        renderBackground(guiGraphics, i, i2, f);
        super.render(guiGraphics, i, i2, f);
        int iM818z = m818z();
        int i3 = (this.width - 360) / 2;
        int i4 = (this.height - iM818z) / 2;
        C0129bt.m485c(this.font, guiGraphics, f1107bU, this.width / 2, i4, -1);
        int i5 = i4 + 20;
        C0129bt.m471a(this.font, guiGraphics, f1108bV, i3, i5, -5592406);
        int i6 = i5 + 36;
        C0129bt.m471a(this.font, guiGraphics, f1109bW, i3, i6, -5592406);
        int i7 = i6 + 36;
        C0129bt.m471a(this.font, guiGraphics, f1110bX, i3, i7, -5592406);
        int i8 = i7 + 36;
        C0129bt.m471a(this.font, guiGraphics, f1111bY, i3, i8, -5592406);
        int i9 = i8 + 36;
        C0129bt.m471a(this.font, guiGraphics, f1112bZ, i3, i9, -5592406);
        C0129bt.m471a(this.font, guiGraphics, f1113ca, i3, i9 + 36, -5592406);
        if (this.f1142ch != null) {
            C0129bt.m485c(this.font, guiGraphics, this.f1142ch, this.width / 2, ((this.height - iM818z) / 2) + iM818z + 8, -1);
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    /* JADX INFO: renamed from: z */
    private static int m818z() {
        return Token.ARROW;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    private static String m819b(float f) {
        return ((double) f) == Math.floor((double) f) ? Integer.toString((int) f) : Float.toString(f);
    }

    /* JADX INFO: renamed from: h */
    private static float m820h(float f) {
        float fWrapDegrees = Mth.wrapDegrees(f);
        if (fWrapDegrees < 0.0f) {
            fWrapDegrees += 360.0f;
        }
        return fWrapDegrees;
    }
}
