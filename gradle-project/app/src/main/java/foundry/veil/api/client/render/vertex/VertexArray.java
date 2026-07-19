package foundry.veil.api.client.render.vertex;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.impl.client.render.vertex.ARBVertexArray;
import foundry.veil.impl.client.render.vertex.DSAVertexArray;
import foundry.veil.impl.client.render.vertex.LegacyVertexArray;
import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.function.Function;
import java.util.function.IntFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.ARBMultiDrawIndirect;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GL31C;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArray.class */
public abstract class VertexArray implements NativeResource {
    public static final int VERTEX_BUFFER = 0;
    public static final int ELEMENT_ARRAY_BUFFER = 1;
    private static VertexArrayType vertexArrayType;
    protected final int id;
    protected final VertexArrayBuilder builder;
    protected final Int2IntMap buffers = new Int2IntArrayMap();
    protected int indexCount = 0;
    protected IndexType indexType = IndexType.BYTE;
    protected VertexFormat.Mode drawMode = VertexFormat.Mode.TRIANGLES;

    @Nullable
    protected RenderSystem.AutoStorageIndexBuffer indexBuffer;

    @ApiStatus.Internal
    protected VertexArray(int id, Function<VertexArray, VertexArrayBuilder> builder) {
        this.id = id;
        this.builder = builder.apply(this);
    }

    private static void loadType() {
        if (vertexArrayType == null) {
            if (VeilRenderSystem.directStateAccessSupported()) {
                vertexArrayType = VertexArrayType.DSA;
                return;
            }
            GLCapabilities caps = GL.getCapabilities();
            if (caps.OpenGL43 || caps.GL_ARB_vertex_attrib_binding) {
                vertexArrayType = VertexArrayType.ARB;
            } else {
                vertexArrayType = VertexArrayType.LEGACY;
            }
        }
    }

    public static VertexArray create() {
        RenderSystem.assertOnRenderThreadOrInit();
        loadType();
        return vertexArrayType.factory.apply(VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateVertexArrays() : GL30C.glGenVertexArrays());
    }

    public static VertexArray[] create(int count) {
        VertexArray[] fill = new VertexArray[count];
        create(fill);
        return fill;
    }

