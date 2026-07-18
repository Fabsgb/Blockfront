package foundry.veil.mixin.rendertype.accessor;

import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import java.util.SequencedMap;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/mixin/rendertype/accessor/RenderTypeBufferSourceAccessor.class */
@Mixin({MultiBufferSource.BufferSource.class})
public interface RenderTypeBufferSourceAccessor {
    @Accessor
    SequencedMap<RenderType, ByteBufferBuilder> getFixedBuffers();
}
