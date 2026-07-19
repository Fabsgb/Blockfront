package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import java.util.Iterator;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.cp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cp.class */
public final class C0072cp extends AbstractC0070cn {
    private static final ResourceLocation aE = C0265jv.d("textures/gui/overlay/vehicledamage.png");

    public static void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0376ny abstractC0376ny, float f, float f2) {
        CubeMap cubeMapA;
        nD nDVarA = abstractC0376ny.a((Entity) localPlayer);
        if (nDVarA == null || (cubeMapA = nB.a(nDVarA.K())) == null) {
            return;
        }
        float fE = C0634xm.e(aU.bn, aU.bo, f2);
        float fSin = 0.1f * Mth.sin(f / 3.2f) * (Mth.sin(f / 2.8f) + 1.0f);
        float f3 = fSin * fE;
        float fSin2 = 0.2f * Mth.sin(f / 3.6f) * Mth.sin(f / 2.4f) * fE;
        Entity cameraEntity = minecraft.getCameraEntity();
        float yRot = cameraEntity != null ? cameraEntity.getYRot() : 0.0f;
        float fE2 = C0634xm.e(abstractC0376ny.getXRot(), abstractC0376ny.xRotO, f2);
        float fE3 = C0634xm.e(abstractC0376ny.getYRot(), abstractC0376ny.yRotO, f2) - yRot;
        FloatFloatPair floatFloatPairB = abstractC0376ny.m742a().b(f2);
        float fFirstFloat = fE2 + floatFloatPairB.firstFloat();
        float fW = fE3 + (-floatFloatPairB.secondFloat());
        nD nDVarA2 = abstractC0376ny.a((Entity) localPlayer);
        if (nDVarA2 != null) {
            Iterator<nN<?>> it = nDVarA2.m715b().iterator();
            while (it.hasNext()) {
                fW += it.next().w(f2);
            }
        }
        Vector3f vector3fA = hE.a(f2);
        cubeMapA.render(minecraft, (-fFirstFloat) + f3 + vector3fA.x, fW + fSin2 + vector3fA.y, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0070cn
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0297l c0297l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !minecraft.options.getCameraType().isFirstPerson()) {
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0376ny)) {
            return;
        }
        AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        a(minecraft, localPlayer, abstractC0376ny, fG, deltaTracker.getGameTimeDeltaPartialTick(false));
        if (abstractC0376ny.aQ()) {
            C0040bk.a(poseStackPose, guiGraphics, aE, 0, 0, iGuiWidth, iGuiHeight, ((Mth.sin(fG / 6.0f) + 1.0f) / 2.0f) * 0.75f);
        }
    }
}
