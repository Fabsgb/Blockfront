package io.github.ocelot.glslprocessor.api.node.branch;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslCaseLabelNode.class */
public final class GlslCaseLabelNode implements GlslNode {
    private GlslNode condition;

    public GlslCaseLabelNode(@Nullable GlslNode condition) {
        this.condition = condition;
    }

    public boolean isDefault() {
        return this.condition == null;
    }

    public GlslNode getCondition() {
        return this.condition;
    }

    public void setCondition(@Nullable GlslNode condition) {
        this.condition = condition;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        throw new UnsupportedOperationException("Cannot call visit() on GlslCaseLabelNode");
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.CASE_LABEL;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslCaseLabelNode that = (GlslCaseLabelNode) o;
        return this.condition.equals(that.condition);
    }

    public int hashCode() {
        return Objects.hashCode(this.condition);
    }

    public String toString() {
        return "GlslCaseLabelNode{condition=" + (this.condition == null ? "default" : this.condition) + "}";
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.condition.stream());
    }
}
