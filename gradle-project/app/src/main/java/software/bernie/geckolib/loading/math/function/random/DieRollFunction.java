package software.bernie.geckolib.loading.math.function.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/random/DieRollFunction.class */
public final class DieRollFunction extends MathFunction {
    private final MathValue rolls;
    private final MathValue min;
    private final MathValue max;

    @Nullable
    private final MathValue seed;

    @Nullable
    private final Random random;

    public DieRollFunction(MathValue... values) {
        super(values);
        this.rolls = values[0];
        this.min = values[1];
        this.max = values[2];
        this.seed = values.length >= 4 ? values[3] : null;
        this.random = this.seed != null ? new Random() : null;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.die_roll";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        Random random;
        int rolls = (int) Math.floor(this.rolls.get());
        double min = this.min.get();
        double max = this.max.get();
        double sum = 0.0d;
        if (this.random != null) {
            random = this.random;
            random.setSeed((long) this.seed.get());
        } else {
            random = ThreadLocalRandom.current();
        }
        for (int i = 0; i < rolls; i++) {
            sum += min + (random.nextDouble() * (max - min));
        }
        return sum;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public boolean isMutable(MathValue... values) {
        if (values.length < 4) {
            return true;
        }
        return super.isMutable(values);
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 3;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        if (this.seed != null) {
            return new MathValue[]{this.rolls, this.min, this.max, this.seed};
        }
        return new MathValue[]{this.rolls, this.min, this.max};
    }
}
