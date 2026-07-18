package foundry.veil.api.client.necromancer.animation;

import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.necromancer.constraint.Constraint;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/Animator.class */
public abstract class Animator<P extends SkeletonParent<?, ?>, S extends Skeleton> {
    protected final P parent;
    protected final S skeleton;
    private final List<AnimationEntry<P, S>> animations = new ArrayList();
    private final List<ConstraintEntry> constraints = new ArrayList();

    protected Animator(P parent, S skeleton) {
        this.parent = parent;
        this.skeleton = skeleton;
    }

    public void addConstraint(Constraint constraint, int priority) {
        this.constraints.add(new ConstraintEntry(constraint, priority));
        this.constraints.sort(Comparator.comparingInt((v0) -> {
            return v0.priority();
        }));
    }

    public AnimationEntry<P, S> addAnimation(Animation<P, S> animation, int priority) {
        AnimationEntry<P, S> entry = new AnimationEntry<>(animation, priority);
        this.animations.add(entry);
        this.animations.sort(Comparator.comparingInt(animEntry -> {
            return animEntry.priority;
        }));
        return entry;
    }

    public TimedAnimationEntry<P, S> addTimedAnimation(Animation<P, S> animation, int priority, int animLength) {
        TimedAnimationEntry<P, S> entry = new TimedAnimationEntry<>(animation, priority, animLength);
        this.animations.add(entry);
        this.animations.sort(Comparator.comparingInt(animEntry -> {
            return animEntry.priority;
        }));
        return entry;
    }

    public void tick() {
        this.skeleton.tick();
        this.skeleton.bones.forEach((name, bone) -> {
            bone.reset();
        });
        animate();
        this.animations.forEach(animation -> {
            animation.apply(this.parent, this.skeleton);
        });
        this.constraints.forEach(constraintEntry -> {
            constraintEntry.constraint.apply();
        });
        animatePostConstraints();
    }

    public void animate() {
    }

    public void animatePostConstraints() {
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry.class */
    static final class ConstraintEntry extends Record {
        private final Constraint constraint;
        private final int priority;

        ConstraintEntry(Constraint constraint, int priority) {
            this.constraint = constraint;
            this.priority = priority;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ConstraintEntry.class), ConstraintEntry.class, "constraint;priority", "FIELD:Lfoundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry;->constraint:Lfoundry/veil/api/client/necromancer/constraint/Constraint;", "FIELD:Lfoundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry;->priority:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ConstraintEntry.class), ConstraintEntry.class, "constraint;priority", "FIELD:Lfoundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry;->constraint:Lfoundry/veil/api/client/necromancer/constraint/Constraint;", "FIELD:Lfoundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry;->priority:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ConstraintEntry.class, Object.class), ConstraintEntry.class, "constraint;priority", "FIELD:Lfoundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry;->constraint:Lfoundry/veil/api/client/necromancer/constraint/Constraint;", "FIELD:Lfoundry/veil/api/client/necromancer/animation/Animator$ConstraintEntry;->priority:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public Constraint constraint() {
            return this.constraint;
        }

        public int priority() {
            return this.priority;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/Animator$AnimationEntry.class */
    public static class AnimationEntry<P extends SkeletonParent<?, ?>, S extends Skeleton> {
        protected final Animation<P, S> animation;
        protected final int priority;
        protected float mixFactor;
        protected float time;

        private AnimationEntry(Animation<P, S> animation, int priority) {
            this.animation = animation;
            this.priority = priority;
        }

        public float getMixFactor() {
            return this.mixFactor;
        }

        public void setMixFactor(float mixFactor) {
            this.mixFactor = mixFactor;
        }

        public float getTime() {
            return this.time;
        }

        public void setTime(float time) {
            this.time = time;
        }

        protected void apply(P parent, S skeleton) {
            if (!this.animation.running(parent, skeleton, this.mixFactor, this.time)) {
                return;
            }
            this.animation.apply(parent, skeleton, this.mixFactor, this.time);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/animation/Animator$TimedAnimationEntry.class */
    public static class TimedAnimationEntry<P extends SkeletonParent<?, ?>, T extends Skeleton> extends AnimationEntry<P, T> {
        int lengthInTicks;
        boolean rewinding;
        public boolean playing;

        private TimedAnimationEntry(Animation<P, T> animation, int priority, int lengthInTicks) {
            super(animation, priority);
            this.rewinding = false;
            this.playing = false;
            setAnimLength(lengthInTicks);
        }

        public void setAnimLength(int lengthInTicks) {
            this.lengthInTicks = lengthInTicks;
        }

        public void begin() {
            this.time = 0.0f;
            resume();
        }

        public void resume() {
            this.playing = true;
            if (animationEnded()) {
                this.time = 0.0f;
            }
        }

        public void rewind() {
            this.rewinding = true;
        }

        public void stop() {
            this.playing = false;
            this.rewinding = false;
        }

        public boolean animationEnded() {
            return (this.time > ((float) this.lengthInTicks) && !this.rewinding) || (this.time < 0.0f && this.rewinding);
        }

        private void updateTime(P parent, T skeleton) {
            if (this.playing && this.animation.running(parent, skeleton, this.mixFactor, this.time)) {
                this.time += this.rewinding ? -1.0f : 1.0f;
            }
            if (animationEnded()) {
                stop();
            }
        }

        @Override // foundry.veil.api.client.necromancer.animation.Animator.AnimationEntry
        protected void apply(P parent, T skeleton) {
            updateTime(parent, skeleton);
            super.apply(parent, skeleton);
        }
    }
}
