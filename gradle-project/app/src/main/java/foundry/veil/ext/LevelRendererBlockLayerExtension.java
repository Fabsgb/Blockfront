package foundry.veil.ext;

import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/ext/LevelRendererBlockLayerExtension.class */
@ApiStatus.Internal
public interface LevelRendererBlockLayerExtension {
    void veil$drawBlockLayer(RenderType renderType, double d, double d2, double d3, Matrix4fc matrix4fc, Matrix4fc matrix4fc2);
}
