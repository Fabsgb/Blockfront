package software.bernie.geckolib.loading.math.function.misc;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;
import software.bernie.geckolib.loading.math.value.Constant;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/misc/PiFunction.class */
public final class PiFunction extends MathFunction {
    public PiFunction(MathValue... values) {
        super(values);
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.pi";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return 3.141592653589793d;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public boolean isMutable(MathValue... values) {
        return false;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 0;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        return new MathValue[]{new Constant(3.141592653589793d)};
    }
}
