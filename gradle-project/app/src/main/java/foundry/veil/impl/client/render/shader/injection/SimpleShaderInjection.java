package foundry.veil.impl.client.render.shader.injection;

import foundry.veil.impl.client.render.shader.injection.util.ShaderInjection;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionFunction;
import io.github.ocelot.glslprocessor.api.GlslParser;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/SimpleShaderInjection.class */
@ApiStatus.Internal
public class SimpleShaderInjection implements ShaderInjection {
    private final int version;
    private final int priority;
    private final ShaderInjectionFunction[] functions;
    private final String globals;

    public SimpleShaderInjection(int version, int priority, ShaderInjectionFunction[] functions) {
        this(version, priority, functions, null);
    }

    public SimpleShaderInjection(int version, int priority, ShaderInjectionFunction[] functions, @Nullable String globals) {
        this.version = version;
        this.priority = priority;
        this.functions = functions;
        this.globals = globals;
    }

    @Override // foundry.veil.impl.client.render.shader.injection.util.ShaderInjection
    public void inject(GlslTree tree, boolean applyVersion) throws GlslSyntaxException, IOException {
        if (applyVersion && this.version >= 0) {
            GlslVersionStatement version = tree.getVersionStatement();
            if (version.getVersion() < this.version) {
                version.setVersion(this.version);
            }
        }
        if (this.globals != null && !this.globals.isEmpty()) {
            tree.getBody().addAll(0, GlslParser.parse(this.globals).getBody());
        }
        for (ShaderInjectionFunction function : this.functions) {
            String name = function.name();
            List<GlslNode> body = (List) tree.functions().filter(definition -> {
                if (definition == null || definition.getBody() == null || !name.equals(definition.getName())) {
                    return false;
                }
                int paramCount = function.parameters();
                return paramCount == -1 || definition.getHeader().getParameters().size() == paramCount;
            }).findFirst().map((v0) -> {
                return v0.getBody();
            }).orElseThrow(() -> {
                int paramCount = function.parameters();
                if (paramCount == -1) {
                    return new IOException("Unknown function: " + name);
                }
                return new IOException("Unknown function with " + paramCount + " parameters: " + name);
            });
            for (GlslNode node : GlslParser.parseExpressionList(function.code())) {
                if (function.head()) {
                    body.addFirst(node);
                } else {
                    body.add(node);
                }
            }
        }
    }

    @Override // foundry.veil.impl.client.render.shader.injection.util.ShaderInjection
    public int priority() {
        return this.priority;
    }

    public ShaderInjectionFunction[] getShaderInjectionFunctions() {
        return this.functions;
    }
}
