package software.bernie.geckolib.loading.math;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.mojang.datafixers.util.Either;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import net.minecraft.Util;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.loading.math.function.MathFunction;
import software.bernie.geckolib.loading.math.function.generic.ACosFunction;
import software.bernie.geckolib.loading.math.function.generic.ASinFunction;
import software.bernie.geckolib.loading.math.function.generic.ATan2Function;
import software.bernie.geckolib.loading.math.function.generic.ATanFunction;
import software.bernie.geckolib.loading.math.function.generic.AbsFunction;
import software.bernie.geckolib.loading.math.function.generic.CosFunction;
import software.bernie.geckolib.loading.math.function.generic.ExpFunction;
import software.bernie.geckolib.loading.math.function.generic.LogFunction;
import software.bernie.geckolib.loading.math.function.generic.ModFunction;
import software.bernie.geckolib.loading.math.function.generic.PowFunction;
import software.bernie.geckolib.loading.math.function.generic.SinFunction;
import software.bernie.geckolib.loading.math.function.generic.SqrtFunction;
import software.bernie.geckolib.loading.math.function.limit.ClampFunction;
import software.bernie.geckolib.loading.math.function.limit.MaxFunction;
import software.bernie.geckolib.loading.math.function.limit.MinFunction;
import software.bernie.geckolib.loading.math.function.misc.PiFunction;
import software.bernie.geckolib.loading.math.function.misc.ToDegFunction;
import software.bernie.geckolib.loading.math.function.misc.ToRadFunction;
import software.bernie.geckolib.loading.math.function.random.DieRollFunction;
import software.bernie.geckolib.loading.math.function.random.DieRollIntegerFunction;
import software.bernie.geckolib.loading.math.function.random.RandomFunction;
import software.bernie.geckolib.loading.math.function.random.RandomIntegerFunction;
import software.bernie.geckolib.loading.math.function.round.CeilFunction;
import software.bernie.geckolib.loading.math.function.round.FloorFunction;
import software.bernie.geckolib.loading.math.function.round.HermiteBlendFunction;
import software.bernie.geckolib.loading.math.function.round.LerpFunction;
import software.bernie.geckolib.loading.math.function.round.LerpRotFunction;
import software.bernie.geckolib.loading.math.function.round.RoundFunction;
import software.bernie.geckolib.loading.math.function.round.TruncateFunction;
import software.bernie.geckolib.loading.math.value.BooleanNegate;
import software.bernie.geckolib.loading.math.value.Calculation;
import software.bernie.geckolib.loading.math.value.CompoundValue;
import software.bernie.geckolib.loading.math.value.Constant;
import software.bernie.geckolib.loading.math.value.Group;
import software.bernie.geckolib.loading.math.value.Negative;
import software.bernie.geckolib.loading.math.value.Ternary;
import software.bernie.geckolib.loading.math.value.Variable;
import software.bernie.geckolib.loading.math.value.VariableAssignment;
import software.bernie.geckolib.util.CompoundException;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/loading/math/MathParser.class */
public class MathParser {
    private static final String MOLANG_RETURN = "return ";
    private static final String STATEMENT_DELIMITER = ";";
    private static final Pattern EXPRESSION_FORMAT = Pattern.compile("^[\\w\\s_+-/*%^&|<>=!?:.,()]+$");
    private static final Pattern WHITESPACE = Pattern.compile("\\s");
    private static final Pattern NUMERIC = Pattern.compile("^-?\\d+(\\.\\d+)?$");
    private static final Pattern VALID_DOUBLE = Pattern.compile("[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\d+)(\\.)?((\\d+)?)([eE][+-]?(\\d+))?)|(\\.(\\d+)([eE][+-]?(\\d+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\d+)))[fFdD]?))[\\x00-\\x20]*");
    private static final Map<String, MathFunction.Factory<?>> FUNCTION_FACTORIES = (Map) Util.make(new ConcurrentHashMap(18), map -> {
        map.put("math.abs", AbsFunction::new);
        map.put("math.acos", ACosFunction::new);
        map.put("math.asin", ASinFunction::new);
        map.put("math.atan", ATanFunction::new);
        map.put("math.atan2", ATan2Function::new);
        map.put("math.ceil", CeilFunction::new);
        map.put("math.clamp", ClampFunction::new);
        map.put("math.cos", CosFunction::new);
        map.put("math.die_roll", DieRollFunction::new);
        map.put("math.die_roll_integer", DieRollIntegerFunction::new);
        map.put("math.exp", ExpFunction::new);
        map.put("math.floor", FloorFunction::new);
        map.put("math.hermite_blend", HermiteBlendFunction::new);
        map.put("math.lerp", LerpFunction::new);
        map.put("math.lerprotate", LerpRotFunction::new);
        map.put("math.ln", LogFunction::new);
        map.put("math.max", MaxFunction::new);
        map.put("math.min", MinFunction::new);
        map.put("math.mod", ModFunction::new);
        map.put("math.pi", PiFunction::new);
        map.put("math.pow", PowFunction::new);
        map.put("math.random", RandomFunction::new);
        map.put("math.random_integer", RandomIntegerFunction::new);
        map.put("math.round", RoundFunction::new);
        map.put("math.sin", SinFunction::new);
        map.put("math.sqrt", SqrtFunction::new);
        map.put("math.to_deg", ToDegFunction::new);
        map.put("math.to_rad", ToRadFunction::new);
        map.put("math.trunc", TruncateFunction::new);
    });

