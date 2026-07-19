package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cB.class */
public class cB extends Screen {
    private static final Component bS = Component.translatable("bf.configurable_geo.title");
    private static final Component bT = Component.translatable("bf.configurable_geo.field.model");
    private static final Component bU = Component.translatable("bf.configurable_geo.field.animation_file");
    private static final Component bV = Component.translatable("bf.configurable_geo.field.animation_name");
    private static final Component bW = Component.translatable("bf.configurable_geo.field.texture");
    private static final Component bX = Component.translatable("bf.configurable_geo.field.rotation");
    private static final Component bY = Component.translatable("bf.configurable_geo.field.realtime");
    private static final Component bZ = Component.translatable("bf.configurable_geo.realtime.on");
    private static final Component ca = Component.translatable("bf.configurable_geo.realtime.off");
    private static final Component cb = Component.translatable("bf.menu.button.confirm");
    private static final Component cc = Component.translatable("bf.menu.button.close");
    private static final Component cd = Component.translatable("bf.configurable_geo.error.invalid_resource").withStyle(ChatFormatting.RED);
    private static final Component ce = Component.translatable("bf.configurable_geo.error.invalid_rotation").withStyle(ChatFormatting.RED);
    private static final int dY = 5;
    private static final int dZ = 360;
    private static final int ea = 18;
    private static final int eb = 10;
    private static final int ec = 8;
    private static final int ed = 80;
    private static final int ee = 20;
    private static final int ef = 20;
    private static final int eg = 38;

    @NotNull
    private final BlockPos a;

    @NotNull
    private final String G;

    @NotNull
    private final String H;

    @NotNull
    private final String I;

    @NotNull
    private final String J;

    @NotNull
    private final String K;
    private boolean aY;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private EditBox f71a;
    private EditBox b;
    private EditBox c;
    private EditBox d;
    private EditBox e;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private C0048bs f72c;

    @Nullable
    private Component cf;

    public cB(@NotNull lO lOVar) {
        super(bS);
        this.cf = null;
        this.a = lOVar.getBlockPos();
        this.G = lOVar.o().toString();
        this.H = lOVar.p().toString();
        this.I = lOVar.D();
        this.J = lOVar.q().toString();
        this.K = b(lOVar.m625p());
        this.aY = lOVar.ao();
    }

    protected void init() {
        super.init();
        int iV = v();
        int i = (this.width - 360) / 2;
        int i2 = ((this.height - iV) / 2) + 20;
        this.f71a = a(i, i2 + 10, bT, this.G);
        int i3 = i2 + 36;
        this.b = a(i, i3 + 10, bU, this.H);
        int i4 = i3 + 36;
        this.c = a(i, i4 + 10, bV, this.I);
        int i5 = i4 + 36;
        this.d = a(i, i5 + 10, bW, this.J);
        int i6 = i5 + 36;
        this.e = a(i, i6 + 10, bX, this.K);
        int i7 = i6 + 36;
        this.f72c = new C0048bs(i, i7 + 10, 360, 20, f(), button -> {
            O();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW);
        addRenderableWidget(this.f72c);
        int i8 = i7 + 46;
        addRenderableWidget(new C0048bs(i, i8, 80, 20, cc, button2 -> {
            onClose();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
        addRenderableWidget(new C0048bs((i + 360) - 80, i8, 80, 20, cb, button3 -> {
            N();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
        setInitialFocus(this.f71a);
    }

    @NotNull
    private EditBox a(int i, int i2, @NotNull Component component, @NotNull String str) {
        EditBox editBox = new EditBox(this.font, i, i2, 360, ea, component);
        editBox.setMaxLength(256);
        editBox.setValue(str);
        addRenderableWidget(editBox);
        return editBox;
    }

    private void N() {
        ResourceLocation resourceLocationTryParse = ResourceLocation.tryParse(this.f71a.getValue().trim());
        ResourceLocation resourceLocationTryParse2 = ResourceLocation.tryParse(this.b.getValue().trim());
        ResourceLocation resourceLocationTryParse3 = ResourceLocation.tryParse(this.d.getValue().trim());
        String strTrim = this.c.getValue().trim();
        if (resourceLocationTryParse == null || resourceLocationTryParse2 == null || resourceLocationTryParse3 == null || strTrim.isEmpty()) {
            this.cf = cd;
            return;
        }
        try {
            C0582vo.c(new C0583vp(this.a, resourceLocationTryParse, resourceLocationTryParse2, strTrim, resourceLocationTryParse3, i(Float.parseFloat(this.e.getValue().trim())), this.aY));
            onClose();
        } catch (NumberFormatException e) {
            this.cf = ce;
        }
    }

    private void O() {
        this.aY = !this.aY;
        if (this.f72c != null) {
            this.f72c.setMessage(f());
        }
    }

    @NotNull
    private Component f() {
        return this.aY ? bZ : ca;
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        renderBackground(guiGraphics, i, i2, f);
        super.render(guiGraphics, i, i2, f);
        int iV = v();
        int i3 = (this.width - 360) / 2;
        int i4 = (this.height - iV) / 2;
        C0040bk.c(this.font, guiGraphics, bS, this.width / 2, i4, -1);
        int i5 = i4 + 20;
        C0040bk.a(this.font, guiGraphics, bT, i3, i5, -5592406);
        int i6 = i5 + 36;
        C0040bk.a(this.font, guiGraphics, bU, i3, i6, -5592406);
        int i7 = i6 + 36;
        C0040bk.a(this.font, guiGraphics, bV, i3, i7, -5592406);
        int i8 = i7 + 36;
        C0040bk.a(this.font, guiGraphics, bW, i3, i8, -5592406);
        int i9 = i8 + 36;
        C0040bk.a(this.font, guiGraphics, bX, i3, i9, -5592406);
        C0040bk.a(this.font, guiGraphics, bY, i3, i9 + 36, -5592406);
        if (this.cf != null) {
            C0040bk.c(this.font, guiGraphics, this.cf, this.width / 2, ((this.height - iV) / 2) + iV + 8, -1);
        }
    }

    public boolean isPauseScreen() {
        return false;
    }

    private static int v() {
        return Token.ARROW;
    }

    @NotNull
    private static String b(float f) {
        return ((double) f) == Math.floor((double) f) ? Integer.toString((int) f) : Float.toString(f);
    }

    private static float i(float f) {
        float fWrapDegrees = Mth.wrapDegrees(f);
        if (fWrapDegrees < 0.0f) {
            fWrapDegrees += 360.0f;
        }
        return fWrapDegrees;
    }
}
