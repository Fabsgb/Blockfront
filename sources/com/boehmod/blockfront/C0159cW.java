package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cW.class */
public class C0159cW<T> extends AbstractC0223dX {

    /* JADX INFO: renamed from: di */
    private static final Component f1293di = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: dj */
    private static final Component f1294dj = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: dk */
    private static final Component f1295dk = Component.translatable("bf.gui.search.hint");

    /* JADX INFO: renamed from: fW */
    private static final int f1296fW = 16;

    /* JADX INFO: renamed from: fX */
    private static final int f1297fX = 12;

    /* JADX INFO: renamed from: fY */
    private static final int f1298fY = 4;

    /* JADX INFO: renamed from: fZ */
    private static final int f1299fZ = 12;

    /* JADX INFO: renamed from: ga */
    private static final int f1300ga = 144;

    /* JADX INFO: renamed from: gb */
    private static final int f1301gb = 872415231;

    /* JADX INFO: renamed from: gc */
    private static final int f1302gc = 1728053247;

    /* JADX INFO: renamed from: v */
    @NotNull
    private final List<T> f1303v;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Function<T, String> f1304b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Function<T, Component> f1305c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Consumer<T> f1306a;

    /* JADX INFO: renamed from: w */
    @NotNull
    private List<T> f1307w;

    /* JADX INFO: renamed from: b */
    @Nullable
    private T f1308b;

    /* JADX INFO: renamed from: fI */
    private int f1309fI;

    public C0159cW(@Nullable Screen screen, @NotNull Component component, @NotNull List<T> list, @NotNull Function<T, String> function, @NotNull Function<T, Component> function2, @Nullable T t, @NotNull Consumer<T> consumer) {
        super(screen, component);
        this.f1309fI = 0;
        this.f1303v = List.copyOf(list);
        this.f1304b = function;
        this.f1305c = function2;
        this.f1308b = t;
        this.f1306a = consumer;
        this.f1307w = this.f1303v;
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        int iIndexOf;
        super.init();
        EditBox editBox = new EditBox(this.font, (this.width / 2) - 95, (m1016J() - 4) - 16, AbstractC0223dX.f1766ij, 16, Component.empty());
        editBox.setMaxLength(64);
        editBox.setHint(f1295dk.copy().withStyle(ChatFormatting.DARK_GRAY));
        editBox.setResponder(this::m1012e);
        addRenderableWidget(editBox);
        if (this.f1308b != null && (iIndexOf = this.f1307w.indexOf(this.f1308b)) >= 0) {
            this.f1309fI = m1017d(iIndexOf - 6);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m1012e(@NotNull String str) {
        if (str.isEmpty()) {
            this.f1307w = this.f1303v;
        } else {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (T t : this.f1303v) {
                if (this.f1304b.apply(t).toLowerCase(Locale.ROOT).contains(lowerCase)) {
                    objectArrayList.add(t);
                }
            }
            this.f1307w = objectArrayList;
        }
        this.f1309fI = 0;
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i = (this.width / 2) - 95;
        int iM1016J = m1016J() + f1300ga + 6;
        addRenderableWidget(new C0085bB(i + 2, iM1016J, 80, 20, f1294dj, button -> {
            m1327N();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        addRenderableWidget(new C0085bB(((i + AbstractC0223dX.f1766ij) - 80) - 2, iM1016J, 80, 20, f1293di, button2 -> {
            m1013Z();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: Z */
    private void m1013Z() {
        if (this.f1308b != null) {
            this.f1306a.accept(this.f1308b);
        }
        if (this.f1058a != null && this.f1058a.screen == this) {
            m1327N();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        int iM1016J;
        if (i == 0 && m1015b(d, d2) && (iM1016J = (((int) (d2 - ((double) m1016J()))) / 12) + this.f1309fI) >= 0 && iM1016J < this.f1307w.size()) {
            this.f1308b = this.f1307w.get(iM1016J);
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (m1015b(d, d2)) {
            this.f1309fI = m1017d(this.f1309fI - ((int) Math.signum(d4)));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        m1014a(guiGraphics, i, i2);
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m1014a(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        int i3;
        int i4;
        int i5 = (this.width / 2) - 95;
        int iM1016J = m1016J();
        C0129bt.m515a(guiGraphics, i5, iM1016J, AbstractC0223dX.f1766ij, f1300ga, 855638016);
        if (m1015b(i, i2)) {
            i3 = ((i2 - iM1016J) / 12) + this.f1309fI;
        } else {
            i3 = -1;
        }
        int i6 = i3;
        for (int i7 = 0; i7 < 12 && (i4 = i7 + this.f1309fI) >= 0 && i4 < this.f1307w.size(); i7++) {
            T t = this.f1307w.get(i4);
            int i8 = iM1016J + (i7 * 12);
            if (t == this.f1308b) {
                C0129bt.m515a(guiGraphics, i5, i8, AbstractC0223dX.f1766ij, 12, f1302gc);
            } else if (i4 == i6) {
                C0129bt.m515a(guiGraphics, i5, i8, AbstractC0223dX.f1766ij, 12, 872415231);
            }
            guiGraphics.drawString(this.font, this.f1305c.apply(t), i5 + 4, i8 + 2, ColorReferences.COLOR_WHITE);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m1015b(double d, double d2) {
        int i = (this.width / 2) - 95;
        int iM1016J = m1016J();
        return d >= ((double) i) && d <= ((double) (i + AbstractC0223dX.f1766ij)) && d2 >= ((double) iM1016J) && d2 <= ((double) (iM1016J + f1300ga));
    }

    /* JADX INFO: renamed from: J */
    private int m1016J() {
        return 85 + (11 * this.f1773D.size()) + 16 + 4;
    }

    /* JADX INFO: renamed from: d */
    private int m1017d(int i) {
        return Mth.clamp(i, 0, Math.max(0, this.f1307w.size() - 12));
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: I */
    protected int mo913I() {
        return 164;
    }
}
