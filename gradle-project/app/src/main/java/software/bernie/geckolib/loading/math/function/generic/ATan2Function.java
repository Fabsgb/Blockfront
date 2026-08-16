package software.bernie.geckolib.loading.math.function.generic;

import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/function/generic/ATan2Function.class */
public final class ATan2Function extends MathFunction {

    /* JADX INFO: renamed from: y */
    private final MathValue f9203y;

    /* JADX INFO: renamed from: x */
    private final MathValue f9204x;

    public ATan2Function(MathValue... values) {
        super(values);
        this.f9203y = values[0];
        this.f9204x = values[1];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.atan2";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return Math.atan2(this.f9203y.get(), this.f9204x.get()) * 57.2957763671875d;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public int getMinArgs() {
        return 2;
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public MathValue[] getArgs() {
        return new MathValue[]{this.f9203y, this.f9204x};
    }
}
