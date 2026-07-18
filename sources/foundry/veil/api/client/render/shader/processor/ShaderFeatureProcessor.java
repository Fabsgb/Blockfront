package foundry.veil.api.client.render.shader.processor;

import foundry.veil.api.client.render.shader.ShaderFeature;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.api.client.render.shader.program.ProgramDefinition;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderFeatureProcessor.class */
public class ShaderFeatureProcessor implements ShaderPreProcessor {
    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        if (!(ctx instanceof ShaderPreProcessor.VeilContext)) {
            return;
        }
        ShaderPreProcessor.VeilContext veilContext = (ShaderPreProcessor.VeilContext) ctx;
        ProgramDefinition definition = veilContext.definition();
        if (definition == null) {
            return;
        }
        int type = ctx.type();
        for (ShaderFeature requiredFeature : definition.requiredFeatures()) {
            requiredFeature.modifyShader(type, tree);
        }
    }
}
