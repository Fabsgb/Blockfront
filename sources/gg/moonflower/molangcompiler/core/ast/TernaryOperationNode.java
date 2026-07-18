package gg.moonflower.molangcompiler.core.ast;

import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.core.compiler.MolangBytecodeEnvironment;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/TernaryOperationNode.class */
@ApiStatus.Internal
public final class TernaryOperationNode extends Record implements Node {
    private final Node value;
    private final Node left;
    private final Node right;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TernaryOperationNode.class), TernaryOperationNode.class, "value;left;right", "FIELD:Lgg/moonflower/molangcompiler/core/ast/TernaryOperationNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/TernaryOperationNode;->left:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/TernaryOperationNode;->right:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TernaryOperationNode.class, Object.class), TernaryOperationNode.class, "value;left;right", "FIELD:Lgg/moonflower/molangcompiler/core/ast/TernaryOperationNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/TernaryOperationNode;->left:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/TernaryOperationNode;->right:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Node value() {
        return this.value;
    }

    public Node left() {
        return this.left;
    }

    public Node right() {
        return this.right;
    }

    public TernaryOperationNode(Node value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return this.value + " ? " + this.left + " : " + this.right;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return this.value.isConstant();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return this.left.hasValue() && this.right.hasValue();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        return this.value.evaluate(environment) != 0.0f ? this.left.evaluate(environment) : this.right.evaluate(environment);
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        Label label_right = new Label();
        Label label_end = new Label();
        if (environment.optimize() && this.value.isConstant()) {
            if (this.value.evaluate(environment) != 0.0f) {
                this.left.writeBytecode(method, environment, breakLabel, continueLabel);
                if (this.left.hasValue() && !hasValue()) {
                    method.visitInsn(87);
                    return;
                }
                return;
            }
            this.right.writeBytecode(method, environment, breakLabel, continueLabel);
            if (this.right.hasValue() && !hasValue()) {
                method.visitInsn(87);
                return;
            }
            return;
        }
        this.value.writeBytecode(method, environment, breakLabel, continueLabel);
        method.visitInsn(11);
        method.visitInsn(149);
        method.visitJumpInsn(153, label_right);
        MolangBytecodeEnvironment localEnvironment = new MolangBytecodeEnvironment(environment);
        this.left.writeBytecode(method, localEnvironment, breakLabel, continueLabel);
        if (this.left.hasValue() && !hasValue()) {
            method.visitInsn(87);
        }
        localEnvironment.writeModifiedVariables(method);
        method.visitJumpInsn(167, label_end);
        method.visitLabel(label_right);
        MolangBytecodeEnvironment localEnvironment2 = new MolangBytecodeEnvironment(environment);
        this.right.writeBytecode(method, environment, breakLabel, continueLabel);
        if (this.right.hasValue() && !hasValue()) {
            method.visitInsn(87);
        }
        localEnvironment2.writeModifiedVariables(method);
        method.visitLabel(label_end);
    }
}
