package foundry.veil.forge.mixin.client;

import foundry.veil.Veil;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.forge.event.ForgeVeilRegisterBlockLayersEvent;
import foundry.veil.forge.impl.ForgeRenderTypeStageHandler;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.fml.ModLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/client/RenderBuffersMixin.class */
@Mixin({RenderBuffers.class})
public class RenderBuffersMixin {
    @Inject(method = {"<init>"}, at = {@At("HEAD")})
    private static void init(CallbackInfo ci) {
        Set<RenderType> blockLayers = new HashSet<>();
        ModLoader.postEvent(new ForgeVeilRegisterBlockLayersEvent(renderType -> {
            if (Veil.platform().isDevelopmentEnvironment() && renderType.bufferSize() > 786432) {
                Veil.LOGGER.warn("Block render layer '{}' uses a large buffer size: {}. If this is intended you can ignore this message", VeilRenderType.getName(renderType), Integer.valueOf(renderType.bufferSize()));
            }
            blockLayers.add(renderType);
        }));
        ForgeRenderTypeStageHandler.setBlockLayers(blockLayers);
    }
}
