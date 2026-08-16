package foundry.veil.api.client.render.light.renderer;

import com.mojang.blaze3d.vertex.VertexConsumer;
import foundry.veil.api.client.render.CullFrustum;
import foundry.veil.api.client.render.light.data.LightData;
import java.util.Collection;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/renderer/LightTypeRenderer.class */
public interface LightTypeRenderer<T extends LightData> extends NativeResource {
    LightRenderHandle<T> addLight(T t);

    LightRenderHandle<T> steal(LightRenderHandle<T> lightRenderHandle);

    @ApiStatus.OverrideOnly
    void prepareLights(LightRenderer lightRenderer, CullFrustum cullFrustum);

    void renderLights(LightRenderer lightRenderer);

    Collection<? extends LightRenderHandle<T>> getLights();

    int getVisibleLights();

    static void createQuad(VertexConsumer builder) {
        builder.addVertex(-1.0f, -1.0f, 0.0f);
        builder.addVertex(1.0f, -1.0f, 0.0f);
        builder.addVertex(-1.0f, 1.0f, 0.0f);
        builder.addVertex(1.0f, 1.0f, 0.0f);
    }

    static void createInvertedCube(VertexConsumer builder) {
        builder.addVertex(-1.0f, 1.0f, 1.0f);
        builder.addVertex(1.0f, 1.0f, 1.0f);
        builder.addVertex(-1.0f, -1.0f, 1.0f);
        builder.addVertex(1.0f, -1.0f, 1.0f);
        builder.addVertex(1.0f, -1.0f, -1.0f);
        builder.addVertex(1.0f, 1.0f, 1.0f);
        builder.addVertex(1.0f, 1.0f, -1.0f);
        builder.addVertex(-1.0f, 1.0f, 1.0f);
        builder.addVertex(-1.0f, 1.0f, -1.0f);
        builder.addVertex(-1.0f, -1.0f, 1.0f);
        builder.addVertex(-1.0f, -1.0f, -1.0f);
        builder.addVertex(1.0f, -1.0f, -1.0f);
        builder.addVertex(-1.0f, 1.0f, -1.0f);
        builder.addVertex(1.0f, 1.0f, -1.0f);
    }
}
