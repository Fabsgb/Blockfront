package gg.moonflower.molangcompiler.core.compiler;

import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/MolangLexer.class */
@ApiStatus.Internal
public final class MolangLexer {
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("[\n\t]");

    public static Token[] createTokens(String input) throws MolangSyntaxException {
        StringReader reader = new StringReader(WHITESPACE_PATTERN.matcher(input).replaceAll(""));
        List<Token> tokens = new ArrayList<>();
        while (reader.canRead()) {
            reader.skipWhitespace();
            Token token = getToken(reader);
            if (token != null) {
                if (!tokens.isEmpty()) {
                    Token lastToken = tokens.get(tokens.size() - 1);
                    if (lastToken.type == TokenType.RIGHT_BRACE && token.type != TokenType.SEMICOLON) {
                        tokens.add(new Token(TokenType.SEMICOLON, ";"));
                    }
                }
                tokens.add(token);
            } else {
                throw new MolangSyntaxException("Unknown Token", reader.getString(), reader.getCursor());
            }
        }
        return (Token[]) tokens.toArray(x$0 -> {
            return new Token[x$0];
        });
    }

    private static Token getToken(StringReader reader) {
        String word = reader.getString().substring(reader.getCursor());
        for (TokenType type : TokenType.values()) {
            Matcher matcher = type.pattern.matcher(word);
            if (matcher.find() && matcher.start() == 0) {
                reader.skip(matcher.end());
                return new Token(type, word.substring(0, matcher.end()));
            }
        }
        return null;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/MolangLexer$Token.class */
    public static final class Token extends Record {
        private final TokenType type;
        private final String value;

        public Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Token.class), Token.class, "type;value", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangLexer$Token;->type:Lgg/moonflower/molangcompiler/core/compiler/MolangLexer$TokenType;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangLexer$Token;->value:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Token.class, Object.class), Token.class, "type;value", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangLexer$Token;->type:Lgg/moonflower/molangcompiler/core/compiler/MolangLexer$TokenType;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangLexer$Token;->value:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public TokenType type() {
            return this.type;
        }

        public String value() {
            return this.value;
        }

        @Override // java.lang.Record
        public String toString() {
            return this.type + "[" + this.value + "]";
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/MolangLexer$TokenType.class */
    public enum TokenType {
        RETURN("return"),
        LOOP("loop"),
        CONTINUE("continue"),
        BREAK("break"),
        IF("if"),
        ELSE("else"),
        THIS("this"),
        TRUE("true"),
        FALSE("false"),
        NUMERAL("\\d+"),
        ALPHANUMERIC("[A-Za-z_][A-Za-z0-9_]*"),
        NULL_COALESCING("\\?\\?"),
        INCREMENT("\\+\\+"),
        DECREMENT("\\-\\-"),
        SPECIAL("[<>&|!?:]"),
        BINARY_OPERATION("[-+*/]"),
        LEFT_PARENTHESIS("\\("),
        RIGHT_PARENTHESIS("\\)"),
        LEFT_BRACE("\\{"),
        RIGHT_BRACE("\\}"),
        DOT("\\."),
        COMMA("\\,"),
        EQUAL("="),
        SEMICOLON(";");

        private final Pattern pattern;

        TokenType(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        public boolean validVariableName() {
            return this == NUMERAL || this == ALPHANUMERIC || this == DOT;
        }

        public boolean canNegate() {
            return this == NUMERAL || this == ALPHANUMERIC || this == THIS;
        }

        public boolean isTerminating() {
            return this == SEMICOLON;
        }

        public boolean isOutOfScope() {
            return this == RIGHT_PARENTHESIS || this == RIGHT_BRACE || this == COMMA;
        }
    }
}
