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

/* JADX INFO: renamed from: com.boehmod.blockfront.hN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hN.class */
public final class C0425hN implements InterfaceC0420hI {

    /* JADX INFO: renamed from: gc */
    private static final float f2697gc = 0.75f;

    @Override // com.boehmod.blockfront.InterfaceC0420hI
    /* JADX INFO: renamed from: a */
    public void mo1970a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        Iterator<Entity> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractClientPlayer abstractClientPlayer = (Entity) it.next();
            if (abstractClientPlayer instanceof AbstractClientPlayer) {
                m1972a(c0396gl, poseStack, guiGraphics, camera, abstractClientPlayer, f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1972a(@NotNull C0396gl c0396gl, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Camera camera, AbstractClientPlayer abstractClientPlayer, float f) {
        C0394gj c0394gj = (C0394gj) c0396gl.m1150a((Player) abstractClientPlayer);
        float yRot = (abstractClientPlayer.getYRot() + 15.0f) * 0.017453292f;
        float f2 = -Mth.sin(yRot);
        float f3 = -Mth.sin(abstractClientPlayer.getXRot() * 0.017453292f);
        float fCos = Mth.cos(yRot);
        Vec3 eyePosition = abstractClientPlayer.getEyePosition(f);
        float fDistanceToSqr = (float) abstractClientPlayer.distanceToSqr(eyePosition.x + ((double) f2), eyePosition.y + ((double) f3), eyePosition.z + ((double) fCos));
        float fM7170f = C1270xJ.m7170f(c0394gj.f1416pi, c0394gj.f1417pj, f);
        if (fM7170f <= 0.0f) {
            return;
        }
        double d = eyePosition.x + ((double) (f2 * 0.75f));
        double d2 = eyePosition.y + 0.10000000149011612d + ((double) (f3 * 0.75f));
        double d3 = eyePosition.z + ((double) (fCos * 0.75f));
        int i = (int) (32.0f * fDistanceToSqr);
        C0129bt.m610a(poseStack, camera, guiGraphics, C0036aF.f311r, d, d2, d3, i, i, fM7170f, false);
    }
}
