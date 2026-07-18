package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0092bJ;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dx.class */
public class C0248dx extends AbstractC0242dr {
    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1410a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1411a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0482iS c0482iS, @NotNull C0195cx c0195cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        for (InterfaceC0092bJ interfaceC0092bJ : c0195cx.m1193d()) {
            if (interfaceC0092bJ.mo293a() == InterfaceC0092bJ.a.BACKGROUND) {
                interfaceC0092bJ.mo291a(minecraft, guiGraphics, poseStack, f, f2);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1412a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
        for (InterfaceC0092bJ interfaceC0092bJ : c0195cx.m1193d()) {
            if (interfaceC0092bJ.mo293a() == InterfaceC0092bJ.a.BACKGROUND) {
                interfaceC0092bJ.mo292b(minecraft, guiGraphics, poseStack, f, f2);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1413a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, float f) {
        c0195cx.m1193d().removeIf(interfaceC0092bJ -> {
            return interfaceC0092bJ.mo290a(f);
        });
    }
}
