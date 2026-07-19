package io.github.ocelot.glslprocessor.api.node.variable;

import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.node.GlslRootNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/variable/GlslVariableDeclarationNode.class */
public final class GlslVariableDeclarationNode implements GlslRootNode {
    private final List<GlslTypeQualifier> typeQualifiers;
    private final List<String> names;

    public GlslVariableDeclarationNode(Collection<GlslTypeQualifier> typeQualifiers, Collection<String> names) {
        this.typeQualifiers = new ArrayList(typeQualifiers);
        this.names = new ArrayList(names);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitVariableDeclaration(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.VARIABLE_DECLARATION;
    }

    public List<GlslTypeQualifier> getTypeQualifiers() {
        return this.typeQualifiers;
    }

    public List<String> getNames() {
        return this.names;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.of(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    @Nullable
    public String getName() {
        throw new UnsupportedOperationException("Use getNames() instead");
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    public GlslRootNode setName(@Nullable String name) {
        throw new UnsupportedOperationException("Use setNames() instead");
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslVariableDeclarationNode that = (GlslVariableDeclarationNode) o;
        return this.typeQualifiers.equals(that.typeQualifiers) && this.names.equals(that.names);
    }

    public int hashCode() {
        int result = this.typeQualifiers.hashCode();
        return (31 * result) + this.names.hashCode();
    }

    public String toString() {
        return "GlslDeclarationNode{typeQualifiers=" + this.typeQualifiers + ", names=" + this.names + "}";
    }
}
