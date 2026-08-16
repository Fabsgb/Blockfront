package io.github.ocelot.glslprocessor.api.node.expression;

import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/expression/GlslPrecisionNode.class */
public final class GlslPrecisionNode implements GlslNode {
    private GlslTypeQualifier.Precision precision;
    private GlslTypeSpecifier typeSpecifier;

    public GlslPrecisionNode(GlslTypeQualifier.Precision precision, GlslTypeSpecifier typeSpecifier) {
        this.precision = precision;
        this.typeSpecifier = typeSpecifier;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitPrecision(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.PRECISION;
    }

    public GlslTypeQualifier.Precision getPrecision() {
        return this.precision;
    }

    public GlslTypeSpecifier getTypeSpecifier() {
        return this.typeSpecifier;
    }

    public GlslPrecisionNode setPrecision(GlslTypeQualifier.Precision precision) {
        this.precision = precision;
        return this;
    }

    public GlslPrecisionNode setTypeSpecifier(GlslTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
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
        GlslPrecisionNode that = (GlslPrecisionNode) o;
        return this.precision == that.precision && this.typeSpecifier.equals(that.typeSpecifier);
    }

    public int hashCode() {
        int result = this.precision.hashCode();
        return (31 * result) + this.typeSpecifier.hashCode();
    }

    public String toString() {
        return "GlslPrecisionNode{precision=" + this.precision + ", typeSpecifier=" + this.typeSpecifier + "}";
    }
}
