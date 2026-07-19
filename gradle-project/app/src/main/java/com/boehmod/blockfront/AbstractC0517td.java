package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.td, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/td.class */
public abstract class AbstractC0517td {
    private static final int rt = 200;
    private float aD = 0.0f;
    private float aE = 0.0f;
    private int ei = 0;

    public abstract void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, int i, int i2, int i3, int i4, int i5, int i6, float f);

    public boolean k() {
        this.ei++;
        this.aE = this.aD;
        if (this.ei < 200) {
            this.aD = C0634xm.d(this.aD, 1.0f, 0.1f);
        } else {
            this.aD = C0634xm.d(this.aD, 0.0f, 0.1f);
        }
        return this.ei > 200 && this.aD + this.aE == 0.0f;
    }

    public void bf() {
        this.ei = 0;
        this.aD = 0.0f;
        this.aE = 0.0f;
    }

    public final float B(float f) {
        return C0634xm.e(this.aD, this.aE, f);
    }
}
