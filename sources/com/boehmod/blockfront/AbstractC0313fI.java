package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0345fo;
import com.google.common.collect.EvictingQueue;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3dc;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;

/* JADX INFO: renamed from: com.boehmod.blockfront.fI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fI.class */
public abstract class AbstractC0313fI<T extends InterfaceC0345fo> implements NativeResource {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected static final VertexFormat f2317a;

    /* JADX INFO: renamed from: iy */
    protected static final int f2318iy = 36;

    /* JADX INFO: renamed from: iz */
    public static final int f2319iz = 4096;

    /* JADX INFO: renamed from: iA */
    protected int f2321iA;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected ByteBuffer f2322a;

    /* JADX INFO: renamed from: a */
    protected VertexBuffer f2323a;

    /* JADX INFO: renamed from: Z */
    protected double f2326Z;

    /* JADX INFO: renamed from: aa */
    protected double f2327aa;

    /* JADX INFO: renamed from: ab */
    protected double f2328ab;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final InterfaceC0314fJ f2329a;

    /* JADX INFO: renamed from: cl */
    static final /* synthetic */ boolean f2330cl;

    /* JADX INFO: renamed from: c */
    @NotNull
    protected final Object2ObjectMap<InterfaceC0316fL, Collection<T>> f2320c = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: aU */
    protected boolean f2324aU = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final Matrix4f f2325a = new Matrix4f();

    static {
        f2330cl = !AbstractC0313fI.class.desiredAssertionStatus();
        f2317a = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("UV0", VertexFormatElement.UV0).build();
    }

    protected AbstractC0313fI(@NotNull InterfaceC0314fJ interfaceC0314fJ) {
        this.f2329a = interfaceC0314fJ;
    }

    /* JADX INFO: renamed from: aC */
    public void m1608aC() {
        this.f2324aU = true;
        this.f2323a = new VertexBuffer(VertexBuffer.Usage.STATIC);
        mo1609aD();
        this.f2321iA = GL15C.glGenBuffers();
        this.f2322a = MemoryUtil.memAlloc(4096 * mo1613ad());
        int iMo1610ac = mo1610ac();
        for (int i = 2; i <= iMo1610ac; i++) {
            GL20C.glEnableVertexAttribArray(i);
        }
        GL15C.glBindBuffer(34962, this.f2321iA);
        mo1611k(mo1613ad());
        for (int i2 = 2; i2 <= iMo1610ac; i2++) {
            GL33C.glVertexAttribDivisor(i2, 1);
        }
        GL15C.glBindBuffer(34962, 0);
        VertexBuffer.unbind();
    }

