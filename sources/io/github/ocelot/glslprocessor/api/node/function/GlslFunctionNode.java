package io.github.ocelot.glslprocessor.api.node.function;

import io.github.ocelot.glslprocessor.api.grammar.GlslFunctionHeader;
import io.github.ocelot.glslprocessor.api.grammar.GlslParameterDeclaration;
import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslNodeList;
import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import io.github.ocelot.glslprocessor.api.node.GlslRootNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/function/GlslFunctionNode.class */
public final class GlslFunctionNode implements GlslRootNode {
    private GlslFunctionHeader header;
    private GlslNodeList body;

    public GlslFunctionNode(GlslFunctionHeader header, @Nullable Collection<GlslNode> body) {
        this.header = header;
        this.body = body != null ? new GlslNodeList(body) : null;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public void visit(GlslNodeVisitor visitor) {
        for (GlslNode node : this.body) {
            node.visit(visitor);
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.FUNCTION;
    }

    public GlslFunctionHeader getHeader() {
        return this.header;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    @NotNull
    public String getName() {
        return this.header.getName();
    }

    public GlslSpecifiedType getReturnType() {
        return this.header.getReturnType();
    }

    public List<GlslParameterDeclaration> getParameters() {
        return this.header.getParameters();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    @Nullable
    public GlslNodeList getBody() {
        return this.body;
    }

    public void setHeader(GlslFunctionHeader header) {
        this.header = header;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslRootNode
    public GlslFunctionNode setName(@Nullable String name) {
        this.header.setName((String) Objects.requireNonNull(name));
        return this;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public boolean setBody(@Nullable Collection<GlslNode> body) {
        if (body != null) {
            if (this.body != null) {
                this.body.clear();
                this.body.addAll(body);
                return true;
            }
            this.body = new GlslNodeList(body);
            return true;
        }
        this.body = null;
        return true;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public Stream<GlslNode> stream() {
        return Stream.concat(Stream.of(this), this.body.stream().flatMap((v0) -> {
            return v0.stream();
        }));
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslFunctionNode that = (GlslFunctionNode) o;
        return this.header.equals(that.header) && Objects.equals(this.body, that.body);
    }

    public int hashCode() {
        int result = this.header.hashCode();
        return (31 * result) + Objects.hashCode(this.body);
    }

    public String toString() {
        return "GlslFunction{header=" + this.header + ", body=" + this.body + "}";
    }
}
