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

/* JADX INFO: renamed from: com.boehmod.blockfront.gd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gd.class */
public final class C0167gd implements NativeResource {
    private static final int iP = 36;
    private static final float fm = 5.0E-4f;

    @NotNull
    private static final VertexFormat b = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).build();
    private VertexBuffer a;
    private int iQ;
    private boolean aU = false;

    private void aC() {
        this.aU = true;
        this.a = new VertexBuffer(VertexBuffer.Usage.STATIC);
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, b);
        bufferBuilderBegin.addVertex(-1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 0.0f, 0.0f);
        bufferBuilderBegin.addVertex(1.0f, 1.0f, 0.0f);
        bufferBuilderBegin.addVertex(-1.0f, 1.0f, 0.0f);
        this.a.bind();
        this.a.upload(bufferBuilderBegin.buildOrThrow());
        this.iQ = GL15C.glGenBuffers();
        for (int i = 1; i <= 5; i++) {
            GL20C.glEnableVertexAttribArray(i);
        }
        GL15C.glBindBuffer(34962, this.iQ);
        GL20C.glVertexAttribPointer(1, 3, 5126, false, iP, 0L);
        GL20C.glVertexAttribPointer(2, 3, 5126, false, iP, 12L);
        GL20C.glVertexAttribPointer(3, 1, 5126, false, iP, 24L);
        GL20C.glVertexAttribPointer(4, 4, 5121, true, iP, 28L);
        GL20C.glVertexAttribPointer(5, 4, 5121, true, iP, 32L);
        for (int i2 = 1; i2 <= 5; i2++) {
            GL33C.glVertexAttribDivisor(i2, 1);
        }
        GL15C.glBindBuffer(34962, 0);
        VertexBuffer.unbind();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull List<C0166gc> list, float f) {
        if (list.isEmpty()) {
            return;
        }
        if (!this.aU) {
            aC();
        }
        ShaderInstance shaderInstanceA = C0168ge.a();
        if (shaderInstanceA == null) {
            return;
        }
        Vec3 position = camera.getPosition();
        double dX = position.x();
        double dY = position.y();
        double dZ = position.z();
        int size = list.size();
        int i = size * iP;
        GL15C.glBindBuffer(34962, this.iQ);
        GL15C.glBufferData(34962, i, 35040);
        ByteBuffer byteBufferGlMapBuffer = GL15C.glMapBuffer(34962, 35001);
        boolean z = byteBufferGlMapBuffer != null;
        if (!z) {
            byteBufferGlMapBuffer = MemoryUtil.memAlloc(i);
        }
        Iterator<C0166gc> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), byteBufferGlMapBuffer, dX, dY, dZ, f);
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
        RenderSystem.setShader(C0168ge::a);
        shaderInstanceA.setDefaultUniforms(VertexFormat.Mode.QUADS, RenderSystem.getModelViewStack(), RenderSystem.getProjectionMatrix(), minecraft.getWindow());
        shaderInstanceA.apply();
        this.a.bind();
        GL31.glDrawElementsInstanced(this.a.mode.asGLMode, this.a.indexCount, this.a.getIndexType().asGLType, 0L, size);
        VertexBuffer.unbind();
        shaderInstanceA.clear();
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.enableCull();
    }

    private void a(@NotNull C0166gc c0166gc, @NotNull ByteBuffer byteBuffer, double d, double d2, double d3, float f) {
        Vec3 vec3C = c0166gc.c();
        Vec3 vec3D = c0166gc.d();
        double d4 = vec3C.x - vec3D.x;
        double d5 = vec3C.y - vec3D.y;
        double d6 = vec3C.z - vec3D.z;
        float f2 = (float) ((vec3D.x + (d4 * ((double) f))) - d);
        float f3 = (float) ((vec3D.y + (d5 * ((double) f))) - d2);
        float f4 = (float) ((vec3D.z + (d6 * ((double) f))) - d3);
        float f5 = f2 + ((float) d4);
        byteBuffer.putFloat(f2);
        byteBuffer.putFloat(f3);
        byteBuffer.putFloat(f4);
        byteBuffer.putFloat(f5);
        byteBuffer.putFloat(f3 + ((float) d5));
        byteBuffer.putFloat(f4 + ((float) d6));
        byteBuffer.putFloat(c0166gc.A() * fm);
        int color = c0166gc.getColor();
        int i = color - ColorReferences.COLOR_BLACK_SOLID;
        int iA = color;
        if (c0166gc.Q()) {
            iA = C0634xm.a(color, 1.0f - c0166gc.r());
        }
        a(byteBuffer, i);
        a(byteBuffer, iA);
    }

    private static void a(@NotNull ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >> 16) & 255));
        byteBuffer.put((byte) ((i >> 8) & 255));
        byteBuffer.put((byte) (i & 255));
        byteBuffer.put((byte) ((i >> 24) & 255));
    }

    public void aF() {
        if (this.a != null) {
            this.a.close();
        }
        if (this.iQ != 0) {
            GL15C.glDeleteBuffers(this.iQ);
        }
    }
}
