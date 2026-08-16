package io.github.ocelot.glslprocessor.api.node.expression;

import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/expression/GlslUnaryNode.class */
public final class GlslUnaryNode implements GlslNode {
    private GlslNode expression;
    private Operand operand;

    public GlslUnaryNode(GlslNode expression, Operand operand) {
        this.expression = expression;
        this.operand = operand;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitUnary(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.UNARY;
    }

    public GlslNode getExpression() {
        return this.expression;
    }

    public Operand getOperand() {
        return this.operand;
    }

    public GlslUnaryNode setExpression(GlslNode expression) {
        this.expression = expression;
        return this;
    }

    public GlslUnaryNode setOperand(Operand operand) {
        this.operand = operand;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    @Nullable
    public GlslSpecifiedType getType() {
        return this.expression.getType();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.expression.stream());
    }

    public String toString() {
        return "GlslUnaryNode{expression=" + this.expression + ", operand=" + this.operand + "}";
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslUnaryNode that = (GlslUnaryNode) o;
        return this.expression.equals(that.expression) && this.operand == that.operand;
    }

    public int hashCode() {
        int result = this.expression.hashCode();
        return (31 * result) + this.operand.hashCode();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/expression/GlslUnaryNode$Operand.class */
    public enum Operand {
        PRE_INCREMENT("++"),
        PRE_DECREMENT("--"),
        POST_INCREMENT("++"),
        POST_DECREMENT("--"),
        PLUS("+"),
        DASH("-"),
        BANG("!"),
        TILDE("~");

        private final String delimiter;

        Operand(String delimiter) {
            this.delimiter = delimiter;
        }

        public String getDelimiter() {
            return this.delimiter;
        }
    }
}
