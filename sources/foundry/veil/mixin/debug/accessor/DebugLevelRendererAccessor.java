package foundry.veil.mixin.debug.accessor;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.PostChain;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/mixin/debug/accessor/DebugLevelRendererAccessor.class */
@Mixin({LevelRenderer.class})
public interface DebugLevelRendererAccessor {
    @Accessor
    @Nullable
    PostChain getEntityEffect();

    @Accessor
    @Nullable
    PostChain getTransparencyChain();
}
