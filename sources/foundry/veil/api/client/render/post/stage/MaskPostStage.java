package foundry.veil.api.client.render.post.stage;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.render.post.PostPipeline;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/stage/MaskPostStage.class */
public final class MaskPostStage extends Record implements PostPipeline {
    private final boolean red;
    private final boolean green;
    private final boolean blue;
    private final boolean alpha;
    private final boolean depth;
    public static final MapCodec<MaskPostStage> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.optionalFieldOf("red", true).forGetter((v0) -> {
            return v0.red();
        }), Codec.BOOL.optionalFieldOf("green", true).forGetter((v0) -> {
            return v0.green();
        }), Codec.BOOL.optionalFieldOf("blue", true).forGetter((v0) -> {
            return v0.blue();
        }), Codec.BOOL.optionalFieldOf("alpha", true).forGetter((v0) -> {
            return v0.alpha();
        }), Codec.BOOL.optionalFieldOf("depth", false).forGetter((v0) -> {
            return v0.depth();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new MaskPostStage(v1, v2, v3, v4, v5);
        });
    });

    public MaskPostStage(boolean red, boolean green, boolean blue, boolean alpha, boolean depth) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        this.depth = depth;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MaskPostStage.class), MaskPostStage.class, "red;green;blue;alpha;depth", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->red:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->green:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->blue:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->alpha:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->depth:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MaskPostStage.class), MaskPostStage.class, "red;green;blue;alpha;depth", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->red:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->green:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->blue:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->alpha:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->depth:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MaskPostStage.class, Object.class), MaskPostStage.class, "red;green;blue;alpha;depth", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->red:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->green:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->blue:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->alpha:Z", "FIELD:Lfoundry/veil/api/client/render/post/stage/MaskPostStage;->depth:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public boolean red() {
        return this.red;
    }

    public boolean green() {
        return this.green;
    }

    public boolean blue() {
        return this.blue;
    }

    public boolean alpha() {
        return this.alpha;
    }

    public boolean depth() {
        return this.depth;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public void apply(PostPipeline.Context context) {
        RenderSystem.colorMask(this.red, this.green, this.blue, this.alpha);
        RenderSystem.depthMask(this.depth);
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public PostPipelineStageRegistry.PipelineType<? extends PostPipeline> getType() {
        return PostPipelineStageRegistry.MASK.get();
    }
}
