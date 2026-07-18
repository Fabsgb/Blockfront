package gg.moonflower.molangcompiler.core.compiler;

import com.boehmod.blockfront.AbstractC0877pq;
import com.boehmod.blockfront.C0862pb;
import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import gg.moonflower.molangcompiler.core.ast.BinaryConditionalNode;
import gg.moonflower.molangcompiler.core.ast.BinaryOperation;
import gg.moonflower.molangcompiler.core.ast.BinaryOperationNode;
import gg.moonflower.molangcompiler.core.ast.BreakNode;
import gg.moonflower.molangcompiler.core.ast.CompoundNode;
import gg.moonflower.molangcompiler.core.ast.ConstNode;
import gg.moonflower.molangcompiler.core.ast.ContinueNode;
import gg.moonflower.molangcompiler.core.ast.FunctionNode;
import gg.moonflower.molangcompiler.core.ast.LoopNode;
import gg.moonflower.molangcompiler.core.ast.MathNode;
import gg.moonflower.molangcompiler.core.ast.MathOperation;
import gg.moonflower.molangcompiler.core.ast.Node;
import gg.moonflower.molangcompiler.core.ast.OptionalValueNode;
import gg.moonflower.molangcompiler.core.ast.ReturnNode;
import gg.moonflower.molangcompiler.core.ast.ScopeNode;
import gg.moonflower.molangcompiler.core.ast.TernaryOperationNode;
import gg.moonflower.molangcompiler.core.ast.ThisNode;
import gg.moonflower.molangcompiler.core.ast.VariableGetNode;
import gg.moonflower.molangcompiler.core.ast.VariableSetNode;
import gg.moonflower.molangcompiler.core.compiler.MolangLexer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/MolangParser.class */
@ApiStatus.Internal
public final class MolangParser {
    public static Node parseTokens(MolangLexer.Token[] tokens) throws MolangSyntaxException {
        if (tokens.length == 0) {
            throw new MolangSyntaxException("Expected token");
        }
        return parseTokensUntil(new TokenReader(tokens), true, token -> {
            return false;
        });
    }

    private static Node parseTokensUntil(TokenReader reader, boolean insertReturn, Predicate<MolangLexer.Token> filter) throws MolangSyntaxException {
        List<Node> nodes = new ArrayList<>(2);
        while (true) {
            if (!reader.canRead() || filter.test(reader.peek())) {
                break;
            }
            nodes.add(parseExpression(reader));
            if (reader.canRead()) {
                MolangLexer.Token token = reader.peek();
                if (token.type().isTerminating()) {
                    reader.skip();
                } else if (!filter.test(token)) {
                    throw error("Trailing statement", reader);
                }
            }
        }
        if (nodes.isEmpty()) {
            throw new MolangSyntaxException("Expected node");
        }
        if (insertReturn) {
            Node node = nodes.get(nodes.size() - 1);
            if (!(node instanceof ReturnNode)) {
                if (node instanceof OptionalValueNode) {
                    OptionalValueNode setNode = (OptionalValueNode) node;
                    node = setNode.withReturnValue();
                }
                nodes.set(nodes.size() - 1, new ReturnNode(node));
            }
        }
        if (nodes.size() == 1) {
            return nodes.get(0);
        }
        return new CompoundNode((Node[]) nodes.toArray(x$0 -> {
            return new Node[x$0];
        }));
    }

