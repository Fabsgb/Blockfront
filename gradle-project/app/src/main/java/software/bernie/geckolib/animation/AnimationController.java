package software.bernie.geckolib.animation;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.core.Direction;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.keyframe.AnimationPoint;
import software.bernie.geckolib.animation.keyframe.BoneAnimation;
import software.bernie.geckolib.animation.keyframe.BoneAnimationQueue;
import software.bernie.geckolib.animation.keyframe.Keyframe;
import software.bernie.geckolib.animation.keyframe.KeyframeLocation;
import software.bernie.geckolib.animation.keyframe.KeyframeStack;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.animation.keyframe.event.ParticleKeyframeEvent;
import software.bernie.geckolib.animation.keyframe.event.SoundKeyframeEvent;
import software.bernie.geckolib.animation.keyframe.event.data.CustomInstructionKeyframeData;
import software.bernie.geckolib.animation.keyframe.event.data.KeyFrameData;
import software.bernie.geckolib.animation.keyframe.event.data.ParticleKeyframeData;
import software.bernie.geckolib.animation.keyframe.event.data.SoundKeyframeData;
import software.bernie.geckolib.animation.state.BoneSnapshot;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.loading.math.MathParser;
import software.bernie.geckolib.loading.math.MathValue;
import software.bernie.geckolib.loading.math.MolangQueries;
import software.bernie.geckolib.loading.math.value.Constant;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimationController.class */
public class AnimationController<T extends GeoAnimatable> {
    protected final T animatable;
    protected final String name;
    protected final AnimationStateHandler<T> stateHandler;
    protected final Map<String, BoneAnimationQueue> boneAnimationQueues;
    protected final Map<String, BoneSnapshot> boneSnapshots;
    protected Queue<AnimationProcessor.QueuedAnimation> animationQueue;
    protected boolean isJustStarting;
    protected boolean needsAnimationReload;
    protected boolean shouldResetTick;
    private boolean justStopped;
    protected boolean justStartedTransition;
    protected SoundKeyframeHandler<T> soundKeyframeHandler;
    protected ParticleKeyframeHandler<T> particleKeyframeHandler;
    protected CustomKeyframeHandler<T> customKeyframeHandler;
    protected final Map<String, RawAnimation> triggerableAnimations;
    protected RawAnimation triggeredAnimation;
    protected boolean handlingTriggeredAnimations;
    protected double transitionLength;
    protected RawAnimation currentRawAnimation;
    protected AnimationProcessor.QueuedAnimation currentAnimation;
    protected State animationState;
    protected double tickOffset;
    protected double lastPollTime;
    protected Function<T, Double> animationSpeedModifier;
    protected Function<T, EasingType> overrideEasingTypeFunction;
    private final Set<KeyFrameData> executedKeyFrames;
    protected GeoModel<T> lastModel;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimationController$AnimationStateHandler.class */
    @FunctionalInterface
    public interface AnimationStateHandler<A extends GeoAnimatable> {
        PlayState handle(AnimationState<A> animationState);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimationController$CustomKeyframeHandler.class */
    @FunctionalInterface
    public interface CustomKeyframeHandler<A extends GeoAnimatable> {
        void handle(CustomInstructionKeyframeEvent<A> customInstructionKeyframeEvent);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimationController$ParticleKeyframeHandler.class */
    @FunctionalInterface
    public interface ParticleKeyframeHandler<A extends GeoAnimatable> {
        void handle(ParticleKeyframeEvent<A> particleKeyframeEvent);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimationController$SoundKeyframeHandler.class */
    @FunctionalInterface
    public interface SoundKeyframeHandler<A extends GeoAnimatable> {
        void handle(SoundKeyframeEvent<A> soundKeyframeEvent);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/AnimationController$State.class */
    public enum State {
        RUNNING,
        TRANSITIONING,
        PAUSED,
        STOPPED
    }

    public AnimationController(T animatable, AnimationStateHandler<T> animationHandler) {
        this(animatable, "base_controller", 0, animationHandler);
    }

