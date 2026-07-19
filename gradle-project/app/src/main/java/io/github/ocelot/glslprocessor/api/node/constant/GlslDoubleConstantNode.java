package io.github.ocelot.glslprocessor.api.node.constant;

import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/constant/GlslDoubleConstantNode.class */
public final class GlslDoubleConstantNode implements GlslConstantNode {
    private double value;

    @ApiStatus.Internal
    public GlslDoubleConstantNode(double value) {
        this.value = value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public Number numberValue() {
        return Double.valueOf(this.value);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public double doubleValue() {
        return this.value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public boolean booleanValue() {
        return this.value != 0.0d;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public boolean isNumber() {
        return true;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(Number value) {
        this.value = value.doubleValue();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(boolean value) {
        this.value = value ? 1.0d : 0.0d;
    }

    public String toString() {
        return this.value + "lf";
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.DOUBLE_CONSTANT;
    }

    public boolean equals(Object o) {
        if (!(o instanceof GlslDoubleConstantNode)) {
            return false;
        }
        GlslDoubleConstantNode that = (GlslDoubleConstantNode) o;
        return Double.compare(this.value, that.value) == 0;
    }

    public int hashCode() {
        return Double.hashCode(this.value);
    }
}
