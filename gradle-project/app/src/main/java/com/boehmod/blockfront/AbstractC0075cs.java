package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cs.class */
public abstract class AbstractC0075cs {
    public final float dz;
    public final float dA;
    public float aE = 1.0f;
    public float aD = 1.0f;

    public abstract void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f);

    public AbstractC0075cs(float f, float f2) {
        this.dz = f;
        this.dA = f2;
    }

    public boolean k() {
        this.aE = this.aD;
        this.aD -= 0.05f;
        return this.aD <= 0.0f;
    }
}
