package foundry.veil.mixin.pipeline.client;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilRenderer;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/pipeline/client/PipelineDebugScreenOverlayMixin.class */
@Mixin({DebugScreenOverlay.class})
public class PipelineDebugScreenOverlayMixin {
    @ModifyVariable(method = {"getSystemInformation"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;showOnlyReducedInfo()Z", shift = At.Shift.BEFORE), ordinal = 0)
    public List<String> modifyGameInformation(List<String> value) {
        VeilRenderer veilRendererRenderer = VeilRenderSystem.renderer();
        Objects.requireNonNull(value);
        veilRendererRenderer.addDebugInfo((v1) -> {
            r1.add(v1);
        });
        return value;
    }
}
