package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cr.class */
public class C0074cr extends AbstractC0075cs {
    public C0074cr(float f, float f2) {
        super(f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0075cs
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f) {
        float fE = C0634xm.e(this.aD, this.aE, f);
        C0040bk.a(poseStack, guiGraphics, 125.0f - this.dz, (125.0f - this.dA) - (5.0f * fE), 10.0f, 10.0f, ColorReferences.COLOR_WHITE_SOLID, 0.3f * fE);
    }
}
