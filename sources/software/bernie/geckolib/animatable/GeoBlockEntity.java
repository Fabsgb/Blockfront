package software.bernie.geckolib.animatable;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/GeoBlockEntity.class */
public interface GeoBlockEntity extends GeoAnimatable {
    @ApiStatus.NonExtendable
    @Nullable
    default <D> D getAnimData(SerializableDataTicket<D> serializableDataTicket) {
        return (D) getAnimatableInstanceCache().getManagerForId(0L).getData(serializableDataTicket);
    }

    @ApiStatus.NonExtendable
    default <D> void setAnimData(SerializableDataTicket<D> dataTicket, D data) {
        BlockEntity blockEntity = (BlockEntity) this;
        ServerLevel level = blockEntity.getLevel();
        if (level == null) {
            GeckoLibConstants.LOGGER.error("Attempting to set animation data for BlockEntity too early! Must wait until after the BlockEntity has been set in the world. (" + blockEntity.getClass().toString() + ")");
        } else if (level.isClientSide()) {
            getAnimatableInstanceCache().getManagerForId(0L).setData(dataTicket, data);
        } else {
            GeckoLibServices.NETWORK.syncBlockEntityAnimData(blockEntity.getBlockPos(), dataTicket, data, level);
        }
    }

    @ApiStatus.NonExtendable
    default void triggerAnim(@Nullable String controllerName, String animName) {
        BlockEntity blockEntity = (BlockEntity) this;
        ServerLevel level = blockEntity.getLevel();
        if (level == null) {
            GeckoLibConstants.LOGGER.error("Attempting to trigger an animation for a BlockEntity too early! Must wait until after the BlockEntity has been set in the world. (" + blockEntity.getClass().toString() + ")");
            return;
        }
        if (level.isClientSide()) {
            if (controllerName != null) {
                getAnimatableInstanceCache().getManagerForId(0L).tryTriggerAnimation(controllerName, animName);
                return;
            } else {
                getAnimatableInstanceCache().getManagerForId(0L).tryTriggerAnimation(animName);
                return;
            }
        }
        GeckoLibServices.NETWORK.triggerBlockEntityAnim(blockEntity.getBlockPos(), controllerName, animName, level);
    }

    @ApiStatus.NonExtendable
    default void stopTriggeredAnim(@Nullable String controllerName, @Nullable String animName) {
        BlockEntity blockEntity = (BlockEntity) this;
        ServerLevel level = blockEntity.getLevel();
        if (level == null) {
            GeckoLibConstants.LOGGER.error("Attempting to stop a triggered animation for a BlockEntity too early! Must wait until after the BlockEntity has been set in the world. (" + blockEntity.getClass().toString() + ")");
            return;
        }
        if (level.isClientSide()) {
            AnimatableManager<GeoAnimatable> animatableManager = getAnimatableInstanceCache().getManagerForId(0L);
            if (controllerName != null) {
                animatableManager.stopTriggeredAnimation(controllerName, animName);
                return;
            } else {
                animatableManager.stopTriggeredAnimation(animName);
                return;
            }
        }
        GeckoLibServices.NETWORK.stopTriggeredBlockEntityAnim(blockEntity.getBlockPos(), level, controllerName, animName);
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    default double getTick(Object blockEntity) {
        return RenderUtil.getCurrentTick();
    }
}
