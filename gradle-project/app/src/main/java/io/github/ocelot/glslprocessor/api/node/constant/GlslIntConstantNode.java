package io.github.ocelot.glslprocessor.api.node.constant;

import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/constant/GlslIntConstantNode.class */
public final class GlslIntConstantNode implements GlslConstantNode {
    private GlslIntFormat format;
    private boolean signed;
    private int value;

    @ApiStatus.Internal
    public GlslIntConstantNode(GlslIntFormat format, boolean signed, int value) {
        this.format = format;
        this.signed = signed;
        this.value = value;
    }

    public GlslIntFormat format() {
        return this.format;
    }

    public boolean signed() {
        return this.signed;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public Number numberValue() {
        return Integer.valueOf(this.value);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public int intValue() {
        return this.value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public boolean booleanValue() {
        return ((double) this.value) != 0.0d;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public boolean isNumber() {
        return true;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(Number value) {
        this.value = value.intValue();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(boolean value) {
        this.value = value ? 1 : 0;
    }

    public void setFormat(GlslIntFormat format) {
        this.format = format;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public String toString() {
        switch (this.format) {
            case HEXADECIMAL:
                return "0x" + Integer.toHexString(this.value) + (this.signed ? "" : "u");
            case OCTAL:
                return (this.value > 0 ? "0" : "") + Integer.toOctalString(this.value) + (this.signed ? "" : "u");
            case DECIMAL:
                return this.value + (this.signed ? "" : "u");
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.INT_CONSTANT;
    }

    public boolean equals(Object o) {
        if (!(o instanceof GlslIntConstantNode)) {
            return false;
        }
        GlslIntConstantNode that = (GlslIntConstantNode) o;
        return this.signed == that.signed && this.value == that.value && this.format == that.format;
    }

    public int hashCode() {
        int result = this.format.hashCode();
        return (31 * ((31 * result) + Boolean.hashCode(this.signed))) + this.value;
    }
}
