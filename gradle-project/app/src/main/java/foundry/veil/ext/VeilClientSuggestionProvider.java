package foundry.veil.ext;

import java.util.stream.Stream;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/ext/VeilClientSuggestionProvider.class */
public interface VeilClientSuggestionProvider {
    Stream<ResourceLocation> veil$getPostPipelineNames();
}
