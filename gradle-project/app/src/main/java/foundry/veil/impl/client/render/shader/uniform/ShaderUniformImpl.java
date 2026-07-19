package foundry.veil.impl.client.render.shader.uniform;

import com.boehmod.blockfront.AbstractC0422pq;
import com.boehmod.blockfront.C0163g;
import com.boehmod.blockfront.C0407pb;
import foundry.veil.api.client.necromancer.Skeleton;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderUniformCache;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Objects;
import java.util.function.IntSupplier;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix2dc;
import org.joml.Matrix2f;
import org.joml.Matrix2fc;
import org.joml.Matrix3dc;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix3x2dc;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Matrix4x3dc;
import org.joml.Matrix4x3f;
import org.joml.Matrix4x3fc;
import org.joml.Vector2dc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4dc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.joml.Vector4i;
import org.joml.Vector4ic;
import org.lwjgl.opengl.ARBBindlessTexture;
import org.lwjgl.opengl.ARBGPUShaderFP64;
import org.lwjgl.opengl.ARBGPUShaderInt64;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/uniform/ShaderUniformImpl.class */
@ApiStatus.Internal
public class ShaderUniformImpl implements ShaderUniform, NativeResource {
    private final IntSupplier program;
    private final String name;
    private ShaderUniform.Type type;
    private int length;
    private ByteBuffer value;
    private int location;

    public ShaderUniformImpl(IntSupplier program, String name) {
        this.program = program;
        this.name = name;
        set(null);
    }

    private void upload() {
        this.type.upload(this.program.getAsInt(), this.location, this.value);
    }

    private void uploadMatrix(boolean transpose) {
        this.type.uploadAsMatrix(this.program.getAsInt(), this.location, transpose, this.value);
    }

