package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0213dO;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hI.class */
public class C0419hI extends C0429hS {

    /* JADX INFO: renamed from: cF */
    static final /* synthetic */ boolean f2694cF;

    static {
        f2694cF = !C0419hI.class.desiredAssertionStatus();
    }

    public C0419hI(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull C0426hP c0426hP) {
        super(str, str2, str3, c0426hP, AbstractC0213dO.a.MINECRAFT_RESOURCE);
    }

    @Override // com.boehmod.blockfront.C0429hS, com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1986a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2694cF && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        int i7 = ColorReferences.COLOR_WHITE_SOLID;
        C0119bk.m417a(guiGraphics, i, i2, i3, i4, i7, C1290xm.m7843e(this.f2708db, this.f2709dc, f2));
        C0119bk.m415a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        C0003A c0003aA = c0622lM2667b.m2681a().m2435a(m2013q());
        int i8 = i4 / 2;
        float fClamp = Mth.clamp(Mth.sin(f / 15.0f), 0.0f, 1.0f);
        C0119bk.m534a(poseStack, guiGraphics, c0003aA, i + (i3 - i8), i2 + i8, C0424hN.f2724a.m1992N() * Mth.clamp(1.0f - (C0424hN.f2728i.m1996T() ? fClamp : 0.0f), 0.0f, 1.0f), C0424hN.f2720d.m1996T(), C0424hN.f2721e.m1996T(), fClamp);
    }
}
