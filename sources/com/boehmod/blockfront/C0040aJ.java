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

/* JADX INFO: renamed from: com.boehmod.blockfront.aJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aJ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0040aJ {

    /* JADX INFO: renamed from: ae */
    static final /* synthetic */ boolean f362ae;

    static {
        f362ae = !C0040aJ.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m217a(@NotNull RenderNameTagEvent renderNameTagEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        Player player = minecraft.player;
        if (clientLevel == null || player == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f362ae && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a == null) {
            return;
        }
        if (!C0495ie.f3060M.m2230U()) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a == null) {
            return;
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        AbstractC0866pe<?> abstractC0866peM4018b = abstractC0863pbM2874a.m4018b();
        Player cameraEntity = minecraft.getCameraEntity();
        Player player2 = cameraEntity instanceof Player ? cameraEntity : player;
        C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(player2.getUUID());
        if (c0872pkM4229a == null) {
            return;
        }
        LivingEntity entity = renderNameTagEvent.getEntity();
        PoseStack poseStack = renderNameTagEvent.getPoseStack();
        GuiGraphics guiGraphics = C0034aD.f295a;
        if (guiGraphics == null) {
            return;
        }
        int color = c0872pkM4229a.getColor();
        if (entity instanceof C0109bZ) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        if ((entity instanceof LivingEntity) && !m218a(renderNameTagEvent, minecraft, clientLevel, player2, entity, abstractC0864pcM2878a)) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        AbstractC0383gY<?> abstractC0383gYM1822a = AbstractC0383gY.m1822a(entity.getType());
        if (abstractC0383gYM1822a == null) {
            return;
        }
        if (abstractC0383gYM1822a.mo1821a(renderNameTagEvent, minecraft, c0396gl, player, entity, abstractC0863pbM2874a, abstractC0864pcM2878a, c0872pkM4229a)) {
            float fM466g = C0129bt.m466g();
            guiGraphics.pose().pushPose();
            guiGraphics.pose().mulPose(poseStack.last().pose());
            abstractC0383gYM1822a.mo1825a(c0623lM2852b, renderNameTagEvent, minecraft, c0396gl, entity, guiGraphics, abstractC0863pbM2874a, abstractC0864pcM2878a, abstractC0866peM4018b, c0872pkM4229a, color, fM466g, renderNameTagEvent.getPartialTick());
            guiGraphics.pose().popPose();
            return;
        }
        renderNameTagEvent.setCanRender(TriState.FALSE);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m218a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull Player player, @NotNull LivingEntity livingEntity, @NotNull AbstractC0864pc<? extends AbstractC0863pb<?, ?, ?>, ?> abstractC0864pc) {
        if (!abstractC0864pc.mo4154a(minecraft, livingEntity, player, clientLevel)) {
            return false;
        }
        abstractC0864pc.mo4167a(minecraft, renderNameTagEvent, player, clientLevel);
        return true;
    }
}
