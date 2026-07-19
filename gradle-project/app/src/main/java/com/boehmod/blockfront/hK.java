package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hK.class */
public class hK extends hM {
    private final float gm;
    private float gn;
    private float go;
    private float gp;

    public hK(@NotNull String str, @NotNull String str2, @NotNull hP hPVar, float f) {
        super(str, str2, hPVar, false);
        this.gp = 0.0f;
        this.gm = f;
        this.gn = f;
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            this.gn = hM.m(this.gn);
        } else if (i == 1) {
            this.gn = this.gm;
        }
        hN.cI = true;
        this.db = 1.0f;
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull JsonObject jsonObject) {
        this.gn = jsonObject.has(getKey()) ? jsonObject.get(getKey()).getAsFloat() : this.gm;
    }

    @Override // com.boehmod.blockfront.hM
    public void b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), Float.valueOf(this.gn));
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        float fE = C0634xm.e(this.go, this.gp, f2);
        C0040bk.a(guiGraphics, i, i2, i3, i4, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM, C0634xm.e(this.db, this.dc, f2));
        C0040bk.a(guiGraphics, i, (i2 + i4) - 1, i3, 1, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM);
        C0040bk.a(poseStack, guiGraphics, i, (i2 + i4) - 1, i3 * fE, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        C0040bk.c(font, guiGraphics, (Component) Component.literal(((int) (100.0f * this.gn)) + "%").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GRAY), i5, i6 - 4);
    }

    @Override // com.boehmod.blockfront.hM
    public int getColor() {
        return ChatFormatting.GRAY.getColor().intValue();
    }

    public float N() {
        return this.gn;
    }

    @Override // com.boehmod.blockfront.hM
    public void onUpdate() {
        super.onUpdate();
        this.gp = this.go;
        this.go = (float) Mth.lerp(0.5d, this.go, this.gn);
    }
}