    public AnimationController(T animatable, String name, AnimationStateHandler<T> animationHandler) {
        this(animatable, name, 0, animationHandler);
    }

    public AnimationController(T animatable, int transitionTickTime, AnimationStateHandler<T> animationHandler) {
        this(animatable, "base_controller", transitionTickTime, animationHandler);
    }

    public AnimationController(T animatable, String name, int transitionTickTime, AnimationStateHandler<T> animationHandler) {
        this.boneAnimationQueues = new Object2ObjectOpenHashMap();
        this.boneSnapshots = new Object2ObjectOpenHashMap();
        this.animationQueue = new LinkedList();
        this.isJustStarting = false;
        this.needsAnimationReload = false;
        this.shouldResetTick = false;
        this.justStopped = true;
        this.justStartedTransition = false;
        this.soundKeyframeHandler = null;
        this.particleKeyframeHandler = null;
        this.customKeyframeHandler = null;
        this.triggerableAnimations = new Object2ObjectOpenHashMap(0);
        this.triggeredAnimation = null;
        this.handlingTriggeredAnimations = false;
        this.animationState = State.STOPPED;
        this.lastPollTime = -1.0d;
        this.animationSpeedModifier = animatable2 -> {
            return Double.valueOf(1.0d);
        };
        this.overrideEasingTypeFunction = animatable3 -> {
            return null;
        };
        this.executedKeyFrames = new ObjectOpenHashSet();
        this.animatable = animatable;
        this.name = name;
        this.transitionLength = transitionTickTime;
        this.stateHandler = animationHandler;
    }

    public AnimationController<T> setSoundKeyframeHandler(SoundKeyframeHandler<T> soundHandler) {
        this.soundKeyframeHandler = soundHandler;
        return this;
    }

    public AnimationController<T> setParticleKeyframeHandler(ParticleKeyframeHandler<T> particleHandler) {
        this.particleKeyframeHandler = particleHandler;
        return this;
    }

    public AnimationController<T> setCustomInstructionKeyframeHandler(CustomKeyframeHandler<T> customInstructionHandler) {
        this.customKeyframeHandler = customInstructionHandler;
        return this;
    }

    public AnimationController<T> setAnimationSpeedHandler(Function<T, Double> speedModFunction) {
        this.animationSpeedModifier = speedModFunction;
        return this;
    }

    public AnimationController<T> setAnimationSpeed(double speed) {
        return setAnimationSpeedHandler(animatable -> {
            return Double.valueOf(speed);
        });
    }

    public AnimationController<T> setOverrideEasingType(EasingType easingTypeFunction) {
        return setOverrideEasingTypeFunction(animatable -> {
            return easingTypeFunction;
        });
    }

    public AnimationController<T> setOverrideEasingTypeFunction(Function<T, EasingType> easingType) {
        this.overrideEasingTypeFunction = easingType;
        return this;
    }

    public AnimationController<T> triggerableAnim(String name, RawAnimation animation) {
        this.triggerableAnimations.put(name, animation);
        return this;
    }

