package software.bernie.geckolib.animation.keyframe.event.data;

import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/event/data/ParticleKeyframeData.class */
public class ParticleKeyframeData extends KeyFrameData {
    private final String effect;
    private final String locator;
    private final String script;

    public ParticleKeyframeData(double startTick, String effect, String locator, String script) {
        super(startTick);
        this.script = script;
        this.locator = locator;
        this.effect = effect;
    }

    public String getEffect() {
        return this.effect;
    }

    public String getLocator() {
        return this.locator;
    }

    public String script() {
        return this.script;
    }

    @Override // software.bernie.geckolib.animation.keyframe.event.data.KeyFrameData
    public int hashCode() {
        return Objects.hash(Double.valueOf(getStartTick()), this.effect, this.locator, this.script);
    }
}
