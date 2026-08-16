package foundry.veil.api.client.necromancer.animation.keyframe;

import net.minecraft.util.Mth;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/Interpolation.class */
public enum Interpolation {
    NEAREST_NEIGHBOR((a, b, t) -> {
        return ((double) t) < 0.5d ? a : b;
    }, (a2, b2, t2, result) -> {
        result.set(((double) t2) < 0.5d ? a2 : b2);
    }),
    LINEAR((a3, b3, t3) -> {
        return Mth.lerp(t3, a3, b3);
    }, (v0, v1, v2, v3) -> {
        v0.slerp(v1, v2, v3);
    });

    private final FloatInterpolator fInterpolator;
    private final QuaternionInterpolator qInterpolator;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/Interpolation$FloatInterpolator.class */
    public interface FloatInterpolator {
        float interpolate(float f, float f2, float f3);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/Interpolation$QuaternionInterpolator.class */
    public interface QuaternionInterpolator {
        void interpolate(Quaternionfc quaternionfc, Quaternionfc quaternionfc2, float f, Quaternionf quaternionf);
    }

    Interpolation(FloatInterpolator fInterpolator, QuaternionInterpolator qInterpolator) {
        this.fInterpolator = fInterpolator;
        this.qInterpolator = qInterpolator;
    }

    public float interpolate(float a, float b, float t) {
        return this.fInterpolator.interpolate(a, b, t);
    }

    public Quaternionf interpolate(Quaternionfc a, Quaternionfc b, float t, Quaternionf result) {
        this.qInterpolator.interpolate(a, b, t, result);
        return result;
    }
}
