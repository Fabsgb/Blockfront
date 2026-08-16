package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mM.class */
public class C0689mM extends AbstractC0687mK {

    /* JADX INFO: renamed from: mx */
    private final int f3794mx;

    /* JADX INFO: renamed from: iR */
    private final float f3795iR;

    /* JADX INFO: renamed from: iS */
    private final float f3796iS;

    /* JADX INFO: renamed from: iT */
    private final float f3797iT;

    /* JADX INFO: renamed from: cG */
    private boolean f3798cG = false;

    /* JADX INFO: renamed from: aI */
    private float f3799aI = 0.0f;

    /* JADX INFO: renamed from: aJ */
    private float f3800aJ = 0.0f;

    public C0689mM(int i, float f, float f2, float f3) {
        this.f3794mx = i;
        this.f3795iR = f;
        this.f3796iS = f2;
        this.f3797iT = f3;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: a */
    public boolean mo3087a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3800aJ = this.f3799aI;
        if (this.f3798cG) {
            this.f3799aI = C1270xJ.m7161d(this.f3799aI, 0.0f, this.f3796iS);
        } else {
            this.f3799aI = C1270xJ.m7161d(this.f3799aI, this.f3797iT, this.f3795iR);
            if (this.f3799aI >= this.f3797iT) {
                this.f3798cG = true;
            }
        }
        return this.f3798cG && this.f3799aI <= 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0687mK
    /* JADX INFO: renamed from: d */
    public void mo3088d(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        C0129bt.m517a(guiGraphics, 0, 0, i, i2, this.f3794mx, C1270xJ.m7170f(this.f3799aI, this.f3800aJ, f));
    }
}
