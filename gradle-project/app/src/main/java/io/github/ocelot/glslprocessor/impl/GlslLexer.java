package io.github.ocelot.glslprocessor.impl;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.blockfront.AbstractC0422pq;
import com.boehmod.blockfront.C0093dj;
import com.boehmod.blockfront.C0097dn;
import com.boehmod.blockfront.C0122em;
import com.boehmod.blockfront.C0163g;
import com.boehmod.blockfront.C0407pb;
import com.boehmod.blockfront.dE;
import com.boehmod.blockfront.pQ;
import com.boehmod.blockfront.rY;
import com.boehmod.blockfront.sR;
import foundry.veil.api.client.necromancer.Skeleton;
import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.node.expression.GlslAssignmentNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslUnaryNode;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.NumericValue;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ObjIntConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslLexer.class */
@ApiStatus.Internal
public class GlslLexer {
    private static final Pattern MULTI_COMMENT_PATTERN = Pattern.compile("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/");

    public static Token[] createTokens(String input) throws GlslSyntaxException {
        return createTokens(input, null);
    }

    public static Token[] createTokens(String input, @Nullable ObjIntConsumer<Token> commentConsumer) throws GlslSyntaxException {
        GlslStringReader reader = new GlslStringReader(input);
        List<Token> tokens = new ArrayList<>();
        reader.skipWhitespace();
        while (reader.canRead()) {
            Token token = readToken(reader);
            if (token != null) {
                if (token.type != TokenType.COMMENT && token.type != TokenType.MULTI_COMMENT) {
                    tokens.add(token);
                } else if (commentConsumer != null) {
                    commentConsumer.accept(token, tokens.size());
                }
                reader.skipWhitespace();
            } else {
                throw new GlslSyntaxException("Unknown Token", reader.string, reader.cursor + 1);
            }
        }
        return (Token[]) tokens.toArray(x$0 -> {
            return new Token[x$0];
        });
    }

    @Nullable
    private static Token readToken(GlslStringReader reader) {
        int cursor = reader.cursor;
        String string = reader.string;
        char[] chars = reader.chars;
        char firstChar = chars[cursor];
        boolean number = Character.isDigit(firstChar) || (chars.length > 1 && firstChar == '.' && Character.isDigit(chars[cursor + 1]));
        if (firstChar == '#') {
            int i = cursor + 1;
            while (i < chars.length && chars[i] != '\n') {
                i++;
            }
            reader.skip(i - cursor);
            return new Token(TokenType.DIRECTIVE, string.substring(cursor, i));
        }
        if (firstChar == '/' && chars.length > 1) {
            if (chars[cursor + 1] == '/') {
                int i2 = cursor + 2;
                while (i2 < chars.length && chars[i2] != '\n') {
                    i2++;
                }
                reader.skip(i2 - cursor);
                return new Token(TokenType.COMMENT, string.substring(cursor, i2));
            }
            if (chars[cursor + 1] == '*') {
                Matcher matcher = MULTI_COMMENT_PATTERN.matcher(string.substring(cursor));
                if (!matcher.find() || matcher.start() != 0) {
                    return null;
                }
                reader.skip(matcher.end());
                return new Token(TokenType.MULTI_COMMENT, string.substring(cursor, cursor + matcher.end()));
            }
        }
        int patternLength = 0;
        TokenType patternType = null;
        String longestPattern = null;
        if (number) {
            return GlslNumberConstantParser.parseNumberConstant(reader);
        }
        if (isValidIdentifierChar(firstChar)) {
            int i3 = cursor + 1;
            while (i3 < chars.length) {
                char c = chars[i3];
                if (!Character.isDigit(c) && !isValidIdentifierChar(c)) {
                    break;
                }
                i3++;
            }
            patternLength = i3 - cursor;
            longestPattern = string.substring(cursor, i3);
            patternType = TokenType.IDENTIFIER;
        }
        int wordLength = 0;
        TokenType longestWordType = null;
        String longestWord = null;
        for (TokenType type : TokenType.WORD_VALUES) {
            int[] wordLengths = type.wordLengths;
            for (int i4 = 0; i4 < type.wordCount; i4++) {
                if (wordLengths[i4] > wordLength) {
                    char[] charArray = type.chars[i4];
                    if (chars.length - cursor >= charArray.length && Arrays.mismatch(chars, cursor, cursor + charArray.length, charArray, 0, charArray.length) < 0) {
                        wordLength = wordLengths[i4];
                        longestWordType = type;
                        longestWord = type.words[i4];
                    }
                }
            }
        }
        if ((longestPattern == null) ^ (longestWordType == null)) {
            if (longestPattern != null) {
                reader.skip(patternLength);
                return new Token(patternType, longestPattern);
            }
            reader.skip(wordLength);
            return new Token(longestWordType, longestWord);
        }
        if (longestPattern == null) {
            return null;
        }
        if (wordLength >= patternLength) {
            reader.skip(wordLength);
            return new Token(longestWordType, longestWord);
        }
        reader.skip(patternLength);
        return new Token(patternType, longestPattern);
    }

