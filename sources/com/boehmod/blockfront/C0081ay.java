package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.ay */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ay.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0081ay {
    private C0081ay() {
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m298a(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        UUID uuidM6496j;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        AbstractC0858pW abstractC0858pWM6096a;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (uuidM6496j = C1132ue.a.m6496j()) != null) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return;
            }
            AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
            if (!(abstractC0531jNM179a instanceof C0623l) || (abstractC0863pbM2874a = ((C0623l) abstractC0531jNM179a).m2874a()) == null || (abstractC0858pWM6096a = abstractC0863pbM2874a.m4089a().m6096a(uuidM6496j)) == null) {
                return;
            }
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0129bt.m632a(mainCamera, poseStack);
            LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), new AABB(abstractC0858pWM6096a.f4593c.x - 0.55d, abstractC0858pWM6096a.f4593c.y - 0.55d, abstractC0858pWM6096a.f4593c.z - 0.55d, abstractC0858pWM6096a.f4593c.x + 0.55d, abstractC0858pWM6096a.f4593c.y + 0.55d, abstractC0858pWM6096a.f4593c.z + 0.55d), 1.0f, 0.8f, 0.0f, 1.0f);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m299a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && C1132ue.a.m6496j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1308xv.f7696B.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                C1132ue.a.m6498du();
                interactionKeyMappingTriggered.setSwingHand(false);
                interactionKeyMappingTriggered.setCanceled(true);
            }
        }
    }
}
