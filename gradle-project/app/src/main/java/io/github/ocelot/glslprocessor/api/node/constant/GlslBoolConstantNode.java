package io.github.ocelot.glslprocessor.api.node.constant;

import io.github.ocelot.glslprocessor.api.node.GlslNodeType;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/constant/GlslBoolConstantNode.class */
public final class GlslBoolConstantNode implements GlslConstantNode {
    private boolean value;

    @ApiStatus.Internal
    public GlslBoolConstantNode(boolean value) {
        this.value = value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public Number numberValue() {
        return Integer.valueOf(this.value ? 1 : 0);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public boolean booleanValue() {
        return this.value;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public boolean isNumber() {
        return false;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(Number value) {
        this.value = value.longValue() == 1;
    }

    @Override // io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode
    public void set(boolean value) {
        this.value = value;
    }

    public String toString() {
        return Boolean.toString(this.value);
    }

    @Override // io.github.ocelot.glslprocessor.api.node.GlslNode
    public GlslNodeType getNodeType() {
        return GlslNodeType.BOOL_CONSTANT;
    }

    public boolean equals(Object o) {
        if (!(o instanceof GlslBoolConstantNode)) {
            return false;
        }
        GlslBoolConstantNode that = (GlslBoolConstantNode) o;
        return this.value == that.value;
    }

    public int hashCode() {
        return Boolean.hashCode(this.value);
    }
}
