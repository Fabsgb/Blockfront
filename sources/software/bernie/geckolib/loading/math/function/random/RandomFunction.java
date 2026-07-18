package software.bernie.geckolib.loading.math.function.random;

import java.util.Random;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/random/RandomFunction.class */
public final class RandomFunction extends MathFunction {
    private final MathValue valueA;

    @Nullable
    private final MathValue valueB;

    @Nullable
    private final MathValue seed;

    @Nullable
    private final Random random;

    public RandomFunction(MathValue... values) {
        super(values);
        this.valueA = values[0];
        this.valueB = values.length >= 2 ? values[1] : null;
        this.seed = values.length >= 3 ? values[2] : null;
        this.random = this.seed != null ? new Random() : null;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.random";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        double result;
        double result2;
        double valueA = this.valueA.get();
        if (this.random != null) {
            this.random.setSeed((long) this.seed.get());
            result = this.random.nextDouble();
        } else {
            result = Math.random();
        }
        if (this.valueB != null) {
            double valueB = this.valueB.get();
            double min = Math.min(valueA, valueB);
            double max = Math.max(valueA, valueB);
            result2 = min + (result * (max - min));
        } else {
            result2 = result * valueA;
        }
        return result2;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public boolean isMutable(MathValue... values) {
        if (values.length < 3) {
            return true;
        }
        return super.isMutable(values);
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 1;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        if (this.seed != null) {
            return new MathValue[]{this.valueA, this.valueB, this.seed};
        }
        if (this.valueB != null) {
            return new MathValue[]{this.valueA, this.valueB};
        }
        return new MathValue[]{this.valueA};
    }
}
