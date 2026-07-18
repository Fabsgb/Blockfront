package com.boehmod.blockfront;

import java.awt.Rectangle;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cO.class */
public final class C0150cO {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0863pc f1220a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final String[] f1221b;

    /* JADX INFO: renamed from: bm */
    private int f1222bm;

    /* JADX INFO: renamed from: bn */
    private int f1223bn;

    /* JADX INFO: renamed from: cM */
    private int f1224cM;

    /* JADX INFO: renamed from: cN */
    private int f1225cN;

    public C0150cO(int i, int i2, @NotNull C0863pc c0863pc, @NotNull String[] strArr, int i3, int i4) {
        this.f1222bm = i;
        this.f1223bn = i2;
        this.f1220a = c0863pc;
        this.f1221b = strArr;
        this.f1224cM = i3;
        this.f1225cN = i4;
    }

    /* JADX INFO: renamed from: c */
    public void m966c(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        Item item = this.f1220a.m4311a().getItem();
        int iM4312bk = this.f1220a.m4312bk();
        MutableComponent mutableComponentLiteral = Component.literal(C1293xp.m7914a(item.getName(item.getDefaultInstance()).getString(), 12));
        if (iM4312bk > 0) {
            mutableComponentLiteral.append(Component.literal(" $" + C1293xp.m7912a(iM4312bk)).withStyle(ChatFormatting.GREEN));
        }
        C0119bk.m370a(font, guiGraphics, (Component) mutableComponentLiteral, this.f1222bm + 5, this.f1223bn + 7);
    }

    /* JADX INFO: renamed from: a */
    public void m967a(@NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, int i, float f) {
        C0796oO c0796oOM3793a;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622l.m2688a();
        int color = 16759296;
        if (abstractC0787oFM2688a != null && (c0796oOM3793a = abstractC0787oFM2688a.m3582b().m3793a(localPlayer.getUUID())) != null) {
            color = c0796oOM3793a.getColor();
        }
        float fSin = 1.0f + Mth.sin(f / 10.0f);
        C0119bk.m417a(guiGraphics, this.f1222bm - i, this.f1223bn, i, this.f1225cN, color, fSin);
        C0119bk.m417a(guiGraphics, this.f1222bm + this.f1224cM, this.f1223bn, i, this.f1225cN, color, fSin);
        C0119bk.m417a(guiGraphics, this.f1222bm - i, this.f1223bn - i, this.f1224cM + (i * 2), i, color, fSin);
        C0119bk.m417a(guiGraphics, this.f1222bm - i, this.f1223bn + this.f1225cN, this.f1224cM + (i * 2), i, color, fSin);
    }

    /* JADX INFO: renamed from: a */
    public boolean m968a(int i, int i2) {
        return new Rectangle(this.f1222bm, this.f1223bn, this.f1224cM, this.f1225cN).contains(i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Item m969a() {
        return this.f1220a.m4311a().getItem();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public String[] m970a() {
        return this.f1221b;
    }

    /* JADX INFO: renamed from: c */
    public void m971c(int i) {
        this.f1222bm = i;
    }

    /* JADX INFO: renamed from: d */
    public void m972d(int i) {
        this.f1223bn = i;
    }

    /* JADX INFO: renamed from: e */
    public void m973e(int i) {
        this.f1224cM = i;
    }

    /* JADX INFO: renamed from: f */
    public void m974f(int i) {
        this.f1225cN = i;
    }
}
