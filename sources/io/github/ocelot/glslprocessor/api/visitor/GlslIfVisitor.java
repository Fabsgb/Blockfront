package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.node.branch.GlslIfNode;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslIfVisitor.class */
@ApiStatus.Experimental
public class GlslIfVisitor {
    private final GlslIfVisitor parent;

    public GlslIfVisitor() {
        this(null);
    }

    public GlslIfVisitor(@Nullable GlslIfVisitor parent) {
        this.parent = parent;
    }

    @Nullable
    public GlslNodeVisitor visitIf() {
        if (this.parent != null) {
            return this.parent.visitIf();
        }
        return null;
    }

    @Nullable
    public GlslNodeVisitor visitElse() {
        if (this.parent != null) {
            return this.parent.visitElse();
        }
        return null;
    }

    public void visitIfEnd(GlslIfNode node) {
        if (this.parent != null) {
            this.parent.visitIfEnd(node);
        }
    }
}
