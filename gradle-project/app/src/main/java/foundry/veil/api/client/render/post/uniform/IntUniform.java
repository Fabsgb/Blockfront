package foundry.veil.api.client.render.post.uniform;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/post/uniform/IntUniform.class */
public final class IntUniform extends Record implements UniformValue {
    private final int[] values;
    public static final MapCodec<IntUniform> CODEC = Codec.INT.listOf(1, 4).xmap(floats -> {
        return new IntUniform(floats.stream().mapToInt((v0) -> {
            return v0.intValue();
        }).toArray());
    }, uniform -> {
        return Arrays.stream(uniform.values).boxed().toList();
    }).fieldOf("value");

    public IntUniform(int[] values) {
        this.values = values;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, IntUniform.class), IntUniform.class, "values", "FIELD:Lfoundry/veil/api/client/render/post/uniform/IntUniform;->values:[I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, IntUniform.class), IntUniform.class, "values", "FIELD:Lfoundry/veil/api/client/render/post/uniform/IntUniform;->values:[I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, IntUniform.class, Object.class), IntUniform.class, "values", "FIELD:Lfoundry/veil/api/client/render/post/uniform/IntUniform;->values:[I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int[] values() {
        return this.values;
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public void apply(ShaderUniform uniform) {
        uniform.setVectorI(this.values);
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public UniformValue.Type type() {
        return UniformValue.Type.INT;
    }
}
