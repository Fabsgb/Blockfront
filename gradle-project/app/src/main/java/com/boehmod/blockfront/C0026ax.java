package com.boehmod.blockfront;

import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.level.material.FogType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ViewportEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ax.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0026ax {
    public static float Y;
    public static float Z;
    public static float aa;
    public static float ab;
    public static float ac;
    public static FogShape a;
    static final /* synthetic */ boolean U;

    static {
        U = !C0026ax.class.desiredAssertionStatus();
        Y = Float.MAX_VALUE;
        Z = Float.MAX_VALUE;
        aa = 0.0f;
        ab = 0.0f;
        ac = 0.0f;
        a = FogShape.SPHERE;
    }

    @SubscribeEvent
    public static void a(@NotNull ViewportEvent.RenderFog renderFog) {
        Y = Float.MAX_VALUE;
        if (Minecraft.getInstance().gameRenderer.getMainCamera().getFluidInCamera() != FogType.NONE) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!U && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a == null) {
            return;
        }
        sY sYVarM767a = oFVarM591a.m767a();
        float fAZ = sYVarM767a.aZ();
        if (fAZ <= 0.0f) {
            return;
        }
        float fLerp = Mth.lerp(fAZ, renderFog.getNearPlaneDistance(), sYVarM767a.ba());
        float fLerp2 = Mth.lerp(fAZ, renderFog.getFarPlaneDistance(), sYVarM767a.bb());
        renderFog.setNearPlaneDistance(fLerp);
        renderFog.setFarPlaneDistance(fLerp2);
        renderFog.setFogShape(FogShape.CYLINDER);
        renderFog.setCanceled(true);
        Y = fLerp;
        Z = fLerp2;
        a = FogShape.CYLINDER;
    }

    @SubscribeEvent
    public static void a(@NotNull ViewportEvent.ComputeFogColor computeFogColor) {
        C0297l c0297lB = C0297l.b();
        if (!U && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            sY sYVarM767a = oFVarM591a.m767a();
            float fAW = sYVarM767a.aW();
            if (fAW > 0.0f) {
                int iBQ = sYVarM767a.bQ();
                computeFogColor.setRed(Mth.lerp(fAW, computeFogColor.getRed(), ((iBQ >> 16) & 255) / 255.0f));
                computeFogColor.setGreen(Mth.lerp(fAW, computeFogColor.getGreen(), ((iBQ >> 8) & 255) / 255.0f));
                computeFogColor.setBlue(Mth.lerp(fAW, computeFogColor.getBlue(), (iBQ & 255) / 255.0f));
            }
        }
        aa = computeFogColor.getRed();
        ab = computeFogColor.getGreen();
        ac = computeFogColor.getBlue();
    }
}
