package foundry.veil.api.client.render.light.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.MeshData;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.light.InstancedLightData;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.api.client.render.vertex.VertexArrayBuilder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/light/renderer/InstancedLightRenderer.class */
public abstract class InstancedLightRenderer<T extends LightData & InstancedLightData> implements LightTypeRenderer<T> {
    private static final int MAX_UPLOADS = 400;
    protected final int lightSize;
    protected int maxLights = 0;
    private final List<InstancedLightRenderer<T>.LightHandle> lights = new ArrayList();
    private final List<InstancedLightRenderer<T>.LightHandle> visibleLights = new ArrayList();
    private final List<InstancedLightRenderer<T>.LightHandle> lastVisibleLights = new ArrayList();
    private final VertexArray vertexArray = VertexArray.create();
    private final int instancedVbo;
    private boolean freed;

    protected abstract MeshData createMesh();

    protected abstract void setupBufferState(VertexArrayBuilder vertexArrayBuilder);

    @Nullable
    protected abstract RenderType getRenderType(List<? extends LightRenderHandle<T>> list);

    public InstancedLightRenderer(int lightSize) {
        this.lightSize = lightSize;
        MeshData mesh = createMesh();
        this.vertexArray.upload(mesh, VertexArray.DrawUsage.STATIC);
        this.instancedVbo = this.vertexArray.getOrCreateBuffer(2);
        VertexArrayBuilder builder = this.vertexArray.editFormat();
        builder.defineVertexBuffer(2, this.instancedVbo, 0, this.lightSize, 1);
        setupBufferState(builder);
    }

    private void updateAllLights() {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            int pointer = 0;
            long offset = 0;
            ByteBuffer dataBuffer = stack.malloc(Math.min(400, this.visibleLights.size()) * this.lightSize);
            for (InstancedLightRenderer<T>.LightHandle handle : this.visibleLights) {
                int i = pointer;
                pointer++;
                dataBuffer.position(i * this.lightSize);
                ((LightHandle) handle).data.store(dataBuffer);
                ((LightHandle) handle).uploadedRevision = ((LightHandle) handle).data.getRevision();
                if (pointer >= 400) {
                    dataBuffer.rewind();
                    GL15C.glBufferSubData(34962, offset, dataBuffer);
                    offset += (long) dataBuffer.capacity();
                    pointer = 0;
                }
            }
            if (pointer > 0) {
                dataBuffer.rewind();
                GL15C.nglBufferSubData(34962, offset, ((long) pointer) * ((long) this.lightSize), MemoryUtil.memAddress(dataBuffer));
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

    private void updateDirtyLights() {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            ByteBuffer dataBuffer = stack.malloc(this.lightSize);
            for (int i = 0; i < this.visibleLights.size(); i++) {
                InstancedLightRenderer<T>.LightHandle handle = this.visibleLights.get(i);
                long revision = ((LightHandle) handle).data.getRevision();
                if (((LightHandle) handle).uploadedRevision != revision) {
                    dataBuffer.clear();
                    ((LightHandle) handle).data.store(dataBuffer);
                    dataBuffer.rewind();
                    GL15C.nglBufferSubData(34962, ((long) i) * ((long) this.lightSize), this.lightSize, MemoryUtil.memAddress(dataBuffer));
                    ((LightHandle) handle).uploadedRevision = revision;
                }
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

    private boolean visibleLightsChanged() {
        if (this.visibleLights.size() != this.lastVisibleLights.size()) {
            return true;
        }
        for (int i = 0; i < this.visibleLights.size(); i++) {
            if (this.visibleLights.get(i) != this.lastVisibleLights.get(i)) {
                return true;
            }
        }
        return false;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public LightRenderHandle<T> addLight(T light) {
        InstancedLightRenderer<T>.LightHandle lightHandle = new LightHandle(light);
        this.lights.add(lightHandle);
        return lightHandle;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public LightRenderHandle<T> steal(LightRenderHandle<T> handle) {
        if (!(handle instanceof LightHandle)) {
            handle.free();
            return addLight(handle.getLightData());
        }
        return handle;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public void prepareLights(LightRenderer lightRenderer, CullFrustum frustum) {
        this.visibleLights.clear();
        for (InstancedLightRenderer<T>.LightHandle lightHandle : this.lights) {
            if (((LightHandle) lightHandle).data.isVisible(frustum)) {
                this.visibleLights.add(lightHandle);
            }
        }
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public void renderLights(LightRenderer lightRenderer) {
        RenderType renderType;
        if (this.visibleLights.isEmpty() || (renderType = getRenderType(this.visibleLights)) == null) {
            return;
        }
        RenderSystem.glBindBuffer(34962, this.instancedVbo);
        boolean resized = false;
        if (this.visibleLights.size() > this.maxLights) {
            if (this.maxLights < 100) {
                this.maxLights = 100;
            } else {
                this.maxLights = (int) Math.max(Math.ceil(((double) this.maxLights) / 2.0d), ((double) this.visibleLights.size()) * 1.5d);
            }
            GL15C.glBufferData(34962, ((long) this.maxLights) * ((long) this.lightSize), 35040);
            resized = true;
        }
        if (resized || visibleLightsChanged()) {
            updateAllLights();
            this.lastVisibleLights.clear();
            this.lastVisibleLights.addAll(this.visibleLights);
        } else {
            updateDirtyLights();
        }
        this.vertexArray.bind();
        this.vertexArray.drawInstancedWithRenderType(renderType, this.visibleLights.size());
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public List<? extends LightRenderHandle<T>> getLights() {
        return this.lights;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public int getVisibleLights() {
        return this.visibleLights.size();
    }

    public void free() {
        this.vertexArray.free();
        this.freed = true;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/light/renderer/InstancedLightRenderer$LightHandle.class */
    private class LightHandle implements LightRenderHandle<T> {
        private final T data;
        private long uploadedRevision;

        private LightHandle(T data) {
            this.data = data;
            this.uploadedRevision = data.getRevision() - 1;
        }

        @Override // foundry.veil.api.client.render.light.renderer.LightRenderHandle
        public T getLightData() {
            return this.data;
        }

        @Override // foundry.veil.api.client.render.light.renderer.LightRenderHandle
        public void markDirty() {
            this.data.markDirty();
        }

        @Override // foundry.veil.api.client.render.light.renderer.LightRenderHandle
        public boolean isValid() {
            return !InstancedLightRenderer.this.freed;
        }

        public void free() {
            InstancedLightRenderer.this.lights.remove(this);
            InstancedLightRenderer.this.lastVisibleLights.remove(this);
        }
    }
}
