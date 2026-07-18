package gg.moonflower.molangcompiler.core.node;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/node/MolangConstantNode.class */
@ApiStatus.Internal
public final class MolangConstantNode extends Record implements MolangExpression {
    private final float value;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MolangConstantNode.class), MolangConstantNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangConstantNode;->value:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MolangConstantNode.class, Object.class), MolangConstantNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangConstantNode;->value:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public float value() {
        return this.value;
    }

    public MolangConstantNode(float value) {
        this.value = value;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float get(@Nullable MolangEnvironment environment) {
        return this.value;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float getConstant() {
        return this.value;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public boolean isConstant() {
        return true;
    }

    @Override // java.lang.Record
    public String toString() {
        return Float.toString(this.value);
    }
}
