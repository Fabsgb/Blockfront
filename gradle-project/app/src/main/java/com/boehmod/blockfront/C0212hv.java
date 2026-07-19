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

/* JADX INFO: renamed from: com.boehmod.blockfront.hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hv.class */
public class C0212hv implements InterfaceC0209hs {
    private static final int jk = 4;

    @Override // com.boehmod.blockfront.InterfaceC0209hs
    public void a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            C0628xg c0628xgMo532a = c0297l.mo532a();
            int gameTime = (int) clientLevel.getGameTime();
            int id = minecraft.player.getId();
            for (int i = 0; i < 4; i++) {
                float f2 = 0.5f - (i * 0.1f);
                for (jG jGVar : c0628xgMo532a.a(gameTime - (i * 4))) {
                    if (jGVar.al() != id) {
                        boolean zAf = jGVar.af();
                        a(camera, poseStack, jGVar.m513g(), zAf ? 16776960 : 16711680, f2);
                        AABB aabbE = jGVar.e();
                        if (aabbE != null) {
                            a(camera, poseStack, aabbE, zAf ? 65280 : 16711680, f2);
                        }
                        AABB aabbF = jGVar.f();
                        if (aabbF != null) {
                            a(camera, poseStack, aabbF, zAf ? 255 : 16711680, f2);
                        }
                    }
                }
            }
            for (T t : aT.j) {
                a(camera, poseStack, t.m161b(), t.getColor(), t.b());
            }
            Iterator<Entity> it = iterable.iterator();
            while (it.hasNext()) {
                C0374nw c0374nw = (Entity) it.next();
                if (c0374nw instanceof C0374nw) {
                    C0374nw c0374nw2 = c0374nw;
                    if (c0374nw2.aO()) {
                        a(camera, poseStack, c0374nw2.h(), 65535, 0.5f);
                    }
                }
            }
        }
    }

    private void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull AABB aabb, int i, float f) {
        double d = aabb.minX;
        double d2 = aabb.minY;
        double d3 = aabb.minZ;
        double d4 = aabb.maxX;
        double d5 = aabb.maxY;
        double d6 = aabb.maxZ;
        int i2 = (((int) (f * 255.0f)) << 24) | (i & ColorReferences.COLOR_WHITE);
        C0040bk.a(camera, poseStack, d, d2, d3, d4, d2, d3, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d4, d2, d3, d4, d5, d3, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d4, d5, d3, d, d5, d3, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d, d5, d3, d, d2, d3, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d, d2, d6, d4, d2, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d4, d2, d6, d4, d5, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d4, d5, d6, d, d5, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d, d5, d6, d, d2, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d, d2, d3, d, d2, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d4, d2, d3, d4, d2, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d4, d5, d3, d4, d5, d6, 2.0f, i2, f);
        C0040bk.a(camera, poseStack, d, d5, d3, d, d5, d6, 2.0f, i2, f);
    }
}
