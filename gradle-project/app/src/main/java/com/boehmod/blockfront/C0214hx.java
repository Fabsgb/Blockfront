package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hx.class */
public final class C0214hx implements InterfaceC0209hs {
    private static final float fS = 0.75f;

    @Override // com.boehmod.blockfront.InterfaceC0209hs
    public void a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        Iterator<Entity> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractClientPlayer abstractClientPlayer = (Entity) it.next();
            if (abstractClientPlayer instanceof AbstractClientPlayer) {
                a(fVVar, poseStack, guiGraphics, camera, abstractClientPlayer, f);
            }
        }
    }

    private static void a(@NotNull fV fVVar, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Camera camera, AbstractClientPlayer abstractClientPlayer, float f) {
        fT fTVar = (fT) fVVar.a((Player) abstractClientPlayer);
        float yRot = (abstractClientPlayer.getYRot() + 15.0f) * 0.017453292f;
        float f2 = -Mth.sin(yRot);
        float f3 = -Mth.sin(abstractClientPlayer.getXRot() * 0.017453292f);
        float fCos = Mth.cos(yRot);
        Vec3 eyePosition = abstractClientPlayer.getEyePosition(f);
        float fDistanceToSqr = (float) abstractClientPlayer.distanceToSqr(eyePosition.x + ((double) f2), eyePosition.y + ((double) f3), eyePosition.z + ((double) fCos));
        float fE = C0634xm.e(fTVar.ok, fTVar.ol, f);
        if (fE <= 0.0f) {
            return;
        }
        double d = eyePosition.x + ((double) (f2 * 0.75f));
        double d2 = eyePosition.y + 0.10000000149011612d + ((double) (f3 * 0.75f));
        double d3 = eyePosition.z + ((double) (fCos * 0.75f));
        int i = (int) (32.0f * fDistanceToSqr);
        C0040bk.a(poseStack, camera, guiGraphics, C0027ay.r, d, d2, d3, i, i, fE, false);
    }
}
