package foundry.veil.api.client.render.shader.uniform;

import foundry.veil.impl.client.render.shader.uniform.CompositeShaderUniformAccess;
import foundry.veil.impl.client.render.shader.uniform.EmptyShaderUniformAccess;
import foundry.veil.impl.client.render.shader.uniform.WrapperUniformAccess;
import java.util.function.Supplier;
import org.joml.Matrix2dc;
import org.joml.Matrix2fc;
import org.joml.Matrix3dc;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2dc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4dc;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3fc;
import org.joml.Vector2dc;
import org.joml.Vector2fc;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3fc;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4fc;
import org.joml.Vector4ic;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/uniform/ShaderUniformAccess.class */
public interface ShaderUniformAccess {
    public static final ShaderUniformAccess EMPTY = EmptyShaderUniformAccess.INSTANCE;

    boolean isValid();

    void setFloat(float f);

    void setVector(float f, float f2);

    void setVector(float f, float f2, float f3);

    void setVector(float f, float f2, float f3, float f4);

    void setInt(int i);

    void setVectorI(int i, int i2);

    void setVectorI(int i, int i2, int i3);

    void setVectorI(int i, int i2, int i3, int i4);

    void setDouble(double d);

    void setVector64(double d, double d2);

    void setVector64(double d, double d2, double d3);

    void setVector64(double d, double d2, double d3, double d4);

    void setLong(long j);

    void setVectorI64(long j, long j2);

    void setVectorI64(long j, long j2, long j3);

    void setVectorI64(long j, long j2, long j3, long j4);

    void setFloats(float... fArr);

    void setVectors(Vector2fc... vector2fcArr);

    void setVectors(Vector3fc... vector3fcArr);

    void setVectors(Vector4fc... vector4fcArr);

    void setInts(int... iArr);

    void setIVectors(Vector2ic... vector2icArr);

    void setIVectors(Vector3ic... vector3icArr);

    void setIVectors(Vector4ic... vector4icArr);

    void setDoubles(double... dArr);

    void set64Vectors(Vector2dc... vector2dcArr);

    void set64Vectors(Vector3dc... vector3dcArr);

    void set64Vectors(Vector4dc... vector4dcArr);

    void setLongs(long... jArr);

    void setHandle(long j);

    void setHandles(long... jArr);

    void setMatrix(Matrix2fc matrix2fc, boolean z);

    void setMatrix(Matrix3fc matrix3fc, boolean z);

    void setMatrix(Matrix4fc matrix4fc, boolean z);

    void setMatrix2x3(Matrix3x2fc matrix3x2fc, boolean z);

    void setMatrix3x2(Matrix3x2fc matrix3x2fc, boolean z);

    void setMatrix3x4(Matrix4x3fc matrix4x3fc, boolean z);

    void setMatrix4x3(Matrix4x3fc matrix4x3fc, boolean z);

    void setMatrix(Matrix2dc matrix2dc, boolean z);

    void setMatrix(Matrix3dc matrix3dc, boolean z);

    void setMatrix(Matrix4dc matrix4dc, boolean z);

    void setMatrix2x3(Matrix3x2dc matrix3x2dc, boolean z);

    void setMatrix3x2(Matrix3x2dc matrix3x2dc, boolean z);

    void setMatrix3x4(Matrix4x3dc matrix4x3dc, boolean z);

    void setMatrix4x3(Matrix4x3dc matrix4x3dc, boolean z);

    /* JADX INFO: renamed from: of */
    static ShaderUniformAccess m8340of(ShaderUniformAccess... accesses) {
        if (accesses.length == 0) {
            return EMPTY;
        }
        if (accesses.length == 1) {
            return accesses[0];
        }
        return new CompositeShaderUniformAccess(accesses);
    }

    static ShaderUniformAccess wrapped(Supplier<ShaderUniformAccess> getter) {
        return new WrapperUniformAccess(getter);
    }

    default void setVector(Vector2fc value) {
        setVector(value.x(), value.y());
    }

    default void setVector(Vector3fc value) {
        setVector(value.x(), value.y(), value.z());
    }

