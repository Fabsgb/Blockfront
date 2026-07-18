package software.bernie.geckolib.animatable;

import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/GeoEntity.class */
public interface GeoEntity extends GeoAnimatable {
    @ApiStatus.NonExtendable
    @Nullable
    default <D> D getAnimData(SerializableDataTicket<D> serializableDataTicket) {
        return (D) getAnimatableInstanceCache().getManagerForId(((Entity) this).getId()).getData(serializableDataTicket);
    }

    @ApiStatus.NonExtendable
    default <D> void setAnimData(SerializableDataTicket<D> dataTicket, D data) {
        Entity entity = (Entity) this;
        if (entity.level().isClientSide()) {
            getAnimatableInstanceCache().getManagerForId(entity.getId()).setData(dataTicket, data);
        } else {
            GeckoLibServices.NETWORK.syncEntityAnimData(entity, false, dataTicket, data);
        }
    }

    @ApiStatus.NonExtendable
    default void triggerAnim(@Nullable String controllerName, String animName) {
        Entity entity = (Entity) this;
        if (entity.level().isClientSide()) {
            if (controllerName != null) {
                getAnimatableInstanceCache().getManagerForId(entity.getId()).tryTriggerAnimation(controllerName, animName);
                return;
            } else {
                getAnimatableInstanceCache().getManagerForId(entity.getId()).tryTriggerAnimation(animName);
                return;
            }
        }
        GeckoLibServices.NETWORK.triggerEntityAnim(entity, false, controllerName, animName);
    }

    @ApiStatus.NonExtendable
    default void stopTriggeredAnim(@Nullable String controllerName, @Nullable String animName) {
        Entity entity = (Entity) this;
        if (entity.level().isClientSide()) {
            AnimatableManager<GeoAnimatable> animatableManager = getAnimatableInstanceCache().getManagerForId(entity.getId());
            if (animatableManager == null) {
                return;
            }
            if (controllerName != null) {
                animatableManager.stopTriggeredAnimation(controllerName, animName);
                return;
            } else {
                animatableManager.stopTriggeredAnimation(animName);
                return;
            }
        }
        GeckoLibServices.NETWORK.stopTriggeredEntityAnim(entity, false, controllerName, animName);
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    default double getTick(Object entity) {
        return ((Entity) entity).tickCount;
    }
}
