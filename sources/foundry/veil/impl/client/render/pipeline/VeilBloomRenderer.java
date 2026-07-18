package foundry.veil.impl.client.render.pipeline;

import com.boehmod.blockfront.InterfaceC1294xq;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferAttachmentDefinition;
import foundry.veil.api.client.render.framebuffer.FramebufferStack;
import foundry.veil.api.client.render.framebuffer.VeilFramebuffers;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.compat.IrisCompat;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/VeilBloomRenderer.class */
@ApiStatus.Internal
public final class VeilBloomRenderer {
    private static final ResourceLocation BLOOM_PIPELINE = Veil.veilPath("core/bloom");
    private static boolean enabled;
    private static boolean rendered;
    private static AdvancedFbo bloom;

    public static void tryEnable() {
        boolean wasEnabled = enabled;
        enabled = getPipeline() != null;
        if (wasEnabled != enabled) {
            if (enabled) {
                Veil.LOGGER.info("Enabled bloom pipeline");
                rendered = false;
            } else {
                Veil.LOGGER.warn("Disabled bloom pipeline due to error");
                free();
            }
        }
    }

    public static void setupRenderState() {
        if (!enabled) {
            return;
        }
        if (IrisCompat.INSTANCE != null && IrisCompat.INSTANCE.areShadersLoaded()) {
            return;
        }
        AdvancedFbo mainRenderTarget = AdvancedFbo.getMainFramebuffer();
        int w = mainRenderTarget.getWidth();
        int h = mainRenderTarget.getHeight();
        int framebufferTexture = mainRenderTarget.getDepthTextureAttachment().getId();
        if (bloom == null || bloom.getWidth() != w || bloom.getHeight() != h) {
            free();
            bloom = AdvancedFbo.withSize(w, h).setFormat(FramebufferAttachmentDefinition.Format.RGBA16F).addColorTextureBuffer().setDepthTextureWrapper(framebufferTexture).setDebugLabel("Veil Bloom").build(true);
        }
        FramebufferStack.push(null);
        VeilRenderSystem.renderer().getFramebufferManager().setFramebuffer(VeilFramebuffers.BLOOM, bloom);
        bloom.bind(true);
        rendered = true;
    }

    public static void clearRenderState() {
        if (!enabled) {
            return;
        }
        if (IrisCompat.INSTANCE != null && IrisCompat.INSTANCE.areShadersLoaded()) {
            return;
        }
        FramebufferStack.pop(null);
    }

    @Nullable
    private static PostPipeline getPipeline() {
        PostPipeline pipeline = VeilRenderSystem.renderer().getPostProcessingManager().getPipeline(BLOOM_PIPELINE);
        if (pipeline == null) {
            Veil.LOGGER.error("Failed to apply bloom pipeline");
        }
        return pipeline;
    }

    public static boolean hasRendered() {
        return rendered && enabled;
    }

    public static void flush() {
        if (!rendered || !enabled) {
            return;
        }
        rendered = false;
        PostPipeline pipeline = getPipeline();
        if (pipeline == null) {
            enabled = false;
            return;
        }
        ProfilerFiller profiler = Minecraft.getInstance().getProfiler();
        profiler.push("bloom");
        FramebufferStack.push(null);
        VeilRenderSystem.renderer().getPostProcessingManager().runPipeline(pipeline);
        bloom.clear(InterfaceC1294xq.f8660tV);
        FramebufferStack.pop(null);
        profiler.pop();
    }

    public static void free() {
        if (bloom != null) {
            VeilRenderSystem.renderer().getFramebufferManager().removeFramebuffer(VeilFramebuffers.BLOOM);
            bloom.free();
            bloom = null;
        }
    }
}
