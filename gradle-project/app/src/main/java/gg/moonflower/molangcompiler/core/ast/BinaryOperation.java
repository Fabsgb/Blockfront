package gg.moonflower.molangcompiler.core.ast;

import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/BinaryOperation.class */
@ApiStatus.Internal
public enum BinaryOperation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    AND("&&"),
    OR("||"),
    EQUALS("=="),
    NOT_EQUALS("!="),
    LESS_EQUALS("<="),
    LESS("<"),
    GREATER_EQUALS(">="),
    GREATER(">"),
    NULL_COALESCING("??");

    private final String value;

    BinaryOperation(String value) {
        this.value = (String) Objects.requireNonNull(value, "value");
    }

    public String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
