package foundry.veil.api.client.render.post.uniform;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/uniform/Matrix3Uniform.class */
public final class Matrix3Uniform extends Record implements UniformValue {
    private final Matrix3fc value;
    public static final MapCodec<Matrix3Uniform> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.listOf(9, 9).xmap(floats -> {
            float[] values = new float[floats.size()];
            for (int i = 0; i < floats.size(); i++) {
                values[i] = ((Float) floats.get(i)).floatValue();
            }
            return new Matrix3f().set(values);
        }, matrix -> {
            return List.of(Float.valueOf(matrix.m00()), Float.valueOf(matrix.m01()), Float.valueOf(matrix.m02()), Float.valueOf(matrix.m10()), Float.valueOf(matrix.m11()), Float.valueOf(matrix.m12()), Float.valueOf(matrix.m20()), Float.valueOf(matrix.m21()), Float.valueOf(matrix.m22()));
        }).fieldOf("values").forGetter((v0) -> {
            return v0.value();
        })).apply(instance, Matrix3Uniform::new);
    });

    public Matrix3Uniform(Matrix3fc value) {
        this.value = value;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Matrix3Uniform.class), Matrix3Uniform.class, "value", "FIELD:Lfoundry/veil/api/client/render/post/uniform/Matrix3Uniform;->value:Lorg/joml/Matrix3fc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Matrix3Uniform.class), Matrix3Uniform.class, "value", "FIELD:Lfoundry/veil/api/client/render/post/uniform/Matrix3Uniform;->value:Lorg/joml/Matrix3fc;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Matrix3Uniform.class, Object.class), Matrix3Uniform.class, "value", "FIELD:Lfoundry/veil/api/client/render/post/uniform/Matrix3Uniform;->value:Lorg/joml/Matrix3fc;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Matrix3fc value() {
        return this.value;
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public void apply(ShaderUniform uniform) {
        uniform.setMatrix(this.value);
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public UniformValue.Type type() {
        return UniformValue.Type.MAT3;
    }
}
