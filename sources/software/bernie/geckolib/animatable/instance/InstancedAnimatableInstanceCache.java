package software.bernie.geckolib.animatable.instance;

import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/instance/InstancedAnimatableInstanceCache.class */
public class InstancedAnimatableInstanceCache extends AnimatableInstanceCache {
    protected AnimatableManager<?> manager;

    public InstancedAnimatableInstanceCache(GeoAnimatable animatable) {
        super(animatable);
    }

    @Override // software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
    public AnimatableManager<?> getManagerForId(long uniqueId) {
        if (this.manager == null) {
            this.manager = new AnimatableManager<>(this.animatable);
        }
        return this.manager;
    }
}
