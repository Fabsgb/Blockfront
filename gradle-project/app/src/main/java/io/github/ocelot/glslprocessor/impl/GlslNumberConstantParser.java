package io.github.ocelot.glslprocessor.impl;

import java.util.Objects;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslNumberConstantParser.class */
@ApiStatus.Internal
class GlslNumberConstantParser {
    private GlslNumberConstantParser() {
    }

    @Nullable
    public static GlslLexer.Token parseNumberConstant(GlslStringReader reader) {
        if (!reader.canRead()) {
            return null;
        }
        GlslLexer.Token floatingConstant = parseFloatingConstant(reader);
        if (floatingConstant != null) {
            return floatingConstant;
        }
        return parseIntegerConstant(reader);
    }

    @Nullable
    private static GlslLexer.Token parseFloatingConstant(GlslStringReader reader) {
        String exponent;
        StringBuilder fractionalConstant = parseFractionalConstant(reader);
        if (fractionalConstant != null) {
            String exponent2 = parseExponentPart(reader);
            if (exponent2 != null) {
                fractionalConstant.append(exponent2);
            }
            GlslLexer.TokenType type = getFloatingType(reader);
            return new GlslLexer.Token(type, fractionalConstant.toString());
        }
        int cursor = reader.cursor;
        StringBuilder sequence = parseDigitSequence(reader);
        if (sequence != null && (exponent = parseExponentPart(reader)) != null) {
            sequence.append(exponent);
            GlslLexer.TokenType type2 = getFloatingType(reader);
            return new GlslLexer.Token(type2, sequence.toString());
        }
        reader.cursor = cursor;
        return null;
    }

    @Nullable
    private static StringBuilder parseFractionalConstant(GlslStringReader reader) {
        int cursor = reader.cursor;
        StringBuilder first = parseDigitSequence(reader);
        if (reader.chars[reader.cursor] != '.') {
            reader.cursor = cursor;
            return null;
        }
        reader.skip();
        StringBuilder second = parseDigitSequence(reader);
        if (first != null) {
            first.append('.');
            if (second != null) {
                first.append((CharSequence) second);
            }
            return first;
        }
        if (second == null) {
            return null;
        }
        return new StringBuilder(".").append((CharSequence) second);
    }

    @Nullable
    private static StringBuilder parseDigitSequence(GlslStringReader reader) {
        int i = reader.cursor;
        char[] chars = reader.chars;
        StringBuilder sequence = new StringBuilder();
        while (i < chars.length && (Character.isDigit(chars[i]) || Character.isWhitespace(chars[i]))) {
            if (!Character.isWhitespace(chars[i])) {
                sequence.append(chars[i]);
            }
            i++;
        }
        if (sequence.isEmpty()) {
            return null;
        }
        reader.skip(i - reader.cursor);
        return sequence;
    }

    @Nullable
    private static String parseExponentPart(GlslStringReader reader) {
        int cursor = reader.cursor;
        char[] chars = reader.chars;
        if (chars[cursor] != 'e' && chars[cursor] != 'E') {
            return null;
        }
        reader.skip();
        if (!reader.canRead()) {
            return null;
        }
        char sign = chars[cursor + 1];
        if (sign == '+' || sign == '-') {
            reader.skip();
            StringBuilder digitSequence = parseDigitSequence(reader);
            if (digitSequence == null) {
                reader.cursor = cursor;
                return null;
            }
            return "e" + sign + digitSequence;
        }
        StringBuilder digitSequence2 = parseDigitSequence(reader);
        if (digitSequence2 == null) {
            reader.cursor = cursor;
            return null;
        }
        return "e" + digitSequence2;
    }

    private static GlslLexer.TokenType getFloatingType(GlslStringReader reader) {
        if (!reader.canRead()) {
            return GlslLexer.TokenType.FLOATING_CONSTANT;
        }
        char[] chars = reader.chars;
        char first = chars[reader.cursor];
        if (first == 'f' || first == 'F') {
            reader.skip();
            return GlslLexer.TokenType.FLOATING_CONSTANT;
        }
        if (reader.cursor + 1 >= chars.length) {
            return GlslLexer.TokenType.FLOATING_CONSTANT;
        }
        char second = chars[reader.cursor + 1];
        if ((first == 'l' && second == 'f') || (first == 'L' && second == 'F')) {
            reader.skip(2);
            return GlslLexer.TokenType.DOUBLE_CONSTANT;
        }
        return GlslLexer.TokenType.FLOATING_CONSTANT;
    }

    @Nullable
    private static GlslLexer.Token parseIntegerConstant(GlslStringReader reader) {
        char[] chars = reader.chars;
        int cursor = reader.cursor;
        StringBuilder numberBuilder = new StringBuilder();
        GlslLexer.TokenType type = null;
        if (chars[cursor] >= '1' && chars[cursor] <= '9') {
            type = GlslLexer.TokenType.INTEGER_DECIMAL_CONSTANT;
            numberBuilder.append(chars[cursor]);
            reader.skip();
            consumeDigits(reader, numberBuilder, '9');
        } else if (chars[cursor] == '0') {
            reader.skip();
            if (cursor + 1 < chars.length && (chars[cursor + 1] == 'x' || chars[cursor + 1] == 'X')) {
                type = GlslLexer.TokenType.INTEGER_HEXADECIMAL_CONSTANT;
                reader.skip();
                int cursor2 = reader.cursor;
                while (true) {
                    if ((cursor2 >= chars.length || chars[cursor2] < '0' || chars[cursor2] > '9') && ((chars[cursor2] < 'a' || chars[cursor2] > 'f') && (chars[cursor2] < 'A' || chars[cursor2] > 'F'))) {
                        break;
                    }
                    if (!Character.isWhitespace(chars[cursor2])) {
                        numberBuilder.append(chars[cursor2]);
                    }
                    cursor2++;
                }
                reader.cursor = cursor2;
            } else {
                type = GlslLexer.TokenType.INTEGER_OCTAL_CONSTANT;
                numberBuilder.append('0');
                consumeDigits(reader, numberBuilder, '7');
            }
        }
        if (numberBuilder.isEmpty()) {
            return null;
        }
        if (reader.canRead() && (chars[reader.cursor] == 'u' || chars[reader.cursor] == 'U')) {
            switch ((GlslLexer.TokenType) Objects.requireNonNull(type)) {
                case INTEGER_HEXADECIMAL_CONSTANT:
                    type = GlslLexer.TokenType.UINTEGER_HEXADECIMAL_CONSTANT;
                    break;
                case INTEGER_OCTAL_CONSTANT:
                    type = GlslLexer.TokenType.UINTEGER_OCTAL_CONSTANT;
                    break;
                case INTEGER_DECIMAL_CONSTANT:
                    type = GlslLexer.TokenType.UINTEGER_DECIMAL_CONSTANT;
                    break;
            }
            reader.skip();
        }
        return new GlslLexer.Token(type, numberBuilder.toString());
    }

    private static void consumeDigits(GlslStringReader reader, StringBuilder builder, char end) {
        char[] chars = reader.chars;
        int cursor = reader.cursor;
        while (cursor < chars.length && chars[cursor] >= '0' && chars[cursor] <= end) {
            builder.append(chars[cursor]);
            cursor++;
        }
        reader.cursor = cursor;
    }
}
