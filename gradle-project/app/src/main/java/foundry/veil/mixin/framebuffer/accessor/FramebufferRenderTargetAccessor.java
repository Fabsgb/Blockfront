package foundry.veil.mixin.framebuffer.accessor;

import com.mojang.blaze3d.pipeline.RenderTarget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/framebuffer/accessor/FramebufferRenderTargetAccessor.class */
@Mixin({RenderTarget.class})
public interface FramebufferRenderTargetAccessor {
    @Accessor
    float[] getClearChannels();
}
