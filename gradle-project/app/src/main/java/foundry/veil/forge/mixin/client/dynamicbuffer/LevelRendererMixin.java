package foundry.veil.forge.mixin.client.dynamicbuffer;

import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.impl.client.render.dynamicbuffer.DynamicBufferShard;
import java.util.function.Supplier;
import net.minecraft.client.renderer.LevelRenderer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/client/dynamicbuffer/LevelRendererMixin.class */
@Mixin({LevelRenderer.class})
public abstract class LevelRendererMixin {

    @Unique
    private final DynamicBufferShard veil$particleBufferShard = new DynamicBufferShard("particles", (Supplier<RenderTarget>) this::getParticlesTarget);

    @Shadow
    @Nullable
    public abstract RenderTarget getParticlesTarget();

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/neoforged/neoforge/client/ClientHooks;dispatchRenderStage(Lnet/neoforged/neoforge/client/event/RenderLevelStageEvent$Stage;Lnet/minecraft/client/renderer/LevelRenderer;Lcom/mojang/blaze3d/vertex/PoseStack;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;ILnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/culling/Frustum;)V", ordinal = 2, shift = At.Shift.BEFORE)})
    public void beginTranslucent(CallbackInfo ci) {
        VeilRenderSystem.renderer().getDynamicBufferManger().setEnabled(true);
    }

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/particle/ParticleEngine;render(Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;FLnet/minecraft/client/renderer/culling/Frustum;Ljava/util/function/Predicate;)V", shift = At.Shift.BEFORE)})
    public void preRenderParticles(CallbackInfo ci) {
        this.veil$particleBufferShard.setupRenderState();
    }

    @Inject(method = {"renderLevel"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/particle/ParticleEngine;render(Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;FLnet/minecraft/client/renderer/culling/Frustum;Ljava/util/function/Predicate;)V", shift = At.Shift.AFTER)})
    public void postRenderParticles(CallbackInfo ci) {
        this.veil$particleBufferShard.clearRenderState();
    }
}
