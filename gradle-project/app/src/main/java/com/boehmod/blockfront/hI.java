package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.dO;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hI.class */
public class hI extends hS {
    static final /* synthetic */ boolean cF;

    static {
        cF = !hI.class.desiredAssertionStatus();
    }

    public hI(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull hP hPVar) {
        super(str, str2, str3, hPVar, dO.a.MINECRAFT_RESOURCE);
    }

    @Override // com.boehmod.blockfront.hS, com.boehmod.blockfront.hM
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        C0297l c0297lB = C0297l.b();
        if (!cF && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        int i7 = ColorReferences.COLOR_WHITE_SOLID;
        C0040bk.a(guiGraphics, i, i2, i3, i4, i7, C0634xm.e(this.db, this.dc, f2));
        C0040bk.a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        A a = c0297lB.m585a().a(q());
        int i8 = i4 / 2;
        float fClamp = Mth.clamp(Mth.sin(f / 15.0f), 0.0f, 1.0f);
        C0040bk.a(poseStack, guiGraphics, a, i + (i3 - i8), i2 + i8, hN.f153a.N() * Mth.clamp(1.0f - (hN.i.T() ? fClamp : 0.0f), 0.0f, 1.0f), hN.f152d.T(), hN.e.T(), fClamp);
    }
}
