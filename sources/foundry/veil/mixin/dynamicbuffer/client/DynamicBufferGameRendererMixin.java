package foundry.veil.mixin.dynamicbuffer.client;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import java.util.Map;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/dynamicbuffer/client/DynamicBufferGameRendererMixin.class */
@Mixin({GameRenderer.class})
public class DynamicBufferGameRendererMixin {

    @Shadow
    @Final
    private Map<String, ShaderInstance> shaders;

    @Inject(method = {"reloadShaders"}, at = {@At("RETURN")})
    public void reloadShaders(ResourceProvider resourceProvider, CallbackInfo ci) {
        if (Veil.platform().hasErrors()) {
            return;
        }
        VeilRenderSystem.renderer().getVanillaShaderCompiler().reload(this.shaders.values());
    }
}
