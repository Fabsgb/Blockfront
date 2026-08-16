package foundry.veil.mixin.debug.accessor;

import java.util.List;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.PostPass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/accessor/DebugPostChainAccessor.class */
@Mixin({PostChain.class})
public interface DebugPostChainAccessor {
    @Accessor
    List<PostPass> getPasses();
}
