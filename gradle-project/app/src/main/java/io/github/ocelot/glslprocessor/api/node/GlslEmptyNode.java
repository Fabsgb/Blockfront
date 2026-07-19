package io.github.ocelot.glslprocessor.api.node;

import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslEmptyNode.class */
public enum GlslEmptyNode implements GlslNode {
    INSTANCE;

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        throw new AssertionError("This should never happen");
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public List<GlslNode> toList() {
        return new ArrayList();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.empty();
    }
}
