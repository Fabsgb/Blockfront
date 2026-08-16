package foundry.veil.impl.client.render.shader.uniform;

import foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/uniform/EmptyShaderUniformAccess.class */
@ApiStatus.Internal
public enum EmptyShaderUniformAccess implements ShaderUniformAccess {
    INSTANCE;

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public boolean isValid() {
        return false;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloat(float value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z, float w) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(Vector2fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(Vector3fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(Vector4fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float[] values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInt(int value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z, int w) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(Vector2ic value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(Vector3ic value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(Vector4ic value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int[] values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDouble(double value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z, double w) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(Vector2dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(Vector3dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(Vector4dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double[] values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLong(long value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z, long w) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long[] values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloats(float... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector2fc... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector3fc... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector4fc... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInts(int... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector2ic... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector3ic... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector4ic... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDoubles(double... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector2dc... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector3dc... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector4dc... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLongs(long... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandle(long value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandles(long... values) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3fc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3fc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3dc value) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2dc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3dc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4dc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2dc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2dc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3dc value, boolean transpose) {
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3dc value, boolean transpose) {
    }
}
