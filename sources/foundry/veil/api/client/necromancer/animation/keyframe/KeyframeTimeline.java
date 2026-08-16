package foundry.veil.api.client.necromancer.animation.keyframe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/animation/keyframe/KeyframeTimeline.class */
public final class KeyframeTimeline extends Record {
    private final Keyframe[] keyframes;

    public KeyframeTimeline(Keyframe[] keyframes) {
        this.keyframes = keyframes;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, KeyframeTimeline.class), KeyframeTimeline.class, "keyframes", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/KeyframeTimeline;->keyframes:[Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, KeyframeTimeline.class), KeyframeTimeline.class, "keyframes", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/KeyframeTimeline;->keyframes:[Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, KeyframeTimeline.class, Object.class), KeyframeTimeline.class, "keyframes", "FIELD:Lfoundry/veil/api/client/necromancer/animation/keyframe/KeyframeTimeline;->keyframes:[Lfoundry/veil/api/client/necromancer/animation/keyframe/Keyframe;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Keyframe[] keyframes() {
        return this.keyframes;
    }

    protected float getAdjacentKeyframes(float time, boolean looped, Keyframe[] listToPopulate) {
        int currentIndex = findKeyframeIndex(time, looped);
        listToPopulate[1] = this.keyframes[currentIndex];
        int previousIndex = currentIndex - 1;
        listToPopulate[0] = this.keyframes[looped ? previousIndex % this.keyframes.length : Math.max(previousIndex, 0)];
        int nextIndex = currentIndex + 1;
        listToPopulate[2] = this.keyframes[looped ? nextIndex % this.keyframes.length : Math.max(nextIndex, this.keyframes.length - 1)];
        int nextNextIndex = currentIndex + 2;
        listToPopulate[3] = this.keyframes[looped ? nextNextIndex % this.keyframes.length : Math.max(nextNextIndex, this.keyframes.length - 1)];
        return (time - listToPopulate[1].time()) / (listToPopulate[2].time() - listToPopulate[1].time());
    }

    private int findKeyframeIndex(float time, boolean looped) {
        if (this.keyframes.length == 1) {
            return 0;
        }
        int low = 0;
        int high = this.keyframes.length - 1;
        if (this.keyframes[0].time() > time) {
            if (looped) {
                return high;
            }
            return 0;
        }
        if (this.keyframes[high].time() < time) {
            return high;
        }
        while (low <= high) {
            int mid = (low + high) >>> 1;
            float t1 = this.keyframes[mid].time();
            float t2 = this.keyframes[mid + 1].time();
            if (time > t1 && time < t2) {
                return mid;
            }
            if (time > t1) {
                low = mid + 1;
            } else if (time < t1) {
                high = mid - 1;
            }
        }
        throw new IllegalStateException("Cannot find valid keyframe with time " + time + " in keyframe list " + Arrays.toString(this.keyframes));
    }
}
