package foundry.veil.api.client.necromancer.constraint;

import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import net.minecraft.client.renderer.MultiBufferSource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/constraint/Constraint.class */
public interface Constraint {
    void apply();

    default void renderDebugInfo(Skeleton skeleton, SkeletonParent<?, ?> parent, float pPartialTicks, PoseStack poseStack, MultiBufferSource pBuffer) {
    }
}
