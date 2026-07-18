package foundry.veil.api.quasar.emitters.module;

import foundry.veil.api.quasar.particle.QuasarParticle;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/RenderParticleModule.class */
public interface RenderParticleModule extends ParticleModule {
    void render(QuasarParticle quasarParticle, float f);

    default boolean isEnabled() {
        return true;
    }
}
