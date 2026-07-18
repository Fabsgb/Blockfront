package foundry.veil.api.flare.data.model;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Vector4f;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/model/ShellFaceUV.class */
public final class ShellFaceUV extends Record {
    private final Vector4fc uvs;
    private final int rotation;
    public static final Codec<ShellFaceUV> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(CodecUtil.VECTOR4FC_CODEC.fieldOf("uv").forGetter((v0) -> {
            return v0.uvs();
        }), Codec.INT.optionalFieldOf("rotation", 0).forGetter((v0) -> {
            return v0.rotation();
        })).apply(instance, (v1, v2) -> {
            return new ShellFaceUV(v1, v2);
        });
    });

    public ShellFaceUV(Vector4fc uvs, int rotation) {
        this.uvs = uvs;
        this.rotation = rotation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShellFaceUV.class), ShellFaceUV.class, "uvs;rotation", "FIELD:Lfoundry/veil/api/flare/data/model/ShellFaceUV;->uvs:Lorg/joml/Vector4fc;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellFaceUV;->rotation:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShellFaceUV.class), ShellFaceUV.class, "uvs;rotation", "FIELD:Lfoundry/veil/api/flare/data/model/ShellFaceUV;->uvs:Lorg/joml/Vector4fc;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellFaceUV;->rotation:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShellFaceUV.class, Object.class), ShellFaceUV.class, "uvs;rotation", "FIELD:Lfoundry/veil/api/flare/data/model/ShellFaceUV;->uvs:Lorg/joml/Vector4fc;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellFaceUV;->rotation:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Vector4fc uvs() {
        return this.uvs;
    }

    public int rotation() {
        return this.rotation;
    }

    public ShellFaceUV(float u0, float v0, float u1, float v1, int rotation) {
        this(new Vector4f(u0, v0, u1, v1), rotation);
    }

    public float getU(int index) {
        int i = getShiftedIndex(index);
        return this.uvs.get((i == 0 || i == 1) ? 0 : 2);
    }

    public float getV(int index) {
        int i = getShiftedIndex(index);
        return this.uvs.get((i == 0 || i == 3) ? 1 : 3);
    }

    private int getShiftedIndex(int index) {
        return (index + (this.rotation / 90)) % 4;
    }
}
