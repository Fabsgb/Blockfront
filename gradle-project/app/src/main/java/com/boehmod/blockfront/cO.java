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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cO.class */
public final class cO {

    @NotNull
    private final C0408pc a;

    @NotNull
    private final String[] b;
    private int bm;
    private int bn;
    private int cM;
    private int cN;

    public cO(int i, int i2, @NotNull C0408pc c0408pc, @NotNull String[] strArr, int i3, int i4) {
        this.bm = i;
        this.bn = i2;
        this.a = c0408pc;
        this.b = strArr;
        this.cM = i3;
        this.cN = i4;
    }

    public void c(@NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        Item item = this.a.a().getItem();
        int iBk = this.a.bk();
        MutableComponent mutableComponentLiteral = Component.literal(C0637xp.a(item.getName(item.getDefaultInstance()).getString(), 12));
        if (iBk > 0) {
            mutableComponentLiteral.append(Component.literal(" $" + C0637xp.a(iBk)).withStyle(ChatFormatting.GREEN));
        }
        C0040bk.a(font, guiGraphics, (Component) mutableComponentLiteral, this.bm + 5, this.bn + 7);
    }

    public void a(@NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, int i, float f) {
        oO oOVarA;
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        oF<?, ?, ?> oFVarM591a = c0297l.m591a();
        int color = 16759296;
        if (oFVarM591a != null && (oOVarA = oFVarM591a.b().a(localPlayer.getUUID())) != null) {
            color = oOVarA.getColor();
        }
        float fSin = 1.0f + Mth.sin(f / 10.0f);
        C0040bk.a(guiGraphics, this.bm - i, this.bn, i, this.cN, color, fSin);
        C0040bk.a(guiGraphics, this.bm + this.cM, this.bn, i, this.cN, color, fSin);
        C0040bk.a(guiGraphics, this.bm - i, this.bn - i, this.cM + (i * 2), i, color, fSin);
        C0040bk.a(guiGraphics, this.bm - i, this.bn + this.cN, this.cM + (i * 2), i, color, fSin);
    }

    public boolean a(int i, int i2) {
        return new Rectangle(this.bm, this.bn, this.cM, this.cN).contains(i, i2);
    }

    @NotNull
    public Item a() {
        return this.a.a().getItem();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String[] m275a() {
        return this.b;
    }

    public void c(int i) {
        this.bm = i;
    }

    public void d(int i) {
        this.bn = i;
    }

    public void e(int i) {
        this.cM = i;
    }

    public void f(int i) {
        this.cN = i;
    }
}
