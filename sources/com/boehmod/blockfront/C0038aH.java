package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aH.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0038aH {

    /* JADX INFO: renamed from: aO */
    private static final float f358aO = 0.5f;

    /* JADX INFO: renamed from: aP */
    private static final float f359aP = 0.2f;

    /* JADX INFO: renamed from: h */
    private static final List<InterfaceC0420hI> f360h;

    /* JADX INFO: renamed from: ad */
    static final /* synthetic */ boolean f361ad;

    static {
        f361ad = !C0038aH.class.desiredAssertionStatus();
        f360h = new ObjectArrayList();
        f360h.add(new C0425hN());
        f360h.add(new C0421hJ());
        f360h.add(new C0424hM());
        f360h.add(new C0423hL());
        f360h.add(new C0422hK());
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: c */
    public static void m213c(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        Font font = minecraft.font;
        GameRenderer gameRenderer = minecraft.gameRenderer;
        Camera mainCamera = gameRenderer.getMainCamera();
        float fM466g = C0129bt.m466g();
        float gameTimeDeltaPartialTick = renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false);
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, bufferSource);
        PoseStack poseStackPose = guiGraphics.pose();
        minecraft.gui.getDebugOverlay().showDebugScreen();
        poseStackPose.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
        C0129bt.m632a(mainCamera, poseStackPose);
        RenderLevelStageEvent.Stage stage = renderLevelStageEvent.getStage();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f361ad && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        if (stage == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
            RenderSystem.enableDepthTest();
            c0623lM2852b.m2871a().m69a(minecraft, c0623lM2852b, c0394gjM1885a, clientLevel, localPlayer, poseStackPose, gameTimeDeltaPartialTick);
        }
        if (stage == RenderLevelStageEvent.Stage.AFTER_WEATHER) {
            c0623lM2852b.m2872a().m1842a(minecraft, gameRenderer, mainCamera, gameTimeDeltaPartialTick);
        }
        boolean z = stage == RenderLevelStageEvent.Stage.AFTER_PARTICLES;
        if (stage == RenderLevelStageEvent.Stage.AFTER_LEVEL) {
            m215a(minecraft, gameTimeDeltaPartialTick);
        }
        Iterable<Entity> iterableEntitiesForRendering = clientLevel.entitiesForRendering();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        if (stage == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
            Iterator<InterfaceC0420hI> it = f360h.iterator();
            while (it.hasNext()) {
                it.next().mo1970a(renderLevelStageEvent, minecraft, c0623lM2852b, clientLevel, c0396gl, poseStackPose, frustum, guiGraphics, bufferSource, font, mainCamera, iterableEntitiesForRendering, threadLocalRandomCurrent, gameTimeDeltaPartialTick);
            }
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            m214a(renderLevelStageEvent, minecraft, c0623lM2852b, clientLevel, localPlayer, abstractC0863pbM2874a, poseStackPose, frustum, guiGraphics, font, mainCamera, z, fM466g, gameTimeDeltaPartialTick);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m214a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z, float f, float f2) {
        C1096tv c1096tvM4089a = abstractC0863pb.m4089a();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        if (z || c1096tvM4089a.m6077a(renderLevelStageEvent.getStage())) {
            c1096tvM4089a.m6090a(renderLevelStageEvent, minecraft, c0623l, localPlayer, clientLevel, minecraft.getBlockRenderer(), bufferSource, poseStack, guiGraphics, font, camera, f, f2);
        }
        if (z) {
            AbstractC0866pe<?> abstractC0866peM4018b = abstractC0863pb.m4018b();
            boolean zShowDebugScreen = minecraft.getDebugOverlay().showDebugScreen();
            AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623l.m2878a();
            if (abstractC0864pcM2878a != null && !c0623l.m2895a().m3074aJ()) {
                abstractC0864pcM2878a.mo4151a(abstractC0866peM4018b, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, zShowDebugScreen, f, f2);
                bufferSource.endBatch();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m215a(@NotNull Minecraft minecraft, float f) {
        float fM7170f = 0.0f;
        if (C0495ie.f3061N.m2230U()) {
            fM7170f = 0.0f + (C1270xJ.m7170f(C0112bc.f746bD, C0112bc.f747bE, f) * 0.5f);
        }
        float fMax = fM7170f + Math.max(0.0f, C1270xJ.m7170f(C0055aY.f401bi, C0055aY.f402bj, f) - 1.0f);
        if (fMax > 0.0f) {
            C0129bt.m629a(minecraft, f, Math.min((int) (10.0f * fMax), 10));
        }
    }
}
