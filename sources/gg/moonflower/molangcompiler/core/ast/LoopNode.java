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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/LoopNode.class */
@ApiStatus.Internal
public final class LoopNode extends Record implements Node {
    private final Node iterations;
    private final Node body;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, LoopNode.class), LoopNode.class, "iterations;body", "FIELD:Lgg/moonflower/molangcompiler/core/ast/LoopNode;->iterations:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/LoopNode;->body:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, LoopNode.class, Object.class), LoopNode.class, "iterations;body", "FIELD:Lgg/moonflower/molangcompiler/core/ast/LoopNode;->iterations:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/LoopNode;->body:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Node iterations() {
        return this.iterations;
    }

    public Node body() {
        return this.body;
    }

    public LoopNode(Node iterations, Node body) {
        this.iterations = iterations;
        this.body = body;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return "loop(" + this.iterations + ", {" + this.body + "})";
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return false;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return false;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        Label begin = new Label();
        Label next = new Label();
        Label end = new Label();
        this.iterations.writeBytecode(method, environment, breakLabel, continueLabel);
        method.visitInsn(139);
        BytecodeCompiler.writeIntConst(method, 0);
        method.visitLabel(begin);
        this.body.writeBytecode(method, environment, end, next);
        if (this.body.hasValue()) {
            method.visitInsn(87);
        }
        method.visitLabel(next);
        method.visitInsn(4);
        method.visitInsn(96);
        method.visitInsn(92);
        method.visitJumpInsn(163, begin);
        method.visitLabel(end);
    }
}
