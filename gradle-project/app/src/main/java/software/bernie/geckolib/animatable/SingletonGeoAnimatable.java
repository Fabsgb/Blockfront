package software.bernie.geckolib.animatable;

import java.util.function.Consumer;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibServices;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/SingletonGeoAnimatable.class */
public interface SingletonGeoAnimatable extends GeoAnimatable {
    static void registerSyncedAnimatable(GeoAnimatable animatable) {
        GeckoLibUtil.registerSyncedAnimatable(animatable);
    }

    @ApiStatus.NonExtendable
    @Nullable
    default <D> D getAnimData(long j, SerializableDataTicket<D> serializableDataTicket) {
        return (D) getAnimatableInstanceCache().getManagerForId(j).getData(serializableDataTicket);
    }

    @ApiStatus.NonExtendable
    default <D> void setAnimData(Entity relatedEntity, long instanceId, SerializableDataTicket<D> dataTicket, D data) {
        if (relatedEntity.level().isClientSide()) {
            getAnimatableInstanceCache().getManagerForId(instanceId).setData(dataTicket, data);
        } else {
            syncAnimData(instanceId, dataTicket, data, relatedEntity);
        }
    }

    @ApiStatus.NonExtendable
    default <D> void syncAnimData(long instanceId, SerializableDataTicket<D> dataTicket, D data, Entity entityToTrack) {
        GeckoLibServices.NETWORK.syncSingletonAnimData(getClass(), instanceId, dataTicket, data, entityToTrack);
    }

    @ApiStatus.NonExtendable
    default <D> void triggerAnim(Entity relatedEntity, long instanceId, @Nullable String controllerName, String animName) {
        if (relatedEntity.level().isClientSide()) {
            if (controllerName != null) {
                getAnimatableInstanceCache().getManagerForId(instanceId).tryTriggerAnimation(controllerName, animName);
                return;
            } else {
                getAnimatableInstanceCache().getManagerForId(instanceId).tryTriggerAnimation(animName);
                return;
            }
        }
        GeckoLibServices.NETWORK.triggerSingletonAnim(getClass(), relatedEntity, instanceId, controllerName, animName);
    }

    @ApiStatus.NonExtendable
    default void stopTriggeredAnim(Entity relatedEntity, long instanceId, @Nullable String controllerName, @Nullable String animName) {
        if (relatedEntity.level().isClientSide()) {
            AnimatableManager<GeoAnimatable> animatableManager = getAnimatableInstanceCache().getManagerForId(instanceId);
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
        GeckoLibServices.NETWORK.stopTriggeredSingletonAnim(getClass(), relatedEntity, instanceId, controllerName, animName);
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @Nullable
    default AnimatableInstanceCache animatableCacheOverride() {
        return new SingletonAnimatableInstanceCache(this);
    }

    default void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
    }

    default Object getRenderProvider() {
        return getAnimatableInstanceCache().getRenderProvider();
    }
}
