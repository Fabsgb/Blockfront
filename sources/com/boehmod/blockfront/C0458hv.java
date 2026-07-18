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

/* JADX INFO: renamed from: com.boehmod.blockfront.hv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hv.class */
public class C0458hv implements InterfaceC0455hs {

    /* JADX INFO: renamed from: jk */
    private static final int f2863jk = 4;

    @Override // com.boehmod.blockfront.InterfaceC0455hs
    /* JADX INFO: renamed from: a */
    public void mo2068a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            C1284xg c1284xgMo2529a = c0622l.mo2529a();
            int gameTime = (int) clientLevel.getGameTime();
            int id = minecraft.player.getId();
            for (int i = 0; i < 4; i++) {
                float f2 = 0.5f - (i * 0.1f);
                for (C0523jG c0523jG : c1284xgMo2529a.m7815a(gameTime - (i * 4))) {
                    if (c0523jG.m2299al() != id) {
                        boolean zM2305af = c0523jG.m2305af();
                        m2069a(camera, poseStack, c0523jG.m2301g(), zM2305af ? 16776960 : 16711680, f2);
                        AABB aabbM2295e = c0523jG.m2295e();
                        if (aabbM2295e != null) {
                            m2069a(camera, poseStack, aabbM2295e, zM2305af ? 65280 : 16711680, f2);
                        }
                        AABB aabbM2296f = c0523jG.m2296f();
                        if (aabbM2296f != null) {
                            m2069a(camera, poseStack, aabbM2296f, zM2305af ? 255 : 16711680, f2);
                        }
                    }
                }
            }
            for (C0022T c0022t : C0049aT.f305j) {
                m2069a(camera, poseStack, c0022t.m141b(), c0022t.getColor(), c0022t.m140b());
            }
            Iterator<Entity> it = iterable.iterator();
            while (it.hasNext()) {
                C0777nw c0777nw = (Entity) it.next();
                if (c0777nw instanceof C0777nw) {
                    C0777nw c0777nw2 = c0777nw;
                    if (c0777nw2.m3462aO()) {
                        m2069a(camera, poseStack, c0777nw2.m3463h(), 65535, 0.5f);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2069a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull AABB aabb, int i, float f) {
        double d = aabb.minX;
        double d2 = aabb.minY;
        double d3 = aabb.minZ;
        double d4 = aabb.maxX;
        double d5 = aabb.maxY;
        double d6 = aabb.maxZ;
        int i2 = (((int) (f * 255.0f)) << 24) | (i & ColorReferences.COLOR_WHITE);
        C0119bk.m476a(camera, poseStack, d, d2, d3, d4, d2, d3, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d4, d2, d3, d4, d5, d3, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d4, d5, d3, d, d5, d3, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d, d5, d3, d, d2, d3, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d, d2, d6, d4, d2, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d4, d2, d6, d4, d5, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d4, d5, d6, d, d5, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d, d5, d6, d, d2, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d, d2, d3, d, d2, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d4, d2, d3, d4, d2, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d4, d5, d3, d4, d5, d6, 2.0f, i2, f);
        C0119bk.m476a(camera, poseStack, d, d5, d3, d, d5, d6, 2.0f, i2, f);
    }
}
