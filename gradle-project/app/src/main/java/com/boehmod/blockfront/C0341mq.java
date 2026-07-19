package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mq.class */
public class C0341mq extends AbstractC0339mo {
    private final int kC;
    private final float hZ;
    private final float ia;
    private final float ib;
    private boolean cx = false;
    private float aD = 0.0f;
    private float aE = 0.0f;

    public C0341mq(int i, float f, float f2, float f3) {
        this.kC = i;
        this.hZ = f;
        this.ia = f2;
        this.ib = f3;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.aE = this.aD;
        if (this.cx) {
            this.aD = C0634xm.d(this.aD, 0.0f, this.ia);
        } else {
            this.aD = C0634xm.d(this.aD, this.ib, this.hZ);
            if (this.aD >= this.ib) {
                this.cx = true;
            }
        }
        return this.cx && this.aD <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0339mo
    public void d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        C0040bk.a(guiGraphics, 0, 0, i, i2, this.kC, C0634xm.e(this.aD, this.aE, f));
    }
}
