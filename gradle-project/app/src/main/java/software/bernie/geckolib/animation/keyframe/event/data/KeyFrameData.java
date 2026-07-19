package software.bernie.geckolib.animation.keyframe.event.data;

import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/event/data/KeyFrameData.class */
public abstract class KeyFrameData {
    private final double startTick;

    public KeyFrameData(double startTick) {
        this.startTick = startTick;
    }

    public double getStartTick() {
        return this.startTick;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && hashCode() == obj.hashCode();
    }

    public int hashCode() {
        return Objects.hashCode(Double.valueOf(this.startTick));
    }
}
