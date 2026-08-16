package gg.moonflower.molangcompiler.core.node;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/node/MolangCompoundNode.class */
@ApiStatus.Internal
public final class MolangCompoundNode extends Record implements MolangExpression {
    private final MolangExpression[] expressions;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MolangCompoundNode.class), MolangCompoundNode.class, "expressions", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangCompoundNode;->expressions:[Lgg/moonflower/molangcompiler/api/MolangExpression;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MolangCompoundNode.class, Object.class), MolangCompoundNode.class, "expressions", "FIELD:Lgg/moonflower/molangcompiler/core/node/MolangCompoundNode;->expressions:[Lgg/moonflower/molangcompiler/api/MolangExpression;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MolangExpression[] expressions() {
        return this.expressions;
    }

    public MolangCompoundNode(MolangExpression... expressions) {
        this.expressions = expressions;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float get(MolangEnvironment environment) throws MolangRuntimeException {
        for (int i = 0; i < this.expressions.length; i++) {
            float result = environment.resolve(this.expressions[i]);
            if (i >= this.expressions.length - 1) {
                return result;
            }
        }
        return 0.0f;
    }

    @Override // java.lang.Record
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.expressions.length; i++) {
            if (i >= this.expressions.length - 1) {
                builder.append("return ");
            }
            builder.append(this.expressions[i]);
            builder.append(';');
            if (i < this.expressions.length - 1) {
                builder.append('\n');
            }
        }
        return builder.toString();
    }
}
