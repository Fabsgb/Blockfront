package foundry.veil.forge.mixin.client;

import com.boehmod.blockfront.C0942rB;
import foundry.veil.forge.impl.ForgeRenderTypeStageHandler;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/client/RenderTypeMixin.class */
@Mixin(value = {RenderType.class}, priority = C0942rB.f5014pJ)
public class RenderTypeMixin {
    @Inject(method = {"chunkBufferLayers"}, at = {@At("RETURN")}, cancellable = true)
    private static void injectChunkBufferLayers(CallbackInfoReturnable<List<RenderType>> cir) {
        List<RenderType> renderTypes = ForgeRenderTypeStageHandler.getBlockLayers((List) cir.getReturnValue());
        if (renderTypes != null) {
            cir.setReturnValue(renderTypes);
        }
    }
}
