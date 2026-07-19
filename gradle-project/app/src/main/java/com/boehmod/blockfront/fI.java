package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0151fo;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fI.class */
public abstract class fI<T extends InterfaceC0151fo> implements NativeResource {

    @NotNull
    protected static final VertexFormat a;
    protected static final int iy = 36;
    public static final int iz = 4096;
    protected int iA;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    protected ByteBuffer f120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected VertexBuffer f121a;
    protected double Z;
    protected double aa;
    protected double ab;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final fJ f123a;
    static final /* synthetic */ boolean cl;

    @NotNull
    protected final Object2ObjectMap<fL, Collection<T>> c = new Object2ObjectOpenHashMap();
    protected boolean aU = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected final Matrix4f f122a = new Matrix4f();

    static {
        cl = !fI.class.desiredAssertionStatus();
        a = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("UV0", VertexFormatElement.UV0).build();
    }

    protected fI(@NotNull fJ fJVar) {
        this.f123a = fJVar;
    }

    public void aC() {
        this.aU = true;
        this.f121a = new VertexBuffer(VertexBuffer.Usage.STATIC);
        aD();
        this.iA = GL15C.glGenBuffers();
        this.f120a = MemoryUtil.memAlloc(4096 * ad());
        int iAc = ac();
        for (int i = 2; i <= iAc; i++) {
            GL20C.glEnableVertexAttribArray(i);
        }
        GL15C.glBindBuffer(34962, this.iA);
        k(ad());
        for (int i2 = 2; i2 <= iAc; i2++) {
            GL33C.glVertexAttribDivisor(i2, 1);
        }
        GL15C.glBindBuffer(34962, 0);
        VertexBuffer.unbind();
    }

    protected void aD() {
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, a);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 1.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 1.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
        this.f121a.bind();
        this.f121a.upload(bufferBuilderBegin.buildOrThrow());
    }

    protected int ac() {
        return 6;
    }

    protected void k(int i) {
        GL20C.glVertexAttribPointer(2, 3, 5126, false, i, 0L);
        GL20C.glVertexAttribPointer(3, 1, 5126, true, i, 12L);
        GL20C.glVertexAttribPointer(4, 4, 5121, true, i, 16L);
        GL20C.glVertexAttribPointer(5, 3, 5126, false, i, 20L);
        GL30C.glVertexAttribIPointer(6, 2, 5122, i, 32L);
    }

    public void tick() {
        ObjectIterator it = this.c.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).removeIf((v0) -> {
                return v0.M();
            });
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull Camera camera, float f) {
        if (!this.aU) {
            aC();
        }
        if (this.c.isEmpty()) {
            return;
        }
        Vec3 position = camera.getPosition();
        this.Z = position.x();
        this.aa = position.y();
        this.ab = position.z();
        a(camera);
        ObjectIterator it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Collection<T> collection = (Collection) entry.getValue();
            if (!collection.isEmpty()) {
                a(minecraft, gameRenderer, (fL) entry.getKey(), collection, f);
            }
        }
    }

    protected int ad() {
        return iy;
    }

    protected void a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull fL fLVar, @NotNull Collection<T> collection, float f) {
        int size = collection.size();
        int iAd = size * ad();
        if (size == 0) {
            return;
        }
        this.f120a.limit(iAd).position(0);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            a(it.next(), this.f120a, f);
        }
        this.f120a.flip();
        GL15C.glBindBuffer(34962, this.iA);
        GL15C.glBufferData(34962, iAd, 35040);
        GL15C.glBufferSubData(34962, 0L, this.f120a);
        GL15C.glBindBuffer(34962, 0);
        fLVar.r(minecraft);
        ShaderInstance shader = RenderSystem.getShader();
        if (!cl && shader == null) {
            throw new AssertionError("Instanced particle rendering shader is null");
        }
        gameRenderer.lightTexture().turnOnLightLayer();
        shader.setDefaultUniforms(VertexFormat.Mode.QUADS, RenderSystem.getModelViewStack(), RenderSystem.getProjectionMatrix(), minecraft.getWindow());
        shader.apply();
        this.f121a.bind();
        GL31.glDrawElementsInstanced(this.f121a.mode.asGLMode, this.f121a.indexCount, this.f121a.getIndexType().asGLType, 0L, size);
        VertexBuffer.unbind();
        shader.clear();
        fLVar.s(minecraft);
    }

    protected void a(@NotNull Camera camera) {
        if (this.f123a.a(camera, this.f122a)) {
            BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, a);
            bufferBuilderBegin.addVertex(this.f122a, -1.0f, -1.0f, 0.0f).setUv(0.0f, 1.0f);
            bufferBuilderBegin.addVertex(this.f122a, 1.0f, -1.0f, 0.0f).setUv(1.0f, 1.0f);
            bufferBuilderBegin.addVertex(this.f122a, 1.0f, 1.0f, 0.0f).setUv(1.0f, 0.0f);
            bufferBuilderBegin.addVertex(this.f122a, -1.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
            this.f121a.bind();
            this.f121a.upload(bufferBuilderBegin.buildOrThrow());
            return;
        }
        this.f121a.bind();
    }

    protected void a(@NotNull T t, @NotNull ByteBuffer byteBuffer, float f) {
        Vector3dc vector3dcA = t.a(f);
        byteBuffer.putFloat((float) (vector3dcA.x() - this.Z));
        byteBuffer.putFloat((float) (vector3dcA.y() - this.aa));
        byteBuffer.putFloat((float) (vector3dcA.z() - this.ab));
        byteBuffer.putFloat(t.l(f));
        byteBuffer.putInt(t.mo370a(f));
        TextureAtlasSprite textureAtlasSpriteMo371a = t.mo371a(f);
        byteBuffer.putFloat(textureAtlasSpriteMo371a.getU0());
        byteBuffer.putFloat(textureAtlasSpriteMo371a.getV0());
        byteBuffer.putFloat(textureAtlasSpriteMo371a.getV1() - textureAtlasSpriteMo371a.getV0());
        byteBuffer.putInt(t.b(f));
    }

    public void a(@NotNull T t) {
        ((Collection) this.c.computeIfAbsent(t.mo372a(), obj -> {
            return EvictingQueue.create(4096);
        })).add(t);
    }

    public void aE() {
        this.c.clear();
        C0263jt.log("Cleared all instanced particles.", new Object[0]);
    }

    public int ae() {
        int size = 0;
        ObjectIterator it = this.c.values().iterator();
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    public void aF() {
        this.f121a.close();
        GL15C.glDeleteBuffers(this.iA);
        if (this.f120a != null) {
            MemoryUtil.memFree(this.f120a);
        }
    }
}
