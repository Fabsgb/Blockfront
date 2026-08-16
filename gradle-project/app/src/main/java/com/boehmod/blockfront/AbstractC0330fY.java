package com.boehmod.blockfront;

import com.boehmod.blockfront.InterfaceC0310fE;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.fY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/fY.class */
public abstract class AbstractC0330fY<T extends InterfaceC0310fE> implements NativeResource {

    /* JADX INFO: renamed from: a */
    @NotNull
    protected static final VertexFormat f2419a;

    /* JADX INFO: renamed from: jT */
    protected static final int f2420jT = 36;

    /* JADX INFO: renamed from: jU */
    public static final int f2421jU = 4096;

    /* JADX INFO: renamed from: jV */
    protected int f2423jV;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected ByteBuffer f2424a;

    /* JADX INFO: renamed from: a */
    protected VertexBuffer f2425a;

    /* JADX INFO: renamed from: ag */
    protected double f2428ag;

    /* JADX INFO: renamed from: ah */
    protected double f2429ah;

    /* JADX INFO: renamed from: ai */
    protected double f2430ai;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected final InterfaceC0331fZ f2431a;

    /* JADX INFO: renamed from: cu */
    static final /* synthetic */ boolean f2432cu;

    /* JADX INFO: renamed from: c */
    @NotNull
    protected final Object2ObjectMap<InterfaceC0386gb, Collection<T>> f2422c = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: bK */
    protected boolean f2426bK = false;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final Matrix4f f2427b = new Matrix4f();

    static {
        f2432cu = !AbstractC0330fY.class.desiredAssertionStatus();
        f2419a = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("UV0", VertexFormatElement.UV0).build();
    }

    protected AbstractC0330fY(@NotNull InterfaceC0331fZ interfaceC0331fZ) {
        this.f2431a = interfaceC0331fZ;
    }

    /* JADX INFO: renamed from: aI */
    public void m1678aI() {
        this.f2426bK = true;
        this.f2425a = new VertexBuffer(VertexBuffer.Usage.STATIC);
        mo1679aJ();
        this.f2423jV = GL15C.glGenBuffers();
        this.f2424a = MemoryUtil.memAlloc(4096 * mo1683ap());
        int iMo1680ao = mo1680ao();
        for (int i = 2; i <= iMo1680ao; i++) {
            GL20C.glEnableVertexAttribArray(i);
        }
        GL15C.glBindBuffer(34962, this.f2423jV);
        mo1681k(mo1683ap());
        for (int i2 = 2; i2 <= iMo1680ao; i2++) {
            GL33C.glVertexAttribDivisor(i2, 1);
        }
        GL15C.glBindBuffer(34962, 0);
        VertexBuffer.unbind();
    }

