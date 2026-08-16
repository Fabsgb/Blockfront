package foundry.veil.impl.client.render.dynamicbuffer;

import com.mojang.blaze3d.pipeline.RenderTarget;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilLevelPerspectiveRenderer;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.framebuffer.FramebufferStack;
import java.util.function.Supplier;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/dynamicbuffer/DynamicBufferShard.class */
@ApiStatus.Internal
public class DynamicBufferShard extends RenderStateShard {
    public DynamicBufferShard(String name, Supplier<RenderTarget> targetSupplier) {
        this(Veil.veilPath("dynamic_" + name), targetSupplier);
    }

    public DynamicBufferShard(ResourceLocation name, Supplier<RenderTarget> targetSupplier) {
        super("veil:dynamic_buffer", () -> {
            if (!Veil.platform().hasErrors() && !VeilLevelPerspectiveRenderer.isRenderingPerspective()) {
                DynamicBufferManager dynamicBufferManager = VeilRenderSystem.renderer().getDynamicBufferManger();
                if (dynamicBufferManager.isEnabled()) {
                    FramebufferStack.push(name);
                    dynamicBufferManager.setupRenderState(name, (RenderTarget) targetSupplier.get(), true);
                }
            }
        }, () -> {
            if (!Veil.platform().hasErrors() && !VeilLevelPerspectiveRenderer.isRenderingPerspective() && VeilRenderSystem.renderer().getDynamicBufferManger().isEnabled()) {
                FramebufferStack.pop(name);
            }
        });
    }
}
