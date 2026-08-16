package io.github.ocelot.glslprocessor.api.node.branch;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeList;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.Collection;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslForLoopNode.class */
public final class GlslForLoopNode implements GlslNode {
    private GlslNode init;
    private GlslNode condition;
    private GlslNode increment;
    private final GlslNodeList body;

    public GlslForLoopNode(GlslNode init, GlslNode condition, @Nullable GlslNode increment, Collection<GlslNode> body) {
        this.init = init;
        this.condition = condition;
        this.increment = increment;
        this.body = new GlslNodeList(body);
    }

    public GlslNode getInit() {
        return this.init;
    }

    public GlslNode getCondition() {
        return this.condition;
    }

    @Nullable
    public GlslNode getIncrement() {
        return this.increment;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeList getBody() {
        return this.body;
    }

    public GlslForLoopNode setInit(GlslNode init) {
        this.init = init;
        return this;
    }

    public GlslForLoopNode setCondition(GlslNode condition) {
        this.condition = condition;
        return this;
    }

    public GlslForLoopNode setIncrement(@Nullable GlslNode increment) {
        this.increment = increment;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        GlslNodeVisitor bodyVisitor = visitor.visitForLoop(this);
        if (bodyVisitor != null) {
            for (GlslNode node : this.body) {
                node.visit(bodyVisitor);
            }
            bodyVisitor.visitForLoopEnd(this);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.FOR_LOOP;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslForLoopNode that = (GlslForLoopNode) o;
        return this.init.equals(that.init) && this.condition.equals(that.condition) && this.increment.equals(that.increment) && this.body.equals(that.body);
    }

    public int hashCode() {
        int result = this.init.hashCode();
        return (31 * ((31 * ((31 * result) + this.condition.hashCode())) + this.increment.hashCode())) + this.body.hashCode();
    }

    public String toString() {
        return "ForLoopNode{init=" + this.init + ", condition=" + this.condition + ", increment=" + this.increment + ", body=" + this.body + "}";
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(this.init.stream(), Stream.concat(this.condition.stream(), this.increment.stream()));
    }
}
