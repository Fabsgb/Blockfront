package foundry.veil.api.quasar.emitters.module.render;

import foundry.veil.api.quasar.emitters.module.InitParticleModule;
import foundry.veil.api.quasar.p002fx.Trail;
import foundry.veil.api.quasar.particle.QuasarParticle;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/render/TrailParticleModule.class */
public class TrailParticleModule implements InitParticleModule {
    private final List<TrailSettings> settings;

    public TrailParticleModule(List<TrailSettings> settings) {
        this.settings = settings;
    }

    @Override // foundry.veil.api.quasar.emitters.module.InitParticleModule
    public void init(QuasarParticle particle) {
        List<Trail> trails = particle.getRenderData().getTrails();
        for (TrailSettings setting : this.settings) {
            trails.add(new Trail(setting));
        }
    }
}