    /* JADX INFO: renamed from: aD */
    protected void mo1609aD() {
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2317a);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 1.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 1.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
        this.f2323a.bind();
        this.f2323a.upload(bufferBuilderBegin.buildOrThrow());
    }

    /* JADX INFO: renamed from: ac */
    protected int mo1610ac() {
        return 6;
    }

    /* JADX INFO: renamed from: k */
    protected void mo1611k(int i) {
        GL20C.glVertexAttribPointer(2, 3, 5126, false, i, 0L);
        GL20C.glVertexAttribPointer(3, 1, 5126, true, i, 12L);
        GL20C.glVertexAttribPointer(4, 4, 5121, true, i, 16L);
        GL20C.glVertexAttribPointer(5, 3, 5126, false, i, 20L);
        GL30C.glVertexAttribIPointer(6, 2, 5122, i, 32L);
    }

    public void tick() {
        ObjectIterator it = this.f2320c.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).removeIf((v0) -> {
                return v0.mo1457M();
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1612a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull Camera camera, float f) {
        if (!this.f2324aU) {
            m1608aC();
        }
        if (this.f2320c.isEmpty()) {
            return;
        }
        Vec3 position = camera.getPosition();
        this.f2326Z = position.x();
        this.f2327aa = position.y();
        this.f2328ab = position.z();
        mo1615a(camera);
        ObjectIterator it = this.f2320c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Collection<T> collection = (Collection) entry.getValue();
            if (!collection.isEmpty()) {
                m1614a(minecraft, gameRenderer, (InterfaceC0316fL) entry.getKey(), collection, f);
            }
        }
    }

    /* JADX INFO: renamed from: ad */
    protected int mo1613ad() {
        return f2318iy;
    }

    /* JADX INFO: renamed from: a */
    protected void m1614a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull InterfaceC0316fL interfaceC0316fL, @NotNull Collection<T> collection, float f) {
        int size = collection.size();
        int iMo1613ad = size * mo1613ad();
        if (size == 0) {
            return;
        }
        this.f2322a.limit(iMo1613ad).position(0);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            mo1616a(it.next(), this.f2322a, f);
        }
        this.f2322a.flip();
        GL15C.glBindBuffer(34962, this.f2321iA);
        GL15C.glBufferData(34962, iMo1613ad, 35040);
        GL15C.glBufferSubData(34962, 0L, this.f2322a);
        GL15C.glBindBuffer(34962, 0);
        interfaceC0316fL.mo1623r(minecraft);
        ShaderInstance shader = RenderSystem.getShader();
        if (!f2330cl && shader == null) {
            throw new AssertionError("Instanced particle rendering shader is null");
        }
        gameRenderer.lightTexture().turnOnLightLayer();
        shader.setDefaultUniforms(VertexFormat.Mode.QUADS, RenderSystem.getModelViewStack(), RenderSystem.getProjectionMatrix(), minecraft.getWindow());
        shader.apply();
        this.f2323a.bind();
        GL31.glDrawElementsInstanced(this.f2323a.mode.asGLMode, this.f2323a.indexCount, this.f2323a.getIndexType().asGLType, 0L, size);
        VertexBuffer.unbind();
        shader.clear();
        interfaceC0316fL.mo1624s(minecraft);
    }

    /* JADX INFO: renamed from: a */
    protected void mo1615a(@NotNull Camera camera) {
        if (this.f2329a.mo1622a(camera, this.f2325a)) {
            BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2317a);
            bufferBuilderBegin.addVertex(this.f2325a, -1.0f, -1.0f, 0.0f).setUv(0.0f, 1.0f);
            bufferBuilderBegin.addVertex(this.f2325a, 1.0f, -1.0f, 0.0f).setUv(1.0f, 1.0f);
            bufferBuilderBegin.addVertex(this.f2325a, 1.0f, 1.0f, 0.0f).setUv(1.0f, 0.0f);
            bufferBuilderBegin.addVertex(this.f2325a, -1.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
            this.f2323a.bind();
            this.f2323a.upload(bufferBuilderBegin.buildOrThrow());
            return;
        }
        this.f2323a.bind();
    }

    /* JADX INFO: renamed from: a */
    protected void mo1616a(@NotNull T t, @NotNull ByteBuffer byteBuffer, float f) {
        Vector3dc vector3dcMo1458a = t.mo1458a(f);
        byteBuffer.putFloat((float) (vector3dcMo1458a.x() - this.f2326Z));
        byteBuffer.putFloat((float) (vector3dcMo1458a.y() - this.f2327aa));
        byteBuffer.putFloat((float) (vector3dcMo1458a.z() - this.f2328ab));
        byteBuffer.putFloat(t.mo1459l(f));
        byteBuffer.putInt(t.mo1451a(f));
        TextureAtlasSprite textureAtlasSpriteMo1460a = t.mo1460a(f);
        byteBuffer.putFloat(textureAtlasSpriteMo1460a.getU0());
        byteBuffer.putFloat(textureAtlasSpriteMo1460a.getV0());
        byteBuffer.putFloat(textureAtlasSpriteMo1460a.getV1() - textureAtlasSpriteMo1460a.getV0());
        byteBuffer.putInt(t.mo1461b(f));
    }

    /* JADX INFO: renamed from: a */
    public void m1617a(@NotNull T t) {
        ((Collection) this.f2320c.computeIfAbsent(t.mo1452a(), obj -> {
            return EvictingQueue.create(4096);
        })).add(t);
    }

    /* JADX INFO: renamed from: aE */
    public void m1618aE() {
        this.f2320c.clear();
        C0562jt.log("Cleared all instanced particles.", new Object[0]);
    }

    /* JADX INFO: renamed from: ae */
    public int m1619ae() {
        int size = 0;
        ObjectIterator it = this.f2320c.values().iterator();
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    /* JADX INFO: renamed from: aF */
    public void m1620aF() {
        this.f2323a.close();
        GL15C.glDeleteBuffers(this.f2321iA);
        if (this.f2322a != null) {
            MemoryUtil.memFree(this.f2322a);
        }
    }
}
