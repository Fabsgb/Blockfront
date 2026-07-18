package com.boehmod.blockfront;

import com.boehmod.blockfront.C1054tG;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ar */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ar.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0073ar {
    private C0073ar() {
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m244a(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        UUID uuidM5860j;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        AbstractC0835pA abstractC0835pAM5608a;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (uuidM5860j = C1054tG.a.m5860j()) != null) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return;
            }
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!(abstractC0563juM168a instanceof C0622l) || (abstractC0787oFM2688a = ((C0622l) abstractC0563juM168a).m2688a()) == null || (abstractC0835pAM5608a = abstractC0787oFM2688a.m3653a().m5608a(uuidM5860j)) == null) {
                return;
            }
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0119bk.m530a(mainCamera, poseStack);
            LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), new AABB(abstractC0835pAM5608a.f4464c.x - 0.55d, abstractC0835pAM5608a.f4464c.y - 0.55d, abstractC0835pAM5608a.f4464c.z - 0.55d, abstractC0835pAM5608a.f4464c.x + 0.55d, abstractC0835pAM5608a.f4464c.y + 0.55d, abstractC0835pAM5608a.f4464c.z + 0.55d), 1.0f, 0.8f, 0.0f, 1.0f);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m245a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && C1054tG.a.m5860j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1231wY.f7131B.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                C1054tG.a.m5862di();
                interactionKeyMappingTriggered.setSwingHand(false);
                interactionKeyMappingTriggered.setCanceled(true);
            }
        }
    }
}
