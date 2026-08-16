package foundry.veil.mixin.registry.accessor;

import com.mojang.serialization.Lifecycle;
import java.util.Map;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/registry/accessor/RegistryDataAccessor.class */
@Mixin({RegistryDataLoader.RegistryData.class})
public interface RegistryDataAccessor {
    @Invoker
    RegistryDataLoader.Loader<?> invokeCreate(Lifecycle lifecycle, Map<ResourceKey<?>, Exception> map);
}
