package foundry.veil.api.client.necromancer.animation;

import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/Animation.class */
public abstract class Animation<P extends SkeletonParent<?, ?>, S extends Skeleton> {
    public boolean running(P parent, S skeleton, float mixFactor, float time) {
        return mixFactor > 0.0f;
    }

    public void apply(P parent, S skeleton, float mixFactor, float time) {
    }
}
