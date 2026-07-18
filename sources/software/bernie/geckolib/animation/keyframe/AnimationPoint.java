package software.bernie.geckolib.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/AnimationPoint.class */
public final class AnimationPoint extends Record {
    private final Keyframe<?> keyFrame;
    private final double currentTick;
    private final double transitionLength;
    private final double animationStartValue;
    private final double animationEndValue;

    public AnimationPoint(Keyframe<?> keyFrame, double currentTick, double transitionLength, double animationStartValue, double animationEndValue) {
        this.keyFrame = keyFrame;
        this.currentTick = currentTick;
        this.transitionLength = transitionLength;
        this.animationStartValue = animationStartValue;
        this.animationEndValue = animationEndValue;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, AnimationPoint.class), AnimationPoint.class, "keyFrame;currentTick;transitionLength;animationStartValue;animationEndValue", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->keyFrame:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->currentTick:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->transitionLength:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->animationStartValue:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->animationEndValue:D").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, AnimationPoint.class, Object.class), AnimationPoint.class, "keyFrame;currentTick;transitionLength;animationStartValue;animationEndValue", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->keyFrame:Lsoftware/bernie/geckolib/animation/keyframe/Keyframe;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->currentTick:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->transitionLength:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->animationStartValue:D", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPoint;->animationEndValue:D").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Keyframe<?> keyFrame() {
        return this.keyFrame;
    }

    public double currentTick() {
        return this.currentTick;
    }

    public double transitionLength() {
        return this.transitionLength;
    }

    public double animationStartValue() {
        return this.animationStartValue;
    }

    public double animationEndValue() {
        return this.animationEndValue;
    }

    @Override // java.lang.Record
    public String toString() {
        double d = this.currentTick;
        double d2 = this.transitionLength;
        double d3 = this.animationStartValue;
        double d4 = this.animationEndValue;
        return "Tick: " + d + " | Transition Length: " + d + " | Start Value: " + d2 + " | End Value: " + d;
    }
}
