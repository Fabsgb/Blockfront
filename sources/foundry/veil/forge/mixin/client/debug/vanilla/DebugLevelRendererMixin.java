package foundry.veil.forge.mixin.client.debug.vanilla;

import com.llamalad7.mixinextras.sugar.Local;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import java.util.function.Supplier;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/debug/vanilla/DebugLevelRendererMixin.class */
@Mixin({LevelRenderer.class})
public abstract class DebugLevelRendererMixin {
    @Redirect(method = {"renderSectionLayer"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/util/function/Supplier;)V"))
    private void fixBlockProfilerName(ProfilerFiller instance, Supplier<String> stringSupplier, @Local(argsOnly = true) RenderType renderType) {
        instance.popPush("render_" + VeilRenderType.getName(renderType));
    }
}