    public static boolean isFunctionRegistered(String name) {
        return FUNCTION_FACTORIES.containsKey(name);
    }

    public static void registerFunction(String name, MathFunction.Factory<?> factory) {
        if (FUNCTION_FACTORIES.put(name, factory) != null) {
            GeckoLibConstants.LOGGER.log(Level.WARN, "Duplicate registration of MathFunction: '" + name + "'. Ignore if intentional override");
        }
        GeckoLibConstants.LOGGER.log(Level.DEBUG, "Registered MathFunction '" + name + "'");
    }

    @Nullable
    public static <T extends MathFunction> T buildFunction(String str, MathValue... mathValueArr) {
        if (!FUNCTION_FACTORIES.containsKey(str)) {
            return null;
        }
        return (T) FUNCTION_FACTORIES.get(str).create(mathValueArr);
    }

    public static void registerVariable(Variable variable) {
        MolangQueries.registerVariable(variable);
    }

    public static Variable getVariableFor(String name) {
        return MolangQueries.getVariableFor(name);
    }

    public static void setVariable(String name, DoubleSupplier value) {
        getVariableFor(name).set(value);
    }

    public static MathValue parseJson(JsonElement element) {
        if (element instanceof JsonPrimitive) {
            JsonPrimitive primitive = (JsonPrimitive) element;
            if (!primitive.isBoolean()) {
                if (primitive.isNumber()) {
                    return new Constant(primitive.getAsDouble());
                }
                if (primitive.isString()) {
                    String value = primitive.getAsString();
                    if (VALID_DOUBLE.matcher(value).matches()) {
                        return new Constant(Double.parseDouble(value));
                    }
                    return compileMolang(value);
                }
                return new Constant(0.0d);
            }
        }
        throw new CompoundException("Bad formatting on Molang expression, expected single value, received: " + element.getClass().getSimpleName());
    }

    public static MathValue compileMolang(String expression) {
        if (expression.startsWith(MOLANG_RETURN)) {
            expression = expression.substring(MOLANG_RETURN.length());
            if (expression.contains(STATEMENT_DELIMITER)) {
                expression = expression.substring(0, expression.indexOf(STATEMENT_DELIMITER));
            }
        } else if (expression.contains(STATEMENT_DELIMITER)) {
            String[] subExpressions = expression.split(STATEMENT_DELIMITER);
            ObjectArrayList objectArrayList = new ObjectArrayList(subExpressions.length);
            for (String subExpression : subExpressions) {
                boolean isReturn = subExpression.startsWith(MOLANG_RETURN);
                if (isReturn) {
                    subExpression = subExpression.substring(MOLANG_RETURN.length());
                }
                objectArrayList.add(compileExpression(subExpression));
                if (isReturn) {
                    break;
                }
            }
            return new CompoundValue((MathValue[]) objectArrayList.toArray(new MathValue[0]));
        }
        return compileExpression(expression);
    }

