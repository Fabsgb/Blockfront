package foundry.veil.api.client.render.post.uniform;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/uniform/UniformValue.class */
public interface UniformValue {
    public static final Codec<UniformValue> CODEC = Type.CODEC.dispatch((v0) -> {
        return v0.type();
    }, (v0) -> {
        return v0.getCodec();
    });

    void apply(ShaderUniform shaderUniform);

    Type type();

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/uniform/UniformValue$Type.class */
    public enum Type {
        FLOAT(FloatUniform.CODEC),
        INT(IntUniform.CODEC),
        MAT2(Matrix2Uniform.CODEC),
        MAT3(Matrix3Uniform.CODEC),
        MAT4(Matrix4Uniform.CODEC);

        private static final Type[] VALUES = values();
        private static final String VALID_OPTIONS = (String) Arrays.stream(VALUES).map(type -> {
            return type.name().toLowerCase(Locale.ROOT);
        }).collect(Collectors.joining(", "));
        public static final Codec<Type> CODEC = Codec.STRING.flatXmap(name -> {
            for (Type type : VALUES) {
                if (type.name().equalsIgnoreCase(name)) {
                    return DataResult.success(type);
                }
            }
            return DataResult.error(() -> {
                return "Unknown uniform type: " + name + ". Valid types: " + VALID_OPTIONS;
            });
        }, type -> {
            return DataResult.success(type.name().toLowerCase(Locale.ROOT));
        });
        private final MapCodec<? extends UniformValue> codec;

        Type(MapCodec mapCodec) {
            this.codec = mapCodec;
        }

        public MapCodec<? extends UniformValue> getCodec() {
            return this.codec;
        }
    }
}
