package io.github.ocelot.glslprocessor.api.node.variable;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/variable/GlslGetFieldNode.class */
public final class GlslGetFieldNode implements GlslNode {
    private GlslNode expression;
    private String fieldSelection;

    public GlslGetFieldNode(GlslNode expression, String fieldSelection) {
        this.expression = expression;
        this.fieldSelection = fieldSelection;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitGetField(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.GET_FIELD;
    }

    public GlslNode getExpression() {
        return this.expression;
    }

    public String getFieldSelection() {
        return this.fieldSelection;
    }

    public GlslGetFieldNode setExpression(GlslNode expression) {
        this.expression = expression;
        return this;
    }

    public GlslGetFieldNode setFieldSelection(String fieldSelection) {
        this.fieldSelection = fieldSelection;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.expression.stream());
    }

    public String toString() {
        return "GlslFieldNode{expression=" + this.expression + ", fieldSelection=" + this.fieldSelection + "}";
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslGetFieldNode that = (GlslGetFieldNode) o;
        return this.expression.equals(that.expression) && this.fieldSelection.equals(that.fieldSelection);
    }

    public int hashCode() {
        int result = this.expression.hashCode();
        return (31 * result) + this.fieldSelection.hashCode();
    }
}
