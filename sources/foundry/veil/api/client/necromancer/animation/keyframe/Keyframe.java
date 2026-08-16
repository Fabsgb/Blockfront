package foundry.veil.api.client.necromancer.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Quaternionfc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/Keyframe.class */
public final class Keyframe extends Record {
    private final float time;
    private final Interpolation interpolation;
    private final KeyframeTransform transform;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform.class */
    static final class KeyframeTransform extends Record {

        /* JADX INFO: renamed from: px */
        private final float f9109px;

        /* JADX INFO: renamed from: py */
        private final float f9110py;

        /* JADX INFO: renamed from: pz */
        private final float f9111pz;

        /* JADX INFO: renamed from: sx */
        private final float f9112sx;

        /* JADX INFO: renamed from: sy */
        private final float f9113sy;

        /* JADX INFO: renamed from: sz */
        private final float f9114sz;

        /* JADX INFO: renamed from: qx */
        private final float f9115qx;

        /* JADX INFO: renamed from: qy */
        private final float f9116qy;

        /* JADX INFO: renamed from: qz */
        private final float f9117qz;

        /* JADX INFO: renamed from: qw */
        private final float f9118qw;

        KeyframeTransform(float px, float py, float pz, float sx, float sy, float sz, float qx, float qy, float qz, float qw) {
            this.f9109px = px;
            this.f9110py = py;
            this.f9111pz = pz;
            this.f9112sx = sx;
            this.f9113sy = sy;
            this.f9114sz = sz;
            this.f9115qx = qx;
            this.f9116qy = qy;
            this.f9117qz = qz;
            this.f9118qw = qw;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, KeyframeTransform.class), KeyframeTransform.class, "px;py;pz;sx;sy;sz;qx;qy;qz;qw", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->px:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->py:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->pz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sx:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sy:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qx:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qy:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qw:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, KeyframeTransform.class), KeyframeTransform.class, "px;py;pz;sx;sy;sz;qx;qy;qz;qw", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->px:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->py:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->pz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sx:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sy:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qx:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qy:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qw:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, KeyframeTransform.class, Object.class), KeyframeTransform.class, "px;py;pz;sx;sy;sz;qx;qy;qz;qw", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->px:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->py:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->pz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sx:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sy:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->sz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qx:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qy:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qz:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;->qw:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: px */
        public float m8329px() {
            return this.f9109px;
        }

        /* JADX INFO: renamed from: py */
        public float m8330py() {
            return this.f9110py;
        }

        /* JADX INFO: renamed from: pz */
        public float m8331pz() {
            return this.f9111pz;
        }

        /* JADX INFO: renamed from: sx */
        public float m8332sx() {
            return this.f9112sx;
        }

        /* JADX INFO: renamed from: sy */
        public float m8333sy() {
            return this.f9113sy;
        }

        /* JADX INFO: renamed from: sz */
        public float m8334sz() {
            return this.f9114sz;
        }

        /* JADX INFO: renamed from: qx */
        public float m8335qx() {
            return this.f9115qx;
        }

        /* JADX INFO: renamed from: qy */
        public float m8336qy() {
            return this.f9116qy;
        }

        /* JADX INFO: renamed from: qz */
        public float m8337qz() {
            return this.f9117qz;
        }

        /* JADX INFO: renamed from: qw */
        public float m8338qw() {
            return this.f9118qw;
        }

        public KeyframeTransform(float px, float py, float pz, float sx, float sy, float sz, Quaternionfc quaternion) {
            this(px, py, pz, sx, sy, sz, quaternion.x(), quaternion.y(), quaternion.z(), quaternion.w());
        }

        public KeyframeTransform(Vector3fc pos, Vector3fc size, Quaternionfc quaternion) {
            this(pos.x(), pos.y(), pos.z(), size.x(), size.y(), size.z(), quaternion);
        }
    }

    public Keyframe(float time, Interpolation interpolation, KeyframeTransform transform) {
        this.time = time;
        this.interpolation = interpolation;
        this.transform = transform;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Keyframe.class), Keyframe.class, "time;interpolation;transform", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->time:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->interpolation:Lfoundry/veil/api/client/necromancer/animation/keyframe/Interpolation;", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->transform:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Keyframe.class), Keyframe.class, "time;interpolation;transform", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->time:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->interpolation:Lfoundry/veil/api/client/necromancer/animation/keyframe/Interpolation;", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->transform:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Keyframe.class, Object.class), Keyframe.class, "time;interpolation;transform", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->time:F", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->interpolation:Lfoundry/veil/api/client/necromancer/animation/keyframe/Interpolation;", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;->transform:Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public float time() {
        return this.time;
    }

    public Interpolation interpolation() {
        return this.interpolation;
    }

    public KeyframeTransform transform() {
        return this.transform;
    }
}
