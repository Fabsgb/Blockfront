package software.bernie.geckolib.service;

import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import net.minecraft.core.component.DataComponentType;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/service/GeckoLibPlatform.class */
public interface GeckoLibPlatform {
    boolean isDevelopmentEnvironment();

    boolean isPhysicalClient();

    Path getGameDir();

    <T> Supplier<DataComponentType<T>> registerDataComponent(String str, UnaryOperator<DataComponentType.Builder<T>> unaryOperator);
}
