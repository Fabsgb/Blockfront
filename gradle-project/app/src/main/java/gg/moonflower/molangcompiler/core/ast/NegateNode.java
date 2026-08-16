package gg.moonflower.molangcompiler.core.ast;

import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.core.compiler.BytecodeCompiler;
import gg.moonflower.molangcompiler.core.compiler.MolangBytecodeEnvironment;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/NegateNode.class */
@ApiStatus.Internal
public final class NegateNode extends Record implements Node {
    private final Node value;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, NegateNode.class), NegateNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/ast/NegateNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, NegateNode.class, Object.class), NegateNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/ast/NegateNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Node value() {
        return this.value;
    }

    public NegateNode(Node value) {
        this.value = value;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return "!" + this.value;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return this.value.isConstant();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        return this.value.evaluate(environment) == 0.0f ? 1.0f : 0.0f;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        if (environment.optimize() && isConstant()) {
            BytecodeCompiler.writeFloatConst(method, evaluate(environment));
            return;
        }
        Label label_right = new Label();
        Label label_end = new Label();
        this.value.writeBytecode(method, environment, breakLabel, continueLabel);
        method.visitInsn(11);
        method.visitInsn(149);
        method.visitJumpInsn(153, label_right);
        method.visitInsn(12);
        method.visitJumpInsn(167, label_end);
        method.visitLabel(label_right);
        method.visitInsn(11);
        method.visitLabel(label_end);
    }
}
