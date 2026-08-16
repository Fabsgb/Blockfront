package foundry.veil.mixin.perspective.accessor;

import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/perspective/accessor/GameRendererAccessor.class */
@Mixin({GameRenderer.class})
public interface GameRendererAccessor {
    @Accessor
    void setRenderDistance(float f);
}
