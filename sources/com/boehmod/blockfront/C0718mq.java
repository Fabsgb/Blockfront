package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mq.class */
public class C0718mq extends AbstractC0716mo {

    /* JADX INFO: renamed from: kC */
    private final int f3842kC;

    /* JADX INFO: renamed from: hZ */
    private final float f3843hZ;

    /* JADX INFO: renamed from: ia */
    private final float f3844ia;

    /* JADX INFO: renamed from: ib */
    private final float f3845ib;

    /* JADX INFO: renamed from: cx */
    private boolean f3846cx = false;

    /* JADX INFO: renamed from: aD */
    private float f3847aD = 0.0f;

    /* JADX INFO: renamed from: aE */
    private float f3848aE = 0.0f;

    public C0718mq(int i, float f, float f2, float f3) {
        this.f3842kC = i;
        this.f3843hZ = f;
        this.f3844ia = f2;
        this.f3845ib = f3;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: a */
    public boolean mo3254a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3848aE = this.f3847aD;
        if (this.f3846cx) {
            this.f3847aD = C1290xm.m7835d(this.f3847aD, 0.0f, this.f3844ia);
        } else {
            this.f3847aD = C1290xm.m7835d(this.f3847aD, this.f3845ib, this.f3843hZ);
            if (this.f3847aD >= this.f3845ib) {
                this.f3846cx = true;
            }
        }
        return this.f3846cx && this.f3847aD <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0716mo
    /* JADX INFO: renamed from: d */
    public void mo3255d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        C0119bk.m417a(guiGraphics, 0, 0, i, i2, this.f3842kC, C1290xm.m7843e(this.f3847aD, this.f3848aE, f));
    }
}
