package foundry.veil.impl.command;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.impl.client.editor.PostInspector;
import java.util.stream.Stream;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/command/VeilClientSuggestions.class */
@ApiStatus.Internal
public final class VeilClientSuggestions {
    private VeilClientSuggestions() {
    }

    public static Stream<ResourceLocation> getPostPipelineNames() {
        return VeilRenderSystem.renderer().getPostProcessingManager().getPipelines().stream().filter(pipeline -> {
            return !PostInspector.isInternal(pipeline);
        });
    }
}
