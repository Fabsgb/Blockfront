package software.bernie.geckolib.animatable.stateless;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.network.packet.StatelessBlockEntityPlayAnimPacket;
import software.bernie.geckolib.network.packet.StatelessBlockEntityStopAnimPacket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animatable/stateless/StatelessGeoBlockEntity.class */
public interface StatelessGeoBlockEntity extends StatelessAnimatable, GeoBlockEntity {
    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    default void playAnimation(RawAnimation animation) {
        if (this instanceof BlockEntity) {
            BlockEntity self = (BlockEntity) this;
            ServerLevel level = self.getLevel();
            if (level instanceof ServerLevel) {
                ServerLevel level2 = level;
                GeckoLibServices.NETWORK.sendToAllPlayersTrackingBlock(new StatelessBlockEntityPlayAnimPacket(self.getBlockPos(), animation), level2, self.getBlockPos());
                return;
            } else {
                handleClientAnimationPlay(this, 0L, animation);
                return;
            }
        }
        throw new ClassCastException("Cannot use StatelessGeoBlockEntity on a non-blockentity animatable!");
    }

    @Override // software.bernie.geckolib.animatable.stateless.StatelessAnimatable
    default void stopAnimation(String animation) {
        if (this instanceof BlockEntity) {
            BlockEntity self = (BlockEntity) this;
            ServerLevel level = self.getLevel();
            if (level instanceof ServerLevel) {
                ServerLevel level2 = level;
                GeckoLibServices.NETWORK.sendToAllPlayersTrackingBlock(new StatelessBlockEntityStopAnimPacket(self.getBlockPos(), animation), level2, self.getBlockPos());
                return;
            } else {
                handleClientAnimationStop(this, 0L, animation);
                return;
            }
        }
        throw new ClassCastException("Cannot use StatelessGeoBlockEntity on a non-blockentity animatable!");
    }
}
