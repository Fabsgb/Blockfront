package software.bernie.geckolib.animatable;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.ContextAwareAnimatableManager;
import software.bernie.geckolib.cache.AnimatableIdCache;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/GeoItem.class */
public interface GeoItem extends SingletonGeoAnimatable {
    static void registerSyncedAnimatable(GeoAnimatable animatable) {
        SingletonGeoAnimatable.registerSyncedAnimatable(animatable);
    }

    static long getId(ItemStack stack) {
        return ((Long) Optional.ofNullable(stack.getComponentsPatch().get(GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get())).filter((v0) -> {
            return v0.isPresent();
        }).map((v0) -> {
            return v0.get();
        }).orElse(Long.MAX_VALUE)).longValue();
    }

    static long getOrAssignId(ItemStack stack, ServerLevel level) {
        PatchedDataComponentMap components = stack.getComponents();
        if (!(components instanceof PatchedDataComponentMap)) {
            return Long.MAX_VALUE;
        }
        PatchedDataComponentMap components2 = components;
        Long id = (Long) components2.get(GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get());
        if (id == null) {
            DataComponentType<Long> dataComponentType = GeckoLibConstants.STACK_ANIMATABLE_ID_COMPONENT.get();
            Long lValueOf = Long.valueOf(AnimatableIdCache.getFreeId(level));
            id = lValueOf;
            components2.set(dataComponentType, lValueOf);
        }
        return id.longValue();
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    default double getTick(Object itemStack) {
        return RenderUtil.getCurrentTick();
    }

    default boolean isPerspectiveAware() {
        return false;
    }

    @Override // software.bernie.geckolib.animatable.SingletonGeoAnimatable, software.bernie.geckolib.animatable.GeoAnimatable
    @Nullable
    default AnimatableInstanceCache animatableCacheOverride() {
        if (isPerspectiveAware()) {
            return new ContextBasedAnimatableInstanceCache(this);
        }
        return super.animatableCacheOverride();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animatable/GeoItem$ContextBasedAnimatableInstanceCache.class */
    public static class ContextBasedAnimatableInstanceCache extends SingletonAnimatableInstanceCache {
        public ContextBasedAnimatableInstanceCache(GeoAnimatable animatable) {
            super(animatable);
        }

        @Override // software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache, software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
        public AnimatableManager<?> getManagerForId(long uniqueId) {
            if (!this.managers.containsKey(uniqueId)) {
                this.managers.put(uniqueId, new ContextAwareAnimatableManager<GeoItem, ItemDisplayContext>(this, this.animatable) { // from class: software.bernie.geckolib.animatable.GeoItem.ContextBasedAnimatableInstanceCache.1
                    @Override // software.bernie.geckolib.animation.ContextAwareAnimatableManager
                    protected Map<ItemDisplayContext, AnimatableManager<GeoItem>> buildContextOptions(GeoAnimatable animatable) {
                        Map<ItemDisplayContext, AnimatableManager<GeoItem>> map = new EnumMap<>(ItemDisplayContext.class);
                        for (ItemDisplayContext context : ItemDisplayContext.values()) {
                            map.put(context, new AnimatableManager<>(animatable));
                        }
                        return map;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // software.bernie.geckolib.animation.ContextAwareAnimatableManager
                    public ItemDisplayContext getCurrentContext() {
                        ItemDisplayContext context = (ItemDisplayContext) getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                        return context == null ? ItemDisplayContext.NONE : context;
                    }
                });
            }
            return (AnimatableManager) this.managers.get(uniqueId);
        }
    }
}
