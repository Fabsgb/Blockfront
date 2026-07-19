package foundry.veil.impl.client.render.pipeline;

import foundry.veil.api.client.render.VeilRenderSystem;
import net.minecraft.client.renderer.RenderStateShard;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL40C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/PatchStateShard.class */
@ApiStatus.Internal
public class PatchStateShard extends RenderStateShard {
    private final int patchVertices;

    public PatchStateShard(int patchVertices) {
        super("veil:patches", () -> {
            if (VeilRenderSystem.tessellationSupported()) {
                GL40C.glPatchParameteri(36466, patchVertices);
            }
        }, () -> {
            if (VeilRenderSystem.tessellationSupported()) {
                GL40C.glPatchParameteri(36466, 1);
            }
        });
        this.patchVertices = patchVertices;
    }

    public String toString() {
        return this.name + "[" + this.patchVertices + "]";
    }
}
