package io.github.ocelot.glslprocessor.api.grammar;

import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslSpecifiedType.class */
public final class GlslSpecifiedType implements GlslType {
    private GlslTypeSpecifier specifier;
    private final List<GlslTypeQualifier> qualifiers;

    public GlslSpecifiedType(GlslTypeSpecifier specifier) {
        this.specifier = specifier;
        this.qualifiers = new ArrayList();
    }

    public GlslSpecifiedType(GlslTypeSpecifier specifier, GlslTypeQualifier... qualifiers) {
        this(specifier);
        this.qualifiers.addAll(Arrays.asList(qualifiers));
    }

    public GlslSpecifiedType(GlslTypeSpecifier specifier, Collection<GlslTypeQualifier> qualifiers) {
        this(specifier);
        this.qualifiers.addAll(qualifiers);
    }

    public GlslTypeSpecifier getSpecifier() {
        return this.specifier;
    }

    public GlslSpecifiedType addLayoutId(String identifier, @Nullable GlslNode expression) {
        for (int i = 0; i < this.qualifiers.size(); i++) {
            GlslTypeQualifier glslTypeQualifier = this.qualifiers.get(i);
            if (glslTypeQualifier instanceof GlslTypeQualifier.Layout) {
                GlslTypeQualifier.Layout layout = (GlslTypeQualifier.Layout) glslTypeQualifier;
                this.qualifiers.set(i, layout.addLayoutId(identifier, expression));
                return this;
            }
        }
        this.qualifiers.add(0, GlslTypeQualifier.layout(GlslTypeQualifier.layoutId(identifier, expression)));
        return this;
    }

    public List<GlslTypeQualifier> getQualifiers() {
        return this.qualifiers;
    }

    public GlslSpecifiedType setSpecifier(GlslTypeSpecifier specifier) {
        this.specifier = specifier;
        return this;
    }

    public GlslSpecifiedType setQualifiers(GlslTypeQualifier... qualifiers) {
        this.qualifiers.clear();
        this.qualifiers.addAll(Arrays.asList(qualifiers));
        return this;
    }

    public GlslSpecifiedType setQualifiers(Collection<GlslTypeQualifier> qualifiers) {
        this.qualifiers.clear();
        this.qualifiers.addAll(qualifiers);
        return this;
    }

    public GlslSpecifiedType copy() {
        return new GlslSpecifiedType(this.specifier, this.qualifiers);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslSpecifiedType that = (GlslSpecifiedType) o;
        return this.specifier.equals(that.specifier) && this.qualifiers.equals(that.qualifiers);
    }

    public int hashCode() {
        int result = this.specifier.hashCode();
        return (31 * result) + this.qualifiers.hashCode();
    }

    public String toString() {
        return "GlslSpecifiedType[specifier=" + this.specifier + ", qualifiers=" + this.qualifiers;
    }

    @Override // io.github.ocelot.glslprocessor.api.grammar.GlslType
    public GlslSpecifiedType asSpecifiedType() {
        return this;
    }
}
