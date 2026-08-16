package foundry.veil.api.client.registry;

import com.mojang.serialization.MapCodec;
import foundry.veil.Veil;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.post.stage.BlitPostStage;
import foundry.veil.api.client.render.post.stage.CopyPostStage;
import foundry.veil.api.client.render.post.stage.DepthFunctionPostStage;
import foundry.veil.api.client.render.post.stage.MaskPostStage;
import foundry.veil.platform.registry.RegistrationProvider;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/PostPipelineStageRegistry.class */
public final class PostPipelineStageRegistry {
    public static final ResourceKey<Registry<PipelineType<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("post_pipeline_stage"));
    private static final RegistrationProvider<PipelineType<?>> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);
    public static final Registry<PipelineType<?>> REGISTRY = PROVIDER.asVanillaRegistry();
    public static final Supplier<PipelineType<BlitPostStage>> BLIT = register("blit", BlitPostStage.CODEC);
    public static final Supplier<PipelineType<CopyPostStage>> COPY = register("copy", CopyPostStage.CODEC);
    public static final Supplier<PipelineType<MaskPostStage>> MASK = register("mask", MaskPostStage.CODEC);
    public static final Supplier<PipelineType<DepthFunctionPostStage>> DEPTH_FUNC = register("depth_function", DepthFunctionPostStage.CODEC);

    private PostPipelineStageRegistry() {
    }

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T extends PostPipeline> Supplier<PipelineType<T>> register(String str, MapCodec<T> mapCodec) {
        return PROVIDER.register(str, () -> {
            return new PipelineType(mapCodec);
        });
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/registry/PostPipelineStageRegistry$PipelineType.class */
    public static final class PipelineType<T extends PostPipeline> extends Record {
        private final MapCodec<T> codec;

        public PipelineType(MapCodec<T> codec) {
            this.codec = codec;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PipelineType.class), PipelineType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/PostPipelineStageRegistry$PipelineType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PipelineType.class), PipelineType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/PostPipelineStageRegistry$PipelineType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PipelineType.class, Object.class), PipelineType.class, "codec", "FIELD:Lfoundry/veil/api/client/registry/PostPipelineStageRegistry$PipelineType;->codec:Lcom/mojang/serialization/MapCodec;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public MapCodec<T> codec() {
            return this.codec;
        }
    }
}
