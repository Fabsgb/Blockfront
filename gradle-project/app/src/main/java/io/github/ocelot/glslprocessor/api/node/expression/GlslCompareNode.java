package io.github.ocelot.glslprocessor.api.node.expression;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/expression/GlslCompareNode.class */
public final class GlslCompareNode implements GlslNode {
    private GlslNode first;
    private GlslNode second;
    private Operand operand;

    public GlslCompareNode(GlslNode first, GlslNode second, Operand operand) {
        this.first = first;
        this.second = second;
        this.operand = operand;
    }

    public GlslNode getFirst() {
        return this.first;
    }

    public GlslNode getSecond() {
        return this.second;
    }

    public Operand getOperand() {
        return this.operand;
    }

    public GlslCompareNode setFirst(GlslNode first) {
        this.first = first;
        return this;
    }

    public GlslCompareNode setSecond(GlslNode second) {
        this.second = second;
        return this;
    }

    public GlslCompareNode setOperand(Operand operand) {
        this.operand = operand;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitCompare(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.COMPARE;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), Stream.concat(this.first.stream(), this.second.stream()));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslCompareNode that = (GlslCompareNode) o;
        return this.first.equals(that.first) && this.second.equals(that.second) && this.operand == that.operand;
    }

    public int hashCode() {
        int result = this.first.hashCode();
        return (31 * ((31 * result) + this.second.hashCode())) + this.operand.hashCode();
    }

    public String toString() {
        return "GlslCompareNode{first=" + this.first + ", second=" + this.second + ", operand=" + this.operand + "}";
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/expression/GlslCompareNode$Operand.class */
    public enum Operand {
        EQUAL("=="),
        NOT_EQUAL("!="),
        LESS("<"),
        GREATER(">"),
        LEQUAL("<="),
        GEQUAL(">=");

        private final String delimiter;

        Operand(String delimiter) {
            this.delimiter = delimiter;
        }

        public String getDelimiter() {
            return this.delimiter;
        }
    }
}
