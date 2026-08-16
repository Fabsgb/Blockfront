package software.bernie.geckolib.loading.math.value;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.DoubleSupplier;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/value/Variable.class */
public final class Variable extends Record implements MathValue {
    private final String name;
    private final AtomicReference<DoubleSupplier> value;

    public Variable(String name, AtomicReference<DoubleSupplier> value) {
        this.name = name;
        this.value = value;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Variable.class), Variable.class, "name;value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Variable;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Variable;->value:Ljava/util/concurrent/atomic/AtomicReference;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Variable.class, Object.class), Variable.class, "name;value", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Variable;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/math/value/Variable;->value:Ljava/util/concurrent/atomic/AtomicReference;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String name() {
        return this.name;
    }

    public AtomicReference<DoubleSupplier> value() {
        return this.value;
    }

    public Variable(String name, double value) {
        this(name, () -> {
            return value;
        });
    }

    public Variable(String name, DoubleSupplier value) {
        this(name, (AtomicReference<DoubleSupplier>) new AtomicReference(value));
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        try {
            return this.value.get().getAsDouble();
        } catch (Exception ex) {
            GeckoLibConstants.LOGGER.error("Attempted to use Molang variable for incompatible animatable type (" + this.name + "). An animation json needs to be fixed", ex.getMessage());
            return 0.0d;
        }
    }

    public void set(double value) {
        this.value.set(() -> {
            return value;
        });
    }

    public void set(DoubleSupplier value) {
        this.value.set(value);
    }

    @Override // java.lang.Record
    public String toString() {
        return this.name + "(" + this.value.get().getAsDouble() + ")";
    }
}
