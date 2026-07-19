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

/* JADX INFO: renamed from: com.boehmod.blockfront.ds, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ds.class */
public class C0101ds extends AbstractC0100dr {

    @NotNull
    private static final Component eX = Component.translatable("bf.menu.text.punished.title").withStyle(ChatFormatting.RED);

    @NotNull
    private static final ItemStack b = new ItemStack((ItemLike) wY.l.get());
    private static final int gw = 50;
    private static final int gx = 250;
    private static final float dU = 1.5f;

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        iS iSVarM404a = fVVar.m404a(minecraft);
        int i5 = i / 2;
        int i6 = 8;
        poseStack.pushPose();
        if (minecraft.screen instanceof dG) {
            i6 = 15;
        }
        C0040bk.a(guiGraphics, 0, 40, i, i6, C0040bk.p());
        C0040bk.a(guiGraphics, 0, 40 + i6, i, 1, C0040bk.p(), 0.25f);
        C0040bk.c(guiGraphics, 0, 0, i, 40, C0040bk.p());
        C0040bk.c(guiGraphics, 0, i2 - 40, i, 40, C0040bk.p());
        C0040bk.a(guiGraphics, i5 - 162, 0, 325, 40);
        a(poseStack, font, guiGraphics, i5, iSVarM404a);
        guiGraphics.disableScissor();
        C0040bk.a(guiGraphics, 0, i2 - 50, i, 50, ColorReferences.COLOR_BLACK_TRANSPARENT, -1442840576);
        poseStack.popPose();
    }

    private static void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, @NotNull iS iSVar) {
        if (!iSVar.getActivePunishments().isEmpty()) {
            C0040bk.c(font, guiGraphics, eX, i, 10);
            int i2 = 0;
            ObjectListIterator it = iH.a(font, I18n.get("bf.menu.text.punished.par1", new Object[]{String.valueOf(ChatFormatting.RED) + String.valueOf(iSVar.getActivePunishments().size()) + String.valueOf(ChatFormatting.GRAY)}), 350).iterator();
            while (it.hasNext()) {
                C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()).withStyle(ChatFormatting.GRAY), i, 20 + (5 * i2), 0.5f);
                i2++;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, iS iSVar, @NotNull C0080cx c0080cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        boolean z = !iSVar.getActivePunishments().isEmpty();
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 50.0f);
        int i5 = i / 2;
        if (!z) {
            C0040bk.a(poseStack, guiGraphics, b, i5, 32.0f, 0.19f);
            a(guiGraphics, poseStack, font, f, i5);
        }
        poseStack.popPose();
    }

    private static void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, float f, int i) {
        ObjectList<String> objectListA = iH.a(font, C0080cx.F, gx);
        poseStack.pushPose();
        poseStack.translate(i + 40.0f, 27.0f, 50.0f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(-2.5f));
        float size = (1.5f - (0.4f * objectListA.size())) + (0.1f * ((Mth.sin(f / 30.0f) + 1.0f) / 2.0f));
        poseStack.scale(size, size, size);
        ObjectListIterator it = objectListA.iterator();
        while (it.hasNext()) {
            C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()), 0, 0, ColorReferences.COLOR_THEME_YELLOW_SOLID);
            poseStack.translate(0.0f, 8.0f, 0.0f);
        }
        poseStack.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, float f) {
    }
}
