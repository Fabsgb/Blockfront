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

/* JADX INFO: renamed from: com.boehmod.blockfront.cg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cg.class */
public class C0169cg extends AbstractC0188cp<C1040ss, C1042su> {

    /* JADX INFO: renamed from: ai */
    private static final ResourceLocation f1347ai = C0532jO.m2378d("textures/text/infected.png");

    /* JADX INFO: renamed from: c */
    @NotNull
    private FormattedCharSequence f1348c;

    /* JADX INFO: renamed from: dV */
    private int f1349dV;

    /* JADX INFO: renamed from: dE */
    private int f1350dE;

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        m1056a(minecraft, (C1040ss) abstractC0863pb, (C1042su) abstractC0866pe, (AbstractC0864pc<C1040ss, C1042su>) abstractC0864pc, localPlayer);
    }

    public C0169cg() {
        super(1);
        this.f1348c = FormattedCharSequence.EMPTY;
        this.f1349dV = Integer.MIN_VALUE;
        this.f1350dE = 1;
    }

    /* JADX INFO: renamed from: a */
    public void m1056a(@NotNull Minecraft minecraft, @NotNull C1040ss c1040ss, @NotNull C1042su c1042su, @NotNull AbstractC0864pc<C1040ss, C1042su> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        int i = c1040ss.f5668sd + c1040ss.f5667sc;
        if (i != this.f1349dV) {
            this.f1349dV = i;
            this.f1348c = Component.literal(C1273xM.m7239b(i)).withStyle(ChatFormatting.RED).getVisualOrderText();
            this.f1350dE = minecraft.font.width(this.f1348c) + 15 + 3;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        int i3 = i + 3;
        C0129bt.m531a(poseStack, guiGraphics, f1347ai, i3, i2 + 2, 11, 11);
        C0129bt.m504b(font, guiGraphics, this.f1348c, i3 + 11 + 2, i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        return this.f1350dE;
    }
}
