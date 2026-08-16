package foundry.veil.forge.mixin;

import foundry.veil.forge.ext.DeferredRegisterExtensions;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/DeferredRegisterMixin.class */
@Mixin({DeferredRegister.class})
public abstract class DeferredRegisterMixin<T> implements DeferredRegisterExtensions<T> {

    @Shadow
    private boolean seenRegisterEvent;

    @Shadow
    @Final
    private ResourceKey<? extends Registry<T>> registryKey;

    @Shadow
    @Final
    private Map<DeferredHolder<T, ? extends T>, Supplier<? extends T>> entries;

    @Shadow
    protected abstract <I extends T> DeferredHolder<T, I> createHolder(ResourceKey<? extends Registry<T>> resourceKey, ResourceLocation resourceLocation);

    @Override // foundry.veil.forge.ext.DeferredRegisterExtensions
    public <I extends T> DeferredHolder<T, I> register(ResourceLocation key, Function<ResourceLocation, ? extends I> func) {
        if (this.seenRegisterEvent) {
            throw new IllegalStateException("Cannot register new entries to DeferredRegister after RegisterEvent has been fired.");
        }
        Objects.requireNonNull(key);
        Objects.requireNonNull(func);
        DeferredHolder<T, I> holder = createHolder(this.registryKey, key);
        if (this.entries.putIfAbsent(holder, () -> {
            return func.apply(key);
        }) != null) {
            throw new IllegalArgumentException("Duplicate registration " + String.valueOf(key));
        }
        return holder;
    }
}
