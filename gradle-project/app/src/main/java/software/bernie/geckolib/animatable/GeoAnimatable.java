package software.bernie.geckolib.animatable;

import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/GeoAnimatable.class */
public interface GeoAnimatable {
    void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar);

    AnimatableInstanceCache getAnimatableInstanceCache();

    double getTick(Object obj);

    default double getBoneResetTime() {
        return 1.0d;
    }

    default boolean shouldPlayAnimsWhileGamePaused() {
        return false;
    }

    default AnimatableInstanceCache animatableCacheOverride() {
        return null;
    }
}
