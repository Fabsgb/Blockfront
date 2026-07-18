package io.github.ocelot.glslprocessor.api.node.constant;

import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/constant/GlslFloatConstantNode.class */
public final class GlslFloatConstantNode implements GlslConstantNode {
    private float value;

    @ApiStatus.Internal
    public GlslFloatConstantNode(float value) {
        this.value = value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public Number numberValue() {
        return Float.valueOf(this.value);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public float floatValue() {
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
        this.value = value.floatValue();
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(boolean value) {
        this.value = value ? 1.0f : 0.0f;
    }

    public String toString() {
        return Float.toString(this.value);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.FLOAT_CONSTANT;
    }

    public boolean equals(Object o) {
        if (!(o instanceof GlslFloatConstantNode)) {
            return false;
        }
        GlslFloatConstantNode that = (GlslFloatConstantNode) o;
        return Float.compare(this.value, that.value) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.value);
    }
}
