package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.StringJoiner;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/value/CompoundValue.class */
public final class CompoundValue extends Record implements MathValue {
    private final MathValue[] subValues;

    public CompoundValue(MathValue[] subValues) {
        this.subValues = subValues;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CompoundValue.class), CompoundValue.class, "subValues", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/CompoundValue;->subValues:[Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CompoundValue.class, Object.class), CompoundValue.class, "subValues", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/CompoundValue;->subValues:[Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MathValue[] subValues() {
        return this.subValues;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        for (int i = 0; i < this.subValues.length - 1; i++) {
            this.subValues[i].get();
        }
        return this.subValues[this.subValues.length - 1].get();
    }

    @Override // java.lang.Record
    public String toString() {
        StringJoiner joiner = new StringJoiner("; ");
        for (MathValue subValue : this.subValues) {
            joiner.add(subValue.toString());
        }
        return joiner.toString();
    }
}
