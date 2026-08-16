package foundry.veil.api.quasar.emitters.module.force;

import foundry.veil.api.quasar.emitters.module.ForceParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/force/ScaleForceModule.class */
public class ScaleForceModule implements ForceParticleModule {
    private final Vector3d scale;
    private float strength = 1.0f;

    public ScaleForceModule(Vector3dc scale) {
        this.scale = new Vector3d(scale);
    }

    public ScaleForceModule(double scale) {
        this.scale = new Vector3d(scale);
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void applyForce(QuasarParticle particle) {
        particle.getVelocity().mul(1.0d + ((this.scale.x - 1.0d) * ((double) this.strength)), 1.0d + ((this.scale.y - 1.0d) * ((double) this.strength)), 1.0d + ((this.scale.z - 1.0d) * ((double) this.strength)));
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void setStrength(float strength) {
        this.strength = strength;
    }

    public Vector3d getScale() {
        return this.scale;
    }
}
