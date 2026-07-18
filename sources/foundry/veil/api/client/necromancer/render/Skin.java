package foundry.veil.api.client.necromancer.render;

import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.shader.block.DynamicShaderBlock;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import it.unimi.dsi.fastutil.floats.FloatList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/render/Skin.class */
public class Skin implements NativeResource {
    private final VertexArray vertexArray;
    private final Object2IntMap<String> boneIds;
    private int instances;
    private final Vector4f color = new Vector4f();
    private final Matrix3f normalMatrix = new Matrix3f();
    private Matrix4x3f[] matrixStack = null;
    private Quaternionf[] orientationStack = null;

    public Skin(VertexArray vertexArray, Object2IntMap<String> boneIds) {
        this.vertexArray = vertexArray;
        this.boneIds = boneIds;
    }

    @ApiStatus.Internal
    public void render(RenderType renderType, List<Matrix4x3f> transforms, List<Skeleton> skeletons, int instancedBuffer, ByteBufferBuilder boneBuilder, int boneBuffer, DynamicShaderBlock<?> boneBlock, FloatList partialTicks) {
        if (skeletons.isEmpty()) {
            return;
        }
        if (this.instances != skeletons.size()) {
            VertexArrayBuilder format = this.vertexArray.editFormat();
            format.defineVertexBuffer(1, instancedBuffer, 0, 8, 1);
            if (this.instances == 0) {
                format.setVertexIAttribute(4, 1, 1, VertexArrayBuilder.DataType.UNSIGNED_BYTE, 0);
                format.setVertexIAttribute(5, 1, 1, VertexArrayBuilder.DataType.UNSIGNED_BYTE, 1);
                format.setVertexAttribute(6, 1, 4, VertexArrayBuilder.DataType.UNSIGNED_BYTE, true, 2);
            }
            this.instances = skeletons.size();
        }
        Skeleton first = (Skeleton) skeletons.getFirst();
        int maxDepth = first.getMaxDepth();
        if (this.matrixStack == null || this.matrixStack.length < maxDepth) {
            this.matrixStack = new Matrix4x3f[maxDepth];
            this.orientationStack = new Quaternionf[maxDepth];
            for (int i = 0; i < maxDepth; i++) {
                this.matrixStack[i] = new Matrix4x3f();
                this.orientationStack[i] = new Quaternionf();
            }
        }
        int skeletonDataSize = Skeleton.UNIFORM_STRIDE * getSkeletonDataSize();
        int size = skeletonDataSize * skeletons.size();
        ByteBuffer buffer = MemoryUtil.memByteBuffer(boneBuilder.reserve(size), size);
        for (int i2 = 0; i2 < skeletons.size(); i2++) {
            Skeleton skeleton = skeletons.get(i2);
            for (int j = 0; j < maxDepth; j++) {
                this.matrixStack[j].identity();
            }
            buffer.position(i2 * skeletonDataSize);
            skeleton.storeInstancedData(buffer, skeleton.roots, this.boneIds, 0, this.color, this.normalMatrix, transforms.get(i2), this.matrixStack, this.orientationStack, partialTicks.getFloat(i2));
        }
        buffer.rewind();
        ByteBufferBuilder.Result result = boneBuilder.build();
        if (result != null) {
            result.close();
        }
        if (VeilRenderSystem.directStateAccessSupported()) {
            ARBDirectStateAccess.glNamedBufferSubData(boneBuffer, 0L, buffer);
        } else {
            GL15C.glBindBuffer(35345, boneBuffer);
            GL15C.glBufferSubData(35345, 0L, buffer);
        }
        this.vertexArray.bind();
        VeilRenderSystem.bind("NecromancerBones", boneBlock);
        renderType.setupRenderState();
        render();
        renderType.clearRenderState();
        if (renderType instanceof VeilRenderType.LayeredRenderType) {
            VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
            for (RenderType layer : layeredRenderType.getLayers()) {
                layer.setupRenderState();
                render();
                layer.clearRenderState();
            }
        }
        VeilRenderSystem.unbind(boneBlock);
    }

