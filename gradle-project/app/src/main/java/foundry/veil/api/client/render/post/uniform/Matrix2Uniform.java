package foundry.veil.api.client.render.post.uniform;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.post.uniform.UniformValue;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.joml.Matrix2f;
import org.joml.Matrix2fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/uniform/Matrix2Uniform.class */
public final class Matrix2Uniform extends Record implements UniformValue {
    private final Matrix2fc value;
    public static final MapCodec<Matrix2Uniform> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.listOf(4, 4).xmap(floats -> {
            float[] values = new float[floats.size()];
            for (int i = 0; i < floats.size(); i++) {
                values[i] = ((Float) floats.get(i)).floatValue();
            }
            return new Matrix2f().set(values);
        }, matrix -> {
            return List.of(Float.valueOf(matrix.m00()), Float.valueOf(matrix.m01()), Float.valueOf(matrix.m10()), Float.valueOf(matrix.m11()));
        }).fieldOf("values").forGetter((v0) -> {
            return v0.value();
        })).apply(instance, Matrix2Uniform::new);
    });

    public Matrix2Uniform(Matrix2fc value) {
        this.value = value;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Matrix2Uniform.class), Matrix2Uniform.class, "value", "FIELD:Lfoundry/veil/api/client/render/post/uniform/Matrix2Uniform;->value:Lorg/joml/Matrix2fc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Matrix2Uniform.class), Matrix2Uniform.class, "value", "FIELD:Lfoundry/veil/api/client/render/post/uniform/Matrix2Uniform;->value:Lorg/joml/Matrix2fc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Matrix2Uniform.class, Object.class), Matrix2Uniform.class, "value", "FIELD:Lfoundry/veil/api/client/render/post/uniform/Matrix2Uniform;->value:Lorg/joml/Matrix2fc;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Matrix2fc value() {
        return this.value;
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public void apply(ShaderUniform uniform) {
        uniform.setMatrix(this.value);
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public UniformValue.Type type() {
        return UniformValue.Type.MAT2;
    }
}
