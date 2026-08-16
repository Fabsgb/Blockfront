package foundry.veil.forge.platform;

import foundry.veil.platform.registry.RegistrationProvider;
import foundry.veil.platform.registry.RegistryObject;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/platform/NeoForgeRegistrationFactory.class */
@ApiStatus.Internal
public class NeoForgeRegistrationFactory implements RegistrationProvider.Factory {
    @Override // foundry.veil.platform.registry.RegistrationProvider.Factory
    public <T> RegistrationProvider<T> create(ResourceKey<? extends Registry<T>> resourceKey, String modId) {
        FMLModContainer fMLModContainer = (ModContainer) ModList.get().getModContainerById(modId).orElseThrow(() -> {
            return new NullPointerException("Cannot find mod container for id " + modId);
        });
        if (!(fMLModContainer instanceof FMLModContainer)) {
            throw new ClassCastException("The container of the mod " + modId + " is not a FML one!");
        }
        FMLModContainer forgeContainer = fMLModContainer;
        DeferredRegister<T> register = DeferredRegister.create(resourceKey, modId);
        if (!BuiltInRegistries.REGISTRY.containsKey(resourceKey.location())) {
            register.makeRegistry(builder -> {
                builder.sync(false);
            });
        }
        register.register((IEventBus) Objects.requireNonNull(forgeContainer.getEventBus()));
        return new Provider(modId, register);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/platform/NeoForgeRegistrationFactory$Provider.class */
    private static class Provider<T> implements RegistrationProvider<T> {
        private final String modId;
        private final DeferredRegister<T> registry;
        private final Set<RegistryObject<T>> entries = new HashSet();
        private final Set<RegistryObject<T>> entriesView = Collections.unmodifiableSet(this.entries);

        private Provider(String modId, DeferredRegister<T> registry) {
            this.modId = modId;
            this.registry = registry;
        }

        @Override // foundry.veil.platform.registry.RegistrationProvider
        public <I extends T> RegistryObject<I> register(String name, Supplier<? extends I> supplier) {
            DeferredHolder<I, I> obj = this.registry.register(name, supplier);
            NeoForgeRegistryObject neoForgeRegistryObject = new NeoForgeRegistryObject(obj);
            this.entries.add(neoForgeRegistryObject);
            return neoForgeRegistryObject;
        }

        @Override // foundry.veil.platform.registry.RegistrationProvider
        public <I extends T> RegistryObject<I> register(ResourceLocation id, Supplier<? extends I> supplier) {
            NeoForgeRegistryObject neoForgeRegistryObject = new NeoForgeRegistryObject(this.registry.register(id, supplier));
            this.entries.add(neoForgeRegistryObject);
            return neoForgeRegistryObject;
        }

        @Override // foundry.veil.platform.registry.RegistrationProvider
        public Collection<RegistryObject<T>> getEntries() {
            return this.entriesView;
        }

        @Override // foundry.veil.platform.registry.RegistrationProvider
        public Registry<T> asVanillaRegistry() {
            return (Registry) Objects.requireNonNull((Registry) this.registry.getRegistry().get(), "Vanilla registry was not created");
        }

        @Override // foundry.veil.platform.registry.RegistrationProvider
        public String getModId() {
            return this.modId;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/platform/NeoForgeRegistrationFactory$NeoForgeRegistryObject.class */
    private static final class NeoForgeRegistryObject<T, I extends T> extends Record implements RegistryObject<I> {
        private final DeferredHolder<I, I> holder;

        private NeoForgeRegistryObject(DeferredHolder<I, I> holder) {
            this.holder = holder;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, NeoForgeRegistryObject.class), NeoForgeRegistryObject.class, "holder", "FIELD:Lfoundry/veil/forge/platform/NeoForgeRegistrationFactory$NeoForgeRegistryObject;->holder:Lnet/neoforged/neoforge/registries/DeferredHolder;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, NeoForgeRegistryObject.class), NeoForgeRegistryObject.class, "holder", "FIELD:Lfoundry/veil/forge/platform/NeoForgeRegistrationFactory$NeoForgeRegistryObject;->holder:Lnet/neoforged/neoforge/registries/DeferredHolder;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, NeoForgeRegistryObject.class, Object.class), NeoForgeRegistryObject.class, "holder", "FIELD:Lfoundry/veil/forge/platform/NeoForgeRegistrationFactory$NeoForgeRegistryObject;->holder:Lnet/neoforged/neoforge/registries/DeferredHolder;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public DeferredHolder<I, I> holder() {
            return this.holder;
        }

        @Override // foundry.veil.platform.registry.RegistryObject
        public ResourceKey<I> getResourceKey() {
            return this.holder.getKey();
        }

        @Override // foundry.veil.platform.registry.RegistryObject
        public boolean isPresent() {
            return this.holder.isBound();
        }

        @Override // foundry.veil.platform.registry.RegistryObject, java.util.function.Supplier
        public I get() {
            return (I) this.holder.get();
        }

        @Override // foundry.veil.platform.registry.RegistryObject
        public Holder<I> asHolder() {
            return this.holder;
        }
    }
}
