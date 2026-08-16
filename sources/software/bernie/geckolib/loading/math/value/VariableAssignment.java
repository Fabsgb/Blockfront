package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/value/VariableAssignment.class */
public final class VariableAssignment extends Record implements MathValue {
    private final Variable variable;
    private final MathValue value;

    public VariableAssignment(Variable variable, MathValue value) {
        this.variable = variable;
        this.value = value;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VariableAssignment.class), VariableAssignment.class, "variable;value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/VariableAssignment;->variable:Lsoftware/bernie/geckolib/loading/math/value/Variable;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/VariableAssignment;->value:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VariableAssignment.class, Object.class), VariableAssignment.class, "variable;value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/VariableAssignment;->variable:Lsoftware/bernie/geckolib/loading/math/value/Variable;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/VariableAssignment;->value:Lsoftware/bernie/geckolib/loading/math/MathValue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Variable variable() {
        return this.variable;
    }

    public MathValue value() {
        return this.value;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        this.variable.set(this.value.get());
        return 0.0d;
    }

    @Override // java.lang.Record
    public String toString() {
        return this.variable.name() + "=" + this.value.toString();
    }
}
