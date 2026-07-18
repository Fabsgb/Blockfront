package software.bernie.geckolib.platform;

import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.service.GeckoLibPlatform;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/platform/GeckoLibNeoForge.class */
public final class GeckoLibNeoForge implements GeckoLibPlatform {
    @Override // software.bernie.geckolib.service.GeckoLibPlatform
    public boolean isDevelopmentEnvironment() {
        return !FMLEnvironment.production;
    }

    @Override // software.bernie.geckolib.service.GeckoLibPlatform
    public Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    @Override // software.bernie.geckolib.service.GeckoLibPlatform
    public boolean isPhysicalClient() {
        return FMLEnvironment.dist.isClient();
    }

    @Override // software.bernie.geckolib.service.GeckoLibPlatform
    public <T> Supplier<DataComponentType<T>> registerDataComponent(String id, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return GeckoLib.DATA_COMPONENTS_REGISTER.registerComponentType(id, builder);
    }
}
