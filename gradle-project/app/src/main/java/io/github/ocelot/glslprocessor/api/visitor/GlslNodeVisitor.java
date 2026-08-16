package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.node.branch.GlslForLoopNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslIfNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslJumpNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslReturnNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslSwitchNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslWhileLoopNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslAssignmentNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslBitwiseNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslCompareNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslConditionalNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslOperationNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslPrecisionNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslUnaryNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslInvokeFunctionNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslPrimitiveConstructorNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslGetArrayNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslGetFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableNode;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslNodeVisitor.class */
@ApiStatus.Experimental
public class GlslNodeVisitor {
    private final GlslNodeVisitor parent;

    public GlslNodeVisitor() {
        this(null);
    }

    public GlslNodeVisitor(@Nullable GlslNodeVisitor parent) {
        this.parent = parent;
    }

    @Nullable
    public GlslNodeVisitor visitForLoop(GlslForLoopNode node) {
        if (this.parent != null) {
            return this.parent.visitForLoop(node);
        }
        return null;
    }

    public void visitForLoopEnd(GlslForLoopNode node) {
        if (this.parent != null) {
            this.parent.visitForLoopEnd(node);
        }
    }

    @Nullable
    public GlslNodeVisitor visitWhileLoop(GlslWhileLoopNode node) {
        if (this.parent != null) {
            return this.parent.visitWhileLoop(node);
        }
        return null;
    }

    public void visitWhileLoopEnd(GlslWhileLoopNode node) {
        if (this.parent != null) {
            this.parent.visitWhileLoopEnd(node);
        }
    }

    public void visitJump(GlslJumpNode node) {
        if (this.parent != null) {
            this.parent.visitJump(node);
        }
    }

    public void visitReturn(GlslReturnNode node) {
        if (this.parent != null) {
            this.parent.visitReturn(node);
        }
    }

    @Nullable
    public GlslIfVisitor visitIf(GlslIfNode node) {
        if (this.parent != null) {
            return this.parent.visitIf(node);
        }
        return null;
    }

    @Nullable
    public GlslSwitchVisitor visitSwitch(GlslSwitchNode node) {
        if (this.parent != null) {
            return this.parent.visitSwitch(node);
        }
        return null;
    }

    @Nullable
    public GlslBitwiseVisitor visitBitwise(GlslBitwiseNode node) {
        if (this.parent != null) {
            return this.parent.visitBitwise(node);
        }
        return null;
    }

    public void visitAssign(GlslAssignmentNode node) {
        if (this.parent != null) {
            this.parent.visitAssign(node);
        }
    }

    public void visitOperation(GlslOperationNode node) {
        if (this.parent != null) {
            this.parent.visitOperation(node);
        }
    }

    public void visitCompare(GlslCompareNode node) {
        if (this.parent != null) {
            this.parent.visitCompare(node);
        }
    }

    public void visitCondition(GlslConditionalNode node) {
        if (this.parent != null) {
            this.parent.visitCondition(node);
        }
    }

    public void visitPrecision(GlslPrecisionNode node) {
        if (this.parent != null) {
            this.parent.visitPrecision(node);
        }
    }

    public void visitUnary(GlslUnaryNode node) {
        if (this.parent != null) {
            this.parent.visitUnary(node);
        }
    }

    @Nullable
    public GlslInvokeVisitor visitFunctionInvocation(GlslInvokeFunctionNode node) {
        if (this.parent != null) {
            return this.parent.visitFunctionInvocation(node);
        }
        return null;
    }

    public void visitPrimitiveConstructor(GlslPrimitiveConstructorNode node) {
        if (this.parent != null) {
            this.parent.visitPrimitiveConstructor(node);
        }
    }

    public void visitConstant(GlslConstantNode node) {
        if (this.parent != null) {
            this.parent.visitConstant(node);
        }
    }

    public void visitVariableDeclaration(GlslVariableDeclarationNode node) {
        if (this.parent != null) {
            this.parent.visitVariableDeclaration(node);
        }
    }

    public void visitGetArray(GlslGetArrayNode node) {
        if (this.parent != null) {
            this.parent.visitGetArray(node);
        }
    }

    public void visitGetField(GlslGetFieldNode node) {
        if (this.parent != null) {
            this.parent.visitGetField(node);
        }
    }

    public void visitNewField(GlslNewFieldNode node) {
        if (this.parent != null) {
            this.parent.visitNewField(node);
        }
    }

    public void visitStructDeclaration(GlslStructDeclarationNode node) {
        if (this.parent != null) {
            this.parent.visitStructDeclaration(node);
        }
    }

    public void visitVariable(GlslVariableNode node) {
        if (this.parent != null) {
            this.parent.visitVariable(node);
        }
    }
}
