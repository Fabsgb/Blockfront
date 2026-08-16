package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dB.class */
public class C0201dB extends AbstractC0200dA {

    /* JADX INFO: renamed from: fa */
    @NotNull
    private static final Component f1580fa = Component.translatable("bf.menu.text.punished.title").withStyle(ChatFormatting.RED);

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final ItemStack f1581b = new ItemStack((ItemLike) C1308xv.f7680l.get());

    /* JADX INFO: renamed from: hB */
    private static final int f1582hB = 50;

    /* JADX INFO: renamed from: hC */
    private static final int f1583hC = 250;

    /* JADX INFO: renamed from: dX */
    private static final float f1584dX = 1.5f;

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1236a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        int i5 = i / 2;
        int i6 = 8;
        poseStack.pushPose();
        if (minecraft.screen instanceof AbstractC0217dR) {
            i6 = 15;
        }
        C0129bt.m515a(guiGraphics, 0, 40, i, i6, C0129bt.m465t());
        C0129bt.m517a(guiGraphics, 0, 40 + i6, i, 1, C0129bt.m465t(), 0.25f);
        C0129bt.m591c(guiGraphics, 0, 0, i, 40, C0129bt.m465t());
        C0129bt.m591c(guiGraphics, 0, i2 - 40, i, 40, C0129bt.m465t());
        C0129bt.m618a(guiGraphics, i5 - 162, 0, 325, 40);
        m1240a(poseStack, font, guiGraphics, i5, c0555jlM1886a);
        guiGraphics.disableScissor();
        C0129bt.m523a(guiGraphics, 0, i2 - 50, i, 50, ColorReferences.COLOR_BLACK_TRANSPARENT, -1442840576);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m1240a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, @NotNull C0555jl c0555jl) {
        if (!c0555jl.getActivePunishments().isEmpty()) {
            C0129bt.m483c(font, guiGraphics, f1580fa, i, 10);
            int i2 = 0;
            ObjectListIterator it = C0544ja.m2458a(font, I18n.get("bf.menu.text.punished.par1", new Object[]{String.valueOf(ChatFormatting.RED) + String.valueOf(c0555jl.getActivePunishments().size()) + String.valueOf(ChatFormatting.GRAY)}), 350).iterator();
            while (it.hasNext()) {
                C0129bt.m491b(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()).withStyle(ChatFormatting.GRAY), i, 20 + (5 * i2), 0.5f);
                i2++;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1237a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0555jl c0555jl, @NotNull C0143cG c0143cG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        boolean z = !c0555jl.getActivePunishments().isEmpty();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 50.0f);
        int i5 = i / 2;
        if (!z) {
            C0129bt.m601b(poseStack, guiGraphics, f1581b, i5, 32.0f, 0.19f);
            m1241a(guiGraphics, poseStack, font, f, i5);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static void m1241a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, float f, int i) {
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, C0143cG.f1053L, f1583hC);
        poseStack.pushPose();
        poseStack.translate(i + 40.0f, 27.0f, 50.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(-2.5f));
        float size = (1.5f - (0.4f * objectListM2458a.size())) + (0.1f * ((Mth.sin(f / 30.0f) + 1.0f) / 2.0f));
        poseStack.scale(size, size, size);
        ObjectListIterator it = objectListM2458a.iterator();
        while (it.hasNext()) {
            C0129bt.m501a(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()), 0, 0, ColorReferences.COLOR_THEME_YELLOW_SOLID);
            poseStack.translate(0.0f, 8.0f, 0.0f);
        }
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1238a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1239a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0143cG c0143cG, float f) {
    }
}
