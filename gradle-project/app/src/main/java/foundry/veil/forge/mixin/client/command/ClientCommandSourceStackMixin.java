package foundry.veil.forge.mixin.client.command;

import foundry.veil.ext.VeilClientSuggestionProvider;
import foundry.veil.impl.command.VeilClientSuggestions;
import java.util.stream.Stream;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.ClientCommandSourceStack;
import org.spongepowered.asm.mixin.Mixin;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/client/command/ClientCommandSourceStackMixin.class */
@Mixin({ClientCommandSourceStack.class})
public class ClientCommandSourceStackMixin implements VeilClientSuggestionProvider {
    @Override // foundry.veil.ext.VeilClientSuggestionProvider
    public Stream<ResourceLocation> veil$getPostPipelineNames() {
        return VeilClientSuggestions.getPostPipelineNames();
    }
}
