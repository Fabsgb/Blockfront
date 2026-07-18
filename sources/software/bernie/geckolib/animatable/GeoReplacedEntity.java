package software.bernie.geckolib.animatable;

import java.util.function.Consumer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/GeoReplacedEntity.class */
public interface GeoReplacedEntity extends SingletonGeoAnimatable {
    EntityType<?> getReplacingEntityType();

    @ApiStatus.NonExtendable
    @Nullable
    default <D> D getAnimData(Entity entity, SerializableDataTicket<D> serializableDataTicket) {
        return (D) getAnimatableInstanceCache().getManagerForId(entity.getId()).getData(serializableDataTicket);
    }

    @ApiStatus.NonExtendable
    default <D> void setAnimData(Entity relatedEntity, SerializableDataTicket<D> dataTicket, D data) {
        if (relatedEntity.level().isClientSide()) {
            getAnimatableInstanceCache().getManagerForId(relatedEntity.getId()).setData(dataTicket, data);
        } else {
            GeckoLibServices.NETWORK.syncEntityAnimData(relatedEntity, true, dataTicket, data);
        }
    }

    @ApiStatus.NonExtendable
    default void triggerAnim(Entity relatedEntity, @Nullable String controllerName, String animName) {
        if (relatedEntity.level().isClientSide()) {
            if (controllerName != null) {
                getAnimatableInstanceCache().getManagerForId(relatedEntity.getId()).tryTriggerAnimation(controllerName, animName);
                return;
            } else {
                getAnimatableInstanceCache().getManagerForId(relatedEntity.getId()).tryTriggerAnimation(animName);
                return;
            }
        }
        GeckoLibServices.NETWORK.triggerEntityAnim(relatedEntity, true, controllerName, animName);
    }

    @ApiStatus.NonExtendable
    default void stopTriggeredAnim(Entity relatedEntity, @Nullable String controllerName, @Nullable String animName) {
        if (relatedEntity.level().isClientSide()) {
            AnimatableManager<GeoAnimatable> animatableManager = getAnimatableInstanceCache().getManagerForId(relatedEntity.getId());
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
        GeckoLibServices.NETWORK.stopTriggeredEntityAnim(relatedEntity, true, controllerName, animName);
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    default double getTick(Object entity) {
        return ((Entity) entity).tickCount;
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    @ApiStatus.NonExtendable
    default void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable
    @ApiStatus.NonExtendable
    default Object getRenderProvider() {
        return null;
    }
}
