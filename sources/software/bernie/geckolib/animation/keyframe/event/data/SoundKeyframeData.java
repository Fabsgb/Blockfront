package software.bernie.geckolib.animation.keyframe.event.data;

import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/keyframe/event/data/SoundKeyframeData.class */
public class SoundKeyframeData extends KeyFrameData {
    private final String sound;

    public SoundKeyframeData(Double startTick, String sound) {
        super(startTick.doubleValue());
        this.sound = sound;
    }

    public String getSound() {
        return this.sound;
    }

    @Override // software.bernie.geckolib.animation.keyframe.event.data.KeyFrameData
    public int hashCode() {
        return Objects.hash(Double.valueOf(getStartTick()), this.sound);
    }
}
