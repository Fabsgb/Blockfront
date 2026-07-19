package software.bernie.geckolib.loading.object;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.Animation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/object/BakedAnimations.class */
public final class BakedAnimations extends Record {
    private final Map<String, Animation> animations;

    public BakedAnimations(Map<String, Animation> animations) {
        this.animations = animations;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BakedAnimations.class), BakedAnimations.class, "animations", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedAnimations;->animations:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BakedAnimations.class), BakedAnimations.class, "animations", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedAnimations;->animations:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BakedAnimations.class, Object.class), BakedAnimations.class, "animations", "FIELD:Lsoftware/bernie/geckolib/loading/object/BakedAnimations;->animations:Ljava/util/Map;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Map<String, Animation> animations() {
        return this.animations;
    }

    @Nullable
    public Animation getAnimation(String name) {
        return this.animations.get(name);
    }
}
