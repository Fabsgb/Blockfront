package software.bernie.geckolib.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.InstancedAnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.EasingType;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.dataticket.SerializableDataTicket;
import software.bernie.geckolib.loading.object.BakedModelFactory;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/util/GeckoLibUtil.class */
public final class GeckoLibUtil {
    private static final Int2ObjectMap<String> ANIMATABLE_IDENTITIES = new Int2ObjectOpenHashMap();
    public static final Map<String, GeoAnimatable> SYNCED_ANIMATABLES = new Object2ObjectOpenHashMap();

    public static AnimatableInstanceCache createInstanceCache(GeoAnimatable animatable) {
        AnimatableInstanceCache cache = animatable.animatableCacheOverride();
        if (cache != null) {
            return cache;
        }
        return createInstanceCache(animatable, ((animatable instanceof Entity) || (animatable instanceof BlockEntity)) ? false : true);
    }

    public static AnimatableInstanceCache createInstanceCache(GeoAnimatable animatable, boolean singletonObject) {
        AnimatableInstanceCache cache = animatable.animatableCacheOverride();
        if (cache != null) {
            return cache;
        }
        return singletonObject ? new SingletonAnimatableInstanceCache(animatable) : new InstancedAnimatableInstanceCache(animatable);
    }

    public static synchronized Animation.LoopType addCustomLoopType(String name, Animation.LoopType loopType) {
        return Animation.LoopType.register(name, loopType);
    }

    public static synchronized EasingType addCustomEasingType(String name, EasingType easingType) {
        return EasingType.register(name, easingType);
    }

    public static synchronized void addCustomBakedModelFactory(String namespace, BakedModelFactory factory) {
        BakedModelFactory.register(namespace, factory);
    }

    public static synchronized <D> SerializableDataTicket<D> addDataTicket(SerializableDataTicket<D> dataTicket) {
        return DataTickets.registerSerializable(dataTicket);
    }

    public static synchronized void registerSyncedAnimatable(GeoAnimatable animatable) {
        GeoAnimatable existing = SYNCED_ANIMATABLES.put(getSyncedSingletonAnimatableId(animatable), animatable);
        if (existing == null) {
            GeckoLibConstants.LOGGER.debug("Registered SyncedAnimatable for " + String.valueOf(animatable.getClass()));
        }
    }

    @Nullable
    public static GeoAnimatable getSyncedAnimatable(String syncedAnimatableId) {
        GeoAnimatable animatable = SYNCED_ANIMATABLES.get(syncedAnimatableId);
        if (animatable == null) {
            GeckoLibConstants.LOGGER.error("Attempting to retrieve unregistered synced animatable! (" + syncedAnimatableId + ")");
        }
        return animatable;
    }

    public static String getSyncedSingletonAnimatableId(GeoAnimatable animatable) {
        return (String) ANIMATABLE_IDENTITIES.computeIfAbsent(System.identityHashCode(animatable), i -> {
            String baseId = animatable.getClass().getName();
            int i = 0;
            while (SYNCED_ANIMATABLES.containsKey(baseId + i)) {
                i++;
            }
            return baseId + i;
        });
    }
}
