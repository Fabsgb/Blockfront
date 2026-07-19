package foundry.veil.forge.ext;

import java.util.Map;
import net.caffeinemc.mods.sodium.client.gl.shader.GlProgram;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderInterface;
import net.caffeinemc.mods.sodium.client.render.chunk.shader.ChunkShaderOptions;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/ext/ShaderChunkRendererExtension.class */
public interface ShaderChunkRendererExtension {
    void veil$recompile();

    void veil$setActiveBuffers(int i);

    Map<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> veil$getPrograms();
}
