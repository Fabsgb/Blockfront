package foundry.veil.api.client.necromancer.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Quaternionfc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/keyframe/Keyframe.class */
public final class Keyframe extends Record {
    private final float time;
    private final Interpolation interpolation;
    private final KeyframeTransform transform;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/keyframe/Keyframe$KeyframeTransform.class */
    static final class KeyframeTransform extends Record {

        /* JADX INFO: renamed from: px */
        private final float f8723px;

        /* JADX INFO: renamed from: py */
        private final float f8724py;

        /* JADX INFO: renamed from: pz */
        private final float f8725pz;

        /* JADX INFO: renamed from: sx */
        private final float f8726sx;

        /* JADX INFO: renamed from: sy */
        private final float f8727sy;

        /* JADX INFO: renamed from: sz */
        private final float f8728sz;

        /* JADX INFO: renamed from: qx */
        private final float f8729qx;

        /* JADX INFO: renamed from: qy */
        private final float f8730qy;

        /* JADX INFO: renamed from: qz */
        private final float f8731qz;

        /* JADX INFO: renamed from: qw */
        private final float f8732qw;

        KeyframeTransform(float px, float py, float pz, float sx, float sy, float sz, float qx, float qy, float qz, float qw) {
            this.f8723px = px;
            this.f8724py = py;
            this.f8725pz = pz;
            this.f8726sx = sx;
            this.f8727sy = sy;
            this.f8728sz = sz;
            this.f8729qx = qx;
            this.f8730qy = qy;
            this.f8731qz = qz;
            this.f8732qw = qw;
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
        public float m7978px() {
            return this.f8723px;
        }

        /* JADX INFO: renamed from: py */
        public float m7979py() {
            return this.f8724py;
        }

        /* JADX INFO: renamed from: pz */
        public float m7980pz() {
            return this.f8725pz;
        }

        /* JADX INFO: renamed from: sx */
        public float m7981sx() {
            return this.f8726sx;
        }

        /* JADX INFO: renamed from: sy */
        public float m7982sy() {
            return this.f8727sy;
        }

        /* JADX INFO: renamed from: sz */
        public float m7983sz() {
            return this.f8728sz;
        }

        /* JADX INFO: renamed from: qx */
        public float m7984qx() {
            return this.f8729qx;
        }

        /* JADX INFO: renamed from: qy */
        public float m7985qy() {
            return this.f8730qy;
        }

        /* JADX INFO: renamed from: qz */
        public float m7986qz() {
            return this.f8731qz;
        }

        /* JADX INFO: renamed from: qw */
        public float m7987qw() {
            return this.f8732qw;
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
