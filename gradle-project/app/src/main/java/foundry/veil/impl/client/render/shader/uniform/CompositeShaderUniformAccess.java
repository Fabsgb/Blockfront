package foundry.veil.impl.client.render.shader.uniform;

import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/uniform/CompositeShaderUniformAccess.class */
@ApiStatus.Internal
public final class CompositeShaderUniformAccess extends Record implements ShaderUniformAccess {
    private final ShaderUniformAccess[] accesses;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, CompositeShaderUniformAccess.class), CompositeShaderUniformAccess.class, "accesses", "FIELD:Lfoundry/veil/impl/client/render/shader/uniform/CompositeShaderUniformAccess;->accesses:[Lfoundry/veil/api/client/render/shader/uniform/ShaderUniformAccess;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CompositeShaderUniformAccess.class), CompositeShaderUniformAccess.class, "accesses", "FIELD:Lfoundry/veil/impl/client/render/shader/uniform/CompositeShaderUniformAccess;->accesses:[Lfoundry/veil/api/client/render/shader/uniform/ShaderUniformAccess;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CompositeShaderUniformAccess.class, Object.class), CompositeShaderUniformAccess.class, "accesses", "FIELD:Lfoundry/veil/impl/client/render/shader/uniform/CompositeShaderUniformAccess;->accesses:[Lfoundry/veil/api/client/render/shader/uniform/ShaderUniformAccess;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public ShaderUniformAccess[] accesses() {
        return this.accesses;
    }

    public CompositeShaderUniformAccess(ShaderUniformAccess... accesses) {
        this.accesses = accesses;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public boolean isValid() {
        for (ShaderUniformAccess access : this.accesses) {
            if (access.isValid()) {
                return true;
            }
        }
        return false;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloat(float value) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setFloat(value);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVector(x, y);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVector(x, y, z);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z, float w) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVector(x, y, z, w);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInt(int value) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setInt(value);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectorI(x, y);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectorI(x, y, z);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z, int w) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectorI(x, y, z, w);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDouble(double value) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setDouble(value);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVector64(x, y);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVector64(x, y, z);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z, double w) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVector64(x, y, z, w);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLong(long value) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setLong(value);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectorI64(x, y);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectorI64(x, y, z);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z, long w) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectorI64(x, y, z, w);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloats(float... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setFloats(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector2fc... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector3fc... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector4fc... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setVectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInts(int... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setInts(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector2ic... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setIVectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector3ic... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setIVectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector4ic... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setIVectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDoubles(double... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setDoubles(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector2dc... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.set64Vectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector3dc... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.set64Vectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector4dc... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.set64Vectors(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLongs(long... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setLongs(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandle(long value) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setHandle(value);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandles(long... values) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setHandles(values);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix2x3(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix3x2(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix3x4(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3fc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix4x3(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix2x3(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix3x2(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix3x4(value, transpose);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3dc value, boolean transpose) {
        for (ShaderUniformAccess access : this.accesses) {
            access.setMatrix4x3(value, transpose);
        }
    }
}
