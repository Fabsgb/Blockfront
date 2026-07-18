package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/value/Constant.class */
public final class Constant extends Record implements MathValue {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Constant.class), Constant.class, "value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Constant;->value:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Constant.class, Object.class), Constant.class, "value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Constant;->value:D").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public double value() {
        return this.value;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        return this.value;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public boolean isMutable() {
        return false;
    }

    @Override // java.lang.Record
    public String toString() {
        return String.valueOf(this.value);
    }
}
