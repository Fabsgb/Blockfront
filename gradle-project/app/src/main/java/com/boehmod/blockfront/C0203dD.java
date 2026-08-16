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

/* JADX INFO: renamed from: com.boehmod.blockfront.dD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dD.class */
public class C0203dD extends AbstractC0200dA {

    /* JADX INFO: renamed from: hD */
    private static final int f1585hD = Calendar.getInstance().get(1);

    /* JADX INFO: renamed from: fb */
    @NotNull
    private static final Component f1586fb = Component.literal(String.valueOf(f1585hD)).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);

    /* JADX INFO: renamed from: fc */
    @NotNull
    private static final Component f1587fc = Component.translatable("bf.menu.text.copyright.bf.left", new Object[]{f1586fb, C0030a.f263a}).withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: fd */
    @NotNull
    private static final Component f1588fd = Component.translatable("bf.menu.text.copyright.mc.left", new Object[]{f1586fb}).withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: fe */
    @NotNull
    private static final Component f1589fe = Component.translatable("bf.menu.text.copyright.right");

    /* JADX INFO: renamed from: V */
    @NotNull
    private static final String f1590V = String.format("%s is a 3rd party modification and is not owned by or affiliated with %s, %s or %s", C0030a.f263a, String.valueOf(ChatFormatting.BOLD) + "Minecraft" + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.BOLD) + "Microsoft" + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.BOLD) + "Mojang AB" + String.valueOf(ChatFormatting.RESET));

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1236a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull Minecraft minecraft, @NotNull C0143cG c0143cG, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i / 2;
        C0129bt.m489b(poseStack, font, guiGraphics, f1587fc, 3.0f, 3.0f, 1157627903, 0.5f);
        C0129bt.m489b(poseStack, font, guiGraphics, f1588fd, 3.0f, 9.0f, 1157627903, 0.5f);
        C0129bt.m489b(poseStack, font, guiGraphics, f1589fe, (i - (font.width(f1589fe) / 2)) - 3, 3.0f, 1157627903, 0.5f);
        int i6 = 0;
        Iterator it = C0544ja.m2458a(font, f1590V, Token.CCOMMENT).iterator();
        while (it.hasNext()) {
            C0129bt.m492c(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()), i5, (i2 - 30) + (5 * i6), ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_TOP, 0.5f);
            i6++;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0200dA
    /* JADX INFO: renamed from: a */
    public void mo1237a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0555jl c0555jl, @NotNull C0143cG c0143cG, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
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
