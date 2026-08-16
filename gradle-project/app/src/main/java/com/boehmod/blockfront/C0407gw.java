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

/* JADX INFO: renamed from: com.boehmod.blockfront.gw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gw.class */
public final class C0407gw {

    /* JADX INFO: renamed from: km */
    private static final int f2638km = 128;

    /* JADX INFO: renamed from: kn */
    private static final int f2639kn = 32;

    /* JADX INFO: renamed from: fx */
    private static final float f2640fx = 16384.0f;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final Map<C0409gy, a[]> f2641f = new IdentityHashMap();

    private C0407gw() {
    }

    /* JADX INFO: renamed from: a */
    public static void m1936a(@NotNull C0409gy c0409gy, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3, float f2) {
        if (f2 <= 0.0f || clientLevel.effects().renderClouds(clientLevel, i, f, poseStack, d, d2, d3, matrix4f, matrix4f2)) {
            return;
        }
        float cloudHeight = clientLevel.effects().getCloudHeight();
        if (Float.isNaN(cloudHeight)) {
            return;
        }
        List<C0408gx> listM1951m = c0409gy.m1951m();
        if (listM1951m.isEmpty()) {
            return;
        }
        a[] aVarArrM1938a = m1938a(c0409gy, listM1951m.size());
        FogRenderer.levelFogColor();
        boolean z = f2 < 1.0f;
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, f2);
        }
        Matrix4f matrix4fM1941a = m1941a(matrix4f2);
        for (int i2 = 0; i2 < listM1951m.size(); i2++) {
            m1939a(minecraft, clientLevel, i, poseStack, matrix4f, matrix4fM1941a, f, d, d2, d3, cloudHeight, listM1951m.get(i2), aVarArrM1938a[i2]);
        }
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    /* JADX INFO: renamed from: aR */
    public static void m1937aR() {
        Runnable runnable = () -> {
            for (a[] aVarArr : f2641f.values()) {
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        aVar.m1943aM();
                    }
                }
            }
            f2641f.clear();
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
    private static a[] m1938a(@NotNull C0409gy c0409gy, int i) {
        a[] aVarArr = f2641f.get(c0409gy);
        if (aVarArr == null || aVarArr.length != i) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        aVar.m1943aM();
                    }
                }
            }
            aVarArr = new a[i];
            f2641f.put(c0409gy, aVarArr);
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (aVarArr[i2] == null) {
                aVarArr[i2] = new a();
            }
        }
        return aVarArr;
    }

    /* JADX INFO: renamed from: a */
    private static void m1939a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3, float f2, @NotNull C0408gx c0408gx, @NotNull a aVar) {
        double dM1947f = 12.0d * ((double) c0408gx.m1947f());
        double dM1946C = (d + ((double) (((i + f) * 0.03f) * c0408gx.m1946C()))) / dM1947f;
        double dM1945B = ((f2 + c0408gx.m1945B()) - ((float) d2)) + 0.33f;
        double d4 = (d3 / dM1947f) + 0.33000001311302185d;
        double dFloor = dM1946C - ((double) (Mth.floor(dM1946C / 2048.0d) * InterfaceC1274xN.f6854vW));
        double dFloor2 = d4 - ((double) (Mth.floor(d4 / 2048.0d) * InterfaceC1274xN.f6854vW));
        float fFloor = (float) (dFloor - ((double) Mth.floor(dFloor)));
        float fFloor2 = ((float) ((dM1945B / 4.0d) - ((double) Mth.floor(dM1945B / 4.0d)))) * 4.0f;
        float fFloor3 = (float) (dFloor2 - ((double) Mth.floor(dFloor2)));
        Vec3 cloudColor = clientLevel.getCloudColor(f);
        int iFloor = (int) Math.floor(dFloor);
        int iFloor2 = (int) Math.floor(dM1945B / 4.0d);
        int iFloor3 = (int) Math.floor(dFloor2);
        if (iFloor != aVar.f2643ko || iFloor2 != aVar.f2644kp || iFloor3 != aVar.f2645kq || aVar.f2646q.distanceToSqr(cloudColor) > 2.0E-4d) {
            aVar.f2643ko = iFloor;
            aVar.f2644kp = iFloor2;
            aVar.f2645kq = iFloor3;
            aVar.f2646q = cloudColor;
            aVar.f2647cv = true;
        }
        if (aVar.f2647cv) {
            aVar.f2647cv = false;
            if (aVar.f2642b != null) {
                aVar.f2642b.close();
            }
            aVar.f2642b = new VertexBuffer(VertexBuffer.Usage.STATIC);
            aVar.f2642b.bind();
            aVar.f2642b.upload(m1940a(Tesselator.getInstance(), dFloor, dM1945B, dFloor2, cloudColor, c0408gx));
            VertexBuffer.unbind();
        }
        if (aVar.f2642b == null) {
            return;
        }
        poseStack.pushPose();
        poseStack.mulPose(matrix4f);
        poseStack.scale((float) dM1947f, 1.0f, (float) dM1947f);
        poseStack.translate(-fFloor, fFloor2, -fFloor3);
        aVar.f2642b.bind();
        RenderType renderTypeClouds = RenderType.clouds();
        renderTypeClouds.setupRenderState();
        RenderSystem.setShaderTexture(0, minecraft.getTextureManager().getTexture(c0408gx.m1944f()).getId());
        RenderSystem.depthMask(false);
        aVar.f2642b.drawWithShader(poseStack.last().pose(), matrix4f2, RenderSystem.getShader());
        renderTypeClouds.clearRenderState();
        VertexBuffer.unbind();
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private static MeshData m1940a(@NotNull Tesselator tesselator, double d, double d2, double d3, @NotNull Vec3 vec3, @NotNull C0408gx c0408gx) {
        float fFloor = Mth.floor(d) * 0.00390625f;
        float fFloor2 = Mth.floor(d3) * 0.00390625f;
        float fM1948u = ((c0408gx.m1948u() >> 16) & 255) / 255.0f;
        float fM1948u2 = ((c0408gx.m1948u() >> 8) & 255) / 255.0f;
        float fM1948u3 = (c0408gx.m1948u() & 255) / 255.0f;
        float f = ((float) vec3.x) * fM1948u;
        float f2 = ((float) vec3.y) * fM1948u2;
        float f3 = ((float) vec3.z) * fM1948u3;
        float fM1949D = 0.8f * c0408gx.m1949D();
        BufferBuilder bufferBuilderBegin = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR_NORMAL);
        float fFloor3 = ((float) Math.floor(d2 / 4.0d)) * 4.0f;
        for (int i = -128; i < 128; i += 32) {
            for (int i2 = -128; i2 < 128; i2 += 32) {
                float f4 = i + 32;
                float f5 = i2 + 32;
                bufferBuilderBegin.addVertex(i, fFloor3, f5).setUv((i * 0.00390625f) + fFloor, (f5 * 0.00390625f) + fFloor2).setColor(f, f2, f3, fM1949D).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(f4, fFloor3, f5).setUv((f4 * 0.00390625f) + fFloor, (f5 * 0.00390625f) + fFloor2).setColor(f, f2, f3, fM1949D).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(f4, fFloor3, i2).setUv((f4 * 0.00390625f) + fFloor, (i2 * 0.00390625f) + fFloor2).setColor(f, f2, f3, fM1949D).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(i, fFloor3, i2).setUv((i * 0.00390625f) + fFloor, (i2 * 0.00390625f) + fFloor2).setColor(f, f2, f3, fM1949D).setNormal(0.0f, -1.0f, 0.0f);
            }
        }
        return bufferBuilderBegin.buildOrThrow();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Matrix4f m1941a(@NotNull Matrix4f matrix4f) {
        float fM32 = matrix4f.m32() / (matrix4f.m22() - 1.0f);
        Matrix4f matrix4f2 = new Matrix4f(matrix4f);
        matrix4f2.m22((-(f2640fx + fM32)) / (f2640fx - fM32));
        matrix4f2.m32(((-32768.0f) * fM32) / (f2640fx - fM32));
        return matrix4f2;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.gw$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gw$a.class */
    private static final class a {

        /* JADX INFO: renamed from: b */
        VertexBuffer f2642b;

        /* JADX INFO: renamed from: ko */
        int f2643ko = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: kp */
        int f2644kp = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: kq */
        int f2645kq = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: q */
        Vec3 f2646q = Vec3.ZERO;

        /* JADX INFO: renamed from: cv */
        boolean f2647cv = true;

        private a() {
        }

        /* JADX INFO: renamed from: aM */
        void m1943aM() {
            if (this.f2642b != null) {
                this.f2642b.close();
                this.f2642b = null;
            }
        }
    }
}
