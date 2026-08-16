package foundry.veil.mixin.debug.accessor;

import java.util.Map;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.ShaderInstance;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/accessor/DebugGameRendererAccessor.class */
@Mixin({GameRenderer.class})
public interface DebugGameRendererAccessor {
    @Accessor
    @Nullable
    PostChain getPostEffect();

    @Accessor
    Map<String, ShaderInstance> getShaders();

    @Accessor
    ShaderInstance getBlitShader();
}
