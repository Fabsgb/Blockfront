package io.github.ocelot.glslprocessor.api.node.variable;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/variable/GlslVariableNode.class */
public final class GlslVariableNode implements GlslNode {
    private String name;

    public GlslVariableNode(String name) {
        this.name = name;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitVariable(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.VARIABLE;
    }

    public String getName() {
        return this.name;
    }

    public GlslVariableNode setName(String name) {
        this.name = name;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.of(this);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslVariableNode that = (GlslVariableNode) o;
        return this.name.equals(that.name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "GlslVariableNode{name=" + this.name + "}";
    }
}
