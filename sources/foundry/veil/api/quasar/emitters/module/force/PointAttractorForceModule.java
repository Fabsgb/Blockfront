package foundry.veil.api.quasar.emitters.module.force;

import foundry.veil.api.quasar.data.module.force.PointAttractorForceData;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/force/PointAttractorForceModule.class */
public class PointAttractorForceModule extends SimplePositionedForce {
    private double rangeSq;
    private float strength;
    private boolean strengthByDistance;
    private boolean invertDistanceModifier;

    public PointAttractorForceModule(PointAttractorForceData data) {
        this(data.position(), data.localPosition(), data.range(), data.strength(), data.strengthByDistance(), data.invertDistanceModifier());
    }

    public PointAttractorForceModule(Vector3dc position, boolean localPosition, float range, float strength, boolean strengthByDistance, boolean invertDistanceModifier) {
        super(position, localPosition);
        this.rangeSq = range * range;
        this.strength = strength;
        this.strengthByDistance = strengthByDistance;
        this.invertDistanceModifier = invertDistanceModifier;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void applyForce(QuasarParticle particle) {
        double strength;
        Vector3d diff = getDeltaPosition(particle);
        double distanceSq = diff.lengthSquared();
        if (distanceSq >= this.rangeSq) {
            return;
        }
        if (this.strengthByDistance) {
            double factor = this.invertDistanceModifier ? (distanceSq / this.rangeSq) * 2.0d : 1.0d - (distanceSq / this.rangeSq);
            strength = ((double) this.strength) * factor;
        } else {
            strength = this.strength;
        }
        particle.getVelocity().add(diff.normalize(strength));
    }

    public void setRange(double range) {
        this.rangeSq = range * range;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void setStrength(float strength) {
        this.strength = strength;
    }

    public void setStrengthByDistance(boolean strengthByDistance) {
        this.strengthByDistance = strengthByDistance;
    }

    public void setInvertDistanceModifier(boolean invertDistanceModifier) {
        this.invertDistanceModifier = invertDistanceModifier;
    }
}
