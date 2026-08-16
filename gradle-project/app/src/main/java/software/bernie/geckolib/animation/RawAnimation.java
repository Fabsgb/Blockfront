package software.bernie.geckolib.animation;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Objects;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/RawAnimation.class */
public final class RawAnimation {
    public static final StreamCodec<ByteBuf, RawAnimation> STREAM_CODEC = StreamCodec.composite(Stage.STREAM_CODEC.apply(ByteBufCodecs.list()), instance -> {
        return instance.animationList;
    }, RawAnimation::new);
    private final List<Stage> animationList;

    private RawAnimation() {
        this(new ObjectArrayList());
    }

    private RawAnimation(List<Stage> animationList) {
        this.animationList = animationList;
    }

    public static RawAnimation begin() {
        return new RawAnimation();
    }

    public RawAnimation thenPlay(String animationName) {
        return then(animationName, Animation.LoopType.DEFAULT);
    }

    public RawAnimation thenLoop(String animationName) {
        return then(animationName, Animation.LoopType.LOOP);
    }

    public RawAnimation thenWait(int ticks) {
        this.animationList.add(new Stage("internal.wait", Animation.LoopType.PLAY_ONCE, ticks));
        return this;
    }

    public RawAnimation thenPlayAndHold(String animation) {
        return then(animation, Animation.LoopType.HOLD_ON_LAST_FRAME);
    }

    public RawAnimation thenPlayXTimes(String animationName, int playCount) {
        int i = 0;
        while (i < playCount) {
            then(animationName, i == playCount - 1 ? Animation.LoopType.DEFAULT : Animation.LoopType.PLAY_ONCE);
            i++;
        }
        return this;
    }

    public RawAnimation then(String animationName, Animation.LoopType loopType) {
        this.animationList.add(new Stage(animationName, loopType));
        return this;
    }

    public List<Stage> getAnimationStages() {
        return this.animationList;
    }

    public static RawAnimation copyOf(RawAnimation other) {
        RawAnimation newInstance = begin();
        newInstance.animationList.addAll(other.animationList);
        return newInstance;
    }

    public int getStageCount() {
        return this.animationList.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && hashCode() == obj.hashCode();
    }

    public int hashCode() {
        return Objects.hash(this.animationList);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/animation/RawAnimation$Stage.class */
    public static final class Stage extends Record {
        private final String animationName;
        private final Animation.LoopType loopType;
        private final int additionalTicks;
        public static final StreamCodec<ByteBuf, Stage> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
            return v0.animationName();
        }, ByteBufCodecs.STRING_UTF8.map(Animation.LoopType::fromString, (v0) -> {
            return v0.getId();
        }), (v0) -> {
            return v0.loopType();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.additionalTicks();
        }, (v1, v2, v3) -> {
            return new Stage(v1, v2, v3);
        });
        static final String WAIT = "internal.wait";

        public Stage(String animationName, Animation.LoopType loopType, int additionalTicks) {
            this.animationName = animationName;
            this.loopType = loopType;
            this.additionalTicks = additionalTicks;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Stage.class), Stage.class, "animationName;loopType;additionalTicks", "FIELD:Lsoftware/bernie/geckolib/animation/RawAnimation$Stage;->animationName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/animation/RawAnimation$Stage;->loopType:Lsoftware/bernie/geckolib/animation/Animation$LoopType;", "FIELD:Lsoftware/bernie/geckolib/animation/RawAnimation$Stage;->additionalTicks:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        public String animationName() {
            return this.animationName;
        }

        public Animation.LoopType loopType() {
            return this.loopType;
        }

        public int additionalTicks() {
            return this.additionalTicks;
        }

        public Stage(String animationName, Animation.LoopType loopType) {
            this(animationName, loopType, 0);
        }

        @Override // java.lang.Record
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && hashCode() == obj.hashCode();
        }

        @Override // java.lang.Record
        public int hashCode() {
            return Objects.hash(this.animationName, this.loopType);
        }
    }
}
