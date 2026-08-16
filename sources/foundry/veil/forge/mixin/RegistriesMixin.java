package foundry.veil.forge.mixin;

import foundry.veil.api.resource.VeilDynamicRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/RegistriesMixin.class */
@Mixin({Registries.class})
public class RegistriesMixin {
    @Inject(method = {"elementsDirPath"}, at = {@At("HEAD")}, cancellable = true)
    private static void veilElementsPath(ResourceKey<? extends Registry<?>> pRegistryKey, CallbackInfoReturnable<String> cir) {
        if (VeilDynamicRegistry.isLoading()) {
            cir.setReturnValue(pRegistryKey.location().getPath());
        }
    }

    @Inject(method = {"tagsDirPath"}, at = {@At("HEAD")}, cancellable = true)
    private static void veilTagsPath(ResourceKey<? extends Registry<?>> pRegistryKey, CallbackInfoReturnable<String> cir) {
        if (VeilDynamicRegistry.isLoading()) {
            cir.setReturnValue(pRegistryKey.location().getPath());
        }
    }
}
