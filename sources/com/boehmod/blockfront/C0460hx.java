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

/* JADX INFO: renamed from: com.boehmod.blockfront.hx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hx.class */
public final class C0460hx implements InterfaceC0455hs {

    /* JADX INFO: renamed from: fS */
    private static final float f2867fS = 0.75f;

    @Override // com.boehmod.blockfront.InterfaceC0455hs
    /* JADX INFO: renamed from: a */
    public void mo2068a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        Iterator<Entity> it = iterable.iterator();
        while (it.hasNext()) {
            AbstractClientPlayer abstractClientPlayer = (Entity) it.next();
            if (abstractClientPlayer instanceof AbstractClientPlayer) {
                m2070a(c0326fV, poseStack, guiGraphics, camera, abstractClientPlayer, f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2070a(@NotNull C0326fV c0326fV, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Camera camera, AbstractClientPlayer abstractClientPlayer, float f) {
        C0324fT c0324fT = (C0324fT) c0326fV.m1133a((Player) abstractClientPlayer);
        float yRot = (abstractClientPlayer.getYRot() + 15.0f) * 0.017453292f;
        float f2 = -Mth.sin(yRot);
        float f3 = -Mth.sin(abstractClientPlayer.getXRot() * 0.017453292f);
        float fCos = Mth.cos(yRot);
        Vec3 eyePosition = abstractClientPlayer.getEyePosition(f);
        float fDistanceToSqr = (float) abstractClientPlayer.distanceToSqr(eyePosition.x + ((double) f2), eyePosition.y + ((double) f3), eyePosition.z + ((double) fCos));
        float fM7843e = C1290xm.m7843e(c0324fT.f1494ok, c0324fT.f1495ol, f);
        if (fM7843e <= 0.0f) {
            return;
        }
        double d = eyePosition.x + ((double) (f2 * 0.75f));
        double d2 = eyePosition.y + 0.10000000149011612d + ((double) (f3 * 0.75f));
        double d3 = eyePosition.z + ((double) (fCos * 0.75f));
        int i = (int) (32.0f * fDistanceToSqr);
        C0119bk.m510a(poseStack, camera, guiGraphics, C0080ay.f489r, d, d2, d3, i, i, fM7843e, false);
    }
}
