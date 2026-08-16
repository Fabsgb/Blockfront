package software.bernie.geckolib.loading.math.function.round;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/function/round/LerpRotFunction.class */
public final class LerpRotFunction extends MathFunction {
    private final MathValue min;
    private final MathValue max;
    private final MathValue delta;

    public LerpRotFunction(MathValue... values) {
        super(values);
        this.min = values[0];
        this.max = values[1];
        this.delta = values[2];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.lerprotate";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return RenderUtil.lerpYaw(this.delta.get(), this.min.get(), this.max.get());
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 3;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        return new MathValue[]{this.min, this.max, this.delta};
    }
}
