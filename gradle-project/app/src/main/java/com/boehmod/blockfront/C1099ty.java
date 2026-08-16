package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Locale;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ty */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ty.class */
public class C1099ty extends AbstractC1049tA {

    /* JADX INFO: renamed from: fJ */
    @NotNull
    private static final ResourceLocation f5994fJ = C0532jO.m2378d("textures/gui/game/scoreboard/emblem.png");

    @Override // com.boehmod.blockfront.AbstractC1049tA
    /* JADX INFO: renamed from: a */
    public void mo5865a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        float fE = m5866E(f);
        if (fE <= 0.02f) {
            fE = 0.02f;
        }
        int iM7159a = C1270xJ.m7159a(i6, fE);
        String strM4030T = abstractC0863pb.m4030T();
        C1095tu c1095tuM4027a = abstractC0863pb.m4027a();
        C0129bt.m537a(poseStack, guiGraphics, f5994fJ, i + 10, i2 + 10, 32, 32, 0.0f, fE, iM7159a);
        C0129bt.m488a(poseStack, font, guiGraphics, (Component) Component.literal(strM4030T.toUpperCase(Locale.ROOT) + " | " + c1095tuM4027a.getName()).withColor(iM7159a), 58.0f, i2 + 10 + 3, iM7159a, 2.0f);
        C0129bt.m471a(font, guiGraphics, (Component) Component.literal(c1095tuM4027a.m6050au()), 58, i2 + 10 + 21, iM7159a);
    }
}
