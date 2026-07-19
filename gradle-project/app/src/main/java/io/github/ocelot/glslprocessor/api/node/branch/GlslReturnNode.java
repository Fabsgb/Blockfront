package io.github.ocelot.glslprocessor.api.node.branch;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslReturnNode.class */
public final class GlslReturnNode implements GlslNode {
    private GlslNode value;

    public GlslReturnNode(@Nullable GlslNode value) {
        this.value = value;
    }

    @Nullable
    public GlslNode getValue() {
        return this.value;
    }

    public void setValue(@Nullable GlslNode value) {
        this.value = value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitReturn(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.RETURN;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.value.stream());
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslReturnNode that = (GlslReturnNode) o;
        return this.value.equals(that.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "ReturnNode{value=" + this.value + "}";
    }
}
