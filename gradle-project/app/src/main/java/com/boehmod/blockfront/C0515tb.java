package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tb.class */
public class C0515tb extends AbstractC0517td {

    @NotNull
    private static final ResourceLocation fK = C0265jv.d("textures/gui/game/scoreboard/emblem.png");

    @Override // com.boehmod.blockfront.AbstractC0517td
    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        float fB = B(f);
        if (fB <= 0.02f) {
            fB = 0.02f;
        }
        int iA = C0634xm.a(i6, fB);
        String strM = oFVar.M();
        sX sXVarM751a = oFVar.m751a();
        C0040bk.a(poseStack, guiGraphics, fK, i + 10, i2 + 10, 32, 32, 0.0f, fB, iA);
        C0040bk.a(poseStack, font, guiGraphics, (Component) Component.literal(strM.toUpperCase(Locale.ROOT) + " | " + sXVarM751a.getName()).withColor(iA), 58.0f, i2 + 10 + 3, iA, 2.0f);
        C0040bk.a(font, guiGraphics, (Component) Component.literal(sXVarM751a.an()), 58, i2 + 10 + 21, iA);
    }
}
