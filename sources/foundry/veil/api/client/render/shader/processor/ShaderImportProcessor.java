package foundry.veil.api.client.render.shader.processor;

import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/shader/processor/ShaderImportProcessor.class */
public class ShaderImportProcessor implements ShaderPreProcessor {
    private static final String INCLUDE_KEY = "#include ";

    public static String sanitizeLocation(String location) {
        if ((location.startsWith("\"") && location.endsWith("\"")) || ((location.startsWith("'") && location.endsWith("'")) || (location.startsWith("<") && location.endsWith(">")))) {
            return location.substring(1, location.length() - 1);
        }
        return location;
    }

    @Override // foundry.veil.api.client.render.shader.processor.ShaderPreProcessor
    public void modify(ShaderPreProcessor.Context ctx, GlslTree tree) throws IOException, GlslSyntaxException, LexerException {
        List<String> imports = new ArrayList<>();
        List<String> directives = tree.getDirectives();
        for (String directive : directives) {
            if (directive.startsWith(INCLUDE_KEY)) {
                imports.add(directive);
            }
        }
        Iterator<String> it = imports.iterator();
        while (it.hasNext()) {
            String importId = sanitizeLocation(it.next().substring(INCLUDE_KEY.length()).trim());
            try {
                ctx.include(tree, ResourceLocation.parse(importId), ShaderPreProcessor.IncludeOverloadStrategy.SOURCE);
            } catch (ResourceLocationException e) {
                throw new IOException("Invalid import: " + importId, e);
            }
        }
        directives.removeAll(imports);
    }
}
