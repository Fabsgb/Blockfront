package io.github.ocelot.glslprocessor.api.node.branch;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeList;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslIfVisitor;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.Collection;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslIfNode.class */
public final class GlslIfNode implements GlslNode {
    private GlslNode expression;
    private final GlslNodeList first;
    private final GlslNodeList second;

    public GlslIfNode(GlslNode expression, Collection<GlslNode> first, Collection<GlslNode> second) {
        this.expression = expression;
        this.first = new GlslNodeList(first);
        this.second = new GlslNodeList(second);
    }

    public GlslNode getExpression() {
        return this.expression;
    }

    public GlslNodeList getFirst() {
        return this.first;
    }

    public GlslNodeList getSecond() {
        return this.second;
    }

    public void setExpression(GlslNode expression) {
        this.expression = expression;
    }

    public GlslIfNode setFirst(Collection<GlslNode> first) {
        this.first.clear();
        this.first.addAll(first);
        return this;
    }

    public GlslIfNode setSecond(Collection<GlslNode> first) {
        this.first.clear();
        this.first.addAll(first);
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        GlslNodeVisitor elseVisitor;
        GlslNodeVisitor ifVisitor;
        GlslIfVisitor bodyVisitor = visitor.visitIf(this);
        if (bodyVisitor != null) {
            if (!this.first.isEmpty() && (ifVisitor = bodyVisitor.visitIf()) != null) {
                for (GlslNode node : this.first) {
                    node.visit(ifVisitor);
                }
            }
            if (!this.second.isEmpty() && (elseVisitor = bodyVisitor.visitElse()) != null) {
                for (GlslNode node2 : this.second) {
                    node2.visit(elseVisitor);
                }
            }
            bodyVisitor.visitIfEnd(this);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.IF_ELSE;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), Stream.concat(this.first.stream().flatMap((v0) -> {
            return v0.stream();
        }), this.second.stream().flatMap((v0) -> {
            return v0.stream();
        })));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslIfNode that = (GlslIfNode) o;
        return this.expression.equals(that.expression) && this.first.equals(that.first) && this.second.equals(that.second);
    }

    public int hashCode() {
        int result = this.expression.hashCode();
        return (31 * ((31 * result) + this.first.hashCode())) + this.second.hashCode();
    }

    public String toString() {
        return "GlslIfNode{expression=" + this.expression + ", first=" + this.first + ", branch=" + this.second + "}";
    }
}