    private void render() {
        ShaderInstance shader = RenderSystem.getShader();
        if (shader != null) {
            shader.setDefaultUniforms(VertexFormat.Mode.TRIANGLES, RenderSystem.getModelViewMatrix(), RenderSystem.getProjectionMatrix(), Minecraft.getInstance().getWindow());
            shader.apply();
            Uniform uniform = shader.getUniform("NecromancerBoneCount");
            if (uniform != null) {
                GL30C.glUniform1ui(uniform.getLocation(), this.boneIds.size());
            }
        }
        this.vertexArray.drawInstanced(this.instances);
        if (shader != null) {
            shader.clear();
        }
    }

    public VertexArray getVertexArray() {
        return this.vertexArray;
    }

    public int getSkeletonDataSize() {
        return this.boneIds.size();
    }

    public static VertexArray createVertexArray() {
        RenderSystem.assertOnRenderThreadOrInit();
        VertexArray vertexArray = VertexArray.create();
        int vbo = vertexArray.getOrCreateBuffer(0);
        VertexArrayBuilder format = vertexArray.editFormat();
        format.defineVertexBuffer(0, vbo, 0, 24, 0);
        format.setVertexAttribute(0, 0, 3, VertexArrayBuilder.DataType.FLOAT, false, 0);
        format.setVertexAttribute(1, 0, 2, VertexArrayBuilder.DataType.FLOAT, false, 12);
        format.setVertexAttribute(2, 0, 3, VertexArrayBuilder.DataType.BYTE, true, 20);
        format.setVertexIAttribute(3, 0, 1, VertexArrayBuilder.DataType.UNSIGNED_BYTE, 23);
        VertexArray.unbind();
        return vertexArray;
    }

    public void free() {
        this.vertexArray.free();
    }

