package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bX.class */
public class bX extends AbstractC0063cg<rV, rX> {
    private static final ResourceLocation ai = C0265jv.d("textures/text/infected.png");

    @NotNull
    private FormattedCharSequence c;
    private int cM;

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public /* bridge */ /* synthetic */ void a(@NotNull Minecraft minecraft, @NotNull oF oFVar, @NotNull oI oIVar, @NotNull oG oGVar, @NotNull LocalPlayer localPlayer) {
        a(minecraft, (rV) oFVar, (rX) oIVar, (oG<rV, rX>) oGVar, localPlayer);
    }

    public bX() {
        super(1);
        this.c = FormattedCharSequence.EMPTY;
        this.cM = 1;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull rV rVVar, @NotNull rX rXVar, @NotNull oG<rV, rX> oGVar, @NotNull LocalPlayer localPlayer) {
        this.c = Component.literal(C0637xp.a(rVVar.qc + rVVar.qb)).withStyle(ChatFormatting.RED).getVisualOrderText();
        this.cM = minecraft.font.width(this.c) + 15 + 3;
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.a(guiGraphics, poseStack, font, i, i2, f);
        int i3 = i + 3;
        C0040bk.a(poseStack, guiGraphics, ai, i3, i2 + 2, 11, 11);
        C0040bk.b(font, guiGraphics, this.c, i3 + 11 + 2, i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public int a(@NotNull Font font) {
        return this.cM;
    }
}
