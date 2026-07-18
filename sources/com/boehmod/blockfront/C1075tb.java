package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tb.class */
public class C1075tb extends AbstractC1077td {

    /* JADX INFO: renamed from: fK */
    @NotNull
    private static final ResourceLocation f5649fK = C0564jv.m2555d("textures/gui/game/scoreboard/emblem.png");

    @Override // com.boehmod.blockfront.AbstractC1077td
    /* JADX INFO: renamed from: a */
    public void mo5983a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        float fB = m5986B(f);
        if (fB <= 0.02f) {
            fB = 0.02f;
        }
        int iM7833a = C1290xm.m7833a(i6, fB);
        String strM3594M = abstractC0787oF.m3594M();
        C1017sX c1017sXM3591a = abstractC0787oF.m3591a();
        C0119bk.m437a(poseStack, guiGraphics, f5649fK, i + 10, i2 + 10, 32, 32, 0.0f, fB, iM7833a);
        C0119bk.m388a(poseStack, font, guiGraphics, (Component) Component.literal(strM3594M.toUpperCase(Locale.ROOT) + " | " + c1017sXM3591a.getName()).withColor(iM7833a), 58.0f, i2 + 10 + 3, iM7833a, 2.0f);
        C0119bk.m371a(font, guiGraphics, (Component) Component.literal(c1017sXM3591a.m5562an()), 58, i2 + 10 + 21, iM7833a);
    }
}
