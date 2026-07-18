package foundry.veil.api.client.render.shader.processor;

import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import org.lwjgl.opengl.GLCapabilities;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/processor/ShaderVersionProcessor.class */
public class ShaderVersionProcessor implements ShaderPreProcessor {
    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        GlslVersionStatement version = tree.getVersionStatement();
        if (version.getVersion() == 110 && version.isCore()) {
            GLCapabilities caps = ctx.glCapabilities();
            if (caps.OpenGL41) {
                version.setVersion(410);
            } else {
                version.setVersion(330);
            }
        }
    }
}
