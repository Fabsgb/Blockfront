package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslTreeStringWriter.class */
public final class GlslTreeStringWriter extends GlslTreeVisitor {
    private final Map<GlslNode, String> markedNodes = new HashMap();
    private final GlslNodeStringWriter visitor = new GlslNodeStringWriter(false);
    private final StringBuilder builder = new StringBuilder();
    private String value = "";

    private String formatExpression(GlslNode node) {
        this.visitor.clear();
        node.visit(this.visitor);
        return this.visitor.toString();
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitMarkers(Map<String, GlslNode> markers) {
        for (Map.Entry<String, GlslNode> entry : markers.entrySet()) {
            this.markedNodes.put(entry.getValue(), entry.getKey());
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitVersion(GlslVersionStatement version) {
        this.builder.append("#version ").append(version.getVersionStatement()).append("\n");
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitDirective(String directive) {
        this.builder.append(directive).append('\n');
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitMacro(String key, String value) {
        this.builder.append("#define ").append(key).append(" ").append(value).append("\n");
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitNewField(GlslNewFieldNode node) {
        String marker = this.markedNodes.get(node);
        if (marker != null) {
            this.builder.append("/* #").append(marker).append(" */\n");
        }
        this.builder.append(formatExpression(node));
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitStructDeclaration(GlslStructDeclarationNode node) {
        String marker = this.markedNodes.get(node);
        if (marker != null) {
            this.builder.append("/* #").append(marker).append(" */\n");
        }
        this.builder.append(formatExpression(node));
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitDeclaration(GlslVariableDeclarationNode node) {
        String marker = this.markedNodes.get(node);
        if (marker != null) {
            this.builder.append("/* #").append(marker).append(" */\n");
        }
        this.builder.append(formatExpression(node));
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    @Nullable
    public GlslNodeVisitor visitFunction(GlslFunctionNode node) {
        String marker = this.markedNodes.get(node);
        if (marker != null) {
            this.builder.append("/* #").append(marker).append(" */\n");
        }
        this.visitor.clear();
        this.visitor.visitFunctionDeclaration(node);
        node.visit(this.visitor.indent());
        this.visitor.visitFunctionDeclarationEnd(node);
        this.builder.append(this.visitor);
        return null;
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
    public void visitTreeEnd(GlslTree tree) {
        this.markedNodes.clear();
        this.value = this.builder.toString();
        this.builder.setLength(0);
    }

    public String toString() {
        return this.value;
    }
}
