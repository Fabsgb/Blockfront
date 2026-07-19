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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aA.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aA {
    private static final float aJ = 0.5f;
    private static final float aK = 0.2f;
    private static final List<InterfaceC0209hs> g;
    static final /* synthetic */ boolean Y;

    static {
        Y = !aA.class.desiredAssertionStatus();
        g = new ObjectArrayList();
        g.add(new C0214hx());
        g.add(new C0210ht());
        g.add(new C0213hw());
        g.add(new C0212hv());
        g.add(new C0211hu());
    }

    @SubscribeEvent
    public static void c(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        Font font = minecraft.font;
        GameRenderer gameRenderer = minecraft.gameRenderer;
        Camera mainCamera = gameRenderer.getMainCamera();
        float fG = C0040bk.g();
        float gameTimeDeltaPartialTick = renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false);
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, bufferSource);
        PoseStack poseStackPose = guiGraphics.pose();
        minecraft.gui.getDebugOverlay().showDebugScreen();
        poseStackPose.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
        C0040bk.a(mainCamera, poseStackPose);
        RenderLevelStageEvent.Stage stage = renderLevelStageEvent.getStage();
        C0297l c0297lB = C0297l.b();
        if (!Y && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        fT fTVarA = fVVar.a(minecraft);
        if (stage == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
            RenderSystem.enableDepthTest();
            c0297lB.m589a().a(minecraft, c0297lB, fTVarA, clientLevel, localPlayer, poseStackPose, gameTimeDeltaPartialTick);
        }
        if (stage == RenderLevelStageEvent.Stage.AFTER_WEATHER) {
            c0297lB.m590a().a(minecraft, gameRenderer, mainCamera, gameTimeDeltaPartialTick);
        }
        boolean z = stage == RenderLevelStageEvent.Stage.AFTER_PARTICLES;
        if (stage == RenderLevelStageEvent.Stage.AFTER_LEVEL) {
            a(minecraft, gameTimeDeltaPartialTick);
        }
        Iterable<Entity> iterableEntitiesForRendering = clientLevel.entitiesForRendering();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        if (stage == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
            Iterator<InterfaceC0209hs> it = g.iterator();
            while (it.hasNext()) {
                it.next().a(renderLevelStageEvent, minecraft, c0297lB, clientLevel, fVVar, poseStackPose, frustum, guiGraphics, bufferSource, font, mainCamera, iterableEntitiesForRendering, threadLocalRandomCurrent, gameTimeDeltaPartialTick);
            }
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            a(renderLevelStageEvent, minecraft, c0297lB, clientLevel, localPlayer, oFVarM591a, poseStackPose, frustum, guiGraphics, font, mainCamera, z, fG, gameTimeDeltaPartialTick);
        }
    }

    private static void a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z, float f, float f2) {
        sY sYVarM767a = oFVar.m767a();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        if (z || sYVarM767a.a(renderLevelStageEvent.getStage())) {
            sYVarM767a.a(renderLevelStageEvent, minecraft, c0297l, localPlayer, clientLevel, minecraft.getBlockRenderer(), bufferSource, poseStack, guiGraphics, font, camera, f, f2);
        }
        if (z) {
            oI<?> oIVarB = oFVar.b();
            boolean zShowDebugScreen = minecraft.getDebugOverlay().showDebugScreen();
            oG<?, ?> oGVarM593a = c0297l.m593a();
            if (oGVarM593a != null && !c0297l.m602a().ay()) {
                oGVarM593a.a(oIVarB, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, zShowDebugScreen, f, f2);
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, float f) {
        float fE = 0.0f;
        if (hN.N.T()) {
            fE = 0.0f + (C0634xm.e(aU.bx, aU.by, f) * 0.5f);
        }
        float fMax = fE + Math.max(0.0f, C0634xm.e(aQ.bc, aQ.bd, f) - 1.0f);
        if (fMax > 0.0f) {
            C0040bk.a(minecraft, f, Math.min((int) (10.0f * fMax), 10));
        }
    }
}
