package foundry.veil.api.quasar.emitters.module.force;

import foundry.veil.api.quasar.data.module.force.PointForceData;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/force/PointForceModule.class */
public class PointForceModule extends SimplePositionedForce {
    private double rangeSq;
    private float strength;

    public PointForceModule(PointForceData data) {
        this(data.point(), data.localPoint(), data.range(), data.strength());
    }

    public PointForceModule(Vector3dc point, boolean localPoint, float range, float strength) {
        super(point, localPoint);
        this.rangeSq = range * range;
        this.strength = strength;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void applyForce(QuasarParticle particle) {
        Vector3d diff = getDeltaPosition(particle);
        double distanceSq = diff.lengthSquared();
        if (distanceSq >= this.rangeSq) {
            return;
        }
        particle.getVelocity().sub(diff.normalize(this.strength));
    }

    public void setRange(double range) {
        this.rangeSq = range * range;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void setStrength(float strength) {
        this.strength = strength;
    }
}
