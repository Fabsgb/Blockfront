package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/value/BooleanNegate.class */
public final class BooleanNegate extends Record implements MathValue {
    private final MathValue value;

    public BooleanNegate(MathValue value) {
        this.value = value;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BooleanNegate.class), BooleanNegate.class, "value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/BooleanNegate;->value:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BooleanNegate.class, Object.class), BooleanNegate.class, "value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/BooleanNegate;->value:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MathValue value() {
        return this.value;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        return this.value.get() == 0.0d ? 1.0d : 0.0d;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public boolean isMutable() {
        return this.value.isMutable();
    }

    @Override // java.lang.Record
    public String toString() {
        return "!" + this.value.toString();
    }
}
