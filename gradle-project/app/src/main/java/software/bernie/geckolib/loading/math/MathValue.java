package software.bernie.geckolib.loading.math;

import java.util.function.DoubleSupplier;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/MathValue.class */
public interface MathValue extends DoubleSupplier {
    double get();

    default boolean isMutable() {
        return true;
    }

    @Override // java.util.function.DoubleSupplier
    @ApiStatus.Internal
    default double getAsDouble() {
        return get();
    }
}
