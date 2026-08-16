package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.pD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pD.class */
public class C0839pD {

    /* JADX INFO: renamed from: dO */
    @NotNull
    private static final ResourceLocation f4525dO = C0532jO.m2378d("textures/gui/game/radio/bg.png");

    /* JADX INFO: renamed from: dP */
    @NotNull
    private static final ResourceLocation f4526dP = C0532jO.m2378d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: pE */
    private static final int f4527pE = 16;

    /* JADX INFO: renamed from: pF */
    private static final int f4528pF = 64;

    /* JADX INFO: renamed from: b */
    @Nonnull
    private final EnumC0960rS f4529b;

    /* JADX INFO: renamed from: dQ */
    @NotNull
    private final ResourceLocation f4530dQ;

    /* JADX INFO: renamed from: O */
    private final Vec3 f4531O;

    /* JADX INFO: renamed from: aN */
    private int f4532aN;

    public C0839pD(@NotNull String str, int i, @NotNull Vec3 vec3, @Nonnull EnumC0960rS enumC0960rS) {
        this.f4530dQ = C0532jO.m2378d("textures/gui/game/radio/" + str + ".png");
        this.f4532aN = i;
        this.f4531O = vec3;
        this.f4529b = enumC0960rS;
    }

    /* JADX INFO: renamed from: e */
    public boolean m3843e(@NotNull LocalPlayer localPlayer) {
        if (Mth.sqrt((float) localPlayer.distanceToSqr(this.f4531O)) <= 5.0f) {
            return true;
        }
        int i = this.f4532aN;
        this.f4532aN = i - 1;
        return i <= 0;
    }

    /* JADX INFO: renamed from: a */
    public void m3844a(@NotNull Camera camera, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0866pe<?> abstractC0866pe, float f) {
        C0872pk c0872pkM4229a = abstractC0866pe.m4229a(localPlayer.getUUID());
        if (c0872pkM4229a == null) {
            return;
        }
        int value = (-16777216) + ((TextColor) Objects.requireNonNull(c0872pkM4229a.m4312a().getColor())).getValue();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        C0129bt.f fVarM647a = C0129bt.m647a(m3846c(), camera, iGuiWidth, iGuiHeight, 32, f);
        float fSqrt = Mth.sqrt(((fVarM647a.m694h() - (iGuiWidth / 2.0f)) * (fVarM647a.m694h() - (iGuiWidth / 2.0f))) + ((fVarM647a.m695i() - (iGuiHeight / 2.0f)) * (fVarM647a.m695i() - (iGuiHeight / 2.0f)))) / Mth.sqrt(((iGuiWidth / 2) * (iGuiWidth / 2)) + ((iGuiHeight / 2) * (iGuiHeight / 2)));
        poseStack.pushPose();
        poseStack.translate(fVarM647a.m694h(), fVarM647a.m695i(), 0.0f);
        C0129bt.m547b(poseStack, guiGraphics, f4526dP, 0, 0, 64, 64, 0.0f, fSqrt, value);
        C0129bt.m547b(poseStack, guiGraphics, f4526dP, 0, 0, 32, 32, 0.0f, 0.25f * fSqrt, ColorReferences.COLOR_WHITE);
        C0129bt.m547b(poseStack, guiGraphics, f4525dO, 0, 0, 32, 32, 0.0f, fSqrt, value);
        C0129bt.m547b(poseStack, guiGraphics, getIcon(), 0, 0, 16, 16, 0.0f, fSqrt, ColorReferences.COLOR_WHITE);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0960rS m3845a() {
        return this.f4529b;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.f4530dQ;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m3846c() {
        return this.f4531O;
    }
}