    public static MathValue compileExpression(String expression) {
        try {
            return parseSymbols(compileSymbols(decomposeExpression(expression)));
        } catch (CompoundException ex) {
            throw ex.withMessage("Failed to parse expression '" + expression + "'");
        }
    }

    public static char[] decomposeExpression(String expression) throws CompoundException {
        if (expression.isEmpty()) {
            return new char[]{0};
        }
        if (!EXPRESSION_FORMAT.matcher(expression).matches()) {
            throw new CompoundException("Invalid characters found in expression: '" + expression + "'");
        }
        char[] chars = WHITESPACE.matcher(expression).replaceAll("").toLowerCase(Locale.ROOT).toCharArray();
        int groupState = 0;
        for (char character : chars) {
            if (character == '(') {
                groupState++;
            } else if (character == ')') {
                groupState--;
            }
            if (groupState < 0) {
                throw new CompoundException("Closing parenthesis before opening parenthesis in expression '" + expression + "'");
            }
        }
        if (groupState != 0) {
            throw new CompoundException("Uneven parenthesis in expression, each opening brace must have a pairing close brace '" + expression + "'");
        }
        return chars;
    }

    @Nullable
    protected static String tryMergeOperativeSymbols(char[] chars, int index) {
        char ch = chars[index];
        if (!Operator.isOperativeSymbol(ch)) {
            return null;
        }
        int maxLength = Math.min(chars.length - index, Operator.maxOperatorLength());
        for (int length = maxLength; length > 0; length--) {
            String testOperator = String.copyValueOf(chars, index, length);
            if (Operator.isOperator(testOperator)) {
                return testOperator;
            }
        }
        if (ch == '?' || ch == ':' || ch == ',') {
            return String.valueOf(ch);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x01a0  */
    public static List<Either<String, List<MathValue>>> compileSymbols(char[] chars) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        StringBuilder buffer = new StringBuilder();
        int lastSymbolIndex = -1;
        int i = 0;
        while (i < chars.length) {
            char ch = chars[i];
            if (ch == '-' && buffer.isEmpty() && (objectArrayList.isEmpty() || lastSymbolIndex == objectArrayList.size() - 1)) {
                buffer.append(ch);
            } else {
                String operator = tryMergeOperativeSymbols(chars, i);
                if (operator != null) {
                    i += operator.length() - 1;
                    if (!buffer.isEmpty()) {
                        objectArrayList.add(Either.left(buffer.toString()));
                    }
                    lastSymbolIndex = objectArrayList.size();
                    objectArrayList.add(Either.left(operator));
                    buffer.setLength(0);
                } else if (ch == '(') {
                    if (!buffer.isEmpty()) {
                        objectArrayList.add(Either.left(buffer.toString()));
                        buffer.setLength(0);
                    }
                    ObjectArrayList objectArrayList2 = new ObjectArrayList();
                    int groupState = 1;
                    for (int j = i + 1; j < chars.length; j++) {
                        char groupChar = chars[j];
                        if (groupChar == '(') {
                            groupState++;
                        } else if (groupChar == ')') {
                            groupState--;
                        } else {
                            if (groupChar == ',' && groupState == 1) {
                                objectArrayList2.add(parseSymbols(compileSymbols(buffer.toString().toCharArray())));
                                buffer.setLength(0);
                            }
                        }
                        if (groupState == 0) {
                            if (!buffer.isEmpty()) {
                                if (!objectArrayList.isEmpty()) {
                                    String str = "-";
                                    if (((Either) objectArrayList.getLast()).left().filter((v1) -> {
                                        return r1.equals(v1);
                                    }).isPresent() && (objectArrayList.size() == 1 || ((Either) objectArrayList.get(objectArrayList.size() - 2)).left().filter(Operator::isOperator).isPresent())) {
                                        objectArrayList.removeLast();
                                        objectArrayList2.add(new Negative(parseSymbols(compileSymbols(buffer.toString().toCharArray()))));
                                    } else {
                                        objectArrayList2.add(parseSymbols(compileSymbols(buffer.toString().toCharArray())));
                                    }
                                } else {
                                    objectArrayList2.add(parseSymbols(compileSymbols(buffer.toString().toCharArray())));
                                }
                            }
                            i = j;
                            objectArrayList.add(Either.right(objectArrayList2));
                            buffer.setLength(0);
                            break;
                        }
                        buffer.append(groupChar);
                    }
                } else {
                    buffer.append(ch);
                }
            }
            i++;
        }
        if (!buffer.isEmpty()) {
            objectArrayList.add(Either.left(buffer.toString()));
        }
        return objectArrayList;
    }

    public static MathValue parseSymbols(List<Either<String, List<MathValue>>> symbols) throws CompoundException {
        if (symbols.size() == 2) {
            Optional<String> prefix = ((Either) symbols.getFirst()).left().filter(left -> {
                return left.startsWith("-") || left.startsWith("!") || isFunctionRegistered(left);
            });
            Optional<List<MathValue>> group = symbols.get(1).right();
            if (prefix.isPresent() && group.isPresent()) {
                return compileFunction(prefix.get(), group.get());
            }
        }
        MathValue value = compileValue(symbols);
        if (value != null) {
            return value;
        }
        throw new CompoundException("Unable to parse compiled symbols from expression: " + String.valueOf(symbols));
    }

    @Nullable
    protected static MathValue compileValue(List<Either<String, List<MathValue>>> symbols) throws CompoundException {
        if (symbols.size() == 1) {
            return compileSingleValue((Either) symbols.getFirst());
        }
        Ternary ternary = compileTernary(symbols);
        if (ternary != null) {
            return ternary;
        }
        return compileCalculation(symbols);
    }

    @Nullable
    protected static MathValue compileSingleValue(Either<String, List<MathValue>> symbol) throws CompoundException {
        if (symbol.right().isPresent()) {
            return new Group((MathValue) ((List) symbol.right().get()).getFirst());
        }
        return (MathValue) symbol.left().map(string -> {
            if (string.startsWith("!")) {
                return new BooleanNegate(compileSingleValue(Either.left(string.substring(1))));
            }
            if (isNumeric(string)) {
                return new Constant(Double.parseDouble(string));
            }
            if (isLikelyVariable(string)) {
                if (string.startsWith("-")) {
                    return new Negative(getVariableFor(string.substring(1)));
                }
                return getVariableFor(string);
            }
            if (isFunctionRegistered(string)) {
                return compileFunction(string, List.of());
            }
            return null;
        }).orElse(null);
    }

    @Nullable
    protected static MathValue compileCalculation(List<Either<String, List<MathValue>>> symbols) throws CompoundException {
        if (symbols.size() < 3) {
            return null;
        }
        int symbolCount = symbols.size();
        ObjectArrayList objectArrayList = new ObjectArrayList(symbolCount / 2);
        ObjectArrayList objectArrayList2 = new ObjectArrayList((symbolCount / 2) + 1);
        int lastOperatorIndex = -1;
        for (int i = 0; i < symbolCount; i++) {
            Operator operator = (Operator) symbols.get(i).left().filter(Operator::isOperator).map(MathParser::getOperatorFor).orElse(null);
            if (operator != null) {
                if (operator == Operator.ASSIGN_VARIABLE) {
                    MathValue symbols2 = parseSymbols(symbols.subList(0, i));
                    if (!(symbols2 instanceof Variable)) {
                        throw new CompoundException("Attempted to assign a value to a non-variable");
                    }
                    Variable variable = (Variable) symbols2;
                    return new VariableAssignment(variable, parseSymbols(symbols.subList(i + 1, symbolCount)));
                }
                objectArrayList2.add(parseSymbols(symbols.subList(lastOperatorIndex + 1, i)));
                objectArrayList.add(operator);
                lastOperatorIndex = i;
            }
        }
        if (objectArrayList2.isEmpty()) {
            return null;
        }
        objectArrayList2.add(parseSymbols(symbols.subList(lastOperatorIndex + 1, symbolCount)));
        while (true) {
            Operator lastOperator = null;
            int highestOperatorIndex = -1;
            for (int i2 = 0; i2 < objectArrayList.size(); i2++) {
                Operator operator2 = (Operator) objectArrayList.get(i2);
                if (lastOperator == null || operator2.takesPrecedenceOver(lastOperator)) {
                    lastOperator = operator2;
                    highestOperatorIndex = i2;
                }
            }
            if (highestOperatorIndex == -1) {
                break;
            }
            objectArrayList2.add(highestOperatorIndex, new Calculation(lastOperator, (MathValue) objectArrayList2.get(highestOperatorIndex), (MathValue) objectArrayList2.get(highestOperatorIndex + 1)));
            objectArrayList.remove(highestOperatorIndex);
            objectArrayList2.remove(highestOperatorIndex + 1);
            objectArrayList2.remove(highestOperatorIndex + 1);
        }
        if (objectArrayList2.size() != 1) {
            throw new CompoundException("Invalidly formatted expression: " + String.valueOf(symbols));
        }
        return (MathValue) objectArrayList2.getFirst();
    }

    @Nullable
    protected static Ternary compileTernary(List<Either<String, List<MathValue>>> symbols) throws CompoundException {
        int symbolCount = symbols.size();
        if (symbolCount < 3) {
            return null;
        }
        Supplier<MathValue> condition = null;
        Supplier<MathValue> ifTrue = null;
        int ternaryState = 0;
        int lastColon = -1;
        int queryIndex = -1;
        for (int i = 0; i < symbolCount; i++) {
            int i2 = i;
            String string = (String) symbols.get(i).left().orElse(null);
            if ("?".equals(string)) {
                if (condition == null) {
                    condition = () -> {
                        return parseSymbols(symbols.subList(0, i2));
                    };
                    queryIndex = i2 + 1;
                }
                ternaryState++;
            } else if (":".equals(string)) {
                if (ternaryState == 1 && ifTrue == null && queryIndex > 0) {
                    int queryIndex2 = queryIndex;
                    ifTrue = () -> {
                        return parseSymbols(symbols.subList(queryIndex2, i2));
                    };
                }
                ternaryState--;
                lastColon = i;
            }
        }
        if (ternaryState == 0 && condition != null && ifTrue != null && lastColon < symbolCount - 1) {
            return new Ternary(condition.get(), ifTrue.get(), parseSymbols(symbols.subList(lastColon + 1, symbolCount)));
        }
        return null;
    }

    @Nullable
    protected static MathValue compileFunction(String name, List<MathValue> args) throws CompoundException {
        if (name.startsWith("!")) {
            if (name.length() == 1) {
                return new BooleanNegate((MathValue) args.getFirst());
            }
            return new BooleanNegate(compileFunction(name.substring(1), args));
        }
        if (name.startsWith("-")) {
            if (name.length() == 1) {
                return new Negative((MathValue) args.getFirst());
            }
            return new Negative(compileFunction(name.substring(1), args));
        }
        if (!isFunctionRegistered(name)) {
            return null;
        }
        return buildFunction(name, (MathValue[]) args.toArray(new MathValue[0]));
    }

    @Deprecated(forRemoval = true)
    public static boolean isOperativeSymbol(char symbol) {
        return isOperativeSymbol(String.valueOf(symbol));
    }

    @Deprecated(forRemoval = true)
    public static boolean isOperativeSymbol(@NotNull String symbol) {
        return Operator.isOperator(symbol) || symbol.equals("?") || symbol.equals(":");
    }

    public static boolean isNumeric(String string) {
        return NUMERIC.matcher(string).matches();
    }

    protected static Operator getOperatorFor(String op) throws CompoundException {
        return Operator.getOperatorFor(op).orElseThrow(() -> {
            return new CompoundException("Unknown operator symbol '" + op + "'");
        });
    }

    @Deprecated(forRemoval = true)
    protected static boolean isQueryOrFunctionName(String string) {
        return (isNumeric(string) || isOperativeSymbol(string)) ? false : true;
    }

    protected static boolean isLikelyVariable(String string) {
        if (MolangQueries.isExistingVariable(string)) {
            return true;
        }
        return (isNumeric(string) || isFunctionRegistered(string) || Operator.isOperator(string) || string.equals("?") || string.equals(":")) ? false : true;
    }
}
