package foundry.veil.impl.client.render.pipeline;

import foundry.veil.Veil;
import foundry.veil.api.client.registry.VeilShaderBufferRegistry;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.VeilShaderBufferLayout;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.impl.client.render.LayoutSerializer;
import foundry.veil.impl.client.render.shader.block.LayoutShaderBlockImpl;
import foundry.veil.impl.client.render.shader.program.ShaderProgramImpl;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/pipeline/VeilShaderBufferCache.class */
@ApiStatus.Internal
public class VeilShaderBufferCache implements NativeResource {
    private LayoutShaderBlockImpl<?>[] values;
    private VeilShaderBufferLayout<?>[] layouts;

    public void onShaderCompile(Map<ResourceLocation, ShaderProgram> updatedPrograms) {
        LayoutShaderBlockImpl<?> block;
        int storageBlock;
        if (this.layouts == null) {
            this.layouts = (VeilShaderBufferLayout[]) VeilShaderBufferRegistry.REGISTRY.stream().toArray(x$0 -> {
                return new VeilShaderBufferLayout[x$0];
            });
            this.values = new LayoutShaderBlockImpl[this.layouts.length];
        }
        for (ShaderProgram shader : updatedPrograms.values()) {
            if (shader instanceof ShaderProgramImpl) {
                ShaderProgramImpl impl = (ShaderProgramImpl) shader;
                impl.clearShaderBlocks();
            }
        }
        for (int i = 0; i < this.values.length; i++) {
            LayoutShaderBlockImpl<?> block2 = this.values[i];
            if (block2 != null) {
                Set<ResourceLocation> shaders = block2.getReferencedShaders();
                if (shaders.removeAll(updatedPrograms.keySet()) && shaders.isEmpty()) {
                    block2.free();
                    this.values[i] = null;
                }
            }
            VeilShaderBufferLayout<?> layout = this.layouts[i];
            boolean packed = layout.memoryLayout() == ShaderBlock.MemoryLayout.PACKED;
            String name = layout.name();
            for (ShaderProgram shader2 : updatedPrograms.values()) {
                switch (layout.binding()) {
                    case UNIFORM:
                        storageBlock = shader2.getUniformBlock(name);
                        break;
                    case SHADER_STORAGE:
                        storageBlock = shader2.getStorageBlock(name);
                        break;
                    default:
                        throw new MatchException((String) null, (Throwable) null);
                }
                int index = storageBlock;
                if (index != -1) {
                    if (this.values[i] == null) {
                        LayoutShaderBlockImpl<?> block3 = LayoutSerializer.create(layout, shader2, name, index);
                        block3.getReferencedShaders().add(shader2.getName());
                        this.values[i] = block3;
                        if (packed && (shader2 instanceof ShaderProgramImpl)) {
                            ShaderProgramImpl impl2 = (ShaderProgramImpl) shader2;
                            impl2.addShaderBlock(name, block3);
                        }
                    } else {
                        this.values[i].getReferencedShaders().add(shader2.getName());
                    }
                    if (!packed && (block = this.values[i]) != null) {
                        Set<ResourceLocation> shaders2 = block.getReferencedShaders();
                        if (shaders2.size() != 1) {
                            String error = (String) shaders2.stream().map((v0) -> {
                                return v0.toString();
                            }).collect(Collectors.joining(", "));
                            Veil.LOGGER.error("Shader Block {} uses the 'packed' memory layout and only supports a single shader using the block. Either use a different format or only use the block in one shader. Affected shaders: {}", name, error);
                        }
                    }
                }
            }
            if (!packed) {
            }
        }
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
