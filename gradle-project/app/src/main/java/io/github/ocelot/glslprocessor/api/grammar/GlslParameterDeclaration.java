package io.github.ocelot.glslprocessor.api.grammar;

import java.util.Collection;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslParameterDeclaration.class */
public final class GlslParameterDeclaration {
    private GlslSpecifiedType type;
    private String name;

    public GlslParameterDeclaration(GlslType type, @Nullable String name) {
        this.name = name;
        this.type = type.asSpecifiedType();
    }

    public GlslSpecifiedType getType() {
        return this.type;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public GlslParameterDeclaration setType(GlslType type) {
        this.type = type.asSpecifiedType();
        return this;
    }

    public GlslParameterDeclaration setName(@Nullable String name) {
        this.name = name;
        return this;
    }

    public GlslParameterDeclaration setQualifiers(GlslTypeQualifier... qualifiers) {
        this.type.setQualifiers(qualifiers);
        return this;
    }

    public GlslParameterDeclaration setQualifiers(Collection<GlslTypeQualifier> qualifiers) {
        this.type.setQualifiers(qualifiers);
        return this;
    }

    public GlslParameterDeclaration copy() {
        return new GlslParameterDeclaration(this.type.copy(), this.name);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslParameterDeclaration that = (GlslParameterDeclaration) o;
        return this.name.equals(that.name) && this.type.equals(that.type);
    }

    public int hashCode() {
        int result = this.name.hashCode();
        return (31 * result) + this.type.hashCode();
    }

    public String toString() {
        return "GlslParameterDeclaration{type='" + this.type + "', name=" + this.name + "}";
    }
}
