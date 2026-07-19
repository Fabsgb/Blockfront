package com.boehmod.blockfront;

import com.boehmod.blockfront.tG;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ar.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0020ar {
    private C0020ar() {
    }

    @SubscribeEvent
    public static void a(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        UUID uuidJ;
        oF<?, ?, ?> oFVarM591a;
        pA pAVarA;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (uuidJ = tG.a.j()) != null) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return;
            }
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!(abstractC0264juM166a instanceof C0297l) || (oFVarM591a = ((C0297l) abstractC0264juM166a).m591a()) == null || (pAVarA = oFVarM591a.m767a().a(uuidJ)) == null) {
                return;
            }
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0040bk.a(mainCamera, poseStack);
            LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), new AABB(pAVarA.c.x - 0.55d, pAVarA.c.y - 0.55d, pAVarA.c.z - 0.55d, pAVarA.c.x + 0.55d, pAVarA.c.y + 0.55d, pAVarA.c.z + 0.55d), 1.0f, 0.8f, 0.0f, 1.0f);
        }
    }

    @SubscribeEvent
    public static void a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && tG.a.j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) wY.B.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                tG.a.di();
                interactionKeyMappingTriggered.setSwingHand(false);
                interactionKeyMappingTriggered.setCanceled(true);
            }
        }
    }
}
