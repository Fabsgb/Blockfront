package foundry.veil.impl.client.render.shader.uniform;

import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/uniform/WrapperUniformAccess.class */
@ApiStatus.Internal
public final class WrapperUniformAccess extends Record implements ShaderUniformAccess {
    private final Supplier<ShaderUniformAccess> getter;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, WrapperUniformAccess.class), WrapperUniformAccess.class, "getter", "FIELD:Lfoundry/veil/impl/client/render/shader/uniform/WrapperUniformAccess;->getter:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, WrapperUniformAccess.class), WrapperUniformAccess.class, "getter", "FIELD:Lfoundry/veil/impl/client/render/shader/uniform/WrapperUniformAccess;->getter:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, WrapperUniformAccess.class, Object.class), WrapperUniformAccess.class, "getter", "FIELD:Lfoundry/veil/impl/client/render/shader/uniform/WrapperUniformAccess;->getter:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Supplier<ShaderUniformAccess> getter() {
        return this.getter;
    }

    public WrapperUniformAccess(Supplier<ShaderUniformAccess> getter) {
        this.getter = getter;
    }

    private ShaderUniformAccess getAccess() {
        ShaderUniformAccess access = this.getter.get();
        return access != null ? access : ShaderUniformAccess.EMPTY;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public boolean isValid() {
        return getAccess().isValid();
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloat(float value) {
        getAccess().setFloat(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y) {
        getAccess().setVector(x, y);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z) {
        getAccess().setVector(x, y, z);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z, float w) {
        getAccess().setVector(x, y, z, w);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(Vector2fc value) {
        getAccess().setVector(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(Vector3fc value) {
        getAccess().setVector(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(Vector4fc value) {
        getAccess().setVector(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float[] values) {
        getAccess().setVector(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInt(int value) {
        getAccess().setInt(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y) {
        getAccess().setVectorI(x, y);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z) {
        getAccess().setVectorI(x, y, z);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z, int w) {
        getAccess().setVectorI(x, y, z, w);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(Vector2ic value) {
        getAccess().setVectorI(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(Vector3ic value) {
        getAccess().setVectorI(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(Vector4ic value) {
        getAccess().setVectorI(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int[] values) {
        getAccess().setVectorI(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDouble(double value) {
        getAccess().setDouble(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y) {
        getAccess().setVector64(x, y);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z) {
        getAccess().setVector64(x, y, z);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z, double w) {
        getAccess().setVector64(x, y, z, w);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(Vector2dc value) {
        super.setVector64(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(Vector3dc value) {
        getAccess().setVector64(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(Vector4dc value) {
        getAccess().setVector64(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double[] values) {
        getAccess().setVector64(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLong(long value) {
        getAccess().setLong(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y) {
        getAccess().setVectorI64(x, y);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z) {
        getAccess().setVectorI64(x, y, z);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z, long w) {
        getAccess().setVectorI64(x, y, z, w);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long[] values) {
        getAccess().setVectorI64(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloats(float... values) {
        getAccess().setFloats(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector2fc... values) {
        getAccess().setVectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector3fc... values) {
        getAccess().setVectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector4fc... values) {
        getAccess().setVectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInts(int... values) {
        getAccess().setInts(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector2ic... values) {
        getAccess().setIVectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector3ic... values) {
        getAccess().setIVectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector4ic... values) {
        getAccess().setIVectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDoubles(double... values) {
        getAccess().setDoubles(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector2dc... values) {
        getAccess().set64Vectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector3dc... values) {
        getAccess().set64Vectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector4dc... values) {
        getAccess().set64Vectors(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLongs(long... values) {
        getAccess().setLongs(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandle(long value) {
        getAccess().setHandle(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandles(long... values) {
        getAccess().setHandles(values);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2fc value) {
        getAccess().setMatrix(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3fc value) {
        getAccess().setMatrix(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4fc value) {
        getAccess().setMatrix(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2fc value) {
        getAccess().setMatrix2x3(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2fc value) {
        getAccess().setMatrix3x2(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3fc value) {
        getAccess().setMatrix3x4(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3fc value) {
        getAccess().setMatrix4x3(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2fc value, boolean transpose) {
        getAccess().setMatrix(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3fc value, boolean transpose) {
        getAccess().setMatrix(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4fc value, boolean transpose) {
        getAccess().setMatrix(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2fc value, boolean transpose) {
        getAccess().setMatrix2x3(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2fc value, boolean transpose) {
        getAccess().setMatrix3x2(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3fc value, boolean transpose) {
        getAccess().setMatrix3x4(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3fc value, boolean transpose) {
        getAccess().setMatrix4x3(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2dc value) {
        getAccess().setMatrix(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3dc value) {
        getAccess().setMatrix(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4dc value) {
        getAccess().setMatrix(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2dc value) {
        getAccess().setMatrix2x3(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2dc value) {
        getAccess().setMatrix3x2(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3dc value) {
        getAccess().setMatrix3x4(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3dc value) {
        getAccess().setMatrix4x3(value);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2dc value, boolean transpose) {
        getAccess().setMatrix(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3dc value, boolean transpose) {
        getAccess().setMatrix(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4dc value, boolean transpose) {
        getAccess().setMatrix(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2dc value, boolean transpose) {
        getAccess().setMatrix2x3(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2dc value, boolean transpose) {
        getAccess().setMatrix3x2(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3dc value, boolean transpose) {
        getAccess().setMatrix3x4(value, transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3dc value, boolean transpose) {
        getAccess().setMatrix4x3(value, transpose);
    }
}
