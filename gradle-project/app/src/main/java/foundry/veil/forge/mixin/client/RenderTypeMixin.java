package foundry.veil.forge.mixin.client;

import com.boehmod.blockfront.C0966rY;
import foundry.veil.forge.impl.ForgeRenderTypeStageHandler;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/RenderTypeMixin.class */
@Mixin(value = {RenderType.class}, priority = C0966rY.f5366rI)
public class RenderTypeMixin {
    @Inject(method = {"chunkBufferLayers"}, at = {@At("RETURN")}, cancellable = true)
    private static void injectChunkBufferLayers(CallbackInfoReturnable<List<RenderType>> cir) {
        List<RenderType> renderTypes = ForgeRenderTypeStageHandler.getBlockLayers((List) cir.getReturnValue());
        if (renderTypes != null) {
            cir.setReturnValue(renderTypes);
        }
    }
}