    /* JADX INFO: renamed from: aJ */
    protected void mo1679aJ() {
        BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2419a);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 0.0f).setUv(0.0f, 1.0f);
        bufferBuilderBegin.addVertex(0.0f, 0.0f, 1.0f).setUv(1.0f, 1.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 1.0f).setUv(1.0f, 0.0f);
        bufferBuilderBegin.addVertex(0.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
        this.f2425a.bind();
        this.f2425a.upload(bufferBuilderBegin.buildOrThrow());
    }

    /* JADX INFO: renamed from: ao */
    protected int mo1680ao() {
        return 6;
    }

    /* JADX INFO: renamed from: k */
    protected void mo1681k(int i) {
        GL20C.glVertexAttribPointer(2, 3, 5126, false, i, 0L);
        GL20C.glVertexAttribPointer(3, 1, 5126, true, i, 12L);
        GL20C.glVertexAttribPointer(4, 4, 5121, true, i, 16L);
        GL20C.glVertexAttribPointer(5, 3, 5126, false, i, 20L);
        GL30C.glVertexAttribIPointer(6, 2, 5122, i, 32L);
    }

    public void tick() {
        ObjectIterator it = this.f2422c.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).removeIf((v0) -> {
                return v0.mo1660O();
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1682a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull Camera camera, float f) {
        if (!this.f2426bK) {
            m1678aI();
        }
        if (this.f2422c.isEmpty()) {
            return;
        }
        Vec3 position = camera.getPosition();
        this.f2428ag = position.x();
        this.f2429ah = position.y();
        this.f2430ai = position.z();
        mo1685a(camera);
        ObjectIterator it = this.f2422c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Collection<T> collection = (Collection) entry.getValue();
            if (!collection.isEmpty()) {
                m1684a(minecraft, gameRenderer, (InterfaceC0386gb) entry.getKey(), collection, f);
            }
        }
    }

    /* JADX INFO: renamed from: ap */
    protected int mo1683ap() {
        return f2420jT;
    }

    /* JADX INFO: renamed from: a */
    protected void m1684a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull InterfaceC0386gb interfaceC0386gb, @NotNull Collection<T> collection, float f) {
        int size = collection.size();
        int iMo1683ap = size * mo1683ap();
        if (size == 0) {
            return;
        }
        this.f2424a.limit(iMo1683ap).position(0);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            mo1686a(it.next(), this.f2424a, f);
        }
        this.f2424a.flip();
        GL15C.glBindBuffer(34962, this.f2423jV);
        GL15C.glBufferData(34962, iMo1683ap, 35040);
        GL15C.glBufferSubData(34962, 0L, this.f2424a);
        GL15C.glBindBuffer(34962, 0);
        interfaceC0386gb.mo1833s(minecraft);
        ShaderInstance shader = RenderSystem.getShader();
        if (!f2432cu && shader == null) {
            throw new AssertionError("Instanced particle rendering shader is null");
        }
        gameRenderer.lightTexture().turnOnLightLayer();
        shader.setDefaultUniforms(VertexFormat.Mode.QUADS, RenderSystem.getModelViewStack(), RenderSystem.getProjectionMatrix(), minecraft.getWindow());
        shader.apply();
        this.f2425a.bind();
        GL31.glDrawElementsInstanced(this.f2425a.mode.asGLMode, this.f2425a.indexCount, this.f2425a.getIndexType().asGLType, 0L, size);
        VertexBuffer.unbind();
        shader.clear();
        interfaceC0386gb.mo1834t(minecraft);
    }

    /* JADX INFO: renamed from: a */
    protected void mo1685a(@NotNull Camera camera) {
        if (this.f2431a.mo1692a(camera, this.f2427b)) {
            BufferBuilder bufferBuilderBegin = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, f2419a);
            bufferBuilderBegin.addVertex(this.f2427b, -1.0f, -1.0f, 0.0f).setUv(0.0f, 1.0f);
            bufferBuilderBegin.addVertex(this.f2427b, 1.0f, -1.0f, 0.0f).setUv(1.0f, 1.0f);
            bufferBuilderBegin.addVertex(this.f2427b, 1.0f, 1.0f, 0.0f).setUv(1.0f, 0.0f);
            bufferBuilderBegin.addVertex(this.f2427b, -1.0f, 1.0f, 0.0f).setUv(0.0f, 0.0f);
            this.f2425a.bind();
            this.f2425a.upload(bufferBuilderBegin.buildOrThrow());
            return;
        }
        this.f2425a.bind();
    }

    /* JADX INFO: renamed from: a */
    protected void mo1686a(@NotNull T t, @NotNull ByteBuffer byteBuffer, float f) {
        Vector3dc vector3dcMo1657a = t.mo1657a(f);
        byteBuffer.putFloat((float) (vector3dcMo1657a.x() - this.f2428ag));
        byteBuffer.putFloat((float) (vector3dcMo1657a.y() - this.f2429ah));
        byteBuffer.putFloat((float) (vector3dcMo1657a.z() - this.f2430ai));
        byteBuffer.putFloat(t.mo1661k(f));
        byteBuffer.putInt(t.mo1544b(f));
        TextureAtlasSprite textureAtlasSpriteMo1662a = t.mo1662a(f);
        byteBuffer.putFloat(textureAtlasSpriteMo1662a.getU0());
        byteBuffer.putFloat(textureAtlasSpriteMo1662a.getV0());
        byteBuffer.putFloat(textureAtlasSpriteMo1662a.getV1() - textureAtlasSpriteMo1662a.getV0());
        byteBuffer.putInt(t.mo1663c(f));
    }

    /* JADX INFO: renamed from: a */
    public void m1687a(@NotNull T t) {
        ((Collection) this.f2422c.computeIfAbsent(t.mo1545a(), obj -> {
            return EvictingQueue.create(4096);
        })).add(t);
    }

    /* JADX INFO: renamed from: aK */
    public void m1688aK() {
        this.f2422c.clear();
        C0530jM.log("Cleared all instanced particles.", new Object[0]);
    }

    /* JADX INFO: renamed from: aq */
    public int m1689aq() {
        int size = 0;
        ObjectIterator it = this.f2422c.values().iterator();
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    /* JADX INFO: renamed from: aL */
    public void m1690aL() {
        this.f2425a.close();
        GL15C.glDeleteBuffers(this.f2423jV);
        if (this.f2424a != null) {
            MemoryUtil.memFree(this.f2424a);
        }
    }
}
