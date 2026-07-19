package software.bernie.geckolib.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.loading.math.MathValue;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/BoneAnimation.class */
public final class BoneAnimation extends Record {
    private final String boneName;
    private final KeyframeStack<Keyframe<MathValue>> rotationKeyFrames;
    private final KeyframeStack<Keyframe<MathValue>> positionKeyFrames;
    private final KeyframeStack<Keyframe<MathValue>> scaleKeyFrames;

    public BoneAnimation(String boneName, KeyframeStack<Keyframe<MathValue>> rotationKeyFrames, KeyframeStack<Keyframe<MathValue>> positionKeyFrames, KeyframeStack<Keyframe<MathValue>> scaleKeyFrames) {
        this.boneName = boneName;
        this.rotationKeyFrames = rotationKeyFrames;
        this.positionKeyFrames = positionKeyFrames;
        this.scaleKeyFrames = scaleKeyFrames;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BoneAnimation.class), BoneAnimation.class, "boneName;rotationKeyFrames;positionKeyFrames;scaleKeyFrames", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->boneName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->rotationKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->positionKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->scaleKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BoneAnimation.class), BoneAnimation.class, "boneName;rotationKeyFrames;positionKeyFrames;scaleKeyFrames", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->boneName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->rotationKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->positionKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->scaleKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BoneAnimation.class, Object.class), BoneAnimation.class, "boneName;rotationKeyFrames;positionKeyFrames;scaleKeyFrames", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->boneName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->rotationKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->positionKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;->scaleKeyFrames:Lsoftware/bernie/geckolib/animation/keyframe/KeyframeStack;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String boneName() {
        return this.boneName;
    }

    public KeyframeStack<Keyframe<MathValue>> rotationKeyFrames() {
        return this.rotationKeyFrames;
    }

    public KeyframeStack<Keyframe<MathValue>> positionKeyFrames() {
        return this.positionKeyFrames;
    }

    public KeyframeStack<Keyframe<MathValue>> scaleKeyFrames() {
        return this.scaleKeyFrames;
    }
}
