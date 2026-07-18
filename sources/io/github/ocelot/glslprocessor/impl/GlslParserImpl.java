package io.github.ocelot.glslprocessor.impl;

import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.grammar.GlslFunctionHeader;
import io.github.ocelot.glslprocessor.api.grammar.GlslParameterDeclaration;
import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructField;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructSpecifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslType;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.GlslEmptyNode;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.api.node.branch.GlslCaseLabelNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslForLoopNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslIfNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslJumpNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslReturnNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslSwitchNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslWhileLoopNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslBoolConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslDoubleConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslFloatConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslIntConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslIntFormat;
import io.github.ocelot.glslprocessor.api.node.expression.GlslAssignmentNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslBitwiseNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslCompareNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslConditionalNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslOperationNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslPrecisionNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslUnaryNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslInvokeFunctionNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslPrimitiveConstructorNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslGetArrayNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslGetFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableNode;
import io.github.ocelot.glslprocessor.impl.GlslLexer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslParserImpl.class */
@ApiStatus.Internal
public class GlslParserImpl {
    public static final Pattern VERSION_PATTERN = Pattern.compile("#version\\s+(\\d+)\\s*(\\w+)?");
    public static final Pattern STRIP_PATTERN = Pattern.compile("#version\\s+\\d+\\s*(\\w+)?|#line\\s+\\d+\\s*(\\d+)?|#extension\\s+\\w+\\s*:\\s*\\w+|#include\\s+\\S+|#veil:.*");
    public static final Pattern UNSTRIP_PATTERN = Pattern.compile("// #veil:stripped ");

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String preprocess(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) throws io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.ocelot.glslprocessor.impl.GlslParserImpl.preprocess(java.lang.String, java.util.Map):java.lang.String");
    }

    public static GlslTree parse(String input) throws GlslSyntaxException {
        GlslTokenReader reader = new GlslTokenReader(input);
        GlslVersionStatement version = new GlslVersionStatement();
        GlslLexer.Token token = reader.peek();
        if (token != null && token.type() == GlslLexer.TokenType.DIRECTIVE && token.value().startsWith("#version ")) {
            reader.skip();
            String[] parts = token.value().substring(9).split(" +", 2);
            try {
                version.setVersion(Integer.parseInt(parts[0].trim()));
                version.setCore(parts.length == 1 || parts[1].trim().equals("core"));
            } catch (NumberFormatException e) {
                throw reader.error("Invalid Version: " + token.value() + ". " + e.getMessage());
            }
        }
        List<String> directives = new ArrayList<>();
        List<GlslNode> body = new ArrayList<>();
        while (reader.canRead()) {
            if (reader.tryConsume(GlslLexer.TokenType.DIRECTIVE)) {
                directives.add(reader.peek(-1).value());
            } else {
                int cursor = reader.getCursor();
                GlslFunctionNode functionDefinition = parseFunctionDefinition(reader);
                if (functionDefinition != null) {
                    reader.markNode(cursor, functionDefinition);
                    body.add(functionDefinition);
                } else {
                    int cursor2 = reader.getCursor();
                    List<GlslNode> declarations = parseDeclaration(reader);
                    if (declarations != null) {
                        for (GlslNode declaration : declarations) {
                            reader.markNode(cursor2, declaration);
                            body.add(declaration);
                        }
                    } else if (!reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                        reader.throwError();
                    }
                }
            }
        }
        return new GlslTree(version, body, directives, reader.getMarkedNodes());
    }

    @Nullable
    public static GlslNode parsePrimaryExpression(GlslTokenReader reader) {
        GlslNode condition;
        if (reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
            String variableName = reader.peek(-1).value();
            return new GlslVariableNode(variableName);
        }
        if (reader.tryConsume(GlslLexer.TokenType.INTEGER_DECIMAL_CONSTANT)) {
            return new GlslIntConstantNode(GlslIntFormat.DECIMAL, true, Integer.parseUnsignedInt(reader.peek(-1).value(), 10));
        }
        if (reader.tryConsume(GlslLexer.TokenType.INTEGER_HEXADECIMAL_CONSTANT)) {
            return new GlslIntConstantNode(GlslIntFormat.HEXADECIMAL, true, Integer.parseUnsignedInt(reader.peek(-1).value(), 16));
        }
        if (reader.tryConsume(GlslLexer.TokenType.INTEGER_OCTAL_CONSTANT)) {
            return new GlslIntConstantNode(GlslIntFormat.OCTAL, true, Integer.parseUnsignedInt(reader.peek(-1).value(), 8));
        }
        if (reader.tryConsume(GlslLexer.TokenType.UINTEGER_DECIMAL_CONSTANT)) {
            return new GlslIntConstantNode(GlslIntFormat.DECIMAL, false, Integer.parseUnsignedInt(reader.peek(-1).value(), 10));
        }
        if (reader.tryConsume(GlslLexer.TokenType.UINTEGER_HEXADECIMAL_CONSTANT)) {
            return new GlslIntConstantNode(GlslIntFormat.HEXADECIMAL, false, Integer.parseUnsignedInt(reader.peek(-1).value(), 16));
        }
        if (reader.tryConsume(GlslLexer.TokenType.UINTEGER_OCTAL_CONSTANT)) {
            return new GlslIntConstantNode(GlslIntFormat.OCTAL, false, Integer.parseUnsignedInt(reader.peek(-1).value(), 8));
        }
        if (reader.tryConsume(GlslLexer.TokenType.FLOATING_CONSTANT)) {
            return new GlslFloatConstantNode(Float.parseFloat(reader.peek(-1).value()));
        }
        if (reader.tryConsume(GlslLexer.TokenType.DOUBLE_CONSTANT)) {
            return new GlslDoubleConstantNode(Double.parseDouble(reader.peek(-1).value()));
        }
        if (reader.tryConsume(GlslLexer.TokenType.BOOL_CONSTANT)) {
            return new GlslBoolConstantNode(Boolean.parseBoolean(reader.peek(-1).value()));
        }
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.LEFT_PAREN) && (condition = parseCondition(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
            return condition;
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parsePostfixExpression(boolean allowFunction, GlslTokenReader reader) {
        GlslNode integerExpression;
        GlslNode integerExpression2;
        int cursor = reader.getCursor();
        if (allowFunction) {
            GlslNode functionCall = parseFunctionCallGeneric(reader);
            if (functionCall != null) {
                int functionCursor = reader.getCursor();
                if (reader.tryConsume(GlslLexer.TokenType.LEFT_BRACKET) && (integerExpression2 = parseIntegerExpression(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACKET)) {
                    functionCall = new GlslGetArrayNode(functionCall, integerExpression2);
                    functionCursor = reader.getCursor();
                }
                reader.setCursor(functionCursor);
                if (reader.tryConsume(GlslLexer.TokenType.DOT, GlslLexer.TokenType.IDENTIFIER)) {
                    StringBuilder fieldSelection = new StringBuilder(reader.peek(-1).value());
                    while (reader.tryConsume(GlslLexer.TokenType.DOT, GlslLexer.TokenType.IDENTIFIER)) {
                        fieldSelection.append('.').append(reader.peek(-1).value());
                    }
                    return new GlslGetFieldNode(functionCall, fieldSelection.toString());
                }
                reader.setCursor(functionCursor);
                if (reader.tryConsume(GlslLexer.TokenType.INC_OP)) {
                    return new GlslUnaryNode(functionCall, GlslUnaryNode.Operand.POST_INCREMENT);
                }
                reader.setCursor(functionCursor);
                if (reader.tryConsume(GlslLexer.TokenType.DEC_OP)) {
                    return new GlslUnaryNode(functionCall, GlslUnaryNode.Operand.POST_DECREMENT);
                }
                reader.setCursor(functionCursor);
                return functionCall;
            }
            reader.setCursor(cursor);
        }
        GlslNode primaryExpression = parsePrimaryExpression(reader);
        while (true) {
            GlslNode primaryExpression2 = primaryExpression;
            if (primaryExpression2 != null) {
                int expressionCursor = reader.getCursor();
                if (reader.tryConsume(GlslLexer.TokenType.LEFT_BRACKET) && (integerExpression = parseIntegerExpression(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACKET)) {
                    primaryExpression = new GlslGetArrayNode(primaryExpression2, integerExpression);
                } else {
                    reader.setCursor(expressionCursor);
                    if (reader.tryConsume(GlslLexer.TokenType.DOT, GlslLexer.TokenType.IDENTIFIER)) {
                        StringBuilder fieldSelection2 = new StringBuilder(reader.peek(-1).value());
                        while (reader.tryConsume(GlslLexer.TokenType.DOT, GlslLexer.TokenType.IDENTIFIER)) {
                            fieldSelection2.append('.').append(reader.peek(-1).value());
                        }
                        primaryExpression = new GlslGetFieldNode(primaryExpression2, fieldSelection2.toString());
                    } else {
                        reader.setCursor(expressionCursor);
                        if (reader.tryConsume(GlslLexer.TokenType.INC_OP)) {
                            primaryExpression = new GlslUnaryNode(primaryExpression2, GlslUnaryNode.Operand.POST_INCREMENT);
                        } else {
                            reader.setCursor(expressionCursor);
                            if (reader.tryConsume(GlslLexer.TokenType.DEC_OP)) {
                                primaryExpression = new GlslUnaryNode(primaryExpression2, GlslUnaryNode.Operand.POST_DECREMENT);
                            } else {
                                reader.setCursor(expressionCursor);
                                return primaryExpression2;
                            }
                        }
                    }
                }
            } else {
                reader.setCursor(cursor);
                return null;
            }
        }
    }

    @Nullable
    public static GlslNode parseIntegerExpression(GlslTokenReader reader) {
        List<GlslNode> expression = parseExpression(reader);
        if (expression == null) {
            return null;
        }
        if (expression.size() != 1) {
            reader.markError("Expected exactly 1 expression, got " + expression.size());
            return null;
        }
        return expression.get(0);
    }

    @Nullable
    public static GlslNode parseFunctionCallGeneric(GlslTokenReader reader) {
        GlslNode functionCallHeader = parseFunctionCallHeader(reader);
        if (functionCallHeader == null) {
            return null;
        }
        int cursor = reader.getCursor();
        int parameterCursor = reader.getCursor();
        List<GlslNode> parameters = new ArrayList<>();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            GlslNode parameter = parseAssignmentExpression(reader);
            if (parameter == null) {
                reader.setCursor(parameterCursor);
                break;
            }
            parameters.add(parameter);
            reader.markNode(parameterCursor, parameter);
            parameterCursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        if (reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
            return new GlslInvokeFunctionNode(functionCallHeader, parameters);
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.VOID, GlslLexer.TokenType.RIGHT_PAREN)) {
            return new GlslInvokeFunctionNode(functionCallHeader, Collections.emptyList());
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
            return new GlslInvokeFunctionNode(functionCallHeader, Collections.emptyList());
        }
        reader.markError("Expected ')'");
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseFunctionCallHeader(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        GlslTypeSpecifier typeSpecifier = parseTypeSpecifier(reader);
        if (typeSpecifier != null && !typeSpecifier.isNamed() && reader.tryConsume(GlslLexer.TokenType.LEFT_PAREN)) {
            return new GlslPrimitiveConstructorNode(typeSpecifier);
        }
        reader.setCursor(cursor);
        GlslNode expression = parsePostfixExpression(false, reader);
        if (expression != null && reader.tryConsume(GlslLexer.TokenType.LEFT_PAREN)) {
            return expression;
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseUnaryExpression(GlslTokenReader reader) {
        GlslUnaryNode.Operand operator;
        GlslNode right;
        GlslNode right2;
        GlslNode expression = parsePostfixExpression(true, reader);
        if (expression != null) {
            return expression;
        }
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.INC_OP) && (right2 = parseUnaryExpression(reader)) != null) {
            return new GlslUnaryNode(right2, GlslUnaryNode.Operand.PRE_INCREMENT);
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.DEC_OP) && (right = parseUnaryExpression(reader)) != null) {
            return new GlslUnaryNode(right, GlslUnaryNode.Operand.PRE_DECREMENT);
        }
        reader.setCursor(cursor);
        if (reader.canRead() && (operator = reader.peek().type().asUnaryOperator()) != null) {
            reader.skip();
            GlslNode right3 = parseUnaryExpression(reader);
            if (right3 != null) {
                return new GlslUnaryNode(right3, operator);
            }
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseSimpleExpression(GlslTokenReader reader, Function<GlslTokenReader, GlslNode> parser, GlslLexer.TokenType operator, Function<List<GlslNode>, GlslNode> join) {
        int cursor = reader.getCursor();
        List<GlslNode> expressions = new ArrayList<>();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            GlslNode expression = parser.apply(reader);
            if (expression == null) {
                reader.setCursor(cursor);
                break;
            }
            expressions.add(expression);
            cursor = reader.getCursor();
            if (!reader.tryConsume(operator)) {
                break;
            }
        }
        if (expressions.isEmpty()) {
            return null;
        }
        if (expressions.size() == 1) {
            return expressions.get(0);
        }
        return join.apply(expressions);
    }

    @Nullable
    public static GlslNode parseMultiplicativeExpression(GlslTokenReader reader) {
        GlslNode left = parseUnaryExpression(reader);
        if (left == null) {
            return null;
        }
        while (reader.canRead()) {
            int cursor = reader.getCursor();
            if (reader.tryConsume(GlslLexer.TokenType.STAR)) {
                GlslNode right = parseUnaryExpression(reader);
                if (right == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right, GlslOperationNode.Operand.MULTIPLY);
            } else if (reader.tryConsume(GlslLexer.TokenType.SLASH)) {
                GlslNode right2 = parseUnaryExpression(reader);
                if (right2 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right2, GlslOperationNode.Operand.DIVIDE);
            } else {
                if (!reader.tryConsume(GlslLexer.TokenType.PERCENT)) {
                    break;
                }
                GlslNode right3 = parseUnaryExpression(reader);
                if (right3 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right3, GlslOperationNode.Operand.MODULO);
            }
        }
        return left;
    }

    @Nullable
    public static GlslNode parseAdditiveExpression(GlslTokenReader reader) {
        GlslNode left = parseMultiplicativeExpression(reader);
        if (left == null) {
            return null;
        }
        while (reader.canRead()) {
            int cursor = reader.getCursor();
            if (reader.tryConsume(GlslLexer.TokenType.PLUS)) {
                GlslNode right = parseMultiplicativeExpression(reader);
                if (right == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right, GlslOperationNode.Operand.ADD);
            } else {
                if (!reader.tryConsume(GlslLexer.TokenType.DASH)) {
                    break;
                }
                GlslNode right2 = parseMultiplicativeExpression(reader);
                if (right2 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right2, GlslOperationNode.Operand.SUBTRACT);
            }
        }
        return left;
    }

    @Nullable
    public static GlslNode parseShiftExpression(GlslTokenReader reader) {
        GlslNode left = parseAdditiveExpression(reader);
        if (left == null) {
            return null;
        }
        while (reader.canRead()) {
            int cursor = reader.getCursor();
            if (reader.tryConsume(GlslLexer.TokenType.LEFT_OP)) {
                GlslNode right = parseAdditiveExpression(reader);
                if (right == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right, GlslOperationNode.Operand.LEFT_SHIFT);
            } else {
                if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_OP)) {
                    break;
                }
                GlslNode right2 = parseAdditiveExpression(reader);
                if (right2 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslOperationNode(left, right2, GlslOperationNode.Operand.RIGHT_SHIFT);
            }
        }
        return left;
    }

    @Nullable
    public static GlslNode parseRelationalExpression(GlslTokenReader reader) {
        GlslNode left = parseShiftExpression(reader);
        if (left == null) {
            return null;
        }
        while (reader.canRead()) {
            int cursor = reader.getCursor();
            if (reader.tryConsume(GlslLexer.TokenType.LEFT_ANGLE)) {
                GlslNode right = parseShiftExpression(reader);
                if (right == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslCompareNode(left, right, GlslCompareNode.Operand.LESS);
            } else if (reader.tryConsume(GlslLexer.TokenType.RIGHT_ANGLE)) {
                GlslNode right2 = parseShiftExpression(reader);
                if (right2 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslCompareNode(left, right2, GlslCompareNode.Operand.GREATER);
            } else if (reader.tryConsume(GlslLexer.TokenType.LE_OP)) {
                GlslNode right3 = parseShiftExpression(reader);
                if (right3 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslCompareNode(left, right3, GlslCompareNode.Operand.LEQUAL);
            } else {
                if (!reader.tryConsume(GlslLexer.TokenType.GE_OP)) {
                    break;
                }
                GlslNode right4 = parseShiftExpression(reader);
                if (right4 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslCompareNode(left, right4, GlslCompareNode.Operand.GEQUAL);
            }
        }
        return left;
    }

    @Nullable
    public static GlslNode parseEqualityExpression(GlslTokenReader reader) {
        GlslNode left = parseRelationalExpression(reader);
        if (left == null) {
            return null;
        }
        while (reader.canRead()) {
            int cursor = reader.getCursor();
            if (reader.tryConsume(GlslLexer.TokenType.EQ_OP)) {
                GlslNode right = parseRelationalExpression(reader);
                if (right == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslCompareNode(left, right, GlslCompareNode.Operand.EQUAL);
            } else {
                if (!reader.tryConsume(GlslLexer.TokenType.NE_OP)) {
                    break;
                }
                GlslNode right2 = parseRelationalExpression(reader);
                if (right2 == null) {
                    reader.setCursor(cursor);
                    return left;
                }
                left = new GlslCompareNode(left, right2, GlslCompareNode.Operand.NOT_EQUAL);
            }
        }
        return left;
    }

    @Nullable
    public static GlslNode parseAndExpression(GlslTokenReader reader) {
        return parseSimpleExpression(reader, GlslParserImpl::parseEqualityExpression, GlslLexer.TokenType.AMPERSAND, (v0) -> {
            return GlslBitwiseNode.bitAnd(v0);
        });
    }

    @Nullable
    public static GlslNode parseExclusiveOrExpression(GlslTokenReader reader) {
        return parseSimpleExpression(reader, GlslParserImpl::parseAndExpression, GlslLexer.TokenType.CARET, (v0) -> {
            return GlslBitwiseNode.bitXor(v0);
        });
    }

    @Nullable
    public static GlslNode parseInclusiveOrExpression(GlslTokenReader reader) {
        return parseSimpleExpression(reader, GlslParserImpl::parseExclusiveOrExpression, GlslLexer.TokenType.VERTICAL_BAR, (v0) -> {
            return GlslBitwiseNode.bitOr(v0);
        });
    }

    @Nullable
    public static GlslNode parseLogicalAndExpression(GlslTokenReader reader) {
        return parseSimpleExpression(reader, GlslParserImpl::parseInclusiveOrExpression, GlslLexer.TokenType.AND_OP, (v0) -> {
            return GlslBitwiseNode.logicalAnd(v0);
        });
    }

    @Nullable
    public static GlslNode parseLogicalXorExpression(GlslTokenReader reader) {
        return parseSimpleExpression(reader, GlslParserImpl::parseLogicalAndExpression, GlslLexer.TokenType.XOR_OP, (v0) -> {
            return GlslBitwiseNode.logicalXor(v0);
        });
    }

    @Nullable
    public static GlslNode parseLogicalOrExpression(GlslTokenReader reader) {
        return parseSimpleExpression(reader, GlslParserImpl::parseLogicalXorExpression, GlslLexer.TokenType.OR_OP, (v0) -> {
            return GlslBitwiseNode.logicalOr(v0);
        });
    }

    @Nullable
    public static GlslNode parseConditionalExpression(GlslTokenReader reader) {
        List<GlslNode> first;
        GlslNode branch;
        GlslNode logicalOr = parseLogicalOrExpression(reader);
        if (logicalOr == null) {
            return null;
        }
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.QUESTION) && (first = parseExpression(reader)) != null && reader.tryConsume(GlslLexer.TokenType.COLON) && (branch = parseAssignmentExpression(reader)) != null) {
            return new GlslConditionalNode(logicalOr, GlslNode.compound(first), branch);
        }
        reader.setCursor(cursor);
        return logicalOr;
    }

    @Nullable
    public static GlslNode parseAssignmentExpression(GlslTokenReader reader) {
        GlslAssignmentNode.Operand assignmentOperator;
        int cursor = reader.getCursor();
        GlslNode unaryExpression = parseUnaryExpression(reader);
        if (reader.canRead() && (assignmentOperator = reader.peek().type().asAssignmentOperator()) != null) {
            reader.skip();
            GlslNode right = parseAssignmentExpression(reader);
            return new GlslAssignmentNode(unaryExpression, right, assignmentOperator);
        }
        reader.setCursor(cursor);
        return parseConditionalExpression(reader);
    }

    @Nullable
    public static List<GlslNode> parseExpression(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        List<GlslNode> expressions = new ArrayList<>();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            GlslNode expression = parseAssignmentExpression(reader);
            if (expression == null) {
                reader.setCursor(cursor);
                break;
            }
            expressions.add(expression);
            cursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        if (expressions.isEmpty()) {
            return null;
        }
        return expressions;
    }

    @Nullable
    public static List<GlslNode> parseDeclaration(GlslTokenReader reader) {
        GlslTypeSpecifier typeSpecifier;
        int cursor = reader.getCursor();
        GlslFunctionHeader functionPrototype = parseFunctionPrototype(reader);
        if (functionPrototype != null) {
            if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                return Collections.singletonList(new GlslFunctionNode(functionPrototype, null));
            }
            reader.setCursor(cursor);
        }
        List<GlslNode> initDeclaratorList = parseInitDeclaratorList(reader);
        if (initDeclaratorList != null) {
            if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                return initDeclaratorList;
            }
            reader.setCursor(cursor);
        }
        if (reader.tryConsume(GlslLexer.TokenType.PRECISION)) {
            GlslTypeQualifier.Precision precisionQualifier = parsePrecisionQualifier(reader);
            if (precisionQualifier != null && (typeSpecifier = parseTypeSpecifier(reader)) != null && reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                return Collections.singletonList(new GlslPrecisionNode(precisionQualifier, typeSpecifier));
            }
            reader.setCursor(cursor);
        }
        List<GlslTypeQualifier> typeQualifier = parseTypeQualifiers(reader);
        if (typeQualifier == null) {
            return null;
        }
        int cursor2 = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.IDENTIFIER, GlslLexer.TokenType.LEFT_BRACE)) {
            String identifier = reader.peek(-2).value();
            List<GlslStructField> structFields = parseStructDeclarationList(reader);
            if (structFields != null) {
                if (reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
                    GlslSpecifiedType structSpecifier = new GlslSpecifiedType(GlslTypeSpecifier.struct(identifier, structFields), typeQualifier);
                    if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                        return Collections.singletonList(new GlslStructDeclarationNode(structSpecifier));
                    }
                    if (reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
                        String label = reader.peek(-1).value();
                        if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                            return Collections.singletonList(new GlslNewFieldNode(structSpecifier, label, null));
                        }
                        GlslSpecifiedType arraySpecifier = parseArraySpecifier(reader, structSpecifier);
                        if (arraySpecifier != null && reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                            return Collections.singletonList(new GlslNewFieldNode(arraySpecifier, label, null));
                        }
                    }
                }
                reader.markError("Expected '}'");
            }
        }
        reader.setCursor(cursor2);
        if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
            return Collections.singletonList(new GlslVariableDeclarationNode(typeQualifier, Collections.emptyList()));
        }
        GlslTypeSpecifier typeSpecifier2 = null;
        List<String> identifiers = parseIdentifierList(reader);
        if (identifiers == null) {
            typeSpecifier2 = parseTypeSpecifier(reader);
            if (typeSpecifier2 == null) {
                reader.markError("Expected ';'");
                reader.setCursor(cursor2);
                return null;
            }
            identifiers = parseIdentifierList(reader);
            if (identifiers == null) {
                reader.markError("Expected ';'");
                reader.setCursor(cursor2);
                return null;
            }
        }
        if (!reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
            reader.markError("Expected ';'");
            reader.setCursor(cursor2);
            return null;
        }
        if (typeSpecifier2 != null) {
            GlslSpecifiedType type = new GlslSpecifiedType(typeSpecifier2, typeQualifier);
            return identifiers.stream().map(name -> {
                return new GlslNewFieldNode(type, name, null);
            }).toList();
        }
        return Collections.singletonList(new GlslVariableDeclarationNode(typeQualifier, identifiers));
    }

    @Nullable
    public static List<String> parseIdentifierList(GlslTokenReader reader) {
        List<String> identifiers = new ArrayList<>();
        int cursor = reader.getCursor();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            if (!reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
                reader.setCursor(cursor);
                break;
            }
            identifiers.add(reader.peek(-1).value());
            cursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        if (identifiers.isEmpty()) {
            return null;
        }
        return identifiers;
    }

    @Nullable
    public static GlslFunctionHeader parseFunctionPrototype(GlslTokenReader reader) {
        GlslParameterDeclaration parameterDeclaration;
        int cursor = reader.getCursor();
        GlslSpecifiedType fullySpecifiedType = parseFullySpecifiedType(reader);
        if (fullySpecifiedType != null && reader.tryConsume(GlslLexer.TokenType.IDENTIFIER, GlslLexer.TokenType.LEFT_PAREN, GlslLexer.TokenType.RIGHT_PAREN)) {
            String name = reader.peek(-3).value();
            return new GlslFunctionHeader(name, fullySpecifiedType, (Collection<GlslParameterDeclaration>) new ArrayList());
        }
        reader.setCursor(cursor);
        GlslFunctionHeader functionHeaderWithParameters = parseFunctionHeaderWithParameters(reader);
        if (functionHeaderWithParameters != null) {
            return functionHeaderWithParameters;
        }
        GlslSpecifiedType fullySpecifiedType2 = parseFullySpecifiedType(reader);
        if (fullySpecifiedType2 != null && reader.tryConsume(GlslLexer.TokenType.IDENTIFIER, GlslLexer.TokenType.LEFT_PAREN)) {
            String name2 = reader.peek(-2).value();
            GlslParameterDeclaration parameterDeclaration2 = parseParameterDeclaration(reader);
            if (parameterDeclaration2 != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
                return new GlslFunctionHeader(name2, fullySpecifiedType2, (Collection<GlslParameterDeclaration>) Collections.singletonList(parameterDeclaration2));
            }
        }
        reader.setCursor(cursor);
        GlslFunctionHeader functionHeaderWithParameters2 = parseFunctionHeaderWithParameters(reader);
        if (functionHeaderWithParameters2 != null && reader.tryConsume(GlslLexer.TokenType.COMMA) && (parameterDeclaration = parseParameterDeclaration(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
            List<GlslParameterDeclaration> parameters = functionHeaderWithParameters2.getParameters();
            parameters.add(parameterDeclaration);
            return functionHeaderWithParameters2;
        }
        reader.setCursor(cursor);
        return null;
    }

    public static List<GlslParameterDeclaration> parseParameterList(GlslTokenReader reader) {
        List<GlslParameterDeclaration> parameters = new ArrayList<>();
        int cursor = reader.getCursor();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            GlslParameterDeclaration parameterDeclaration = parseParameterDeclaration(reader);
            if (parameterDeclaration == null) {
                reader.setCursor(cursor);
                break;
            }
            parameters.add(parameterDeclaration);
            cursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        return parameters;
    }

    @Nullable
    public static GlslFunctionHeader parseFunctionHeaderWithParameters(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        GlslSpecifiedType fullySpecifiedType = parseFullySpecifiedType(reader);
        if (fullySpecifiedType != null && reader.tryConsume(GlslLexer.TokenType.IDENTIFIER, GlslLexer.TokenType.LEFT_PAREN)) {
            String name = reader.peek(-2).value();
            List<GlslParameterDeclaration> parameters = parseParameterList(reader);
            if (reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
                return new GlslFunctionHeader(name, (GlslType) fullySpecifiedType, (Collection<GlslParameterDeclaration>) parameters);
            }
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslParameterDeclaration parseParameterDeclarator(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        GlslTypeSpecifier typeSpecifier = parseTypeSpecifier(reader);
        if (typeSpecifier == null) {
            return null;
        }
        if (!reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
            reader.markError("Expected identifier");
            reader.setCursor(cursor);
            return null;
        }
        String name = reader.peek(-1).value();
        GlslTypeSpecifier arraySpecifier = parseArraySpecifier(reader, typeSpecifier);
        return new GlslParameterDeclaration((GlslType) Objects.requireNonNullElse(arraySpecifier, typeSpecifier), name);
    }

    @Nullable
    public static GlslParameterDeclaration parseParameterDeclaration(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        List<GlslTypeQualifier> typeQualifiers = parseTypeQualifiers(reader);
        if (typeQualifiers != null) {
            GlslParameterDeclaration parameterDeclarator = parseParameterDeclarator(reader);
            if (parameterDeclarator != null) {
                return parameterDeclarator.setQualifiers(typeQualifiers);
            }
            GlslTypeSpecifier parameterTypeSpecifier = parseTypeSpecifier(reader);
            if (parameterTypeSpecifier != null) {
                return new GlslParameterDeclaration(new GlslSpecifiedType(parameterTypeSpecifier, typeQualifiers), null);
            }
        }
        reader.setCursor(cursor);
        GlslParameterDeclaration parameterDeclarator2 = parseParameterDeclarator(reader);
        if (parameterDeclarator2 != null) {
            return parameterDeclarator2;
        }
        GlslTypeSpecifier parameterTypeSpecifier2 = parseTypeSpecifier(reader);
        if (parameterTypeSpecifier2 != null) {
            return new GlslParameterDeclaration(parameterTypeSpecifier2, null);
        }
        return null;
    }

    @Nullable
    public static List<GlslNode> parseInitDeclaratorList(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        List<GlslNode> initDeclaratorList = new ArrayList<>();
        GlslSpecifiedType fullySpecifiedType = null;
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            GlslNode singleDeclaration = parseSingleDeclaration(fullySpecifiedType, reader);
            if (singleDeclaration == null) {
                reader.setCursor(cursor);
                break;
            }
            initDeclaratorList.add(singleDeclaration);
            cursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                reader.setCursor(cursor);
                break;
            }
            if (fullySpecifiedType == null) {
                fullySpecifiedType = singleDeclaration.getType();
                if (fullySpecifiedType == null) {
                    reader.setCursor(cursor);
                    break;
                }
            }
        }
        if (initDeclaratorList.isEmpty()) {
            return null;
        }
        return initDeclaratorList;
    }

    @Nullable
    public static GlslNode parseSingleDeclaration(@Nullable GlslSpecifiedType fullySpecifiedType, GlslTokenReader reader) {
        GlslNode initializer;
        int cursor = reader.getCursor();
        if (fullySpecifiedType == null) {
            fullySpecifiedType = parseFullySpecifiedType(reader);
            if (fullySpecifiedType == null) {
                reader.setCursor(cursor);
                return null;
            }
        }
        if (!reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
            if (fullySpecifiedType.getSpecifier().isStruct()) {
                return new GlslStructDeclarationNode(fullySpecifiedType);
            }
            return new GlslNewFieldNode(fullySpecifiedType, null, null);
        }
        int cursor2 = reader.getCursor();
        String name = reader.peek(-1).value();
        GlslSpecifiedType arraySpecifier = parseArraySpecifier(reader, fullySpecifiedType);
        if (arraySpecifier != null) {
            if (!reader.tryConsume(GlslLexer.TokenType.EQUAL)) {
                return new GlslNewFieldNode(arraySpecifier, name, null);
            }
            GlslNode initializer2 = parseInitializer(reader);
            if (initializer2 != null) {
                return new GlslNewFieldNode(arraySpecifier, name, initializer2);
            }
        }
        reader.setCursor(cursor2);
        if (reader.tryConsume(GlslLexer.TokenType.EQUAL) && (initializer = parseInitializer(reader)) != null) {
            return new GlslNewFieldNode(fullySpecifiedType, name, initializer);
        }
        reader.setCursor(cursor2);
        return new GlslNewFieldNode(fullySpecifiedType, name, null);
    }

    @Nullable
    public static GlslSpecifiedType parseFullySpecifiedType(GlslTokenReader reader) {
        GlslTypeSpecifier typeSpecifier;
        GlslTypeSpecifier typeSpecifier2 = parseTypeSpecifier(reader);
        if (typeSpecifier2 != null) {
            return new GlslSpecifiedType(typeSpecifier2);
        }
        int cursor = reader.getCursor();
        List<GlslTypeQualifier> typeQualifiers = parseTypeQualifiers(reader);
        if (typeQualifiers != null && (typeSpecifier = parseTypeSpecifier(reader)) != null) {
            return new GlslSpecifiedType(typeSpecifier, typeQualifiers);
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslTypeQualifier.Interpolation parseInterpolationQualifier(GlslTokenReader reader) {
        GlslLexer.TokenType type = reader.peekType(0);
        GlslTypeQualifier.Interpolation interpolationQualifier = type != null ? type.asInterpolationQualifier() : null;
        if (interpolationQualifier != null) {
            reader.skip();
            return interpolationQualifier;
        }
        return null;
    }

    @Nullable
    public static GlslTypeQualifier parseLayoutQualifier(GlslTokenReader reader) {
        if (!reader.tryConsume(GlslLexer.TokenType.LAYOUT, GlslLexer.TokenType.LEFT_PAREN)) {
            return null;
        }
        int layoutCursor = reader.getCursor();
        List<GlslTypeQualifier.LayoutId> layoutQualifierIds = new ArrayList<>();
        while (reader.canRead()) {
            GlslTypeQualifier.LayoutId qualifier = null;
            if (reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
                String identifier = reader.peek(-1).value();
                GlslNode expression = null;
                int cursor = reader.getCursor();
                if (reader.tryConsume(GlslLexer.TokenType.EQUAL)) {
                    expression = parseConditionalExpression(reader);
                    if (expression == null) {
                        reader.setCursor(cursor);
                    }
                }
                qualifier = GlslTypeQualifier.layoutId(identifier, expression);
            }
            if (qualifier == null && reader.tryConsume(GlslLexer.TokenType.SHARED)) {
                qualifier = GlslTypeQualifier.LayoutId.SHARED;
            }
            if (qualifier == null) {
                break;
            }
            layoutQualifierIds.add(qualifier);
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
            reader.markError("Expected ')'");
            reader.setCursor(layoutCursor);
            return null;
        }
        return GlslTypeQualifier.layout(layoutQualifierIds);
    }

    @Nullable
    public static List<GlslTypeQualifier> parseTypeQualifiers(GlslTokenReader reader) {
        List<GlslTypeQualifier> typeQualifiers = new ArrayList<>();
        while (reader.canRead()) {
            GlslTypeQualifier storageQualifier = parseStorageQualifier(reader);
            if (storageQualifier != null) {
                typeQualifiers.add(storageQualifier);
            } else {
                GlslTypeQualifier layoutQualifier = parseLayoutQualifier(reader);
                if (layoutQualifier != null) {
                    typeQualifiers.add(layoutQualifier);
                } else {
                    GlslTypeQualifier precisionQualifier = parsePrecisionQualifier(reader);
                    if (precisionQualifier != null) {
                        typeQualifiers.add(precisionQualifier);
                    } else {
                        GlslTypeQualifier interpolationQualifier = parseInterpolationQualifier(reader);
                        if (interpolationQualifier != null) {
                            typeQualifiers.add(interpolationQualifier);
                        } else if (reader.tryConsume(GlslLexer.TokenType.INVARIANT)) {
                            typeQualifiers.add(GlslTypeQualifier.Invariant.INVARIANT);
                        } else {
                            if (!reader.tryConsume(GlslLexer.TokenType.PRECISE)) {
                                break;
                            }
                            typeQualifiers.add(GlslTypeQualifier.Precise.PRECISE);
                        }
                    }
                }
            }
        }
        if (typeQualifiers.isEmpty()) {
            return null;
        }
        return typeQualifiers;
    }

    @Nullable
    public static GlslTypeQualifier parseStorageQualifier(GlslTokenReader reader) {
        GlslTypeQualifier.StorageType storageQualifier = reader.peek().type().asStorageQualifier();
        if (storageQualifier != null) {
            reader.skip();
            return storageQualifier;
        }
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.SUBROUTINE)) {
            if (reader.tryConsume(GlslLexer.TokenType.LEFT_PAREN)) {
                List<String> typeNames = new ArrayList<>();
                while (reader.canRead() && reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
                    typeNames.add(reader.peek(-1).value());
                    if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                        break;
                    }
                }
                if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
                    reader.markError("Expected ')'");
                    reader.setCursor(cursor);
                    return null;
                }
                return GlslTypeQualifier.storage((String[]) typeNames.toArray(x$0 -> {
                    return new String[x$0];
                }));
            }
            return GlslTypeQualifier.storage(new String[0]);
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslTypeSpecifier parseTypeSpecifier(GlslTokenReader reader) {
        GlslTypeSpecifier typeSpecifier;
        if (!reader.canRead()) {
            return null;
        }
        GlslLexer.Token token = reader.peek();
        GlslTypeSpecifier.BuiltinType type = token.type().asBuiltinType();
        if (type != null) {
            typeSpecifier = type;
            reader.skip();
        } else {
            GlslStructSpecifier structSpecifier = parseStructSpecifier(reader);
            if (structSpecifier != null) {
                typeSpecifier = structSpecifier;
            } else if (token.type() == GlslLexer.TokenType.IDENTIFIER) {
                reader.skip();
                typeSpecifier = GlslTypeSpecifier.named(token.value());
            } else {
                return null;
            }
        }
        GlslTypeSpecifier arraySpecifier = parseArraySpecifier(reader, typeSpecifier);
        if (arraySpecifier != null) {
            return arraySpecifier;
        }
        return typeSpecifier;
    }

    @Nullable
    public static GlslSpecifiedType parseArraySpecifier(GlslTokenReader reader, GlslSpecifiedType type) {
        GlslTypeSpecifier arraySpecifier = parseArraySpecifier(reader, type.getSpecifier());
        if (arraySpecifier != null) {
            return new GlslSpecifiedType(arraySpecifier, type.getQualifiers());
        }
        return null;
    }

    @Nullable
    public static GlslTypeSpecifier parseArraySpecifier(GlslTokenReader reader, GlslTypeSpecifier type) {
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.LEFT_BRACKET)) {
            if (reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACKET)) {
                return GlslTypeSpecifier.array(type, null);
            }
            GlslNode conditionalExpression = parseConditionalExpression(reader);
            if (conditionalExpression != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACKET)) {
                return GlslTypeSpecifier.array(type, conditionalExpression);
            }
            reader.setCursor(cursor);
            return null;
        }
        return null;
    }

    @Nullable
    public static GlslTypeQualifier.Precision parsePrecisionQualifier(GlslTokenReader reader) {
        GlslLexer.TokenType type = reader.peekType(0);
        GlslTypeQualifier.Precision precisionQualifier = type != null ? type.asPrecisionQualifier() : null;
        if (precisionQualifier != null) {
            reader.skip();
            return precisionQualifier;
        }
        return null;
    }

    @Nullable
    public static GlslStructSpecifier parseStructSpecifier(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        if (!reader.tryConsume(GlslLexer.TokenType.STRUCT)) {
            return null;
        }
        String name = null;
        if (reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
            name = reader.peek(-1).value();
        }
        if (!reader.tryConsume(GlslLexer.TokenType.LEFT_BRACE)) {
            reader.setCursor(cursor);
            return null;
        }
        List<GlslStructField> fields = parseStructDeclarationList(reader);
        if (fields == null) {
            return null;
        }
        if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
            reader.markError("Expected '}'");
            reader.setCursor(cursor);
            return null;
        }
        return GlslTypeSpecifier.struct(name, fields);
    }

    @Nullable
    public static List<GlslStructField> parseStructDeclarationList(GlslTokenReader reader) {
        List<GlslStructField> fields;
        List<GlslStructField> declarations = new ArrayList<>();
        while (reader.canRead() && (fields = parseStructDeclaration(reader)) != null) {
            declarations.addAll(fields);
        }
        if (declarations.isEmpty()) {
            return null;
        }
        return declarations;
    }

    @Nullable
    public static List<GlslStructField> parseStructDeclaration(GlslTokenReader reader) {
        List<GlslStructField> structDeclaration;
        int cursor = reader.getCursor();
        GlslSpecifiedType fullySpecifiedType = parseFullySpecifiedType(reader);
        if (fullySpecifiedType == null || (structDeclaration = parseStructDeclaratorList(fullySpecifiedType, reader)) == null) {
            return null;
        }
        if (!reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
            reader.markError("Expected ';'");
            reader.setCursor(cursor);
            return null;
        }
        return structDeclaration;
    }

    @Nullable
    public static List<GlslStructField> parseStructDeclaratorList(GlslSpecifiedType type, GlslTokenReader reader) {
        int cursor = reader.getCursor();
        List<GlslStructField> fields = new ArrayList<>();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            GlslStructField field = parseStructDeclarator(type, reader);
            if (field == null) {
                reader.setCursor(cursor);
                break;
            }
            fields.add(field);
            cursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        if (fields.isEmpty()) {
            return null;
        }
        return fields;
    }

    @Nullable
    public static GlslStructField parseStructDeclarator(GlslSpecifiedType type, GlslTokenReader reader) {
        if (!reader.tryConsume(GlslLexer.TokenType.IDENTIFIER)) {
            return null;
        }
        String name = reader.peek(-1).value();
        GlslSpecifiedType arraySpecifier = parseArraySpecifier(reader, type);
        return new GlslStructField((GlslType) Objects.requireNonNullElse(arraySpecifier, type), name);
    }

    @Nullable
    public static GlslNode parseInitializer(GlslTokenReader reader) {
        GlslNode assignmentExpression = parseAssignmentExpression(reader);
        if (assignmentExpression != null) {
            return assignmentExpression;
        }
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.LEFT_BRACE)) {
            List<GlslNode> initializerList = parseInitializerList(reader);
            reader.tryConsume(GlslLexer.TokenType.COMMA);
            if (reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
                return GlslNode.compound(initializerList);
            }
        }
        reader.setCursor(cursor);
        return null;
    }

    public static List<GlslNode> parseInitializerList(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        List<GlslNode> initializers = new ArrayList<>();
        while (true) {
            if (!reader.canRead()) {
                break;
            }
            List<GlslNode> statements = parseStatement(reader);
            if (statements == null) {
                reader.setCursor(cursor);
                break;
            }
            initializers.addAll(statements);
            cursor = reader.getCursor();
            if (!reader.tryConsume(GlslLexer.TokenType.COMMA)) {
                break;
            }
        }
        return initializers;
    }

    @Nullable
    public static List<GlslNode> parseStatement(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        GlslNode compoundStatement = parseCompoundStatement(reader);
        if (compoundStatement != null) {
            reader.markNode(cursor, compoundStatement);
            return compoundStatement.toList();
        }
        reader.setCursor(cursor);
        List<GlslNode> simpleStatements = parseSimpleStatement(reader);
        if (simpleStatements != null) {
            for (GlslNode simpleStatement : simpleStatements) {
                reader.markNode(cursor, simpleStatement);
            }
            return simpleStatements;
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static List<GlslNode> parseSimpleStatement(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        List<GlslNode> declaration = parseDeclaration(reader);
        if (declaration != null) {
            return declaration;
        }
        reader.setCursor(cursor);
        GlslNode statement = parseExpressionStatement(reader);
        if (statement != null) {
            return Collections.singletonList(statement);
        }
        reader.setCursor(cursor);
        GlslNode statement2 = parseSelectionStatement(reader);
        if (statement2 != null) {
            return Collections.singletonList(statement2);
        }
        reader.setCursor(cursor);
        GlslNode statement3 = parseSwitchStatement(reader);
        if (statement3 != null) {
            return Collections.singletonList(statement3);
        }
        reader.setCursor(cursor);
        GlslNode statement4 = parseCaseLabel(reader);
        if (statement4 != null) {
            return Collections.singletonList(statement4);
        }
        reader.setCursor(cursor);
        GlslNode statement5 = parseIterationStatement(reader);
        if (statement5 != null) {
            return Collections.singletonList(statement5);
        }
        reader.setCursor(cursor);
        GlslNode statement6 = parseJumpStatement(reader);
        if (statement6 != null) {
            return Collections.singletonList(statement6);
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseCompoundStatement(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        if (!reader.tryConsume(GlslLexer.TokenType.LEFT_BRACE)) {
            reader.setCursor(cursor);
            return null;
        }
        if (reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
            return GlslEmptyNode.INSTANCE;
        }
        List<GlslNode> statements = parseStatementList(reader);
        if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
            reader.setCursor(cursor);
            return null;
        }
        return GlslNode.compound(statements);
    }

    @Nullable
    public static List<GlslNode> parseStatementNoNewScope(GlslTokenReader reader) {
        List<GlslNode> statementNoNewScope = parseCompoundStatementNoNewScope(reader);
        if (statementNoNewScope != null) {
            return statementNoNewScope;
        }
        return parseSimpleStatement(reader);
    }

    public static List<GlslNode> parseCompoundStatementNoNewScope(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        if (!reader.tryConsume(GlslLexer.TokenType.LEFT_BRACE)) {
            return null;
        }
        List<GlslNode> statements = parseStatementList(reader);
        if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
            reader.markError("Expected '}'");
            reader.setCursor(cursor);
            return null;
        }
        return statements;
    }

    public static List<GlslNode> parseStatementList(GlslTokenReader reader) {
        List<GlslNode> statement;
        List<GlslNode> statements = new ArrayList<>();
        while (reader.canRead() && (statement = parseStatement(reader)) != null) {
            statements.addAll(statement);
        }
        return statements;
    }

    @Nullable
    public static GlslNode parseExpressionStatement(GlslTokenReader reader) {
        if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
            return GlslEmptyNode.INSTANCE;
        }
        int cursor = reader.getCursor();
        GlslNode condition = parseCondition(reader);
        if (condition != null && reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
            return condition;
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseSelectionStatement(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        if (!reader.tryConsume(GlslLexer.TokenType.IF)) {
            return null;
        }
        if (!reader.tryConsume(GlslLexer.TokenType.LEFT_PAREN)) {
            reader.markError("Expected '('");
            reader.setCursor(cursor);
            return null;
        }
        GlslNode expression = parseCondition(reader);
        if (expression == null) {
            reader.setCursor(cursor);
            return null;
        }
        if (!reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN)) {
            reader.markError("Expected ')'");
            reader.setCursor(cursor);
            return null;
        }
        List<GlslNode> statements = parseStatement(reader);
        if (statements == null) {
            reader.setCursor(cursor);
            return null;
        }
        int cursor2 = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.ELSE)) {
            List<GlslNode> otherStatements = parseStatement(reader);
            if (otherStatements != null) {
                return new GlslIfNode(expression, statements, otherStatements);
            }
            reader.setCursor(cursor2);
            return null;
        }
        reader.setCursor(cursor2);
        return new GlslIfNode(expression, statements, Collections.emptyList());
    }

    @Nullable
    public static GlslNode parseCondition(GlslTokenReader reader) {
        List<GlslNode> expression = parseExpression(reader);
        if (expression != null) {
            return GlslNode.compound(expression);
        }
        int cursor = reader.getCursor();
        GlslSpecifiedType type = parseFullySpecifiedType(reader);
        if (type != null && reader.tryConsume(GlslLexer.TokenType.IDENTIFIER, GlslLexer.TokenType.EQUAL)) {
            String name = reader.peek(-2).value();
            GlslNode initializer = parseInitializer(reader);
            if (initializer != null) {
                return new GlslNewFieldNode(type, name, initializer);
            }
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseSwitchStatement(GlslTokenReader reader) {
        GlslNode condition;
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.SWITCH, GlslLexer.TokenType.LEFT_PAREN) && (condition = parseCondition(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN, GlslLexer.TokenType.LEFT_BRACE)) {
            List<GlslNode> statements = parseStatementList(reader);
            if (reader.tryConsume(GlslLexer.TokenType.RIGHT_BRACE)) {
                return new GlslSwitchNode(condition, statements);
            }
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslCaseLabelNode parseCaseLabel(GlslTokenReader reader) {
        GlslNode condition;
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.CASE) && (condition = parseCondition(reader)) != null && reader.tryConsume(GlslLexer.TokenType.COLON)) {
            return new GlslCaseLabelNode(condition);
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.DEFAULT, GlslLexer.TokenType.COLON)) {
            return new GlslCaseLabelNode(null);
        }
        return null;
    }

    @Nullable
    public static GlslNode parseIterationStatement(GlslTokenReader reader) {
        GlslNode init;
        GlslNode condition;
        List<GlslNode> body;
        List<GlslNode> body2;
        GlslNode condition2;
        GlslNode condition3;
        List<GlslNode> body3;
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.WHILE, GlslLexer.TokenType.LEFT_PAREN) && (condition3 = parseCondition(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN) && (body3 = parseStatementNoNewScope(reader)) != null) {
            return new GlslWhileLoopNode(condition3, body3, GlslWhileLoopNode.Type.WHILE);
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.DO) && (body2 = parseStatement(reader)) != null && reader.tryConsume(GlslLexer.TokenType.WHILE, GlslLexer.TokenType.LEFT_PAREN) && (condition2 = parseCondition(reader)) != null && reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN, GlslLexer.TokenType.SEMICOLON)) {
            return new GlslWhileLoopNode(condition2, body2, GlslWhileLoopNode.Type.DO);
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.FOR, GlslLexer.TokenType.LEFT_PAREN) && (init = parseForInitStatement(reader)) != null && (condition = parseConditionopt(reader)) != null && reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
            GlslNode increment = parseCondition(reader);
            if (reader.tryConsume(GlslLexer.TokenType.RIGHT_PAREN) && (body = parseStatementNoNewScope(reader)) != null) {
                return new GlslForLoopNode(init, condition, increment, body);
            }
        }
        reader.setCursor(cursor);
        return null;
    }

    @Nullable
    public static GlslNode parseForInitStatement(GlslTokenReader reader) {
        GlslNode expressionStatement = parseExpressionStatement(reader);
        if (expressionStatement != null) {
            return expressionStatement;
        }
        List<GlslNode> declaration = parseDeclaration(reader);
        if (declaration != null) {
            return GlslNode.compound(declaration);
        }
        return null;
    }

    public static GlslNode parseConditionopt(GlslTokenReader reader) {
        GlslNode condition = parseCondition(reader);
        return condition != null ? condition : GlslEmptyNode.INSTANCE;
    }

    @Nullable
    public static GlslNode parseJumpStatement(GlslTokenReader reader) {
        if (reader.tryConsume(GlslLexer.TokenType.CONTINUE, GlslLexer.TokenType.SEMICOLON)) {
            return GlslJumpNode.CONTINUE;
        }
        if (reader.tryConsume(GlslLexer.TokenType.BREAK, GlslLexer.TokenType.SEMICOLON)) {
            return GlslJumpNode.BREAK;
        }
        int cursor = reader.getCursor();
        if (reader.tryConsume(GlslLexer.TokenType.RETURN)) {
            if (reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                return new GlslReturnNode(null);
            }
            GlslNode condition = parseCondition(reader);
            if (condition != null && reader.tryConsume(GlslLexer.TokenType.SEMICOLON)) {
                return new GlslReturnNode(condition);
            }
        }
        reader.setCursor(cursor);
        if (reader.tryConsume(GlslLexer.TokenType.DISCARD, GlslLexer.TokenType.SEMICOLON)) {
            return GlslJumpNode.DISCARD;
        }
        return null;
    }

    @Nullable
    public static GlslFunctionNode parseFunctionDefinition(GlslTokenReader reader) {
        int cursor = reader.getCursor();
        GlslFunctionHeader functionPrototype = parseFunctionPrototype(reader);
        if (functionPrototype == null) {
            return null;
        }
        List<GlslNode> statement = parseCompoundStatementNoNewScope(reader);
        if (statement == null) {
            reader.setCursor(cursor);
            return null;
        }
        return new GlslFunctionNode(functionPrototype, statement);
    }
}