    private static Node parseNode(TokenReader reader) throws MolangSyntaxException {
        Node node;
        expectLength(reader, 1);
        MolangLexer.Token token = reader.peek();
        switch (C14481.f8784x77a837da[token.type().ordinal()]) {
            case 1:
                reader.skip();
                Node value = parseExpression(reader);
                if (reader.canRead() && reader.peek().type().isTerminating()) {
                    reader.skip();
                }
                boolean scope = reader.canRead() && reader.peek().type() == MolangLexer.TokenType.RIGHT_BRACE;
                if (reader.canRead() && !scope) {
                    throw error("Trailing statement", reader);
                }
                if (value instanceof OptionalValueNode) {
                    OptionalValueNode setNode = (OptionalValueNode) value;
                    value = setNode.withReturnValue();
                }
                return new ReturnNode(value);
            case 2:
                reader.skip();
                expect(reader, MolangLexer.TokenType.LEFT_PARENTHESIS);
                reader.skip();
                Node iterations = parseTokensUntil(reader, false, t -> {
                    return t.type() == MolangLexer.TokenType.COMMA;
                });
                expect(reader, MolangLexer.TokenType.COMMA);
                reader.skip();
                Node body = parseTokensUntil(reader, false, t2 -> {
                    return t2.type() == MolangLexer.TokenType.RIGHT_PARENTHESIS;
                });
                expect(reader, MolangLexer.TokenType.RIGHT_PARENTHESIS);
                reader.skip();
                if (body instanceof ScopeNode) {
                    ScopeNode scopeNode = (ScopeNode) body;
                    node = scopeNode.node();
                } else {
                    node = body;
                }
                return new LoopNode(iterations, node);
            case 3:
                reader.skip();
                return new ContinueNode();
            case 4:
                reader.skip();
                return new BreakNode();
            case 5:
                reader.skip();
                expect(reader, MolangLexer.TokenType.LEFT_PARENTHESIS);
                reader.skip();
                Node condition = parseExpression(reader);
                expect(reader, MolangLexer.TokenType.RIGHT_PARENTHESIS);
                reader.skip();
                Node branch = parseExpression(reader);
                if (reader.canRead(2) && reader.peek().type().isTerminating() && reader.peekAfter(1).type() == MolangLexer.TokenType.ELSE) {
                    reader.skip(2);
                    return new TernaryOperationNode(condition, branch, parseExpression(reader));
                }
                return new BinaryConditionalNode(condition, branch);
            case 6:
                reader.skip();
                return new ThisNode();
            case 7:
                reader.skip();
                return new ConstNode(1.0f);
            case 8:
                reader.skip();
                return new ConstNode(0.0f);
            case C0862pb.f4509nv /* 9 */:
                try {
                    float value2 = Integer.parseInt(reader.peek().value());
                    reader.skip();
                    if (reader.canRead() && reader.peek().type() == MolangLexer.TokenType.DOT) {
                        reader.skip();
                        expect(reader, MolangLexer.TokenType.NUMERAL);
                        String decimalString = reader.peek().value();
                        float decimal = Integer.parseInt(decimalString);
                        reader.skip();
                        if (decimal > 0.0f) {
                            value2 += (float) (((double) decimal) / Math.pow(10.0d, decimalString.length()));
                        }
                    }
                    return new ConstNode(value2);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw error("Error parsing numeral", reader);
                }
            case 10:
                return parseAlphanumeric(reader);
            case AbstractC0877pq.f4599nO /* 11 */:
                switch (token.value()) {
                    case "-":
                        if (!reader.canRead(2) || !reader.peekAfter(1).type().canNegate()) {
                            throw error("Cannot negate " + reader.peekAfter(1), reader);
                        }
                        reader.skip();
                        return new BinaryOperationNode(BinaryOperation.MULTIPLY, new ConstNode(-1.0f), parseNode(reader));
                    case "+":
                        if (!reader.canRead(2) || !reader.peekAfter(1).type().canNegate()) {
                            throw error("Cannot assign + to " + reader.peekAfter(1), reader);
                        }
                        reader.skip();
                        return parseNode(reader);
                    default:
                        throw error("Expected +num or -num", reader);
                }
            case 12:
                reader.skip();
                Node node2 = parseExpression(reader);
                expect(reader, MolangLexer.TokenType.RIGHT_PARENTHESIS);
                reader.skip();
                return node2;
            case C0862pb.f4508nu /* 13 */:
                reader.skip();
                Node node3 = parseTokensUntil(reader, false, t3 -> {
                    return t3.type() == MolangLexer.TokenType.RIGHT_BRACE;
                });
                expect(reader, MolangLexer.TokenType.RIGHT_BRACE);
                reader.skip();
                return new ScopeNode(node3);
            default:
                throw error("Unexpected token", reader);
        }
    }

