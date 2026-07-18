package foundry.veil.api.client.render.shader.processor;

import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.io.IOException;
import java.util.Collection;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderImporter.class */
public interface ShaderImporter {
    GlslTree loadImport(ShaderPreProcessor.Context context, ResourceLocation resourceLocation, boolean z) throws IOException;

    Collection<ResourceLocation> addedImports();
}
