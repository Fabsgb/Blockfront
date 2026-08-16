package foundry.veil.api.quasar.emitters.module;

import foundry.veil.api.quasar.particle.QuasarParticle;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/ForceParticleModule.class */
public interface ForceParticleModule extends ParticleModule {
    void applyForce(QuasarParticle quasarParticle);

    void setStrength(float f);
}
