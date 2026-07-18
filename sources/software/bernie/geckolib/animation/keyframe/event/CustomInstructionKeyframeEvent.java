package software.bernie.geckolib.animation.keyframe.event;

import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.keyframe.event.data.CustomInstructionKeyframeData;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/event/CustomInstructionKeyframeEvent.class */
public class CustomInstructionKeyframeEvent<T extends GeoAnimatable> extends KeyFrameEvent<T, CustomInstructionKeyframeData> {
    public CustomInstructionKeyframeEvent(T entity, double animationTick, AnimationController<T> controller, CustomInstructionKeyframeData customInstructionKeyframeData) {
        super(entity, animationTick, controller, customInstructionKeyframeData);
    }

    @Override // software.bernie.geckolib.animation.keyframe.event.KeyFrameEvent
    public CustomInstructionKeyframeData getKeyframeData() {
        return (CustomInstructionKeyframeData) super.getKeyframeData();
    }
}
