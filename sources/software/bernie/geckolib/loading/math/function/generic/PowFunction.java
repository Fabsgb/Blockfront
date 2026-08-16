package software.bernie.geckolib.loading.math.function.generic;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/function/generic/PowFunction.class */
public final class PowFunction extends MathFunction {
    private final MathValue value;
    private final MathValue power;

    public PowFunction(MathValue... values) {
        super(values);
        this.value = values[0];
        this.power = values[1];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.pow";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return Math.pow(this.value.get(), this.power.get());
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 2;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        return new MathValue[]{this.value, this.power};
    }
}
