package foundry.veil.api.util;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.minecraft.network.VarInt;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/EnumCodec.class */
public class EnumCodec<T extends Enum<?>> implements Codec<T> {
    private final String name;
    private final T[] values;
    private final String valid;
    private final Function<T, String> toString;
    private final boolean ordinal;
    private final StreamCodec<ByteBuf, T> streamCodec = StreamCodec.of((buf, value) -> {
        VarInt.write(buf, getIndex(value));
    }, buf2 -> {
        int i = VarInt.read(buf2);
        if (i < 0 || i >= this.values.length) {
            throw new DecoderException("Unknown " + this.name + " with index: " + i);
        }
        return this.values[i];
    });

    public /* bridge */ /* synthetic */ DataResult encode(Object obj, DynamicOps dynamicOps, Object obj2) {
        return encode((Enum) obj, (DynamicOps<Object>) dynamicOps, obj2);
    }

    private EnumCodec(String name, T[] values, Function<T, String> toString, boolean ordinal) {
        this.name = name;
        this.values = values;
        this.valid = (String) Arrays.stream(values).map(toString).collect(Collectors.joining(", "));
        this.toString = toString;
        this.ordinal = ordinal;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: io.netty.handler.codec.EncoderException */
    private int getIndex(T value) throws EncoderException {
        if (this.ordinal) {
            return value.ordinal();
        }
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] == value) {
                return i;
            }
        }
        throw new EncoderException("Invalid " + this.name + ": " + this.toString.apply(value));
    }

    public <T1> DataResult<Pair<T, T1>> decode(DynamicOps<T1> ops, T1 input) {
        if (ops.compressMaps()) {
            return ops.getNumberValue(input).flatMap(index -> {
                int i = index.intValue();
                if (i < 0 || i >= this.values.length) {
                    return DataResult.error(() -> {
                        return "Unknown " + this.name + " with index: " + i;
                    });
                }
                return DataResult.success(Pair.of(this.values[i], input));
            });
        }
        return ops.getStringValue(input).flatMap(valueName -> {
            for (T value : this.values) {
                if (this.toString.apply(value).equalsIgnoreCase(valueName)) {
                    return DataResult.success(Pair.of(value, input));
                }
            }
            return DataResult.error(() -> {
                return "Unknown " + this.name + ": " + valueName + ". Valid options: " + this.valid;
            });
        });
    }

    public <T1> DataResult<T1> encode(T input, DynamicOps<T1> ops, T1 prefix) {
        if (ops.compressMaps()) {
            return DataResult.success(ops.createInt(getIndex(input)));
        }
        return DataResult.success(ops.createString(this.toString.apply(input)));
    }

    public StreamCodec<ByteBuf, T> streamCodec() {
        return this.streamCodec;
    }

    public static <T extends Enum<?>> Builder<T> builder(String name) {
        return new Builder<>(name);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/util/EnumCodec$Builder.class */
    public static class Builder<T extends Enum<?>> {
        private static final Function<Enum<?>, String> LOWERCASE = e -> {
            return e.name().toLowerCase(Locale.ROOT);
        };
        private static final Function<Enum<?>, String> UPPERCASE = e -> {
            return e.name().toUpperCase(Locale.ROOT);
        };
        private final String name;
        private T[] values = null;
        private Function<T, String> toString = (Function<T, String>) LOWERCASE;

        private Builder(String str) {
            this.name = str;
        }

        public Builder<T> values(Class<T> clazz) {
            this.values = clazz.getEnumConstants();
            return this;
        }

        @SafeVarargs
        public final Builder<T> values(T... values) {
            this.values = values;
            return this;
        }

        public Builder<T> toStringFunction(Function<T, String> toString) {
            this.toString = (Function) Objects.requireNonNull(toString, "toString");
            return this;
        }

        public Builder<T> uppercase() {
            this.toString = (Function<T, String>) UPPERCASE;
            return this;
        }

        public Builder<T> lowercase() {
            this.toString = (Function<T, String>) LOWERCASE;
            return this;
        }

        public EnumCodec<T> build() {
            Class<?> clazz;
            Objects.requireNonNull(this.values, "Values must be specified");
            if (this.values.length == 0) {
                throw new IllegalArgumentException("At least 1 value must be specified");
            }
            if (Arrays.stream(this.values).distinct().count() != this.values.length) {
                throw new IllegalArgumentException("All values must be unique");
            }
            Class<?> superclass = this.values[0].getClass();
            while (true) {
                clazz = superclass;
                if (clazz.isEnum()) {
                    break;
                }
                superclass = clazz.getSuperclass();
            }
            Enum<?>[] enumValues = (Enum[]) clazz.getEnumConstants();
            return new EnumCodec<>(this.name, this.values, this.toString, enumValues.length == this.values.length);
        }
    }
}
