package foundry.veil.api.client.necromancer;

import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.necromancer.animation.Animator;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/SkeletonParent.class */
public interface SkeletonParent<P extends SkeletonParent<?, ?>, S extends Skeleton> {
    void setSkeleton(@Nullable S s);

    void setAnimator(@Nullable Animator<P, S> animator);

    @Nullable
    S getSkeleton();

    @Nullable
    Animator<P, S> getAnimator();
}
