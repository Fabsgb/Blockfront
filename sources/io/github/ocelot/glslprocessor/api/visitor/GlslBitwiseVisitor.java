package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.node.expression.GlslBitwiseNode;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslBitwiseVisitor.class */
@ApiStatus.Experimental
public class GlslBitwiseVisitor {
    private final GlslBitwiseVisitor parent;

    public GlslBitwiseVisitor() {
        this(null);
    }

    public GlslBitwiseVisitor(@Nullable GlslBitwiseVisitor parent) {
        this.parent = parent;
    }

    @Nullable
    public GlslNodeVisitor visitNode(int index) {
        if (this.parent != null) {
            return this.parent.visitNode(index);
        }
        return null;
    }

    public void visitBitwiseExpressionEnd(GlslBitwiseNode node) {
        if (this.parent != null) {
            this.parent.visitBitwiseExpressionEnd(node);
        }
    }
}
