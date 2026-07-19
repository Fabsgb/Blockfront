package foundry.veil.api.flare.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.util.Easing;
import it.unimi.dsi.fastutil.floats.FloatOpenHashSet;
import it.unimi.dsi.fastutil.floats.FloatSet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/FloatCurve.class */
public class FloatCurve {
    public static final FloatCurve ZERO = new FloatCurve(new KeyFrame[0]);
    public static final Codec<FloatCurve> CODEC = KeyFrame.CODEC.listOf().xmap(list -> {
        return new FloatCurve((KeyFrame[]) list.toArray(x$0 -> {
            return new KeyFrame[x$0];
        }));
    }, curve -> {
        return Arrays.asList(curve.keys);
    });
    private final KeyFrame[] keys;

    private FloatCurve(KeyFrame[] keys) {
        this.keys = keys;
    }

    public float evaluate(float time) {
        if (this.keys.length == 0) {
            return 0.0f;
        }
        KeyFrame first = this.keys[0];
        if (time < first.time) {
            return first.value;
        }
        KeyFrame last = this.keys[this.keys.length - 1];
        if (time > last.time) {
            return last.value;
        }
        for (int i = 1; i < this.keys.length; i++) {
            KeyFrame nextKey = this.keys[i];
            if (nextKey.time >= time) {
                KeyFrame previousKey = this.keys[i - 1];
                float inBetweenTime = Mth.inverseLerp(time, previousKey.time, nextKey.time);
                return Mth.lerp(previousKey.easing.ease(inBetweenTime), previousKey.value, nextKey.value);
            }
        }
        return time;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/FloatCurve$Builder.class */
    public static class Builder {
        private final List<KeyFrame> keys = new ArrayList();
        private final FloatSet times = new FloatOpenHashSet();

        public Builder addKey(KeyFrame key) {
            if (!this.times.add(key.time)) {
                throw new IllegalArgumentException("Float curve cannot contain multiple keys with the same time!");
            }
            this.keys.add(key);
            return this;
        }

        public FloatCurve build() {
            return new FloatCurve((KeyFrame[]) this.keys.stream().sorted().toArray(x$0 -> {
                return new KeyFrame[x$0];
            }));
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/FloatCurve$KeyFrame.class */
    public static final class KeyFrame extends Record implements Comparable<KeyFrame> {
        private final float time;
        private final float value;
        private final Easing easing;
        public static final Codec<KeyFrame> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.FLOAT.fieldOf("time").forGetter((v0) -> {
                return v0.time();
            }), Codec.FLOAT.fieldOf("value").forGetter((v0) -> {
                return v0.value();
            }), Easing.CODEC.fieldOf("easing").forGetter((v0) -> {
                return v0.easing();
            })).apply(instance, (v1, v2, v3) -> {
                return new KeyFrame(v1, v2, v3);
            });
        });

        public KeyFrame(float time, float value, Easing easing) {
            this.time = time;
            this.value = value;
            this.easing = easing;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, KeyFrame.class), KeyFrame.class, "time;value;easing", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->time:F", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->value:F", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->easing:Lfoundry/veil/api/client/util/Easing;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, KeyFrame.class), KeyFrame.class, "time;value;easing", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->time:F", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->value:F", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->easing:Lfoundry/veil/api/client/util/Easing;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, KeyFrame.class, Object.class), KeyFrame.class, "time;value;easing", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->time:F", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->value:F", "FIELD:Lfoundry/veil/api/flare/data/FloatCurve$KeyFrame;->easing:Lfoundry/veil/api/client/util/Easing;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public float time() {
            return this.time;
        }

        public float value() {
            return this.value;
        }

        public Easing easing() {
            return this.easing;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull KeyFrame other) {
            return Float.compare(this.time, other.time);
        }
    }
}
