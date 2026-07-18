package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0213dO;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hS.class */
public class C0429hS extends C0423hM {

    /* JADX INFO: renamed from: hK */
    @NotNull
    private static final Component f2789hK = Component.translatable("bf.menu.button.settings.prompt");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AbstractC0213dO.a[] f2790a;

    /* JADX INFO: renamed from: aq */
    @NotNull
    private final String f2791aq;

    /* JADX INFO: renamed from: ar */
    @NotNull
    private String f2792ar;

    public C0429hS(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull C0426hP c0426hP) {
        this(str, str2, str3, c0426hP, AbstractC0213dO.a.COMMON);
    }

    public C0429hS(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull C0426hP c0426hP, @NotNull AbstractC0213dO.a... aVarArr) {
        super(str, str2, c0426hP, false);
        this.f2790a = aVarArr;
        this.f2791aq = str3;
        this.f2792ar = str3;
    }

    /* JADX INFO: renamed from: g */
    public void m2012g(@NotNull String str) {
        this.f2792ar = str;
        C0424hN.f2773cI = true;
        this.f2708db = 1.0f;
    }

    /* JADX INFO: renamed from: q */
    public String m2013q() {
        return this.f2792ar;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1991a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            minecraft.setScreen(new C0212dN(screen, this).m1280a(this.f2790a).m1273a(f2789hK));
        } else if (i == 1) {
            m2012g(this.f2791aq);
        }
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1989a(@NotNull JsonObject jsonObject) {
        this.f2792ar = jsonObject.has(getKey()) ? jsonObject.get(getKey()).getAsString() : this.f2791aq;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: b */
    public void mo1990b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), this.f2792ar);
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1986a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        int i7 = ColorReferences.COLOR_WHITE_SOLID;
        C0119bk.m417a(guiGraphics, i, i2, i3, i4, i7, C1290xm.m7843e(this.f2708db, this.f2709dc, f2));
        C0119bk.m415a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        String str = String.format("'%s'", this.f2792ar);
        C0119bk.m370a(font, guiGraphics, (Component) Component.literal(str), i5 - font.width(str), i6);
    }

    @Override // com.boehmod.blockfront.C0423hM
    public int getColor() {
        return ChatFormatting.GRAY.getColor().intValue();
    }
}
