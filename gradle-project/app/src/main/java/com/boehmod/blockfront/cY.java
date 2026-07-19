package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cY.class */
public class cY extends C0048bs {

    @NotNull
    private final C0408pc b;

    public cY(int i, int i2, int i3, int i4, @NotNull Component component, @NotNull Button.OnPress onPress, @NotNull C0408pc c0408pc) {
        super(i, i2, i3, i4, component, onPress);
        this.b = c0408pc;
    }

    @Override // com.boehmod.blockfront.C0048bs
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        super.a(guiGraphics, poseStack, i, i2, f, f2);
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.a(poseStack, guiGraphics, this.b.a(), getX() + i3, getY() + i4, 1.5f);
    }

    @Override // com.boehmod.blockfront.C0048bs
    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int x = getX() + (this.width / 2);
        int y = getY() + this.height;
        int iBk = this.b.bk();
        C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal(this.b.a().getDisplayName().getString().replace("[", "").replace("]", "")).withStyle(ChatFormatting.BOLD), x, y - 14, ColorReferences.COLOR_WHITE, 0.4f);
        if (iBk > 0) {
            C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal(String.valueOf(this.b.bk())).withStyle(ChatFormatting.GREEN), x, y - 8, ColorReferences.COLOR_WHITE, 0.8f);
        }
    }
}
