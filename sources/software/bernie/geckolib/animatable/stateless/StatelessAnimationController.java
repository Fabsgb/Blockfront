package software.bernie.geckolib.animatable.stateless;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/stateless/StatelessAnimationController.class */
public class StatelessAnimationController extends AnimationController<GeoAnimatable> {

    @Nullable
    protected RawAnimation currentAnim;

    public StatelessAnimationController(GeoAnimatable animatable, String name) {
        super(animatable, name, (AnimationController.AnimationStateHandler<GeoAnimatable>) state -> {
            return PlayState.STOP;
        });
        this.currentAnim = null;
    }

    public void setCurrentAnimation(@Nullable RawAnimation animation) {
        this.currentAnim = animation;
    }

    @Nullable
    public RawAnimation getCurrentAnim() {
        return this.currentAnim;
    }

    @Override // software.bernie.geckolib.animation.AnimationController
    public AnimationController.AnimationStateHandler<GeoAnimatable> getStateHandler() {
        return this::overrideStateHandler;
    }

    @ApiStatus.Internal
    protected PlayState overrideStateHandler(AnimationState<GeoAnimatable> test) {
        return getCurrentAnim() == null ? PlayState.STOP : test.setAndContinue(getCurrentAnim());
    }
}
