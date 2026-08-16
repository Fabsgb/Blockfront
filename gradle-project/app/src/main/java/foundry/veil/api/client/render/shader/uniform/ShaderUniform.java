package foundry.veil.api.client.render.shader.uniform;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderUniformCache;
import java.nio.ByteBuffer;
import net.minecraft.client.renderer.ShaderInstance;
import org.joml.Matrix2f;
import org.joml.Matrix3f;
import org.joml.Matrix3x2f;
import org.joml.Matrix4f;
import org.joml.Matrix4x3f;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.joml.Vector4i;
import org.lwjgl.opengl.ARBGPUShaderFP64;
import org.lwjgl.opengl.ARBGPUShaderInt64;
import org.lwjgl.opengl.ARBSeparateShaderObjects;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/uniform/ShaderUniform.class */
public interface ShaderUniform extends ShaderUniformAccess {
    void invalidateCache();

    String getName();

    int getLocation();

    Type getType();

    int getArrayLength();

    float getFloat();

    void getFloats(float[] fArr, int i, int i2);

    int getInt();

    void getInts(int[] iArr, int i, int i2);

    double getDouble();

    void getDoubles(double[] dArr, int i, int i2);

    long getLong();

    void getLongs(long[] jArr, int i, int i2);

    void getVector(CharSequence charSequence, Vector2f... vector2fArr);

    void getVector(CharSequence charSequence, Vector3f... vector3fArr);

    void getVector(CharSequence charSequence, Vector4f... vector4fArr);

    void getVectori(CharSequence charSequence, Vector2i... vector2iArr);

    void getVectori(CharSequence charSequence, Vector3i... vector3iArr);

    void getVectori(CharSequence charSequence, Vector4i... vector4iArr);

    void getMatrix(CharSequence charSequence, Matrix2f matrix2f);

    void getMatrix(CharSequence charSequence, Matrix3f matrix3f);

    void getMatrix(CharSequence charSequence, Matrix4f matrix4f);

    void getMatrix(CharSequence charSequence, Matrix3x2f matrix3x2f);

    void getMatrix(CharSequence charSequence, Matrix4x3f matrix4x3f);

    default float[] getFloats() {
        float[] values = new float[getArrayLength()];
        getFloats(values, 0, values.length);
        return values;
    }

    default void getFloats(float[] fill) {
        getFloats(fill, 0, fill.length);
    }

    default int[] getInts() {
        int[] values = new int[getArrayLength()];
        getInts(values, 0, values.length);
        return values;
    }

    default void getInts(int[] fill) {
        getInts(fill, 0, fill.length);
    }

    default double[] getDoubles() {
        double[] values = new double[getArrayLength()];
        getDoubles(values, 0, values.length);
        return values;
    }

    default void getDoubles(double[] fill) {
        getDoubles(fill, 0, fill.length);
    }

    default long[] getLongs() {
        long[] values = new long[getArrayLength()];
        getLongs(values, 0, values.length);
        return values;
    }

