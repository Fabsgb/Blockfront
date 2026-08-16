package software.bernie.geckolib.animatable.stateless;

import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.network.packet.StatelessEntityPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessEntityStopAnimPacket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/stateless/StatelessGeoEntity.class */
public interface StatelessGeoEntity extends StatelessAnimatable, GeoEntity {
    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    default void playAnimation(RawAnimation animation) {
        if (this instanceof Entity) {
            Entity self = (Entity) this;
            if (self.level().isClientSide) {
                handleClientAnimationPlay(this, self.getId(), animation);
                return;
            } else {
                GeckoLibServices.NETWORK.sendToAllPlayersTrackingEntity(new StatelessEntityPlayAnimPacket(self.getId(), false, animation), self);
                return;
            }
        }
        throw new ClassCastException("Cannot use StatelessGeoEntity on a non-entity animatable!");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    default void stopAnimation(String animation) {
        if (this instanceof Entity) {
            Entity self = (Entity) this;
            if (self.level().isClientSide) {
                handleClientAnimationStop(this, self.getId(), animation);
                return;
            } else {
                GeckoLibServices.NETWORK.sendToAllPlayersTrackingEntity(new StatelessEntityStopAnimPacket(self.getId(), false, animation), self);
                return;
            }
        }
        throw new ClassCastException("Cannot use StatelessGeoEntity on a non-entity animatable!");
    }
}
