package io.github.ocelot.glslprocessor.api.node.branch;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import io.github.ocelot.glslprocessor.api.visitor.GlslSwitchVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslSwitchNode.class */
public final class GlslSwitchNode implements GlslNode {
    private GlslNode condition;
    private final List<GlslNode> branches;

    public GlslSwitchNode(GlslNode condition, Collection<GlslNode> branches) {
        this.condition = condition;
        this.branches = new ArrayList(branches);
    }

    public GlslNode getCondition() {
        return this.condition;
    }

    public List<GlslNode> getBranches() {
        return this.branches;
    }

    public GlslSwitchNode setCondition(GlslNode condition) {
        this.condition = condition;
        return this;
    }

    public GlslSwitchNode setBranches(Collection<GlslNode> branches) {
        this.branches.clear();
        this.branches.addAll(branches);
        return this;
    }

    public GlslSwitchNode setBranches(GlslNode... branches) {
        this.branches.clear();
        this.branches.addAll(Arrays.asList(branches));
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        GlslSwitchVisitor switchVisitor = visitor.visitSwitch(this);
        if (switchVisitor != null) {
            GlslNodeVisitor nodeVisitor = null;
            for (GlslNode branch : this.branches) {
                if (branch instanceof GlslCaseLabelNode) {
                    GlslCaseLabelNode node = (GlslCaseLabelNode) branch;
                    nodeVisitor = switchVisitor.visitLabel(node);
                } else if (nodeVisitor != null) {
                    branch.visit(nodeVisitor);
                }
            }
            switchVisitor.visitSwitchEnd(this);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.SWITCH;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), Stream.concat(this.condition.stream(), this.branches.stream().flatMap((v0) -> {
            return v0.stream();
        })));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslSwitchNode that = (GlslSwitchNode) o;
        return this.condition.equals(that.condition) && this.branches.equals(that.branches);
    }

    public int hashCode() {
        int result = this.condition.hashCode();
        return (31 * result) + this.branches.hashCode();
    }

    public String toString() {
        return "GlslSwitchNode{condition=" + this.condition + ", branches=" + this.branches + "}";
    }
}
