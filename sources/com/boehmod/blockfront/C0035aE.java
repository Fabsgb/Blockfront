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

/* JADX INFO: renamed from: com.boehmod.blockfront.aE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aE.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0035aE {

    /* JADX INFO: renamed from: ad */
    public static float f303ad;

    /* JADX INFO: renamed from: ae */
    public static float f304ae;

    /* JADX INFO: renamed from: af */
    public static float f305af;

    /* JADX INFO: renamed from: ag */
    public static float f306ag;

    /* JADX INFO: renamed from: ah */
    public static float f307ah;

    /* JADX INFO: renamed from: a */
    public static FogShape f308a;

    /* JADX INFO: renamed from: Z */
    static final /* synthetic */ boolean f309Z;

    static {
        f309Z = !C0035aE.class.desiredAssertionStatus();
        f303ad = Float.MAX_VALUE;
        f304ae = Float.MAX_VALUE;
        f305af = 0.0f;
        f306ag = 0.0f;
        f307ah = 0.0f;
        f308a = FogShape.SPHERE;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m199a(@NotNull ViewportEvent.RenderFog renderFog) {
        f303ad = Float.MAX_VALUE;
        if (Minecraft.getInstance().gameRenderer.getMainCamera().getFluidInCamera() != FogType.NONE) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f309Z && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        C1096tv c1096tvM4089a = abstractC0863pbM2874a.m4089a();
        float fM6137bf = c1096tvM4089a.m6137bf();
        if (fM6137bf <= 0.0f) {
            return;
        }
        float fLerp = Mth.lerp(fM6137bf, renderFog.getNearPlaneDistance(), c1096tvM4089a.m6138bg());
        float fLerp2 = Mth.lerp(fM6137bf, renderFog.getFarPlaneDistance(), c1096tvM4089a.m6139bh());
        renderFog.setNearPlaneDistance(fLerp);
        renderFog.setFarPlaneDistance(fLerp2);
        renderFog.setFogShape(FogShape.CYLINDER);
        renderFog.setCanceled(true);
        f303ad = fLerp;
        f304ae = fLerp2;
        f308a = FogShape.CYLINDER;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m200a(@NotNull ViewportEvent.ComputeFogColor computeFogColor) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f309Z && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            C1096tv c1096tvM4089a = abstractC0863pbM2874a.m4089a();
            float fM6122bc = c1096tvM4089a.m6122bc();
            if (fM6122bc > 0.0f) {
                int iM6121cf = c1096tvM4089a.m6121cf();
                computeFogColor.setRed(Mth.lerp(fM6122bc, computeFogColor.getRed(), ((iM6121cf >> 16) & 255) / 255.0f));
                computeFogColor.setGreen(Mth.lerp(fM6122bc, computeFogColor.getGreen(), ((iM6121cf >> 8) & 255) / 255.0f));
                computeFogColor.setBlue(Mth.lerp(fM6122bc, computeFogColor.getBlue(), (iM6121cf & 255) / 255.0f));
            }
        }
        f305af = computeFogColor.getRed();
        f306ag = computeFogColor.getGreen();
        f307ah = computeFogColor.getBlue();
    }
}
