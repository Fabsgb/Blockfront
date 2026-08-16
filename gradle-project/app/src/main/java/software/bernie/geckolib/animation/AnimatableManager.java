package software.bernie.geckolib.animation;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.state.BoneSnapshot;
import software.bernie.geckolib.constant.dataticket.DataTicket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimatableManager.class */
public class AnimatableManager<T extends GeoAnimatable> {
    private final Map<String, AnimationController<T>> animationControllers;
    private Map<DataTicket<?>, Object> extraData;
    private double lastUpdateTime;
    private final Map<String, BoneSnapshot> boneSnapshotCollection = new Object2ObjectOpenHashMap();
    private boolean isFirstTick = true;
    private double firstTickTime = -1.0d;

    public AnimatableManager(GeoAnimatable animatable) {
        ControllerRegistrar registrar = new ControllerRegistrar(new ObjectArrayList(2));
        animatable.registerControllers(registrar);
        this.animationControllers = registrar.build();
    }

    public void addController(AnimationController controller) {
        getAnimationControllers().put(controller.getName(), controller);
    }

    public void removeController(String name) {
        getAnimationControllers().remove(name);
    }

    public Map<String, AnimationController<T>> getAnimationControllers() {
        return this.animationControllers;
    }

    public Map<String, BoneSnapshot> getBoneSnapshotCollection() {
        return this.boneSnapshotCollection;
    }

    public void clearSnapshotCache() {
        getBoneSnapshotCollection().clear();
    }

    public double getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void updatedAt(double updateTime) {
        this.lastUpdateTime = updateTime;
    }

    public double getFirstTickTime() {
        return this.firstTickTime;
    }

    public void startedAt(double time) {
        this.firstTickTime = time;
    }

    public boolean isFirstTick() {
        return this.isFirstTick;
    }

    protected void finishFirstTick() {
        this.isFirstTick = false;
    }

    public <D> void setData(DataTicket<D> dataTicket, D data) {
        if (this.extraData == null) {
            this.extraData = new Object2ObjectOpenHashMap();
        }
        this.extraData.put(dataTicket, data);
    }

    public <D> D getData(DataTicket<D> dataTicket) {
        if (this.extraData != null) {
            return dataTicket.getData(this.extraData);
        }
        return null;
    }

    public void tryTriggerAnimation(String animName) {
        Iterator<AnimationController<T>> it = getAnimationControllers().values().iterator();
        while (it.hasNext() && !it.next().tryTriggerAnimation(animName)) {
        }
    }

    public void tryTriggerAnimation(String controllerName, String animName) {
        AnimationController<T> animationController = getAnimationControllers().get(controllerName);
        if (animationController != null) {
            animationController.tryTriggerAnimation(animName);
        }
    }

    public void stopTriggeredAnimation(@Nullable String animName) {
        for (AnimationController<T> animationController : getAnimationControllers().values()) {
            if (animName == null || animationController.triggerableAnimations.get(animName) == animationController.getTriggeredAnimation()) {
                if (animationController.stopTriggeredAnimation()) {
                    return;
                }
            }
        }
    }

    public void stopTriggeredAnimation(String controllerName, @Nullable String animName) {
        AnimationController<T> animationController = getAnimationControllers().get(controllerName);
        if (animationController != null) {
            if (animName == null || animationController.triggerableAnimations.get(animName) == animationController.getTriggeredAnimation()) {
                animationController.stopTriggeredAnimation();
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar.class */
    public static final class ControllerRegistrar extends Record {
        private final List<AnimationController<? extends GeoAnimatable>> controllers;

        public ControllerRegistrar(List<AnimationController<? extends GeoAnimatable>> controllers) {
            this.controllers = controllers;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ControllerRegistrar.class), ControllerRegistrar.class, "controllers", "FIELD:Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;->controllers:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ControllerRegistrar.class), ControllerRegistrar.class, "controllers", "FIELD:Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;->controllers:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ControllerRegistrar.class, Object.class), ControllerRegistrar.class, "controllers", "FIELD:Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;->controllers:Ljava/util/List;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public List<AnimationController<? extends GeoAnimatable>> controllers() {
            return this.controllers;
        }

        public ControllerRegistrar add(AnimationController<?>... controllers) {
            controllers().addAll(Arrays.asList(controllers));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ControllerRegistrar add(AnimationController<?> animationController) {
            controllers().add(animationController);
            return this;
        }

        public ControllerRegistrar remove(String name) {
            controllers().removeIf(controller -> {
                return controller.getName().equals(name);
            });
            return this;
        }

        @ApiStatus.Internal
        private <T extends GeoAnimatable> Object2ObjectArrayMap<String, AnimationController<T>> build() {
            Object2ObjectArrayMap<String, AnimationController<T>> object2ObjectArrayMap = new Object2ObjectArrayMap<>(controllers().size());
            controllers().forEach(controller -> {
                object2ObjectArrayMap.put(controller.getName(), controller);
            });
            return object2ObjectArrayMap;
        }
    }
}