    default void getLongs(long[] fill) {
        getLongs(fill, 0, fill.length);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/uniform/ShaderUniform$Type.class */
    public enum Type {
        SAMPLER(0) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.1
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform1iv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform1iv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        FLOAT(4) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.2
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform1fv(program, location, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform1fv(location, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        FLOAT_VEC2(8) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.3
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform2fv(program, location, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform2fv(location, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        FLOAT_VEC3(12) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.4
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform3fv(program, location, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform3fv(location, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        FLOAT_VEC4(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.5
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform4fv(program, location, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform4fv(location, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        INT(4) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.6
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform1iv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform1iv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        INT_VEC2(8) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.7
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform2iv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform2iv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        INT_VEC3(12) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.8
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform3iv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform3iv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        INT_VEC4(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.9
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform4iv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform4iv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_INT(4) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.10
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform1uiv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform1uiv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_INT_VEC2(8) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.11
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform2uiv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform2uiv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_INT_VEC3(12) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.12
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform3uiv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform3uiv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_INT_VEC4(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.13
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform4uiv(program, location, buffer.asIntBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniform4uiv(location, buffer.asIntBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX2x2(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.14
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix2fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix2fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX3x3(36) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.15
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix3fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix3fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX4x4(64) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.16
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix4fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix4fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX2x3(24) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.17
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix2x3fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix2x3fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX3x2(24) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.18
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix3x2fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix3x2fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX2x4(32) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.19
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix2x4fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix2x4fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX4x2(32) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.20
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix4x2fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix4x2fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX3x4(48) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.21
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix3x4fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix3x4fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        MATRIX4x3(48) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.22
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix4x3fv(program, location, transpose, buffer.asFloatBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                GL30C.glUniformMatrix4x3fv(location, transpose, buffer.asFloatBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE(8) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.23
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform1dv(program, location, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniform1dv(location, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_VEC2(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.24
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform2dv(program, location, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniform2dv(location, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_VEC3(24) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.25
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform3dv(program, location, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniform3dv(location, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_VEC4(32) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.26
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniform4dv(program, location, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniform4dv(location, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        LONG(8) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.27
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform1i64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform1i64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        LONG_VEC2(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.28
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform2i64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform2i64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        LONG_VEC3(24) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.29
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform3i64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform3i64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        LONG_VEC4(32) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.30
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform4i64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform4i64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_LONG(8) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.31
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform1ui64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform1ui64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_LONG_VEC2(16) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.32
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform2ui64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform2ui64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_LONG_VEC3(24) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.33
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform3ui64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform3ui64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        UNSIGNED_LONG_VEC4(32) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.34
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void upload(int program, int location, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderInt64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Integers are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBGPUShaderInt64.glProgramUniform4ui64vARB(program, location, buffer.asLongBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderInt64.glUniform4ui64vARB(location, buffer.asLongBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX2x2(32) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.35
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix2dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix2dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX3x3(72) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.36
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix3dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix3dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX4x4(128) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.37
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix4dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix4dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX2x3(48) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.38
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix2x3dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix2x3dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX3x2(48) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.39
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix3x2dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix3x2dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX2x4(64) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.40
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix2x4dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix2x4dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX4x2(64) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.41
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix4x2dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix4x2dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX3x4(96) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.42
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix3x4dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix3x4dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        },
        DOUBLE_MATRIX4x3(96) { // from class: foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type.43
            @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform.Type
            public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
                if (!VeilRenderSystem.gpuShaderFloat64BitSupported()) {
                    throw new UnsupportedOperationException("64-Bit Floats are not supported");
                }
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBSeparateShaderObjects.glProgramUniformMatrix4x3dv(program, location, transpose, buffer.asDoubleBuffer());
                    return;
                }
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(program);
                }
                ARBGPUShaderFP64.glUniformMatrix4x3dv(location, transpose, buffer.asDoubleBuffer());
                if (program != ShaderInstance.lastProgramId) {
                    GL30C.glUseProgram(ShaderInstance.lastProgramId);
                }
            }
        };

        private final int bytes;

        Type(int bytes) {
            this.bytes = bytes;
        }

        public static Type byId(int type) {
            if (ShaderUniformCache.isSampler(type)) {
                return SAMPLER;
            }
            switch (type) {
                case 5124:
                    return INT;
                case 5125:
                    return UNSIGNED_INT;
                case 5126:
                    return FLOAT;
                case 5130:
                    return DOUBLE;
                case 5134:
                    return LONG;
                case 5135:
                    return UNSIGNED_LONG;
                case 35664:
                    return FLOAT_VEC2;
                case 35665:
                    return FLOAT_VEC3;
                case 35666:
                    return FLOAT_VEC4;
                case 35667:
                    return INT_VEC2;
                case 35668:
                    return INT_VEC3;
                case 35669:
                    return INT_VEC4;
                case 35674:
                    return MATRIX2x2;
                case 35675:
                    return MATRIX3x3;
                case 35676:
                    return MATRIX4x4;
                case 35685:
                    return MATRIX2x3;
                case 35688:
                    return MATRIX3x4;
                case 36294:
                    return UNSIGNED_INT_VEC2;
                case 36295:
                    return UNSIGNED_INT_VEC3;
                case 36296:
                    return UNSIGNED_INT_VEC4;
                case 36678:
                    return DOUBLE_MATRIX2x2;
                case 36679:
                    return DOUBLE_MATRIX3x3;
                case 36680:
                    return DOUBLE_MATRIX4x4;
                case 36681:
                    return DOUBLE_MATRIX2x3;
                case 36684:
                    return DOUBLE_MATRIX3x4;
                case 36841:
                    return LONG_VEC2;
                case 36842:
                    return LONG_VEC3;
                case 36843:
                    return LONG_VEC4;
                case 36853:
                    return UNSIGNED_LONG_VEC2;
                case 36854:
                    return UNSIGNED_LONG_VEC3;
                case 36855:
                    return UNSIGNED_LONG_VEC4;
                case 36860:
                    return DOUBLE_VEC2;
                case 36861:
                    return DOUBLE_VEC3;
                case 36862:
                    return DOUBLE_VEC4;
                default:
                    throw new AssertionError("Invalid Uniform Type: " + ShaderUniformCache.getName(type));
            }
        }

        public void upload(int program, int location, ByteBuffer buffer) {
            throw new UnsupportedOperationException();
        }

        public void uploadAsMatrix(int program, int location, boolean transpose, ByteBuffer buffer) {
            throw new UnsupportedOperationException();
        }

        public int getBytes() {
            if (this == SAMPLER) {
                return VeilRenderSystem.bindlessTextureSupported() ? 8 : 4;
            }
            return this.bytes;
        }
    }
}
