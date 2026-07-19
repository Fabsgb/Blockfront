package software.bernie.geckolib.loading.math.function;

import java.util.StringJoiner;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/MathFunction.class */
public abstract class MathFunction implements MathValue {
    private final boolean isMutable;
    private double cachedValue = Double.MIN_VALUE;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/MathFunction$Factory.class */
    @FunctionalInterface
    public interface Factory<T extends MathFunction> {
        T create(MathValue... mathValueArr);
    }

    public abstract String getName();

    public abstract double compute();

    public abstract int getMinArgs();

    public abstract MathValue[] getArgs();

    protected MathFunction(MathValue... values) {
        validate(values);
        this.isMutable = isMutable(values);
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public final double get() {
        if (this.isMutable) {
            return compute();
        }
        if (this.cachedValue == Double.MIN_VALUE) {
            this.cachedValue = compute();
        }
        return this.cachedValue;
    }

    public boolean isMutable(MathValue... values) {
        for (MathValue value : values) {
            if (value.isMutable()) {
                return true;
            }
        }
        return false;
    }

    public void validate(MathValue... inputs) throws IllegalArgumentException {
        int minArgs = getMinArgs();
        if (inputs.length < minArgs) {
            throw new IllegalArgumentException(String.format("Function '%s' at least %s arguments. Only %s given!", getName(), Integer.valueOf(minArgs), Integer.valueOf(inputs.length)));
        }
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public final boolean isMutable() {
        return this.isMutable;
    }

    public String toString() {
        MathValue[] args = getArgs();
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        for (MathValue arg : args) {
            joiner.add(arg.toString());
        }
        return getName() + String.valueOf(joiner);
    }
}
