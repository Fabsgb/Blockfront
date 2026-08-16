package foundry.veil.mixin.dynamicbuffer.accessor;

import java.util.Map;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/dynamicbuffer/accessor/DynamicBufferGameRendererAccessor.class */
@Mixin({GameRenderer.class})
public interface DynamicBufferGameRendererAccessor {
    @Accessor
    Map<String, ShaderInstance> getShaders();
}
