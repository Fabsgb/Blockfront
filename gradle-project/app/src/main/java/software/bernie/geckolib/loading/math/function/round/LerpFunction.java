package software.bernie.geckolib.loading.math.function.round;

import net.minecraft.util.Mth;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/function/round/LerpFunction.class */
public final class LerpFunction extends MathFunction {
    private final MathValue min;
    private final MathValue max;
    private final MathValue delta;

    public LerpFunction(MathValue... values) {
        super(values);
        this.min = values[0];
        this.max = values[1];
        this.delta = values[2];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.lerp";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return Mth.lerp(this.delta.get(), this.min.get(), this.max.get());
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
