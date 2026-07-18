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

/* JADX INFO: renamed from: com.boehmod.blockfront.du */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/du.class */
public class C0245du extends AbstractC0242dr {

    /* JADX INFO: renamed from: gy */
    private static final int f2020gy = Calendar.getInstance().get(1);

    /* JADX INFO: renamed from: eY */
    @NotNull
    private static final Component f2021eY = Component.literal(String.valueOf(f2020gy)).withColor(ColorReferences.COLOR_TEAM_ALLIES_HOVERED);

    /* JADX INFO: renamed from: eZ */
    @NotNull
    private static final Component f2022eZ = Component.translatable("bf.menu.text.copyright.bf.left", new Object[]{f2021eY, C0029a.f246a}).withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: fa */
    @NotNull
    private static final Component f2023fa = Component.translatable("bf.menu.text.copyright.mc.left", new Object[]{f2021eY}).withColor(ColorReferences.COLOR_WHITE);

    /* JADX INFO: renamed from: fb */
    @NotNull
    private static final Component f2024fb = Component.translatable("bf.menu.text.copyright.right");

    /* JADX INFO: renamed from: P */
    @NotNull
    private static final String f2025P = String.format("%s is a 3rd party modification and is not owned by or affiliated with %s, %s or %s", C0029a.f246a, String.valueOf(ChatFormatting.BOLD) + "Minecraft" + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.BOLD) + "Microsoft" + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.BOLD) + "Mojang AB" + String.valueOf(ChatFormatting.RESET));

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1410a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull Minecraft minecraft, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, int i3, int i4, float f, float f2) {
        int i5 = i / 2;
        C0119bk.m389b(poseStack, font, guiGraphics, f2022eZ, 3.0f, 3.0f, 1157627903, 0.5f);
        C0119bk.m389b(poseStack, font, guiGraphics, f2023fa, 3.0f, 9.0f, 1157627903, 0.5f);
        C0119bk.m389b(poseStack, font, guiGraphics, f2024fb, (i - (font.width(f2024fb) / 2)) - 3, 3.0f, 1157627903, 0.5f);
        int i6 = 0;
        Iterator it = C0471iH.m2131a(font, f2025P, Token.CCOMMENT).iterator();
        while (it.hasNext()) {
            C0119bk.m392c(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()), i5, (i2 - 30) + (5 * i6), ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_TOP, 0.5f);
            i6++;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1411a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0482iS c0482iS, @NotNull C0195cx c0195cx, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1412a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0242dr
    /* JADX INFO: renamed from: a */
    public void mo1413a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0195cx c0195cx, float f) {
    }
}
