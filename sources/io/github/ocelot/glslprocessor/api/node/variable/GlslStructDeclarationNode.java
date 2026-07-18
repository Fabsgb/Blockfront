package io.github.ocelot.glslprocessor.api.node.variable;

import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructSpecifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.node.GlslRootNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.stream.Stream;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/variable/GlslStructDeclarationNode.class */
public final class GlslStructDeclarationNode implements GlslRootNode {
    private GlslSpecifiedType specifiedType;

    public GlslStructDeclarationNode(GlslSpecifiedType specifiedType) {
        if (!specifiedType.getSpecifier().isStruct()) {
            throw new IllegalArgumentException("specified type must be struct or array of structs");
        }
        this.specifiedType = specifiedType;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitStructDeclaration(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.STRUCT_DECLARATION;
    }

    public GlslSpecifiedType getSpecifiedType() {
        return this.specifiedType;
    }

    public GlslStructSpecifier getStructSpecifier() {
        return this.specifiedType.getSpecifier().asStructSpecifier();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.of(this);
    }

    public GlslStructDeclarationNode setSpecifiedType(GlslSpecifiedType specifiedType) {
        if (!specifiedType.getSpecifier().isStruct()) {
            throw new IllegalArgumentException("specified type must be struct or array of structs");
        }
        this.specifiedType = specifiedType;
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    public String getName() {
        return this.specifiedType.getSpecifier().getName();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    public GlslStructDeclarationNode setName(String name) {
        getStructSpecifier().setName(name);
        return this;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslStructDeclarationNode that = (GlslStructDeclarationNode) o;
        return this.specifiedType.equals(that.specifiedType);
    }

    public int hashCode() {
        return this.specifiedType.hashCode();
    }

    public String toString() {
        return "GlslStructNode{specifiedType=" + this.specifiedType + "}";
    }
}