    public static Builder builder(int textureWidth, int textureHeight) {
        return new Builder(textureWidth, textureHeight);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/render/Skin$Builder.class */
    public static class Builder {
        private static final Vector3f POS = new Vector3f();
        private static final Vector3f NORMAL = new Vector3f();
        private final float textureWidth;
        private final float textureHeight;
        private final VertexArray vertexArray = Skin.createVertexArray();
        private final ByteBufferBuilder vertices = new ByteBufferBuilder(147456);
        private final IntList indices = new IntArrayList();
        private final List<String> boneNames = new ArrayList();
        private final Matrix4f position = new Matrix4f();
        private final Matrix3f normal = new Matrix3f();
        private int nextIndex = 0;

        private Builder(float textureWidth, float textureHeight) {
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
        }

        private static byte normalIntValue(float value) {
            return (byte) (((int) (Mth.clamp(value, -1.0f, 1.0f) * 127.0f)) & 255);
        }

        public Builder startBone(String boneId) {
            if (this.boneNames.contains(boneId)) {
                throw new IllegalStateException("Bone '" + boneId + "' has already defined mesh data");
            }
            if (this.boneNames.size() >= 256) {
                throw new IllegalStateException("Too many bones defined. Max is 256");
            }
            this.boneNames.add(boneId);
            return this;
        }

        public Builder setTransform(MatrixStack stack) {
            return setTransform((Matrix4fc) stack.position());
        }

        public Builder setTransform(PoseStack stack) {
            return setTransform(stack.last());
        }

        public Builder setTransform(PoseStack.Pose pose) {
            return setTransform((Matrix4fc) pose.pose());
        }

        public Builder setTransform(Matrix4fc position) {
            this.position.set(position);
            this.position.normal(this.normal);
            return this;
        }

        public Builder addVertex(float x, float y, float z, float u, float v, float normalX, float normalY, float normalZ) {
            if (this.boneNames.isEmpty()) {
                throw new IllegalStateException("No bone specified. Call #startBone(String) to start building a mesh.");
            }
            this.position.transformPosition(x, y, z, POS);
            this.normal.transform(normalX, normalY, normalZ, NORMAL);
            long pointer = this.vertices.reserve(24);
            MemoryUtil.memPutFloat(pointer, POS.x);
            MemoryUtil.memPutFloat(pointer + 4, POS.y);
            MemoryUtil.memPutFloat(pointer + 8, POS.z);
            MemoryUtil.memPutFloat(pointer + 12, u);
            MemoryUtil.memPutFloat(pointer + 16, v);
            MemoryUtil.memPutByte(pointer + 20, normalIntValue(NORMAL.x));
            MemoryUtil.memPutByte(pointer + 21, normalIntValue(NORMAL.y));
            MemoryUtil.memPutByte(pointer + 22, normalIntValue(NORMAL.z));
            MemoryUtil.memPutByte(pointer + 23, (byte) (this.boneNames.size() - 1));
            return this;
        }

        public Builder addIndex(int index) {
            this.indices.add(index);
            if (index > this.nextIndex) {
                this.nextIndex = index + 1;
            }
            return this;
        }

        public Builder addQuadIndices(int index) {
            addIndex(index);
            addIndex(index + 1);
            addIndex(index + 2);
            addIndex(index + 2);
            addIndex(index + 3);
            addIndex(index);
            return this;
        }

        public Builder addCube(float xSize, float ySize, float zSize, float xOffset, float yOffset, float zOffset, float xInflate, float yInflate, float zInflate, float uOffset, float vOffset, boolean mirrored) {
            float minX = xOffset - xInflate;
            float minY = yOffset - yInflate;
            float minZ = zOffset - zInflate;
            float maxX = xOffset + xSize + xInflate;
            float maxY = yOffset + ySize + yInflate;
            float maxZ = zOffset + zSize + zInflate;
            float u1 = uOffset + zSize;
            float u2 = u1 + xSize;
            float u3 = u2 + zSize;
            float u4 = u3 + xSize;
            float u0 = uOffset / this.textureWidth;
            float u12 = u1 / this.textureWidth;
            float u22 = u2 / this.textureWidth;
            float u32 = u3 / this.textureWidth;
            float u42 = u4 / this.textureWidth;
            float topBottomU0 = uOffset + zSize;
            float topBottomU1 = topBottomU0 + xSize;
            float topBottomU2 = topBottomU1 + xSize;
            float topBottomU02 = topBottomU0 / this.textureWidth;
            float topBottomU12 = topBottomU1 / this.textureWidth;
            float topBottomU22 = topBottomU2 / this.textureWidth;
            float v1 = vOffset + zSize;
            float v2 = v1 + ySize;
            float v0 = vOffset / this.textureHeight;
            float v12 = v1 / this.textureHeight;
            float v22 = v2 / this.textureHeight;
            if (!mirrored) {
                addVertex(minX, maxY, minZ, topBottomU12, v12, 0.0f, 1.0f, 0.0f);
                addVertex(minX, maxY, maxZ, topBottomU12, v0, 0.0f, 1.0f, 0.0f);
                addVertex(maxX, maxY, maxZ, topBottomU02, v0, 0.0f, 1.0f, 0.0f);
                addVertex(maxX, maxY, minZ, topBottomU02, v12, 0.0f, 1.0f, 0.0f);
                addVertex(maxX, minY, maxZ, topBottomU12, v0, 0.0f, -1.0f, 0.0f);
                addVertex(minX, minY, maxZ, topBottomU22, v0, 0.0f, -1.0f, 0.0f);
                addVertex(minX, minY, minZ, topBottomU22, v12, 0.0f, -1.0f, 0.0f);
                addVertex(maxX, minY, minZ, topBottomU12, v12, 0.0f, -1.0f, 0.0f);
                addVertex(maxX, minY, maxZ, u0, v22, 1.0f, 0.0f, 0.0f);
                addVertex(maxX, minY, minZ, u12, v22, 1.0f, 0.0f, 0.0f);
                addVertex(maxX, maxY, minZ, u12, v12, 1.0f, 0.0f, 0.0f);
                addVertex(maxX, maxY, maxZ, u0, v12, 1.0f, 0.0f, 0.0f);
                addVertex(minX, minY, minZ, u22, v22, -1.0f, 0.0f, 0.0f);
                addVertex(minX, minY, maxZ, u32, v22, -1.0f, 0.0f, 0.0f);
                addVertex(minX, maxY, maxZ, u32, v12, -1.0f, 0.0f, 0.0f);
                addVertex(minX, maxY, minZ, u22, v12, -1.0f, 0.0f, 0.0f);
                addVertex(maxX, minY, minZ, u12, v22, 0.0f, 0.0f, -1.0f);
                addVertex(minX, minY, minZ, u22, v22, 0.0f, 0.0f, -1.0f);
                addVertex(minX, maxY, minZ, u22, v12, 0.0f, 0.0f, -1.0f);
                addVertex(maxX, maxY, minZ, u12, v12, 0.0f, 0.0f, -1.0f);
                addVertex(minX, minY, maxZ, u32, v22, 0.0f, 0.0f, 1.0f);
                addVertex(maxX, minY, maxZ, u42, v22, 0.0f, 0.0f, 1.0f);
                addVertex(maxX, maxY, maxZ, u42, v12, 0.0f, 0.0f, 1.0f);
                addVertex(minX, maxY, maxZ, u32, v12, 0.0f, 0.0f, 1.0f);
            } else {
                addVertex(minX, maxY, minZ, topBottomU02, v12, 0.0f, 1.0f, 0.0f);
                addVertex(minX, maxY, maxZ, topBottomU02, v0, 0.0f, 1.0f, 0.0f);
                addVertex(maxX, maxY, maxZ, topBottomU12, v0, 0.0f, 1.0f, 0.0f);
                addVertex(maxX, maxY, minZ, topBottomU12, v12, 0.0f, 1.0f, 0.0f);
                addVertex(maxX, minY, maxZ, topBottomU22, v0, 0.0f, -1.0f, 0.0f);
                addVertex(minX, minY, maxZ, topBottomU12, v0, 0.0f, -1.0f, 0.0f);
                addVertex(minX, minY, minZ, topBottomU12, v12, 0.0f, -1.0f, 0.0f);
                addVertex(maxX, minY, minZ, topBottomU22, v12, 0.0f, -1.0f, 0.0f);
                addVertex(maxX, minY, maxZ, u32, v22, 1.0f, 0.0f, 0.0f);
                addVertex(maxX, minY, minZ, u22, v22, 1.0f, 0.0f, 0.0f);
                addVertex(maxX, maxY, minZ, u22, v12, 1.0f, 0.0f, 0.0f);
                addVertex(maxX, maxY, maxZ, u32, v12, 1.0f, 0.0f, 0.0f);
                addVertex(minX, minY, minZ, u12, v22, -1.0f, 0.0f, 0.0f);
                addVertex(minX, minY, maxZ, u0, v22, -1.0f, 0.0f, 0.0f);
                addVertex(minX, maxY, maxZ, u0, v12, -1.0f, 0.0f, 0.0f);
                addVertex(minX, maxY, minZ, u12, v12, -1.0f, 0.0f, 0.0f);
                addVertex(maxX, minY, minZ, u22, v22, 0.0f, 0.0f, -1.0f);
                addVertex(minX, minY, minZ, u12, v22, 0.0f, 0.0f, -1.0f);
                addVertex(minX, maxY, minZ, u12, v12, 0.0f, 0.0f, -1.0f);
                addVertex(maxX, maxY, minZ, u22, v12, 0.0f, 0.0f, -1.0f);
                addVertex(minX, minY, maxZ, u42, v22, 0.0f, 0.0f, 1.0f);
                addVertex(maxX, minY, maxZ, u32, v22, 0.0f, 0.0f, 1.0f);
                addVertex(maxX, maxY, maxZ, u32, v12, 0.0f, 0.0f, 1.0f);
                addVertex(minX, maxY, maxZ, u42, v12, 0.0f, 0.0f, 1.0f);
            }
            for (int i = 0; i < 6; i++) {
                addQuadIndices(nextIndex());
            }
            return this;
        }

        public Builder addTri(float x1, float y1, float z1, float u1, float v1, float x2, float y2, float z2, float u2, float v2, float x3, float y3, float z3, float u3, float v3, float normalX, float normalY, float normalZ) {
            this.vertices.reserve(72);
            addVertex(x1, y1, z1, u1, v1, normalX, normalY, normalZ);
            addVertex(x2, y2, z2, u2, v2, normalX, normalY, normalZ);
            addVertex(x3, y3, z3, u3, v3, normalX, normalY, normalZ);
            addIndex(nextIndex());
            addIndex(nextIndex());
            addIndex(nextIndex());
            return this;
        }

        public Builder addFace(float x1, float y1, float z1, float u1, float v1, float x2, float y2, float z2, float u2, float v2, float x3, float y3, float z3, float u3, float v3, float x4, float y4, float z4, float u4, float v4, float normalX, float normalY, float normalZ) {
            this.vertices.reserve(96);
            addVertex(x1, y1, z1, u1, v1, normalX, normalY, normalZ);
            addVertex(x2, y2, z2, u2, v2, normalX, normalY, normalZ);
            addVertex(x3, y3, z3, u3, v3, normalX, normalY, normalZ);
            addVertex(x4, y4, z4, u4, v4, normalX, normalY, normalZ);
            addQuadIndices(nextIndex());
            return this;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        private void storeIndices(VertexArray.IndexType indexType, ByteBuffer buffer) {
            for (int i = 0; i < this.indices.size(); i++) {
                int index = this.indices.getInt(i);
                switch (indexType) {
                    case BYTE:
                        buffer.put(i, (byte) index);
                        break;
                    case SHORT:
                        buffer.putShort(i * 2, (short) index);
                        break;
                    case INT:
                        buffer.putInt(i * 4, index);
                        break;
                }
            }
        }

        public Skin build() {
            ByteBuffer indices = null;
            try {
                ByteBufferBuilder byteBufferBuilder = this.vertices;
                try {
                    ByteBufferBuilder.Result result = this.vertices.build();
                    try {
                        if (result == null) {
                            throw new IllegalStateException("No mesh data provides to skin");
                        }
                        int vertexBuffer = this.vertexArray.getOrCreateBuffer(0);
                        VertexArray.upload(vertexBuffer, result.byteBuffer(), VertexArray.DrawUsage.STATIC);
                        VertexArray.IndexType indexType = VertexArray.IndexType.least(this.nextIndex - 1);
                        indices = MemoryUtil.memAlloc(this.indices.size() << indexType.ordinal());
                        storeIndices(indexType, indices);
                        this.vertexArray.uploadIndexBuffer(indices, indexType);
                        Object2IntArrayMap object2IntArrayMap = new Object2IntArrayMap(this.boneNames.size());
                        for (int i = 0; i < this.boneNames.size(); i++) {
                            object2IntArrayMap.put(this.boneNames.get(i), i);
                        }
                        Skin skin = new Skin(this.vertexArray, Object2IntMaps.unmodifiable(object2IntArrayMap));
                        if (result != null) {
                            result.close();
                        }
                        if (byteBufferBuilder != null) {
                            byteBufferBuilder.close();
                        }
                        return skin;
                    } catch (Throwable th) {
                        if (result != null) {
                            try {
                                result.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } finally {
                MemoryUtil.memFree(indices);
            }
        }
    }
}
