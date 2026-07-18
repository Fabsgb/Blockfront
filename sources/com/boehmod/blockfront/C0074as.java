package com.boehmod.blockfront;

import com.boehmod.blockfront.C1053tF;
import com.boehmod.blockfront.C1055tH;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.as */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/as.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0074as {

    /* JADX INFO: renamed from: aP */
    private static final int f450aP = 2;

    /* JADX INFO: renamed from: J */
    private static final float f451J = 1.0f;

    /* JADX INFO: renamed from: aQ */
    private static final int f452aQ = -1;

    /* JADX INFO: renamed from: K */
    private static final float f453K = 0.35f;

    private C0074as() {
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m246b(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_SKY) {
            return;
        }
        C1055tH.b.m5877p(renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false));
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m247a(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        float fM5872C;
        Vec3 vec3M5851a;
        C1055tH.a aVarM5871b;
        float f;
        boolean z;
        int iDisplayColor;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        AbstractC0835pA abstractC0835pAM5608a;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null) {
            UUID uuidM5867j = C1055tH.b.m5867j();
            Vec3 vec3M5868v = C1055tH.b.m5868v();
            boolean z2 = false;
            if (uuidM5867j != null && vec3M5868v != null) {
                AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                if (!(abstractC0563juM168a instanceof C0622l) || (abstractC0787oFM2688a = ((C0622l) abstractC0563juM168a).m2688a()) == null || (abstractC0835pAM5608a = abstractC0787oFM2688a.m3653a().m5608a(uuidM5867j)) == null) {
                    return;
                }
                vec3M5851a = abstractC0835pAM5608a.f4464c;
                aVarM5871b = C1055tH.b.m5869a();
                f = 1.0f;
                z = true;
            } else {
                Vec3 vec3M5870w = C1055tH.b.m5870w();
                float gameTimeDeltaPartialTick = renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false);
                if (vec3M5870w != null) {
                    fM5872C = C1055tH.b.m5872C(gameTimeDeltaPartialTick);
                } else {
                    fM5872C = 0.0f;
                }
                float f2 = fM5872C;
                if (vec3M5870w != null && f2 > 0.0f) {
                    vec3M5851a = vec3M5870w;
                    aVarM5871b = C1055tH.b.m5871b();
                    f = f2;
                    z = false;
                } else if (m250a((Player) localPlayer)) {
                    vec3M5851a = C1053tF.b.m5851a(localPlayer);
                    aVarM5871b = C1055tH.a.NORMAL;
                    f = 1.0f;
                    z = false;
                    z2 = true;
                } else {
                    return;
                }
            }
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0119bk.m530a(mainCamera, poseStack);
            if (z2) {
                iDisplayColor = C1053tF.b.m5848a().displayColor();
            } else {
                iDisplayColor = aVarM5871b.displayColor();
            }
            int i = iDisplayColor;
            if (z) {
                LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), new AABB(vec3M5868v.x - 0.5d, vec3M5868v.y - 0.5d, vec3M5868v.z - 0.5d, vec3M5868v.x + 0.5d, vec3M5868v.y + 0.5d, vec3M5868v.z + 0.5d), ((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, 1.0f);
                C0119bk.m474a(mainCamera, poseStack, vec3M5868v, vec3M5851a, 1.0f, i);
            }
            m248a(poseStack, vec3M5851a, i, f);
            m249a(mainCamera, poseStack, vec3M5851a, i, f);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m248a(@NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
        int iFloor = (int) Math.floor(vec3.x);
        int iFloor2 = (int) Math.floor(vec3.y);
        int iFloor3 = (int) Math.floor(vec3.z);
        double d = vec3.x - ((double) iFloor);
        double d2 = vec3.y - ((double) iFloor2);
        double d3 = vec3.z - ((double) iFloor3);
        double dAbs = Math.abs(d - 0.5d);
        double dAbs2 = Math.abs(d2 - 0.5d);
        double dAbs3 = Math.abs(d3 - 0.5d);
        float fMax = ((float) Math.max(0.0d, 1.0d - (dAbs * 2.0d))) * 0.35f * f;
        float fMax2 = ((float) Math.max(0.0d, 1.0d - (dAbs2 * 2.0d))) * 0.35f * f;
        float fMax3 = ((float) Math.max(0.0d, 1.0d - (dAbs3 * 2.0d))) * 0.35f * f;
        double d4 = iFloor;
        double d5 = iFloor + 1;
        double d6 = iFloor2;
        double d7 = iFloor2 + 1;
        double d8 = iFloor3;
        double d9 = iFloor3 + 1;
        if (fMax > 0.0f) {
            C0119bk.m482a(poseStack, d4, d6, d8, d4, d7, d8, d4, d7, d9, d4, d6, d9, i, fMax);
            C0119bk.m482a(poseStack, d5, d6, d8, d5, d7, d8, d5, d7, d9, d5, d6, d9, i, fMax);
        }
        if (fMax2 > 0.0f) {
            C0119bk.m482a(poseStack, d4, d6, d8, d5, d6, d8, d5, d6, d9, d4, d6, d9, i, fMax2);
            C0119bk.m482a(poseStack, d4, d7, d8, d5, d7, d8, d5, d7, d9, d4, d7, d9, i, fMax2);
        }
        if (fMax3 > 0.0f) {
            C0119bk.m482a(poseStack, d4, d6, d8, d5, d6, d8, d5, d7, d8, d4, d7, d8, i, fMax3);
            C0119bk.m482a(poseStack, d4, d6, d9, d5, d6, d9, d5, d7, d9, d4, d7, d9, i, fMax3);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m249a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
        int iFloor = (int) Math.floor(vec3.x - 2.0d);
        int iFloor2 = ((int) Math.floor(vec3.x + 2.0d)) + 1;
        int iFloor3 = (int) Math.floor(vec3.y - 2.0d);
        int iFloor4 = ((int) Math.floor(vec3.y + 2.0d)) + 1;
        int iFloor5 = (int) Math.floor(vec3.z - 2.0d);
        int iFloor6 = ((int) Math.floor(vec3.z + 2.0d)) + 1;
        float f2 = 1.0f * f;
        for (int i2 = iFloor3; i2 <= iFloor4; i2++) {
            double d = ((double) i2) - vec3.y;
            for (int i3 = iFloor5; i3 <= iFloor6; i3++) {
                double d2 = ((double) i3) - vec3.z;
                double d3 = (d * d) + (d2 * d2);
                if (d3 < 4.0d) {
                    float fSqrt = ((float) (1.0d - (Math.sqrt(d3) / 2.0d))) * f2;
                    C0119bk.m481a(camera, poseStack, iFloor, i2, i3, vec3.x, i2, i3, 1.0f, i, i, 0.0f, fSqrt);
                    C0119bk.m481a(camera, poseStack, vec3.x, i2, i3, iFloor2, i2, i3, 1.0f, i, i, fSqrt, 0.0f);
                }
            }
        }
        for (int i4 = iFloor; i4 <= iFloor2; i4++) {
            double d4 = ((double) i4) - vec3.x;
            for (int i5 = iFloor5; i5 <= iFloor6; i5++) {
                double d5 = ((double) i5) - vec3.z;
                double d6 = (d4 * d4) + (d5 * d5);
                if (d6 < 4.0d) {
                    float fSqrt2 = ((float) (1.0d - (Math.sqrt(d6) / 2.0d))) * f2;
                    C0119bk.m481a(camera, poseStack, i4, iFloor3, i5, i4, vec3.y, i5, 1.0f, i, i, 0.0f, fSqrt2);
                    C0119bk.m481a(camera, poseStack, i4, vec3.y, i5, i4, iFloor4, i5, 1.0f, i, i, fSqrt2, 0.0f);
                }
            }
        }
        for (int i6 = iFloor; i6 <= iFloor2; i6++) {
            double d7 = ((double) i6) - vec3.x;
            for (int i7 = iFloor3; i7 <= iFloor4; i7++) {
                double d8 = ((double) i7) - vec3.y;
                double d9 = (d7 * d7) + (d8 * d8);
                if (d9 < 4.0d) {
                    float fSqrt3 = ((float) (1.0d - (Math.sqrt(d9) / 2.0d))) * f2;
                    C0119bk.m481a(camera, poseStack, i6, i7, iFloor5, i6, i7, vec3.z, 1.0f, i, i, 0.0f, fSqrt3);
                    C0119bk.m481a(camera, poseStack, i6, i7, vec3.z, i6, i7, iFloor6, 1.0f, i, i, fSqrt3, 0.0f);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m250a(@NotNull Player player) {
        Item item = (Item) C1231wY.f7130A.get();
        return player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m251a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && C1055tH.b.m5867j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1231wY.f7129z.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                C1055tH.b.m5882dn();
                interactionKeyMappingTriggered.setSwingHand(false);
                interactionKeyMappingTriggered.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m252b(@NotNull InputEvent.Key key) {
        LocalPlayer localPlayer;
        if (key.getKey() == 261 && key.getAction() == 1 && C1055tH.b.m5867j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1231wY.f7129z.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                C1055tH.b.m5881dm();
            }
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m253a(@NotNull InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        LocalPlayer localPlayer;
        if (C1055tH.b.m5867j() == null || (localPlayer = Minecraft.getInstance().player) == null || !localPlayer.isCreative()) {
            return;
        }
        Item item = (Item) C1231wY.f7129z.get();
        if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
            C1055tH.b.m5880b(mouseScrollingEvent.getScrollDeltaY() * 1.0d);
            mouseScrollingEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m254a(@NotNull InputEvent.MouseButton.Pre pre) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        if (pre.getButton() == 2 && pre.getAction() == 1 && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1231wY.f7129z.get();
            if ((localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) && C1055tH.b.m5867j() != null) {
                C1055tH.b.m5873dk();
                pre.setCanceled(true);
                return;
            }
            Item item2 = (Item) C1231wY.f7130A.get();
            if (localPlayer.getMainHandItem().getItem() == item2 || localPlayer.getOffhandItem().getItem() == item2) {
                C1053tF.b.m5849H(minecraft);
                pre.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m255a(@NotNull RenderGuiEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !localPlayer.isCreative()) {
            return;
        }
        GuiGraphics guiGraphics = post.getGuiGraphics();
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = (guiGraphics.guiHeight() / 2) + 12;
        if (C1055tH.b.m5867j() != null) {
            C1055tH.a aVarM5869a = C1055tH.b.m5869a();
            guiGraphics.drawCenteredString(minecraft.font, Component.literal("Mode: " + aVarM5869a.displayName()), iGuiWidth, iGuiHeight, aVarM5869a.displayColor());
            return;
        }
        Item item = (Item) C1231wY.f7130A.get();
        if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
            C1053tF.a aVarM5848a = C1053tF.b.m5848a();
            guiGraphics.drawCenteredString(minecraft.font, Component.literal("Mode: " + aVarM5848a.displayName()), iGuiWidth, iGuiHeight, aVarM5848a.displayColor());
        }
    }
}
