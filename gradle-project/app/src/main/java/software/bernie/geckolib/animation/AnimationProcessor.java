package software.bernie.geckolib.animation;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import net.minecraft.util.Mth;
import org.apache.logging.log4j.Level;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.keyframe.AnimationPoint;
import software.bernie.geckolib.animation.keyframe.BoneAnimationQueue;
import software.bernie.geckolib.animation.state.BoneSnapshot;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.loading.math.MolangQueries;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/AnimationProcessor.class */
public class AnimationProcessor<T extends GeoAnimatable> {
    private final GeoModel<T> model;
    private final Map<String, GeoBone> bones = new Object2ObjectOpenHashMap();
    public boolean reloadAnimations = false;

    public AnimationProcessor(GeoModel<T> model) {
        this.model = model;
    }

    public Queue<QueuedAnimation> buildAnimationQueue(T animatable, RawAnimation rawAnimation) {
        LinkedList<QueuedAnimation> animations = new LinkedList<>();
        boolean error = false;
        for (RawAnimation.Stage stage : rawAnimation.getAnimationStages()) {
            Animation animation = null;
            if (stage.animationName() == "internal.wait") {
                animation = Animation.generateWaitAnimation(stage.additionalTicks());
            } else {
                try {
                    animation = this.model.getAnimation(animatable, stage.animationName());
                } catch (RuntimeException ex) {
                    GeckoLibConstants.LOGGER.log(Level.ERROR, "Unable to find animation: " + stage.animationName() + " for " + animatable.getClass().getSimpleName());
                    error = true;
                    ex.printStackTrace();
                }
            }
            if (animation != null) {
                animations.add(new QueuedAnimation(animation, stage.loopType()));
            }
        }
        if (error) {
            return null;
        }
        return animations;
    }

