package io.github.ocelot.glslprocessor.api.grammar;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslStructField.class */
public final class GlslStructField {
    private GlslSpecifiedType type;
    private String name;

    public GlslStructField(GlslType type, String name) {
        this.type = type.asSpecifiedType();
        this.name = name;
    }

    public GlslSpecifiedType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public GlslStructField setType(GlslSpecifiedType type) {
        this.type = type;
        return this;
    }

    public GlslStructField setName(String name) {
        this.name = name;
        return this;
    }

    public GlslStructField copy() {
        return new GlslStructField(this.type.copy(), this.name);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslStructField that = (GlslStructField) o;
        return this.type.equals(that.type) && this.name.equals(that.name);
    }

    public int hashCode() {
        int result = this.type.hashCode();
        return (31 * result) + this.name.hashCode();
    }
}
