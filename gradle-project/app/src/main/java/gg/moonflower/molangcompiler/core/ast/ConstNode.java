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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/ConstNode.class */
@ApiStatus.Internal
public final class ConstNode extends Record implements Node {
    private final float value;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ConstNode.class), ConstNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/ast/ConstNode;->value:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ConstNode.class, Object.class), ConstNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/ast/ConstNode;->value:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public float value() {
        return this.value;
    }

    public ConstNode(float value) {
        this.value = value;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        return this.value;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        BytecodeCompiler.writeFloatConst(method, this.value);
    }
}
