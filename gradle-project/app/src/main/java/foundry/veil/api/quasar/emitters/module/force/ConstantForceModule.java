package foundry.veil.api.quasar.emitters.module.force;

import foundry.veil.api.quasar.emitters.module.ForceParticleModule;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/force/ConstantForceModule.class */
public class ConstantForceModule implements ForceParticleModule {
    private final Vector3d acceleration;
    private float strength;

    public ConstantForceModule(Vector3dc acceleration) {
        this(new Vector3d(acceleration));
    }

    public ConstantForceModule(Vector3d acceleration) {
        this.acceleration = acceleration;
        this.strength = 1.0f;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void applyForce(QuasarParticle particle) {
        particle.getVelocity().add(this.acceleration.x * ((double) this.strength), this.acceleration.y * ((double) this.strength), this.acceleration.z * ((double) this.strength));
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void setStrength(float strength) {
        this.strength = strength;
    }

    public Vector3d getAcceleration() {
        return this.acceleration;
    }
}
