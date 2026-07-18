package io.github.ocelot.glslprocessor.api.node.variable;

import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslType;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.node.GlslRootNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/variable/GlslNewFieldNode.class */
public final class GlslNewFieldNode implements GlslRootNode {
    private GlslSpecifiedType type;
    private String name;
    private GlslNode initializer;

    public GlslNewFieldNode(GlslType type, @Nullable String name, @Nullable GlslNode initializer) {
        this.type = type.asSpecifiedType();
        this.name = name;
        this.initializer = initializer;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        visitor.visitNewField(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.NEW_FIELD;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    @NotNull
    public GlslSpecifiedType getType() {
        return this.type;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return this.initializer != null ? Stream.concat(Stream.of(this), this.initializer.stream()) : Stream.of(this);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public GlslNode getInitializer() {
        return this.initializer;
    }

    public GlslNewFieldNode setType(GlslType type) {
        this.type = type.asSpecifiedType();
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    public GlslNewFieldNode setName(@Nullable String name) {
        this.name = name;
        return this;
    }

    public GlslNewFieldNode setInitializer(@Nullable GlslNode initializer) {
        this.initializer = initializer;
        return this;
    }

    public String toString() {
        return "GlslNewNode{operand=" + this.type + ", name='" + this.name + "', initializer=" + this.initializer + "}";
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslNewFieldNode that = (GlslNewFieldNode) o;
        return this.type.equals(that.type) && this.name.equals(that.name) && Objects.equals(this.initializer, that.initializer);
    }

    public int hashCode() {
        int result = this.type.hashCode();
        return (31 * ((31 * result) + this.name.hashCode())) + Objects.hashCode(this.initializer);
    }
}
