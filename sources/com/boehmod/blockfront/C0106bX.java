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

/* JADX INFO: renamed from: com.boehmod.blockfront.bX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bX.class */
public class C0106bX extends AbstractC0168cg<C0962rV, C0964rX> {

    /* JADX INFO: renamed from: ai */
    private static final ResourceLocation f666ai = C0564jv.m2555d("textures/text/infected.png");

    /* JADX INFO: renamed from: c */
    @NotNull
    private FormattedCharSequence f667c;

    /* JADX INFO: renamed from: cM */
    private int f668cM;

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        m331a(minecraft, (C0962rV) abstractC0787oF, (C0964rX) abstractC0790oI, (AbstractC0788oG<C0962rV, C0964rX>) abstractC0788oG, localPlayer);
    }

    public C0106bX() {
        super(1);
        this.f667c = FormattedCharSequence.EMPTY;
        this.f668cM = 1;
    }

    /* JADX INFO: renamed from: a */
    public void m331a(@NotNull Minecraft minecraft, @NotNull C0962rV c0962rV, @NotNull C0964rX c0964rX, @NotNull AbstractC0788oG<C0962rV, C0964rX> abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        this.f667c = Component.literal(C1293xp.m7912a(c0962rV.f5091qc + c0962rV.f5090qb)).withStyle(ChatFormatting.RED).getVisualOrderText();
        this.f668cM = minecraft.font.width(this.f667c) + 15 + 3;
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        int i3 = i + 3;
        C0119bk.m431a(poseStack, guiGraphics, f666ai, i3, i2 + 2, 11, 11);
        C0119bk.m404b(font, guiGraphics, this.f667c, i3 + 11 + 2, i2 + 4);
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        return this.f668cM;
    }
}
