package software.bernie.geckolib.animation.keyframe.event.data;

import java.util.Objects;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/keyframe/event/data/CustomInstructionKeyframeData.class */
public class CustomInstructionKeyframeData extends KeyFrameData {
    private final String instructions;

    public CustomInstructionKeyframeData(double startTick, String instructions) {
        super(startTick);
        this.instructions = instructions;
    }

    public String getInstructions() {
        return this.instructions;
    }

    @Override // software.bernie.geckolib.animation.keyframe.event.data.KeyFrameData
    public int hashCode() {
        return Objects.hash(Double.valueOf(getStartTick()), this.instructions);
    }
}
