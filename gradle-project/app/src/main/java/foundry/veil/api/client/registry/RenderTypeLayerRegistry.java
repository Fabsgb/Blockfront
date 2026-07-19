package foundry.veil.api.client.registry;

import com.mojang.serialization.MapCodec;
import foundry.veil.Veil;
import foundry.veil.api.client.render.rendertype.layer.ColorLogicLayer;
import foundry.veil.api.client.render.rendertype.layer.CullLayer;
import foundry.veil.api.client.render.rendertype.layer.DepthClampLayer;
import foundry.veil.api.client.render.rendertype.layer.DepthTestLayer;
import foundry.veil.api.client.render.rendertype.layer.LayeringLayer;
import foundry.veil.api.client.render.rendertype.layer.LightmapLayer;
import foundry.veil.api.client.render.rendertype.layer.LineLayer;
import foundry.veil.api.client.render.rendertype.layer.MultiTextureLayer;
import foundry.veil.api.client.render.rendertype.layer.MultisampleLayer;
import foundry.veil.api.client.render.rendertype.layer.OutputLayer;
import foundry.veil.api.client.render.rendertype.layer.OverlayLayer;
import foundry.veil.api.client.render.rendertype.layer.PatchesLayer;
import foundry.veil.api.client.render.rendertype.layer.RenderTypeLayer;
import foundry.veil.api.client.render.rendertype.layer.SeamlessCubemapLayer;
import foundry.veil.api.client.render.rendertype.layer.TextureLayer;
import foundry.veil.api.client.render.rendertype.layer.TexturingLayer;
import foundry.veil.api.client.render.rendertype.layer.TransparencyLayer;
import foundry.veil.api.client.render.rendertype.layer.VanillaShaderLayer;
import foundry.veil.api.client.render.rendertype.layer.VeilShaderLayer;
import foundry.veil.api.client.render.rendertype.layer.WriteMaskLayer;
import foundry.veil.platform.registry.RegistrationProvider;
import foundry.veil.platform.registry.RegistryObject;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/RenderTypeLayerRegistry.class */
public final class RenderTypeLayerRegistry {
    public static final ResourceKey<Registry<LayerType<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("render_type_layer"));
    private static final RegistrationProvider<LayerType<?>> VANILLA_PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<LayerType<?>> REGISTRY = VANILLA_PROVIDER.asVanillaRegistry();
    public static final RegistryObject<LayerType<TextureLayer>> TEXTURE = register("texture", TextureLayer.CODEC);
    public static final RegistryObject<LayerType<MultiTextureLayer>> MULTI_TEXTURE = register("multi_texture", MultiTextureLayer.CODEC);
    public static final RegistryObject<LayerType<VanillaShaderLayer>> VANILLA_SHADER = register("shader", VanillaShaderLayer.CODEC);
    public static final RegistryObject<LayerType<VeilShaderLayer>> VEIL_SHADER = register(Veil.veilPath("shader"), VeilShaderLayer.CODEC);
    public static final RegistryObject<LayerType<TransparencyLayer>> TRANSPARENCY = register("transparency", TransparencyLayer.CODEC);
    public static final RegistryObject<LayerType<DepthTestLayer>> DEPTH_TEST = register("depth_test", DepthTestLayer.CODEC);
    public static final RegistryObject<LayerType<CullLayer>> CULL = register("cull", CullLayer.CODEC);
    public static final RegistryObject<LayerType<LightmapLayer>> LIGHTMAP = register("lightmap", LightmapLayer.CODEC);
    public static final RegistryObject<LayerType<OverlayLayer>> OVERLAY = register("overlay", OverlayLayer.CODEC);
    public static final RegistryObject<LayerType<LayeringLayer>> LAYERING = register("layering", LayeringLayer.CODEC);
    public static final RegistryObject<LayerType<OutputLayer>> OUTPUT = register("output", OutputLayer.CODEC);
    public static final RegistryObject<LayerType<TexturingLayer>> TEXTURING = register("texturing", TexturingLayer.CODEC);
    public static final RegistryObject<LayerType<WriteMaskLayer>> WRITE_MASK = register("write_mask", WriteMaskLayer.CODEC);
    public static final RegistryObject<LayerType<LineLayer>> LINE = register("line", LineLayer.CODEC);
    public static final RegistryObject<LayerType<ColorLogicLayer>> COLOR_LOGIC = register("color_logic", ColorLogicLayer.CODEC);
    public static final RegistryObject<LayerType<PatchesLayer>> PATCHES = register(Veil.veilPath("patches"), PatchesLayer.CODEC);
    public static final RegistryObject<LayerType<DepthClampLayer>> DEPTH_CLAMP = register(Veil.veilPath("depth_clamp"), DepthClampLayer.CODEC);
    public static final RegistryObject<LayerType<MultisampleLayer>> MULTISAMPLE = register(Veil.veilPath("multisample"), MultisampleLayer.CODEC);
    public static final RegistryObject<LayerType<SeamlessCubemapLayer>> SEAMLESS_CUBEMAP = register(Veil.veilPath("seamless_cubemap"), SeamlessCubemapLayer.CODEC);

    private RenderTypeLayerRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T extends RenderTypeLayer> RegistryObject<LayerType<T>> register(String str, MapCodec<T> mapCodec) {
        return (RegistryObject<LayerType<T>>) VANILLA_PROVIDER.register(ResourceLocation.withDefaultNamespace(str), () -> {
            return new LayerType(mapCodec);
        });
    }

    private static <T extends RenderTypeLayer> RegistryObject<LayerType<T>> register(ResourceLocation resourceLocation, MapCodec<T> mapCodec) {
        return (RegistryObject<LayerType<T>>) VANILLA_PROVIDER.register(resourceLocation, () -> {
            return new LayerType(mapCodec);
        });
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/registry/RenderTypeLayerRegistry$LayerType.class */
    public static final class LayerType<T extends RenderTypeLayer> extends Record {
        private final MapCodec<T> codec;

        public LayerType(MapCodec<T> codec) {
            this.codec = codec;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, LayerType.class), LayerType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeLayerRegistry$LayerType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LayerType.class), LayerType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeLayerRegistry$LayerType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LayerType.class, Object.class), LayerType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/RenderTypeLayerRegistry$LayerType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public MapCodec<T> codec() {
            return this.codec;
        }
    }
}
