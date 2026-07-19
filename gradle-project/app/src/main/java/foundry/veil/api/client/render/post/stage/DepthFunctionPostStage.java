package foundry.veil.api.client.render.post.stage;

import com.boehmod.blockfront.InterfaceC0638xq;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.render.post.PostPipeline;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/stage/DepthFunctionPostStage.class */
public final class DepthFunctionPostStage extends Record implements PostPipeline {
    private final DepthFunc func;
    public static final MapCodec<DepthFunctionPostStage> CODEC = DepthFunc.CODEC.fieldOf("function").xmap(DepthFunctionPostStage::new, (v0) -> {
        return v0.func();
    });

    public DepthFunctionPostStage(DepthFunc func) {
        this.func = func;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DepthFunctionPostStage.class), DepthFunctionPostStage.class, "func", "FIELD:Lfoundry/veil/api/client/render/post/stage/DepthFunctionPostStage;->func:Lfoundry/veil/api/client/render/post/stage/DepthFunctionPostStage$DepthFunc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DepthFunctionPostStage.class), DepthFunctionPostStage.class, "func", "FIELD:Lfoundry/veil/api/client/render/post/stage/DepthFunctionPostStage;->func:Lfoundry/veil/api/client/render/post/stage/DepthFunctionPostStage$DepthFunc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DepthFunctionPostStage.class, Object.class), DepthFunctionPostStage.class, "func", "FIELD:Lfoundry/veil/api/client/render/post/stage/DepthFunctionPostStage;->func:Lfoundry/veil/api/client/render/post/stage/DepthFunctionPostStage$DepthFunc;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public DepthFunc func() {
        return this.func;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public void apply(PostPipeline.Context context) {
        RenderSystem.depthFunc(this.func.getId());
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public PostPipelineStageRegistry.PipelineType<? extends PostPipeline> getType() {
        return PostPipelineStageRegistry.DEPTH_FUNC.get();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/stage/DepthFunctionPostStage$DepthFunc.class */
    public enum DepthFunc {
        NEVER(InterfaceC0638xq.tQ),
        LESS(513),
        EQUAL(514),
        LEQUAL(515),
        GREATER(516),
        NOTEQUAL(517),
        GEQUAL(518),
        ALWAYS(519);

        public static final Codec<DepthFunc> CODEC = Codec.STRING.flatXmap(name -> {
            for (DepthFunc type : values()) {
                if (type.name().equalsIgnoreCase(name)) {
                    return DataResult.success(type);
                }
            }
            return DataResult.error(() -> {
                return "Unknown depth function: " + name;
            });
        }, type -> {
            return DataResult.success(type.name());
        });
        private final int id;

        DepthFunc(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }
}
