package foundry.veil.api.client.necromancer.animation.keyframe;

import foundry.veil.api.client.necromancer.Bone;
import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.necromancer.SkeletonParent;
import foundry.veil.api.client.necromancer.animation.Animation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.Mth;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/KeyframedAnimation.class */
public class KeyframedAnimation<P extends SkeletonParent<?, ?>, S extends Skeleton> extends Animation<P, S> {
    private final Map<String, KeyframeTimeline> keyframesByBoneName;
    private final boolean additive;
    private final boolean looping;
    private final Quaternionf tempRotationA = new Quaternionf();
    private final Quaternionf tempRotationB = new Quaternionf();
    private final Keyframe[] tempKeyframes = new Keyframe[4];

    private KeyframedAnimation(Map<String, KeyframeTimeline> keyframesByBoneName, boolean additive, boolean looping) {
        this.keyframesByBoneName = keyframesByBoneName;
        this.additive = additive;
        this.looping = looping;
    }

    @Override // foundry.veil.api.client.necromancer.animation.Animation
    public void apply(P parent, S skeleton, float mixFactor, float time) {
        for (Map.Entry<String, KeyframeTimeline> timeline : this.keyframesByBoneName.entrySet()) {
            Bone bone = skeleton.bones.get(timeline.getKey());
            if (bone != null) {
                KeyframeTimeline keyframes = timeline.getValue();
                float t = keyframes.getAdjacentKeyframes(time, this.looping, this.tempKeyframes);
                Keyframe a = this.tempKeyframes[1];
                Keyframe b = this.tempKeyframes[2];
                Interpolation interpolation = a.interpolation();
                if (this.additive) {
                    bone.position.add(interpolation.interpolate(a.transform().m8329px(), b.transform().m8329px(), t), interpolation.interpolate(a.transform().m8330py(), b.transform().m8330py(), t), interpolation.interpolate(a.transform().m8331pz(), b.transform().m8331pz(), t));
                    this.tempRotationA.set(a.transform().m8335qx(), a.transform().m8336qy(), a.transform().m8337qz(), a.transform().m8338qw());
                    this.tempRotationB.set(b.transform().m8335qx(), b.transform().m8336qy(), b.transform().m8337qz(), b.transform().m8338qw());
                    interpolation.interpolate(this.tempRotationA, this.tempRotationB, t, this.tempRotationA);
                    this.tempRotationA.slerp(this.tempRotationB.identity(), mixFactor);
                    bone.rotation.premul(this.tempRotationA);
                    bone.size.mul(Mth.lerp(mixFactor, 1.0f, interpolation.interpolate(a.transform().m8332sx(), b.transform().m8332sx(), t)), Mth.lerp(mixFactor, 1.0f, interpolation.interpolate(a.transform().m8333sy(), b.transform().m8333sy(), t)), Mth.lerp(mixFactor, 1.0f, interpolation.interpolate(a.transform().m8334sz(), b.transform().m8334sz(), t)));
                } else {
                    bone.size.set(Mth.lerp(mixFactor, bone.position.x, interpolation.interpolate(a.transform().m8329px(), b.transform().m8329px(), t)), Mth.lerp(mixFactor, bone.position.y, interpolation.interpolate(a.transform().m8330py(), b.transform().m8330py(), t)), Mth.lerp(mixFactor, bone.position.z, interpolation.interpolate(a.transform().m8331pz(), b.transform().m8331pz(), t)));
                    this.tempRotationA.set(a.transform().m8335qx(), a.transform().m8336qy(), a.transform().m8337qz(), a.transform().m8338qw());
                    this.tempRotationB.set(b.transform().m8335qx(), b.transform().m8336qy(), b.transform().m8337qz(), b.transform().m8338qw());
                    interpolation.interpolate(this.tempRotationA, this.tempRotationB, t, this.tempRotationA);
                    bone.rotation.slerp(this.tempRotationA, mixFactor);
                    bone.size.set(Mth.lerp(mixFactor, bone.size.x, interpolation.interpolate(a.transform().m8332sx(), b.transform().m8332sx(), t)), Mth.lerp(mixFactor, bone.size.y, interpolation.interpolate(a.transform().m8333sy(), b.transform().m8333sy(), t)), Mth.lerp(mixFactor, bone.size.z, interpolation.interpolate(a.transform().m8334sz(), b.transform().m8334sz(), t)));
                }
            }
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/KeyframedAnimation$Builder.class */
    public static class Builder {
        boolean looped = false;
        boolean additive = false;
        Map<String, List<Keyframe>> timelines = new HashMap();

        Builder looped(boolean isLooped) {
            this.looped = isLooped;
            return this;
        }

        Builder additive(boolean isAdditive) {
            this.additive = isAdditive;
            return this;
        }

        public void addKeyframe(String boneId, float time, Interpolation interpolation, Vector3fc position, Vector3fc size, Quaternionfc orientation) {
            if (!this.timelines.containsKey(boneId)) {
                this.timelines.put(boneId, new ArrayList(2));
            }
            this.timelines.get(boneId).add(new Keyframe(time, interpolation, new Keyframe.KeyframeTransform(position, size, orientation)));
        }

        public KeyframedAnimation<?, ?> build() {
            Map<String, KeyframeTimeline> builtTimelines = new HashMap<>();
            for (Map.Entry<String, List<Keyframe>> timeline : this.timelines.entrySet()) {
                List<Keyframe> keyframeList = timeline.getValue();
                keyframeList.sort(Comparator.comparingDouble((v0) -> {
                    return v0.time();
                }));
                KeyframeTimeline builtTimeline = new KeyframeTimeline((Keyframe[]) keyframeList.toArray(new Keyframe[0]));
                builtTimelines.put(timeline.getKey(), builtTimeline);
            }
            return new KeyframedAnimation<>(builtTimelines, this.additive, this.looped);
        }
    }
}
