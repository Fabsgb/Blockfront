package gg.moonflower.molangcompiler.core.ast;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/MathOperation.class */
@ApiStatus.Internal
public enum MathOperation {
    ABS(1),
    ACOS(1),
    ASIN(1),
    ATAN(1),
    ATAN2(2),
    CEIL(1),
    CLAMP(3),
    COS(1),
    SIN(1),
    DIE_ROLL(3, false),
    DIE_ROLL_INTEGER(3, false),
    EXP(1),
    FLOOR(1),
    HERMITE_BLEND(1),
    LERP(3),
    LERPROTATE(3),
    LN(1),
    MAX(2),
    MIN(2),
    MIN_ANGLE(1),
    MOD(2),
    PI(0),
    POW(2),
    RANDOM(2, false),
    RANDOM_INTEGER(2, false),
    ROUND(1),
    SQRT(1),
    TRUNC(1),
    SIGN(1),
    TRIANGLE_WAVE(2);

    private final String name;
    private final int parameters;
    private final boolean deterministic;

    MathOperation(int parameters) {
        this(parameters, true);
    }

    MathOperation(int parameters, boolean deterministic) {
        this.parameters = parameters;
        this.deterministic = deterministic;
        this.name = name().toLowerCase(Locale.ROOT);
    }

    public int getParameters() {
        return this.parameters;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDeterministic() {
        return this.deterministic;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
