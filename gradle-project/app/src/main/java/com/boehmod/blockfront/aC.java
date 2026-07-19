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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aC.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aC {
    static final /* synthetic */ boolean Z;

    static {
        Z = !aC.class.desiredAssertionStatus();
    }

    @SubscribeEvent
    public static void a(@NotNull RenderNameTagEvent renderNameTagEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel clientLevel = minecraft.level;
        Player player = minecraft.player;
        if (clientLevel == null || player == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (!Z && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a == null) {
            return;
        }
        if (!hN.M.T()) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a == null) {
            return;
        }
        fV fVVar = (fV) c0297lB.a();
        oI<?> oIVarB = oFVarM591a.b();
        Player cameraEntity = minecraft.getCameraEntity();
        Player player2 = cameraEntity instanceof Player ? cameraEntity : player;
        oO oOVarA = oIVarB.a(player2.getUUID());
        if (oOVarA == null) {
            return;
        }
        LivingEntity entity = renderNameTagEvent.getEntity();
        PoseStack poseStack = renderNameTagEvent.getPoseStack();
        GuiGraphics guiGraphics = C0025aw.a;
        if (guiGraphics == null) {
            return;
        }
        int color = oOVarA.getColor();
        if (entity instanceof bQ) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        if ((entity instanceof LivingEntity) && !a(renderNameTagEvent, minecraft, clientLevel, player2, entity, oGVarM593a)) {
            renderNameTagEvent.setCanRender(TriState.FALSE);
            return;
        }
        gI<?> gIVarA = gI.a(entity.getType());
        if (gIVarA == null) {
            return;
        }
        if (gIVarA.a(renderNameTagEvent, minecraft, fVVar, player, entity, oFVarM591a, oGVarM593a, oOVarA)) {
            float fG = C0040bk.g();
            guiGraphics.pose().pushPose();
            guiGraphics.pose().mulPose(poseStack.last().pose());
            gIVarA.a(c0297lB, renderNameTagEvent, minecraft, fVVar, entity, guiGraphics, oFVarM591a, oGVarM593a, oIVarB, oOVarA, color, fG, renderNameTagEvent.getPartialTick());
            guiGraphics.pose().popPose();
            return;
        }
        renderNameTagEvent.setCanRender(TriState.FALSE);
    }

    private static boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull Player player, @NotNull LivingEntity livingEntity, @NotNull oG<? extends oF<?, ?, ?>, ?> oGVar) {
        if (!oGVar.a(minecraft, livingEntity, player, clientLevel)) {
            return false;
        }
        oGVar.a(minecraft, renderNameTagEvent, player, clientLevel);
        return true;
    }
}
