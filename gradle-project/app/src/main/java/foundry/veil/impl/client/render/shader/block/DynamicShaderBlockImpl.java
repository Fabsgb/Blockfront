package foundry.veil.impl.client.render.shader.block;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.block.DynamicShaderBlock;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import java.nio.ByteBuffer;
import java.util.function.BiConsumer;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/block/DynamicShaderBlockImpl.class */
@ApiStatus.Internal
public class DynamicShaderBlockImpl<T> extends ShaderBlockImpl<T> implements DynamicShaderBlock<T> {
    private final BiConsumer<T, ByteBuffer> serializer;
    private int size;
    private boolean resized;
    private ByteBuffer upload;

    public DynamicShaderBlockImpl(ShaderBlock.BufferBinding binding, int initialSize, BiConsumer<T, ByteBuffer> serializer) {
        super(binding);
        this.serializer = serializer;
        this.size = initialSize;
        this.resized = false;
        this.upload = MemoryUtil.memAlloc(initialSize);
    }

    @Override // foundry.veil.api.client.render.shader.block.DynamicShaderBlock
    public int getSize() {
        return this.size;
    }

    @Override // foundry.veil.api.client.render.shader.block.DynamicShaderBlock
    public void setSize(int size) {
        this.size = size;
        this.resized = true;
        this.upload = MemoryUtil.memRealloc(this.upload, size);
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void bind(int index) {
        int binding = this.binding.getGlType();
        Validate.inclusiveBetween(0L, VeilRenderSystem.maxTargetBindings(binding), index);
        if (this.buffer == 0) {
            this.resized = true;
            this.buffer = getStorageType().createBuffer(binding);
        }
        if (this.resized) {
            this.resized = false;
            this.dirty = true;
            getStorageType().resize(binding, this.buffer, this.size);
        }
        if (this.dirty) {
            this.dirty = false;
            if (this.value != null) {
                this.serializer.accept(this.value, this.upload);
                this.upload.rewind();
            } else {
                MemoryUtil.memSet(this.upload, 0);
            }
            getStorageType().write(binding, this.buffer, this.upload);
        }
        GL30C.glBindBufferBase(binding, index, this.buffer);
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void unbind(int index) {
        int binding = this.binding.getGlType();
        Validate.inclusiveBetween(0L, VeilRenderSystem.maxTargetBindings(binding), index);
        GL30C.glBindBufferBase(binding, index, 0);
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void free() {
        super.free();
        MemoryUtil.memFree(this.upload);
    }
}
