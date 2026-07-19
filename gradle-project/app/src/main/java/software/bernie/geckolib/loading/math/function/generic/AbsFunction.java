package software.bernie.geckolib.loading.math.function.generic;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/generic/AbsFunction.class */
public final class AbsFunction extends MathFunction {
    private final MathValue value;

    public AbsFunction(MathValue... values) {
        super(values);
        this.value = values[0];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.abs";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return Math.abs(this.value.get());
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 1;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        return new MathValue[]{this.value};
    }
}
