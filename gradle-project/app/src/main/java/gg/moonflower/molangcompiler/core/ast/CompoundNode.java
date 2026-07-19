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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/CompoundNode.class */
@ApiStatus.Internal
public final class CompoundNode extends Record implements Node {
    private final Node[] nodes;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, CompoundNode.class), CompoundNode.class, "nodes", "FIELD:Lgg/moonflower/molangcompiler/core/ast/CompoundNode;->nodes:[Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, CompoundNode.class, Object.class), CompoundNode.class, "nodes", "FIELD:Lgg/moonflower/molangcompiler/core/ast/CompoundNode;->nodes:[Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Node[] nodes() {
        return this.nodes;
    }

    public CompoundNode(Node... nodes) {
        this.nodes = nodes;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Node node : this.nodes) {
            builder.append(node).append(";\n");
        }
        return builder.toString();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return this.nodes.length == 1 && this.nodes[0].isConstant();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return this.nodes.length > 0 && this.nodes[this.nodes.length - 1].hasValue();
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        return this.nodes[0].evaluate(environment);
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        for (Node node : this.nodes) {
            node.writeBytecode(method, environment, breakLabel, continueLabel);
        }
    }
}
