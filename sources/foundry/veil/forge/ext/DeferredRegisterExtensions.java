package foundry.veil.forge.ext;

import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/ext/DeferredRegisterExtensions.class */
public interface DeferredRegisterExtensions<T> {
    <I extends T> DeferredHolder<T, I> register(ResourceLocation resourceLocation, Function<ResourceLocation, ? extends I> function);

    default <I extends T> DeferredHolder<T, I> register(ResourceLocation name, Supplier<? extends I> sup) {
        return register(name, key -> {
            return sup.get();
        });
    }
}
