package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cr.class */
public class C0189cr extends AbstractC0190cs {
    public C0189cr(float f, float f2) {
        super(f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0190cs
    /* JADX INFO: renamed from: a */
    public void mo1171a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        float fM7843e = C1290xm.m7843e(this.f1535aD, this.f1536aE, f);
        C0119bk.m416a(poseStack, guiGraphics, 125.0f - this.f1533dz, (125.0f - this.f1534dA) - (5.0f * fM7843e), 10.0f, 10.0f, ColorReferences.COLOR_WHITE_SOLID, 0.3f * fM7843e);
    }
}
