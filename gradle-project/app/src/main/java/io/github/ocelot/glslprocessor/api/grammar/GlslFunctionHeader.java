package io.github.ocelot.glslprocessor.api.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslFunctionHeader.class */
public final class GlslFunctionHeader {
    private String name;
    private GlslSpecifiedType returnType;
    private final List<GlslParameterDeclaration> parameters;

    public GlslFunctionHeader(String name, GlslType returnType, Collection<GlslParameterDeclaration> parameters) {
        this(name, returnType, (List<GlslParameterDeclaration>) new ArrayList(parameters));
    }

    private GlslFunctionHeader(String name, GlslType returnType, List<GlslParameterDeclaration> parameters) {
        this.name = name;
        this.returnType = returnType.asSpecifiedType();
        this.parameters = parameters;
    }

    public String getName() {
        return this.name;
    }

    public GlslSpecifiedType getReturnType() {
        return this.returnType;
    }

    public List<GlslParameterDeclaration> getParameters() {
        return this.parameters;
    }

    public GlslFunctionHeader setName(String name) {
        this.name = name;
        return this;
    }

    public GlslFunctionHeader setReturnType(GlslType returnType) {
        this.returnType = returnType.asSpecifiedType();
        return this;
    }

    public GlslFunctionHeader setParameters(GlslParameterDeclaration... parameters) {
        return setParameters(Arrays.asList(parameters));
    }

    public GlslFunctionHeader setParameters(Collection<GlslParameterDeclaration> parameters) {
        this.parameters.clear();
        this.parameters.addAll(parameters);
        return this;
    }

    public GlslFunctionHeader copy() {
        List<GlslParameterDeclaration> declarations = new ArrayList<>();
        for (GlslParameterDeclaration parameter : this.parameters) {
            declarations.add(parameter.copy());
        }
        return new GlslFunctionHeader(this.name, (GlslType) this.returnType, declarations);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslFunctionHeader that = (GlslFunctionHeader) o;
        return this.name.equals(that.name) && this.returnType.equals(that.returnType) && this.parameters.equals(that.parameters);
    }

    public int hashCode() {
        int result = this.name.hashCode();
        return (31 * ((31 * result) + this.returnType.hashCode())) + this.parameters.hashCode();
    }

    public String toString() {
        return "GlslFunctionHeader{name='" + this.name + "', returnType=" + this.returnType + ", parameters=" + this.parameters + "}";
    }
}
