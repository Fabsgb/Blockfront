package io.github.ocelot.glslprocessor.api.node.branch;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeList;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.Collection;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslWhileLoopNode.class */
public final class GlslWhileLoopNode implements GlslNode {
    private GlslNode condition;
    private final GlslNodeList body;
    private Type loopType;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/branch/GlslWhileLoopNode$Type.class */
    public enum Type {
        WHILE,
        DO
    }

    public GlslWhileLoopNode(GlslNode condition, Collection<GlslNode> body, Type loopType) {
        this.condition = condition;
        this.body = new GlslNodeList(body);
        this.loopType = loopType;
    }

    public GlslNode getCondition() {
        return this.condition;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeList getBody() {
        return this.body;
    }

    public Type getLoopType() {
        return this.loopType;
    }

    public GlslWhileLoopNode setCondition(GlslNode condition) {
        this.condition = condition;
        return this;
    }

    public GlslWhileLoopNode setLoopType(Type loopType) {
        this.loopType = loopType;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        GlslNodeVisitor bodyVisitor = visitor.visitWhileLoop(this);
        if (bodyVisitor != null) {
            for (GlslNode node : this.body) {
                node.visit(bodyVisitor);
            }
            bodyVisitor.visitWhileLoopEnd(this);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.WHILE_LOOP;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslWhileLoopNode that = (GlslWhileLoopNode) o;
        return this.condition.equals(that.condition) && this.body.equals(that.body) && this.loopType == that.loopType;
    }

    public int hashCode() {
        int result = this.condition.hashCode();
        return (31 * ((31 * result) + this.body.hashCode())) + this.loopType.hashCode();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), Stream.concat(this.condition.stream(), this.body.stream()));
    }
}
