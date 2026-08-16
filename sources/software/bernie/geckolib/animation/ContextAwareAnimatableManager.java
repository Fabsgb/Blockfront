package software.bernie.geckolib.animation;

import java.util.Map;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.state.BoneSnapshot;
import software.bernie.geckolib.constant.dataticket.DataTicket;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/ContextAwareAnimatableManager.class */
public abstract class ContextAwareAnimatableManager<T extends GeoAnimatable, C> extends AnimatableManager<T> {
    private final Map<C, AnimatableManager<T>> managers;

    protected abstract Map<C, AnimatableManager<T>> buildContextOptions(GeoAnimatable geoAnimatable);

    public abstract C getCurrentContext();

    public ContextAwareAnimatableManager(GeoAnimatable animatable) {
        super(animatable);
        this.managers = buildContextOptions(animatable);
    }

    public AnimatableManager<T> getManagerForContext(C context) {
        return this.managers.get(context);
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void addController(AnimationController controller) {
        getManagerForContext(getCurrentContext()).addController(controller);
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void removeController(String name) {
        getManagerForContext(getCurrentContext()).removeController(name);
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public Map<String, AnimationController<T>> getAnimationControllers() {
        return getManagerForContext(getCurrentContext()).getAnimationControllers();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public Map<String, BoneSnapshot> getBoneSnapshotCollection() {
        return getManagerForContext(getCurrentContext()).getBoneSnapshotCollection();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void clearSnapshotCache() {
        getManagerForContext(getCurrentContext()).clearSnapshotCache();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public double getLastUpdateTime() {
        return getManagerForContext(getCurrentContext()).getLastUpdateTime();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void updatedAt(double updateTime) {
        getManagerForContext(getCurrentContext()).updatedAt(updateTime);
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public double getFirstTickTime() {
        return getManagerForContext(getCurrentContext()).getFirstTickTime();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void startedAt(double time) {
        getManagerForContext(getCurrentContext()).startedAt(time);
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public boolean isFirstTick() {
        return getManagerForContext(getCurrentContext()).isFirstTick();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    protected void finishFirstTick() {
        getManagerForContext(getCurrentContext()).finishFirstTick();
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void tryTriggerAnimation(String animName) {
        for (AnimatableManager<T> manager : this.managers.values()) {
            manager.tryTriggerAnimation(animName);
        }
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void tryTriggerAnimation(String controllerName, String animName) {
        for (AnimatableManager<T> manager : this.managers.values()) {
            manager.tryTriggerAnimation(controllerName, animName);
        }
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void stopTriggeredAnimation(@Nullable String animName) {
        for (AnimatableManager<T> manager : this.managers.values()) {
            manager.stopTriggeredAnimation(animName);
        }
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public void stopTriggeredAnimation(String controllerName, @Nullable String animName) {
        for (AnimatableManager<T> manager : this.managers.values()) {
            manager.stopTriggeredAnimation(controllerName, animName);
        }
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public <D> void setData(DataTicket<D> dataTicket, D data) {
        super.setData(dataTicket, data);
    }

    @Override // software.bernie.geckolib.animation.AnimatableManager
    public <D> D getData(DataTicket<D> dataTicket) {
        return (D) super.getData(dataTicket);
    }
}
