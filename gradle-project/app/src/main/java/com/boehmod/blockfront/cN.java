package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cN.class */
public class cN<T> extends dM {
    private static final Component dg = Component.translatable("bf.menu.button.confirm");
    private static final Component dh = Component.translatable("bf.menu.button.close");
    private static final Component di = Component.translatable("bf.gui.search.hint");
    private static final int eW = 16;
    private static final int eX = 12;
    private static final int eY = 4;
    private static final int eZ = 12;
    private static final int fa = 144;
    private static final int fb = 872415231;
    private static final int fc = 1728053247;

    @NotNull
    private final List<T> t;

    @NotNull
    private final Function<T, String> b;

    @NotNull
    private final Function<T, Component> c;

    @NotNull
    private final Consumer<T> a;

    @NotNull
    private List<T> u;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private T f85a;
    private int eI;

    public cN(@Nullable Screen screen, @NotNull Component component, @NotNull List<T> list, @NotNull Function<T, String> function, @NotNull Function<T, Component> function2, @Nullable T t, @NotNull Consumer<T> consumer) {
        super(screen, component);
        this.eI = 0;
        this.t = List.copyOf(list);
        this.b = function;
        this.c = function2;
        this.f85a = t;
        this.a = consumer;
        this.u = this.t;
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        int iIndexOf;
        super.init();
        EditBox editBox = new EditBox(this.font, (this.width / 2) - 95, (F() - 4) - 16, dM.gZ, 16, Component.empty());
        editBox.setMaxLength(64);
        editBox.setHint(di.copy().withStyle(ChatFormatting.DARK_GRAY));
        editBox.setResponder(this::e);
        addRenderableWidget(editBox);
        if (this.f85a != null && (iIndexOf = this.u.indexOf(this.f85a)) >= 0) {
            this.eI = d(iIndexOf - 6);
        }
    }

    private void e(@NotNull String str) {
        if (str.isEmpty()) {
            this.u = this.t;
        } else {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (T t : this.t) {
                if (this.b.apply(t).toLowerCase(Locale.ROOT).contains(lowerCase)) {
                    objectArrayList.add(t);
                }
            }
            this.u = objectArrayList;
        }
        this.eI = 0;
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        int i = (this.width / 2) - 95;
        int iF = F() + fa + 6;
        addRenderableWidget(new C0048bs(i + 2, iF, 80, 20, dh, button -> {
            J();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
        addRenderableWidget(new C0048bs(((i + dM.gZ) - 80) - 2, iF, 80, 20, dg, button2 -> {
            V();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    private void V() {
        if (this.f85a != null) {
            this.a.accept(this.f85a);
        }
        if (this.b != null && this.b.screen == this) {
            J();
        }
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.C0080cx
    public boolean mouseClicked(double d, double d2, int i) {
        int iF;
        if (i == 0 && b(d, d2) && (iF = (((int) (d2 - ((double) F()))) / 12) + this.eI) >= 0 && iF < this.u.size()) {
            this.f85a = this.u.get(iF);
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (b(d, d2)) {
            this.eI = d(this.eI - ((int) Math.signum(d4)));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        a(guiGraphics, i, i2);
        poseStackPose.popPose();
    }

    private void a(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int i3;
        int i4;
        int i5 = (this.width / 2) - 95;
        int iF = F();
        C0040bk.a(guiGraphics, i5, iF, dM.gZ, fa, 855638016);
        if (b(i, i2)) {
            i3 = ((i2 - iF) / 12) + this.eI;
        } else {
            i3 = -1;
        }
        int i6 = i3;
        for (int i7 = 0; i7 < 12 && (i4 = i7 + this.eI) >= 0 && i4 < this.u.size(); i7++) {
            T t = this.u.get(i4);
            int i8 = iF + (i7 * 12);
            if (t == this.f85a) {
                C0040bk.a(guiGraphics, i5, i8, dM.gZ, 12, fc);
            } else if (i4 == i6) {
                C0040bk.a(guiGraphics, i5, i8, dM.gZ, 12, 872415231);
            }
            guiGraphics.drawString(this.font, this.c.apply(t), i5 + 4, i8 + 2, ColorReferences.COLOR_WHITE);
        }
    }

    private boolean b(double d, double d2) {
        int i = (this.width / 2) - 95;
        int iF = F();
        return d >= ((double) i) && d <= ((double) (i + dM.gZ)) && d2 >= ((double) iF) && d2 <= ((double) (iF + fa));
    }

    private int F() {
        return 85 + (11 * this.B.size()) + 16 + 4;
    }

    private int d(int i) {
        return Mth.clamp(i, 0, Math.max(0, this.u.size() - 12));
    }

    @Override // com.boehmod.blockfront.dM
    protected int E() {
        return 164;
    }
}
