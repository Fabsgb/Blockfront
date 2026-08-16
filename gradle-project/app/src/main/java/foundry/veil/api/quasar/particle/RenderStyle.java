package foundry.veil.api.quasar.particle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.serialization.Codec;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.vertex.VeilVertexFormat;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import foundry.veil.api.quasar.registry.RenderStyleRegistry;
import foundry.veil.api.util.CodecUtil;
import java.nio.ByteBuffer;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/particle/RenderStyle.class */
public abstract class RenderStyle implements NativeResource {
    public static final Codec<RenderStyle> CODEC = CodecUtil.registryOrLegacyCodec(RenderStyleRegistry.REGISTRY);
    protected VertexArray vertexArray;
    protected int instanceVBO;
    protected final int bufferSize;
    protected int maxParticles = 0;
    public static final int MIN_PARTICLES = 400;

    protected abstract MeshData createMesh();

    protected abstract void setupBufferState(VertexArrayBuilder vertexArrayBuilder);

    protected abstract void putBufferData(QuasarParticle quasarParticle, Camera camera, ByteBuffer byteBuffer);

    public RenderStyle(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void init() {
        if (this.bufferSize <= 0) {
            return;
        }
        this.vertexArray = VertexArray.create();
        this.vertexArray.upload(createMesh(), VertexArray.DrawUsage.STATIC);
        this.instanceVBO = this.vertexArray.getOrCreateBuffer(2);
        VertexArrayBuilder builder = this.vertexArray.editFormat();
        builder.defineVertexBuffer(2, this.instanceVBO, 0, this.bufferSize, 1);
        setupBufferState(builder);
    }

    public boolean setup(int particleCount) {
        return true;
    }

    public void clear() {
    }

    public void render(List<QuasarParticle> particles, Camera camera) {
        RenderType renderType;
        if (particles.isEmpty() || (renderType = ((QuasarParticle) particles.getFirst()).getRenderData().getRenderType()) == null) {
            return;
        }
        List<QuasarParticle> visibleParticles = particles.stream().filter(particle -> {
            return VeilRenderSystem.getCullingFrustum().testSphere((Vector3dc) particle.getPosition(), particle.getRenderData().getRenderRadius());
        }).toList();
        if (visibleParticles.isEmpty()) {
            return;
        }
        RenderSystem.glBindBuffer(34962, this.instanceVBO);
        if (visibleParticles.size() > this.maxParticles) {
            if (this.maxParticles < 100) {
                this.maxParticles = 100;
            } else {
                this.maxParticles = (int) Math.max(Math.ceil(((double) this.maxParticles) / 2.0d), ((double) visibleParticles.size()) * 1.5d);
            }
            GL15C.glBufferData(34962, ((long) this.maxParticles) * ((long) this.bufferSize), 35044);
        }
        MemoryStack stack = MemoryStack.stackPush();
        try {
            int pointer = 0;
            long offset = 0;
            ByteBuffer dataBuffer = stack.malloc(Math.min(400, visibleParticles.size()) * this.bufferSize);
            for (QuasarParticle particle2 : visibleParticles) {
                int i = pointer;
                pointer++;
                dataBuffer.position(i * this.bufferSize);
                putBufferData(particle2, camera, dataBuffer);
                if (pointer >= 400) {
                    dataBuffer.rewind();
                    GL15C.glBufferSubData(34962, offset, dataBuffer);
                    offset += (long) dataBuffer.capacity();
                    pointer = 0;
                }
            }
            if (pointer > 0) {
                dataBuffer.rewind();
                GL15C.nglBufferSubData(34962, offset, ((long) pointer) * ((long) this.bufferSize), MemoryUtil.memAddress(dataBuffer));
            }
            if (stack != null) {
                stack.close();
            }
            this.vertexArray.bind();
            this.vertexArray.drawInstancedWithRenderType(renderType, visibleParticles.size());
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

    public RenderType getRenderType(QuasarParticle particle, RenderData renderData) {
        boolean additive = renderData.isAdditive();
        TextureAtlasSprite atlasSprite = renderData.getAtlasSprite();
        if (atlasSprite != null) {
            return VeilRenderType.quasarParticle(atlasSprite.atlasLocation(), additive);
        }
        SpriteData spriteData = renderData.getSpriteData();
        if (spriteData != null) {
            return VeilRenderType.quasarParticle(spriteData.sprite(), additive);
        }
        return VeilRenderType.quasarParticle(RenderData.BLANK, additive);
    }

    public void free() {
        this.vertexArray.free();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/particle/RenderStyle$Cube.class */
    @ApiStatus.Internal
    public static final class Cube extends RenderStyle {
        private static final Vector3fc[] CUBE_POSITIONS = {new Vector3f(1.0f, 1.0f, -1.0f), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(-1.0f, 1.0f, 1.0f), new Vector3f(-1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, 1.0f), new Vector3f(-1.0f, 1.0f, 1.0f), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, -1.0f), new Vector3f(1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, -1.0f, -1.0f), new Vector3f(-1.0f, 1.0f, -1.0f), new Vector3f(-1.0f, 1.0f, 1.0f), new Vector3f(-1.0f, -1.0f, 1.0f), new Vector3f(1.0f, -1.0f, 1.0f), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(1.0f, 1.0f, -1.0f), new Vector3f(1.0f, -1.0f, -1.0f)};
        private static final float[] CUBE_NORMALS = {0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

        public Cube() {
            super(104);
        }

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        protected MeshData createMesh() {
            BufferBuilder builder = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, VeilVertexFormat.QUASAR_PARTICLE);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    Vector3fc pos = CUBE_POSITIONS[(i * 4) + j];
                    builder.addVertex(pos.x(), pos.y(), pos.z());
                    builder.setNormal(CUBE_NORMALS[i * 3], CUBE_NORMALS[(i * 3) + 1], CUBE_NORMALS[(i * 3) + 2]);
                }
            }
            return builder.buildOrThrow();
        }

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        protected void setupBufferState(VertexArrayBuilder builder) {
            builder.setVertexAttribute(2, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 0);
            builder.setVertexAttribute(3, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 16);
            builder.setVertexAttribute(4, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 32);
            builder.setVertexAttribute(5, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 48);
            builder.setVertexAttribute(6, 2, 1, VertexArrayBuilder.DataType.FLOAT, false, 64);
            builder.setVertexAttribute(7, 2, 2, VertexArrayBuilder.DataType.FLOAT, false, 68);
            builder.setVertexAttribute(8, 2, 2, VertexArrayBuilder.DataType.FLOAT, false, 76);
            builder.setVertexAttribute(9, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 84);
            builder.setVertexIAttribute(10, 2, 2, VertexArrayBuilder.DataType.SHORT, 100);
        }

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        protected void putBufferData(QuasarParticle particle, Camera camera, ByteBuffer buffer) {
            RenderData renderData = particle.getRenderData();
            Vector3fc rotation = renderData.getRenderRotation();
            SpriteData spriteData = renderData.getSpriteData();
            Vec3 projectedView = camera.getPosition();
            Vector3f renderOffset = new Vector3f();
            Vector3dc renderPosition = renderData.getRenderPosition();
            renderOffset.set((float) (renderPosition.x() - projectedView.x), (float) (renderPosition.y() - projectedView.y), (float) (renderPosition.z() - projectedView.z));
            Matrix4f transformationMatrix = new Matrix4f().translate(renderOffset.x, renderOffset.y, renderOffset.z).rotate(new Quaternionf().rotateLocalX(rotation.x()).rotateLocalY(rotation.y()).rotateLocalZ(rotation.z()));
            transformationMatrix.get(buffer.position(), buffer);
            buffer.position(buffer.position() + 64);
            buffer.putFloat(renderData.getRenderRadius());
            float uMin = 0.0f;
            float vMin = 0.0f;
            float uMax = 1.0f;
            float vMax = 1.0f;
            if (spriteData != null) {
                uMin = spriteData.m8344u(renderData.getRenderAge(), renderData.getAgePercent(), 0.0f);
                uMax = spriteData.m8344u(renderData.getRenderAge(), renderData.getAgePercent(), 1.0f);
                vMin = spriteData.m8345v(renderData.getRenderAge(), renderData.getAgePercent(), 0.0f);
                vMax = spriteData.m8345v(renderData.getRenderAge(), renderData.getAgePercent(), 1.0f);
            }
            buffer.putFloat(uMin);
            buffer.putFloat(vMin);
            buffer.putFloat(uMax);
            buffer.putFloat(vMax);
            buffer.putFloat(renderData.getRed());
            buffer.putFloat(renderData.getGreen());
            buffer.putFloat(renderData.getBlue());
            buffer.putFloat(renderData.getAlpha());
            int packedLight = renderData.getPackedLight();
            buffer.putShort((short) (packedLight & 65535));
            buffer.putShort((short) ((packedLight >> 16) & 65535));
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/particle/RenderStyle$Billboard.class */
    @ApiStatus.Internal
    public static final class Billboard extends RenderStyle {
        private static final Vector3fc[] PLANE_POSITIONS = {new Vector3f(1.0f, -1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(-1.0f, -1.0f, 0.0f)};

        public Billboard() {
            super(104);
        }

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        protected MeshData createMesh() {
            BufferBuilder builder = RenderSystem.renderThreadTesselator().begin(VertexFormat.Mode.QUADS, VeilVertexFormat.QUASAR_PARTICLE);
            for (int j = 0; j < 4; j++) {
                Vector3fc pos = PLANE_POSITIONS[j];
                builder.addVertex(pos.x(), pos.y(), pos.z());
                builder.setNormal(0.0f, 0.0f, -1.0f);
            }
            return builder.buildOrThrow();
        }

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        protected void setupBufferState(VertexArrayBuilder builder) {
            builder.setVertexAttribute(2, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 0);
            builder.setVertexAttribute(3, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 16);
            builder.setVertexAttribute(4, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 32);
            builder.setVertexAttribute(5, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 48);
            builder.setVertexAttribute(6, 2, 1, VertexArrayBuilder.DataType.FLOAT, false, 64);
            builder.setVertexAttribute(7, 2, 2, VertexArrayBuilder.DataType.FLOAT, false, 68);
            builder.setVertexAttribute(8, 2, 2, VertexArrayBuilder.DataType.FLOAT, false, 76);
            builder.setVertexAttribute(9, 2, 4, VertexArrayBuilder.DataType.FLOAT, false, 84);
            builder.setVertexIAttribute(10, 2, 2, VertexArrayBuilder.DataType.SHORT, 100);
        }

        @Override // foundry.veil.api.quasar.particle.RenderStyle
        protected void putBufferData(QuasarParticle particle, Camera camera, ByteBuffer buffer) {
            RenderData renderData = particle.getRenderData();
            Quaternionf faceCameraRotation = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation().get(new Quaternionf());
            Vector3fc rotation = renderData.getRenderRotation();
            SpriteData spriteData = renderData.getSpriteData();
            Vec3 projectedView = camera.getPosition();
            Vector3f renderOffset = new Vector3f();
            Vector3dc renderPosition = renderData.getRenderPosition();
            renderOffset.set((float) (renderPosition.x() - projectedView.x), (float) (renderPosition.y() - projectedView.y), (float) (renderPosition.z() - projectedView.z));
            Matrix4f transformationMatrix = new Matrix4f().translate(renderOffset.x, renderOffset.y, renderOffset.z).rotate(faceCameraRotation.rotateLocalX(rotation.x()).rotateLocalY(rotation.y()).rotateLocalZ(rotation.z()));
            transformationMatrix.get(buffer.position(), buffer);
            buffer.position(buffer.position() + 64);
            buffer.putFloat(renderData.getRenderRadius());
            float uMin = 0.0f;
            float vMin = 0.0f;
            float uMax = 1.0f;
            float vMax = 1.0f;
            if (spriteData != null) {
                uMin = spriteData.m8344u(renderData.getRenderAge(), renderData.getAgePercent(), 0.0f);
                uMax = spriteData.m8344u(renderData.getRenderAge(), renderData.getAgePercent(), 1.0f);
                vMin = spriteData.m8345v(renderData.getRenderAge(), renderData.getAgePercent(), 0.0f);
                vMax = spriteData.m8345v(renderData.getRenderAge(), renderData.getAgePercent(), 1.0f);
            }
            buffer.putFloat(uMin);
            buffer.putFloat(vMin);
            buffer.putFloat(uMax);
            buffer.putFloat(vMax);
            buffer.putFloat(renderData.getRed());
            buffer.putFloat(renderData.getGreen());
            buffer.putFloat(renderData.getBlue());
            buffer.putFloat(renderData.getAlpha());
            int packedLight = renderData.getPackedLight();
            buffer.putShort((short) (packedLight & 65535));
            buffer.putShort((short) ((packedLight >> 16) & 65535));
        }
    }
}
