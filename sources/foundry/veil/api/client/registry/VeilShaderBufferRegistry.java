package foundry.veil.api.client.registry;

import com.boehmod.blockfront.C1230wX;
import foundry.veil.Veil;
import foundry.veil.api.client.render.CameraMatrices;
import foundry.veil.api.client.render.GuiInfo;
import foundry.veil.api.client.render.VeilShaderBufferLayout;
import foundry.veil.platform.registry.RegistrationProvider;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/VeilShaderBufferRegistry.class */
public final class VeilShaderBufferRegistry {
    public static final ResourceKey<Registry<VeilShaderBufferLayout<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("shader_buffer"));
    private static final RegistrationProvider<VeilShaderBufferLayout<?>> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<VeilShaderBufferLayout<?>> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final Supplier<VeilShaderBufferLayout<CameraMatrices>> CAMERA = register(C1230wX.f6994dU, CameraMatrices::createLayout);
    public static final Supplier<VeilShaderBufferLayout<GuiInfo>> GUI_INFO = register("gui_info", GuiInfo::createLayout);

    private VeilShaderBufferRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T> Supplier<VeilShaderBufferLayout<T>> register(String str, Supplier<VeilShaderBufferLayout<T>> supplier) {
        return PROVIDER.register(str, supplier);
    }
}
