package foundry.veil.impl.client.necromancer.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.render.NecromancerRenderer;
import foundry.veil.api.client.necromancer.render.Skin;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.profiler.RenderProfilerCounter;
import foundry.veil.api.client.render.profiler.VeilRenderProfiler;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.shader.block.DynamicShaderBlock;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.api.client.render.vertex.VertexArray;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.floats.FloatList;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3f;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/necromancer/render/NecromancerRenderDispatcher.class */
@ApiStatus.Internal
public class NecromancerRenderDispatcher {
    private static final Batched BATCHED = new Batched();
    private static final Immediate IMMEDIATE = new Immediate();
    private static final int BASE_INSTANCES = 100;
    private static DynamicShaderBlock<?> boneBlock;
    private static int boneBuffer;
    private static int instancedBuffer;
    private static ByteBufferBuilder boneBuilder;
    private static boolean drawing;

    public static void begin() {
        drawing = true;
        BATCHED.begin();
    }

    public static void end() {
        BATCHED.end();
        drawing = false;
    }

    public static void delete() {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            GL15C.glDeleteBuffers(stack.ints(boneBuffer, instancedBuffer));
            if (stack != null) {
                stack.close();
            }
            boneBlock = null;
            boneBuffer = 0;
            instancedBuffer = 0;
            if (boneBuilder != null) {
                boneBuilder.close();
                boneBuilder = null;
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static NecromancerRenderer getRenderer() {
        return drawing ? BATCHED : IMMEDIATE;
    }

    private static void updateBlockSize(int skeletonCount, int dataSize) {
        if (boneBlock == null) {
            boneBuffer = GlStateManager._glGenBuffers();
            boneBlock = ShaderBlock.wrapper(ShaderBlock.BufferBinding.UNIFORM, boneBuffer);
        }
        if (boneBlock.getSize() < Skeleton.UNIFORM_STRIDE * skeletonCount * dataSize) {
            int newSize = (int) (((double) skeletonCount) * 1.5d * ((double) dataSize));
            boneBlock.setSize(Skeleton.UNIFORM_STRIDE * newSize);
            VeilRenderSystem.renderer().getShaderDefinitions().set("NECROMANCER_BONE_BUFFER_SIZE", Long.toString(newSize));
            if (VeilRenderSystem.directStateAccessSupported()) {
                ARBDirectStateAccess.glNamedBufferData(boneBuffer, boneBlock.getSize(), 35048);
                return;
            }
            GL15C.glBindBuffer(35345, boneBuffer);
            GL15C.glBufferData(35345, boneBlock.getSize(), 35048);
            GL15C.glBindBuffer(35345, 0);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/necromancer/render/NecromancerRenderDispatcher$RendererImpl.class */
    private static abstract class RendererImpl implements NecromancerRenderer {
        protected int overlay;
        protected int light;

        /* JADX INFO: renamed from: r */
        protected int f8767r;

        /* JADX INFO: renamed from: g */
        protected int f8768g;

        /* JADX INFO: renamed from: b */
        protected int f8769b;

        /* JADX INFO: renamed from: a */
        protected int f8770a;
        protected final Matrix4f transform = new Matrix4f();

        private RendererImpl() {
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void setUv1(int u, int v) {
            this.overlay = ((v & 15) << 4) | (u & 15);
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void setUv2(int u, int v) {
            this.light = ((v & 15) << 4) | (u & 15);
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void setColor(float r, float g, float b, float a) {
            this.f8767r = ((int) (((double) r) * 255.0d)) & 255;
            this.f8768g = ((int) (((double) g) * 255.0d)) & 255;
            this.f8769b = ((int) (((double) b) * 255.0d)) & 255;
            this.f8770a = ((int) (((double) a) * 255.0d)) & 255;
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void setColor(int color) {
            this.f8767r = (color >> 16) & 255;
            this.f8768g = (color >> 8) & 255;
            this.f8769b = color & 255;
            this.f8770a = (color >> 24) & 255;
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void reset() {
            this.overlay = 160;
            this.light = 255;
            this.f8767r = 255;
            this.f8768g = 255;
            this.f8769b = 255;
            this.f8770a = 255;
            this.transform.identity();
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void setTransform(Matrix4fc transform) {
            this.transform.set(transform);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/necromancer/render/NecromancerRenderDispatcher$Immediate.class */
    public static class Immediate extends RendererImpl {
        private final Matrix4x3f affineTransform = new Matrix4x3f();

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setTransform(Matrix4fc matrix4fc) {
            super.setTransform(matrix4fc);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setColor(int i) {
            super.setColor(i);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setColor(float f, float f2, float f3, float f4) {
            super.setColor(f, f2, f3, f4);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setUv2(int i, int i2) {
            super.setUv2(i, i2);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setUv1(int i, int i2) {
            super.setUv1(i, i2);
        }

        private Immediate() {
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void draw(RenderType renderType, Skeleton skeleton, Skin skin, float partialTicks) {
            VeilRenderProfiler profiler = VeilRenderProfiler.get();
            profiler.push("necromancer_draw_immediate_" + VeilRenderType.getName(renderType), new RenderProfilerCounter[0]);
            MemoryStack stack = MemoryStack.stackPush();
            try {
                ByteBuffer instancedData = stack.malloc(8);
                instancedData.put(0, (byte) this.overlay);
                instancedData.put(1, (byte) this.light);
                instancedData.put(2, (byte) this.f8767r);
                instancedData.put(3, (byte) this.f8768g);
                instancedData.put(4, (byte) this.f8769b);
                instancedData.put(5, (byte) this.f8770a);
                instancedData.put(6, (byte) 0);
                instancedData.put(7, (byte) 0);
                this.affineTransform.set(this.transform);
                if (NecromancerRenderDispatcher.instancedBuffer == 0) {
                    NecromancerRenderDispatcher.instancedBuffer = GlStateManager._glGenBuffers();
                }
                if (NecromancerRenderDispatcher.boneBuilder == null) {
                    NecromancerRenderDispatcher.boneBuilder = new ByteBufferBuilder(11200);
                }
                VertexArray.upload(NecromancerRenderDispatcher.instancedBuffer, instancedData, VertexArray.DrawUsage.DYNAMIC);
                NecromancerRenderDispatcher.updateBlockSize(1, skin.getSkeletonDataSize());
                skin.render(renderType, List.of(this.affineTransform), List.of(skeleton), NecromancerRenderDispatcher.instancedBuffer, NecromancerRenderDispatcher.boneBuilder, NecromancerRenderDispatcher.boneBuffer, NecromancerRenderDispatcher.boneBlock, FloatList.of(partialTicks));
                if (stack != null) {
                    stack.close();
                }
                profiler.pop();
            } catch (Throwable th) {
                if (stack != null) {
                    try {
                        stack.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @NotNull
        public VertexConsumer getBuffer(@NotNull RenderType renderType) {
            return Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(renderType);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/necromancer/render/NecromancerRenderDispatcher$Batched.class */
    public static class Batched extends RendererImpl {
        private final List<ByteBufferBuilder> bufferBuilderList = new ObjectArrayList();
        private final Int2ObjectMap<SkeletonBatch> skeletonBatches = new Int2ObjectArrayMap();
        private final Map<RenderType, BufferBuilder> buffers = new Object2ObjectArrayMap();
        private int bufferIndex;

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setTransform(Matrix4fc matrix4fc) {
            super.setTransform(matrix4fc);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setColor(int i) {
            super.setColor(i);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setColor(float f, float f2, float f3, float f4) {
            super.setColor(f, f2, f3, f4);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setUv2(int i, int i2) {
            super.setUv2(i, i2);
        }

        @Override // foundry.veil.impl.client.necromancer.render.NecromancerRenderDispatcher.RendererImpl, foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public /* bridge */ /* synthetic */ void setUv1(int i, int i2) {
            super.setUv1(i, i2);
        }

        @Override // foundry.veil.api.client.necromancer.render.NecromancerRenderer
        public void draw(RenderType renderType, Skeleton skeleton, Skin skin, float partialTicks) {
            SkeletonBatch batch = (SkeletonBatch) this.skeletonBatches.computeIfAbsent((skin.hashCode() * 31) + renderType.hashCode(), unused -> {
                return new SkeletonBatch(renderType, skin);
            });
            batch.add(this.transform, skeleton, this.overlay, this.light, this.f8767r, this.f8768g, this.f8769b, this.f8770a, partialTicks);
        }

        @NotNull
        public VertexConsumer getBuffer(@NotNull RenderType renderType) {
            BufferBuilder buffer;
            BufferBuilder buffer2 = this.buffers.get(renderType);
            if (buffer2 != null) {
                return buffer2;
            }
            if (this.bufferIndex >= this.bufferBuilderList.size()) {
                ByteBufferBuilder builder = new ByteBufferBuilder(renderType.bufferSize());
                this.bufferBuilderList.add(builder);
                buffer = new BufferBuilder(builder, renderType.mode(), renderType.format());
            } else {
                buffer = new BufferBuilder(this.bufferBuilderList.get(this.bufferIndex), renderType.mode(), renderType.format());
            }
            this.bufferIndex++;
            this.buffers.put(renderType, buffer);
            return buffer;
        }

        public void begin() {
            this.bufferIndex = 0;
            reset();
        }

        public void end() {
            VeilRenderProfiler profiler = VeilRenderProfiler.get();
            ObjectIterator it = this.skeletonBatches.values().iterator();
            while (it.hasNext()) {
                SkeletonBatch batch = (SkeletonBatch) it.next();
                profiler.push("necromancer_draw_batched_" + VeilRenderType.getName(batch.renderType), new RenderProfilerCounter[0]);
                batch.render();
                profiler.pop();
            }
            this.skeletonBatches.clear();
            for (Map.Entry<RenderType, BufferBuilder> entry : this.buffers.entrySet()) {
                MeshData data = entry.getValue().build();
                if (data != null) {
                    try {
                        entry.getKey().draw(data);
                    } catch (Throwable th) {
                        if (data != null) {
                            try {
                                data.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                if (data != null) {
                    data.close();
                }
            }
            this.buffers.clear();
            ListIterator<ByteBufferBuilder> iterator = this.bufferBuilderList.listIterator(this.bufferIndex);
            while (iterator.hasNext()) {
                iterator.next().close();
                iterator.remove();
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/necromancer/render/NecromancerRenderDispatcher$SkeletonBatch.class */
    private static class SkeletonBatch {
        private final RenderType renderType;
        private final Skin skin;
        private final List<Matrix4x3f> transforms = new ObjectArrayList();
        private final List<Skeleton> skeletons = new ObjectArrayList();
        private final FloatList partialTicks = new FloatArrayList();
        private ByteBuffer instancedData = MemoryUtil.memAlloc(800);

        private SkeletonBatch(RenderType renderType, Skin skin) {
            this.renderType = renderType;
            this.skin = skin;
        }

        public void add(Matrix4fc transform, Skeleton skeleton, int overlay, int light, int r, int g, int b, int a, float partialTicks) {
            if (this.instancedData.capacity() - this.instancedData.position() < 8) {
                this.instancedData = MemoryUtil.memRealloc(this.instancedData, (int) (((double) this.instancedData.capacity()) * 1.5d));
            }
            this.instancedData.put((byte) overlay);
            this.instancedData.put((byte) light);
            this.instancedData.put((byte) r);
            this.instancedData.put((byte) g);
            this.instancedData.put((byte) b);
            this.instancedData.put((byte) a);
            this.instancedData.put((byte) 0);
            this.instancedData.put((byte) 0);
            this.transforms.add(new Matrix4x3f().set(transform));
            this.skeletons.add(skeleton);
            this.partialTicks.add(partialTicks);
        }

        public void render() {
            try {
                if (NecromancerRenderDispatcher.instancedBuffer == 0) {
                    NecromancerRenderDispatcher.instancedBuffer = GlStateManager._glGenBuffers();
                }
                if (NecromancerRenderDispatcher.boneBuilder == null) {
                    NecromancerRenderDispatcher.boneBuilder = new ByteBufferBuilder(11200);
                }
                this.instancedData.flip();
                VertexArray.upload(NecromancerRenderDispatcher.instancedBuffer, this.instancedData, VertexArray.DrawUsage.DYNAMIC);
                NecromancerRenderDispatcher.updateBlockSize(this.skeletons.size(), this.skin.getSkeletonDataSize());
                this.skin.render(this.renderType, this.transforms, this.skeletons, NecromancerRenderDispatcher.instancedBuffer, NecromancerRenderDispatcher.boneBuilder, NecromancerRenderDispatcher.boneBuffer, NecromancerRenderDispatcher.boneBlock, this.partialTicks);
            } finally {
                MemoryUtil.memFree(this.instancedData);
            }
        }
    }
}