    /* JADX INFO: renamed from: gg.moonflower.molangcompiler.core.compiler.MolangParser$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/MolangParser$1.class */
    static /* synthetic */ class C14481 {

        /* JADX INFO: renamed from: $SwitchMap$gg$moonflower$molangcompiler$core$compiler$MolangLexer$TokenType */
        static final /* synthetic */ int[] f8784x77a837da = new int[MolangLexer.TokenType.values().length];

        static {
            try {
                f8784x77a837da[MolangLexer.TokenType.RETURN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.LOOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.CONTINUE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.BREAK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.IF.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.THIS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.TRUE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.FALSE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.NUMERAL.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.ALPHANUMERIC.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.BINARY_OPERATION.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.LEFT_PARENTHESIS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.LEFT_BRACE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.NULL_COALESCING.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.EQUAL.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f8784x77a837da[MolangLexer.TokenType.SPECIAL.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static gg.moonflower.molangcompiler.core.ast.Node parseExpression(gg.moonflower.molangcompiler.core.compiler.TokenReader r6) throws gg.moonflower.molangcompiler.api.exception.MolangSyntaxException {
        /*
            Method dump skipped, instruction units count: 767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gg.moonflower.molangcompiler.core.compiler.MolangParser.parseExpression(gg.moonflower.molangcompiler.core.compiler.TokenReader):gg.moonflower.molangcompiler.core.ast.Node");
    }

    private static Node parseAlphanumeric(TokenReader reader) throws MolangSyntaxException {
        Node binaryOperationNode;
        expectLength(reader, 2);
        String object = reader.peek().value();
        if ("t".equalsIgnoreCase(object)) {
            object = "temp";
        }
        reader.skip();
        expect(reader, MolangLexer.TokenType.DOT);
        reader.skip();
        expect(reader, MolangLexer.TokenType.ALPHANUMERIC);
        StringBuilder nameBuilder = new StringBuilder(reader.peek().value());
        reader.skip();
        while (reader.canRead()) {
            MolangLexer.Token token = reader.peek();
            if (!token.type().validVariableName()) {
                break;
            }
            nameBuilder.append(token.value());
            reader.skip();
        }
        String name = nameBuilder.toString();
        MathOperation mathOperation = parseMathOperation(object, name, reader);
        if (mathOperation != null && mathOperation.getParameters() == 0) {
            return new MathNode(mathOperation, new Node[0]);
        }
        if (!reader.canRead() || reader.peek().type().isTerminating()) {
            if (mathOperation != null) {
                throw error("Cannot get value of a math function", reader);
            }
            return new VariableGetNode(object, name);
        }
        MolangLexer.Token operand = reader.peek();
        if (operand.type() == MolangLexer.TokenType.EQUAL) {
            if (reader.canRead() && reader.peekAfter(1).type() == MolangLexer.TokenType.EQUAL) {
                return new VariableGetNode(object, name);
            }
            if (mathOperation != null) {
                throw error("Cannot set value of a math function", reader);
            }
            reader.skip();
            return new VariableSetNode(object, name, parseExpression(reader));
        }
        if (operand.type() == MolangLexer.TokenType.INCREMENT) {
            reader.skip();
            return new VariableSetNode(object, name, new BinaryOperationNode(BinaryOperation.ADD, new VariableGetNode(object, name), new ConstNode(1.0f)));
        }
        if (operand.type() == MolangLexer.TokenType.DECREMENT) {
            reader.skip();
            return new VariableSetNode(object, name, new BinaryOperationNode(BinaryOperation.SUBTRACT, new VariableGetNode(object, name), new ConstNode(1.0f)));
        }
        if (reader.canRead(2) && operand.type() == MolangLexer.TokenType.BINARY_OPERATION) {
            if (mathOperation != null) {
                throw error("Cannot set value of a math function", reader);
            }
            VariableGetNode left = new VariableGetNode(object, name);
            MolangLexer.Token secondOperand = reader.peekAfter(1);
            if (secondOperand.type() == MolangLexer.TokenType.EQUAL) {
                reader.skip(2);
                switch (operand.value()) {
                    case "-":
                        binaryOperationNode = new BinaryOperationNode(BinaryOperation.SUBTRACT, left, parseExpression(reader));
                        break;
                    case "+":
                        binaryOperationNode = new BinaryOperationNode(BinaryOperation.ADD, left, parseExpression(reader));
                        break;
                    case "*":
                        binaryOperationNode = new BinaryOperationNode(BinaryOperation.MULTIPLY, left, parseExpression(reader));
                        break;
                    case "/":
                        binaryOperationNode = new BinaryOperationNode(BinaryOperation.DIVIDE, left, parseExpression(reader));
                        break;
                    default:
                        throw error("Unexpected token", reader);
                }
                Node value = binaryOperationNode;
                return new VariableSetNode(object, name, value);
            }
        }
        if (operand.type() == MolangLexer.TokenType.LEFT_PARENTHESIS) {
            reader.skip();
            if (reader.peek().type() == MolangLexer.TokenType.RIGHT_PARENTHESIS) {
                reader.skip();
                return new FunctionNode(object, name, new Node[0]);
            }
            List<Node> parameters = new ArrayList<>();
            while (reader.canRead()) {
                parameters.add(parseExpression(reader));
                if (reader.peek().type() == MolangLexer.TokenType.COMMA) {
                    reader.skip();
                } else {
                    expect(reader, MolangLexer.TokenType.RIGHT_PARENTHESIS);
                    reader.skip();
                    if (mathOperation != null) {
                        if (mathOperation.getParameters() != parameters.size()) {
                            throw error("Expected " + mathOperation.getParameters() + " parameters, got " + parameters.size(), reader);
                        }
                        return new MathNode(mathOperation, (Node[]) parameters.toArray(x$0 -> {
                            return new Node[x$0];
                        }));
                    }
                    return new FunctionNode(object, name, (Node[]) parameters.toArray(x$02 -> {
                        return new Node[x$02];
                    }));
                }
            }
            expectLength(reader, 1);
        }
        return new VariableGetNode(object, name);
    }

    private static MathOperation parseMathOperation(String object, String name, TokenReader reader) throws MolangSyntaxException {
        if (!"math".equalsIgnoreCase(object)) {
            return null;
        }
        for (MathOperation operation : MathOperation.values()) {
            if (operation.getName().equalsIgnoreCase(name)) {
                return operation;
            }
        }
        throw error("Unknown math function: " + name, reader);
    }

    private static Node parseBinaryExpression(Node left, TokenReader reader) throws MolangSyntaxException {
        MolangLexer.Token token = reader.peek();
        switch (token.value()) {
            case "+":
                reader.skip();
                return new BinaryOperationNode(BinaryOperation.ADD, left, parseTerm(reader));
            case "-":
                reader.skip();
                return new BinaryOperationNode(BinaryOperation.SUBTRACT, left, parseTerm(reader));
            case "*":
                reader.skip();
                return new BinaryOperationNode(BinaryOperation.MULTIPLY, left, parseNode(reader));
            case "/":
                reader.skip();
                return new BinaryOperationNode(BinaryOperation.DIVIDE, left, parseNode(reader));
            default:
                return left;
        }
    }

    private static Node parseTerm(TokenReader reader) throws MolangSyntaxException {
        Node left = parseNode(reader);
        if (!reader.canRead()) {
            return left;
        }
        MolangLexer.Token token = reader.peek();
        if (token.type() == MolangLexer.TokenType.BINARY_OPERATION) {
            switch (token.value()) {
                case "*":
                    reader.skip();
                    return new BinaryOperationNode(BinaryOperation.MULTIPLY, left, parseNode(reader));
                case "/":
                    reader.skip();
                    return new BinaryOperationNode(BinaryOperation.DIVIDE, left, parseNode(reader));
            }
        }
        return left;
    }

    public static void expect(TokenReader reader, MolangLexer.TokenType token) throws MolangSyntaxException {
        if (!reader.canRead() || reader.peek().type() != token) {
            throw error("Expected " + token, reader);
        }
    }

    public static void expect(TokenReader reader, MolangLexer.TokenType token, String value) throws MolangSyntaxException {
        expect(reader, token);
        if (!value.equals(reader.peek().value())) {
            throw error("Expected " + value, reader);
        }
    }

    public static void expectLength(TokenReader reader, int amount) throws MolangSyntaxException {
        if (!reader.canRead(amount)) {
            throw new MolangSyntaxException("Trailing statement", reader.getString(), reader.getString().length());
        }
    }

    public static MolangSyntaxException error(String error, TokenReader reader) {
        return new MolangSyntaxException(error, reader.getString(), reader.getCursorOffset());
    }
}
