package foundry.veil.impl.client.render.shader.block;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBDirectStateAccess;
import org.lwjgl.opengl.GL15C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/block/ShaderBlockImpl.class */
@ApiStatus.Internal
public abstract class ShaderBlockImpl<T> implements ShaderBlock<T> {
    private static StorageType storageType;
    protected final ShaderBlock.BufferBinding binding;
    protected int buffer = 0;
    protected T value = null;
    protected boolean dirty = false;
    private int index = -1;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/block/ShaderBlockImpl$StorageType.class */
    public enum StorageType {
        LEGACY { // from class: foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType.1
            @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType
            public int createBuffer(int binding) {
                return GL15C.glGenBuffers();
            }

            @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType
            public void resize(int binding, int buffer, long size) {
                RenderSystem.glBindBuffer(binding, buffer);
                GL15C.glBufferData(binding, size, 35048);
            }

            @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType
            public void write(int binding, int buffer, ByteBuffer upload) {
                RenderSystem.glBindBuffer(binding, buffer);
                GL15C.glBufferSubData(binding, 0L, upload);
            }
        },
        DSA { // from class: foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType.2
            @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType
            public int createBuffer(int binding) {
                return ARBDirectStateAccess.glCreateBuffers();
            }

            @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType
            public void resize(int binding, int buffer, long size) {
                ARBDirectStateAccess.glNamedBufferData(buffer, size, 35048);
            }

            @Override // foundry.veil.impl.client.render.shader.block.ShaderBlockImpl.StorageType
            public void write(int binding, int buffer, ByteBuffer upload) {
                ARBDirectStateAccess.glNamedBufferSubData(buffer, 0L, upload);
            }
        };

        public abstract int createBuffer(int i);

        public abstract void resize(int i, int i2, long j);

        public abstract void write(int i, int i2, ByteBuffer byteBuffer);
    }

    public abstract void bind(int i);

    public abstract void unbind(int i);

    protected ShaderBlockImpl(ShaderBlock.BufferBinding binding) {
        this.binding = binding;
    }

    protected static StorageType getStorageType() {
        if (storageType == null) {
            storageType = VeilRenderSystem.directStateAccessSupported() ? StorageType.DSA : StorageType.LEGACY;
        }
        return storageType;
    }

    @Override // foundry.veil.api.client.render.shader.block.ShaderBlock
    public void set(@Nullable T value) {
        this.value = value;
        this.dirty = true;
    }

    public ShaderBlock.BufferBinding getBinding() {
        return this.binding;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // foundry.veil.api.client.render.shader.block.ShaderBlock
    @Nullable
    public T getValue() {
        return this.value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void free() {
        VeilRenderSystem.unbind(this);
        if (this.buffer != 0) {
            GlStateManager._glDeleteBuffers(this.buffer);
            this.buffer = 0;
        }
    }
}
