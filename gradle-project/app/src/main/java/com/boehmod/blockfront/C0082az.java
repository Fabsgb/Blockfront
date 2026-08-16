package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.az */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/az.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0082az {

    /* JADX INFO: renamed from: bD */
    private static final int f493bD = 2;

    /* JADX INFO: renamed from: O */
    private static final float f494O = 1.0f;

    /* JADX INFO: renamed from: bE */
    private static final int f495bE = -1;

    /* JADX INFO: renamed from: P */
    private static final float f496P = 0.35f;

    private C0082az() {
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m300b(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_SKY) {
            return;
        }
        C1133uf.b.m6513o(renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false));
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m301a(@NotNull RenderLevelStageEvent renderLevelStageEvent) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        float fM6508F;
        Vec3 vec3M6487a;
        C1133uf.a aVarM6507b;
        float f;
        boolean z;
        int iDisplayColor;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        AbstractC0858pW abstractC0858pWM6096a;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null) {
            UUID uuidM6503j = C1133uf.b.m6503j();
            Vec3 vec3M6504w = C1133uf.b.m6504w();
            boolean z2 = false;
            if (uuidM6503j != null && vec3M6504w != null) {
                AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                if (!(abstractC0531jNM179a instanceof C0623l) || (abstractC0863pbM2874a = ((C0623l) abstractC0531jNM179a).m2874a()) == null || (abstractC0858pWM6096a = abstractC0863pbM2874a.m4089a().m6096a(uuidM6503j)) == null) {
                    return;
                }
                vec3M6487a = abstractC0858pWM6096a.f4593c;
                aVarM6507b = C1133uf.b.m6505a();
                f = 1.0f;
                z = true;
            } else {
                Vec3 vec3M6506x = C1133uf.b.m6506x();
                float gameTimeDeltaPartialTick = renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false);
                if (vec3M6506x != null) {
                    fM6508F = C1133uf.b.m6508F(gameTimeDeltaPartialTick);
                } else {
                    fM6508F = 0.0f;
                }
                float f2 = fM6508F;
                if (vec3M6506x != null && f2 > 0.0f) {
                    vec3M6487a = vec3M6506x;
                    aVarM6507b = C1133uf.b.m6507b();
                    f = f2;
                    z = false;
                } else if (m304a((Player) localPlayer)) {
                    vec3M6487a = C1131ud.b.m6487a(localPlayer);
                    aVarM6507b = C1133uf.a.NORMAL;
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
            C0129bt.m632a(mainCamera, poseStack);
            if (z2) {
                iDisplayColor = C1131ud.b.m6484a().displayColor();
            } else {
                iDisplayColor = aVarM6507b.displayColor();
            }
            int i = iDisplayColor;
            if (z) {
                LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), new AABB(vec3M6504w.x - 0.5d, vec3M6504w.y - 0.5d, vec3M6504w.z - 0.5d, vec3M6504w.x + 0.5d, vec3M6504w.y + 0.5d, vec3M6504w.z + 0.5d), ((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, 1.0f);
                C0129bt.m574a(mainCamera, poseStack, vec3M6504w, vec3M6487a, 1.0f, i);
            }
            m302a(poseStack, vec3M6487a, i, f);
            m303a(mainCamera, poseStack, vec3M6487a, i, f);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m302a(@NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
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
            C0129bt.m582a(poseStack, d4, d6, d8, d4, d7, d8, d4, d7, d9, d4, d6, d9, i, fMax);
            C0129bt.m582a(poseStack, d5, d6, d8, d5, d7, d8, d5, d7, d9, d5, d6, d9, i, fMax);
        }
        if (fMax2 > 0.0f) {
            C0129bt.m582a(poseStack, d4, d6, d8, d5, d6, d8, d5, d6, d9, d4, d6, d9, i, fMax2);
            C0129bt.m582a(poseStack, d4, d7, d8, d5, d7, d8, d5, d7, d9, d4, d7, d9, i, fMax2);
        }
        if (fMax3 > 0.0f) {
            C0129bt.m582a(poseStack, d4, d6, d8, d5, d6, d8, d5, d7, d8, d4, d7, d8, i, fMax3);
            C0129bt.m582a(poseStack, d4, d6, d9, d5, d6, d9, d5, d7, d9, d4, d7, d9, i, fMax3);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m303a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
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
                    C0129bt.m581a(camera, poseStack, iFloor, i2, i3, vec3.x, i2, i3, 1.0f, i, i, 0.0f, fSqrt);
                    C0129bt.m581a(camera, poseStack, vec3.x, i2, i3, iFloor2, i2, i3, 1.0f, i, i, fSqrt, 0.0f);
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
                    C0129bt.m581a(camera, poseStack, i4, iFloor3, i5, i4, vec3.y, i5, 1.0f, i, i, 0.0f, fSqrt2);
                    C0129bt.m581a(camera, poseStack, i4, vec3.y, i5, i4, iFloor4, i5, 1.0f, i, i, fSqrt2, 0.0f);
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
                    C0129bt.m581a(camera, poseStack, i6, i7, iFloor5, i6, i7, vec3.z, 1.0f, i, i, 0.0f, fSqrt3);
                    C0129bt.m581a(camera, poseStack, i6, i7, vec3.z, i6, i7, iFloor6, 1.0f, i, i, fSqrt3, 0.0f);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m304a(@NotNull Player player) {
        Item item = (Item) C1308xv.f7695A.get();
        return player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m305a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && C1133uf.b.m6503j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1308xv.f7694z.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                C1133uf.b.m6518dz();
                interactionKeyMappingTriggered.setSwingHand(false);
                interactionKeyMappingTriggered.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m306b(@NotNull InputEvent.Key key) {
        LocalPlayer localPlayer;
        if (key.getKey() == 261 && key.getAction() == 1 && C1133uf.b.m6503j() != null && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1308xv.f7694z.get();
            if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
                C1133uf.b.m6517dy();
            }
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m307a(@NotNull InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        LocalPlayer localPlayer;
        if (C1133uf.b.m6503j() == null || (localPlayer = Minecraft.getInstance().player) == null || !localPlayer.isCreative()) {
            return;
        }
        Item item = (Item) C1308xv.f7694z.get();
        if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
            C1133uf.b.m6516b(mouseScrollingEvent.getScrollDeltaY() * 1.0d);
            mouseScrollingEvent.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m308a(@NotNull InputEvent.MouseButton.Pre pre) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        if (pre.getButton() == 2 && pre.getAction() == 1 && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null && localPlayer.isCreative()) {
            Item item = (Item) C1308xv.f7694z.get();
            if ((localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) && C1133uf.b.m6503j() != null) {
                C1133uf.b.m6509dw();
                pre.setCanceled(true);
                return;
            }
            Item item2 = (Item) C1308xv.f7695A.get();
            if (localPlayer.getMainHandItem().getItem() == item2 || localPlayer.getOffhandItem().getItem() == item2) {
                C1131ud.b.m6485J(minecraft);
                pre.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m309a(@NotNull RenderGuiEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !localPlayer.isCreative()) {
            return;
        }
        GuiGraphics guiGraphics = post.getGuiGraphics();
        int iGuiWidth = guiGraphics.guiWidth() / 2;
        int iGuiHeight = (guiGraphics.guiHeight() / 2) + 12;
        if (C1133uf.b.m6503j() != null) {
            C1133uf.a aVarM6505a = C1133uf.b.m6505a();
            guiGraphics.drawCenteredString(minecraft.font, Component.literal("Mode: " + aVarM6505a.displayName()), iGuiWidth, iGuiHeight, aVarM6505a.displayColor());
            return;
        }
        Item item = (Item) C1308xv.f7695A.get();
        if (localPlayer.getMainHandItem().getItem() == item || localPlayer.getOffhandItem().getItem() == item) {
            C1131ud.a aVarM6484a = C1131ud.b.m6484a();
            guiGraphics.drawCenteredString(minecraft.font, Component.literal("Mode: " + aVarM6484a.displayName()), iGuiWidth, iGuiHeight, aVarM6484a.displayColor());
        }
    }
}
