package foundry.veil.platform.registry;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/platform/registry/RegistrationProvider.class */
public interface RegistrationProvider<T> {
    public static final Factory FACTORY = (Factory) ServiceLoader.load(Factory.class).findFirst().orElseThrow(() -> {
        return new RuntimeException("Failed to load registration provider");
    });

    <I extends T> RegistryObject<I> register(ResourceLocation resourceLocation, Supplier<? extends I> supplier);

    Collection<RegistryObject<T>> getEntries();

    Registry<T> asVanillaRegistry();

    String getModId();

    static <T> RegistrationProvider<T> get(ResourceKey<? extends Registry<T>> resourceKey, String modId) {
        return FACTORY.create(resourceKey, modId);
    }

    static <T> RegistrationProvider<T> get(Registry<T> registry, String modId) {
        return FACTORY.create(registry, modId);
    }

    default <I extends T> RegistryObject<I> register(String name, Supplier<? extends I> supplier) {
        return register(ResourceLocation.fromNamespaceAndPath(getModId(), name), supplier);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/platform/registry/RegistrationProvider$Factory.class */
    public interface Factory {
        <T> RegistrationProvider<T> create(ResourceKey<? extends Registry<T>> resourceKey, String str);

        default <T> RegistrationProvider<T> create(Registry<T> registry, String modId) {
            return create(registry.key(), modId);
        }
    }
}
