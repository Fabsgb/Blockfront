package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType.class */
@ApiStatus.Internal
final class TokenType extends Record {
    private final String name;
    private final String text;
    private static final List<TokenType> TYPES = new ArrayList();

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, TokenType.class), TokenType.class, "name;text", "FIELD:Lio/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType;->name:Ljava/lang/String;", "FIELD:Lio/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType;->text:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, TokenType.class), TokenType.class, "name;text", "FIELD:Lio/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType;->name:Ljava/lang/String;", "FIELD:Lio/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType;->text:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, TokenType.class, Object.class), TokenType.class, "name;text", "FIELD:Lio/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType;->name:Ljava/lang/String;", "FIELD:Lio/github/ocelot/glslprocessor/lib/anarres/cpp/TokenType;->text:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    static {
        for (int i = 0; i < 255; i++) {
            String text = String.valueOf((char) i);
            addTokenType(i, text, text);
        }
        addTokenType(Token.AND_EQ, "AND_EQ", "&=");
        addTokenType(Token.ARROW, "ARROW", "->");
        addTokenType(Token.CHARACTER, "CHARACTER");
        addTokenType(Token.CCOMMENT, "CCOMMENT");
        addTokenType(Token.CPPCOMMENT, "CPPCOMMENT");
        addTokenType(Token.DEC, "DEC", "--");
        addTokenType(Token.DIV_EQ, "DIV_EQ", "/=");
        addTokenType(Token.ELLIPSIS, "ELLIPSIS", "...");
        addTokenType(Token.EOF, "EOF");
        addTokenType(Token.f8804EQ, "EQ", "==");
        addTokenType(Token.f8805GE, "GE", ">=");
        addTokenType(Token.HASH, "HASH", "#");
        addTokenType(Token.HEADER, "HEADER");
        addTokenType(Token.IDENTIFIER, "IDENTIFIER");
        addTokenType(Token.INC, "INC", "++");
        addTokenType(Token.NUMBER, "NUMBER");
        addTokenType(Token.LAND, "LAND", "&&");
        addTokenType(Token.LAND_EQ, "LAND_EQ", "&&=");
        addTokenType(Token.f8806LE, "LE", "<=");
        addTokenType(Token.LITERAL, "LITERAL");
        addTokenType(Token.LOR, "LOR", "||");
        addTokenType(Token.LOR_EQ, "LOR_EQ", "||=");
        addTokenType(Token.LSH, "LSH", "<<");
        addTokenType(Token.LSH_EQ, "LSH_EQ", "<<=");
        addTokenType(Token.MOD_EQ, "MOD_EQ", "%=");
        addTokenType(Token.MULT_EQ, "MULT_EQ", "*=");
        addTokenType(Token.f8807NE, "NE", "!=");
        addTokenType(Token.f8808NL, "NL");
        addTokenType(Token.OR_EQ, "OR_EQ", "|=");
        addTokenType(Token.PASTE, "PASTE", "##");
        addTokenType(Token.PLUS_EQ, "PLUS_EQ", "+=");
        addTokenType(Token.RANGE, "RANGE", "..");
        addTokenType(Token.RSH, "RSH", ">>");
        addTokenType(Token.RSH_EQ, "RSH_EQ", ">>=");
        addTokenType(Token.SQSTRING, "SQSTRING");
        addTokenType(Token.STRING, "STRING");
        addTokenType(Token.SUB_EQ, "SUB_EQ", "-=");
        addTokenType(Token.WHITESPACE, "WHITESPACE");
        addTokenType(Token.XOR_EQ, "XOR_EQ", "^=");
        addTokenType(Token.M_ARG, "M_ARG");
        addTokenType(Token.M_PASTE, "M_PASTE");
        addTokenType(Token.M_STRING, "M_STRING");
        addTokenType(Token.P_LINE, "P_LINE");
        addTokenType(300, "INVALID");
    }

    private static void addTokenType(int type, @NotNull String name, @Nullable String text) {
        while (TYPES.size() <= type) {
            TYPES.add(null);
        }
        TYPES.set(type, new TokenType(name, text));
    }

    private static void addTokenType(int type, @NotNull String name) {
        addTokenType(type, name, null);
    }

    @Nullable
    public static TokenType getTokenType(int type) {
        try {
            return TYPES.get(type);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @NotNull
    public static String getTokenName(int type) {
        TokenType tokenType = getTokenType(type);
        if (tokenType == null) {
            return "Unknown" + type;
        }
        return tokenType.name();
    }

    @Nullable
    public static String getTokenText(int type) {
        TokenType tokenType = getTokenType(type);
        if (tokenType == null) {
            return null;
        }
        return tokenType.text();
    }

    TokenType(@NotNull String name, @Nullable String text) {
        this.name = name;
        this.text = text;
    }

    @NotNull
    public String name() {
        return this.name;
    }

    @Nullable
    public String text() {
        return this.text;
    }
}