    public void tickAnimation(T animatable, GeoModel<T> model, AnimatableManager<T> animatableManager, double animTime, AnimationState<T> state, boolean crashWhenCantFindBone) {
        Map<String, BoneSnapshot> boneSnapshots = updateBoneSnapshots(animatableManager.getBoneSnapshotCollection());
        for (AnimationController<T> controller : animatableManager.getAnimationControllers().values()) {
            if (this.reloadAnimations) {
                controller.forceAnimationReset();
                controller.getBoneAnimationQueues().clear();
            }
            controller.isJustStarting = animatableManager.isFirstTick();
            state.withController(controller);
            controller.process(model, state, this.bones, boneSnapshots, animTime, crashWhenCantFindBone);
            for (BoneAnimationQueue boneAnimation : controller.getBoneAnimationQueues().values()) {
                GeoBone bone = boneAnimation.bone();
                BoneSnapshot snapshot = boneSnapshots.get(bone.getName());
                BoneSnapshot initialSnapshot = bone.getInitialSnapshot();
                AnimationPoint rotXPoint = boneAnimation.rotationXQueue().poll();
                AnimationPoint rotYPoint = boneAnimation.rotationYQueue().poll();
                AnimationPoint rotZPoint = boneAnimation.rotationZQueue().poll();
                AnimationPoint posXPoint = boneAnimation.positionXQueue().poll();
                AnimationPoint posYPoint = boneAnimation.positionYQueue().poll();
                AnimationPoint posZPoint = boneAnimation.positionZQueue().poll();
                AnimationPoint scaleXPoint = boneAnimation.scaleXQueue().poll();
                AnimationPoint scaleYPoint = boneAnimation.scaleYQueue().poll();
                AnimationPoint scaleZPoint = boneAnimation.scaleZQueue().poll();
                EasingType easingType = controller.overrideEasingTypeFunction.apply(animatable);
                if (rotXPoint != null && rotYPoint != null && rotZPoint != null) {
                    bone.setRotX(((float) EasingType.lerpWithOverride(rotXPoint, easingType)) + initialSnapshot.getRotX());
                    bone.setRotY(((float) EasingType.lerpWithOverride(rotYPoint, easingType)) + initialSnapshot.getRotY());
                    bone.setRotZ(((float) EasingType.lerpWithOverride(rotZPoint, easingType)) + initialSnapshot.getRotZ());
                    snapshot.updateRotation(bone.getRotX(), bone.getRotY(), bone.getRotZ());
                    snapshot.startRotAnim();
                    bone.markRotationAsChanged();
                }
                if (posXPoint != null && posYPoint != null && posZPoint != null) {
                    bone.setPosX((float) EasingType.lerpWithOverride(posXPoint, easingType));
                    bone.setPosY((float) EasingType.lerpWithOverride(posYPoint, easingType));
                    bone.setPosZ((float) EasingType.lerpWithOverride(posZPoint, easingType));
                    snapshot.updateOffset(bone.getPosX(), bone.getPosY(), bone.getPosZ());
                    snapshot.startPosAnim();
                    bone.markPositionAsChanged();
                }
                if (scaleXPoint != null && scaleYPoint != null && scaleZPoint != null) {
                    bone.setScaleX((float) EasingType.lerpWithOverride(scaleXPoint, easingType));
                    bone.setScaleY((float) EasingType.lerpWithOverride(scaleYPoint, easingType));
                    bone.setScaleZ((float) EasingType.lerpWithOverride(scaleZPoint, easingType));
                    snapshot.updateScale(bone.getScaleX(), bone.getScaleY(), bone.getScaleZ());
                    snapshot.startScaleAnim();
                    bone.markScaleAsChanged();
                }
            }
        }
        this.reloadAnimations = false;
        double resetTickLength = animatable.getBoneResetTime();
        for (GeoBone bone2 : getRegisteredBones()) {
            if (!bone2.hasRotationChanged()) {
                BoneSnapshot initialSnapshot2 = bone2.getInitialSnapshot();
                BoneSnapshot saveSnapshot = boneSnapshots.get(bone2.getName());
                if (saveSnapshot.isRotAnimInProgress()) {
                    saveSnapshot.stopRotAnim(animTime);
                }
                double percentageReset = Math.min((animTime - saveSnapshot.getLastResetRotationTick()) / resetTickLength, 1.0d);
                bone2.setRotX((float) Mth.lerp(percentageReset, saveSnapshot.getRotX(), initialSnapshot2.getRotX()));
                bone2.setRotY((float) Mth.lerp(percentageReset, saveSnapshot.getRotY(), initialSnapshot2.getRotY()));
                bone2.setRotZ((float) Mth.lerp(percentageReset, saveSnapshot.getRotZ(), initialSnapshot2.getRotZ()));
                if (percentageReset >= 1.0d) {
                    saveSnapshot.updateRotation(bone2.getRotX(), bone2.getRotY(), bone2.getRotZ());
                }
            }
            if (!bone2.hasPositionChanged()) {
                BoneSnapshot initialSnapshot3 = bone2.getInitialSnapshot();
                BoneSnapshot saveSnapshot2 = boneSnapshots.get(bone2.getName());
                if (saveSnapshot2.isPosAnimInProgress()) {
                    saveSnapshot2.stopPosAnim(animTime);
                }
                double percentageReset2 = Math.min((animTime - saveSnapshot2.getLastResetPositionTick()) / resetTickLength, 1.0d);
                bone2.setPosX((float) Mth.lerp(percentageReset2, saveSnapshot2.getOffsetX(), initialSnapshot3.getOffsetX()));
                bone2.setPosY((float) Mth.lerp(percentageReset2, saveSnapshot2.getOffsetY(), initialSnapshot3.getOffsetY()));
                bone2.setPosZ((float) Mth.lerp(percentageReset2, saveSnapshot2.getOffsetZ(), initialSnapshot3.getOffsetZ()));
                if (percentageReset2 >= 1.0d) {
                    saveSnapshot2.updateOffset(bone2.getPosX(), bone2.getPosY(), bone2.getPosZ());
                }
            }
            if (!bone2.hasScaleChanged()) {
                BoneSnapshot initialSnapshot4 = bone2.getInitialSnapshot();
                BoneSnapshot saveSnapshot3 = boneSnapshots.get(bone2.getName());
                if (saveSnapshot3.isScaleAnimInProgress()) {
                    saveSnapshot3.stopScaleAnim(animTime);
                }
                double percentageReset3 = Math.min((animTime - saveSnapshot3.getLastResetScaleTick()) / resetTickLength, 1.0d);
                bone2.setScaleX((float) Mth.lerp(percentageReset3, saveSnapshot3.getScaleX(), initialSnapshot4.getScaleX()));
                bone2.setScaleY((float) Mth.lerp(percentageReset3, saveSnapshot3.getScaleY(), initialSnapshot4.getScaleY()));
                bone2.setScaleZ((float) Mth.lerp(percentageReset3, saveSnapshot3.getScaleZ(), initialSnapshot4.getScaleZ()));
                if (percentageReset3 >= 1.0d) {
                    saveSnapshot3.updateScale(bone2.getScaleX(), bone2.getScaleY(), bone2.getScaleZ());
                }
            }
        }
        resetBoneTransformationMarkers();
        animatableManager.finishFirstTick();
    }

