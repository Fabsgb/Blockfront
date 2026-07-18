package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/value/Ternary.class */
public final class Ternary extends Record implements MathValue {
    private final MathValue condition;
    private final MathValue trueValue;
    private final MathValue falseValue;

    public Ternary(MathValue condition, MathValue trueValue, MathValue falseValue) {
        this.condition = condition;
        this.trueValue = trueValue;
        this.falseValue = falseValue;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Ternary.class), Ternary.class, "condition;trueValue;falseValue", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Ternary;->condition:Lsoftware/bernie/geckolib/loading/math/MathValue;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Ternary;->trueValue:Lsoftware/bernie/geckolib/loading/math/MathValue;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Ternary;->falseValue:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Ternary.class, Object.class), Ternary.class, "condition;trueValue;falseValue", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Ternary;->condition:Lsoftware/bernie/geckolib/loading/math/MathValue;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Ternary;->trueValue:Lsoftware/bernie/geckolib/loading/math/MathValue;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Ternary;->falseValue:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MathValue condition() {
        return this.condition;
    }

    public MathValue trueValue() {
        return this.trueValue;
    }

    public MathValue falseValue() {
        return this.falseValue;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        return this.condition.get() != 0.0d ? this.trueValue.get() : this.falseValue.get();
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public boolean isMutable() {
        return this.condition.isMutable() || this.trueValue.isMutable() || this.falseValue.isMutable();
    }

    @Override // java.lang.Record
    public String toString() {
        return this.condition.toString() + " ? " + this.trueValue.toString() + " : " + this.falseValue.toString();
    }
}
