package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import java.util.Calendar;
import java.util.Iterator;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.du, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/du.class */
public class C0103du extends AbstractC0100dr {
    private static final int gy = Calendar.getInstance().get(1);

    @NotNull
    private static final Component eY = Component.literal(String.valueOf(gy)).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);

    @NotNull
    private static final Component eZ = Component.translatable("bf.menu.text.copyright.bf.left", new Object[]{eY, C0002a.a}).withColor(ColorReferences.COLOR_WHITE);

    @NotNull
    private static final Component fa = Component.translatable("bf.menu.text.copyright.mc.left", new Object[]{eY}).withColor(ColorReferences.COLOR_WHITE);

    @NotNull
    private static final Component fb = Component.translatable("bf.menu.text.copyright.right");

    @NotNull
    private static final String P = String.format("%s is a 3rd party modification and is not owned by or affiliated with %s, %s or %s", C0002a.a, String.valueOf(ChatFormatting.BOLD) + "Minecraft" + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.BOLD) + "Microsoft" + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.BOLD) + "Mojang AB" + String.valueOf(ChatFormatting.RESET));

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull Minecraft minecraft, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i / 2;
        C0040bk.b(poseStack, font, guiGraphics, eZ, 3.0f, 3.0f, 1157627903, 0.5f);
        C0040bk.b(poseStack, font, guiGraphics, fa, 3.0f, 9.0f, 1157627903, 0.5f);
        C0040bk.b(poseStack, font, guiGraphics, fb, (i - (font.width(fb) / 2)) - 3, 3.0f, 1157627903, 0.5f);
        int i6 = 0;
        Iterator it = iH.a(font, P, Token.CCOMMENT).iterator();
        while (it.hasNext()) {
            C0040bk.c(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()), i5, (i2 - 30) + (5 * i6), ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_TOP, 0.5f);
            i6++;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, iS iSVar, @NotNull C0080cx c0080cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0100dr
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull C0080cx c0080cx, float f) {
    }
}
