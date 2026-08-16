package foundry.veil.forge.mixin.compat.sodium;

import foundry.veil.forge.compat.sodium.VeilChunkVertex;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkMeshFormats;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/mixin/compat/sodium/ChunkMeshFormatsMixin.class */
@Mixin({ChunkMeshFormats.class})
public class ChunkMeshFormatsMixin {

    @Mutable
    @Shadow
    @Final
    public static ChunkVertexType COMPACT;

    @Inject(method = {"<clinit>"}, at = {@At("TAIL")})
    private static void clinit(CallbackInfo ci) {
        COMPACT = new VeilChunkVertex();
    }
}
