package foundry.veil.api.quasar.emitters.module.force;

import foundry.veil.api.quasar.data.module.force.VectorFieldForceData;
import foundry.veil.api.quasar.emitters.module.ForceParticleModule;
import foundry.veil.api.quasar.emitters.module.update.VectorField;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/force/VectorFieldForceModule.class */
public class VectorFieldForceModule implements ForceParticleModule {
    private VectorField vectorField;
    private float strength;
    private final Vector3d temp;

    public VectorFieldForceModule(VectorFieldForceData data) {
        this(data.vectorField(), data.strength());
    }

    public VectorFieldForceModule(VectorField vectorField, float strength) {
        this.vectorField = vectorField;
        this.strength = strength;
        this.temp = new Vector3d();
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void applyForce(QuasarParticle particle) {
        Vector3d vector = this.vectorField.getVector(particle.getPosition(), this.temp);
        particle.getVelocity().add(vector.mul(this.strength));
    }

    public void setVectorField(VectorField vectorField) {
        this.vectorField = vectorField;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void setStrength(float strength) {
        this.strength = strength;
    }
}
