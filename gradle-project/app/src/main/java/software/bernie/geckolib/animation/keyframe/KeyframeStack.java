package software.bernie.geckolib.animation.keyframe;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import software.bernie.geckolib.animation.keyframe.Keyframe;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/KeyframeStack.class */
public final class KeyframeStack<T extends Keyframe<?>> extends Record {
    private final List<T> xKeyframes;
    private final List<T> yKeyframes;
    private final List<T> zKeyframes;

    public KeyframeStack(List<T> xKeyframes, List<T> yKeyframes, List<T> zKeyframes) {
        this.xKeyframes = xKeyframes;
        this.yKeyframes = yKeyframes;
        this.zKeyframes = zKeyframes;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, KeyframeStack.class), KeyframeStack.class, "xKeyframes;yKeyframes;zKeyframes", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->xKeyframes:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->yKeyframes:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->zKeyframes:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, KeyframeStack.class), KeyframeStack.class, "xKeyframes;yKeyframes;zKeyframes", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->xKeyframes:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->yKeyframes:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->zKeyframes:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, KeyframeStack.class, Object.class), KeyframeStack.class, "xKeyframes;yKeyframes;zKeyframes", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->xKeyframes:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->yKeyframes:Ljava/util/List;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;->zKeyframes:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public List<T> xKeyframes() {
        return this.xKeyframes;
    }

    public List<T> yKeyframes() {
        return this.yKeyframes;
    }

    public List<T> zKeyframes() {
        return this.zKeyframes;
    }

    public KeyframeStack() {
        this(new ObjectArrayList(), new ObjectArrayList(), new ObjectArrayList());
    }

    public static <F extends Keyframe<?>> KeyframeStack<F> from(KeyframeStack<F> otherStack) {
        return new KeyframeStack<>(((KeyframeStack) otherStack).xKeyframes, ((KeyframeStack) otherStack).yKeyframes, ((KeyframeStack) otherStack).zKeyframes);
    }

    public double getLastKeyframeTime() {
        double xTime = 0.0d;
        double yTime = 0.0d;
        double zTime = 0.0d;
        for (T frame : xKeyframes()) {
            xTime += frame.length();
        }
        for (T frame2 : yKeyframes()) {
            yTime += frame2.length();
        }
        for (T frame3 : zKeyframes()) {
            zTime += frame3.length();
        }
        return Math.max(xTime, Math.max(yTime, zTime));
    }
}
