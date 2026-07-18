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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/BinaryConditionalNode.class */
@ApiStatus.Internal
public final class BinaryConditionalNode extends Record implements Node {
    private final Node value;
    private final Node branch;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BinaryConditionalNode.class), BinaryConditionalNode.class, "value;branch", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryConditionalNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryConditionalNode;->branch:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BinaryConditionalNode.class, Object.class), BinaryConditionalNode.class, "value;branch", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryConditionalNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryConditionalNode;->branch:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Node value() {
        return this.value;
    }

    public Node branch() {
        return this.branch;
    }

    public BinaryConditionalNode(Node value, Node branch) {
        this.value = value;
        this.branch = branch;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return this.value + " ? " + this.branch;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return this.value.isConstant();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return false;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        if (this.value.evaluate(environment) != 0.0f) {
            return this.branch.evaluate(environment);
        }
        return 0.0f;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        Label label_end = new Label();
        if (environment.optimize() && this.value.isConstant()) {
            if (this.value.evaluate(environment) != 0.0f) {
                this.branch.writeBytecode(method, environment, breakLabel, continueLabel);
            }
        } else {
            this.value.writeBytecode(method, environment, breakLabel, continueLabel);
            method.visitInsn(11);
            method.visitInsn(149);
            method.visitJumpInsn(153, label_end);
            this.branch.writeBytecode(method, environment, breakLabel, continueLabel);
            method.visitLabel(label_end);
        }
    }
}
