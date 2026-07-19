package foundry.veil.api.flare.data.model;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.util.CodecUtil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Direction;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/flare/data/model/ShellElementRotation.class */
public final class ShellElementRotation extends Record {
    private final Vector3fc origin;
    private final Direction.Axis axis;
    private final float angle;
    public static final Codec<ShellElementRotation> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(CodecUtil.VECTOR3FC_CODEC.fieldOf("origin").forGetter((v0) -> {
            return v0.origin();
        }), Direction.Axis.CODEC.fieldOf("axis").forGetter((v0) -> {
            return v0.axis();
        }), Codec.FLOAT.fieldOf("angle").forGetter((v0) -> {
            return v0.angle();
        })).apply(instance, (v1, v2, v3) -> {
            return new ShellElementRotation(v1, v2, v3);
        });
    });

    public ShellElementRotation(Vector3fc origin, Direction.Axis axis, float angle) {
        this.origin = origin;
        this.axis = axis;
        this.angle = angle;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ShellElementRotation.class), ShellElementRotation.class, "origin;axis;angle", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->origin:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->axis:Lnet/minecraft/core/Direction$Axis;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->angle:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ShellElementRotation.class), ShellElementRotation.class, "origin;axis;angle", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->origin:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->axis:Lnet/minecraft/core/Direction$Axis;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->angle:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ShellElementRotation.class, Object.class), ShellElementRotation.class, "origin;axis;angle", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->origin:Lorg/joml/Vector3fc;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->axis:Lnet/minecraft/core/Direction$Axis;", "FIELD:Lfoundry/veil/api/flare/data/model/ShellElementRotation;->angle:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Vector3fc origin() {
        return this.origin;
    }

    public Direction.Axis axis() {
        return this.axis;
    }

    public float angle() {
        return this.angle;
    }
}
