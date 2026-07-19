package foundry.veil.api.client.render.post.uniform;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.render.post.uniform.UniformValue;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/post/uniform/FloatUniform.class */
public final class FloatUniform extends Record implements UniformValue {
    private final float[] values;
    public static final MapCodec<FloatUniform> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.FLOAT.listOf(1, 4).xmap(floats -> {
            float[] values = new float[floats.size()];
            for (int i = 0; i < floats.size(); i++) {
                values[i] = ((Float) floats.get(i)).floatValue();
            }
            return values;
        }, values -> {
            List<Float> floats2 = new ArrayList<>(values.length);
            for (float value : values) {
                floats2.add(Float.valueOf(value));
            }
            return floats2;
        }).fieldOf("value").forGetter((v0) -> {
            return v0.values();
        })).apply(instance, FloatUniform::new);
    });

    public FloatUniform(float[] values) {
        this.values = values;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FloatUniform.class), FloatUniform.class, "values", "FIELD:Lfoundry/veil/api/client/render/post/uniform/FloatUniform;->values:[F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FloatUniform.class), FloatUniform.class, "values", "FIELD:Lfoundry/veil/api/client/render/post/uniform/FloatUniform;->values:[F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FloatUniform.class, Object.class), FloatUniform.class, "values", "FIELD:Lfoundry/veil/api/client/render/post/uniform/FloatUniform;->values:[F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public float[] values() {
        return this.values;
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public void apply(ShaderUniform uniform) {
        uniform.setVector(this.values);
    }

    @Override // foundry.veil.api.client.render.post.uniform.UniformValue
    public UniformValue.Type type() {
        return UniformValue.Type.FLOAT;
    }
}
