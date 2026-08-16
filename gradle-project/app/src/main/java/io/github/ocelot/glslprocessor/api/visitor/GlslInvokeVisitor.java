package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.node.function.GlslInvokeFunctionNode;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslInvokeVisitor.class */
@ApiStatus.Experimental
public class GlslInvokeVisitor {
    private final GlslInvokeVisitor parent;

    public GlslInvokeVisitor() {
        this(null);
    }

    public GlslInvokeVisitor(@Nullable GlslInvokeVisitor parent) {
        this.parent = parent;
    }

    public void visitHeader() {
        if (this.parent != null) {
            this.parent.visitHeader();
        }
    }

    @Nullable
    public GlslNodeVisitor visitParameter(int index) {
        if (this.parent != null) {
            return this.parent.visitParameter(index);
        }
        return null;
    }

    public void visitInvokeEnd(GlslInvokeFunctionNode node) {
        if (this.parent != null) {
            this.parent.visitInvokeEnd(node);
        }
    }
}
