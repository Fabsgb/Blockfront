package foundry.veil.api.quasar.emitters.module.update;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.data.module.update.TickSubEmitterModuleData;
import foundry.veil.api.quasar.emitters.module.UpdateParticleModule;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/update/TickSubEmitterModule.class */
public class TickSubEmitterModule implements UpdateParticleModule {
    private final TickSubEmitterModuleData data;

    public TickSubEmitterModule(TickSubEmitterModuleData data) {
        this.data = data;
    }

    @Override // foundry.veil.api.quasar.emitters.module.UpdateParticleModule
    public void update(QuasarParticle particle) {
        ParticleSystemManager particleManager;
        ParticleEmitter instance;
        if (particle.getAge() % this.data.frequency() != 0 || (instance = (particleManager = VeilRenderSystem.renderer().getParticleManager()).createEmitter(this.data.subEmitter())) == null) {
            return;
        }
        instance.setPosition((Vector3dc) particle.getPosition());
        particleManager.getScheduler().execute(() -> {
            particleManager.addParticleSystem(instance);
        });
    }
}