    default void setVector(Vector4fc value) {
        setVector(value.x(), value.y(), value.z(), value.w());
    }

    default void setVector(float[] values) {
        switch (Math.min(4, values.length)) {
            case 1:
                setFloat(values[0]);
                return;
            case 2:
                setVector(values[0], values[1]);
                return;
            case 3:
                setVector(values[0], values[1], values[2]);
                return;
            case 4:
                setVector(values[0], values[1], values[2], values[3]);
                return;
            default:
                throw new UnsupportedOperationException("At least 1 value must be specified");
        }
    }

    default void setVectorI(Vector2ic value) {
        setVectorI(value.x(), value.y());
    }

    default void setVectorI(Vector3ic value) {
        setVectorI(value.x(), value.y(), value.z());
    }

    default void setVectorI(Vector4ic value) {
        setVectorI(value.x(), value.y(), value.z(), value.w());
    }

    default void setVectorI(int[] values) {
        switch (Math.min(4, values.length)) {
            case 1:
                setInt(values[0]);
                return;
            case 2:
                setVectorI(values[0], values[1]);
                return;
            case 3:
                setVectorI(values[0], values[1], values[2]);
                return;
            case 4:
                setVectorI(values[0], values[1], values[2], values[3]);
                return;
            default:
                throw new UnsupportedOperationException("At least 1 value must be specified");
        }
    }

    default void setVector64(Vector2dc value) {
        setVector64(value.x(), value.y());
    }

    default void setVector64(Vector3dc value) {
        setVector64(value.x(), value.y(), value.z());
    }

    default void setVector64(Vector4dc value) {
        setVector64(value.x(), value.y(), value.z(), value.w());
    }

    default void setVector64(double[] values) {
        switch (Math.min(4, values.length)) {
            case 1:
                setDouble(values[0]);
                return;
            case 2:
                setVector64(values[0], values[1]);
                return;
            case 3:
                setVector64(values[0], values[1], values[2]);
                return;
            case 4:
                setVector64(values[0], values[1], values[2], values[3]);
                return;
            default:
                throw new UnsupportedOperationException("At least 1 value must be specified");
        }
    }

    default void setVectorI64(long[] values) {
        switch (Math.min(4, values.length)) {
            case 1:
                setLong(values[0]);
                return;
            case 2:
                setVectorI64(values[0], values[1]);
                return;
            case 3:
                setVectorI64(values[0], values[1], values[2]);
                return;
            case 4:
                setVectorI64(values[0], values[1], values[2], values[3]);
                return;
            default:
                throw new UnsupportedOperationException("At least 1 value must be specified");
        }
    }

    default void setMatrix(Matrix2fc value) {
        setMatrix(value, false);
    }

    default void setMatrix(Matrix3fc value) {
        setMatrix(value, false);
    }

    default void setMatrix(Matrix4fc value) {
        setMatrix(value, false);
    }

    default void setMatrix2x3(Matrix3x2fc value) {
        setMatrix2x3(value, false);
    }

    default void setMatrix3x2(Matrix3x2fc value) {
        setMatrix3x2(value, false);
    }

    default void setMatrix3x4(Matrix4x3fc value) {
        setMatrix3x4(value, false);
    }

    default void setMatrix4x3(Matrix4x3fc value) {
        setMatrix4x3(value, false);
    }

    default void setMatrix(Matrix2dc value) {
        setMatrix(value, false);
    }

    default void setMatrix(Matrix3dc value) {
        setMatrix(value, false);
    }

    default void setMatrix(Matrix4dc value) {
        setMatrix(value, false);
    }

    default void setMatrix2x3(Matrix3x2dc value) {
        setMatrix2x3(value, false);
    }

    default void setMatrix3x2(Matrix3x2dc value) {
        setMatrix3x2(value, false);
    }

    default void setMatrix3x4(Matrix4x3dc value) {
        setMatrix3x4(value, false);
    }

    default void setMatrix4x3(Matrix4x3dc value) {
        setMatrix4x3(value, false);
    }
}
