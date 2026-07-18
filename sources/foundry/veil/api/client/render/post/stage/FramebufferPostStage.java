package foundry.veil.api.client.render.post.stage;

import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/stage/FramebufferPostStage.class */
public abstract class FramebufferPostStage implements PostPipeline {

    /* JADX INFO: renamed from: in */
    private final ResourceLocation f8748in;
    private final ResourceLocation out;
    private final boolean clear;

    public FramebufferPostStage(@Nullable ResourceLocation in, ResourceLocation out, boolean clear) {
        this.f8748in = in;
        this.out = out;
        this.clear = clear;
    }

    protected void setupFramebuffer(PostPipeline.Context context, ShaderProgram shader) {
        AdvancedFbo in = this.f8748in != null ? context.getFramebuffer(this.f8748in) : null;
        AdvancedFbo out = context.getFramebufferOrDraw(this.out);
        if (in != null) {
            shader.setFramebufferSamplers(in);
        }
        out.bind(true);
        if (this.clear) {
            out.clear();
        }
        ShaderUniform inSize = shader.getUniform("InSize");
        if (inSize != null) {
            if (in != null) {
                inSize.setVector(in.getWidth(), in.getHeight());
            } else {
                inSize.setVector(1.0f, 1.0f);
            }
        }
        ShaderUniform outSize = shader.getUniform("OutSize");
        if (outSize != null) {
            outSize.setVector(out.getWidth(), out.getHeight());
        }
    }

    @Nullable
    public ResourceLocation getIn() {
        return this.f8748in;
    }

    public ResourceLocation getOut() {
        return this.out;
    }

    public boolean clearOut() {
        return this.clear;
    }
}
