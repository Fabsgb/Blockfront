package foundry.veil.api.quasar.emitters.module.force;

import foundry.veil.api.quasar.data.module.force.VortexForceData;
import foundry.veil.api.quasar.particle.QuasarParticle;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/force/VortexForceModule.class */
public class VortexForceModule extends SimplePositionedForce {
    private final Vector3d vortexAxis;
    private double rangeSq;
    private float strength;
    private final Vector3d dot;

    public VortexForceModule(VortexForceData data) {
        this(data.vortexAxis(), data.vortexCenter(), data.localPosition(), data.range(), data.strength());
    }

    public VortexForceModule(Vector3dc vortexAxis, Vector3dc vortexCenter, boolean localPosition, double range, float strength) {
        super(vortexCenter, localPosition);
        this.vortexAxis = vortexAxis.normalize(new Vector3d());
        this.rangeSq = range * range;
        this.strength = strength;
        this.dot = new Vector3d();
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void applyForce(QuasarParticle particle) {
        Vector3d diff = getDeltaPosition(particle);
        double distanceSq = diff.lengthSquared();
        if (distanceSq >= this.rangeSq) {
            return;
        }
        Vector3d particleToCenterOnAxis = diff.sub(this.vortexAxis.mul(diff.dot(this.vortexAxis), this.dot));
        particleToCenterOnAxis.normalize();
        particleToCenterOnAxis.cross(this.vortexAxis).mul(this.strength);
        particle.getVelocity().add(particleToCenterOnAxis);
    }

    public Vector3dc getVortexAxis() {
        return this.vortexAxis;
    }

    public void setVortexAxis(double x, double y, double z) {
        this.vortexAxis.set(x, y, z).normalize();
    }

    public void setVortexAxis(Vector3dc axis) {
        setVortexAxis(axis.x(), axis.y(), axis.z());
    }

    public void setRange(double range) {
        this.rangeSq = range * range;
    }

    @Override // foundry.veil.api.quasar.emitters.module.ForceParticleModule
    public void setStrength(float strength) {
        this.strength = strength;
    }
}
