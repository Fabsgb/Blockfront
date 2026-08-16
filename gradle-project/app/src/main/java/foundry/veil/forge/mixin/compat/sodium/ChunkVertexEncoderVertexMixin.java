package foundry.veil.forge.mixin.compat.sodium;

import foundry.veil.ext.sodium.ChunkVertexEncoderVertexExtension;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/ChunkVertexEncoderVertexMixin.class */
@Mixin({ChunkVertexEncoder.Vertex.class})
public class ChunkVertexEncoderVertexMixin implements ChunkVertexEncoderVertexExtension {

    @Unique
    private int veil$packedNormal;

    @Override // foundry.veil.ext.sodium.ChunkVertexEncoderVertexExtension
    public int veil$getPackedNormal() {
        return this.veil$packedNormal;
    }

    @Override // foundry.veil.ext.sodium.ChunkVertexEncoderVertexExtension
    public void veil$setNormal(int packedNormal) {
        this.veil$packedNormal = packedNormal;
    }
}
