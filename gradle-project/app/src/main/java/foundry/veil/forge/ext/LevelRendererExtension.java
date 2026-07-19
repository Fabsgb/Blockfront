package foundry.veil.forge.ext;

import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/ext/LevelRendererExtension.class */
@ApiStatus.Internal
public interface LevelRendererExtension {
    void veil$renderStage(RenderType renderType, Matrix4fc matrix4fc, Matrix4fc matrix4fc2);
}
