package software.bernie.geckolib.loading.math.function.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/random/RandomIntegerFunction.class */
public final class RandomIntegerFunction extends MathFunction {
    private final MathValue valueA;

    @Nullable
    private final MathValue valueB;

    @Nullable
    private final MathValue seed;

    @Nullable
    private final Random random;

    public RandomIntegerFunction(MathValue... values) {
        super(values);
        this.valueA = values[0];
        this.valueB = values.length >= 2 ? values[1] : null;
        this.seed = values.length >= 3 ? values[2] : null;
        this.random = this.seed != null ? new Random() : null;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.random_integer";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        Random random;
        int result;
        int valueA = (int) Math.round(this.valueA.get());
        if (this.random != null) {
            this.random.setSeed((long) this.seed.get());
            random = this.random;
        } else {
            random = ThreadLocalRandom.current();
        }
        if (this.valueB != null) {
            int valueB = (int) Math.round(this.valueB.get());
            int min = Math.min(valueA, valueB);
            int max = Math.max(valueA, valueB);
            result = min + random.nextInt((max + 1) - min);
        } else {
            result = random.nextInt(0, valueA + 1);
        }
        return result;
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
