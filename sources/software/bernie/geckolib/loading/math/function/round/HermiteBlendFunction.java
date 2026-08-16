package software.bernie.geckolib.loading.math.function.round;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/function/round/HermiteBlendFunction.class */
public final class HermiteBlendFunction extends MathFunction {
    private final MathValue valueA;

    public HermiteBlendFunction(MathValue... values) {
        super(values);
        this.valueA = values[0];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.hermite_blend";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        double value = this.valueA.get();
        return ((3.0d * value) * value) - (((2.0d * value) * value) * value);
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 1;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        return new MathValue[]{this.valueA};
    }
}
