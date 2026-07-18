package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0119bk;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ph */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ph.class */
public class C0868ph {

    /* JADX INFO: renamed from: dQ */
    @NotNull
    private static final ResourceLocation f4556dQ = C0564jv.m2555d("textures/gui/game/radio/bg.png");

    /* JADX INFO: renamed from: dR */
    @NotNull
    private static final ResourceLocation f4557dR = C0564jv.m2555d("textures/gui/backshadow_white.png");

    /* JADX INFO: renamed from: nF */
    private static final int f4558nF = 16;

    /* JADX INFO: renamed from: nG */
    private static final int f4559nG = 64;

    /* JADX INFO: renamed from: b */
    @Nonnull
    private final EnumC0988rv f4560b;

    /* JADX INFO: renamed from: dS */
    @NotNull
    private final ResourceLocation f4561dS;

    /* JADX INFO: renamed from: N */
    private final Vec3 f4562N;

    /* JADX INFO: renamed from: Z */
    private int f4563Z;

    public C0868ph(@NotNull String str, int i, @NotNull Vec3 vec3, @Nonnull EnumC0988rv enumC0988rv) {
        this.f4561dS = C0564jv.m2555d("textures/gui/game/radio/" + str + ".png");
        this.f4563Z = i;
        this.f4562N = vec3;
        this.f4560b = enumC0988rv;
    }

    /* JADX INFO: renamed from: e */
    public boolean m4358e(@NotNull LocalPlayer localPlayer) {
        if (Mth.sqrt((float) localPlayer.distanceToSqr(this.f4562N)) <= 5.0f) {
            return true;
        }
        int i = this.f4563Z;
        this.f4563Z = i - 1;
        return i <= 0;
    }

    /* JADX INFO: renamed from: a */
    public void m4359a(@NotNull Camera camera, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0790oI<?> abstractC0790oI, float f) {
        C0796oO c0796oOM3793a = abstractC0790oI.m3793a(localPlayer.getUUID());
        if (c0796oOM3793a == null) {
            return;
        }
        int value = (-16777216) + ((TextColor) Objects.requireNonNull(c0796oOM3793a.m3876a().getColor())).getValue();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        C0119bk.f fVarM544a = C0119bk.m544a(m4361c(), camera, iGuiWidth, iGuiHeight, 32, f);
        float fSqrt = Mth.sqrt(((fVarM544a.m589h() - (iGuiWidth / 2.0f)) * (fVarM544a.m589h() - (iGuiWidth / 2.0f))) + ((fVarM544a.m590i() - (iGuiHeight / 2.0f)) * (fVarM544a.m590i() - (iGuiHeight / 2.0f)))) / Mth.sqrt(((iGuiWidth / 2) * (iGuiWidth / 2)) + ((iGuiHeight / 2) * (iGuiHeight / 2)));
        poseStack.pushPose();
        poseStack.translate(fVarM544a.m589h(), fVarM544a.m590i(), 0.0f);
        C0119bk.m447b(poseStack, guiGraphics, f4557dR, 0, 0, 64, 64, 0.0f, fSqrt, value);
        C0119bk.m447b(poseStack, guiGraphics, f4557dR, 0, 0, 32, 32, 0.0f, 0.25f * fSqrt, ColorReferences.COLOR_WHITE);
        C0119bk.m447b(poseStack, guiGraphics, f4556dQ, 0, 0, 32, 32, 0.0f, fSqrt, value);
        C0119bk.m447b(poseStack, guiGraphics, getIcon(), 0, 0, 16, 16, 0.0f, fSqrt, ColorReferences.COLOR_WHITE);
        poseStack.popPose();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0988rv m4360a() {
        return this.f4560b;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.f4561dS;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m4361c() {
        return this.f4562N;
    }
}
