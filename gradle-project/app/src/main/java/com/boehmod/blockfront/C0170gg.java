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

/* JADX INFO: renamed from: com.boehmod.blockfront.gg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gg.class */
public final class C0170gg {
    private static final int iR = 128;
    private static final int iS = 32;
    private static final float fn = 16384.0f;

    @NotNull
    private static final Map<C0172gi, a[]> f = new IdentityHashMap();

    private C0170gg() {
    }

    public static void a(@NotNull C0172gi c0172gi, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f2, double d, double d2, double d3, float f3) {
        if (f3 <= 0.0f || clientLevel.effects().renderClouds(clientLevel, i, f2, poseStack, d, d2, d3, matrix4f, matrix4f2)) {
            return;
        }
        float cloudHeight = clientLevel.effects().getCloudHeight();
        if (Float.isNaN(cloudHeight)) {
            return;
        }
        List<C0171gh> listK = c0172gi.k();
        if (listK.isEmpty()) {
            return;
        }
        a[] aVarArrA = a(c0172gi, listK.size());
        FogRenderer.levelFogColor();
        boolean z = f3 < 1.0f;
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, f3);
        }
        Matrix4f matrix4fA = a(matrix4f2);
        for (int i2 = 0; i2 < listK.size(); i2++) {
            a(minecraft, clientLevel, i, poseStack, matrix4f, matrix4fA, f2, d, d2, d3, cloudHeight, listK.get(i2), aVarArrA[i2]);
        }
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    public static void aL() {
        Runnable runnable = () -> {
            for (a[] aVarArr : f.values()) {
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        aVar.aG();
                    }
                }
            }
            f.clear();
        };
        if (RenderSystem.isOnRenderThread()) {
            runnable.run();
        } else {
            Objects.requireNonNull(runnable);
            RenderSystem.recordRenderCall(runnable::run);
        }
    }

    @NotNull
    private static a[] a(@NotNull C0172gi c0172gi, int i) {
        a[] aVarArr = f.get(c0172gi);
        if (aVarArr == null || aVarArr.length != i) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    if (aVar != null) {
                        aVar.aG();
                    }
                }
            }
            aVarArr = new a[i];
            f.put(c0172gi, aVarArr);
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (aVarArr[i2] == null) {
                aVarArr[i2] = new a();
            }
        }
        return aVarArr;
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f2, double d, double d2, double d3, float f3, @NotNull C0171gh c0171gh, @NotNull a aVar) {
        double dM439f = 12.0d * ((double) c0171gh.m439f());
        double dC = (d + ((double) (((i + f2) * 0.03f) * c0171gh.C()))) / dM439f;
        double dB = ((f3 + c0171gh.B()) - ((float) d2)) + 0.33f;
        double d4 = (d3 / dM439f) + 0.33000001311302185d;
        double dFloor = dC - ((double) (Mth.floor(dC / 2048.0d) * InterfaceC0638xq.tS));
        double dFloor2 = d4 - ((double) (Mth.floor(d4 / 2048.0d) * InterfaceC0638xq.tS));
        float fFloor = (float) (dFloor - ((double) Mth.floor(dFloor)));
        float fFloor2 = ((float) ((dB / 4.0d) - ((double) Mth.floor(dB / 4.0d)))) * 4.0f;
        float fFloor3 = (float) (dFloor2 - ((double) Mth.floor(dFloor2)));
        Vec3 cloudColor = clientLevel.getCloudColor(f2);
        int iFloor = (int) Math.floor(dFloor);
        int iFloor2 = (int) Math.floor(dB / 4.0d);
        int iFloor3 = (int) Math.floor(dFloor2);
        if (iFloor != aVar.iT || iFloor2 != aVar.iU || iFloor3 != aVar.iV || aVar.q.distanceToSqr(cloudColor) > 2.0E-4d) {
            aVar.iT = iFloor;
            aVar.iU = iFloor2;
            aVar.iV = iFloor3;
            aVar.q = cloudColor;
            aVar.cm = true;
        }
        if (aVar.cm) {
            aVar.cm = false;
            if (aVar.b != null) {
                aVar.b.close();
            }
            aVar.b = new VertexBuffer(VertexBuffer.Usage.STATIC);
            aVar.b.bind();
            aVar.b.upload(a(Tesselator.getInstance(), dFloor, dB, dFloor2, cloudColor, c0171gh));
            VertexBuffer.unbind();
        }
        if (aVar.b == null) {
            return;
        }
        poseStack.pushPose();
        poseStack.mulPose(matrix4f);
        poseStack.scale((float) dM439f, 1.0f, (float) dM439f);
        poseStack.translate(-fFloor, fFloor2, -fFloor3);
        aVar.b.bind();
        RenderType renderTypeClouds = RenderType.clouds();
        renderTypeClouds.setupRenderState();
        RenderSystem.setShaderTexture(0, minecraft.getTextureManager().getTexture(c0171gh.f()).getId());
        RenderSystem.depthMask(false);
        aVar.b.drawWithShader(poseStack.last().pose(), matrix4f2, RenderSystem.getShader());
        renderTypeClouds.clearRenderState();
        VertexBuffer.unbind();
        poseStack.popPose();
    }

    private static MeshData a(@NotNull Tesselator tesselator, double d, double d2, double d3, @NotNull Vec3 vec3, @NotNull C0171gh c0171gh) {
        float fFloor = Mth.floor(d) * 0.00390625f;
        float fFloor2 = Mth.floor(d3) * 0.00390625f;
        float fQ = ((float) vec3.x) * (((c0171gh.q() >> 16) & 255) / 255.0f);
        float fQ2 = ((float) vec3.y) * (((c0171gh.q() >> 8) & 255) / 255.0f);
        float fQ3 = ((float) vec3.z) * ((c0171gh.q() & 255) / 255.0f);
        float fD = 0.8f * c0171gh.D();
        BufferBuilder bufferBuilderBegin = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR_NORMAL);
        float fFloor3 = ((float) Math.floor(d2 / 4.0d)) * 4.0f;
        for (int i = -128; i < 128; i += 32) {
            for (int i2 = -128; i2 < 128; i2 += 32) {
                float f2 = i + 32;
                float f3 = i2 + 32;
                bufferBuilderBegin.addVertex(i, fFloor3, f3).setUv((i * 0.00390625f) + fFloor, (f3 * 0.00390625f) + fFloor2).setColor(fQ, fQ2, fQ3, fD).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(f2, fFloor3, f3).setUv((f2 * 0.00390625f) + fFloor, (f3 * 0.00390625f) + fFloor2).setColor(fQ, fQ2, fQ3, fD).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(f2, fFloor3, i2).setUv((f2 * 0.00390625f) + fFloor, (i2 * 0.00390625f) + fFloor2).setColor(fQ, fQ2, fQ3, fD).setNormal(0.0f, -1.0f, 0.0f);
                bufferBuilderBegin.addVertex(i, fFloor3, i2).setUv((i * 0.00390625f) + fFloor, (i2 * 0.00390625f) + fFloor2).setColor(fQ, fQ2, fQ3, fD).setNormal(0.0f, -1.0f, 0.0f);
            }
        }
        return bufferBuilderBegin.buildOrThrow();
    }

    @NotNull
    private static Matrix4f a(@NotNull Matrix4f matrix4f) {
        float fM32 = matrix4f.m32() / (matrix4f.m22() - 1.0f);
        Matrix4f matrix4f2 = new Matrix4f(matrix4f);
        matrix4f2.m22((-(fn + fM32)) / (fn - fM32));
        matrix4f2.m32(((-32768.0f) * fM32) / (fn - fM32));
        return matrix4f2;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.gg$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gg$a.class */
    private static final class a {
        VertexBuffer b;
        int iT = Integer.MIN_VALUE;
        int iU = Integer.MIN_VALUE;
        int iV = Integer.MIN_VALUE;
        Vec3 q = Vec3.ZERO;
        boolean cm = true;

        private a() {
        }

        void aG() {
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        }
    }
}