    public AnimationController<T> receiveTriggeredAnimations() {
        this.handlingTriggeredAnimations = true;
        return this;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public AnimationProcessor.QueuedAnimation getCurrentAnimation() {
        return this.currentAnimation;
    }

    @Nullable
    public RawAnimation getTriggeredAnimation() {
        return this.triggeredAnimation;
    }

    public State getAnimationState() {
        return this.animationState;
    }

    public AnimationStateHandler<T> getStateHandler() {
        return this.stateHandler;
    }

    public Map<String, BoneAnimationQueue> getBoneAnimationQueues() {
        return this.boneAnimationQueues;
    }

    public double getAnimationSpeed() {
        return this.animationSpeedModifier.apply(this.animatable).doubleValue();
    }

    public void forceAnimationReset() {
        this.needsAnimationReload = true;
    }

    public void stop() {
        this.animationState = State.STOPPED;
    }

    public AnimationController<T> transitionLength(int ticks) {
        this.transitionLength = ticks;
        return this;
    }

    public boolean hasAnimationFinished() {
        return this.currentRawAnimation != null && this.animationState == State.STOPPED;
    }

    public RawAnimation getCurrentRawAnimation() {
        return this.currentRawAnimation;
    }

    public boolean isPlayingTriggeredAnimation() {
        return (this.triggeredAnimation == null || hasAnimationFinished()) ? false : true;
    }

    public void setAnimation(RawAnimation rawAnimation) {
        Queue<AnimationProcessor.QueuedAnimation> animations;
        if (rawAnimation == null || rawAnimation.getAnimationStages().isEmpty()) {
            stop();
            return;
        }
        if (this.needsAnimationReload || !rawAnimation.equals(this.currentRawAnimation)) {
            if (this.lastModel != null && (animations = this.lastModel.getAnimationProcessor().buildAnimationQueue(this.animatable, rawAnimation)) != null) {
                this.animationQueue = animations;
                this.currentRawAnimation = rawAnimation;
                this.shouldResetTick = true;
                this.animationState = State.TRANSITIONING;
                this.justStartedTransition = true;
                this.needsAnimationReload = false;
                return;
            }
            stop();
        }
    }

    public boolean tryTriggerAnimation(String animName) {
        RawAnimation anim = this.triggerableAnimations.get(animName);
        if (anim == null) {
            return false;
        }
        this.triggeredAnimation = anim;
        if (this.animationState == State.STOPPED) {
            this.animationState = State.TRANSITIONING;
            this.shouldResetTick = true;
            this.justStartedTransition = true;
            return true;
        }
        return true;
    }

    protected boolean stopTriggeredAnimation() {
        if (this.triggeredAnimation == null) {
            return false;
        }
        if (this.currentRawAnimation == this.triggeredAnimation) {
            this.currentAnimation = null;
            this.currentRawAnimation = null;
        }
        this.triggeredAnimation = null;
        this.needsAnimationReload = true;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected PlayState handleAnimationState(AnimationState<T> animationState) {
        if (this.triggeredAnimation != null) {
            if (this.currentRawAnimation != this.triggeredAnimation) {
                this.currentAnimation = null;
            }
            setAnimation(this.triggeredAnimation);
            if (!hasAnimationFinished() && (!this.handlingTriggeredAnimations || getStateHandler().handle(animationState) == PlayState.CONTINUE)) {
                return PlayState.CONTINUE;
            }
            this.triggeredAnimation = null;
            this.needsAnimationReload = true;
        }
        return getStateHandler().handle(animationState);
    }

    public void process(GeoModel<T> model, AnimationState<T> state, Map<String, GeoBone> bones, Map<String, BoneSnapshot> snapshots, double seekTime, boolean crashWhenCantFindBone) {
        double adjustedTick = adjustTick(seekTime);
        this.lastModel = model;
        if (this.animationState == State.TRANSITIONING && adjustedTick >= this.transitionLength) {
            this.shouldResetTick = true;
            this.animationState = State.RUNNING;
            adjustedTick = adjustTick(seekTime);
        }
        PlayState playState = handleAnimationState(state);
        if (playState == PlayState.STOP || (this.currentAnimation == null && this.animationQueue.isEmpty())) {
            this.animationState = State.STOPPED;
            this.justStopped = true;
            return;
        }
        createInitialQueues(bones.values());
        if (this.justStartedTransition && (this.shouldResetTick || this.justStopped)) {
            this.justStopped = false;
            adjustedTick = adjustTick(seekTime);
            if (this.currentAnimation == null) {
                this.animationState = State.TRANSITIONING;
            }
        } else if (this.currentAnimation == null) {
            this.shouldResetTick = true;
            this.animationState = State.TRANSITIONING;
            this.justStartedTransition = true;
            this.needsAnimationReload = false;
            adjustedTick = adjustTick(seekTime);
        } else if (this.animationState != State.TRANSITIONING) {
            this.animationState = State.RUNNING;
        }
        if (getAnimationState() == State.RUNNING) {
            processCurrentAnimation(adjustedTick, seekTime, crashWhenCantFindBone);
            return;
        }
        if (this.animationState == State.TRANSITIONING) {
            if (this.lastPollTime != seekTime && (adjustedTick == 0.0d || this.isJustStarting)) {
                this.justStartedTransition = false;
                this.lastPollTime = seekTime;
                this.currentAnimation = this.animationQueue.poll();
                resetEventKeyFrames();
                if (this.currentAnimation == null) {
                    return;
                } else {
                    saveSnapshotsForAnimation(this.currentAnimation, snapshots);
                }
            }
            if (this.currentAnimation != null) {
                MathParser.setVariable(MolangQueries.ANIM_TIME, () -> {
                    return 0.0d;
                });
                for (BoneAnimation boneAnimation : this.currentAnimation.animation().boneAnimations()) {
                    BoneAnimationQueue boneAnimationQueue = this.boneAnimationQueues.get(boneAnimation.boneName());
                    BoneSnapshot boneSnapshot = this.boneSnapshots.get(boneAnimation.boneName());
                    GeoBone bone = bones.get(boneAnimation.boneName());
                    if (boneSnapshot != null) {
                        if (bone == null) {
                            if (crashWhenCantFindBone) {
                                throw new RuntimeException("Could not find bone: " + boneAnimation.boneName());
                            }
                        } else {
                            KeyframeStack<Keyframe<MathValue>> rotationKeyFrames = boneAnimation.rotationKeyFrames();
                            KeyframeStack<Keyframe<MathValue>> positionKeyFrames = boneAnimation.positionKeyFrames();
                            KeyframeStack<Keyframe<MathValue>> scaleKeyFrames = boneAnimation.scaleKeyFrames();
                            if (!rotationKeyFrames.xKeyframes().isEmpty()) {
                                boneAnimationQueue.addNextRotation(null, adjustedTick, this.transitionLength, boneSnapshot, bone.getInitialSnapshot(), getAnimationPointAtTick(rotationKeyFrames.xKeyframes(), 0.0d, true, Direction.Axis.X), getAnimationPointAtTick(rotationKeyFrames.yKeyframes(), 0.0d, true, Direction.Axis.Y), getAnimationPointAtTick(rotationKeyFrames.zKeyframes(), 0.0d, true, Direction.Axis.Z));
                            }
                            if (!positionKeyFrames.xKeyframes().isEmpty()) {
                                boneAnimationQueue.addNextPosition(null, adjustedTick, this.transitionLength, boneSnapshot, getAnimationPointAtTick(positionKeyFrames.xKeyframes(), 0.0d, false, Direction.Axis.X), getAnimationPointAtTick(positionKeyFrames.yKeyframes(), 0.0d, false, Direction.Axis.Y), getAnimationPointAtTick(positionKeyFrames.zKeyframes(), 0.0d, false, Direction.Axis.Z));
                            }
                            if (!scaleKeyFrames.xKeyframes().isEmpty()) {
                                boneAnimationQueue.addNextScale(null, adjustedTick, this.transitionLength, boneSnapshot, getAnimationPointAtTick(scaleKeyFrames.xKeyframes(), 0.0d, false, Direction.Axis.X), getAnimationPointAtTick(scaleKeyFrames.yKeyframes(), 0.0d, false, Direction.Axis.Y), getAnimationPointAtTick(scaleKeyFrames.zKeyframes(), 0.0d, false, Direction.Axis.Z));
                            }
                        }
                    }
                }
            }
        }
    }

    private void processCurrentAnimation(double adjustedTick, double seekTime, boolean crashWhenCantFindBone) {
        if (adjustedTick >= this.currentAnimation.animation().length()) {
            if (this.currentAnimation.loopType().shouldPlayAgain(this.animatable, this, this.currentAnimation.animation())) {
                if (this.animationState != State.PAUSED) {
                    this.shouldResetTick = true;
                    adjustedTick = adjustTick(seekTime);
                    resetEventKeyFrames();
                }
            } else {
                AnimationProcessor.QueuedAnimation nextAnimation = this.animationQueue.peek();
                resetEventKeyFrames();
                if (nextAnimation == null) {
                    this.animationState = State.STOPPED;
                    return;
                }
                this.animationState = State.TRANSITIONING;
                this.shouldResetTick = true;
                adjustedTick = adjustTick(seekTime);
                this.currentAnimation = this.animationQueue.poll();
            }
        }
        double finalAdjustedTick = adjustedTick;
        MathParser.setVariable(MolangQueries.ANIM_TIME, () -> {
            return finalAdjustedTick / 20.0d;
        });
        for (BoneAnimation boneAnimation : this.currentAnimation.animation().boneAnimations()) {
            BoneAnimationQueue boneAnimationQueue = this.boneAnimationQueues.get(boneAnimation.boneName());
            if (boneAnimationQueue == null) {
                if (crashWhenCantFindBone) {
                    throw new RuntimeException("Could not find bone: " + boneAnimation.boneName());
                }
            } else {
                KeyframeStack<Keyframe<MathValue>> rotationKeyFrames = boneAnimation.rotationKeyFrames();
                KeyframeStack<Keyframe<MathValue>> positionKeyFrames = boneAnimation.positionKeyFrames();
                KeyframeStack<Keyframe<MathValue>> scaleKeyFrames = boneAnimation.scaleKeyFrames();
                if (!rotationKeyFrames.xKeyframes().isEmpty()) {
                    boneAnimationQueue.addRotations(getAnimationPointAtTick(rotationKeyFrames.xKeyframes(), adjustedTick, true, Direction.Axis.X), getAnimationPointAtTick(rotationKeyFrames.yKeyframes(), adjustedTick, true, Direction.Axis.Y), getAnimationPointAtTick(rotationKeyFrames.zKeyframes(), adjustedTick, true, Direction.Axis.Z));
                }
                if (!positionKeyFrames.xKeyframes().isEmpty()) {
                    boneAnimationQueue.addPositions(getAnimationPointAtTick(positionKeyFrames.xKeyframes(), adjustedTick, false, Direction.Axis.X), getAnimationPointAtTick(positionKeyFrames.yKeyframes(), adjustedTick, false, Direction.Axis.Y), getAnimationPointAtTick(positionKeyFrames.zKeyframes(), adjustedTick, false, Direction.Axis.Z));
                }
                if (!scaleKeyFrames.xKeyframes().isEmpty()) {
                    boneAnimationQueue.addScales(getAnimationPointAtTick(scaleKeyFrames.xKeyframes(), adjustedTick, false, Direction.Axis.X), getAnimationPointAtTick(scaleKeyFrames.yKeyframes(), adjustedTick, false, Direction.Axis.Y), getAnimationPointAtTick(scaleKeyFrames.zKeyframes(), adjustedTick, false, Direction.Axis.Z));
                }
            }
        }
        double adjustedTick2 = adjustedTick + this.transitionLength;
        for (SoundKeyframeData keyframeData : this.currentAnimation.animation().keyFrames().sounds()) {
            if (adjustedTick2 >= keyframeData.getStartTick() && this.executedKeyFrames.add(keyframeData)) {
                if (this.soundKeyframeHandler == null) {
                    GeckoLibConstants.LOGGER.log(Level.WARN, "Sound Keyframe found for " + this.animatable.getClass().getSimpleName() + " -> " + getName() + ", but no keyframe handler registered");
                    break;
                }
                this.soundKeyframeHandler.handle(new SoundKeyframeEvent<>(this.animatable, adjustedTick2, this, keyframeData));
            }
        }
        for (ParticleKeyframeData keyframeData2 : this.currentAnimation.animation().keyFrames().particles()) {
            if (adjustedTick2 >= keyframeData2.getStartTick() && this.executedKeyFrames.add(keyframeData2)) {
                if (this.particleKeyframeHandler == null) {
                    GeckoLibConstants.LOGGER.log(Level.WARN, "Particle Keyframe found for " + this.animatable.getClass().getSimpleName() + " -> " + getName() + ", but no keyframe handler registered");
                    break;
                }
                this.particleKeyframeHandler.handle(new ParticleKeyframeEvent<>(this.animatable, adjustedTick2, this, keyframeData2));
            }
        }
        for (CustomInstructionKeyframeData keyframeData3 : this.currentAnimation.animation().keyFrames().customInstructions()) {
            if (adjustedTick2 >= keyframeData3.getStartTick() && this.executedKeyFrames.add(keyframeData3)) {
                if (this.customKeyframeHandler == null) {
                    GeckoLibConstants.LOGGER.log(Level.WARN, "Custom Instruction Keyframe found for " + this.animatable.getClass().getSimpleName() + " -> " + getName() + ", but no keyframe handler registered");
                    break;
                }
                this.customKeyframeHandler.handle(new CustomInstructionKeyframeEvent<>(this.animatable, adjustedTick2, this, keyframeData3));
            }
        }
        if (this.transitionLength == 0.0d && this.shouldResetTick && this.animationState == State.TRANSITIONING) {
            this.currentAnimation = this.animationQueue.poll();
        }
    }

    private void createInitialQueues(Collection<GeoBone> modelRendererList) {
        this.boneAnimationQueues.clear();
        for (GeoBone modelRenderer : modelRendererList) {
            this.boneAnimationQueues.put(modelRenderer.getName(), new BoneAnimationQueue(modelRenderer));
        }
    }

    private void saveSnapshotsForAnimation(AnimationProcessor.QueuedAnimation animation, Map<String, BoneSnapshot> snapshots) {
        for (BoneSnapshot snapshot : snapshots.values()) {
            if (animation.animation().boneAnimations() != null) {
                for (BoneAnimation boneAnimation : animation.animation().boneAnimations()) {
                    if (boneAnimation.boneName().equals(snapshot.getBone().getName())) {
                        this.boneSnapshots.put(boneAnimation.boneName(), BoneSnapshot.copy(snapshot));
                        break;
                    }
                }
            }
        }
    }

    protected double adjustTick(double tick) {
        if (!this.shouldResetTick) {
            return this.animationSpeedModifier.apply(this.animatable).doubleValue() * Math.max(tick - this.tickOffset, 0.0d);
        }
        if (getAnimationState() != State.STOPPED) {
            this.tickOffset = tick;
        }
        this.shouldResetTick = false;
        return 0.0d;
    }

    private AnimationPoint getAnimationPointAtTick(List<Keyframe<MathValue>> frames, double tick, boolean isRotation, Direction.Axis axis) {
        KeyframeLocation<Keyframe<MathValue>> location = getCurrentKeyFrameLocation(frames, tick);
        Keyframe<MathValue> currentFrame = location.keyframe();
        double startValue = currentFrame.startValue().get();
        double endValue = currentFrame.endValue().get();
        if (isRotation) {
            if (!(currentFrame.startValue() instanceof Constant)) {
                startValue = Math.toRadians(startValue);
                if (axis == Direction.Axis.X || axis == Direction.Axis.Y) {
                    startValue *= -1.0d;
                }
            }
            if (!(currentFrame.endValue() instanceof Constant)) {
                endValue = Math.toRadians(endValue);
                if (axis == Direction.Axis.X || axis == Direction.Axis.Y) {
                    endValue *= -1.0d;
                }
            }
        }
        return new AnimationPoint(currentFrame, location.startTick(), currentFrame.length(), startValue, endValue);
    }

    private KeyframeLocation<Keyframe<MathValue>> getCurrentKeyFrameLocation(List<Keyframe<MathValue>> frames, double ageInTicks) {
        double totalFrameTime = 0.0d;
        for (Keyframe<MathValue> frame : frames) {
            totalFrameTime += frame.length();
            if (totalFrameTime > ageInTicks) {
                return new KeyframeLocation<>(frame, ageInTicks - (totalFrameTime - frame.length()));
            }
        }
        return new KeyframeLocation<>((Keyframe) frames.getLast(), ageInTicks);
    }

    private void resetEventKeyFrames() {
        this.executedKeyFrames.clear();
    }
}
