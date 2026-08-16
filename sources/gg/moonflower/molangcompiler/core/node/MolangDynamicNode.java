package gg.moonflower.molangcompiler.core.node;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/node/MolangDynamicNode.class */
@ApiStatus.Internal
public final class MolangDynamicNode extends Record implements MolangExpression {
    private final Supplier<Float> value;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MolangDynamicNode.class), MolangDynamicNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangDynamicNode;->value:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MolangDynamicNode.class, Object.class), MolangDynamicNode.class, "value", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangDynamicNode;->value:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Supplier<Float> value() {
        return this.value;
    }

    public MolangDynamicNode(Supplier<Float> value) {
        this.value = value;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float get(MolangEnvironment environment) {
        return this.value.get().floatValue();
    }

    @Override // java.lang.Record
    public String toString() {
        return Float.toString(this.value.get().floatValue());
    }
}
