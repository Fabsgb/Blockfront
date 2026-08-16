package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cB.class */
public abstract class AbstractC0138cB {

    /* JADX INFO: renamed from: dF */
    public final float f1013dF;

    /* JADX INFO: renamed from: dG */
    public final float f1014dG;

    /* JADX INFO: renamed from: aJ */
    public float f1016aJ = 1.0f;

    /* JADX INFO: renamed from: aI */
    public float f1015aI = 1.0f;

    /* JADX INFO: renamed from: a */
    public abstract void mo768a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f);

    public AbstractC0138cB(float f, float f2) {
        this.f1013dF = f;
        this.f1014dG = f2;
    }

    /* JADX INFO: renamed from: l */
    public boolean m769l() {
        this.f1016aJ = this.f1015aI;
        this.f1015aI -= 0.05f;
        return this.f1015aI <= 0.0f;
    }
}
