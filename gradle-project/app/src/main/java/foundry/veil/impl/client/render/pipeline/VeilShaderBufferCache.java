package foundry.veil.impl.client.render.pipeline;

import foundry.veil.api.client.registry.VeilShaderBufferRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilShaderBufferLayout;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.impl.client.render.shader.block.LayoutShaderBlockImpl;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/pipeline/VeilShaderBufferCache.class */
@ApiStatus.Internal
public class VeilShaderBufferCache implements NativeResource {
    private LayoutShaderBlockImpl<?>[] values;
    private VeilShaderBufferLayout<?>[] layouts;

    /* JADX WARN: Code restructure failed: missing block: B:48:0x019d, code lost:
    
        if (r10 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01a0, code lost:
    
        r0 = r5.values[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01a8, code lost:
    
        if (r0 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ae, code lost:
    
        r0 = r0.getReferencedShaders();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01bc, code lost:
    
        if (r0.size() == 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01bf, code lost:
    
        r0 = (java.lang.String) r0.stream().map((v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
            return v0.toString();
        }).collect(java.util.stream.Collectors.joining(", "));
        foundry.veil.Veil.LOGGER.error("Shader Block {} uses the 'packed' memory layout and only supports a single shader using the block. Either use a different format or only use the block in one shader. Affected shaders: {}", r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ed, code lost:
    
        r7 = r7 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onShaderCompile(java.util.Map<net.minecraft.resources.ResourceLocation, foundry.veil.api.client.render.shader.program.ShaderProgram> r6) {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.impl.client.render.pipeline.VeilShaderBufferCache.onShaderCompile(java.util.Map):void");
    }

    public void bind() {
        if (this.values == null) {
            return;
        }
        for (int i = 0; i < this.values.length; i++) {
            LayoutShaderBlockImpl<?> block = this.values[i];
            if (block != null && this.layouts[i].memoryLayout() != ShaderBlock.MemoryLayout.PACKED) {
                VeilRenderSystem.bind(this.layouts[i].name(), block);
            }
        }
    }

    public void unbindPacked() {
        if (this.values == null) {
            return;
        }
        for (int i = 0; i < this.values.length; i++) {
            LayoutShaderBlockImpl<?> block = this.values[i];
            if (block != null && this.layouts[i].memoryLayout() == ShaderBlock.MemoryLayout.PACKED) {
                VeilRenderSystem.unbind(block);
            }
        }
    }

    @Nullable
    public <T> ShaderBlock<T> getBlock(VeilShaderBufferLayout<T> layout) throws IllegalArgumentException {
        if (this.values == null) {
            return null;
        }
        int id = VeilShaderBufferRegistry.REGISTRY.getId(layout);
        if (id < 0 || id >= this.values.length) {
            throw new IllegalArgumentException("Attempted to use unregistered buffer layout: " + layout.name());
        }
        return this.values[id];
    }

    public void bind(VeilShaderBufferLayout<?> layout) throws IllegalArgumentException {
        if (this.values == null) {
            return;
        }
        int id = VeilShaderBufferRegistry.REGISTRY.getId(layout);
        if (id < 0 || id >= this.values.length) {
            throw new IllegalArgumentException("Attempted to use unregistered buffer layout: " + layout.name());
        }
        LayoutShaderBlockImpl<?> block = this.values[id];
        if (block != null) {
            VeilRenderSystem.bind(this.layouts[id].name(), block);
        }
    }

    public void unbind(VeilShaderBufferLayout<?> layout) throws IllegalArgumentException {
        if (this.values == null) {
            return;
        }
        int id = VeilShaderBufferRegistry.REGISTRY.getId(layout);
        if (id < 0 || id >= this.values.length) {
            throw new IllegalArgumentException("Attempted to use unregistered buffer layout: " + layout.name());
        }
        LayoutShaderBlockImpl<?> block = this.values[id];
        if (block != null) {
            VeilRenderSystem.unbind(block);
        }
    }

    public void free() {
        if (this.values != null) {
            for (int i = 0; i < this.values.length; i++) {
                LayoutShaderBlockImpl<?> block = this.values[i];
                if (block != null) {
                    block.free();
                }
                this.values[i] = null;
            }
        }
    }
}
