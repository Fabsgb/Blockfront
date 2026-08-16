package foundry.veil.forge.mixin.compat.sodium;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.caffeinemc.mods.sodium.api.util.NormI8;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.buffers.ChunkVertexConsumer;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexEncoder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/ChunkVertexConsumerMixin.class */
@Mixin({ChunkVertexConsumer.class})
public class ChunkVertexConsumerMixin {

    @Shadow
    @Final
    private ChunkVertexEncoder.Vertex[] vertices;

    @Shadow
    private int vertexIndex;

    @Inject(method = {"setNormal"}, at = {@At("HEAD")})
    public void setNormal(float x, float y, float z, CallbackInfoReturnable<VertexConsumer> cir) {
        this.vertices[this.vertexIndex].veil$setNormal(NormI8.pack(x, y, z));
    }
}
