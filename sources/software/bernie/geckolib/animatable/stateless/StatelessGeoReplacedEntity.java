package software.bernie.geckolib.animatable.stateless;

import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.network.packet.StatelessEntityPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessEntityStopAnimPacket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/stateless/StatelessGeoReplacedEntity.class */
public interface StatelessGeoReplacedEntity extends StatelessGeoSingletonAnimatable, GeoReplacedEntity {
    default void playAnimation(String animation, Entity relatedEntity) {
        playAnimation(animation, relatedEntity, relatedEntity.getId());
    }

    default void playLoopingAnimation(String animation, Entity relatedEntity) {
        playLoopingAnimation(animation, relatedEntity, relatedEntity.getId());
    }

    default void playAndHoldAnimation(String animation, Entity relatedEntity) {
        playAndHoldAnimation(animation, relatedEntity, relatedEntity.getId());
    }

    default void stopAnimation(RawAnimation animation, Entity relatedEntity) {
        stopAnimation(animation, relatedEntity, relatedEntity.getId());
    }

    default void playAnimation(RawAnimation animation, Entity relatedEntity) {
        playAnimation(animation, relatedEntity, relatedEntity.getId());
    }

    default void stopAnimation(String animation, Entity relatedEntity) {
        stopAnimation(animation, relatedEntity, relatedEntity.getId());
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessGeoSingletonAnimatable
    default void playAnimation(RawAnimation animation, Entity relatedEntity, long instanceId) {
        if (relatedEntity.level().isClientSide) {
            handleClientAnimationPlay(this, instanceId, animation);
        } else {
            GeckoLibServices.NETWORK.sendToAllPlayersTrackingEntity(new StatelessEntityPlayAnimPacket((int) instanceId, true, animation), relatedEntity);
        }
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessGeoSingletonAnimatable
    default void stopAnimation(String animation, Entity relatedEntity, long instanceId) {
        if (relatedEntity.level().isClientSide) {
            handleClientAnimationStop(this, instanceId, animation);
        } else {
            GeckoLibServices.NETWORK.sendToAllPlayersTrackingEntity(new StatelessEntityStopAnimPacket((int) instanceId, true, animation), relatedEntity);
        }
    }
}
