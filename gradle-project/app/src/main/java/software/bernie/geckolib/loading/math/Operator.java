package software.bernie.geckolib.loading.math;

import it.unimi.dsi.fastutil.chars.CharOpenHashSet;
import it.unimi.dsi.fastutil.chars.CharSet;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.Util;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/Operator.class */
public final class Operator extends Record implements Comparable<Operator> {
    private final String symbol;
    private final int precedence;
    private final Operation operation;
    private static int LONGEST_OPERATOR;
    private static final Map<String, Operator> OPERATORS = new Object2ObjectOpenHashMap(14);
    private static final CharSet OPERATOR_SYMBOLS = (CharSet) Util.make(new CharOpenHashSet(15), set -> {
        set.addAll(Arrays.asList('?', ':', ','));
    });
    public static final Operator ADD = register("+", 1, (a, b) -> {
        return a + b;
    });
    public static final Operator SUB = register("-", 1, (a, b) -> {
        return a - b;
    });
    public static final Operator MUL = register("*", 2, (a, b) -> {
        return a * b;
    });
    public static final Operator DIV = register("/", 2, (a, b) -> {
        return b == 0.0d ? a : a / b;
    });
    public static final Operator MOD = register("%", 2, (a, b) -> {
        return b == 0.0d ? a : a % b;
    });
    public static final Operator POW = register("^", 3, Math::pow);
    public static final Operator AND = register("&&", 5, (a, b) -> {
        return (a == 0.0d || b == 0.0d) ? 0.0d : 1.0d;
    });
    public static final Operator OR = register("||", 5, (a, b) -> {
        return (a == 0.0d && b == 0.0d) ? 0.0d : 1.0d;
    });
    public static final Operator LT = register("<", 5, (a, b) -> {
        return a < b ? 1.0d : 0.0d;
    });
    public static final Operator LTE = register("<=", 5, (a, b) -> {
        return a <= b ? 1.0d : 0.0d;
    });
    public static final Operator GT = register(">", 5, (a, b) -> {
        return a > b ? 1.0d : 0.0d;
    });
    public static final Operator GTE = register(">=", 5, (a, b) -> {
        return a >= b ? 1.0d : 0.0d;
    });
    public static final Operator EQUAL = register("==", 5, (a, b) -> {
        return Math.abs(a - b) < 1.0E-5d ? 1.0d : 0.0d;
    });
    public static final Operator NOT_EQUAL = register("!=", 5, (a, b) -> {
        return Math.abs(a - b) >= 1.0E-5d ? 1.0d : 0.0d;
    });
    public static final Operator ASSIGN_VARIABLE = register("=", Integer.MAX_VALUE, (a, b) -> {
        return 0.0d;
    });

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/loading/math/Operator$Operation.class */
    @FunctionalInterface
    public interface Operation {
        double compute(double d, double d2);
    }

    public Operator(String symbol, int precedence, Operation operation) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.operation = operation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Operator.class), Operator.class, "symbol;precedence;operation", "FIELD:Lsoftware/bernie/geckolib/loading/math/Operator;->symbol:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/math/Operator;->precedence:I", "FIELD:Lsoftware/bernie/geckolib/loading/math/Operator;->operation:Lsoftware/bernie/geckolib/loading/math/Operator$Operation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Operator.class, Object.class), Operator.class, "symbol;precedence;operation", "FIELD:Lsoftware/bernie/geckolib/loading/math/Operator;->symbol:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/loading/math/Operator;->precedence:I", "FIELD:Lsoftware/bernie/geckolib/loading/math/Operator;->operation:Lsoftware/bernie/geckolib/loading/math/Operator$Operation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String symbol() {
        return this.symbol;
    }

    public int precedence() {
        return this.precedence;
    }

    public Operation operation() {
        return this.operation;
    }

    public static Operator register(String symbol, int precedence, Operation operation) {
        Operator operator = new Operator(symbol, precedence, operation);
        if (OPERATORS.put(symbol, operator) != null) {
            throw new IllegalArgumentException("Attempting to register an already existing operator! '" + symbol + "'");
        }
        for (char symbolChar : symbol.toCharArray()) {
            OPERATOR_SYMBOLS.add(symbolChar);
        }
        LONGEST_OPERATOR = Math.max(LONGEST_OPERATOR, symbol.length());
        return operator;
    }

    public static boolean isOperator(String symbol) {
        return OPERATORS.containsKey(symbol);
    }

    public static Optional<Operator> getOperatorFor(String symbol) {
        return Optional.ofNullable(OPERATORS.get(symbol));
    }

    public static int maxOperatorLength() {
        return LONGEST_OPERATOR;
    }

    public static boolean isOperativeSymbol(char symbol) {
        return OPERATOR_SYMBOLS.contains(symbol);
    }

    public double compute(double argA, double argB) {
        return this.operation.compute(argA, argB);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Operator operator) {
        return Integer.compare(this.precedence, operator.precedence);
    }

    public boolean takesPrecedenceOver(Operator operator) {
        return compareTo(operator) > 0;
    }

    @Override // java.lang.Record
    public int hashCode() {
        return Objects.hash(this.symbol);
    }
}
