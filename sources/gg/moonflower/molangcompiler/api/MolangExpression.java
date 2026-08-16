package gg.moonflower.molangcompiler.api;

import gg.moonflower.molangcompiler.api.bridge.MolangJavaFunction;
import gg.moonflower.molangcompiler.api.bridge.MolangVariable;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.core.node.MolangCompoundNode;
import gg.moonflower.molangcompiler.core.node.MolangConstantNode;
import gg.moonflower.molangcompiler.core.node.MolangDynamicNode;
import gg.moonflower.molangcompiler.core.node.MolangFunctionNode;
import gg.moonflower.molangcompiler.core.node.MolangLazyNode;
import gg.moonflower.molangcompiler.core.node.MolangVariableNode;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangExpression.class */
public interface MolangExpression {
    public static final MolangExpression ZERO = m8349of(0.0f);

    @ApiStatus.OverrideOnly
    float get(MolangEnvironment molangEnvironment) throws MolangRuntimeException;

    default float getConstant() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Expression is not constant");
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "4.0.0")
    @Deprecated
    default float resolve(MolangEnvironment environment) throws MolangRuntimeException {
        return environment.resolve(this);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "4.0.0")
    @Deprecated
    default float safeResolve(MolangEnvironment environment) {
        return environment.safeResolve(this);
    }

    default boolean isConstant() {
        return false;
    }

    default MolangExpression getCopy() {
        return this;
    }

    /* JADX INFO: renamed from: of */
    static MolangExpression m8349of(float value) {
        return new MolangConstantNode(value);
    }

    /* JADX INFO: renamed from: of */
    static MolangExpression m8350of(boolean value) {
        return new MolangConstantNode(value ? 1.0f : 0.0f);
    }

    /* JADX INFO: renamed from: of */
    static MolangExpression m8351of(Supplier<Float> value) {
        return new MolangDynamicNode(value);
    }

    static MolangExpression lazy(Supplier<Float> value) {
        return new MolangLazyNode(value);
    }

    static MolangExpression function(int params, MolangJavaFunction consumer) {
        return new MolangFunctionNode(params, consumer);
    }

    static MolangExpression function(MolangJavaFunction consumer) {
        return new MolangFunctionNode(-1, consumer);
    }

    /* JADX INFO: renamed from: of */
    static MolangExpression m8352of(BooleanSupplier value) {
        return new MolangDynamicNode(() -> {
            return Float.valueOf(value.getAsBoolean() ? 1.0f : 0.0f);
        });
    }

    static MolangExpression lazy(BooleanSupplier value) {
        return new MolangLazyNode(() -> {
            return Float.valueOf(value.getAsBoolean() ? 1.0f : 0.0f);
        });
    }

    /* JADX INFO: renamed from: of */
    static MolangExpression m8353of(MolangVariable value) {
        return new MolangVariableNode(value);
    }

    /* JADX INFO: renamed from: of */
    static MolangExpression m8354of(MolangExpression... expressions) {
        if (expressions.length == 0) {
            return ZERO;
        }
        if (expressions.length == 1) {
            return expressions[0];
        }
        return new MolangCompoundNode(expressions);
    }
}
