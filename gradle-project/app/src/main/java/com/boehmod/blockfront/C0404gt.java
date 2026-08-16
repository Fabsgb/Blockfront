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

/* JADX INFO: renamed from: com.boehmod.blockfront.gt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gt.class */
public final class C0404gt implements NativeResource {

    /* JADX INFO: renamed from: kk */
    private static final int f2629kk = 36;

    /* JADX INFO: renamed from: fw */
    private static final float f2630fw = 5.0E-4f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final VertexFormat f2631b = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).build();

    /* JADX INFO: renamed from: a */
    private VertexBuffer f2632a;

    /* JADX INFO: renamed from: kl */
    private int f2633kl;

    /* JADX INFO: renamed from: bK */
    private boolean f2634bK = false;

    /* JADX INFO: renamed from: aI */
    private void m1927aI() {
        this.f2634bK = true;
        this.f2632a = new VertexBuffer(VertexBuffer.Usage.STATIC);
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2631b);
        bufferBuilderBegin.addVertex(-1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f);
        bufferBuilderBegin.addVertex(-1.0f, 1.0f, 0.0f);
        this.f2632a.bind();
        this.f2632a.upload(bufferBuilderBegin.buildOrThrow());
        this.f2633kl = GL15C.glGenBuffers();
        for (int i = 1; i <= 5; i++) {
            GL20C.glEnableVertexAttribArray(i);
        }
        GL15C.glBindBuffer(34962, this.f2633kl);
        GL20C.glVertexAttribPointer(1, 3, 5126, false, f2629kk, 0L);
        GL20C.glVertexAttribPointer(2, 3, 5126, false, f2629kk, 12L);
        GL20C.glVertexAttribPointer(3, 1, 5126, false, f2629kk, 24L);
        GL20C.glVertexAttribPointer(4, 4, 5121, true, f2629kk, 28L);
        GL20C.glVertexAttribPointer(5, 4, 5121, true, f2629kk, 32L);
        for (int i2 = 1; i2 <= 5; i2++) {
            GL33C.glVertexAttribDivisor(i2, 1);
        }
        GL15C.glBindBuffer(34962, 0);
        VertexBuffer.unbind();
    }

    /* JADX INFO: renamed from: a */
    public void m1928a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull List<C0403gs> list, float f) {
        if (list.isEmpty()) {
            return;
        }
        if (!this.f2634bK) {
            m1927aI();
        }
        ShaderInstance shaderInstanceM1932a = C0405gu.m1932a();
        if (shaderInstanceM1932a == null) {
            return;
        }
        Vec3 position = camera.getPosition();
        double dX = position.x();
        double dY = position.y();
        double dZ = position.z();
        int size = list.size();
        int i = size * f2629kk;
        GL15C.glBindBuffer(34962, this.f2633kl);
        GL15C.glBufferData(34962, i, 35040);
        ByteBuffer byteBufferGlMapBuffer = GL15C.glMapBuffer(34962, 35001);
        boolean z = byteBufferGlMapBuffer != null;
        if (!z) {
            byteBufferGlMapBuffer = MemoryUtil.memAlloc(i);
        }
        Iterator<C0403gs> it = list.iterator();
        while (it.hasNext()) {
            m1929a(it.next(), byteBufferGlMapBuffer, dX, dY, dZ, f);
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
        RenderSystem.setShader(C0405gu::m1932a);
        shaderInstanceM1932a.setDefaultUniforms(VertexFormat.Mode.QUADS, RenderSystem.getModelViewStack(), RenderSystem.getProjectionMatrix(), minecraft.getWindow());
        shaderInstanceM1932a.apply();
        this.f2632a.bind();
        GL31.glDrawElementsInstanced(this.f2632a.mode.asGLMode, this.f2632a.indexCount, this.f2632a.getIndexType().asGLType, 0L, size);
        VertexBuffer.unbind();
        shaderInstanceM1932a.clear();
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
    }

    /* JADX INFO: renamed from: a */
    private void m1929a(@NotNull C0403gs c0403gs, @NotNull ByteBuffer byteBuffer, double d, double d2, double d3, float f) {
        Vec3 vec3M1921c = c0403gs.m1921c();
        Vec3 vec3M1922d = c0403gs.m1922d();
        double d4 = vec3M1921c.x - vec3M1922d.x;
        double d5 = vec3M1921c.y - vec3M1922d.y;
        double d6 = vec3M1921c.z - vec3M1922d.z;
        float f2 = (float) ((vec3M1922d.x + (d4 * ((double) f))) - d);
        float f3 = (float) ((vec3M1922d.y + (d5 * ((double) f))) - d2);
        float f4 = (float) ((vec3M1922d.z + (d6 * ((double) f))) - d3);
        float f5 = f2 + ((float) d4);
        byteBuffer.putFloat(f2);
        byteBuffer.putFloat(f3);
        byteBuffer.putFloat(f4);
        byteBuffer.putFloat(f5);
        byteBuffer.putFloat(f3 + ((float) d5));
        byteBuffer.putFloat(f4 + ((float) d6));
        byteBuffer.putFloat(c0403gs.m1924A() * f2630fw);
        int color = c0403gs.getColor();
        int i = color - ColorReferences.COLOR_BLACK_SOLID;
        int iM7159a = color;
        if (c0403gs.m1925S()) {
            iM7159a = C1270xJ.m7159a(color, 1.0f - c0403gs.m1926r());
        }
        m1930a(byteBuffer, i);
        m1930a(byteBuffer, iM7159a);
    }

    /* JADX INFO: renamed from: a */
    private static void m1930a(@NotNull ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >> 16) & 255));
        byteBuffer.put((byte) ((i >> 8) & 255));
        byteBuffer.put((byte) (i & 255));
        byteBuffer.put((byte) ((i >> 24) & 255));
    }

    /* JADX INFO: renamed from: aL */
    public void m1931aL() {
        if (this.f2632a != null) {
            this.f2632a.close();
        }
        if (this.f2633kl != 0) {
            GL15C.glDeleteBuffers(this.f2633kl);
        }
    }
}
