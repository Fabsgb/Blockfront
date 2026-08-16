package foundry.veil.api.client.render.light.renderer;

import com.boehmod.blockfront.InterfaceC1274xN;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.Veil;
import foundry.veil.api.client.registry.LightTypeRegistry;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import foundry.veil.api.client.render.dynamicbuffer.DynamicBufferType;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.vertex.VertexArray;
import foundry.veil.impl.client.render.light.VoxelShadowGrid;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/renderer/LightRenderer.class */
public final class LightRenderer implements NativeResource {
    private static final ResourceLocation BUFFER_ID = Veil.veilPath("lights");
    private final Map<LightTypeRegistry.LightType<?>, LightTypeRenderer<?>> renderers = new Object2ObjectArrayMap();
    private final Map<LightTypeRegistry.LightType<?>, LightTypeRenderer<?>> renderersView = Collections.unmodifiableMap(this.renderers);

    @ApiStatus.Internal
    public boolean render(CullFrustum frustum, AdvancedFbo lightFbo, AdvancedFbo lightInscatteringFbo, boolean renderInscattering) {
        boolean hasRendered = false;
        boolean setupDDA = false;
        VeilRenderer renderer = VeilRenderSystem.renderer();
        for (LightTypeRenderer<?> lightRenderer : this.renderers.values()) {
            lightRenderer.prepareLights(this, frustum);
            if (lightRenderer.getVisibleLights() > 0) {
                if (!hasRendered) {
                    if (renderer.enableBuffers(BUFFER_ID, DynamicBufferType.ALBEDO, DynamicBufferType.NORMAL)) {
                        return false;
                    }
                    lightFbo.bind(true);
                    lightFbo.clear(InterfaceC1274xN.f6857vZ);
                    AdvancedFbo.getMainFramebuffer().resolveToAdvancedFbo(lightFbo, 256, 9728);
                }
                hasRendered = true;
                if (lightRenderer instanceof DDALightRenderer) {
                    DDALightRenderer<?> ddalightRenderer = (DDALightRenderer) lightRenderer;
                    if (!setupDDA) {
                        VoxelShadowGrid.setup();
                        setupDDA = true;
                    }
                    ddalightRenderer.uploadVoxelGridUniforms(VoxelShadowGrid.getTextureId(), VoxelShadowGrid.getUniformGridPos());
                }
                lightRenderer.renderLights(this);
                if (lightRenderer instanceof InscatteringLightRenderer) {
                    InscatteringLightRenderer<?> inscatteringLightRenderer = (InscatteringLightRenderer) lightRenderer;
                    if (renderInscattering) {
                        lightInscatteringFbo.bind(true);
                        AdvancedFbo.getMainFramebuffer().resolveToAdvancedFbo(lightInscatteringFbo, 256, 9728);
                        inscatteringLightRenderer.renderLightInscattering(this);
                        AdvancedFbo.unbind();
                    }
                }
            }
        }
        if (hasRendered && !renderInscattering) {
            lightInscatteringFbo.clear(InterfaceC1274xN.f6857vZ);
        }
        if (!hasRendered) {
            renderer.disableBuffers(BUFFER_ID, DynamicBufferType.ALBEDO, DynamicBufferType.NORMAL);
            return false;
        }
        VertexArray.unbind();
        return true;
    }

    public <T extends LightData> LightRenderHandle<T> addLight(T lightData) {
        Objects.requireNonNull(lightData, "light");
        RenderSystem.assertOnRenderThreadOrInit();
        return this.renderers.computeIfAbsent(lightData.getType(), lightType -> {
            return lightType.rendererFactory().createRenderer();
        }).addLight(lightData);
    }

    public <T extends LightData> LightRenderHandle<T> addLight(LightRenderHandle<T> handle) {
        Objects.requireNonNull(handle, "light");
        RenderSystem.assertOnRenderThreadOrInit();
        return this.renderers.computeIfAbsent(handle.getLightData().getType(), lightType -> {
            return lightType.rendererFactory().createRenderer();
        }).steal(handle);
    }

    public <T extends LightData> Collection<? extends LightRenderHandle<T>> getLights(LightTypeRegistry.LightType<? extends T> type) {
        LightTypeRenderer<?> renderer = this.renderers.get(type);
        return renderer != null ? renderer.getLights() : Collections.emptyList();
    }

    public Map<LightTypeRegistry.LightType<?>, LightTypeRenderer<?>> getRenderers() {
        return this.renderersView;
    }

    public void free() {
        this.renderers.values().forEach((v0) -> {
            v0.free();
        });
        this.renderers.clear();
    }

    @ApiStatus.Internal
    public void addDebugInfo(Consumer<String> consumer) {
        int visible = 0;
        int all = 0;
        for (LightTypeRenderer<?> renderer : this.renderers.values()) {
            visible += renderer.getVisibleLights();
            all += renderer.getLights().size();
        }
        consumer.accept("Lights: " + visible + " / " + all);
    }
}
