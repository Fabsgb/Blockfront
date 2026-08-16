package foundry.veil.api.client.render.shader.block;

import foundry.veil.impl.client.render.shader.block.DynamicShaderBlockImpl;
import foundry.veil.impl.client.render.shader.block.SizedShaderBlockImpl;
import foundry.veil.impl.client.render.shader.block.WrapperShaderBlockImpl;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Objects;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/block/ShaderBlock.class */
public interface ShaderBlock<T> extends NativeResource {
    void set(@Nullable T t);

    @Nullable
    T getValue();

    static <T> ShaderBlock<T> withSize(BufferBinding binding, int size, BiConsumer<T, ByteBuffer> serializer) {
        return new SizedShaderBlockImpl(binding, size, serializer);
    }

    static <T> DynamicShaderBlock<T> dynamic(BufferBinding binding, BiConsumer<T, ByteBuffer> serializer) {
        return dynamic(binding, 256, serializer);
    }

    static <T> DynamicShaderBlock<T> dynamic(BufferBinding binding, int initialSize, BiConsumer<T, ByteBuffer> serializer) {
        return new DynamicShaderBlockImpl(binding, initialSize, serializer);
    }

    static DynamicShaderBlock<?> wrapper(BufferBinding binding, int buffer) {
        return new WrapperShaderBlockImpl(binding, buffer);
    }

    default void update(@Nullable T value) {
        if (!Objects.equals(getValue(), value)) {
            set(value);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/block/ShaderBlock$BufferBinding.class */
    public enum BufferBinding {
        UNIFORM(35345),
        SHADER_STORAGE(37074);

        private final int glType;

        BufferBinding(int glType) {
            this.glType = glType;
        }

        public int getGlType() {
            return this.glType;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/block/ShaderBlock$MemoryLayout.class */
    public enum MemoryLayout {
        PACKED,
        SHARED,
        STD140,
        STD430;

        private final GlslTypeQualifier.LayoutId layoutId = new GlslTypeQualifier.LayoutId(name().toLowerCase(Locale.ROOT), null);

        MemoryLayout() {
        }

        public GlslTypeQualifier.LayoutId getLayoutId() {
            return this.layoutId;
        }
    }
}
