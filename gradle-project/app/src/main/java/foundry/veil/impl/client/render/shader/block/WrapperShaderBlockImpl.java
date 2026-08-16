package foundry.veil.impl.client.render.shader.block;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.block.DynamicShaderBlock;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL30C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/block/WrapperShaderBlockImpl.class */
@ApiStatus.Internal
public class WrapperShaderBlockImpl extends ShaderBlockImpl<Object> implements DynamicShaderBlock<Object> {
    private int size;

    public WrapperShaderBlockImpl(ShaderBlock.BufferBinding binding, int buffer) {
        super(binding);
        this.buffer = buffer;
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void bind(int index) {
        int binding = this.binding.getGlType();
        Validate.inclusiveBetween(0L, VeilRenderSystem.maxTargetBindings(binding), index);
        GL30C.glBindBufferRange(binding, index, this.buffer, 0L, this.size);
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void unbind(int index) {
        int binding = this.binding.getGlType();
        Validate.inclusiveBetween(0L, VeilRenderSystem.maxTargetBindings(binding), index);
        GL30C.glBindBufferRange(binding, index, 0, 0L, this.size);
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl, foundry.veil.api.client.render.shader.block.ShaderBlock
    public void set(@Nullable Object value) {
        throw new UnsupportedOperationException("Wrapper Shader Block cannot be set to a java object");
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl, foundry.veil.api.client.render.shader.block.ShaderBlock
    @Nullable
    public Object getValue() {
        throw new UnsupportedOperationException("Wrapper Shader Block cannot be read as a java object");
    }

    @Override // foundry.veil.api.client.render.shader.block.DynamicShaderBlock
    public int getSize() {
        return this.size;
    }

    @Override // foundry.veil.api.client.render.shader.block.DynamicShaderBlock
    public void setSize(int newSize) {
        this.size = newSize;
    }

    @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl
    public void free() {
        VeilRenderSystem.unbind(this);
    }
}
