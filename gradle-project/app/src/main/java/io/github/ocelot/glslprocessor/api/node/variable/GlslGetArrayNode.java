package io.github.ocelot.glslprocessor.api.node.variable;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/variable/GlslGetArrayNode.class */
public final class GlslGetArrayNode implements GlslNode {
    private GlslNode expression;
    private GlslNode index;

    public GlslGetArrayNode(GlslNode expression, GlslNode index) {
        this.expression = expression;
        this.index = index;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitGetArray(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.GET_ARRAY;
    }

    public GlslNode getExpression() {
        return this.expression;
    }

    public GlslNode getIndex() {
        return this.index;
    }

    public GlslGetArrayNode setExpression(GlslNode expression) {
        this.expression = expression;
        return this;
    }

    public GlslGetArrayNode setIndex(GlslNode index) {
        this.index = index;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), Stream.concat(this.expression.stream(), this.index.stream()));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslGetArrayNode that = (GlslGetArrayNode) o;
        return this.expression.equals(that.expression) && this.index.equals(that.index);
    }

    public int hashCode() {
        int result = this.expression.hashCode();
        return (31 * result) + this.index.hashCode();
    }

    public String toString() {
        return "GlslArrayNode{expression=" + this.expression + ", index=" + this.index + "}";
    }
}
