package io.github.ocelot.glslprocessor.api.node.expression;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/expression/GlslConditionalNode.class */
public final class GlslConditionalNode implements GlslNode {
    private GlslNode condition;
    private GlslNode first;
    private GlslNode second;

    public GlslConditionalNode(GlslNode condition, GlslNode first, GlslNode second) {
        this.condition = condition;
        this.first = first;
        this.second = second;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitCondition(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.CONDITIONAL;
    }

    public GlslNode getCondition() {
        return this.condition;
    }

    public GlslNode getFirst() {
        return this.first;
    }

    public GlslNode getSecond() {
        return this.second;
    }

    public GlslConditionalNode setCondition(GlslNode condition) {
        this.condition = condition;
        return this;
    }

    public GlslConditionalNode setFirst(GlslNode first) {
        this.first = first;
        return this;
    }

    public GlslConditionalNode setSecond(GlslNode second) {
        this.second = second;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), Stream.concat(this.first.stream(), this.second.stream()));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslConditionalNode that = (GlslConditionalNode) o;
        return this.condition.equals(that.condition) && this.first.equals(that.first) && this.second.equals(that.second);
    }

    public int hashCode() {
        int result = this.condition.hashCode();
        return (31 * ((31 * result) + this.first.hashCode())) + this.second.hashCode();
    }

    public String toString() {
        return "GlslConditionalNode{condition=" + this.condition + ", first=" + this.first + ", second=" + this.second + "}";
    }
}
