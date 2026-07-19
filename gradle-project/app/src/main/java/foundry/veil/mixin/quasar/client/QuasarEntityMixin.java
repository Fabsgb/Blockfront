package foundry.veil.mixin.quasar.client;

import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.ext.EntityExtension;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/quasar/client/QuasarEntityMixin.class */
@Mixin({Entity.class})
public abstract class QuasarEntityMixin implements EntityExtension {

    @Unique
    private final List<ParticleEmitter> quasar$emitters = new ArrayList();

    @Override // foundry.veil.ext.EntityExtension
    public List<ParticleEmitter> veil$getEmitters() {
        return this.quasar$emitters;
    }

    @Override // foundry.veil.ext.EntityExtension
    public void veil$addEmitter(ParticleEmitter emitter) {
        this.quasar$emitters.add(emitter);
    }

    @Inject(method = {"onClientRemoval"}, at = {@At("TAIL")})
    public void remove(CallbackInfo ci) {
        this.quasar$emitters.forEach((v0) -> {
            v0.remove();
        });
        this.quasar$emitters.clear();
    }
}