    private static boolean isValidIdentifierChar(char c) {
        return c == '_' || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslLexer$Token.class */
    public static final class Token extends Record {
        private final TokenType type;
        private final String value;

        public Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Token.class), Token.class, "type;value", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslLexer$Token;->type:Lio/github/ocelot/glslprocessor/impl/GlslLexer$TokenType;", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslLexer$Token;->value:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Token.class, Object.class), Token.class, "type;value", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslLexer$Token;->type:Lio/github/ocelot/glslprocessor/impl/GlslLexer$TokenType;", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslLexer$Token;->value:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
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

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslLexer$TokenType.class */
    public enum TokenType {
        DIRECTIVE(new String[0]),
        GLSL_MACRO("__LINE__", "__FILE__", "__VERSION__"),
        COMMENT(new String[0]),
        MULTI_COMMENT(new String[0]),
        CONST("const"),
        BOOL("bool"),
        FLOAT("float"),
        INT("int"),
        UINT("uint"),
        DOUBLE("double"),
        BVEC2("bvec2"),
        BVEC3("bvec3"),
        BVEC4("bvec4"),
        IVEC2("ivec2"),
        IVEC3("ivec3"),
        IVEC4("ivec4"),
        UVEC2("uvec2"),
        UVEC3("uvec3"),
        UVEC4("uvec4"),
        VEC2("vec2"),
        VEC3("vec3"),
        VEC4("vec4"),
        MAT2("mat2"),
        MAT3("mat3"),
        MAT4("mat4"),
        MAT2X2("mat2x2"),
        MAT2X3("mat2x3"),
        MAT2X4("mat2x4"),
        MAT3X2("mat3x2"),
        MAT3X3("mat3x3"),
        MAT3X4("mat3x4"),
        MAT4X2("mat4x2"),
        MAT4X3("mat4x3"),
        MAT4X4("mat4x4"),
        DVEC2("dvec2"),
        DVEC3("dvec3"),
        DVEC4("dvec4"),
        DMAT2("dmat2"),
        DMAT3("dmat3"),
        DMAT4("dmat4"),
        DMAT2X2("dmat2x2"),
        DMAT2X3("dmat2x3"),
        DMAT2X4("dmat2x4"),
        DMAT3X2("dmat3x2"),
        DMAT3X3("dmat3x3"),
        DMAT3X4("dmat3x4"),
        DMAT4X2("dmat4x2"),
        DMAT4X3("dmat4x3"),
        DMAT4X4("dmat4x4"),
        CENTROID("centroid"),
        IN("in"),
        OUT("out"),
        INOUT("inout"),
        UNIFORM("uniform"),
        PATCH("patch"),
        SAMPLE("sample"),
        BUFFER("buffer"),
        SHARED("shared"),
        COHERENT("cohent"),
        VOLATILE("volatile"),
        RESTRICT("restrict"),
        READONLY("readonly"),
        WRITEONLY("writeonly"),
        NOPERSPECTIVE("noperspective"),
        FLAT("flat"),
        SMOOTH("smooth"),
        LAYOUT("layout"),
        ATOMIC_UINT("atomic_uint"),
        SAMPLER2D("sampler2D"),
        SAMPLER3D("sampler3D"),
        SAMPLERCUBE("samplerCube"),
        SAMPLER2DSHADOW("sampler2DShadow"),
        SAMPLERCUBESHADOW("samplerCubeShadow"),
        SAMPLER2DARRAY("sampler2DArray"),
        SAMPLER2DARRAYSHADOW("sampler2DArrayShadow"),
        ISAMPLER2D("isampler2D"),
        ISAMPLER3D("isampler3D"),
        ISAMPLERCUBE("isamplerCube"),
        ISAMPLER2DARRAY("isampler2DArray"),
        USAMPLER2D("usampler2D"),
        USAMPLER3D("usampler3D"),
        USAMPLERCUBE("usamplerCube"),
        USAMPLER2DARRAY("uSampler2DArray"),
        SAMPLER1D("sampler1D"),
        SAMPLER1DSHADOW("sampler1DShadow"),
        SAMPLER1DARRAY("sampler1DArray"),
        SAMPLER1DARRAYSHADOW("sampler1DArrayShadow"),
        ISAMPLER1D("isampler1D"),
        ISAMPLER1DARRAY("isampler1DArray"),
        USAMPLER1D("usampler1D"),
        USAMPLER1DARRAY("usampler1DArray"),
        SAMPLER2DRECT("sampler2DRect"),
        SAMPLER2DRECTSHADOW("sampler2DRectShadow"),
        ISAMPLER2DRECT("isampler2DRect"),
        USAMPLER2DRECT("usampler2DRect"),
        SAMPLERBUFFER("samplerBuffer"),
        ISAMPLERBUFFER("isamplerBuffer"),
        USAMPLERBUFFER("usamplerBuffer"),
        SAMPLERCUBEARRAY("samplerCubeArray"),
        SAMPLERCUBEARRAYSHADOW("samplerCubeArrayShadow"),
        ISAMPLERCUBEARRAY("isamplerCubeArray"),
        USAMPLERCUBEARRAY("usamplerCubeArray"),
        SAMPLER2DMS("sampler2Dms"),
        ISAMPLER2DMS("isampler2Dms"),
        USAMPLER2DMS("usampler2Dms"),
        SAMPLER2DMSARRAY("sampler2DMSArray"),
        ISAMPLER2DMSARRAY("isampler2DMSArray"),
        USAMPLER2DMSARRAY("usampler2DMSArray"),
        IMAGE2D("image2D"),
        IIMAGE2D("iimage2D"),
        UIMAGE2D("uimage2D"),
        IMAGE3D("image3D"),
        IIMAGE3D("iimage3D"),
        UIMAGE3D("uimage3D"),
        IMAGECUBE("imagecube"),
        IIMAGECUBE("iimageCube"),
        UIMAGECUBE("uimageCube"),
        IMAGEBUFFER("imageBuffer"),
        IIMAGEBUFFER("iimageBuffer"),
        UIMAGEBUFFER("uimageBuffer"),
        IMAGE2DARRAY("image2DArray"),
        IIMAGE2DARRAY("iimage2DArray"),
        UIMAGE2DARRAY("uimage2DArray"),
        IMAGECUBEARRAY("imagecubeArray"),
        IIMAGECUBEARRAY("iimageCubeArray"),
        UIMAGECUBEARRAY("uimageCubeArray"),
        IMAGE1D("image1D"),
        IIMAGE1D("iimage1D"),
        UIMAGE1D("uimage1D"),
        IMAGE1DARRAY("image1DArray"),
        IIMAGE1DARRAY("iimage1DArray"),
        UIMAGE1DARRAY("uimage1DArray"),
        IMAGE2DRECT("image2DRect"),
        IIMAGE2DRECT("iimage2DRect"),
        UIMAGE2DRECT("uimage2DRect"),
        IMAGE2DMS("image2Dms"),
        IIMAGE2DMS("iimage2DMS"),
        UIMAGE2DMS("uimage2DMS"),
        IMAGE2DMSARRAY("image2DMSArray"),
        IIMAGE2DMSARRAY("iimage2DMSArray"),
        UIMAGE2DMSARRAY("uimage2DMSArray"),
        STRUCT("struct"),
        VOID("void"),
        WHILE("while"),
        BREAK("break"),
        CONTINUE("continue"),
        DO("do"),
        ELSE("else"),
        FOR("for"),
        IF("if"),
        DISCARD("discard"),
        RETURN("return"),
        SWITCH("switch"),
        CASE("case"),
        DEFAULT("default"),
        SUBROUTINE("subroutine"),
        FLOATING_CONSTANT(new String[0]),
        DOUBLE_CONSTANT(new String[0]),
        UINTEGER_HEXADECIMAL_CONSTANT(new String[0]),
        UINTEGER_OCTAL_CONSTANT(new String[0]),
        UINTEGER_DECIMAL_CONSTANT(new String[0]),
        INTEGER_HEXADECIMAL_CONSTANT(new String[0]),
        INTEGER_OCTAL_CONSTANT(new String[0]),
        INTEGER_DECIMAL_CONSTANT(new String[0]),
        BOOL_CONSTANT("true", "false"),
        LEFT_OP("<<"),
        RIGHT_OP(">>"),
        INC_OP("++"),
        DEC_OP("--"),
        LE_OP("<="),
        GE_OP(">="),
        EQ_OP("=="),
        NE_OP("!="),
        AND_OP("&&"),
        OR_OP("||"),
        XOR_OP("^^"),
        MUL_ASSIGN("*="),
        DIV_ASSIGN("/="),
        ADD_ASSIGN("+="),
        MOD_ASSIGN("%="),
        LEFT_ASSIGN("<<="),
        RIGHT_ASSIGN(">>="),
        AND_ASSIGN("&="),
        XOR_ASSIGN("^="),
        OR_ASSIGN("|="),
        SUB_ASSIGN("-="),
        LEFT_PAREN("("),
        RIGHT_PAREN(")"),
        LEFT_BRACKET("["),
        RIGHT_BRACKET("]"),
        LEFT_BRACE("{"),
        RIGHT_BRACE("}"),
        DOT("."),
        COMMA(","),
        COLON(":"),
        EQUAL("="),
        SEMICOLON(";"),
        BANG("!"),
        DASH("-"),
        TILDE("~"),
        PLUS("+"),
        STAR("*"),
        SLASH("/"),
        PERCENT("%"),
        LEFT_ANGLE("<"),
        RIGHT_ANGLE(">"),
        VERTICAL_BAR("|"),
        CARET("^"),
        AMPERSAND("&"),
        QUESTION("?"),
        INVARIANT("invariant"),
        PRECISE("precise"),
        HIGH_PRECISION("highp"),
        MEDIUM_PRECISION("mediump"),
        LOW_PRECISION("lowp"),
        PRECISION("precision"),
        IDENTIFIER(new String[0]);

        private static final TokenType[] WORD_VALUES = (TokenType[]) Arrays.stream(values()).filter(type -> {
            return type.words != null;
        }).toArray(x$0 -> {
            return new TokenType[x$0];
        });
        private final int wordCount;
        private final String[] words;
        private final int[] wordLengths;
        private final char[][] chars;

        TokenType(String... words) {
            if (words.length > 0) {
                this.wordCount = words.length;
                this.words = words;
                this.wordLengths = Arrays.stream(words).mapToInt((v0) -> {
                    return v0.length();
                }).toArray();
                this.chars = (char[][]) Arrays.stream(words).map((v0) -> {
                    return v0.toCharArray();
                }).toArray(x$0 -> {
                    return new char[x$0];
                });
                return;
            }
            this.wordCount = 0;
            this.words = null;
            this.wordLengths = null;
            this.chars = null;
        }

        @VisibleForTesting
        public String[] getWords() {
            return this.words;
        }

        @Nullable
        public GlslTypeSpecifier.BuiltinType asBuiltinType() {
            switch (AnonymousClass1.$SwitchMap$io$github$ocelot$glslprocessor$impl$GlslLexer$TokenType[ordinal()]) {
                case 1:
                    return GlslTypeSpecifier.BuiltinType.VOID;
                case 2:
                    return GlslTypeSpecifier.BuiltinType.FLOAT;
                case 3:
                    return GlslTypeSpecifier.BuiltinType.DOUBLE;
                case 4:
                    return GlslTypeSpecifier.BuiltinType.INT;
                case 5:
                    return GlslTypeSpecifier.BuiltinType.UINT;
                case 6:
                    return GlslTypeSpecifier.BuiltinType.BOOL;
                case 7:
                    return GlslTypeSpecifier.BuiltinType.VEC2;
                case 8:
                    return GlslTypeSpecifier.BuiltinType.VEC3;
                case C0407pb.nv /* 9 */:
                    return GlslTypeSpecifier.BuiltinType.VEC4;
                case 10:
                    return GlslTypeSpecifier.BuiltinType.DVEC2;
                case AbstractC0422pq.nO /* 11 */:
                    return GlslTypeSpecifier.BuiltinType.DVEC3;
                case 12:
                    return GlslTypeSpecifier.BuiltinType.DVEC4;
                case C0407pb.nu /* 13 */:
                    return GlslTypeSpecifier.BuiltinType.BVEC2;
                case 14:
                    return GlslTypeSpecifier.BuiltinType.BVEC3;
                case 15:
                    return GlslTypeSpecifier.BuiltinType.BVEC4;
                case 16:
                    return GlslTypeSpecifier.BuiltinType.IVEC2;
                case 17:
                    return GlslTypeSpecifier.BuiltinType.IVEC3;
                case 18:
                    return GlslTypeSpecifier.BuiltinType.IVEC4;
                case 19:
                    return GlslTypeSpecifier.BuiltinType.UVEC2;
                case 20:
                    return GlslTypeSpecifier.BuiltinType.UVEC3;
                case 21:
                    return GlslTypeSpecifier.BuiltinType.UVEC4;
                case 22:
                    return GlslTypeSpecifier.BuiltinType.MAT2;
                case C0407pb.nw /* 23 */:
                    return GlslTypeSpecifier.BuiltinType.MAT3;
                case 24:
                    return GlslTypeSpecifier.BuiltinType.MAT4;
                case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                    return GlslTypeSpecifier.BuiltinType.MAT2X2;
                case 26:
                    return GlslTypeSpecifier.BuiltinType.MAT2X3;
                case 27:
                    return GlslTypeSpecifier.BuiltinType.MAT2X4;
                case pQ.nU /* 28 */:
                    return GlslTypeSpecifier.BuiltinType.MAT3X2;
                case 29:
                    return GlslTypeSpecifier.BuiltinType.MAT3X3;
                case 30:
                    return GlslTypeSpecifier.BuiltinType.MAT3X4;
                case 31:
                    return GlslTypeSpecifier.BuiltinType.MAT4X2;
                case 32:
                    return GlslTypeSpecifier.BuiltinType.MAT4X3;
                case 33:
                    return GlslTypeSpecifier.BuiltinType.MAT4X4;
                case 34:
                    return GlslTypeSpecifier.BuiltinType.DMAT2;
                case rY.qj /* 35 */:
                    return GlslTypeSpecifier.BuiltinType.DMAT3;
                case 36:
                    return GlslTypeSpecifier.BuiltinType.DMAT4;
                case sR.rf /* 37 */:
                    return GlslTypeSpecifier.BuiltinType.DMAT2X2;
                case 38:
                    return GlslTypeSpecifier.BuiltinType.DMAT2X3;
                case 39:
                    return GlslTypeSpecifier.BuiltinType.DMAT2X4;
                case 40:
                    return GlslTypeSpecifier.BuiltinType.DMAT3X2;
                case 41:
                    return GlslTypeSpecifier.BuiltinType.DMAT3X3;
                case 42:
                    return GlslTypeSpecifier.BuiltinType.DMAT3X4;
                case sR.rh /* 43 */:
                    return GlslTypeSpecifier.BuiltinType.DMAT4X2;
                case 44:
                    return GlslTypeSpecifier.BuiltinType.DMAT4X3;
                case 45:
                    return GlslTypeSpecifier.BuiltinType.DMAT4X4;
                case 46:
                    return GlslTypeSpecifier.BuiltinType.ATOMIC_UINT;
                case 47:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2D;
                case 48:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER3D;
                case 49:
                    return GlslTypeSpecifier.BuiltinType.SAMPLERCUBE;
                case 50:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DSHADOW;
                case 51:
                    return GlslTypeSpecifier.BuiltinType.SAMPLERCUBESHADOW;
                case 52:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DARRAY;
                case 53:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DARRAYSHADOW;
                case 54:
                    return GlslTypeSpecifier.BuiltinType.SAMPLERCUBEARRAY;
                case 55:
                    return GlslTypeSpecifier.BuiltinType.SAMPLERCUBEARRAYSHADOW;
                case C0093dj.ge /* 56 */:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER2D;
                case 57:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER3D;
                case 58:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLERCUBE;
                case 59:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER2DARRAY;
                case 60:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLERCUBEARRAY;
                case 61:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER2D;
                case NumericValue.FF_SIZE /* 62 */:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER3D;
                case 63:
                    return GlslTypeSpecifier.BuiltinType.USAMPLERCUBE;
                case 64:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER2DARRAY;
                case 65:
                    return GlslTypeSpecifier.BuiltinType.USAMPLERCUBEARRAY;
                case 66:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER1D;
                case 67:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER1DSHADOW;
                case 68:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER1DARRAY;
                case 69:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER1DARRAYSHADOW;
                case C0122em.hO /* 70 */:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER1D;
                case 71:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER1DARRAY;
                case 72:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER1D;
                case 73:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER1DARRAY;
                case 74:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DRECT;
                case 75:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DRECTSHADOW;
                case 76:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER2DRECT;
                case 77:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER2DRECT;
                case 78:
                    return GlslTypeSpecifier.BuiltinType.SAMPLERBUFFER;
                case 79:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLERBUFFER;
                case 80:
                    return GlslTypeSpecifier.BuiltinType.USAMPLERBUFFER;
                case 81:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DMS;
                case 82:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER2DMS;
                case 83:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER2DMS;
                case 84:
                    return GlslTypeSpecifier.BuiltinType.SAMPLER2DMSARRAY;
                case 85:
                    return GlslTypeSpecifier.BuiltinType.ISAMPLER2DMSARRAY;
                case 86:
                    return GlslTypeSpecifier.BuiltinType.USAMPLER2DMSARRAY;
                case 87:
                    return GlslTypeSpecifier.BuiltinType.IMAGE2D;
                case 88:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE2D;
                case 89:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE2D;
                case 90:
                    return GlslTypeSpecifier.BuiltinType.IMAGE3D;
                case 91:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE3D;
                case 92:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE3D;
                case 93:
                    return GlslTypeSpecifier.BuiltinType.IMAGECUBE;
                case 94:
                    return GlslTypeSpecifier.BuiltinType.IIMAGECUBE;
                case 95:
                    return GlslTypeSpecifier.BuiltinType.UIMAGECUBE;
                case 96:
                    return GlslTypeSpecifier.BuiltinType.IMAGEBUFFER;
                case 97:
                    return GlslTypeSpecifier.BuiltinType.IIMAGEBUFFER;
                case 98:
                    return GlslTypeSpecifier.BuiltinType.UIMAGEBUFFER;
                case 99:
                    return GlslTypeSpecifier.BuiltinType.IMAGE1D;
                case 100:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE1D;
                case 101:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE1D;
                case 102:
                    return GlslTypeSpecifier.BuiltinType.IMAGE1DARRAY;
                case 103:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE1DARRAY;
                case 104:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE1DARRAY;
                case 105:
                    return GlslTypeSpecifier.BuiltinType.IMAGE2DRECT;
                case 106:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE2DRECT;
                case 107:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE2DRECT;
                case 108:
                    return GlslTypeSpecifier.BuiltinType.IMAGE2DARRAY;
                case 109:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE2DARRAY;
                case C0093dj.gd /* 110 */:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE2DARRAY;
                case 111:
                    return GlslTypeSpecifier.BuiltinType.IMAGECUBEARRAY;
                case Skeleton.UNIFORM_STRIDE /* 112 */:
                    return GlslTypeSpecifier.BuiltinType.IIMAGECUBEARRAY;
                case 113:
                    return GlslTypeSpecifier.BuiltinType.UIMAGECUBEARRAY;
                case C0097dn.gs /* 114 */:
                    return GlslTypeSpecifier.BuiltinType.IMAGE2DMS;
                case 115:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE2DMS;
                case 116:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE2DMS;
                case 117:
                    return GlslTypeSpecifier.BuiltinType.IMAGE2DMSARRAY;
                case 118:
                    return GlslTypeSpecifier.BuiltinType.IIMAGE2DMSARRAY;
                case 119:
                    return GlslTypeSpecifier.BuiltinType.UIMAGE2DMSARRAY;
                default:
                    return null;
            }
        }

        @Nullable
        public GlslTypeQualifier.StorageType asStorageQualifier() {
            switch (AnonymousClass1.$SwitchMap$io$github$ocelot$glslprocessor$impl$GlslLexer$TokenType[ordinal()]) {
                case C0163g.g /* 120 */:
                    return GlslTypeQualifier.StorageType.CONST;
                case 121:
                    return GlslTypeQualifier.StorageType.IN;
                case 122:
                    return GlslTypeQualifier.StorageType.OUT;
                case 123:
                    return GlslTypeQualifier.StorageType.INOUT;
                case 124:
                    return GlslTypeQualifier.StorageType.CENTROID;
                case 125:
                    return GlslTypeQualifier.StorageType.PATCH;
                case 126:
                    return GlslTypeQualifier.StorageType.SAMPLE;
                case 127:
                    return GlslTypeQualifier.StorageType.UNIFORM;
                case 128:
                    return GlslTypeQualifier.StorageType.BUFFER;
                case 129:
                    return GlslTypeQualifier.StorageType.SHARED;
                case 130:
                    return GlslTypeQualifier.StorageType.COHERENT;
                case 131:
                    return GlslTypeQualifier.StorageType.VOLATILE;
                case 132:
                    return GlslTypeQualifier.StorageType.RESTRICT;
                case dE.gN /* 133 */:
                    return GlslTypeQualifier.StorageType.READONLY;
                case 134:
                    return GlslTypeQualifier.StorageType.WRITEONLY;
                default:
                    return null;
            }
        }

        @Nullable
        public GlslTypeQualifier.Precision asPrecisionQualifier() {
            switch (this) {
                case HIGH_PRECISION:
                    return GlslTypeQualifier.Precision.HIGH_PRECISION;
                case MEDIUM_PRECISION:
                    return GlslTypeQualifier.Precision.MEDIUM_PRECISION;
                case LOW_PRECISION:
                    return GlslTypeQualifier.Precision.LOW_PRECISION;
                default:
                    return null;
            }
        }

        @Nullable
        public GlslTypeQualifier.Interpolation asInterpolationQualifier() {
            switch (this) {
                case SMOOTH:
                    return GlslTypeQualifier.Interpolation.SMOOTH;
                case FLAT:
                    return GlslTypeQualifier.Interpolation.FLAT;
                case NOPERSPECTIVE:
                    return GlslTypeQualifier.Interpolation.NOPERSPECTIVE;
                default:
                    return null;
            }
        }

        @Nullable
        public GlslAssignmentNode.Operand asAssignmentOperator() {
            switch (this) {
                case EQUAL:
                    return GlslAssignmentNode.Operand.EQUAL;
                case MUL_ASSIGN:
                    return GlslAssignmentNode.Operand.MUL_ASSIGN;
                case DIV_ASSIGN:
                    return GlslAssignmentNode.Operand.DIV_ASSIGN;
                case MOD_ASSIGN:
                    return GlslAssignmentNode.Operand.MOD_ASSIGN;
                case ADD_ASSIGN:
                    return GlslAssignmentNode.Operand.ADD_ASSIGN;
                case SUB_ASSIGN:
                    return GlslAssignmentNode.Operand.SUB_ASSIGN;
                case LEFT_ASSIGN:
                    return GlslAssignmentNode.Operand.LEFT_ASSIGN;
                case RIGHT_ASSIGN:
                    return GlslAssignmentNode.Operand.RIGHT_ASSIGN;
                case AND_ASSIGN:
                    return GlslAssignmentNode.Operand.AND_ASSIGN;
                case XOR_ASSIGN:
                    return GlslAssignmentNode.Operand.XOR_ASSIGN;
                case OR_ASSIGN:
                    return GlslAssignmentNode.Operand.OR_ASSIGN;
                default:
                    return null;
            }
        }

        @Nullable
        public GlslUnaryNode.Operand asUnaryOperator() {
            switch (this) {
                case PLUS:
                    return GlslUnaryNode.Operand.PLUS;
                case DASH:
                    return GlslUnaryNode.Operand.DASH;
                case BANG:
                    return GlslUnaryNode.Operand.BANG;
                case TILDE:
                    return GlslUnaryNode.Operand.TILDE;
                default:
                    return null;
            }
        }
    }
}
