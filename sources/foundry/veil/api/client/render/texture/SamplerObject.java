package foundry.veil.api.client.render.texture;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import java.nio.IntBuffer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL33C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/texture/SamplerObject.class */
public class SamplerObject implements NativeResource {

    /* JADX INFO: renamed from: id */
    private final int f9138id;

    private SamplerObject(int id) {
        this.f9138id = id;
    }

    public static SamplerObject create() {
        RenderSystem.assertOnRenderThreadOrInit();
        return new SamplerObject(VeilRenderSystem.directStateAccessSupported() ? ARBDirectStateAccess.glCreateSamplers() : GL33C.glGenSamplers());
    }

    public static SamplerObject[] create(int count) {
        SamplerObject[] fill = new SamplerObject[count];
        create(fill);
        return fill;
    }

    public static void create(SamplerObject[] fill) {
        RenderSystem.assertOnRenderThreadOrInit();
        if (fill.length == 0) {
            return;
        }
        boolean dsa = VeilRenderSystem.directStateAccessSupported();
        MemoryStack stack = MemoryStack.stackPush();
        try {
            IntBuffer samplers = stack.mallocInt(fill.length);
            if (dsa) {
                ARBDirectStateAccess.glCreateSamplers(samplers);
            } else {
                GL33C.glGenSamplers(samplers);
            }
            for (int i = 0; i < samplers.limit(); i++) {
                fill[i] = new SamplerObject(samplers.get(i));
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

    public void bind(int unit) {
        GL33C.glBindSampler(unit, this.f9138id);
    }

    public static void unbind(int unit) {
        GL33C.glBindSampler(unit, 0);
    }

    public int getId() {
        return this.f9138id;
    }

    public void setFilter(TextureFilter filter) {
        GL33C.glSamplerParameteri(this.f9138id, 10241, filter.minFilter());
        GL33C.glSamplerParameteri(this.f9138id, 10240, filter.magFilter());
        setAnisotropy(filter.anisotropy());
        setCompareFunc(filter.compareFunction());
        setWrap(filter.wrapX(), filter.wrapY(), filter.wrapZ());
        switch (filter.borderType()) {
            case FLOAT:
                setBorderColor(filter.borderColor());
                break;
            case INT:
                setBorderColorI(filter.borderColor());
                break;
            case UINT:
                setBorderColorUI(filter.borderColor());
                break;
        }
        setCubeMapSeamless(filter.seamless());
    }

    public void setFilter(boolean blur, boolean mipmap) {
        int minFilter;
        int magFilter;
        if (blur) {
            minFilter = mipmap ? 9987 : 9729;
            magFilter = 9729;
        } else {
            minFilter = mipmap ? 9986 : 9728;
            magFilter = 9728;
        }
        GL33C.glSamplerParameteri(this.f9138id, 10241, minFilter);
        GL33C.glSamplerParameteri(this.f9138id, 10240, magFilter);
    }

    public void setAnisotropy(float value) {
        if (VeilRenderSystem.textureAnisotropySupported()) {
            GL33C.glSamplerParameterf(this.f9138id, 34046, Math.min(value, VeilRenderSystem.maxTextureAnisotropy()));
        }
    }

    public void setCompareFunc(@Nullable TextureFilter.CompareFunction compareFunction) {
        if (compareFunction != null) {
            GL33C.glSamplerParameteri(this.f9138id, 34892, 34894);
            GL33C.glSamplerParameteri(this.f9138id, 34893, compareFunction.getId());
        } else {
            GL33C.glSamplerParameteri(this.f9138id, 34892, 0);
        }
    }

    public void setWrapX(TextureFilter.Wrap wrap) {
        GL33C.glSamplerParameteri(this.f9138id, 10242, wrap.getId());
    }

    public void setWrapY(TextureFilter.Wrap wrap) {
        GL33C.glSamplerParameteri(this.f9138id, 10243, wrap.getId());
    }

    public void setWrapZ(TextureFilter.Wrap wrap) {
        GL33C.glSamplerParameteri(this.f9138id, 32882, wrap.getId());
    }

    public void setWrap(TextureFilter.Wrap wrapX, TextureFilter.Wrap wrapY, TextureFilter.Wrap wrapZ) {
        GL33C.glSamplerParameteri(this.f9138id, 10242, wrapX.getId());
        GL33C.glSamplerParameteri(this.f9138id, 10243, wrapY.getId());
        GL33C.glSamplerParameteri(this.f9138id, 32882, wrapZ.getId());
    }

    public void setBorderColor(float red, float green, float blue, float alpha) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            GL33C.glSamplerParameterfv(this.f9138id, 4100, stack.floats(red, green, blue, alpha));
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

    public void setBorderColor(int red, int green, int blue, int alpha) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            GL33C.glSamplerParameteriv(this.f9138id, 4100, stack.ints(red, green, blue, alpha));
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

    public void setBorderColor(int color) {
        setBorderColor((color >> 16) & 255, (color >> 8) & 255, color & 255, (color >> 24) & 255);
    }

    public void setBorderColorI(int red, int green, int blue, int alpha) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            GL33C.glGetSamplerParameterIiv(this.f9138id, 4100, stack.ints(red, green, blue, alpha));
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

    public void setBorderColorI(int color) {
        setBorderColorI((color >> 16) & 255, (color >> 8) & 255, color & 255, (color >> 24) & 255);
    }

    public void setBorderColorUI(int red, int green, int blue, int alpha) {
        MemoryStack stack = MemoryStack.stackPush();
        try {
            GL33C.glGetSamplerParameterIuiv(this.f9138id, 4100, stack.ints(red, green, blue, alpha));
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

    public void setBorderColorUI(int color) {
        setBorderColorUI((color >> 16) & 255, (color >> 8) & 255, color & 255, (color >> 24) & 255);
    }

    public void setCubeMapSeamless(boolean seamless) {
        if (VeilRenderSystem.textureCubeMapSeamlessSupported()) {
            GL33C.glSamplerParameteri(this.f9138id, 34895, seamless ? 1 : 0);
        }
    }

    public void free() {
        GL33C.glDeleteSamplers(this.f9138id);
    }
}
