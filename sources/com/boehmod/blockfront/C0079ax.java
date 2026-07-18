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

/* JADX INFO: renamed from: com.boehmod.blockfront.ax */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ax.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0079ax {

    /* JADX INFO: renamed from: Y */
    public static float f481Y;

    /* JADX INFO: renamed from: Z */
    public static float f482Z;

    /* JADX INFO: renamed from: aa */
    public static float f483aa;

    /* JADX INFO: renamed from: ab */
    public static float f484ab;

    /* JADX INFO: renamed from: ac */
    public static float f485ac;

    /* JADX INFO: renamed from: a */
    public static FogShape f486a;

    /* JADX INFO: renamed from: U */
    static final /* synthetic */ boolean f487U;

    static {
        f487U = !C0079ax.class.desiredAssertionStatus();
        f481Y = Float.MAX_VALUE;
        f482Z = Float.MAX_VALUE;
        f483aa = 0.0f;
        f484ab = 0.0f;
        f485ac = 0.0f;
        f486a = FogShape.SPHERE;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m272a(@NotNull ViewportEvent.RenderFog renderFog) {
        f481Y = Float.MAX_VALUE;
        if (Minecraft.getInstance().gameRenderer.getMainCamera().getFluidInCamera() != FogType.NONE) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f487U && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        C1018sY c1018sYM3653a = abstractC0787oFM2688a.m3653a();
        float fM5649aZ = c1018sYM3653a.m5649aZ();
        if (fM5649aZ <= 0.0f) {
            return;
        }
        float fLerp = Mth.lerp(fM5649aZ, renderFog.getNearPlaneDistance(), c1018sYM3653a.m5650ba());
        float fLerp2 = Mth.lerp(fM5649aZ, renderFog.getFarPlaneDistance(), c1018sYM3653a.m5651bb());
        renderFog.setNearPlaneDistance(fLerp);
        renderFog.setFarPlaneDistance(fLerp2);
        renderFog.setFogShape(FogShape.CYLINDER);
        renderFog.setCanceled(true);
        f481Y = fLerp;
        f482Z = fLerp2;
        f486a = FogShape.CYLINDER;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m273a(@NotNull ViewportEvent.ComputeFogColor computeFogColor) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f487U && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            C1018sY c1018sYM3653a = abstractC0787oFM2688a.m3653a();
            float fM5634aW = c1018sYM3653a.m5634aW();
            if (fM5634aW > 0.0f) {
                int iM5633bQ = c1018sYM3653a.m5633bQ();
                computeFogColor.setRed(Mth.lerp(fM5634aW, computeFogColor.getRed(), ((iM5633bQ >> 16) & 255) / 255.0f));
                computeFogColor.setGreen(Mth.lerp(fM5634aW, computeFogColor.getGreen(), ((iM5633bQ >> 8) & 255) / 255.0f));
                computeFogColor.setBlue(Mth.lerp(fM5634aW, computeFogColor.getBlue(), (iM5633bQ & 255) / 255.0f));
            }
        }
        f483aa = computeFogColor.getRed();
        f484ab = computeFogColor.getGreen();
        f485ac = computeFogColor.getBlue();
    }
}
