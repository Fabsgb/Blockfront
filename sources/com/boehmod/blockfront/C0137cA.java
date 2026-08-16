package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cA.class */
public class C0137cA extends AbstractC0138cB {
    public C0137cA(float f, float f2) {
        super(f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0138cB
    /* JADX INFO: renamed from: a */
    public void mo768a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        float fM7170f = C1270xJ.m7170f(this.f1015aI, this.f1016aJ, f);
        C0129bt.m516a(poseStack, guiGraphics, 125.0f - this.f1013dF, (125.0f - this.f1014dG) - (5.0f * fM7170f), 10.0f, 10.0f, ColorReferences.COLOR_WHITE_SOLID, 0.3f * fM7170f);
    }
}
