package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gg.class */
public final class C0390gg {

    /* JADX INFO: renamed from: iR */
    private static final int f2579iR = 128;

    /* JADX INFO: renamed from: iS */
    private static final int f2580iS = 32;

    /* JADX INFO: renamed from: fn */
    private static final float f2581fn = 16384.0f;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final Map<C0392gi, a[]> f2582f = new IdentityHashMap();

    private C0390gg() {
    }

    /* JADX INFO: renamed from: a */
    public static void m1871a(@NotNull C0392gi c0392gi, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3, float f2) {
        if (f2 <= 0.0f || clientLevel.effects().renderClouds(clientLevel, i, f, poseStack, d, d2, d3, matrix4f, matrix4f2)) {
            return;
        }
        float cloudHeight = clientLevel.effects().getCloudHeight();
        if (Float.isNaN(cloudHeight)) {
            return;
        }
        List<C0391gh> listM1886k = c0392gi.m1886k();
        if (listM1886k.isEmpty()) {
            return;
        }
        a[] aVarArrM1873a = m1873a(c0392gi, listM1886k.size());
        FogRenderer.levelFogColor();
        boolean z = f2 < 1.0f;
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, f2);
        }
        Matrix4f matrix4fM1876a = m1876a(matrix4f2);
        for (int i2 = 0; i2 < listM1886k.size(); i2++) {
            m1874a(minecraft, clientLevel, i, poseStack, matrix4f, matrix4fM1876a, f, d, d2, d3, cloudHeight, listM1886k.get(i2), aVarArrM1873a[i2]);
        }
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    /* JADX INFO: renamed from: aL */
    public static void m1872aL() {
        Runnable runnable = () -> {
            for (a[] aVarArr : f2582f.values()) {
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        aVar.m1878aG();
                    }
                }
            }
            f2582f.clear();
        };
        if (RenderSystem.isOnRenderThread()) {
            runnable.run();
        } else {
            Objects.requireNonNull(runnable);
            RenderSystem.recordRenderCall(runnable::run);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static a[] m1873a(@NotNull C0392gi c0392gi, int i) {
        a[] aVarArr = f2582f.get(c0392gi);
        if (aVarArr == null || aVarArr.length != i) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        aVar.m1878aG();
                    }
                }
            }
            aVarArr = new a[i];
            f2582f.put(c0392gi, aVarArr);
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (aVarArr[i2] == null) {
                aVarArr[i2] = new a();
            }
        }
        return aVarArr;
    }

    /* JADX INFO: renamed from: a */
    private static void m1874a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3, float f2, @NotNull C0391gh c0391gh, @NotNull a aVar) {
        double dM1882f = 12.0d * ((double) c0391gh.m1882f());
        double dM1881C = (d + ((double) (((i + f) * 0.03f) * c0391gh.m1881C()))) / dM1882f;
        double dM1880B = ((f2 + c0391gh.m1880B()) - ((float) d2)) + 0.33f;
        double d4 = (d3 / dM1882f) + 0.33000001311302185d;
        double dFloor = dM1881C - ((double) (Mth.floor(dM1881C / 2048.0d) * InterfaceC1294xq.f8657tS));
        double dFloor2 = d4 - ((double) (Mth.floor(d4 / 2048.0d) * InterfaceC1294xq.f8657tS));
        float fFloor = (float) (dFloor - ((double) Mth.floor(dFloor)));
        float fFloor2 = ((float) ((dM1880B / 4.0d) - ((double) Mth.floor(dM1880B / 4.0d)))) * 4.0f;
        float fFloor3 = (float) (dFloor2 - ((double) Mth.floor(dFloor2)));
        Vec3 cloudColor = clientLevel.getCloudColor(f);
        int iFloor = (int) Math.floor(dFloor);
        int iFloor2 = (int) Math.floor(dM1880B / 4.0d);
        int iFloor3 = (int) Math.floor(dFloor2);
        if (iFloor != aVar.f2584iT || iFloor2 != aVar.f2585iU || iFloor3 != aVar.f2586iV || aVar.f2587q.distanceToSqr(cloudColor) > 2.0E-4d) {
            aVar.f2584iT = iFloor;
            aVar.f2585iU = iFloor2;
            aVar.f2586iV = iFloor3;
            aVar.f2587q = cloudColor;
            aVar.f2588cm = true;
        }
        if (aVar.f2588cm) {
            aVar.f2588cm = false;
            if (aVar.f2583b != null) {
                aVar.f2583b.close();
            }
            aVar.f2583b = new VertexBuffer(VertexBuffer.Usage.STATIC);
            aVar.f2583b.bind();
            aVar.f2583b.upload(m1875a(Tesselator.getInstance(), dFloor, dM1880B, dFloor2, cloudColor, c0391gh));
            VertexBuffer.unbind();
        }
        if (aVar.f2583b == null) {
            return;
        }
        poseStack.pushPose();
        poseStack.mulPose(matrix4f);
        poseStack.scale((float) dM1882f, 1.0f, (float) dM1882f);
        poseStack.translate(-fFloor, fFloor2, -fFloor3);
        aVar.f2583b.bind();
        RenderType renderTypeClouds = RenderType.clouds();
        renderTypeClouds.setupRenderState();
        RenderSystem.setShaderTexture(0, minecraft.getTextureManager().getTexture(c0391gh.m1879f()).getId());
        RenderSystem.depthMask(false);
        aVar.f2583b.drawWithShader(poseStack.last().pose(), matrix4f2, RenderSystem.getShader());
        renderTypeClouds.clearRenderState();
        VertexBuffer.unbind();
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static MeshData m1875a(@NotNull Tesselator tesselator, double d, double d2, double d3, @NotNull Vec3 vec3, @NotNull C0391gh c0391gh) {
        float fFloor = Mth.floor(d) * 0.00390625f;
        float fFloor2 = Mth.floor(d3) * 0.00390625f;
        float fM1883q = ((float) vec3.x) * (((c0391gh.m1883q() >> 16) & 255) / 255.0f);
        float fM1883q2 = ((float) vec3.y) * (((c0391gh.m1883q() >> 8) & 255) / 255.0f);
        float fM1883q3 = ((float) vec3.z) * ((c0391gh.m1883q() & 255) / 255.0f);
        float fM1884D = 0.8f * c0391gh.m1884D();
        BufferBuilder bufferBuilderBegin = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR_NORMAL);
        float fFloor3 = ((float) Math.floor(d2 / 4.0d)) * 4.0f;
        for (int i = -128; i < 128; i += 32) {
            for (int i2 = -128; i2 < 128; i2 += 32) {
                float f = i + 32;
                float f2 = i2 + 32;
                bufferBuilderBegin.addVertex(i, fFloor3, f2).setUv((i * 0.00390625f) + fFloor, (f2 * 0.00390625f) + fFloor2).setColor(fM1883q, fM1883q2, fM1883q3, fM1884D).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(f, fFloor3, f2).setUv((f * 0.00390625f) + fFloor, (f2 * 0.00390625f) + fFloor2).setColor(fM1883q, fM1883q2, fM1883q3, fM1884D).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(f, fFloor3, i2).setUv((f * 0.00390625f) + fFloor, (i2 * 0.00390625f) + fFloor2).setColor(fM1883q, fM1883q2, fM1883q3, fM1884D).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(i, fFloor3, i2).setUv((i * 0.00390625f) + fFloor, (i2 * 0.00390625f) + fFloor2).setColor(fM1883q, fM1883q2, fM1883q3, fM1884D).setNormal(0.0f, -1.0f, 0.0f);
            }
        }
        return bufferBuilderBegin.buildOrThrow();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Matrix4f m1876a(@NotNull Matrix4f matrix4f) {
        float fM32 = matrix4f.m32() / (matrix4f.m22() - 1.0f);
        Matrix4f matrix4f2 = new Matrix4f(matrix4f);
        matrix4f2.m22((-(f2581fn + fM32)) / (f2581fn - fM32));
        matrix4f2.m32(((-32768.0f) * fM32) / (f2581fn - fM32));
        return matrix4f2;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.gg$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gg$a.class */
    private static final class a {

        /* JADX INFO: renamed from: b */
        VertexBuffer f2583b;

        /* JADX INFO: renamed from: iT */
        int f2584iT = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: iU */
        int f2585iU = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: iV */
        int f2586iV = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: q */
        Vec3 f2587q = Vec3.ZERO;

        /* JADX INFO: renamed from: cm */
        boolean f2588cm = true;

        private a() {
        }

        /* JADX INFO: renamed from: aG */
        void m1878aG() {
            if (this.f2583b != null) {
                this.f2583b.close();
                this.f2583b = null;
            }
        }
    }
}
