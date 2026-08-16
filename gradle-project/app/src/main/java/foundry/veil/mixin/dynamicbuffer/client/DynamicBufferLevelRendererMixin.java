package foundry.veil.mixin.dynamicbuffer.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferShard;
import java.util.function.Supplier;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/dynamicbuffer/client/DynamicBufferLevelRendererMixin.class */
@Mixin(value = {LevelRenderer.class}, priority = 200)
public abstract class DynamicBufferLevelRendererMixin {

    @Unique
    private final DynamicBufferShard veil$weatherBufferShard = new DynamicBufferShard("weather", (Supplier<RenderTarget>) this::getWeatherTarget);

    @Shadow
    @Nullable
    public abstract RenderTarget getWeatherTarget();

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;setupRender(Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/culling/Frustum;ZZ)V", shift = At.Shift.BEFORE)})
    public void setupOpaque(CallbackInfo ci) {
        VeilRenderSystem.renderer().getDynamicBufferManger().setEnabled(true);
    }

    @WrapOperation(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderStateShard$OutputStateShard;setupRenderState()V")})
    public void setupState(RenderStateShard.OutputStateShard instance, Operation<Void> original) {
        if ("weather_target".equals(VeilRenderType.getName(instance))) {
            this.veil$weatherBufferShard.setupRenderState();
        } else {
            if ("particles_target".equals(VeilRenderType.getName(instance))) {
                if (!VeilRenderSystem.renderer().getDynamicBufferManger().isEnabled()) {
                    original.call(new Object[]{instance});
                    return;
                }
                return;
            }
            original.call(new Object[]{instance});
        }
    }

    @WrapOperation(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderStateShard$OutputStateShard;setupRenderState()V")})
    public void clearState(RenderStateShard.OutputStateShard instance, Operation<Void> original) {
        if ("weather_target".equals(VeilRenderType.getName(instance))) {
            this.veil$weatherBufferShard.clearRenderState();
        } else {
            if ("particles_target".equals(VeilRenderType.getName(instance))) {
                if (!VeilRenderSystem.renderer().getDynamicBufferManger().isEnabled()) {
                    original.call(new Object[]{instance});
                    return;
                }
                return;
            }
            original.call(new Object[]{instance});
        }
    }

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/OutlineBufferSource;endOutlineBatch()V", ordinal = 0)})
    public void endOpaque(CallbackInfo ci) {
        VeilRenderSystem.renderer().getDynamicBufferManger().setEnabled(false);
    }

    @Inject(method = {"renderLevel"}, at = {@At("TAIL")})
    public void blit(CallbackInfo ci) {
        VeilRenderSystem.renderer().getDynamicBufferManger().setEnabled(false);
    }
}
