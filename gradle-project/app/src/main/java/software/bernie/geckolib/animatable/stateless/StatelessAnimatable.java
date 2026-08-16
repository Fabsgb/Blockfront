package software.bernie.geckolib.animatable.stateless;

import org.jetbrains.annotations.ApiStatus;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/stateless/StatelessAnimatable.class */
public interface StatelessAnimatable {
    void playAnimation(RawAnimation rawAnimation);

    void stopAnimation(String str);

    default void playAnimation(String animation) {
        playAnimation(RawAnimation.begin().thenPlay(animation));
    }

    default void playLoopingAnimation(String animation) {
        playAnimation(RawAnimation.begin().thenLoop(animation));
    }

    default void playAndHoldAnimation(String animation) {
        playAnimation(RawAnimation.begin().thenPlayAndHold(animation));
    }

    default void stopAnimation(RawAnimation animation) {
        stopAnimation(animation.getStageCount() == 1 ? ((RawAnimation.Stage) animation.getAnimationStages().getFirst()).animationName() : animation.toString());
    }

    @ApiStatus.Internal
    default void handleClientAnimationPlay(GeoAnimatable animatable, long animatableId, RawAnimation animation) {
        AnimatableManager<GeoAnimatable> animatableManager = animatable.getAnimatableInstanceCache().getManagerForId(animatableId);
        if (animatableManager == null) {
            return;
        }
        String animKey = animation.getStageCount() == 1 ? ((RawAnimation.Stage) animation.getAnimationStages().getFirst()).animationName() : animation.toString();
        AnimationController<?> controller = (AnimationController) animatableManager.getAnimationControllers().computeIfAbsent(animKey, anim -> {
            return new StatelessAnimationController(animatable, anim);
        });
        if (controller instanceof StatelessAnimationController) {
            StatelessAnimationController statelessController = (StatelessAnimationController) controller;
            statelessController.setCurrentAnimation(animation);
        }
    }

    @ApiStatus.Internal
    default void handleClientAnimationStop(GeoAnimatable animatable, long animatableId, String animName) {
        AnimatableManager<GeoAnimatable> animatableManager = animatable.getAnimatableInstanceCache().getManagerForId(animatableId);
        if (animatableManager == null) {
            return;
        }
        Object obj = animatableManager.getAnimationControllers().get(animName);
        if (obj instanceof StatelessAnimationController) {
            StatelessAnimationController statelessController = (StatelessAnimationController) obj;
            statelessController.setCurrentAnimation(null);
        }
    }
}
