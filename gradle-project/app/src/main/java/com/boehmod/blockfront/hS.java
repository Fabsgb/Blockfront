package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.dO;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hS.class */
public class hS extends hM {

    @NotNull
    private static final Component hK = Component.translatable("bf.menu.button.settings.prompt");

    @NotNull
    private final dO.a[] a;

    @NotNull
    private final String aq;

    @NotNull
    private String ar;

    public hS(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull hP hPVar) {
        this(str, str2, str3, hPVar, dO.a.COMMON);
    }

    public hS(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull hP hPVar, @NotNull dO.a... aVarArr) {
        super(str, str2, hPVar, false);
        this.a = aVarArr;
        this.aq = str3;
        this.ar = str3;
    }

    public void g(@NotNull String str) {
        this.ar = str;
        hN.cI = true;
        this.db = 1.0f;
    }

    public String q() {
        return this.ar;
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            minecraft.setScreen(new dN(screen, this).a(this.a).a(hK));
        } else if (i == 1) {
            g(this.aq);
        }
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull JsonObject jsonObject) {
        this.ar = jsonObject.has(getKey()) ? jsonObject.get(getKey()).getAsString() : this.aq;
    }

    @Override // com.boehmod.blockfront.hM
    public void b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), this.ar);
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        int i7 = ColorReferences.COLOR_WHITE_SOLID;
        C0040bk.a(guiGraphics, i, i2, i3, i4, i7, C0634xm.e(this.db, this.dc, f2));
        C0040bk.a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        String str = String.format("'%s'", this.ar);
        C0040bk.a(font, guiGraphics, (Component) Component.literal(str), i5 - font.width(str), i6);
    }

    @Override // com.boehmod.blockfront.hM
    public int getColor() {
        return ChatFormatting.GRAY.getColor().intValue();
    }
}
