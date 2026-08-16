package software.bernie.geckolib.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import software.bernie.geckolib.animation.state.BoneSnapshot;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/keyframe/BoneAnimationQueue.class */
public final class BoneAnimationQueue extends Record {
    private final GeoBone bone;
    private final AnimationPointQueue rotationXQueue;
    private final AnimationPointQueue rotationYQueue;
    private final AnimationPointQueue rotationZQueue;
    private final AnimationPointQueue positionXQueue;
    private final AnimationPointQueue positionYQueue;
    private final AnimationPointQueue positionZQueue;
    private final AnimationPointQueue scaleXQueue;
    private final AnimationPointQueue scaleYQueue;
    private final AnimationPointQueue scaleZQueue;

    public BoneAnimationQueue(GeoBone bone, AnimationPointQueue rotationXQueue, AnimationPointQueue rotationYQueue, AnimationPointQueue rotationZQueue, AnimationPointQueue positionXQueue, AnimationPointQueue positionYQueue, AnimationPointQueue positionZQueue, AnimationPointQueue scaleXQueue, AnimationPointQueue scaleYQueue, AnimationPointQueue scaleZQueue) {
        this.bone = bone;
        this.rotationXQueue = rotationXQueue;
        this.rotationYQueue = rotationYQueue;
        this.rotationZQueue = rotationZQueue;
        this.positionXQueue = positionXQueue;
        this.positionYQueue = positionYQueue;
        this.positionZQueue = positionZQueue;
        this.scaleXQueue = scaleXQueue;
        this.scaleYQueue = scaleYQueue;
        this.scaleZQueue = scaleZQueue;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BoneAnimationQueue.class), BoneAnimationQueue.class, "bone;rotationXQueue;rotationYQueue;rotationZQueue;positionXQueue;positionYQueue;positionZQueue;scaleXQueue;scaleYQueue;scaleZQueue", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->bone:Lsoftware/bernie/geckolib/cache/object/GeoBone;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BoneAnimationQueue.class), BoneAnimationQueue.class, "bone;rotationXQueue;rotationYQueue;rotationZQueue;positionXQueue;positionYQueue;positionZQueue;scaleXQueue;scaleYQueue;scaleZQueue", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->bone:Lsoftware/bernie/geckolib/cache/object/GeoBone;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BoneAnimationQueue.class, Object.class), BoneAnimationQueue.class, "bone;rotationXQueue;rotationYQueue;rotationZQueue;positionXQueue;positionYQueue;positionZQueue;scaleXQueue;scaleYQueue;scaleZQueue", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->bone:Lsoftware/bernie/geckolib/cache/object/GeoBone;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->rotationZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->positionZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleXQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleYQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;", "FIELD:Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimationQueue;->scaleZQueue:Lsoftware/bernie/geckolib/animation/keyframe/AnimationPointQueue;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public GeoBone bone() {
        return this.bone;
    }

    public AnimationPointQueue rotationXQueue() {
        return this.rotationXQueue;
    }

    public AnimationPointQueue rotationYQueue() {
        return this.rotationYQueue;
    }

    public AnimationPointQueue rotationZQueue() {
        return this.rotationZQueue;
    }

    public AnimationPointQueue positionXQueue() {
        return this.positionXQueue;
    }

    public AnimationPointQueue positionYQueue() {
        return this.positionYQueue;
    }

    public AnimationPointQueue positionZQueue() {
        return this.positionZQueue;
    }

    public AnimationPointQueue scaleXQueue() {
        return this.scaleXQueue;
    }

    public AnimationPointQueue scaleYQueue() {
        return this.scaleYQueue;
    }

    public AnimationPointQueue scaleZQueue() {
        return this.scaleZQueue;
    }

    public BoneAnimationQueue(GeoBone bone) {
        this(bone, new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue(), new AnimationPointQueue());
    }

    public void addPosXPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.positionXQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addPosYPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.positionYQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addPosZPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.positionZQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addNextPosition(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, BoneSnapshot startSnapshot, AnimationPoint nextXPoint, AnimationPoint nextYPoint, AnimationPoint nextZPoint) {
        addPosXPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getOffsetX(), nextXPoint.animationStartValue());
        addPosYPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getOffsetY(), nextYPoint.animationStartValue());
        addPosZPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getOffsetZ(), nextZPoint.animationStartValue());
    }

    public void addScaleXPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.scaleXQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addScaleYPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.scaleYQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addScaleZPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.scaleZQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addNextScale(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, BoneSnapshot startSnapshot, AnimationPoint nextXPoint, AnimationPoint nextYPoint, AnimationPoint nextZPoint) {
        addScaleXPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getScaleX(), nextXPoint.animationStartValue());
        addScaleYPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getScaleY(), nextYPoint.animationStartValue());
        addScaleZPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getScaleZ(), nextZPoint.animationStartValue());
    }

    public void addRotationXPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.rotationXQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addRotationYPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.rotationYQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addRotationZPoint(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, double startValue, double endValue) {
        this.rotationZQueue.add(new AnimationPoint(keyFrame, lerpedTick, transitionLength, startValue, endValue));
    }

    public void addNextRotation(Keyframe<?> keyFrame, double lerpedTick, double transitionLength, BoneSnapshot startSnapshot, BoneSnapshot initialSnapshot, AnimationPoint nextXPoint, AnimationPoint nextYPoint, AnimationPoint nextZPoint) {
        addRotationXPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getRotX() - initialSnapshot.getRotX(), nextXPoint.animationStartValue());
        addRotationYPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getRotY() - initialSnapshot.getRotY(), nextYPoint.animationStartValue());
        addRotationZPoint(keyFrame, lerpedTick, transitionLength, startSnapshot.getRotZ() - initialSnapshot.getRotZ(), nextZPoint.animationStartValue());
    }

    public void addPositions(AnimationPoint xPoint, AnimationPoint yPoint, AnimationPoint zPoint) {
        this.positionXQueue.add(xPoint);
        this.positionYQueue.add(yPoint);
        this.positionZQueue.add(zPoint);
    }

    public void addScales(AnimationPoint xPoint, AnimationPoint yPoint, AnimationPoint zPoint) {
        this.scaleXQueue.add(xPoint);
        this.scaleYQueue.add(yPoint);
        this.scaleZQueue.add(zPoint);
    }

    public void addRotations(AnimationPoint xPoint, AnimationPoint yPoint, AnimationPoint zPoint) {
        this.rotationXQueue.add(xPoint);
        this.rotationYQueue.add(yPoint);
        this.rotationZQueue.add(zPoint);
    }
}
