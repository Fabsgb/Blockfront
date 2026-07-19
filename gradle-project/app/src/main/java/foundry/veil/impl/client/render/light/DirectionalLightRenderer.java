package foundry.veil.impl.client.render.light;

import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import foundry.veil.Veil;
import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.light.data.DirectionalLightData;
import foundry.veil.api.client.render.light.renderer.LightRenderHandle;
import foundry.veil.api.client.render.light.renderer.LightRenderer;
import foundry.veil.api.client.render.light.renderer.LightTypeRenderer;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.api.client.render.vertex.VertexArray;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/light/DirectionalLightRenderer.class */
@ApiStatus.Internal
public class DirectionalLightRenderer implements LightTypeRenderer<DirectionalLightData> {
    private static final Vector3f DIRECTION = new Vector3f();
    private static final ResourceLocation RENDER_TYPE = Veil.veilPath("light/directional");
    private final List<LightHandle> lights = new LinkedList();
    private final VertexArray vertexArray = VertexArray.create();
    private boolean freed;

    public DirectionalLightRenderer() {
        this.vertexArray.upload(createMesh(), VertexArray.DrawUsage.STATIC);
        VertexArray.unbind();
    }

    private static MeshData createMesh() {
        Tesselator tesselator = RenderSystem.renderThreadTesselator();
        BufferBuilder bufferBuilder = tesselator.begin(VertexFormat.Mode.TRIANGLE_STRIP, DefaultVertexFormat.POSITION);
        LightTypeRenderer.createQuad(bufferBuilder);
        return bufferBuilder.buildOrThrow();
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public LightRenderHandle<DirectionalLightData> addLight(DirectionalLightData light) {
        LightHandle handle = new LightHandle(light);
        this.lights.add(handle);
        return handle;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public LightRenderHandle<DirectionalLightData> steal(LightRenderHandle<DirectionalLightData> handle) {
        if (!(handle instanceof LightHandle)) {
            handle.free();
            return addLight((DirectionalLightData) handle.getLightData());
        }
        return handle;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public void prepareLights(LightRenderer lightRenderer, CullFrustum frustum) {
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public void renderLights(LightRenderer lightRenderer) {
        RenderType renderType;
        if (this.lights.isEmpty() || (renderType = VeilRenderType.get(RENDER_TYPE, new Object[0])) == null) {
            return;
        }
        this.vertexArray.bind();
        this.vertexArray.setup(renderType);
        render();
        this.vertexArray.clear(renderType);
        if (renderType instanceof VeilRenderType.LayeredRenderType) {
            VeilRenderType.LayeredRenderType layeredRenderType = (VeilRenderType.LayeredRenderType) renderType;
            for (RenderType layer : layeredRenderType.getLayers()) {
                this.vertexArray.setup(layer);
                render();
                this.vertexArray.clear(layer);
            }
        }
    }

    private void render() {
        ShaderInstance shader = RenderSystem.getShader();
        if (shader == null) {
            return;
        }
        for (LightHandle handle : this.lights) {
            DirectionalLightData light = handle.getLightData();
            Uniform lightColorUniform = shader.getUniform("LightColor");
            if (lightColorUniform != null) {
                Colorc lightColor = light.getColor();
                float brightness = light.getBrightness();
                lightColorUniform.set(lightColor.red() * brightness, lightColor.green() * brightness, lightColor.blue() * brightness);
                lightColorUniform.upload();
            }
            Uniform lightDirection = shader.getUniform("LightDirection");
            if (lightDirection != null) {
                lightDirection.set(light.getDirection().normalize(DIRECTION));
                lightDirection.upload();
            }
            this.vertexArray.draw();
        }
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public Collection<? extends LightRenderHandle<DirectionalLightData>> getLights() {
        return this.lights;
    }

    @Override // foundry.veil.api.client.render.light.renderer.LightTypeRenderer
    public int getVisibleLights() {
        return this.lights.size();
    }

    public void free() {
        this.vertexArray.close();
        this.freed = true;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/light/DirectionalLightRenderer$LightHandle.class */
    private class LightHandle implements LightRenderHandle<DirectionalLightData> {
        private final DirectionalLightData data;

        private LightHandle(DirectionalLightData data) {
            this.data = data;
        }

        @Override // foundry.veil.api.client.render.light.renderer.LightRenderHandle
        public DirectionalLightData getLightData() {
            return this.data;
        }

        @Override // foundry.veil.api.client.render.light.renderer.LightRenderHandle
        public void markDirty() {
        }

        @Override // foundry.veil.api.client.render.light.renderer.LightRenderHandle
        public boolean isValid() {
            return !DirectionalLightRenderer.this.freed;
        }

        public void free() {
            DirectionalLightRenderer.this.lights.remove(this);
        }
    }
}
