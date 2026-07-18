package foundry.veil.mixin.command.client;

import foundry.veil.ext.VeilClientSuggestionProvider;
import foundry.veil.impl.command.VeilClientSuggestions;
import java.util.stream.Stream;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/command/client/ClientCommandSourceMixin.class */
@Mixin({ClientSuggestionProvider.class})
public class ClientCommandSourceMixin implements VeilClientSuggestionProvider {
    @Override // foundry.veil.ext.VeilClientSuggestionProvider
    public Stream<ResourceLocation> veil$getPostPipelineNames() {
        return VeilClientSuggestions.getPostPipelineNames();
    }
}