    public void set(@Nullable ShaderUniformCache.Uniform uniform) {
        if (uniform == null) {
            free();
            return;
        }
        this.type = ShaderUniform.Type.byId(uniform.type());
        this.length = uniform.arrayLength();
        if (this.value == null || this.value.capacity() != this.type.getBytes() * this.length) {
            this.value = MemoryUtil.memRealloc(this.value, this.type.getBytes() * this.length);
        }
        this.location = uniform.location();
        invalidateCache();
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void invalidateCache() {
        if (this.value != null) {
            MemoryUtil.memSet(this.value, 0);
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public boolean isValid() {
        return this.location != -1;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public String getName() {
        return this.name;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public int getLocation() {
        return this.location;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public ShaderUniform.Type getType() {
        return this.type;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public int getArrayLength() {
        return this.length;
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public float getFloat() {
        switch (this.type) {
            case FLOAT:
                return GL20C.glGetUniformf(this.program.getAsInt(), this.location);
            case SAMPLER:
            case INT:
                return GL20C.glGetUniformi(this.program.getAsInt(), this.location);
            case UNSIGNED_INT:
                return GL30C.glGetUniformui(this.program.getAsInt(), this.location);
            case DOUBLE:
                return (float) ARBGPUShaderFP64.glGetUniformd(this.program.getAsInt(), this.location);
            case LONG:
                return ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location);
            case UNSIGNED_LONG:
                return ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location);
            default:
                return 0.0f;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getFloats(float[] dst, int offset, int length) {
        Objects.checkFromIndexSize(offset, length, dst.length);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.type) {
                case FLOAT:
                    FloatBuffer buffer = stack.mallocFloat(Math.min(this.length, length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    buffer.get(dst);
                    break;
                case SAMPLER:
                case INT:
                    IntBuffer buffer2 = stack.mallocInt(Math.min(this.length, length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i = 0; i < buffer2.capacity(); i++) {
                        dst[i + offset] = buffer2.get(i);
                    }
                    break;
                case UNSIGNED_INT:
                    IntBuffer buffer3 = stack.mallocInt(Math.min(this.length, length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i2 = 0; i2 < buffer3.capacity(); i2++) {
                        dst[i2 + offset] = buffer3.get(i2);
                    }
                    break;
                case DOUBLE:
                    DoubleBuffer buffer4 = stack.mallocDouble(Math.min(this.length, length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i3 = 0; i3 < buffer4.capacity(); i3++) {
                        dst[i3 + offset] = (float) buffer4.get(i3);
                    }
                    break;
                case LONG:
                    LongBuffer buffer5 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location, buffer5);
                    for (int i4 = 0; i4 < buffer5.capacity(); i4++) {
                        dst[i4 + offset] = (int) buffer5.get(i4);
                    }
                    break;
                case UNSIGNED_LONG:
                    LongBuffer buffer6 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location, buffer6);
                    for (int i5 = 0; i5 < buffer6.capacity(); i5++) {
                        dst[i5 + offset] = (int) buffer6.get(i5);
                    }
                    break;
                default:
                    for (int i6 = 0; i6 < Math.min(this.length, length); i6++) {
                        dst[i6 + offset] = 0.0f;
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public int getInt() {
        switch (this.type) {
            case FLOAT:
                return (int) GL20C.glGetUniformf(this.program.getAsInt(), this.location);
            case SAMPLER:
            case INT:
                return GL20C.glGetUniformi(this.program.getAsInt(), this.location);
            case UNSIGNED_INT:
                return GL30C.glGetUniformui(this.program.getAsInt(), this.location);
            case DOUBLE:
                return (int) ARBGPUShaderFP64.glGetUniformd(this.program.getAsInt(), this.location);
            case LONG:
                return (int) ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location);
            case UNSIGNED_LONG:
                return (int) ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location);
            default:
                return 0;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getInts(int[] dst, int offset, int length) {
        Objects.checkFromIndexSize(offset, length, dst.length);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.type) {
                case FLOAT:
                    FloatBuffer buffer = stack.mallocFloat(Math.min(this.length, length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < buffer.capacity(); i++) {
                        dst[i + offset] = (int) buffer.get(i);
                    }
                    break;
                case SAMPLER:
                case INT:
                    IntBuffer buffer2 = stack.mallocInt(Math.min(this.length, length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    buffer2.get(dst);
                    break;
                case UNSIGNED_INT:
                    IntBuffer buffer3 = stack.mallocInt(Math.min(this.length, length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    buffer3.get(dst);
                    break;
                case DOUBLE:
                    DoubleBuffer buffer4 = stack.mallocDouble(Math.min(this.length, length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i2 = 0; i2 < buffer4.capacity(); i2++) {
                        dst[i2 + offset] = (int) buffer4.get(i2);
                    }
                    break;
                case LONG:
                    LongBuffer buffer5 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location, buffer5);
                    for (int i3 = 0; i3 < buffer5.capacity(); i3++) {
                        dst[i3 + offset] = (int) buffer5.get(i3);
                    }
                    break;
                case UNSIGNED_LONG:
                    LongBuffer buffer6 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location, buffer6);
                    for (int i4 = 0; i4 < buffer6.capacity(); i4++) {
                        dst[i4 + offset] = (int) buffer6.get(i4);
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, length); i5++) {
                        dst[i5 + offset] = 0;
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public double getDouble() {
        switch (this.type) {
            case FLOAT:
                return GL20C.glGetUniformf(this.program.getAsInt(), this.location);
            case SAMPLER:
            case INT:
                return GL20C.glGetUniformi(this.program.getAsInt(), this.location);
            case UNSIGNED_INT:
                return GL30C.glGetUniformui(this.program.getAsInt(), this.location);
            case DOUBLE:
                return ARBGPUShaderFP64.glGetUniformd(this.program.getAsInt(), this.location);
            case LONG:
                return ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location);
            case UNSIGNED_LONG:
                return ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location);
            default:
                return 0.0d;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getDoubles(double[] dst, int offset, int length) {
        Objects.checkFromIndexSize(offset, length, dst.length);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.type) {
                case FLOAT:
                    FloatBuffer buffer = stack.mallocFloat(Math.min(this.length, length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < buffer.capacity(); i++) {
                        dst[i + offset] = buffer.get(i);
                    }
                    break;
                case SAMPLER:
                case INT:
                    IntBuffer buffer2 = stack.mallocInt(Math.min(this.length, length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < buffer2.capacity(); i2++) {
                        dst[i2 + offset] = buffer2.get(i2);
                    }
                    break;
                case UNSIGNED_INT:
                    IntBuffer buffer3 = stack.mallocInt(Math.min(this.length, length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < buffer3.capacity(); i3++) {
                        dst[i3 + offset] = buffer3.get(i3);
                    }
                    break;
                case DOUBLE:
                    DoubleBuffer buffer4 = stack.mallocDouble(Math.min(this.length, length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    buffer4.get(dst);
                    break;
                case LONG:
                    LongBuffer buffer5 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location, buffer5);
                    for (int i4 = 0; i4 < buffer5.capacity(); i4++) {
                        dst[i4 + offset] = buffer5.get(i4);
                    }
                    break;
                case UNSIGNED_LONG:
                    LongBuffer buffer6 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location, buffer6);
                    for (int i5 = 0; i5 < buffer6.capacity(); i5++) {
                        dst[i5 + offset] = buffer6.get(i5);
                    }
                    break;
                default:
                    for (int i6 = 0; i6 < Math.min(this.length, length); i6++) {
                        dst[i6 + offset] = 0.0d;
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public long getLong() {
        switch (this.type) {
            case FLOAT:
                return (long) GL20C.glGetUniformf(this.program.getAsInt(), this.location);
            case SAMPLER:
            case INT:
                return GL20C.glGetUniformi(this.program.getAsInt(), this.location);
            case UNSIGNED_INT:
                return GL30C.glGetUniformui(this.program.getAsInt(), this.location);
            case DOUBLE:
                return (long) ARBGPUShaderFP64.glGetUniformd(this.program.getAsInt(), this.location);
            case LONG:
                return ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location);
            case UNSIGNED_LONG:
                return ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location);
            default:
                return 0L;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getLongs(long[] dst, int offset, int length) {
        Objects.checkFromIndexSize(offset, length, dst.length);
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.type) {
                case FLOAT:
                    FloatBuffer buffer = stack.mallocFloat(Math.min(this.length, length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < buffer.capacity(); i++) {
                        dst[i + offset] = (long) buffer.get(i);
                    }
                    break;
                case SAMPLER:
                case INT:
                    IntBuffer buffer2 = stack.mallocInt(Math.min(this.length, length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < buffer2.capacity(); i2++) {
                        dst[i2 + offset] = buffer2.get(i2);
                    }
                    break;
                case UNSIGNED_INT:
                    IntBuffer buffer3 = stack.mallocInt(Math.min(this.length, length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < buffer3.capacity(); i3++) {
                        dst[i3 + offset] = buffer3.get(i3);
                    }
                    break;
                case DOUBLE:
                    DoubleBuffer buffer4 = stack.mallocDouble(Math.min(this.length, length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < buffer4.capacity(); i4++) {
                        dst[i4 + offset] = (long) buffer4.get(i4);
                    }
                    break;
                case LONG:
                    LongBuffer buffer5 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformi64vARB(this.program.getAsInt(), this.location, buffer5);
                    buffer5.get(dst);
                    break;
                case UNSIGNED_LONG:
                    LongBuffer buffer6 = stack.mallocLong(Math.min(this.length, length));
                    ARBGPUShaderInt64.glGetnUniformui64vARB(this.program.getAsInt(), this.location, buffer6);
                    buffer6.get(dst);
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, length); i5++) {
                        dst[i5 + offset] = 0;
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getVector(CharSequence name, Vector2f... values) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (AnonymousClass1.$SwitchMap$foundry$veil$api$client$render$shader$uniform$ShaderUniform$Type[this.type.ordinal()]) {
                case 8:
                    FloatBuffer buffer = stack.mallocFloat(2 * Math.min(this.length, values.length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < values.length; i++) {
                        values[i].set(i * 2, buffer);
                    }
                    break;
                case C0407pb.nv /* 9 */:
                    IntBuffer buffer2 = stack.mallocInt(2 * Math.min(this.length, values.length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < values.length; i2++) {
                        values[i2].set(buffer2.get(i2 * 2), buffer2.get((i2 * 2) + 1));
                    }
                    break;
                case 10:
                    IntBuffer buffer3 = stack.mallocInt(2 * Math.min(this.length, values.length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < values.length; i3++) {
                        values[i3].set(buffer3.get(i3 * 2), buffer3.get((i3 * 2) + 1));
                    }
                    break;
                case AbstractC0422pq.nO /* 11 */:
                    DoubleBuffer buffer4 = stack.mallocDouble(2 * Math.min(this.length, values.length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < values.length; i4++) {
                        values[i4].set(buffer4.get(i4 * 2), buffer4.get((i4 * 2) + 1));
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, values.length); i5++) {
                        values[i5].set(0.0f);
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getVector(CharSequence name, Vector3f... values) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (AnonymousClass1.$SwitchMap$foundry$veil$api$client$render$shader$uniform$ShaderUniform$Type[this.type.ordinal()]) {
                case 12:
                    FloatBuffer buffer = stack.mallocFloat(3 * Math.min(this.length, values.length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < values.length; i++) {
                        values[i].set(i * 3, buffer);
                    }
                    break;
                case C0407pb.nu /* 13 */:
                    IntBuffer buffer2 = stack.mallocInt(3 * Math.min(this.length, values.length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < values.length; i2++) {
                        values[i2].set(buffer2.get(i2 * 3), buffer2.get((i2 * 3) + 1), buffer2.get((i2 * 3) + 2));
                    }
                    break;
                case 14:
                    IntBuffer buffer3 = stack.mallocInt(3 * Math.min(this.length, values.length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < values.length; i3++) {
                        values[i3].set(buffer3.get(i3 * 3), buffer3.get((i3 * 3) + 1), buffer3.get((i3 * 3) + 2));
                    }
                    break;
                case 15:
                    DoubleBuffer buffer4 = stack.mallocDouble(3 * Math.min(this.length, values.length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < values.length; i4++) {
                        values[i4].set(buffer4.get(i4 * 3), buffer4.get((i4 * 3) + 1), buffer4.get((i4 * 3) + 2));
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, values.length); i5++) {
                        values[i5].set(0.0f);
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getVector(CharSequence name, Vector4f... values) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.type) {
                case FLOAT_VEC4:
                    FloatBuffer buffer = stack.mallocFloat(4 * Math.min(this.length, values.length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < values.length; i++) {
                        values[i].set(i * 4, buffer);
                    }
                    break;
                case INT_VEC4:
                    IntBuffer buffer2 = stack.mallocInt(4 * Math.min(this.length, values.length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < values.length; i2++) {
                        values[i2].set(buffer2.get(i2 * 4), buffer2.get((i2 * 4) + 1), buffer2.get((i2 * 4) + 2), buffer2.get((i2 * 4) + 3));
                    }
                    break;
                case UNSIGNED_INT_VEC4:
                    IntBuffer buffer3 = stack.mallocInt(4 * Math.min(this.length, values.length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < values.length; i3++) {
                        values[i3].set(buffer3.get(i3 * 4), buffer3.get((i3 * 4) + 1), buffer3.get((i3 * 4) + 2), buffer3.get((i3 * 4) + 3));
                    }
                    break;
                case DOUBLE_VEC4:
                    DoubleBuffer buffer4 = stack.mallocDouble(4 * Math.min(this.length, values.length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < values.length; i4++) {
                        values[i4].set(buffer4.get(i4 * 4), buffer4.get((i4 * 4) + 1), buffer4.get((i4 * 4) + 2), buffer4.get((i4 * 4) + 3));
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, values.length); i5++) {
                        values[i5].set(0.0f);
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getVectori(CharSequence name, Vector2i... values) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (AnonymousClass1.$SwitchMap$foundry$veil$api$client$render$shader$uniform$ShaderUniform$Type[this.type.ordinal()]) {
                case 8:
                    FloatBuffer buffer = stack.mallocFloat(2 * Math.min(this.length, values.length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < values.length; i++) {
                        values[i].set((int) buffer.get(i * 2), (int) buffer.get((i * 2) + 1));
                    }
                    break;
                case C0407pb.nv /* 9 */:
                    IntBuffer buffer2 = stack.mallocInt(2 * Math.min(this.length, values.length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < values.length; i2++) {
                        values[i2].set(i2 * 2, buffer2);
                    }
                    break;
                case 10:
                    IntBuffer buffer3 = stack.mallocInt(2 * Math.min(this.length, values.length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < values.length; i3++) {
                        values[i3].set(i3 * 2, buffer3);
                    }
                    break;
                case AbstractC0422pq.nO /* 11 */:
                    DoubleBuffer buffer4 = stack.mallocDouble(2 * Math.min(this.length, values.length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < values.length; i4++) {
                        values[i4].set((int) buffer4.get(i4 * 2), (int) buffer4.get((i4 * 2) + 1));
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, values.length); i5++) {
                        values[i5].set(0);
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getVectori(CharSequence name, Vector3i... values) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (AnonymousClass1.$SwitchMap$foundry$veil$api$client$render$shader$uniform$ShaderUniform$Type[this.type.ordinal()]) {
                case 12:
                    FloatBuffer buffer = stack.mallocFloat(3 * Math.min(this.length, values.length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < values.length; i++) {
                        values[i].set((int) buffer.get(i * 3), (int) buffer.get((i * 3) + 1), (int) buffer.get((i * 3) + 2));
                    }
                    break;
                case C0407pb.nu /* 13 */:
                    IntBuffer buffer2 = stack.mallocInt(3 * Math.min(this.length, values.length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < values.length; i2++) {
                        values[i2].set(i2 * 3, buffer2);
                    }
                    break;
                case 14:
                    IntBuffer buffer3 = stack.mallocInt(3 * Math.min(this.length, values.length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < values.length; i3++) {
                        values[i3].set(i3 * 3, buffer3);
                    }
                    break;
                case 15:
                    DoubleBuffer buffer4 = stack.mallocDouble(3 * Math.min(this.length, values.length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < values.length; i4++) {
                        values[i4].set((int) buffer4.get(i4 * 3), (int) buffer4.get((i4 * 3) + 1), (int) buffer4.get((i4 * 3) + 2));
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, values.length); i5++) {
                        values[i5].set(0);
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getVectori(CharSequence name, Vector4i... values) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (this.type) {
                case FLOAT_VEC4:
                    FloatBuffer buffer = stack.mallocFloat(3 * Math.min(this.length, values.length));
                    GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
                    for (int i = 0; i < values.length; i++) {
                        values[i].set((int) buffer.get(i * 4), (int) buffer.get((i * 4) + 1), (int) buffer.get((i * 4) + 2), (int) buffer.get((i * 4) + 3));
                    }
                    break;
                case INT_VEC4:
                    IntBuffer buffer2 = stack.mallocInt(3 * Math.min(this.length, values.length));
                    GL20C.glGetUniformiv(this.program.getAsInt(), this.location, buffer2);
                    for (int i2 = 0; i2 < values.length; i2++) {
                        values[i2].set(i2 * 4, buffer2);
                    }
                    break;
                case UNSIGNED_INT_VEC4:
                    IntBuffer buffer3 = stack.mallocInt(3 * Math.min(this.length, values.length));
                    GL30C.glGetUniformuiv(this.program.getAsInt(), this.location, buffer3);
                    for (int i3 = 0; i3 < values.length; i3++) {
                        values[i3].set(i3 * 4, buffer3);
                    }
                    break;
                case DOUBLE_VEC4:
                    DoubleBuffer buffer4 = stack.mallocDouble(4 * Math.min(this.length, values.length));
                    ARBGPUShaderFP64.glGetUniformdv(this.program.getAsInt(), this.location, buffer4);
                    for (int i4 = 0; i4 < values.length; i4++) {
                        values[i4].set((int) buffer4.get(i4 * 4), (int) buffer4.get((i4 * 4) + 1), (int) buffer4.get((i4 * 4) + 2), (int) buffer4.get((i4 * 4) + 3));
                    }
                    break;
                default:
                    for (int i5 = 0; i5 < Math.min(this.length, values.length); i5++) {
                        values[i5].set(0);
                    }
                    break;
            }
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getMatrix(CharSequence name, Matrix2f value) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(4);
            GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
            value.set(0, buffer);
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getMatrix(CharSequence name, Matrix3f value) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(9);
            GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
            value.set(0, buffer);
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getMatrix(CharSequence name, Matrix4f value) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(16);
            GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
            value.set(0, buffer);
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getMatrix(CharSequence name, Matrix3x2f value) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(6);
            GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
            value.set(0, buffer);
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniform
    public void getMatrix(CharSequence name, Matrix4x3f value) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(12);
            GL20C.glGetUniformfv(this.program.getAsInt(), this.location, buffer);
            value.set(0, buffer);
            if (stack != null) {
                stack.close();
            }
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void free() {
        this.type = null;
        this.length = 0;
        this.location = -1;
        if (this.value != null) {
            MemoryUtil.memFree(this.value);
            this.value = null;
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloat(float value) {
        if (this.type != ShaderUniform.Type.FLOAT || this.value.getInt(0) == Float.floatToIntBits(value)) {
            return;
        }
        this.value.putFloat(0, value);
        upload();
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y) {
        if (this.type == ShaderUniform.Type.FLOAT_VEC2) {
            if (this.value.getInt(0) == Float.floatToIntBits(x) && this.value.getInt(4) == Float.floatToIntBits(y)) {
                return;
            }
            this.value.putFloat(0, x);
            this.value.putFloat(4, y);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z) {
        if (this.type == ShaderUniform.Type.FLOAT_VEC3) {
            if (this.value.getInt(0) == Float.floatToIntBits(x) && this.value.getInt(4) == Float.floatToIntBits(y) && this.value.getInt(8) == Float.floatToIntBits(z)) {
                return;
            }
            this.value.putFloat(0, x);
            this.value.putFloat(4, y);
            this.value.putFloat(8, z);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector(float x, float y, float z, float w) {
        if (this.type == ShaderUniform.Type.FLOAT_VEC4) {
            if (this.value.getInt(0) == Float.floatToIntBits(x) && this.value.getInt(4) == Float.floatToIntBits(y) && this.value.getInt(8) == Float.floatToIntBits(z) && this.value.getInt(12) == Float.floatToIntBits(w)) {
                return;
            }
            this.value.putFloat(0, x);
            this.value.putFloat(4, y);
            this.value.putFloat(8, z);
            this.value.putFloat(12, w);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInt(int value) {
        if ((this.type != ShaderUniform.Type.INT && this.type != ShaderUniform.Type.UNSIGNED_INT && this.type != ShaderUniform.Type.SAMPLER) || this.value.getInt(0) == value) {
            return;
        }
        if (this.type == ShaderUniform.Type.SAMPLER) {
            this.value.limit(4 * this.length);
        }
        this.value.putInt(0, value);
        upload();
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y) {
        if (this.type == ShaderUniform.Type.INT_VEC2 || this.type == ShaderUniform.Type.UNSIGNED_INT_VEC2) {
            if (this.value.getInt(0) == x && this.value.getInt(4) == y) {
                return;
            }
            this.value.putInt(0, x);
            this.value.putInt(4, y);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z) {
        if (this.type == ShaderUniform.Type.INT_VEC3 || this.type == ShaderUniform.Type.UNSIGNED_INT_VEC3) {
            if (this.value.getInt(0) == x && this.value.getInt(4) == y && this.value.getInt(8) == z) {
                return;
            }
            this.value.putInt(0, x);
            this.value.putInt(4, y);
            this.value.putInt(8, z);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI(int x, int y, int z, int w) {
        if (this.type == ShaderUniform.Type.INT_VEC4 || this.type == ShaderUniform.Type.UNSIGNED_INT_VEC4) {
            if (this.value.getInt(0) == x && this.value.getInt(4) == y && this.value.getInt(8) == z && this.value.getInt(12) == w) {
                return;
            }
            this.value.putInt(0, x);
            this.value.putInt(4, y);
            this.value.putInt(8, z);
            this.value.putInt(12, w);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDouble(double value) {
        if (this.type != ShaderUniform.Type.DOUBLE || this.value.getLong(0) == Double.doubleToLongBits(value)) {
            return;
        }
        this.value.putDouble(0, value);
        upload();
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y) {
        if (this.type == ShaderUniform.Type.DOUBLE_VEC2) {
            if (this.value.getLong(0) == Double.doubleToLongBits(x) && this.value.getLong(8) == Double.doubleToLongBits(y)) {
                return;
            }
            this.value.putDouble(0, x);
            this.value.putDouble(8, y);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z) {
        if (this.type == ShaderUniform.Type.DOUBLE_VEC3) {
            if (this.value.getLong(0) == Double.doubleToLongBits(x) && this.value.getLong(8) == Double.doubleToLongBits(y) && this.value.getLong(16) == Double.doubleToLongBits(z)) {
                return;
            }
            this.value.putDouble(0, x);
            this.value.putDouble(8, y);
            this.value.putDouble(16, z);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVector64(double x, double y, double z, double w) {
        if (this.type == ShaderUniform.Type.DOUBLE_VEC4) {
            if (this.value.getLong(0) == Double.doubleToLongBits(x) && this.value.getLong(8) == Double.doubleToLongBits(y) && this.value.getLong(16) == Double.doubleToLongBits(z) && this.value.getLong(24) == Double.doubleToLongBits(w)) {
                return;
            }
            this.value.putDouble(0, x);
            this.value.putDouble(8, y);
            this.value.putDouble(16, z);
            this.value.putDouble(24, w);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLong(long value) {
        if ((this.type != ShaderUniform.Type.LONG && this.type != ShaderUniform.Type.UNSIGNED_LONG) || this.value.getLong(0) == value) {
            return;
        }
        this.value.putLong(0, value);
        upload();
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y) {
        if (this.type == ShaderUniform.Type.LONG_VEC2 || this.type == ShaderUniform.Type.UNSIGNED_LONG_VEC2) {
            if (this.value.getLong(0) == x && this.value.getLong(8) == y) {
                return;
            }
            this.value.putLong(0, x);
            this.value.putLong(8, y);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z) {
        if (this.type == ShaderUniform.Type.LONG_VEC3 || this.type == ShaderUniform.Type.UNSIGNED_LONG_VEC3) {
            if (this.value.getLong(0) == x && this.value.getLong(8) == y && this.value.getLong(16) == z) {
                return;
            }
            this.value.putLong(0, x);
            this.value.putLong(8, y);
            this.value.putLong(16, z);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectorI64(long x, long y, long z, long w) {
        if (this.type == ShaderUniform.Type.LONG_VEC4 || this.type == ShaderUniform.Type.UNSIGNED_LONG_VEC4) {
            if (this.value.getLong(0) == x && this.value.getLong(8) == y && this.value.getLong(16) == z && this.value.getLong(24) == w) {
                return;
            }
            this.value.putLong(0, x);
            this.value.putLong(8, y);
            this.value.putLong(16, z);
            this.value.putLong(24, w);
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setFloats(float... values) {
        if (this.type != ShaderUniform.Type.FLOAT && this.type != ShaderUniform.Type.FLOAT_VEC2 && this.type != ShaderUniform.Type.FLOAT_VEC3 && this.type != ShaderUniform.Type.FLOAT_VEC4) {
            return;
        }
        int length = Math.min(this.value.capacity() / this.type.getBytes(), values.length);
        for (int i = 0; i < length; i++) {
            if (this.value.getInt(i * 4) != Float.floatToIntBits(values[i])) {
                this.value.asFloatBuffer().put(0, values, 0, length);
                upload();
                return;
            }
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector2fc... values) {
        if (this.type != ShaderUniform.Type.FLOAT_VEC2) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector2fc vector = values[i];
            if (vector.equals(this.value.getFloat(i * 8), this.value.getFloat((i * 8) + 4))) {
                changed = true;
            }
            vector.get(i * 8, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector3fc... values) {
        if (this.type != ShaderUniform.Type.FLOAT_VEC3) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector3fc vector = values[i];
            if (vector.equals(this.value.getFloat(i * 12), this.value.getFloat((i * 12) + 4), this.value.getFloat((i * 12) + 8))) {
                changed = true;
            }
            vector.get(i * 12, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setVectors(Vector4fc... values) {
        if (this.type != ShaderUniform.Type.FLOAT_VEC4) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector4fc vector = values[i];
            if (vector.equals(this.value.getFloat(i * 16), this.value.getFloat((i * 16) + 4), this.value.getFloat((i * 16) + 8), this.value.getFloat((i * 16) + 12))) {
                changed = true;
            }
            vector.get(i * 16, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setInts(int... values) {
        if (this.type != ShaderUniform.Type.INT && this.type != ShaderUniform.Type.INT_VEC2 && this.type != ShaderUniform.Type.INT_VEC3 && this.type != ShaderUniform.Type.INT_VEC4 && this.type != ShaderUniform.Type.UNSIGNED_INT && this.type != ShaderUniform.Type.UNSIGNED_INT_VEC2 && this.type != ShaderUniform.Type.UNSIGNED_INT_VEC3 && this.type != ShaderUniform.Type.UNSIGNED_INT_VEC4 && this.type != ShaderUniform.Type.SAMPLER) {
            return;
        }
        int length = Math.min(this.value.capacity() / (this.type == ShaderUniform.Type.SAMPLER ? 4 : this.type.getBytes()), values.length);
        for (int i = 0; i < length; i++) {
            if (this.value.getInt(i * 4) != values[i]) {
                if (this.type == ShaderUniform.Type.SAMPLER) {
                    this.value.limit(4 * this.length);
                }
                this.value.asIntBuffer().put(0, values, 0, length);
                upload();
                return;
            }
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector2ic... values) {
        if (this.type != ShaderUniform.Type.INT_VEC2 && this.type != ShaderUniform.Type.UNSIGNED_INT_VEC2) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector2ic vector = values[i];
            if (vector.equals(this.value.getInt(i * 8), this.value.getInt((i * 8) + 4))) {
                changed = true;
            }
            vector.get(i * 8, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector3ic... values) {
        if (this.type != ShaderUniform.Type.INT_VEC3 && this.type != ShaderUniform.Type.UNSIGNED_INT_VEC3) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector3ic vector = values[i];
            if (vector.equals(this.value.getInt(i * 12), this.value.getInt((i * 12) + 4), this.value.getInt((i * 12) + 8))) {
                changed = true;
            }
            vector.get(i * 12, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setIVectors(Vector4ic... values) {
        if (this.type != ShaderUniform.Type.INT_VEC4 && this.type != ShaderUniform.Type.UNSIGNED_INT_VEC4) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector4ic vector = values[i];
            if (vector.equals(this.value.getInt(i * 16), this.value.getInt((i * 16) + 4), this.value.getInt((i * 16) + 8), this.value.getInt((i * 16) + 12))) {
                changed = true;
            }
            vector.get(i * 16, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setDoubles(double... values) {
        if (this.type != ShaderUniform.Type.DOUBLE && this.type != ShaderUniform.Type.DOUBLE_VEC2 && this.type != ShaderUniform.Type.DOUBLE_VEC3 && this.type != ShaderUniform.Type.DOUBLE_VEC4) {
            return;
        }
        int length = Math.min(this.value.capacity() / this.type.getBytes(), values.length);
        for (int i = 0; i < length; i++) {
            if (this.value.getLong(i * 8) != Double.doubleToLongBits(values[i])) {
                this.value.asDoubleBuffer().put(0, values, 0, length);
                upload();
                return;
            }
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector2dc... values) {
        if (this.type != ShaderUniform.Type.DOUBLE_VEC2) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector2dc vector = values[i];
            if (vector.equals(this.value.getDouble(i * 16), this.value.getDouble((i * 16) + 8))) {
                changed = true;
            }
            vector.get(i * 16, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector3dc... values) {
        if (this.type != ShaderUniform.Type.DOUBLE_VEC3) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector3dc vector = values[i];
            if (vector.equals(this.value.getDouble(i * 24), this.value.getDouble((i * 24) + 8), this.value.getDouble((i * 24) + 16))) {
                changed = true;
            }
            vector.get(i * 24, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void set64Vectors(Vector4dc... values) {
        if (this.type != ShaderUniform.Type.DOUBLE_VEC4) {
            return;
        }
        int length = Math.min(this.length, values.length);
        boolean changed = false;
        for (int i = 0; i < length; i++) {
            Vector4dc vector = values[i];
            if (vector.equals(this.value.getDouble(i * 32), this.value.getDouble((i * 32) + 8), this.value.getDouble((i * 32) + 16), this.value.getDouble((i * 32) + 24))) {
                changed = true;
            }
            vector.get(i * 32, this.value);
        }
        if (changed) {
            upload();
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setLongs(long... values) {
        if (this.type != ShaderUniform.Type.LONG && this.type != ShaderUniform.Type.LONG_VEC2 && this.type != ShaderUniform.Type.LONG_VEC3 && this.type != ShaderUniform.Type.LONG_VEC4 && this.type != ShaderUniform.Type.UNSIGNED_LONG && this.type != ShaderUniform.Type.UNSIGNED_LONG_VEC2 && this.type != ShaderUniform.Type.UNSIGNED_LONG_VEC3 && this.type != ShaderUniform.Type.UNSIGNED_LONG_VEC4) {
            return;
        }
        int length = Math.min(this.value.capacity() / this.type.getBytes(), values.length);
        for (int i = 0; i < length; i++) {
            if (this.value.getLong(i * 8) != values[i]) {
                this.value.asLongBuffer().put(0, values, 0, length);
                upload();
                return;
            }
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandle(long value) {
        if (this.type != ShaderUniform.Type.SAMPLER || !VeilRenderSystem.bindlessTextureSupported() || this.value.getLong(0) == value) {
            return;
        }
        this.value.limit(this.type.getBytes() * this.length);
        this.value.putLong(0, value);
        if (VeilRenderSystem.separateShaderObjectsSupported()) {
            ARBBindlessTexture.glProgramUniformHandleui64vARB(this.program.getAsInt(), this.location, this.value.asLongBuffer());
        } else {
            ARBBindlessTexture.glUniformHandleui64vARB(this.location, this.value.asLongBuffer());
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setHandles(long... values) {
        if (this.type != ShaderUniform.Type.SAMPLER || !VeilRenderSystem.bindlessTextureSupported()) {
            return;
        }
        int length = Math.min(this.value.capacity() / this.type.getBytes(), values.length);
        for (int i = 0; i < length; i++) {
            if (this.value.getLong(i * 8) != values[i]) {
                this.value.limit(this.type.getBytes() * this.length);
                LongBuffer longBuffer = this.value.asLongBuffer();
                longBuffer.put(0, values, 0, length);
                if (VeilRenderSystem.separateShaderObjectsSupported()) {
                    ARBBindlessTexture.glProgramUniformHandleui64vARB(this.program.getAsInt(), this.location, longBuffer);
                    return;
                } else {
                    ARBBindlessTexture.glUniformHandleui64vARB(this.location, longBuffer);
                    return;
                }
            }
        }
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX2x2) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m10()) && this.value.getInt(12) == Float.floatToIntBits(value.m11())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX3x3) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m02()) && this.value.getInt(12) == Float.floatToIntBits(value.m10()) && this.value.getInt(16) == Float.floatToIntBits(value.m11()) && this.value.getInt(20) == Float.floatToIntBits(value.m12()) && this.value.getInt(24) == Float.floatToIntBits(value.m20()) && this.value.getInt(28) == Float.floatToIntBits(value.m21()) && this.value.getInt(32) == Float.floatToIntBits(value.m22())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX4x4) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m02()) && this.value.getInt(12) == Float.floatToIntBits(value.m03()) && this.value.getInt(16) == Float.floatToIntBits(value.m10()) && this.value.getInt(20) == Float.floatToIntBits(value.m11()) && this.value.getInt(24) == Float.floatToIntBits(value.m12()) && this.value.getInt(28) == Float.floatToIntBits(value.m13()) && this.value.getInt(32) == Float.floatToIntBits(value.m20()) && this.value.getInt(36) == Float.floatToIntBits(value.m21()) && this.value.getInt(40) == Float.floatToIntBits(value.m22()) && this.value.getInt(44) == Float.floatToIntBits(value.m23()) && this.value.getInt(48) == Float.floatToIntBits(value.m30()) && this.value.getInt(52) == Float.floatToIntBits(value.m31()) && this.value.getInt(56) == Float.floatToIntBits(value.m32()) && this.value.getInt(60) == Float.floatToIntBits(value.m33())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX2x3) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m10()) && this.value.getInt(16) == Float.floatToIntBits(value.m11()) && this.value.getInt(20) == Float.floatToIntBits(value.m20()) && this.value.getInt(24) == Float.floatToIntBits(value.m21())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX3x2) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m10()) && this.value.getInt(16) == Float.floatToIntBits(value.m11()) && this.value.getInt(20) == Float.floatToIntBits(value.m20()) && this.value.getInt(24) == Float.floatToIntBits(value.m21())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(!transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX3x4) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m02()) && this.value.getInt(12) == Float.floatToIntBits(value.m10()) && this.value.getInt(16) == Float.floatToIntBits(value.m11()) && this.value.getInt(20) == Float.floatToIntBits(value.m12()) && this.value.getInt(24) == Float.floatToIntBits(value.m20()) && this.value.getInt(28) == Float.floatToIntBits(value.m21()) && this.value.getInt(32) == Float.floatToIntBits(value.m22()) && this.value.getInt(36) == Float.floatToIntBits(value.m30()) && this.value.getInt(40) == Float.floatToIntBits(value.m31()) && this.value.getInt(44) == Float.floatToIntBits(value.m32())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(!transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3fc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX4x3) {
            return;
        }
        if (this.value.getInt(0) == Float.floatToIntBits(value.m00()) && this.value.getInt(4) == Float.floatToIntBits(value.m01()) && this.value.getInt(8) == Float.floatToIntBits(value.m02()) && this.value.getInt(12) == Float.floatToIntBits(value.m10()) && this.value.getInt(16) == Float.floatToIntBits(value.m11()) && this.value.getInt(20) == Float.floatToIntBits(value.m12()) && this.value.getInt(24) == Float.floatToIntBits(value.m20()) && this.value.getInt(28) == Float.floatToIntBits(value.m21()) && this.value.getInt(32) == Float.floatToIntBits(value.m22()) && this.value.getInt(36) == Float.floatToIntBits(value.m30()) && this.value.getInt(40) == Float.floatToIntBits(value.m31()) && this.value.getInt(44) == Float.floatToIntBits(value.m32())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix2dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX2x2) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(8) == Double.doubleToLongBits(value.m01()) && this.value.getLong(16) == Double.doubleToLongBits(value.m10()) && this.value.getLong(24) == Double.doubleToLongBits(value.m11())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix3dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX3x3) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(8) == Double.doubleToLongBits(value.m01()) && this.value.getLong(16) == Double.doubleToLongBits(value.m02()) && this.value.getLong(24) == Double.doubleToLongBits(value.m10()) && this.value.getLong(32) == Double.doubleToLongBits(value.m11()) && this.value.getLong(40) == Double.doubleToLongBits(value.m12()) && this.value.getLong(48) == Double.doubleToLongBits(value.m20()) && this.value.getLong(56) == Double.doubleToLongBits(value.m21()) && this.value.getLong(64) == Double.doubleToLongBits(value.m22())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix(Matrix4dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.DOUBLE_MATRIX4x4) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(8) == Double.doubleToLongBits(value.m01()) && this.value.getLong(16) == Double.doubleToLongBits(value.m02()) && this.value.getLong(24) == Double.doubleToLongBits(value.m03()) && this.value.getLong(32) == Double.doubleToLongBits(value.m10()) && this.value.getLong(40) == Double.doubleToLongBits(value.m11()) && this.value.getLong(48) == Double.doubleToLongBits(value.m12()) && this.value.getLong(56) == Double.doubleToLongBits(value.m13()) && this.value.getLong(64) == Double.doubleToLongBits(value.m20()) && this.value.getLong(72) == Double.doubleToLongBits(value.m21()) && this.value.getLong(80) == Double.doubleToLongBits(value.m22()) && this.value.getLong(88) == Double.doubleToLongBits(value.m23()) && this.value.getLong(96) == Double.doubleToLongBits(value.m30()) && this.value.getLong(104) == Double.doubleToLongBits(value.m31()) && this.value.getLong(Skeleton.UNIFORM_STRIDE) == Double.doubleToLongBits(value.m32()) && this.value.getLong(C0163g.g) == Double.doubleToLongBits(value.m33())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix2x3(Matrix3x2dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX2x3) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(4) == Double.doubleToLongBits(value.m01()) && this.value.getLong(8) == Double.doubleToLongBits(value.m10()) && this.value.getLong(16) == Double.doubleToLongBits(value.m11()) && this.value.getLong(20) == Double.doubleToLongBits(value.m20()) && this.value.getLong(24) == Double.doubleToLongBits(value.m21())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x2(Matrix3x2dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX3x2) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(4) == Double.doubleToLongBits(value.m01()) && this.value.getLong(8) == Double.doubleToLongBits(value.m10()) && this.value.getLong(16) == Double.doubleToLongBits(value.m11()) && this.value.getLong(20) == Double.doubleToLongBits(value.m20()) && this.value.getLong(24) == Double.doubleToLongBits(value.m21())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(!transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix3x4(Matrix4x3dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX3x4) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(4) == Double.doubleToLongBits(value.m01()) && this.value.getLong(8) == Double.doubleToLongBits(value.m02()) && this.value.getLong(12) == Double.doubleToLongBits(value.m10()) && this.value.getLong(16) == Double.doubleToLongBits(value.m11()) && this.value.getLong(20) == Double.doubleToLongBits(value.m12()) && this.value.getLong(24) == Double.doubleToLongBits(value.m20()) && this.value.getLong(28) == Double.doubleToLongBits(value.m21()) && this.value.getLong(32) == Double.doubleToLongBits(value.m22()) && this.value.getLong(36) == Double.doubleToLongBits(value.m30()) && this.value.getLong(40) == Double.doubleToLongBits(value.m31()) && this.value.getLong(44) == Double.doubleToLongBits(value.m32())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(!transpose);
    }

    @Override // foundry.veil.api.client.render.shader.uniform.ShaderUniformAccess
    public void setMatrix4x3(Matrix4x3dc value, boolean transpose) {
        if (this.type != ShaderUniform.Type.MATRIX4x3) {
            return;
        }
        if (this.value.getLong(0) == Double.doubleToLongBits(value.m00()) && this.value.getLong(4) == Double.doubleToLongBits(value.m01()) && this.value.getLong(8) == Double.doubleToLongBits(value.m02()) && this.value.getLong(12) == Double.doubleToLongBits(value.m10()) && this.value.getLong(16) == Double.doubleToLongBits(value.m11()) && this.value.getLong(20) == Double.doubleToLongBits(value.m12()) && this.value.getLong(24) == Double.doubleToLongBits(value.m20()) && this.value.getLong(28) == Double.doubleToLongBits(value.m21()) && this.value.getLong(32) == Double.doubleToLongBits(value.m22()) && this.value.getLong(36) == Double.doubleToLongBits(value.m30()) && this.value.getLong(40) == Double.doubleToLongBits(value.m31()) && this.value.getLong(44) == Double.doubleToLongBits(value.m32())) {
            return;
        }
        value.get(this.value);
        uploadMatrix(transpose);
    }
}
