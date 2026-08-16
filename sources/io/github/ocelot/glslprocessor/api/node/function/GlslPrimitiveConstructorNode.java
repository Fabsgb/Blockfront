package io.github.ocelot.glslprocessor.api.node.function;

import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/function/GlslPrimitiveConstructorNode.class */
public final class GlslPrimitiveConstructorNode implements GlslNode {
    private GlslTypeSpecifier primitiveType;

    public GlslPrimitiveConstructorNode(GlslTypeSpecifier primitiveType) {
        this.primitiveType = primitiveType;
    }

    public GlslTypeSpecifier getPrimitiveType() {
        return this.primitiveType;
    }

    public void setPrimitiveType(GlslTypeSpecifier primitiveType) {
        this.primitiveType = primitiveType;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitPrimitiveConstructor(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.PRIMITIVE_CONSTRUCTOR;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslPrimitiveConstructorNode that = (GlslPrimitiveConstructorNode) o;
        return this.primitiveType.equals(that.primitiveType);
    }

    public int hashCode() {
        return this.primitiveType.hashCode();
    }

    public String toString() {
        return "PrimitiveConstructorNode{operand=" + this.primitiveType + "}";
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.of(this);
    }
}
