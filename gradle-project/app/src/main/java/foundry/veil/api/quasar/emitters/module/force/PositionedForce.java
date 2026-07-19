package foundry.veil.api.quasar.emitters.module.force;

import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/emitters/module/force/PositionedForce.class */
public interface PositionedForce {
    Vector3d getPosition();

    boolean isLocalPosition();

    void setForceOrigin(double d, double d2, double d3);

    default void setForceOrigin(Vector3dc pos) {
        setForceOrigin(pos.x(), pos.y(), pos.z());
    }
}
