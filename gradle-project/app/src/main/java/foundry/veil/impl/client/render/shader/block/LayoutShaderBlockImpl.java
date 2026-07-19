package foundry.veil.impl.client.render.shader.block;

import foundry.veil.api.client.render.shader.block.ShaderBlock;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/block/LayoutShaderBlockImpl.class */
@ApiStatus.Internal
public class LayoutShaderBlockImpl<T> extends SizedShaderBlockImpl<T> {
    private final Set<ResourceLocation> referencedShaders;

    public LayoutShaderBlockImpl(ShaderBlock.BufferBinding binding, int size, BiConsumer<T, ByteBuffer> serializer) {
        super(binding, size, serializer);
        this.referencedShaders = new HashSet();
    }

    public Set<ResourceLocation> getReferencedShaders() {
        return this.referencedShaders;
    }
}
