package software.bernie.geckolib.animatable.stateless;

import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.network.packet.StatelessSingletonPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessSingletonStopAnimPacket;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/stateless/StatelessGeoSingletonAnimatable.class */
public interface StatelessGeoSingletonAnimatable extends StatelessAnimatable, SingletonGeoAnimatable {
    default void playAnimation(String animation, Entity relatedEntity, long instanceId) {
        playAnimation(RawAnimation.begin().thenPlay(animation), relatedEntity, instanceId);
    }

    default void playLoopingAnimation(String animation, Entity relatedEntity, long instanceId) {
        playAnimation(RawAnimation.begin().thenLoop(animation), relatedEntity, instanceId);
    }

    default void playAndHoldAnimation(String animation, Entity relatedEntity, long instanceId) {
        playAnimation(RawAnimation.begin().thenPlayAndHold(animation), relatedEntity, instanceId);
    }

    default void stopAnimation(RawAnimation animation, Entity relatedEntity, long instanceId) {
        stopAnimation(animation.getStageCount() == 1 ? ((RawAnimation.Stage) animation.getAnimationStages().getFirst()).animationName() : animation.toString(), relatedEntity, instanceId);
    }

    default void playAnimation(RawAnimation animation, Entity relatedEntity, long instanceId) {
        if (relatedEntity.level().isClientSide) {
            handleClientAnimationPlay(this, instanceId, animation);
        } else {
            GeckoLibServices.NETWORK.sendToAllPlayersTrackingEntity(new StatelessSingletonPlayAnimPacket(GeckoLibUtil.getSyncedSingletonAnimatableId(this), instanceId, animation), relatedEntity);
        }
    }

    default void stopAnimation(String animation, Entity relatedEntity, long instanceId) {
        if (relatedEntity.level().isClientSide) {
            handleClientAnimationStop(this, instanceId, animation);
        } else {
            GeckoLibServices.NETWORK.sendToAllPlayersTrackingEntity(new StatelessSingletonStopAnimPacket(GeckoLibUtil.getSyncedSingletonAnimatableId(this), instanceId, animation), relatedEntity);
        }
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    @Deprecated
    default void playAnimation(String animation) {
        throw new IllegalStateException("Cannot use non-level method handlers on StatelessSingletonGeoAnimatable");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    @Deprecated
    default void playLoopingAnimation(String animation) {
        throw new IllegalStateException("Cannot use non-level method handlers on StatelessSingletonGeoAnimatable");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    @Deprecated
    default void playAndHoldAnimation(String animation) {
        throw new IllegalStateException("Cannot use non-level method handlers on StatelessSingletonGeoAnimatable");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    @Deprecated
    default void stopAnimation(RawAnimation animation) {
        throw new IllegalStateException("Cannot use non-level method handlers on StatelessSingletonGeoAnimatable");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    @Deprecated
    default void playAnimation(RawAnimation animation) {
        throw new IllegalStateException("Cannot use non-level method handlers on StatelessSingletonGeoAnimatable");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    @Deprecated
    default void stopAnimation(String animation) {
        throw new IllegalStateException("Cannot use non-level method handlers on StatelessSingletonGeoAnimatable");
    }
}
