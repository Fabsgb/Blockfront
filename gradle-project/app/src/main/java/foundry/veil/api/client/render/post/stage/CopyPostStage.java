package foundry.veil.api.client.render.post.stage;

import com.boehmod.blockfront.InterfaceC0638xq;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.registry.PostPipelineStageRegistry;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferManager;
import foundry.veil.api.client.render.post.PostPipeline;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/stage/CopyPostStage.class */
public class CopyPostStage extends FramebufferPostStage {
    public static final MapCodec<CopyPostStage> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(FramebufferManager.FRAMEBUFFER_CODEC.fieldOf("in").forGetter((v0) -> {
            return v0.getIn();
        }), FramebufferManager.FRAMEBUFFER_CODEC.fieldOf("out").forGetter((v0) -> {
            return v0.getOut();
        }), Codec.BOOL.optionalFieldOf("color", true).forGetter((v0) -> {
            return v0.copyColor();
        }), Codec.BOOL.optionalFieldOf("depth", false).forGetter((v0) -> {
            return v0.copyDepth();
        }), Codec.BOOL.optionalFieldOf("linear", false).forGetter((v0) -> {
            return v0.isLinear();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new CopyPostStage(v1, v2, v3, v4, v5);
        });
    });
    private final int mask;
    private final int filter;

    public CopyPostStage(ResourceLocation in, ResourceLocation out, boolean copyColor, boolean copyDepth, boolean linear) {
        super(in, out, false);
        this.mask = (copyColor ? InterfaceC0638xq.tV : 0) | (copyDepth ? 256 : 0);
        this.filter = linear ? 9729 : 9728;
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public void apply(PostPipeline.Context context) {
        AdvancedFbo in = context.getFramebuffer(getIn());
        AdvancedFbo out = context.getFramebuffer(getOut());
        if (in != null && out != null) {
            in.resolveToAdvancedFbo(out, this.mask, this.filter);
        }
    }

    @Override // foundry.veil.api.client.render.post.PostPipeline
    public PostPipelineStageRegistry.PipelineType<? extends PostPipeline> getType() {
        return PostPipelineStageRegistry.COPY.get();
    }

    @Override // foundry.veil.api.client.render.post.stage.FramebufferPostStage
    public ResourceLocation getIn() {
        return (ResourceLocation) Objects.requireNonNull(super.getIn());
    }

    public int getMask() {
        return this.mask;
    }

    public int getFilter() {
        return this.filter;
    }

    public boolean copyColor() {
        return (this.mask & InterfaceC0638xq.tV) > 0;
    }

    public boolean copyDepth() {
        return (this.mask & 256) > 0;
    }

    public boolean isLinear() {
        return this.filter == 9729;
    }
}
