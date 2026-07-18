package foundry.veil.impl.client.render.shader.block;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import foundry.veil.impl.client.render.shader.block.ShaderBlockImpl;
import java.nio.ByteBuffer;
import java.util.function.BiConsumer;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/block/SizedShaderBlockImpl.class */
@ApiStatus.Internal
public class SizedShaderBlockImpl<T> extends ShaderBlockImpl<T> {
    private final int size;
    private final ByteBuffer upload;
    private final BiConsumer<T, ByteBuffer> serializer;

    public SizedShaderBlockImpl(ShaderBlock.BufferBinding binding, int size, BiConsumer<T, ByteBuffer> serializer) {
        super(binding);
        this.size = size;
        this.upload = MemoryUtil.memAlloc(this.size);
        this.serializer = serializer;
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void bind(int index) {
        int binding = this.binding.getGlType();
        Validate.inclusiveBetween(0L, VeilRenderSystem.maxTargetBindings(binding), index);
        if (this.buffer == 0) {
            this.dirty = true;
            ShaderBlockImpl.StorageType storageType = getStorageType();
            this.buffer = storageType.createBuffer(binding);
            storageType.resize(binding, this.buffer, this.size);
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
