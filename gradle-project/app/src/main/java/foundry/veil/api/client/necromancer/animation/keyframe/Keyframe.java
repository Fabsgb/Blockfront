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
        private final float px;
        private final float py;
        private final float pz;
        private final float sx;
        private final float sy;
        private final float sz;
        private final float qx;
        private final float qy;
        private final float qz;
        private final float qw;

        KeyframeTransform(float px, float py, float pz, float sx, float sy, float sz, float qx, float qy, float qz, float qw) {
            this.px = px;
            this.py = py;
            this.pz = pz;
            this.sx = sx;
            this.sy = sy;
            this.sz = sz;
            this.qx = qx;
            this.qy = qy;
            this.qz = qz;
            this.qw = qw;
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

        public float px() {
            return this.px;
        }

        public float py() {
            return this.py;
        }

        public float pz() {
            return this.pz;
        }

        public float sx() {
            return this.sx;
        }

        public float sy() {
            return this.sy;
        }

        public float sz() {
            return this.sz;
        }

        public float qx() {
            return this.qx;
        }

        public float qy() {
            return this.qy;
        }

        public float qz() {
            return this.qz;
        }

        public float qw() {
            return this.qw;
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
