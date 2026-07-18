package gg.moonflower.molangcompiler.core.ast;

import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.core.compiler.BytecodeCompiler;
import gg.moonflower.molangcompiler.core.compiler.MolangBytecodeEnvironment;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/FunctionNode.class */
@ApiStatus.Internal
public final class FunctionNode extends Record implements Node {
    private final String object;
    private final String function;
    private final Node[] arguments;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FunctionNode.class), FunctionNode.class, "object;function;arguments", "FIELD:Lgg/moonflower/molangcompiler/core/ast/FunctionNode;->object:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/FunctionNode;->function:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/FunctionNode;->arguments:[Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FunctionNode.class, Object.class), FunctionNode.class, "object;function;arguments", "FIELD:Lgg/moonflower/molangcompiler/core/ast/FunctionNode;->object:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/FunctionNode;->function:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/FunctionNode;->arguments:[Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String object() {
        return this.object;
    }

    public String function() {
        return this.function;
    }

    public Node[] arguments() {
        return this.arguments;
    }

    public FunctionNode(String object, String function, Node... arguments) {
        this.object = object;
        this.function = function;
        this.arguments = arguments;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return this.object + "." + this.function + "(" + ((String) Arrays.stream(this.arguments).map((v0) -> {
            return v0.toString();
        }).collect(Collectors.joining(", "))) + ")";
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return false;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        int objectIndex = environment.getObjectIndex(method, this.object);
        method.visitVarInsn(25, objectIndex);
        method.visitLdcInsn(this.function);
        method.visitLdcInsn(this.function + "$" + this.arguments.length);
        method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "getFunction", "(Lgg/moonflower/molangcompiler/api/object/MolangObject;Ljava/lang/String;Ljava/lang/String;)Lgg/moonflower/molangcompiler/api/MolangExpression;", false);
        int expressionIndex = environment.allocateVariable(this.object + "." + this.function + "$" + this.arguments.length);
        method.visitVarInsn(58, expressionIndex);
        for (Node node : this.arguments) {
            boolean full = (environment.optimize() && node.isConstant()) ? false : true;
            if (full) {
                node.writeBytecode(method, environment, breakLabel, continueLabel);
            }
            method.visitVarInsn(25, 1);
            if (full) {
                method.visitInsn(95);
            } else {
                BytecodeCompiler.writeFloatConst(method, node.evaluate(environment));
            }
            method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/MolangEnvironment", "loadParameter", "(F)V", true);
        }
        method.visitVarInsn(25, expressionIndex);
        method.visitVarInsn(25, 1);
        method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/MolangExpression", "resolve", "(Lgg/moonflower/molangcompiler/api/MolangEnvironment;)F", true);
        method.visitVarInsn(25, 1);
        method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/MolangEnvironment", "clearParameters", "()V", true);
    }
}
