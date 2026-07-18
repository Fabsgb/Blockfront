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

/* JADX INFO: renamed from: com.boehmod.blockfront.aA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aA.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0030aA {

    /* JADX INFO: renamed from: aJ */
    private static final float f258aJ = 0.5f;

    /* JADX INFO: renamed from: aK */
    private static final float f259aK = 0.2f;

    /* JADX INFO: renamed from: g */
    private static final List<InterfaceC0455hs> f260g;

    /* JADX INFO: renamed from: Y */
    static final /* synthetic */ boolean f261Y;

    static {
        f261Y = !C0030aA.class.desiredAssertionStatus();
        f260g = new ObjectArrayList();
        f260g.add(new C0460hx());
        f260g.add(new C0456ht());
        f260g.add(new C0459hw());
        f260g.add(new C0458hv());
        f260g.add(new C0457hu());
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: c */
    public static void m172c(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        LocalPlayer localPlayer = minecraft.player;
        if (clientLevel == null || localPlayer == null) {
            return;
        }
        Font font = minecraft.font;
        GameRenderer gameRenderer = minecraft.gameRenderer;
        Camera mainCamera = gameRenderer.getMainCamera();
        float fM366g = C0119bk.m366g();
        float gameTimeDeltaPartialTick = renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false);
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, bufferSource);
        PoseStack poseStackPose = guiGraphics.pose();
        minecraft.gui.getDebugOverlay().showDebugScreen();
        poseStackPose.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
        C0119bk.m530a(mainCamera, poseStackPose);
        RenderLevelStageEvent.Stage stage = renderLevelStageEvent.getStage();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f261Y && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        if (stage == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
            RenderSystem.enableDepthTest();
            c0622lM2667b.m2685a().m37a(minecraft, c0622lM2667b, c0324fTM1675a, clientLevel, localPlayer, poseStackPose, gameTimeDeltaPartialTick);
        }
        if (stage == RenderLevelStageEvent.Stage.AFTER_WEATHER) {
            c0622lM2667b.m2686a().m1632a(minecraft, gameRenderer, mainCamera, gameTimeDeltaPartialTick);
        }
        boolean z = stage == RenderLevelStageEvent.Stage.AFTER_PARTICLES;
        if (stage == RenderLevelStageEvent.Stage.AFTER_LEVEL) {
            m174a(minecraft, gameTimeDeltaPartialTick);
        }
        Iterable<Entity> iterableEntitiesForRendering = clientLevel.entitiesForRendering();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        if (stage == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
            Iterator<InterfaceC0455hs> it = f260g.iterator();
            while (it.hasNext()) {
                it.next().mo2068a(renderLevelStageEvent, minecraft, c0622lM2667b, clientLevel, c0326fV, poseStackPose, frustum, guiGraphics, bufferSource, font, mainCamera, iterableEntitiesForRendering, threadLocalRandomCurrent, gameTimeDeltaPartialTick);
            }
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            m173a(renderLevelStageEvent, minecraft, c0622lM2667b, clientLevel, localPlayer, abstractC0787oFM2688a, poseStackPose, frustum, guiGraphics, font, mainCamera, z, fM366g, gameTimeDeltaPartialTick);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m173a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z, float f, float f2) {
        C1018sY c1018sYM3653a = abstractC0787oF.m3653a();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        if (z || c1018sYM3653a.m5589a(renderLevelStageEvent.getStage())) {
            c1018sYM3653a.m5602a(renderLevelStageEvent, minecraft, c0622l, localPlayer, clientLevel, minecraft.getBlockRenderer(), bufferSource, poseStack, guiGraphics, font, camera, f, f2);
        }
        if (z) {
            AbstractC0790oI<?> abstractC0790oIM3582b = abstractC0787oF.m3582b();
            boolean zShowDebugScreen = minecraft.getDebugOverlay().showDebugScreen();
            AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622l.m2692a();
            if (abstractC0788oGM2692a != null && !c0622l.m2709a().m3241ay()) {
                abstractC0788oGM2692a.mo3715a(abstractC0790oIM3582b, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, zShowDebugScreen, f, f2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m174a(@NotNull Minecraft minecraft, float f) {
        float fM7843e = 0.0f;
        if (C0424hN.f2760N.m1996T()) {
            fM7843e = 0.0f + (C1290xm.m7843e(C0050aU.f332bx, C0050aU.f333by, f) * 0.5f);
        }
        float fMax = fM7843e + Math.max(0.0f, C1290xm.m7843e(C0046aQ.f298bc, C0046aQ.f299bd, f) - 1.0f);
        if (fMax > 0.0f) {
            C0119bk.m527a(minecraft, f, Math.min((int) (10.0f * fMax), 10));
        }
    }
}
