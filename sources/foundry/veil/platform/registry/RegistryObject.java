package foundry.veil.platform.registry;

import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/platform/registry/RegistryObject.class */
public interface RegistryObject<T> extends Supplier<T> {
    ResourceKey<T> getResourceKey();

    boolean isPresent();

    @Override // java.util.function.Supplier
    T get();

    Holder<T> asHolder();

    default ResourceLocation getId() {
        return getResourceKey().location();
    }
}
