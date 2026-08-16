package foundry.veil.api.client.render.light.renderer;

import foundry.veil.api.client.render.light.data.LightData;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/renderer/InscatteringLightRenderer.class */
public interface InscatteringLightRenderer<T extends LightData> extends LightTypeRenderer<T> {
    void renderLightInscattering(LightRenderer lightRenderer);
}
