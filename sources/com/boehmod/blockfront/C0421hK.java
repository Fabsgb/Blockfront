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

/* JADX INFO: renamed from: com.boehmod.blockfront.hK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hK.class */
public class C0421hK extends C0423hM {

    /* JADX INFO: renamed from: gm */
    private final float f2698gm;

    /* JADX INFO: renamed from: gn */
    private float f2699gn;

    /* JADX INFO: renamed from: go */
    private float f2700go;

    /* JADX INFO: renamed from: gp */
    private float f2701gp;

    public C0421hK(@NotNull String str, @NotNull String str2, @NotNull C0426hP c0426hP, float f) {
        super(str, str2, c0426hP, false);
        this.f2701gp = 0.0f;
        this.f2698gm = f;
        this.f2699gn = f;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1991a(@NotNull Minecraft minecraft, @NotNull Screen screen, int i) {
        if (i == 0) {
            this.f2699gn = C0423hM.m1994m(this.f2699gn);
        } else if (i == 1) {
            this.f2699gn = this.f2698gm;
        }
        C0424hN.f2773cI = true;
        this.f2708db = 1.0f;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1989a(@NotNull JsonObject jsonObject) {
        this.f2699gn = jsonObject.has(getKey()) ? jsonObject.get(getKey()).getAsFloat() : this.f2698gm;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: b */
    public void mo1990b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), Float.valueOf(this.f2699gn));
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1986a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        float fM7843e = C1290xm.m7843e(this.f2700go, this.f2701gp, f2);
        C0119bk.m417a(guiGraphics, i, i2, i3, i4, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM, C1290xm.m7843e(this.f2708db, this.f2709dc, f2));
        C0119bk.m415a(guiGraphics, i, (i2 + i4) - 1, i3, 1, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM);
        C0119bk.m414a(poseStack, guiGraphics, i, (i2 + i4) - 1, i3 * fM7843e, 1.0f, ColorReferences.COLOR_WHITE_SOLID);
        C0119bk.m383c(font, guiGraphics, (Component) Component.literal(((int) (100.0f * this.f2699gn)) + "%").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GRAY), i5, i6 - 4);
    }

    @Override // com.boehmod.blockfront.C0423hM
    public int getColor() {
        return ChatFormatting.GRAY.getColor().intValue();
    }

    /* JADX INFO: renamed from: N */
    public float m1992N() {
        return this.f2699gn;
    }

    @Override // com.boehmod.blockfront.C0423hM
    public void onUpdate() {
        super.onUpdate();
        this.f2701gp = this.f2700go;
        this.f2700go = (float) Mth.lerp(0.5d, this.f2700go, this.f2699gn);
    }
}
