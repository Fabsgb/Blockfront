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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/VariableGetNode.class */
@ApiStatus.Internal
public final class VariableGetNode extends Record implements Node {
    private final String object;
    private final String name;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VariableGetNode.class), VariableGetNode.class, "object;name", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableGetNode;->object:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableGetNode;->name:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VariableGetNode.class, Object.class), VariableGetNode.class, "object;name", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableGetNode;->object:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableGetNode;->name:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String object() {
        return this.object;
    }

    public String name() {
        return this.name;
    }

    public VariableGetNode(String object, String name) {
        this.object = object;
        this.name = name;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return this.object + "." + this.name;
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
        int index = environment.loadVariable(method, this.object, this.name);
        method.visitVarInsn(23, index);
    }
}
