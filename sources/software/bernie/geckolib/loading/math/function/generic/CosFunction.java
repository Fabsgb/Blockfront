package software.bernie.geckolib.loading.math.function.generic;

import net.minecraft.util.Mth;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.function.MathFunction;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/function/generic/CosFunction.class */
public final class CosFunction extends MathFunction {
    private final MathValue value;

    public CosFunction(MathValue... values) {
        super(values);
        this.value = values[0];
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public String getName() {
        return "math.cos";
    }

    @Override // software.bernie.geckolib.loading.math.function.MathFunction
    public double compute() {
        return Mth.cos(((float) this.value.get()) * 0.017453292f);
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
