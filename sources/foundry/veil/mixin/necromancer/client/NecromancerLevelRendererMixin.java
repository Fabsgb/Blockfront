package foundry.veil.mixin.necromancer.client;

import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.necromancer.animation.Animator;
import javax.annotation.Nullable;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/necromancer/client/NecromancerLevelRendererMixin.class */
@Mixin({LevelRenderer.class})
public class NecromancerLevelRendererMixin {

    @Shadow
    @Nullable
    private ClientLevel level;

    @Inject(method = {"tick"}, at = {@At("HEAD")})
    private void veil$levelRenderTick(CallbackInfo ci) {
        if (this.level == null) {
            return;
        }
        for (SkeletonParent skeletonParent : this.level.entitiesForRendering()) {
            if (skeletonParent instanceof SkeletonParent) {
                SkeletonParent parent = skeletonParent;
                Animator animator = parent.getAnimator();
                if (animator != null) {
                    animator.tick();
                }
            }
        }
    }
}
