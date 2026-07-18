package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aC.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0032aC {

    /* JADX INFO: renamed from: Z */
    static final /* synthetic */ boolean f262Z;

    static {
        f262Z = !C0032aC.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m176a(@NotNull RenderNameTagEvent renderNameTagEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        Player player = minecraft.player;
        if (clientLevel == null || player == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f262Z && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a == null) {
            return;
        }
        if (!C0424hN.f2759M.m1996T()) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a == null) {
            return;
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        AbstractC0790oI<?> abstractC0790oIM3582b = abstractC0787oFM2688a.m3582b();
        Player cameraEntity = minecraft.getCameraEntity();
        Player player2 = cameraEntity instanceof Player ? cameraEntity : player;
        C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(player2.getUUID());
        if (c0796oOM3793a == null) {
            return;
        }
        LivingEntity entity = renderNameTagEvent.getEntity();
        PoseStack poseStack = renderNameTagEvent.getPoseStack();
        GuiGraphics guiGraphics = C0078aw.f473a;
        if (guiGraphics == null) {
            return;
        }
        int color = c0796oOM3793a.getColor();
        if (entity instanceof C0099bQ) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        if ((entity instanceof LivingEntity) && !m177a(renderNameTagEvent, minecraft, clientLevel, player2, entity, abstractC0788oGM2692a)) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        AbstractC0366gI<?> abstractC0366gIM1755a = AbstractC0366gI.m1755a(entity.getType());
        if (abstractC0366gIM1755a == null) {
            return;
        }
        if (abstractC0366gIM1755a.mo1754a(renderNameTagEvent, minecraft, c0326fV, player, entity, abstractC0787oFM2688a, abstractC0788oGM2692a, c0796oOM3793a)) {
            float fM366g = C0119bk.m366g();
            guiGraphics.pose().pushPose();
            guiGraphics.pose().mulPose(poseStack.last().pose());
            abstractC0366gIM1755a.mo1758a(c0622lM2667b, renderNameTagEvent, minecraft, c0326fV, entity, guiGraphics, abstractC0787oFM2688a, abstractC0788oGM2692a, abstractC0790oIM3582b, c0796oOM3793a, color, fM366g, renderNameTagEvent.getPartialTick());
            guiGraphics.pose().popPose();
            return;
        }
        renderNameTagEvent.setCanRender(TriState.FALSE);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m177a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull Player player, @NotNull LivingEntity livingEntity, @NotNull AbstractC0788oG<? extends AbstractC0787oF<?, ?, ?>, ?> abstractC0788oG) {
        if (!abstractC0788oG.mo3718a(minecraft, livingEntity, player, clientLevel)) {
            return false;
        }
        abstractC0788oG.mo3731a(minecraft, renderNameTagEvent, player, clientLevel);
        return true;
    }
}
