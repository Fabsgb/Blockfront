package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hL.class */
public class C0423hL implements InterfaceC0420hI {

    /* JADX INFO: renamed from: kF */
    private static final int f2693kF = 4;

    @Override // com.boehmod.blockfront.InterfaceC0420hI
    /* JADX INFO: renamed from: a */
    public void mo1970a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            C1264xD c1264xDMo2352a = c0623l.mo2352a();
            int gameTime = (int) clientLevel.getGameTime();
            int id = minecraft.player.getId();
            for (int i = 0; i < 4; i++) {
                float f2 = 0.5f - (i * 0.1f);
                for (C0543jZ c0543jZ : c1264xDMo2352a.m7138a(gameTime - (i * 4))) {
                    if (c0543jZ.m2445aB() != id) {
                        boolean zM2451aj = c0543jZ.m2451aj();
                        m1971a(camera, poseStack, c0543jZ.m2447g(), zM2451aj ? 16776960 : 16711680, f2);
                        AABB aabbM2441e = c0543jZ.m2441e();
                        if (aabbM2441e != null) {
                            m1971a(camera, poseStack, aabbM2441e, zM2451aj ? 65280 : 16711680, f2);
                        }
                        AABB aabbM2442f = c0543jZ.m2442f();
                        if (aabbM2442f != null) {
                            m1971a(camera, poseStack, aabbM2442f, zM2451aj ? 255 : 16711680, f2);
                        }
                    }
                }
            }
            for (C0029Z c0029z : C0111bb.f719k) {
                m1971a(camera, poseStack, c0029z.m174b(), c0029z.getColor(), c0029z.m173b());
            }
            Iterator<Entity> it = iterable.iterator();
            while (it.hasNext()) {
                C0748nS c0748nS = (Entity) it.next();
                if (c0748nS instanceof C0748nS) {
                    C0748nS c0748nS2 = c0748nS;
                    if (c0748nS2.mo3393aY()) {
                        m1971a(camera, poseStack, c0748nS2.m3386h(), 65535, 0.5f);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1971a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull AABB aabb, int i, float f) {
        double d = aabb.minX;
        double d2 = aabb.minY;
        double d3 = aabb.minZ;
        double d4 = aabb.maxX;
        double d5 = aabb.maxY;
        double d6 = aabb.maxZ;
        int i2 = (((int) (f * 255.0f)) << 24) | (i & ColorReferences.COLOR_WHITE);
        C0129bt.m576a(camera, poseStack, d, d2, d3, d4, d2, d3, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d4, d2, d3, d4, d5, d3, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d4, d5, d3, d, d5, d3, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d, d5, d3, d, d2, d3, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d, d2, d6, d4, d2, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d4, d2, d6, d4, d5, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d4, d5, d6, d, d5, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d, d5, d6, d, d2, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d, d2, d3, d, d2, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d4, d2, d3, d4, d2, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d4, d5, d3, d4, d5, d6, 2.0f, i2, f);
        C0129bt.m576a(camera, poseStack, d, d5, d3, d, d5, d6, 2.0f, i2, f);
    }
}
