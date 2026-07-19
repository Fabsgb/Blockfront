package com.boehmod.blockfront;

import com.boehmod.blockfront.bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dx.class */
public class C0106dx extends AbstractC0100dr {
    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, iS iSVar, @NotNull C0080cx c0080cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        for (bJ bJVar : c0080cx.d()) {
            if (bJVar.a() == bJ.a.BACKGROUND) {
                bJVar.a(minecraft, guiGraphics, poseStack, f, f2);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        for (bJ bJVar : c0080cx.d()) {
            if (bJVar.a() == bJ.a.BACKGROUND) {
                bJVar.b(minecraft, guiGraphics, poseStack, f, f2);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, float f) {
        c0080cx.d().removeIf(bJVar -> {
            return bJVar.mo206a(f);
        });
    }
}
