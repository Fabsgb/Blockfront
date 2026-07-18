package software.bernie.geckolib.animation.keyframe.event;

import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.keyframe.event.data.SoundKeyframeData;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/animation/keyframe/event/SoundKeyframeEvent.class */
public class SoundKeyframeEvent<T extends GeoAnimatable> extends KeyFrameEvent<T, SoundKeyframeData> {
    public SoundKeyframeEvent(T entity, double animationTick, AnimationController<T> controller, SoundKeyframeData keyFrameData) {
        super(entity, animationTick, controller, keyFrameData);
    }

    @Override // software.bernie.geckolib.animation.keyframe.event.KeyFrameEvent
    public SoundKeyframeData getKeyframeData() {
        return (SoundKeyframeData) super.getKeyframeData();
    }
}
