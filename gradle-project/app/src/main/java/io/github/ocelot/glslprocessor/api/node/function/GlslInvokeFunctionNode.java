package io.github.ocelot.glslprocessor.api.node.function;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslInvokeVisitor;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/function/GlslInvokeFunctionNode.class */
public final class GlslInvokeFunctionNode implements GlslNode {
    private GlslNode header;
    private final List<GlslNode> parameters;

    public GlslInvokeFunctionNode(GlslNode header, Collection<GlslNode> parameters) {
        this.header = header;
        this.parameters = new ArrayList(parameters);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        GlslInvokeVisitor invokeVisitor = visitor.visitFunctionInvocation(this);
        if (invokeVisitor != null) {
            invokeVisitor.visitHeader();
            for (int i = 0; i < this.parameters.size(); i++) {
                GlslNodeVisitor parameterVisitor = invokeVisitor.visitParameter(i);
                if (parameterVisitor != null) {
                    this.parameters.get(i).visit(parameterVisitor);
                }
            }
            invokeVisitor.visitInvokeEnd(this);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.INVOKE_FUNCTION;
    }

    public GlslNode getHeader() {
        return this.header;
    }

    public List<GlslNode> getParameters() {
        return this.parameters;
    }

    public void setHeader(GlslNode header) {
        this.header = header;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslInvokeFunctionNode that = (GlslInvokeFunctionNode) o;
        return this.header.equals(that.header) && this.parameters.equals(that.parameters);
    }

    public int hashCode() {
        int result = this.header.hashCode();
        return (31 * result) + this.parameters.hashCode();
    }

    public String toString() {
        return "GlslInvokeFunctionNode{name=" + this.header + ", parameters=" + this.parameters + "}";
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.parameters.stream().flatMap((v0) -> {
            return v0.stream();
        }));
    }
}
