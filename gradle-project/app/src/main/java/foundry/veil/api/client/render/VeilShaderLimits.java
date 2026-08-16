package foundry.veil.api.client.render;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/VeilShaderLimits.class */
public final class VeilShaderLimits extends Record {
    private final int maxUniformComponents;
    private final int maxUniformBlocks;
    private final int maxInputComponents;
    private final int maxOutputComponents;
    private final int maxTextureImageUnits;
    private final int maxImageUniforms;
    private final int maxAtomicCounters;
    private final int maxAtomicCountBuffers;
    private final int maxShaderStorageBlocks;

    public VeilShaderLimits(int maxUniformComponents, int maxUniformBlocks, int maxInputComponents, int maxOutputComponents, int maxTextureImageUnits, int maxImageUniforms, int maxAtomicCounters, int maxAtomicCountBuffers, int maxShaderStorageBlocks) {
        this.maxUniformComponents = maxUniformComponents;
        this.maxUniformBlocks = maxUniformBlocks;
        this.maxInputComponents = maxInputComponents;
        this.maxOutputComponents = maxOutputComponents;
        this.maxTextureImageUnits = maxTextureImageUnits;
        this.maxImageUniforms = maxImageUniforms;
        this.maxAtomicCounters = maxAtomicCounters;
        this.maxAtomicCountBuffers = maxAtomicCountBuffers;
        this.maxShaderStorageBlocks = maxShaderStorageBlocks;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, VeilShaderLimits.class), VeilShaderLimits.class, "maxUniformComponents;maxUniformBlocks;maxInputComponents;maxOutputComponents;maxTextureImageUnits;maxImageUniforms;maxAtomicCounters;maxAtomicCountBuffers;maxShaderStorageBlocks", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxUniformComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxUniformBlocks:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxInputComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxOutputComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxTextureImageUnits:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxImageUniforms:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxAtomicCounters:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxAtomicCountBuffers:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxShaderStorageBlocks:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VeilShaderLimits.class), VeilShaderLimits.class, "maxUniformComponents;maxUniformBlocks;maxInputComponents;maxOutputComponents;maxTextureImageUnits;maxImageUniforms;maxAtomicCounters;maxAtomicCountBuffers;maxShaderStorageBlocks", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxUniformComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxUniformBlocks:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxInputComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxOutputComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxTextureImageUnits:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxImageUniforms:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxAtomicCounters:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxAtomicCountBuffers:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxShaderStorageBlocks:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VeilShaderLimits.class, Object.class), VeilShaderLimits.class, "maxUniformComponents;maxUniformBlocks;maxInputComponents;maxOutputComponents;maxTextureImageUnits;maxImageUniforms;maxAtomicCounters;maxAtomicCountBuffers;maxShaderStorageBlocks", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxUniformComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxUniformBlocks:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxInputComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxOutputComponents:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxTextureImageUnits:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxImageUniforms:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxAtomicCounters:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxAtomicCountBuffers:I", "FIELD:Lfoundry/veil/api/client/render/VeilShaderLimits;->maxShaderStorageBlocks:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int maxUniformComponents() {
        return this.maxUniformComponents;
    }

    public int maxUniformBlocks() {
        return this.maxUniformBlocks;
    }

    public int maxInputComponents() {
        return this.maxInputComponents;
    }

    public int maxOutputComponents() {
        return this.maxOutputComponents;
    }

    public int maxTextureImageUnits() {
        return this.maxTextureImageUnits;
    }

    public int maxImageUniforms() {
        return this.maxImageUniforms;
    }

    public int maxAtomicCounters() {
        return this.maxAtomicCounters;
    }

    public int maxAtomicCountBuffers() {
        return this.maxAtomicCountBuffers;
    }

    public int maxShaderStorageBlocks() {
        return this.maxShaderStorageBlocks;
    }

    public VeilShaderLimits(GLCapabilities caps, int maxUniformComponents, int maxUniformBlocks, int maxInputComponents, int maxOutputComponents, int maxTextureImageUnits, int maxImageUniforms, int maxAtomicCounters, int maxAtomicCountBuffers, int maxShaderStorageBlocks) {
        this(maxUniformComponents, maxUniformBlocks, maxInputComponents, maxOutputComponents, maxTextureImageUnits, (caps.OpenGL42 || caps.GL_ARB_shader_image_load_store) ? GL11C.glGetInteger(maxImageUniforms) : 0, (caps.OpenGL42 || caps.GL_ARB_shader_atomic_counters) ? GL11C.glGetInteger(maxAtomicCounters) : 0, (caps.OpenGL42 || caps.GL_ARB_shader_atomic_counters) ? GL11C.glGetInteger(maxAtomicCountBuffers) : 0, (caps.OpenGL43 || caps.GL_ARB_shader_storage_buffer_object) ? GL11C.glGetInteger(maxShaderStorageBlocks) : 0);
    }
}
