package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0040bk;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Objects;
import javax.annotation.Nonnull;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ph, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ph.class */
public class C0413ph {

    @NotNull
    private static final ResourceLocation dQ = C0265jv.d("textures/gui/game/radio/bg.png");

    @NotNull
    private static final ResourceLocation dR = C0265jv.d("textures/gui/backshadow_white.png");
    private static final int nF = 16;
    private static final int nG = 64;

    @Nonnull
    private final EnumC0481rv b;

    @NotNull
    private final ResourceLocation dS;
    private final Vec3 N;
    private int Z;

    public C0413ph(@NotNull String str, int i, @NotNull Vec3 vec3, @Nonnull EnumC0481rv enumC0481rv) {
        this.dS = C0265jv.d("textures/gui/game/radio/" + str + ".png");
        this.Z = i;
        this.N = vec3;
        this.b = enumC0481rv;
    }

    public boolean e(@NotNull LocalPlayer localPlayer) {
        if (Mth.sqrt((float) localPlayer.distanceToSqr(this.N)) <= 5.0f) {
            return true;
        }
        int i = this.Z;
        this.Z = i - 1;
        return i <= 0;
    }

    public void a(@NotNull Camera camera, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull oI<?> oIVar, float f) {
        oO oOVarA = oIVar.a(localPlayer.getUUID());
        if (oOVarA == null) {
            return;
        }
        int value = (-16777216) + ((TextColor) Objects.requireNonNull(oOVarA.a().getColor())).getValue();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        C0040bk.f fVarA = C0040bk.a(c(), camera, iGuiWidth, iGuiHeight, 32, f);
        float fSqrt = Mth.sqrt(((fVarA.h() - (iGuiWidth / 2.0f)) * (fVarA.h() - (iGuiWidth / 2.0f))) + ((fVarA.i() - (iGuiHeight / 2.0f)) * (fVarA.i() - (iGuiHeight / 2.0f)))) / Mth.sqrt(((iGuiWidth / 2) * (iGuiWidth / 2)) + ((iGuiHeight / 2) * (iGuiHeight / 2)));
        poseStack.pushPose();
        poseStack.translate(fVarA.h(), fVarA.i(), 0.0f);
        C0040bk.b(poseStack, guiGraphics, dR, 0, 0, 64, 64, 0.0f, fSqrt, value);
        C0040bk.b(poseStack, guiGraphics, dR, 0, 0, 32, 32, 0.0f, 0.25f * fSqrt, ColorReferences.COLOR_WHITE);
        C0040bk.b(poseStack, guiGraphics, dQ, 0, 0, 32, 32, 0.0f, fSqrt, value);
        C0040bk.b(poseStack, guiGraphics, getIcon(), 0, 0, 16, 16, 0.0f, fSqrt, ColorReferences.COLOR_WHITE);
        poseStack.popPose();
    }

    @NotNull
    public EnumC0481rv a() {
        return this.b;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.dS;
    }

    @NotNull
    public Vec3 c() {
        return this.N;
    }
}
