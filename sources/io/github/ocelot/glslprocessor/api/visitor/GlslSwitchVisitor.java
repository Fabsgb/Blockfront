package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.node.branch.GlslCaseLabelNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslSwitchNode;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslSwitchVisitor.class */
@ApiStatus.Experimental
public class GlslSwitchVisitor {
    private final GlslSwitchVisitor parent;

    public GlslSwitchVisitor() {
        this(null);
    }

    public GlslSwitchVisitor(@Nullable GlslSwitchVisitor parent) {
        this.parent = parent;
    }

    @Nullable
    public GlslNodeVisitor visitLabel(GlslCaseLabelNode node) {
        if (this.parent != null) {
            return this.parent.visitLabel(node);
        }
        return null;
    }

    public void visitSwitchEnd(GlslSwitchNode node) {
        if (this.parent != null) {
            this.parent.visitSwitchEnd(node);
        }
    }
}
