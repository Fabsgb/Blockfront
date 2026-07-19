package io.github.ocelot.glslprocessor.api.node.constant;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/constant/GlslConstantNode.class */
public interface GlslConstantNode extends GlslNode {
    Number numberValue();

    boolean booleanValue();

    boolean isNumber();

    void set(Number number);

    void set(boolean z);

    default double doubleValue() {
        return numberValue().doubleValue();
    }

    default float floatValue() {
        return numberValue().floatValue();
    }

    default int intValue() {
        return numberValue().intValue();
    }

    default long unsignedIntValue() {
        return Integer.toUnsignedLong(intValue());
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    default void visit(GlslNodeVisitor visitor) {
        visitor.visitConstant(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    default Stream<GlslNode> stream() {
        return Stream.of(this);
    }
}
