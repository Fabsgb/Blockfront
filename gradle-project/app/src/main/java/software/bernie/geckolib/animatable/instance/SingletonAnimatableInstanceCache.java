package software.bernie.geckolib.animatable.instance;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/instance/SingletonAnimatableInstanceCache.class */
public class SingletonAnimatableInstanceCache extends AnimatableInstanceCache {
    protected final Long2ObjectMap<AnimatableManager<?>> managers;

    public SingletonAnimatableInstanceCache(GeoAnimatable animatable) {
        super(animatable);
        this.managers = new Long2ObjectOpenHashMap();
    }

    @Override // software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
    public AnimatableManager<?> getManagerForId(long uniqueId) {
        if (!this.managers.containsKey(uniqueId)) {
            this.managers.put(uniqueId, new AnimatableManager(this.animatable));
        }
        return (AnimatableManager) this.managers.get(uniqueId);
    }
}
