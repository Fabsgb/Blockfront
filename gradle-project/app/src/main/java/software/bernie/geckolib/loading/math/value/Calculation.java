package software.bernie.geckolib.loading.math.value;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.Operator;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/value/Calculation.class */
public final class Calculation implements MathValue {
    private final Operator operator;
    private final MathValue argA;
    private final MathValue argB;
    private final boolean isMutable;
    private double cachedValue = Double.MIN_VALUE;

    public Calculation(Operator operator, MathValue argA, MathValue argB) {
        this.operator = operator;
        this.argA = argA;
        this.argB = argB;
        this.isMutable = this.argA.isMutable() || this.argB.isMutable();
    }

    public Operator operator() {
        return this.operator;
    }

    public MathValue argA() {
        return this.argA;
    }

    public MathValue argB() {
        return this.argB;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public double get() {
        if (this.isMutable) {
            return this.operator.compute(this.argA.get(), this.argB.get());
        }
        if (this.cachedValue == Double.MIN_VALUE) {
            this.cachedValue = this.operator.compute(this.argA.get(), this.argB.get());
        }
        return this.cachedValue;
    }

    @Override // software.bernie.geckolib.loading.math.MathValue
    public boolean isMutable() {
        return this.isMutable;
    }

    public String toString() {
        return this.argA.toString() + " " + this.operator.symbol() + " " + this.argB.toString();
    }
}
