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

/* JADX INFO: renamed from: com.boehmod.blockfront.cX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cX.class */
public final class C0160cX {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0886py f1310a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final String[] f1311c;

    /* JADX INFO: renamed from: cc */
    private int f1312cc;

    /* JADX INFO: renamed from: cd */
    private int f1313cd;

    /* JADX INFO: renamed from: dE */
    private int f1314dE;

    /* JADX INFO: renamed from: dF */
    private int f1315dF;

    public C0160cX(int i, int i2, @NotNull C0886py c0886py, @NotNull String[] strArr, int i3, int i4) {
        this.f1312cc = i;
        this.f1313cd = i2;
        this.f1310a = c0886py;
        this.f1311c = strArr;
        this.f1314dE = i3;
        this.f1315dF = i4;
    }

    /* JADX INFO: renamed from: c */
    public void m1020c(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        Item item = this.f1310a.m4636c().getItem();
        int iM4637bz = this.f1310a.m4637bz();
        MutableComponent mutableComponentLiteral = Component.literal(C1273xM.m7241a(item.getName(item.getDefaultInstance()).getString(), 12));
        if (iM4637bz > 0) {
            mutableComponentLiteral.append(Component.literal(" $" + C1273xM.m7239b(iM4637bz)).withStyle(ChatFormatting.GREEN));
        }
        C0129bt.m470a(font, guiGraphics, (Component) mutableComponentLiteral, this.f1312cc + 5, this.f1313cd + 7);
    }

    /* JADX INFO: renamed from: a */
    public void m1021a(@NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, int i, float f) {
        C0872pk c0872pkM4229a;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623l.m2874a();
        int color = 16759296;
        if (abstractC0863pbM2874a != null && (c0872pkM4229a = abstractC0863pbM2874a.m4018b().m4229a(localPlayer.getUUID())) != null) {
            color = c0872pkM4229a.getColor();
        }
        float fSin = 1.0f + Mth.sin(f / 10.0f);
        C0129bt.m517a(guiGraphics, this.f1312cc - i, this.f1313cd, i, this.f1315dF, color, fSin);
        C0129bt.m517a(guiGraphics, this.f1312cc + this.f1314dE, this.f1313cd, i, this.f1315dF, color, fSin);
        C0129bt.m517a(guiGraphics, this.f1312cc - i, this.f1313cd - i, this.f1314dE + (i * 2), i, color, fSin);
        C0129bt.m517a(guiGraphics, this.f1312cc - i, this.f1313cd + this.f1315dF, this.f1314dE + (i * 2), i, color, fSin);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1022a(int i, int i2) {
        return new Rectangle(this.f1312cc, this.f1313cd, this.f1314dE, this.f1315dF).contains(i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Item m1023a() {
        return this.f1310a.m4636c().getItem();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public String[] m1024a() {
        return this.f1311c;
    }

    /* JADX INFO: renamed from: c */
    public void m1025c(int i) {
        this.f1312cc = i;
    }

    /* JADX INFO: renamed from: d */
    public void m1026d(int i) {
        this.f1313cd = i;
    }

    /* JADX INFO: renamed from: e */
    public void m1027e(int i) {
        this.f1314dE = i;
    }

    /* JADX INFO: renamed from: f */
    public void m1028f(int i) {
        this.f1315dF = i;
    }
}
