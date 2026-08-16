package foundry.veil.api.client.render.light.renderer;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.DDALightData;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.shader.program.TextureUniformAccess;
import foundry.veil.api.client.render.shader.program.UniformAccess;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/light/renderer/DDALightRenderer.class */
public interface DDALightRenderer<T extends LightData & DDALightData> extends LightTypeRenderer<T> {
    void uploadVoxelGridUniforms(int i, Vector3fc vector3fc);

    default boolean hasOccludedLights() {
        int visibleLights = getVisibleLights();
        if (visibleLights <= 0) {
            return false;
        }
        for (LightRenderHandle<T> light : getLights()) {
            if (((DDALightData) light.getLightData()).isOcclusionEnabled()) {
                return true;
            }
        }
        return false;
    }

    static void uploadVoxelGridUniforms(ResourceLocation shaderId, int voxelGridTexture, Vector3fc gridOrigin) {
        uploadVoxelGridUniforms(VeilRenderSystem.renderer().getShaderManager().getShader(shaderId), voxelGridTexture, gridOrigin);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lfoundry/veil/api/client/render/shader/program/UniformAccess;:Lfoundry/veil/api/client/render/shader/program/TextureUniformAccess;>(TT;ILorg/joml/Vector3fc;)V */
    static void uploadVoxelGridUniforms(UniformAccess uniformAccess, int voxelGridTexture, Vector3fc gridOrigin) {
        if (uniformAccess == null) {
            return;
        }
        ((TextureUniformAccess) uniformAccess).setTexture("BlockGrid", 32879, voxelGridTexture);
        uniformAccess.getUniformSafe("GridOrigin").setVector(gridOrigin);
    }
}
