package foundry.veil.api.client.registry;

import foundry.veil.Veil;
import foundry.veil.api.client.render.light.data.AreaLightData;
import foundry.veil.api.client.render.light.data.DirectionalLightData;
import foundry.veil.api.client.render.light.data.LightData;
import foundry.veil.api.client.render.light.data.PointLightData;
import foundry.veil.api.client.render.light.data.SpotLightData;
import foundry.veil.api.client.render.light.renderer.LightTypeRenderer;
import foundry.veil.impl.client.render.light.AreaLightRenderer;
import foundry.veil.impl.client.render.light.DirectionalLightRenderer;
import foundry.veil.impl.client.render.light.InstancedPointLightRenderer;
import foundry.veil.impl.client.render.light.SpotLightRenderer;
import foundry.veil.platform.registry.RegistrationProvider;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/LightTypeRegistry.class */
public final class LightTypeRegistry {
    public static final ResourceKey<Registry<LightType<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("light_type"));
    private static final RegistrationProvider<LightType<?>> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<LightType<?>> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final Supplier<LightType<DirectionalLightData>> DIRECTIONAL = register("directional", DirectionalLightRenderer::new, (level, camera) -> {
        return new DirectionalLightData().setTo(camera).setDirection(0.0f, -1.0f, 0.0f);
    });
    public static final Supplier<LightType<PointLightData>> POINT = register("point", () -> {
        return new InstancedPointLightRenderer();
    }, (level, camera) -> {
        return new PointLightData().setTo(camera).setRadius(15.0f);
    });
    public static final Supplier<LightType<AreaLightData>> AREA = register("area", AreaLightRenderer::new, (level, camera) -> {
        return new AreaLightData().setDistance(15.0f).setTo(camera);
    });
    public static final Supplier<LightType<SpotLightData>> SPOT = register("spot", SpotLightRenderer::new, (level, camera) -> {
        return new SpotLightData().setDistance(15.0f).setTo(camera);
    });

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/LightTypeRegistry$DebugLightFactory.class */
    @FunctionalInterface
    public interface DebugLightFactory {
        LightData createDebugLight(ClientLevel clientLevel, Camera camera);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/LightTypeRegistry$RendererFactory.class */
    @FunctionalInterface
    public interface RendererFactory<T extends LightData> {
        LightTypeRenderer<T> createRenderer();
    }

    private LightTypeRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T extends LightData> Supplier<LightType<T>> register(String str, RendererFactory<T> rendererFactory, @Nullable DebugLightFactory debugLightFactory) {
        return PROVIDER.register(str, () -> {
            return new LightType(rendererFactory, debugLightFactory);
        });
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/LightTypeRegistry$LightType.class */
    public static final class LightType<T extends LightData> extends Record {
        private final RendererFactory<T> rendererFactory;

        @Nullable
        private final DebugLightFactory debugLightFactory;

        public LightType(RendererFactory<T> rendererFactory, @Nullable DebugLightFactory debugLightFactory) {
            this.rendererFactory = rendererFactory;
            this.debugLightFactory = debugLightFactory;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LightType.class), LightType.class, "rendererFactory;debugLightFactory", "FIELD:Lfoundry/veil/api/client/registry/LightTypeRegistry$LightType;->rendererFactory:Lfoundry/veil/api/client/registry/LightTypeRegistry$RendererFactory;", "FIELD:Lfoundry/veil/api/client/registry/LightTypeRegistry$LightType;->debugLightFactory:Lfoundry/veil/api/client/registry/LightTypeRegistry$DebugLightFactory;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LightType.class), LightType.class, "rendererFactory;debugLightFactory", "FIELD:Lfoundry/veil/api/client/registry/LightTypeRegistry$LightType;->rendererFactory:Lfoundry/veil/api/client/registry/LightTypeRegistry$RendererFactory;", "FIELD:Lfoundry/veil/api/client/registry/LightTypeRegistry$LightType;->debugLightFactory:Lfoundry/veil/api/client/registry/LightTypeRegistry$DebugLightFactory;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LightType.class, Object.class), LightType.class, "rendererFactory;debugLightFactory", "FIELD:Lfoundry/veil/api/client/registry/LightTypeRegistry$LightType;->rendererFactory:Lfoundry/veil/api/client/registry/LightTypeRegistry$RendererFactory;", "FIELD:Lfoundry/veil/api/client/registry/LightTypeRegistry$LightType;->debugLightFactory:Lfoundry/veil/api/client/registry/LightTypeRegistry$DebugLightFactory;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public RendererFactory<T> rendererFactory() {
            return this.rendererFactory;
        }

        @Nullable
        public DebugLightFactory debugLightFactory() {
            return this.debugLightFactory;
        }
    }
}
