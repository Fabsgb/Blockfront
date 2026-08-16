package foundry.veil.impl.client.render.wrapper;

import com.mojang.blaze3d.shaders.Shader;
import com.mojang.blaze3d.shaders.Uniform;
import java.nio.FloatBuffer;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL41C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/wrapper/VanillaUniformWrapper.class */
@ApiStatus.Internal
public class VanillaUniformWrapper extends Uniform {
    private final int programId;
    private int location;

    public VanillaUniformWrapper(int shaderId, String name) {
        super(name, 0, 0, (Shader) null);
        close();
        this.programId = shaderId;
        this.location = -1;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void set(int index, float value) {
        throw new UnsupportedOperationException("Use absolute set");
    }

    public void set(float value) {
        if (this.location != -1) {
            GL41C.glProgramUniform1f(this.programId, this.location, value);
        }
    }

    public void set(float x, float y) {
        if (this.location != -1) {
            GL41C.glProgramUniform2f(this.programId, this.location, x, y);
        }
    }

    public void set(float x, float y, float z) {
        if (this.location != -1) {
            GL41C.glProgramUniform3f(this.programId, this.location, x, y, z);
        }
    }

    public void set(float x, float y, float z, float w) {
        if (this.location != -1) {
            GL41C.glProgramUniform4f(this.programId, this.location, x, y, z, w);
        }
    }

    public void set(@NotNull Vector3f value) {
        set(value.x, value.y, value.z);
    }

    public void set(@NotNull Vector4f value) {
        set(value.x, value.y, value.z, value.w);
    }

    public void setSafe(float x, float y, float z, float w) {
        set(x, y, z, w);
    }

    public void set(int value) {
        if (this.location != -1) {
            GL41C.glProgramUniform1i(this.programId, this.location, value);
        }
    }

    public void set(int x, int y) {
        if (this.location != -1) {
            GL41C.glProgramUniform2i(this.programId, this.location, x, y);
        }
    }

    public void set(int x, int y, int z) {
        if (this.location != -1) {
            GL41C.glProgramUniform3i(this.programId, this.location, x, y, z);
        }
    }

    public void set(int x, int y, int z, int w) {
        if (this.location != -1) {
            GL41C.glProgramUniform4i(this.programId, this.location, x, y, z, w);
        }
    }

    public void setSafe(int x, int y, int z, int w) {
        set(x, y, z, w);
    }

    public void set(float[] values) {
        switch (values.length) {
            case 1:
                set(values[0]);
                return;
            case 2:
                set(values[0], values[1]);
                return;
            case 3:
                set(values[0], values[1], values[2]);
                return;
            case 4:
                set(values[0], values[1], values[2], values[3]);
                return;
            default:
                throw new UnsupportedOperationException("Invalid value array: " + Arrays.toString(values));
        }
    }

    public void setMat2x2(float $$0, float $$1, float $$2, float $$3) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat2x3(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat2x4(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat3x2(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat3x3(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7, float $$8) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat3x4(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7, float $$8, float $$9, float $$10, float $$11) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat4x2(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat4x3(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7, float $$8, float $$9, float $$10, float $$11) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void setMat4x4(float $$0, float $$1, float $$2, float $$3, float $$4, float $$5, float $$6, float $$7, float $$8, float $$9, float $$10, float $$11, float $$12, float $$13, float $$14, float $$15) {
        throw new UnsupportedOperationException("Use #set(Matrix4fc) or #set(Matrix3fc) instead");
    }

    public void set(@NotNull Matrix3f value) {
        if (this.location == -1) {
            return;
        }
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(9);
            value.get(buffer);
            GL41C.glProgramUniformMatrix3fv(this.programId, this.location, false, buffer);
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

    public void set(@NotNull Matrix4f value) {
        if (this.location == -1) {
            return;
        }
        MemoryStack stack = MemoryStack.stackPush();
        try {
            FloatBuffer buffer = stack.mallocFloat(16);
            value.get(buffer);
            GL41C.glProgramUniformMatrix4fv(this.programId, this.location, false, buffer);
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

    public void upload() {
    }

    public int getLocation() {
        return this.location;
    }
}
