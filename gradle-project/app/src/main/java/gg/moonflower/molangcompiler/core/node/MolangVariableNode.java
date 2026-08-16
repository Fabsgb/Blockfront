package gg.moonflower.molangcompiler.core.node;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.bridge.MolangVariable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/node/MolangVariableNode.class */
@ApiStatus.Internal
public final class MolangVariableNode extends Record implements MolangExpression, MolangVariable {
    private final MolangVariable value;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MolangVariableNode.class), MolangVariableNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangVariableNode;->value:Lgg/moonflower/molangcompiler/api/bridge/MolangVariable;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MolangVariableNode.class, Object.class), MolangVariableNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangVariableNode;->value:Lgg/moonflower/molangcompiler/api/bridge/MolangVariable;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MolangVariable value() {
        return this.value;
    }

    public MolangVariableNode(MolangVariable value) {
        this.value = value;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float get(MolangEnvironment environment) {
        return this.value.getValue();
    }

    @Override // java.lang.Record
    public String toString() {
        return Float.toString(this.value.getValue());
    }

    @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
    public float getValue() {
        return this.value.getValue();
    }

    @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
    public void setValue(float value) {
        this.value.setValue(value);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public MolangExpression getCopy() {
        return new MolangVariableNode(copy());
    }

    @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariable
    public MolangVariable copy() {
        return this.value.copy();
    }
}