    public static void create(VertexArray[] fill) {
        RenderSystem.assertOnRenderThreadOrInit();
        if (fill.length == 0) {
            return;
        }
        loadType();
        MemoryStack stack = MemoryStack.stackPush();
        try {
            IntBuffer arrays = stack.mallocInt(fill.length);
            if (VeilRenderSystem.directStateAccessSupported()) {
                ARBDirectStateAccess.glCreateVertexArrays(arrays);
            } else {
                GL30C.glGenVertexArrays(arrays);
            }
            for (int i = 0; i < arrays.limit(); i++) {
                fill[i] = vertexArrayType.factory.apply(arrays.get(i));
            }
            if (stack != null) {
                stack.close();
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

    public void setup(RenderType renderType) {
        renderType.setupRenderState();
        ShaderInstance shader = RenderSystem.getShader();
        if (shader != null) {
            shader.setDefaultUniforms(this.drawMode, RenderSystem.getModelViewMatrix(), RenderSystem.getProjectionMatrix(), Minecraft.getInstance().getWindow());
            shader.apply();
        }
    }

    public void clear(RenderType renderType) {
        ShaderInstance shader = RenderSystem.getShader();
        if (shader != null) {
            shader.clear();
        }
        renderType.clearRenderState();
    }

    public int getOrCreateBuffer(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return this.buffers.computeIfAbsent(index, unused -> {
            return GlStateManager._glGenBuffers();
        });
    }

    public int getId() {
        return this.id;
    }

    public int getIndexCount() {
        return this.indexCount;
    }

    public IndexType getIndexType() {
        return this.indexType;
    }

    public VertexFormat.Mode getDrawMode() {
        return this.drawMode;
    }

    public static void upload(int buffer, ByteBuffer data, DrawUsage usage) {
        if (VeilRenderSystem.directStateAccessSupported()) {
            ARBDirectStateAccess.glNamedBufferData(buffer, data, usage.getGlType());
            return;
        }
        GL15C.glBindBuffer(34962, buffer);
        GL15C.glBufferData(34962, data, usage.getGlType());
        GL15C.glBindBuffer(34962, 0);
    }

    public void upload(MeshData meshData, DrawUsage usage) {
        upload(0, meshData, usage);
    }

    public void upload(int attributeStart, MeshData meshData, DrawUsage usage) {
        try {
            RenderSystem.assertOnRenderThread();
            MeshData.DrawState drawState = meshData.drawState();
            VertexArrayBuilder builder = editFormat();
            int vertexBuffer = getOrCreateBuffer(0);
            upload(vertexBuffer, meshData.vertexBuffer(), usage);
            builder.applyFrom(0, vertexBuffer, attributeStart, drawState.format());
            ByteBuffer indexBuffer = meshData.indexBuffer();
            if (indexBuffer != null) {
                uploadIndexBuffer(indexBuffer);
            } else {
                uploadIndexBuffer(drawState);
            }
            this.indexCount = drawState.indexCount();
            this.indexType = IndexType.fromBlaze3D(drawState.indexType());
            this.drawMode = drawState.mode();
            if (meshData != null) {
                meshData.close();
            }
        } catch (Throwable th) {
            if (meshData != null) {
                try {
                    meshData.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void uploadIndexBuffer(MeshData.DrawState drawState) {
        this.indexBuffer = RenderSystem.getSequentialBuffer(drawState.mode());
        this.indexBuffer.bind(drawState.indexCount());
    }

    public void uploadIndexBuffer(ByteBuffer data) {
        this.indexBuffer = null;
        GlStateManager._glBindBuffer(34963, getOrCreateBuffer(1));
        RenderSystem.glBufferData(34963, data, 35044);
    }

    public void uploadIndexBuffer(ByteBuffer data, IndexType indexType) {
        uploadIndexBuffer(data);
        setIndexCount(data.remaining() >> indexType.ordinal(), indexType);
    }

    public VertexArrayBuilder editFormat() {
        bind();
        return this.builder;
    }

    public void bind() {
        IndexType expectedIndexType;
        VeilRenderSystem.bindVertexArray(this.id);
        if (this.indexBuffer != null && this.indexType != (expectedIndexType = IndexType.fromBlaze3D(this.indexBuffer.type()))) {
            this.indexBuffer.bind(this.indexCount);
            this.indexType = expectedIndexType;
        }
    }

    public static void unbind() {
        VeilRenderSystem.bindVertexArray(0);
    }

    public void draw() {
        ShaderProgram shader = VeilRenderSystem.getShader();
        if (shader != null && shader.hasTesselation() && shader.getProgram() == GL15C.glGetInteger(35725)) {
            if (this.drawMode == VertexFormat.Mode.QUADS) {
                GL15C.glDrawArrays(14, 0, (this.indexCount * 4) / 6);
                return;
            } else {
                GL15C.glDrawElements(14, this.indexCount, this.indexType.getGlType(), 0L);
                return;
            }
        }
        GL15C.glDrawElements(this.drawMode.asGLMode, this.indexCount, this.indexType.getGlType(), 0L);
    }

    public void drawInstanced(int instances) {
        ShaderProgram shader = VeilRenderSystem.getShader();
        if (shader != null && shader.hasTesselation() && shader.getProgram() == GL15C.glGetInteger(35725)) {
            if (this.drawMode == VertexFormat.Mode.QUADS) {
                GL31C.glDrawArraysInstanced(14, 0, (this.indexCount * 4) / 6, instances);
                return;
            } else {
                GL31C.glDrawElementsInstanced(14, this.indexCount, this.indexType.getGlType(), 0L, instances);
                return;
            }
        }
        GL31C.glDrawElementsInstanced(this.drawMode.asGLMode, this.indexCount, this.indexType.getGlType(), 0L, instances);
    }

    public void drawIndirect(long indirect, int drawCount, int stride) {
        if (!VeilRenderSystem.multiDrawIndirectSupported()) {
            throw new UnsupportedOperationException("Indirect rendering is not supported");
        }
        ARBMultiDrawIndirect.glMultiDrawElementsIndirect(this.drawMode.asGLMode, this.indexType.getGlType(), indirect, drawCount, stride);
    }

    public void drawWithRenderType(RenderType renderType) {
        while (renderType instanceof VeilRenderType.RenderTypeWrapper) {
            VeilRenderType.RenderTypeWrapper wrapper = (VeilRenderType.RenderTypeWrapper) renderType;
            renderType = wrapper.get();
        }
        if (renderType == null) {
            return;
        }
        setup(renderType);
        draw();
        clear(renderType);
        if (renderType instanceof VeilRenderType.LayeredRenderType) {
            VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
            for (RenderType layer : layeredRenderType.getLayers()) {
                setup(layer);
                draw();
                clear(layer);
            }
        }
    }

    public void drawInstancedWithRenderType(RenderType renderType, int instances) {
        while (renderType instanceof VeilRenderType.RenderTypeWrapper) {
            VeilRenderType.RenderTypeWrapper wrapper = (VeilRenderType.RenderTypeWrapper) renderType;
            renderType = wrapper.get();
        }
        if (renderType == null) {
            return;
        }
        setup(renderType);
        drawInstanced(instances);
        clear(renderType);
        if (renderType instanceof VeilRenderType.LayeredRenderType) {
            VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
            for (RenderType layer : layeredRenderType.getLayers()) {
                setup(layer);
                drawInstanced(instances);
                clear(layer);
            }
        }
    }

    public void drawIndirectWithRenderType(RenderType renderType, long indirect, int drawCount, int stride) {
        while (renderType instanceof VeilRenderType.RenderTypeWrapper) {
            VeilRenderType.RenderTypeWrapper wrapper = (VeilRenderType.RenderTypeWrapper) renderType;
            renderType = wrapper.get();
        }
        if (renderType == null) {
            return;
        }
        setup(renderType);
        drawIndirect(indirect, drawCount, stride);
        clear(renderType);
        if (renderType instanceof VeilRenderType.LayeredRenderType) {
            VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
            for (RenderType layer : layeredRenderType.getLayers()) {
                setup(layer);
                drawIndirect(indirect, drawCount, stride);
                clear(layer);
            }
        }
    }

    public void setIndexCount(int indexCount, IndexType indexType) {
        this.indexCount = indexCount;
        this.indexType = indexType;
    }

    public void setDrawMode(VertexFormat.Mode drawMode) {
        this.drawMode = drawMode;
    }

    public void free() {
        RenderSystem.assertOnRenderThreadOrInit();
        GL15C.glDeleteBuffers(this.buffers.values().toIntArray());
        GL30C.glDeleteVertexArrays(this.id);
        this.buffers.clear();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArray$VertexArrayType.class */
    private enum VertexArrayType {
        LEGACY(LegacyVertexArray::new),
        ARB(ARBVertexArray::new),
        DSA(DSAVertexArray::new);

        private final IntFunction<VertexArray> factory;

        VertexArrayType(IntFunction intFunction) {
            this.factory = intFunction;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArray$IndexType.class */
    public enum IndexType {
        BYTE(5121),
        SHORT(5123),
        INT(5125);

        private final int glType;
        private final int bytes = 1 << ordinal();

        IndexType(int glType) {
            this.glType = glType;
        }

        public int getGlType() {
            return this.glType;
        }

        public int getBytes() {
            return this.bytes;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public static IndexType fromBlaze3D(VertexFormat.IndexType type) throws MatchException {
            switch (AnonymousClass1.$SwitchMap$com$mojang$blaze3d$vertex$VertexFormat$IndexType[type.ordinal()]) {
                case 1:
                    return SHORT;
                case 2:
                    return INT;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }

        public static IndexType least(int maxIndex) {
            if ((maxIndex & (-256)) == 0) {
                return BYTE;
            }
            if ((maxIndex & (-65536)) == 0) {
                return SHORT;
            }
            return INT;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArray$DrawUsage.class */
    public enum DrawUsage {
        STATIC(35044),
        DYNAMIC(35048),
        STREAM(35040);

        private final int glType;

        DrawUsage(int glType) {
            this.glType = glType;
        }

        public int getGlType() {
            return this.glType;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public static DrawUsage fromBlaze3D(VertexBuffer.Usage type) throws MatchException {
            switch (AnonymousClass1.$SwitchMap$com$mojang$blaze3d$vertex$VertexBuffer$Usage[type.ordinal()]) {
                case 1:
                    return STATIC;
                case 2:
                    return DYNAMIC;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.render.vertex.VertexArray$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/vertex/VertexArray$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mojang$blaze3d$vertex$VertexFormat$IndexType;
        static final /* synthetic */ int[] $SwitchMap$com$mojang$blaze3d$vertex$VertexBuffer$Usage = new int[VertexBuffer.Usage.values().length];

        static {
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexBuffer$Usage[VertexBuffer.Usage.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexBuffer$Usage[VertexBuffer.Usage.DYNAMIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SwitchMap$com$mojang$blaze3d$vertex$VertexFormat$IndexType = new int[VertexFormat.IndexType.values().length];
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormat$IndexType[VertexFormat.IndexType.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mojang$blaze3d$vertex$VertexFormat$IndexType[VertexFormat.IndexType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
