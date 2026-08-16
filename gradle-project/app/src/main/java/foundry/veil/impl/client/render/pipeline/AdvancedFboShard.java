package foundry.veil.impl.client.render.pipeline;

import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import foundry.veil.api.client.render.framebuffer.FramebufferStack;
import java.util.function.Supplier;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/pipeline/AdvancedFboShard.class */
@ApiStatus.Internal
public class AdvancedFboShard extends RenderStateShard.OutputStateShard {
    private final String fboName;

    public AdvancedFboShard(@Nullable ResourceLocation fboName, Supplier<AdvancedFbo> fbo) {
        super("veil:advanced_fbo", () -> {
            AdvancedFbo value = (AdvancedFbo) fbo.get();
            if (value != null) {
                FramebufferStack.push(fboName);
                value.bind(true);
            }
        }, () -> {
            if (fbo.get() != null) {
                FramebufferStack.pop(fboName);
            }
        });
        this.fboName = fboName != null ? fboName.toString() : "custom";
    }

    public String toString() {
        return this.name + "[" + this.fboName + "]";
    }
}
