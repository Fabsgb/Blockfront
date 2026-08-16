package io.github.ocelot.glslprocessor.api.node;

import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslCompoundNode.class */
public final class GlslCompoundNode implements GlslNode {
    final List<GlslNode> children;

    public GlslCompoundNode(List<GlslNode> children) {
        this.children = children;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        for (GlslNode node : this.children) {
            node.visit(visitor);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        throw new AssertionError("This should never happen");
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public List<GlslNode> toList() {
        return new ArrayList(this.children);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.children.stream().flatMap((v0) -> {
            return v0.stream();
        }));
    }

    public GlslCompoundNode setChildren(GlslNode... children) {
        return setChildren(Arrays.asList(children));
    }

    public GlslCompoundNode setChildren(Collection<GlslNode> children) {
        this.children.clear();
        this.children.addAll(children);
        return this;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslCompoundNode that = (GlslCompoundNode) o;
        return this.children.equals(that.children);
    }

    public int hashCode() {
        return this.children.hashCode();
    }

    public String toString() {
        return "GlslCompoundNode{children=" + this.children + "}";
    }
}
