package foundry.veil.api.client.render.light.renderer;

import foundry.veil.api.client.render.light.data.LightData;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/light/renderer/LightRenderHandle.class */
public interface LightRenderHandle<T extends LightData> extends NativeResource {
    T getLightData();

    void markDirty();

    boolean isValid();
}
