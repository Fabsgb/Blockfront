package io.github.ocelot.glslprocessor.api.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslStructSpecifier.class */
public final class GlslStructSpecifier implements GlslTypeSpecifier {
    private String name;
    private final List<GlslStructField> fields;

    GlslStructSpecifier(String name, Collection<GlslStructField> fields) {
        this(name, (List<GlslStructField>) new ArrayList(fields));
    }

    private GlslStructSpecifier(String name, List<GlslStructField> fields) {
        this.name = name;
        this.fields = fields;
    }

    @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
    public String getName() {
        return this.name;
    }

    public List<GlslStructField> getFields() {
        return this.fields;
    }

    public GlslStructSpecifier setName(String name) {
        this.name = name;
        return this;
    }

    public GlslStructSpecifier setFields(GlslStructField... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GlslStructSpecifier setFields(Collection<GlslStructField> fields) {
        this.fields.clear();
        this.fields.addAll(fields);
        return this;
    }

    public GlslStructSpecifier copy() {
        List<GlslStructField> fields = new ArrayList<>(this.fields.size());
        for (GlslStructField field : this.fields) {
            fields.add(field.copy());
        }
        return new GlslStructSpecifier(this.name, fields);
    }

    @Override // io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier
    public boolean isStruct() {
        return true;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslStructSpecifier that = (GlslStructSpecifier) o;
        return this.name.equals(that.name) && this.fields.equals(that.fields);
    }

    public int hashCode() {
        int result = this.name.hashCode();
        return (31 * result) + this.fields.hashCode();
    }

    public String toString() {
        return "GlslStructSpecifier{name='" + this.name + "', fields=" + this.fields + "}";
    }
}
