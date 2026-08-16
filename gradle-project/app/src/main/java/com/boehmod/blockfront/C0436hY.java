package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hY.class */
public class C0436hY extends C0500ij {

    /* JADX INFO: renamed from: cO */
    static final /* synthetic */ boolean f2788cO;

    static {
        f2788cO = !C0436hY.class.desiredAssertionStatus();
    }

    public C0436hY(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull C0497ig c0497ig) {
        super(str, str2, str3, c0497ig, AbstractC0225dZ.a.MINECRAFT_RESOURCE);
    }

    @Override // com.boehmod.blockfront.C0500ij, com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2017a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2788cO && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        int i7 = ColorReferences.COLOR_WHITE_SOLID;
        C0129bt.m517a(guiGraphics, i, i2, i3, i4, i7, C1270xJ.m7170f(this.f3009dh, this.f3010di, f2));
        C0129bt.m515a(guiGraphics, i, (i2 + i4) - 1, i3, 1, i7);
        C0010G c0010gA = c0623lM2852b.m2867a().m2794a(m2247u());
        int i8 = i4 / 2;
        float fClamp = Mth.clamp(Mth.sin(f / 15.0f), 0.0f, 1.0f);
        C0129bt.m637a(poseStack, guiGraphics, c0010gA, i + (i3 - i8), i2 + i8, C0495ie.f3025a.m2223N() * Mth.clamp(1.0f - (C0495ie.f3029i.m2230U() ? fClamp : 0.0f), 0.0f, 1.0f), C0495ie.f3021d.m2230U(), C0495ie.f3022e.m2230U(), fClamp);
    }
}
