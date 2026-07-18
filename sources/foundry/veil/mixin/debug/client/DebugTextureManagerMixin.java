package foundry.veil.mixin.debug.client;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.ext.VeilDebug;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/debug/client/DebugTextureManagerMixin.class */
@Mixin({TextureManager.class})
public class DebugTextureManagerMixin {
    @Inject(method = {"register(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/texture/AbstractTexture;)V"}, at = {@At("TAIL")})
    public void applyLabel(ResourceLocation name, AbstractTexture texture, CallbackInfo ci) {
        VeilDebug debug = VeilDebug.get();
        if (debug == VeilDebug.ENABLED) {
            VeilRenderSystem.renderThreadExecutor().execute(() -> {
                texture.bind();
                debug.objectLabel(5890, texture.getId(), "Texture " + String.valueOf(name));
            });
        }
    }
}
