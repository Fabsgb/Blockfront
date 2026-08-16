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

/* JADX INFO: renamed from: com.boehmod.blockfront.cy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cy.class */
public final class C0197cy extends AbstractC0195cw {

    /* JADX INFO: renamed from: aE */
    private static final ResourceLocation f1576aE = C0532jO.m2378d("textures/gui/overlay/vehicledamage.png");

    /* JADX INFO: renamed from: a */
    public static void m1232a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0750nU abstractC0750nU, float f, float f2) {
        CubeMap cubeMapM3488a;
        C0755nZ c0755nZM3472a = abstractC0750nU.m3472a((Entity) localPlayer);
        if (c0755nZM3472a == null || (cubeMapM3488a = C0753nX.m3488a(c0755nZM3472a.m3512R())) == null) {
            return;
        }
        float fM7170f = C1270xJ.m7170f(C0112bc.f735bt, C0112bc.f736bu, f2);
        float fSin = 0.1f * Mth.sin(f / 3.2f) * (Mth.sin(f / 2.8f) + 1.0f);
        float f3 = fSin * fM7170f;
        float fSin2 = 0.2f * Mth.sin(f / 3.6f) * Mth.sin(f / 2.4f) * fM7170f;
        Entity cameraEntity = minecraft.getCameraEntity();
        float yRot = cameraEntity != null ? cameraEntity.getYRot() : 0.0f;
        float fM7170f2 = C1270xJ.m7170f(abstractC0750nU.getXRot(), abstractC0750nU.xRotO, f2);
        float fM7170f3 = C1270xJ.m7170f(abstractC0750nU.getYRot(), abstractC0750nU.yRotO, f2) - yRot;
        FloatFloatPair floatFloatPairM3498b = abstractC0750nU.m3437a().m3498b(f2);
        float fFirstFloat = fM7170f2 + floatFloatPairM3498b.firstFloat();
        float fMo3770z = fM7170f3 + (-floatFloatPairM3498b.secondFloat());
        C0755nZ c0755nZM3472a2 = abstractC0750nU.m3472a((Entity) localPlayer);
        if (c0755nZM3472a2 != null) {
            Iterator<AbstractC0818oj<?>> it = c0755nZM3472a2.m3514c().iterator();
            while (it.hasNext()) {
                fMo3770z += it.next().mo3770z(f2);
            }
        }
        Vector3f vector3fM1991a = C0432hU.m1991a(f2);
        cubeMapM3488a.render(minecraft, (-fFirstFloat) + f3 + vector3fM1991a.x, fMo3770z + fSin2 + vector3fM1991a.y, 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0195cw
    /* JADX INFO: renamed from: a */
    public void mo1214a(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker, @NotNull C0623l c0623l) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !minecraft.options.getCameraType().isFirstPerson()) {
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if (!(vehicle instanceof AbstractC0750nU)) {
            return;
        }
        AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        m1232a(minecraft, localPlayer, abstractC0750nU, fM466g, deltaTracker.getGameTimeDeltaPartialTick(false));
        if (abstractC0750nU.m3446ba()) {
            C0129bt.m533a(poseStackPose, guiGraphics, f1576aE, 0, 0, iGuiWidth, iGuiHeight, ((Mth.sin(fM466g / 6.0f) + 1.0f) / 2.0f) * 0.75f);
        }
    }
}
