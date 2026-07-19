package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslTreeVisitor.class */
@ApiStatus.Experimental
public class GlslTreeVisitor {
    private final GlslTreeVisitor parent;

    public GlslTreeVisitor() {
        this(null);
    }

    public GlslTreeVisitor(@Nullable GlslTreeVisitor parent) {
        this.parent = parent;
    }

    public void visitMarkers(Map<String, GlslNode> markers) {
        if (this.parent != null) {
            this.parent.visitMarkers(markers);
        }
    }

    public void visitVersion(GlslVersionStatement version) {
        if (this.parent != null) {
            this.parent.visitVersion(version);
        }
    }

    public void visitDirective(String directive) {
        if (this.parent != null) {
            this.parent.visitDirective(directive);
        }
    }

    public void visitMacro(String key, String value) {
        if (this.parent != null) {
            this.parent.visitMacro(key, value);
        }
    }

    public void visitNewField(GlslNewFieldNode node) {
        if (this.parent != null) {
            this.parent.visitNewField(node);
        }
    }

    public void visitStructDeclaration(GlslStructDeclarationNode node) {
        if (this.parent != null) {
            this.parent.visitStructDeclaration(node);
        }
    }

    public void visitDeclaration(GlslVariableDeclarationNode node) {
        if (this.parent != null) {
            this.parent.visitDeclaration(node);
        }
    }

    @Nullable
    public GlslNodeVisitor visitFunction(GlslFunctionNode node) {
        if (this.parent != null) {
            return this.parent.visitFunction(node);
        }
        return null;
    }

    public void visitFunctionEnd(GlslFunctionNode node) {
        if (this.parent != null) {
            this.parent.visitFunctionEnd(node);
        }
    }

    public void visitTreeEnd(GlslTree tree) {
        if (this.parent != null) {
            this.parent.visitTreeEnd(tree);
        }
    }
}
