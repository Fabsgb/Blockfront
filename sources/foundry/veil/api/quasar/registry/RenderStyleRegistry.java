package foundry.veil.api.quasar.registry;

import foundry.veil.Veil;
import foundry.veil.api.quasar.particle.RenderStyle;
import foundry.veil.platform.registry.RegistrationProvider;
import foundry.veil.platform.registry.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/registry/RenderStyleRegistry.class */
public class RenderStyleRegistry {
    public static final ResourceKey<Registry<RenderStyle>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("quasar/render_style"));
    private static final RegistrationProvider<RenderStyle> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<RenderStyle> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final RegistryObject<RenderStyle.Cube> CUBE = register("cube", new RenderStyle.Cube());
    public static final RegistryObject<RenderStyle.Billboard> BILLBOARD = register("billboard", new RenderStyle.Billboard());

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T extends RenderStyle> RegistryObject<T> register(String str, T t) {
        return (RegistryObject<T>) PROVIDER.register(str, () -> {
            return t;
        });
    }
}
