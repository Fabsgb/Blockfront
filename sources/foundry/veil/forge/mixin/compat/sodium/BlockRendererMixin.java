package foundry.veil.forge.mixin.compat.sodium;

import com.llamalad7.mixinextras.sugar.Local;
import foundry.veil.ext.sodium.ChunkVertexEncoderVertexExtension;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.Material;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexEncoder;
import net.caffeinemc.mods.sodium.client.render.frapi.mesh.MutableQuadViewImpl;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/mixin/compat/sodium/BlockRendererMixin.class */
@Mixin({BlockRenderer.class})
public class BlockRendererMixin {

    @Shadow
    @Final
    private ChunkVertexEncoder.Vertex[] vertices;

    @Inject(method = {"bufferQuad"}, at = {@At(value = "INVOKE", target = "Lnet/caffeinemc/mods/sodium/client/render/frapi/mesh/MutableQuadViewImpl;lightmap(I)I")}, remap = false)
    public void bufferNormal(MutableQuadViewImpl quad, float[] brightnesses, Material material, CallbackInfo ci, @Local(ordinal = 0) int dstIndex, @Local(ordinal = 1) int srcIndex) {
        ChunkVertexEncoderVertexExtension chunkVertexEncoderVertexExtension = this.vertices[dstIndex];
        int packedNormal = quad.packedNormal(srcIndex);
        chunkVertexEncoderVertexExtension.veil$setNormal(packedNormal);
    }
}
