package software.bernie.geckolib.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.animation.keyframe.Keyframe;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/KeyframeLocation.class */
public final class KeyframeLocation<T extends Keyframe<?>> extends Record {
    private final T keyframe;
    private final double startTick;

    public KeyframeLocation(T keyframe, double startTick) {
        this.keyframe = keyframe;
        this.startTick = startTick;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, KeyframeLocation.class), KeyframeLocation.class, "keyframe;startTick", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeLocation;->keyframe:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeLocation;->startTick:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, KeyframeLocation.class), KeyframeLocation.class, "keyframe;startTick", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeLocation;->keyframe:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeLocation;->startTick:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, KeyframeLocation.class, Object.class), KeyframeLocation.class, "keyframe;startTick", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeLocation;->keyframe:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeLocation;->startTick:D").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public T keyframe() {
        return this.keyframe;
    }

    public double startTick() {
        return this.startTick;
    }
}
