package foundry.veil.mixin.quasar.client;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import foundry.veil.impl.quasar.QuasarParticleHandler;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleEngine;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/quasar/client/QuasarParticleEngineMixin.class */
@Mixin({ParticleEngine.class})
public class QuasarParticleEngineMixin {
    @Inject(method = {"tick"}, at = {@At("HEAD")})
    public void tick(CallbackInfo ci) {
        VeilRenderSystem.renderer().getParticleManager().tick();
    }

    @Inject(method = {"countParticles"}, at = {@At("RETURN")}, cancellable = true)
    public void countParticles(CallbackInfoReturnable<String> cir) {
        ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();
        cir.setReturnValue(((String) cir.getReturnValue()) + ". VE: " + particleManager.getEmitterCount() + ". VP: " + particleManager.getParticleCount());
    }

    @Inject(method = {"setLevel"}, at = {@At("HEAD")})
    public void setLevel(@Nullable ClientLevel level, CallbackInfo ci) {
        QuasarParticleHandler.setLevel(level);
    }

    @Inject(method = {"clearParticles"}, at = {@At("TAIL")})
    public void clear(CallbackInfo ci) {
        QuasarParticleHandler.free();
    }
}
