package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cN.class */
public class C0149cN<T> extends AbstractC0211dM {

    /* JADX INFO: renamed from: dg */
    private static final Component f1203dg = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: dh */
    private static final Component f1204dh = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: di */
    private static final Component f1205di = Component.translatable("bf.gui.search.hint");

    /* JADX INFO: renamed from: eW */
    private static final int f1206eW = 16;

    /* JADX INFO: renamed from: eX */
    private static final int f1207eX = 12;

    /* JADX INFO: renamed from: eY */
    private static final int f1208eY = 4;

    /* JADX INFO: renamed from: eZ */
    private static final int f1209eZ = 12;

    /* JADX INFO: renamed from: fa */
    private static final int f1210fa = 144;

    /* JADX INFO: renamed from: fb */
    private static final int f1211fb = 872415231;

    /* JADX INFO: renamed from: fc */
    private static final int f1212fc = 1728053247;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final List<T> f1213t;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Function<T, String> f1214b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Function<T, Component> f1215c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Consumer<T> f1216a;

    /* JADX INFO: renamed from: u */
    @NotNull
    private List<T> f1217u;

    /* JADX INFO: renamed from: a */
    @Nullable
    private T f1218a;

    /* JADX INFO: renamed from: eI */
    private int f1219eI;

    public C0149cN(@Nullable Screen screen, @NotNull Component component, @NotNull List<T> list, @NotNull Function<T, String> function, @NotNull Function<T, Component> function2, @Nullable T t, @NotNull Consumer<T> consumer) {
        super(screen, component);
        this.f1219eI = 0;
        this.f1213t = List.copyOf(list);
        this.f1214b = function;
        this.f1215c = function2;
        this.f1218a = t;
        this.f1216a = consumer;
        this.f1217u = this.f1213t;
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        int iIndexOf;
        super.init();
        EditBox editBox = new EditBox(this.font, (this.width / 2) - 95, (m962F() - 4) - 16, AbstractC0211dM.f1737gZ, 16, Component.empty());
        editBox.setMaxLength(64);
        editBox.setHint(f1205di.copy().withStyle(ChatFormatting.DARK_GRAY));
        editBox.setResponder(this::m958e);
        addRenderableWidget(editBox);
        if (this.f1218a != null && (iIndexOf = this.f1217u.indexOf(this.f1218a)) >= 0) {
            this.f1219eI = m963d(iIndexOf - 6);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m958e(@NotNull String str) {
        if (str.isEmpty()) {
            this.f1217u = this.f1213t;
        } else {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (T t : this.f1213t) {
                if (this.f1214b.apply(t).toLowerCase(Locale.ROOT).contains(lowerCase)) {
                    objectArrayList.add(t);
                }
            }
            this.f1217u = objectArrayList;
        }
        this.f1219eI = 0;
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i = (this.width / 2) - 95;
        int iM962F = m962F() + f1210fa + 6;
        addRenderableWidget(new C0127bs(i + 2, iM962F, 80, 20, f1204dh, button -> {
            mo1276J();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        addRenderableWidget(new C0127bs(((i + AbstractC0211dM.f1737gZ) - 80) - 2, iM962F, 80, 20, f1203dg, button2 -> {
            m959V();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: V */
    private void m959V() {
        if (this.f1218a != null) {
            this.f1216a.accept(this.f1218a);
        }
        if (this.f1587b != null && this.f1587b.screen == this) {
            mo1276J();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        int iM962F;
        if (i == 0 && m961b(d, d2) && (iM962F = (((int) (d2 - ((double) m962F()))) / 12) + this.f1219eI) >= 0 && iM962F < this.f1217u.size()) {
            this.f1218a = this.f1217u.get(iM962F);
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (m961b(d, d2)) {
            this.f1219eI = m963d(this.f1219eI - ((int) Math.signum(d4)));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        m960a(guiGraphics, i, i2);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m960a(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int i3;
        int i4;
        int i5 = (this.width / 2) - 95;
        int iM962F = m962F();
        C0119bk.m415a(guiGraphics, i5, iM962F, AbstractC0211dM.f1737gZ, f1210fa, 855638016);
        if (m961b(i, i2)) {
            i3 = ((i2 - iM962F) / 12) + this.f1219eI;
        } else {
            i3 = -1;
        }
        int i6 = i3;
        for (int i7 = 0; i7 < 12 && (i4 = i7 + this.f1219eI) >= 0 && i4 < this.f1217u.size(); i7++) {
            T t = this.f1217u.get(i4);
            int i8 = iM962F + (i7 * 12);
            if (t == this.f1218a) {
                C0119bk.m415a(guiGraphics, i5, i8, AbstractC0211dM.f1737gZ, 12, f1212fc);
            } else if (i4 == i6) {
                C0119bk.m415a(guiGraphics, i5, i8, AbstractC0211dM.f1737gZ, 12, 872415231);
            }
            guiGraphics.drawString(this.font, this.f1215c.apply(t), i5 + 4, i8 + 2, ColorReferences.COLOR_WHITE);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m961b(double d, double d2) {
        int i = (this.width / 2) - 95;
        int iM962F = m962F();
        return d >= ((double) i) && d <= ((double) (i + AbstractC0211dM.f1737gZ)) && d2 >= ((double) iM962F) && d2 <= ((double) (iM962F + f1210fa));
    }

    /* JADX INFO: renamed from: F */
    private int m962F() {
        return 85 + (11 * this.f1744B.size()) + 16 + 4;
    }

    /* JADX INFO: renamed from: d */
    private int m963d(int i) {
        return Mth.clamp(i, 0, Math.max(0, this.f1217u.size() - 12));
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: E */
    protected int mo859E() {
        return 164;
    }
}
