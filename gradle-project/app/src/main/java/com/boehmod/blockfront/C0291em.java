package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.em */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/em.class */
public final class C0291em extends AbstractC0298et {

    /* JADX INFO: renamed from: iK */
    private static final int f2280iK = 10;

    /* JADX INFO: renamed from: iL */
    private static final int f2281iL = 5;

    /* JADX INFO: renamed from: iM */
    private static final int f2282iM = 5;

    /* JADX INFO: renamed from: ht */
    @NotNull
    private static final Component f2283ht = Component.translatable("bf.menu.news.link.tooltip");

    /* JADX INFO: renamed from: hu */
    @NotNull
    private final Component f2284hu;

    /* JADX INFO: renamed from: bV */
    private boolean f2285bV = false;

    /* JADX INFO: renamed from: bW */
    private boolean f2286bW = false;

    public C0291em(@NotNull Component component) {
        this.f2284hu = component;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0291em m1589a() {
        this.f2285bV = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0291em m1590b() {
        this.f2286bW = true;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        List listSplit = font.split(this.f2284hu, m1595af());
        int size = listSplit.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f2285bV) {
                poseStack.pushPose();
                poseStack.translate(this.f2339iY + 2, this.f2340iZ + 2 + (5 * i3), 0.0f);
                poseStack.scale(0.5f, 0.5f, 1.0f);
                m1592d(font, guiGraphics, (FormattedCharSequence) listSplit.get(i3), 0, 0);
                poseStack.popPose();
            } else {
                m1592d(font, guiGraphics, (FormattedCharSequence) listSplit.get(i3), this.f2339iY + 2, this.f2340iZ + 2 + (10 * i3));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        String strM1594a;
        super.mo871a(minecraft, c0623l, c0396gl, i, i2, i3);
        if (i3 == 0 && (strM1594a = m1594a(m1593a(minecraft.font, i, i2))) != null) {
            C0143cG.m784b(minecraft, strM1594a);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: b */
    public void mo1591b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        String strM1594a;
        super.mo1591b(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        if (m1615E() && (strM1594a = m1594a(m1593a(font, i, i2))) != null) {
            guiGraphics.renderComponentTooltip(font, List.of(f2283ht, Component.literal(strM1594a).withStyle(ChatFormatting.DARK_GRAY)), i, i2);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1592d(@NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence formattedCharSequence, int i, int i2) {
        if (this.f2286bW) {
            C0129bt.m504b(font, guiGraphics, formattedCharSequence, i, i2);
        } else {
            C0129bt.m502a(font, guiGraphics, formattedCharSequence, i, i2);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private Style m1593a(@NotNull Font font, int i, int i2) {
        int iMo1572j = (int) ((((i2 + this.f2338a.mo1572j(1.0f)) - this.f2340iZ) - 2.0f) / (this.f2285bV ? 5 : 10));
        List listSplit = font.split(this.f2284hu, m1595af());
        if (iMo1572j < 0 || iMo1572j >= listSplit.size()) {
            return null;
        }
        int iRound = Math.round(((i - this.f2339iY) - 2) * (this.f2285bV ? 2.0f : 1.0f));
        if (iRound < 0) {
            return null;
        }
        return font.getSplitter().componentStyleAtWidth((FormattedCharSequence) listSplit.get(iMo1572j), iRound);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static String m1594a(@Nullable Style style) {
        ClickEvent clickEvent;
        if (style == null || (clickEvent = style.getClickEvent()) == null || clickEvent.getAction() != ClickEvent.Action.OPEN_URL) {
            return null;
        }
        String value = clickEvent.getValue();
        if (value.startsWith("http://") || value.startsWith("https://")) {
            return value;
        }
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        if (this.f2284hu.getString().isEmpty()) {
            return this.f2285bV ? 4 : 5;
        }
        return Minecraft.getInstance().font.split(this.f2284hu, m1595af()).size() * (this.f2285bV ? 6 : 12);
    }

    /* JADX INFO: renamed from: af */
    private int m1595af() {
        int iMo866x = mo866x() - 19;
        return this.f2285bV ? iMo866x * 2 : iMo866x;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x();
    }
}
