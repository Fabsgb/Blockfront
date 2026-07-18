package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;

/* JADX INFO: renamed from: com.boehmod.blockfront.gd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gd.class */
public final class C0387gd implements NativeResource {

    /* JADX INFO: renamed from: iP */
    private static final int f2570iP = 36;

    /* JADX INFO: renamed from: fm */
    private static final float f2571fm = 5.0E-4f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final VertexFormat f2572b = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).build();

    /* JADX INFO: renamed from: a */
    private VertexBuffer f2573a;

    /* JADX INFO: renamed from: iQ */
    private int f2574iQ;

    /* JADX INFO: renamed from: aU */
    private boolean f2575aU = false;

    /* JADX INFO: renamed from: aC */
    private void m1862aC() {
        this.f2575aU = true;
        this.f2573a = new VertexBuffer(VertexBuffer.Usage.STATIC);
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2572b);
        bufferBuilderBegin.addVertex(-1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f);
        bufferBuilderBegin.addVertex(-1.0f, 1.0f, 0.0f);
        this.f2573a.bind();
        this.f2573a.upload(bufferBuilderBegin.buildOrThrow());
        this.f2574iQ = GL15C.glGenBuffers();
        for (int i = 1; i <= 5; i++) {
            GL20C.glEnableVertexAttribArray(i);
        }
        GL15C.glBindBuffer(34962, this.f2574iQ);
        GL20C.glVertexAttribPointer(1, 3, 5126, false, f2570iP, 0L);
        GL20C.glVertexAttribPointer(2, 3, 5126, false, f2570iP, 12L);
        GL20C.glVertexAttribPointer(3, 1, 5126, false, f2570iP, 24L);
        GL20C.glVertexAttribPointer(4, 4, 5121, true, f2570iP, 28L);
        GL20C.glVertexAttribPointer(5, 4, 5121, true, f2570iP, 32L);
        for (int i2 = 1; i2 <= 5; i2++) {
            GL33C.glVertexAttribDivisor(i2, 1);
        }
        GL15C.glBindBuffer(34962, 0);
        VertexBuffer.unbind();
    }

    /* JADX INFO: renamed from: a */
    public void m1863a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull List<C0386gc> list, float f) {
        if (list.isEmpty()) {
            return;
        }
        if (!this.f2575aU) {
            m1862aC();
        }
        ShaderInstance shaderInstanceM1867a = C0388ge.m1867a();
        if (shaderInstanceM1867a == null) {
            return;
        }
        Vec3 position = camera.getPosition();
        double dX = position.x();
        double dY = position.y();
        double dZ = position.z();
        int size = list.size();
        int i = size * f2570iP;
        GL15C.glBindBuffer(34962, this.f2574iQ);
        GL15C.glBufferData(34962, i, 35040);
        ByteBuffer byteBufferGlMapBuffer = GL15C.glMapBuffer(34962, 35001);
        boolean z = byteBufferGlMapBuffer != null;
        if (!z) {
            byteBufferGlMapBuffer = MemoryUtil.memAlloc(i);
        }
        Iterator<C0386gc> it = list.iterator();
        while (it.hasNext()) {
            m1864a(it.next(), byteBufferGlMapBuffer, dX, dY, dZ, f);
        }
        if (z) {
            GL15C.glUnmapBuffer(34962);
        } else {
            byteBufferGlMapBuffer.rewind();
            GL15C.glBufferSubData(34962, 0L, byteBufferGlMapBuffer);
            MemoryUtil.memFree(byteBufferGlMapBuffer);
        }
        GL15C.glBindBuffer(34962, 0);
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.setShader(C0388ge::m1867a);
        shaderInstanceM1867a.setDefaultUniforms(VertexFormat.Mode.QUADS, RenderSystem.getModelViewStack(), RenderSystem.getProjectionMatrix(), minecraft.getWindow());
        shaderInstanceM1867a.apply();
        this.f2573a.bind();
        GL31.glDrawElementsInstanced(this.f2573a.mode.asGLMode, this.f2573a.indexCount, this.f2573a.getIndexType().asGLType, 0L, size);
        VertexBuffer.unbind();
        shaderInstanceM1867a.clear();
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
    }

    /* JADX INFO: renamed from: a */
    private void m1864a(@NotNull C0386gc c0386gc, @NotNull ByteBuffer byteBuffer, double d, double d2, double d3, float f) {
        Vec3 vec3M1856c = c0386gc.m1856c();
        Vec3 vec3M1857d = c0386gc.m1857d();
        double d4 = vec3M1856c.x - vec3M1857d.x;
        double d5 = vec3M1856c.y - vec3M1857d.y;
        double d6 = vec3M1856c.z - vec3M1857d.z;
        float f2 = (float) ((vec3M1857d.x + (d4 * ((double) f))) - d);
        float f3 = (float) ((vec3M1857d.y + (d5 * ((double) f))) - d2);
        float f4 = (float) ((vec3M1857d.z + (d6 * ((double) f))) - d3);
        float f5 = f2 + ((float) d4);
        byteBuffer.putFloat(f2);
        byteBuffer.putFloat(f3);
        byteBuffer.putFloat(f4);
        byteBuffer.putFloat(f5);
        byteBuffer.putFloat(f3 + ((float) d5));
        byteBuffer.putFloat(f4 + ((float) d6));
        byteBuffer.putFloat(c0386gc.m1859A() * f2571fm);
        int color = c0386gc.getColor();
        int i = color - ColorReferences.COLOR_BLACK_SOLID;
        int iM7833a = color;
        if (c0386gc.m1860Q()) {
            iM7833a = C1290xm.m7833a(color, 1.0f - c0386gc.m1861r());
        }
        m1865a(byteBuffer, i);
        m1865a(byteBuffer, iM7833a);
    }

    /* JADX INFO: renamed from: a */
    private static void m1865a(@NotNull ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >> 16) & 255));
        byteBuffer.put((byte) ((i >> 8) & 255));
        byteBuffer.put((byte) (i & 255));
        byteBuffer.put((byte) ((i >> 24) & 255));
    }

    /* JADX INFO: renamed from: aF */
    public void m1866aF() {
        if (this.f2573a != null) {
            this.f2573a.close();
        }
        if (this.f2574iQ != 0) {
            GL15C.glDeleteBuffers(this.f2574iQ);
        }
    }
}
