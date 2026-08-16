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

/* JADX INFO: renamed from: com.boehmod.blockfront.ia */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ia.class */
public class C0491ia extends C0494id {

    /* JADX INFO: renamed from: gH */
    private final float f2998gH;

    /* JADX INFO: renamed from: gI */
    private float f2999gI;

    /* JADX INFO: renamed from: gJ */
    private float f3000gJ;

    /* JADX INFO: renamed from: gK */
    private float f3001gK;

    public C0491ia(@NotNull String str, @NotNull String str2, @NotNull C0497ig c0497ig, float f) {
        super(str, str2, c0497ig, false);
        this.f3001gK = 0.0f;
        this.f2998gH = f;
        this.f2999gI = f;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2222a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            this.f2999gI = C0494id.m2228m(this.f2999gI);
        } else if (i == 1) {
            this.f2999gI = this.f2998gH;
        }
        C0495ie.f3075cR = true;
        this.f3009dh = 1.0f;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2020a(@NotNull JsonObject jsonObject) {
        this.f2999gI = jsonObject.has(getKey()) ? jsonObject.get(getKey()).getAsFloat() : this.f2998gH;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: b */
    public void mo2021b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), Float.valueOf(this.f2999gI));
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2017a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        float fM7170f = C1270xJ.m7170f(this.f3000gJ, this.f3001gK, f2);
        C0129bt.m517a(guiGraphics, i, i2, i3, i4, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM, C1270xJ.m7170f(this.f3009dh, this.f3010di, f2));
        C0129bt.m515a(guiGraphics, i, (i2 + i4) - 1, i3, 1, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM);
        C0129bt.m514a(poseStack, guiGraphics, i, (i2 + i4) - 1, i3 * fM7170f, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        C0129bt.m483c(font, guiGraphics, (Component) Component.literal(((int) (100.0f * this.f2999gI)) + "%").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GRAY), i5, i6 - 4);
    }

    @Override // com.boehmod.blockfront.C0494id
    public int getColor() {
        return ChatFormatting.GRAY.getColor().intValue();
    }

    /* JADX INFO: renamed from: N */
    public float m2223N() {
        return this.f2999gI;
    }

    @Override // com.boehmod.blockfront.C0494id
    public void onUpdate() {
        super.onUpdate();
        this.f3001gK = this.f3000gJ;
        this.f3000gJ = (float) Mth.lerp(0.5d, this.f3000gJ, this.f2999gI);
    }
}
