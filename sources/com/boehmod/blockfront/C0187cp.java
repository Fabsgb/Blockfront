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

/* JADX INFO: renamed from: com.boehmod.blockfront.cp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cp.class */
public final class C0187cp extends AbstractC0179cn {

    /* JADX INFO: renamed from: aE */
    private static final ResourceLocation f1532aE = C0564jv.m2555d("textures/gui/overlay/vehicledamage.png");

    /* JADX INFO: renamed from: a */
    public static void m1170a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0779ny abstractC0779ny, float f, float f2) {
        CubeMap cubeMapM3301a;
        C0732nD c0732nDM3535a = abstractC0779ny.m3535a((Entity) localPlayer);
        if (c0732nDM3535a == null || (cubeMapM3301a = C0730nB.m3301a(c0732nDM3535a.m3325K())) == null) {
            return;
        }
        float fM7843e = C1290xm.m7843e(C0050aU.f321bn, C0050aU.f322bo, f2);
        float fSin = 0.1f * Mth.sin(f / 3.2f) * (Mth.sin(f / 2.8f) + 1.0f);
        float f3 = fSin * fM7843e;
        float fSin2 = 0.2f * Mth.sin(f / 3.6f) * Mth.sin(f / 2.4f) * fM7843e;
        Entity cameraEntity = minecraft.getCameraEntity();
        float yRot = cameraEntity != null ? cameraEntity.getYRot() : 0.0f;
        float fM7843e2 = C1290xm.m7843e(abstractC0779ny.getXRot(), abstractC0779ny.xRotO, f2);
        float fM7843e3 = C1290xm.m7843e(abstractC0779ny.getYRot(), abstractC0779ny.yRotO, f2) - yRot;
        FloatFloatPair floatFloatPairM3311b = abstractC0779ny.m3500a().m3311b(f2);
        float fFirstFloat = fM7843e2 + floatFloatPairM3311b.firstFloat();
        float fMo3398w = fM7843e3 + (-floatFloatPairM3311b.secondFloat());
        C0732nD c0732nDM3535a2 = abstractC0779ny.m3535a((Entity) localPlayer);
        if (c0732nDM3535a2 != null) {
            Iterator<AbstractC0742nN<?>> it = c0732nDM3535a2.m3327b().iterator();
            while (it.hasNext()) {
                fMo3398w += it.next().mo3398w(f2);
            }
        }
        Vector3f vector3fM1964a = C0415hE.m1964a(f2);
        cubeMapM3301a.render(minecraft, (-fFirstFloat) + f3 + vector3fM1964a.x, fMo3398w + fSin2 + vector3fM1964a.y, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0179cn
    /* JADX INFO: renamed from: a */
    public void mo1027a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0622l c0622l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !minecraft.options.getCameraType().isFirstPerson()) {
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0779ny)) {
            return;
        }
        AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        m1170a(minecraft, localPlayer, abstractC0779ny, fM366g, deltaTracker.getGameTimeDeltaPartialTick(false));
        if (abstractC0779ny.m3509aQ()) {
            C0119bk.m433a(poseStackPose, guiGraphics, f1532aE, 0, 0, iGuiWidth, iGuiHeight, ((Mth.sin(fM366g / 6.0f) + 1.0f) / 2.0f) * 0.75f);
        }
    }
}
