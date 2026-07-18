package software.bernie.geckolib.animation.keyframe;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Objects;
import software.bernie.geckolib.animation.EasingType;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/Keyframe.class */
public final class Keyframe<T extends MathValue> extends Record {
    private final double length;
    private final T startValue;
    private final T endValue;
    private final EasingType easingType;
    private final List<T> easingArgs;

    public Keyframe(double length, T startValue, T endValue, EasingType easingType, List<T> easingArgs) {
        this.length = length;
        this.startValue = startValue;
        this.endValue = endValue;
        this.easingType = easingType;
        this.easingArgs = easingArgs;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Keyframe.class), Keyframe.class, "length;startValue;endValue;easingType;easingArgs", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;->length:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;->startValue:Lsoftware/bernie/geckolib/loading/math/MathValue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;->endValue:Lsoftware/bernie/geckolib/loading/math/MathValue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;->easingType:Lsoftware/bernie/geckolib/animation/EasingType;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;->easingArgs:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    public double length() {
        return this.length;
    }

    public T startValue() {
        return this.startValue;
    }

    public T endValue() {
        return this.endValue;
    }

    public EasingType easingType() {
        return this.easingType;
    }

    public List<T> easingArgs() {
        return this.easingArgs;
    }

    public Keyframe(double length, T startValue, T endValue) {
        this(length, startValue, endValue, EasingType.LINEAR);
    }

    public Keyframe(double length, T startValue, T endValue, EasingType easingType) {
        this(length, startValue, endValue, easingType, new ObjectArrayList(0));
    }

    @Override // java.lang.Record
    public int hashCode() {
        return Objects.hash(Double.valueOf(this.length), this.startValue, this.endValue, this.easingType, this.easingArgs);
    }

    @Override // java.lang.Record
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && hashCode() == obj.hashCode();
    }
}
