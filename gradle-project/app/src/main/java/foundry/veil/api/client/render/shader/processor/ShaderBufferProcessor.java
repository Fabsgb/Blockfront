package foundry.veil.api.client.render.shader.processor;

import foundry.veil.api.client.registry.VeilShaderBufferRegistry;
import foundry.veil.api.client.render.VeilShaderBufferLayout;
import foundry.veil.api.client.render.shader.ShaderFeature;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderBufferProcessor.class */
public class ShaderBufferProcessor implements ShaderPreProcessor {
    private static final String BUFFER_KEY = "#veil:buffer ";

    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        List<String> buffers = new ArrayList<>();
        List<String> directives = tree.getDirectives();
        for (String directive : directives) {
            if (directive.startsWith(BUFFER_KEY)) {
                buffers.add(directive);
            }
        }
        Iterator<String> it = buffers.iterator();
        while (it.hasNext()) {
            String[] parts = it.next().substring(BUFFER_KEY.length()).trim().split(" +", 2);
            String bufferId = parts[0].trim();
            String interfaceName = parts.length > 1 ? parts[1].trim() : null;
            try {
                ResourceLocation name = ResourceLocation.parse(bufferId);
                VeilShaderBufferLayout<?> layout = (VeilShaderBufferLayout) VeilShaderBufferRegistry.REGISTRY.get(name);
                if (layout == null) {
                    throw new IOException("Unknown buffer: " + String.valueOf(name));
                }
                GlslTree loadedImport = new GlslTree();
                loadedImport.getBody().add(layout.createNode(ctx.hasFeatures(ShaderFeature.SHADER_STORAGE), interfaceName));
                ctx.include(tree, "#buffer " + String.valueOf(name), loadedImport, ShaderPreProcessor.IncludeOverloadStrategy.INCLUDE);
            } catch (ResourceLocationException e) {
                throw new IOException("Invalid buffer: " + bufferId, e);
            }
        }
        directives.removeAll(buffers);
    }
}
