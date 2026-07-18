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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/VariableSetNode.class */
@ApiStatus.Internal
public final class VariableSetNode extends Record implements OptionalValueNode {
    private final String object;
    private final String name;
    private final Node value;
    private final boolean returnValue;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, VariableSetNode.class), VariableSetNode.class, "object;name;value;returnValue", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->object:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->name:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->returnValue:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, VariableSetNode.class, Object.class), VariableSetNode.class, "object;name;value;returnValue", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->object:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->name:Ljava/lang/String;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->value:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/VariableSetNode;->returnValue:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String object() {
        return this.object;
    }

    public String name() {
        return this.name;
    }

    public Node value() {
        return this.value;
    }

    public boolean returnValue() {
        return this.returnValue;
    }

    public VariableSetNode(String object, String name, Node value, boolean returnValue) {
        this.object = object;
        this.name = name;
        this.value = value;
        this.returnValue = returnValue;
    }

    public VariableSetNode(String object, String name, Node value) {
        this(object, name, value, false);
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return this.object + "." + this.name + " = " + this.value;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return false;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return this.returnValue;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        if (!"temp".equals(this.object)) {
            environment.getObjectIndex(method, this.object);
        }
        this.value.writeBytecode(method, environment, breakLabel, continueLabel);
        if (this.returnValue) {
            method.visitInsn(89);
        }
        int index = environment.allocateVariable(this.object + "." + this.name);
        method.visitVarInsn(56, index);
        environment.markDirty(this.object, this.name);
    }

    @Override // gg.moonflower.molangcompiler.core.ast.OptionalValueNode
    public VariableSetNode withReturnValue() {
        return this.returnValue ? this : new VariableSetNode(this.object, this.name, this.value, true);
    }
}