    private void resetBoneTransformationMarkers() {
        getRegisteredBones().forEach((v0) -> {
            v0.resetStateChanges();
        });
    }

    private Map<String, BoneSnapshot> updateBoneSnapshots(Map<String, BoneSnapshot> snapshots) {
        for (GeoBone bone : getRegisteredBones()) {
            if (!snapshots.containsKey(bone.getName())) {
                snapshots.put(bone.getName(), BoneSnapshot.copy(bone.getInitialSnapshot()));
            }
        }
        return snapshots;
    }

    public GeoBone getBone(String boneName) {
        return this.bones.get(boneName);
    }

    public void registerGeoBone(GeoBone bone) {
        bone.saveInitialSnapshot();
        this.bones.put(bone.getName(), bone);
        for (GeoBone child : bone.getChildBones()) {
            registerGeoBone(child);
        }
    }

    public void setActiveModel(BakedGeoModel model) {
        this.bones.clear();
        for (GeoBone bone : model.topLevelBones()) {
            registerGeoBone(bone);
        }
    }

    public Collection<GeoBone> getRegisteredBones() {
        return this.bones.values();
    }

    public void preAnimationSetup(AnimationState<T> animationState, double animTime) {
        MolangQueries.updateActor(animationState, animTime);
        this.model.applyMolangQueries(animationState, animTime);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation.class */
    public static final class QueuedAnimation extends Record {
        private final Animation animation;
        private final Animation.LoopType loopType;

        public QueuedAnimation(Animation animation, Animation.LoopType loopType) {
            this.animation = animation;
            this.loopType = loopType;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, QueuedAnimation.class), QueuedAnimation.class, "animation;loopType", "FIELD:Lsoftware/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation;->animation:Lsoftware/bernie/geckolib/animation/Animation;", "FIELD:Lsoftware/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, QueuedAnimation.class), QueuedAnimation.class, "animation;loopType", "FIELD:Lsoftware/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation;->animation:Lsoftware/bernie/geckolib/animation/Animation;", "FIELD:Lsoftware/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, QueuedAnimation.class, Object.class), QueuedAnimation.class, "animation;loopType", "FIELD:Lsoftware/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation;->animation:Lsoftware/bernie/geckolib/animation/Animation;", "FIELD:Lsoftware/bernie/geckolib/animation/AnimationProcessor$QueuedAnimation;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public Animation animation() {
            return this.animation;
        }

        public Animation.LoopType loopType() {
            return this.loopType;
        }
    }
}
