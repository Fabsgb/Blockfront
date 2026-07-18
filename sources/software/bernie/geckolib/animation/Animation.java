package software.bernie.geckolib.animation;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.keyframe.BoneAnimation;
import software.bernie.geckolib.animation.keyframe.event.data.CustomInstructionKeyframeData;
import software.bernie.geckolib.animation.keyframe.event.data.ParticleKeyframeData;
import software.bernie.geckolib.animation.keyframe.event.data.SoundKeyframeData;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/Animation.class */
public final class Animation extends Record {
    private final String name;
    private final double length;
    private final LoopType loopType;
    private final BoneAnimation[] boneAnimations;
    private final Keyframes keyFrames;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/Animation$Keyframes.class */
    public static final class Keyframes extends Record {
        private final SoundKeyframeData[] sounds;
        private final ParticleKeyframeData[] particles;
        private final CustomInstructionKeyframeData[] customInstructions;

        public Keyframes(SoundKeyframeData[] sounds, ParticleKeyframeData[] particles, CustomInstructionKeyframeData[] customInstructions) {
            this.sounds = sounds;
            this.particles = particles;
            this.customInstructions = customInstructions;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Keyframes.class), Keyframes.class, "sounds;particles;customInstructions", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->sounds:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/SoundKeyframeData;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->particles:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/ParticleKeyframeData;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->customInstructions:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/CustomInstructionKeyframeData;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Keyframes.class), Keyframes.class, "sounds;particles;customInstructions", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->sounds:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/SoundKeyframeData;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->particles:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/ParticleKeyframeData;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->customInstructions:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/CustomInstructionKeyframeData;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Keyframes.class, Object.class), Keyframes.class, "sounds;particles;customInstructions", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->sounds:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/SoundKeyframeData;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->particles:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/ParticleKeyframeData;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;->customInstructions:[Lsoftware/bernie/geckolib/animation/keyframe/event/data/CustomInstructionKeyframeData;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public SoundKeyframeData[] sounds() {
            return this.sounds;
        }

        public ParticleKeyframeData[] particles() {
            return this.particles;
        }

        public CustomInstructionKeyframeData[] customInstructions() {
            return this.customInstructions;
        }
    }

    public Animation(String name, double length, LoopType loopType, BoneAnimation[] boneAnimations, Keyframes keyFrames) {
        this.name = name;
        this.length = length;
        this.loopType = loopType;
        this.boneAnimations = boneAnimations;
        this.keyFrames = keyFrames;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Animation.class), Animation.class, "name;length;loopType;boneAnimations;keyFrames", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->length:D", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->boneAnimations:[Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->keyFrames:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Animation.class), Animation.class, "name;length;loopType;boneAnimations;keyFrames", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->length:D", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->boneAnimations:[Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->keyFrames:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Animation.class, Object.class), Animation.class, "name;length;loopType;boneAnimations;keyFrames", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->name:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->length:D", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->boneAnimations:[Lsoftware/bernie/geckolib/animation/keyframe/BoneAnimation;", "FIELD:Lsoftware/bernie/geckolib/animation/Animation;->keyFrames:Lsoftware/bernie/geckolib/animation/Animation$Keyframes;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String name() {
        return this.name;
    }

    public double length() {
        return this.length;
    }

    public LoopType loopType() {
        return this.loopType;
    }

    public BoneAnimation[] boneAnimations() {
        return this.boneAnimations;
    }

    public Keyframes keyFrames() {
        return this.keyFrames;
    }

    static Animation generateWaitAnimation(double length) {
        return new Animation("internal.wait", length, LoopType.PLAY_ONCE, new BoneAnimation[0], new Keyframes(new SoundKeyframeData[0], new ParticleKeyframeData[0], new CustomInstructionKeyframeData[0]));
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/Animation$LoopType.class */
    @FunctionalInterface
    public interface LoopType {
        public static final Map<String, LoopType> LOOP_TYPES = new ConcurrentHashMap(4);
        public static final LoopType DEFAULT = (animatable, controller, currentAnimation) -> {
            return currentAnimation.loopType().shouldPlayAgain(animatable, controller, currentAnimation);
        };
        public static final LoopType PLAY_ONCE = register("play_once", register("false", (animatable, controller, currentAnimation) -> {
            return false;
        }));
        public static final LoopType HOLD_ON_LAST_FRAME = register("hold_on_last_frame", (animatable, controller, currentAnimation) -> {
            controller.animationState = AnimationController.State.PAUSED;
            return true;
        });
        public static final LoopType LOOP = register("loop", register("true", (animatable, controller, currentAnimation) -> {
            return true;
        }));

        boolean shouldPlayAgain(GeoAnimatable geoAnimatable, AnimationController<? extends GeoAnimatable> animationController, Animation animation);

        static LoopType fromJson(JsonElement json) {
            if (json == null || !json.isJsonPrimitive()) {
                return PLAY_ONCE;
            }
            JsonPrimitive primitive = json.getAsJsonPrimitive();
            if (primitive.isBoolean()) {
                return primitive.getAsBoolean() ? LOOP : PLAY_ONCE;
            }
            if (primitive.isString()) {
                return fromString(primitive.getAsString());
            }
            return PLAY_ONCE;
        }

        static LoopType fromString(String name) {
            return LOOP_TYPES.getOrDefault(name, PLAY_ONCE);
        }

        static LoopType register(String name, LoopType loopType) {
            LOOP_TYPES.put(name, loopType);
            return loopType;
        }
    }
}
