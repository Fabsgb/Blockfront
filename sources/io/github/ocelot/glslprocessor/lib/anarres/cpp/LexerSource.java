package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import com.boehmod.blockfront.AbstractC0877pq;
import com.boehmod.blockfront.C0203dE;
import com.boehmod.blockfront.C0234dj;
import com.boehmod.blockfront.C0238dn;
import com.boehmod.blockfront.C0357g;
import com.boehmod.blockfront.C0862pb;
import com.boehmod.blockfront.C0965rY;
import com.boehmod.blockfront.C1011sR;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/LexerSource.class */
@ApiStatus.Internal
public class LexerSource extends Source {
    private final JoinReader reader;
    private final boolean ppvalid;

    /* JADX INFO: renamed from: u0 */
    private int f8800u0;

    /* JADX INFO: renamed from: u1 */
    private int f8801u1;
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean bol = true;
    private boolean include = false;
    private boolean digraphs = true;
    private int ucount = 0;
    private int line = 1;
    private int column = 0;
    private int lastcolumn = -1;

    /* JADX INFO: renamed from: cr */
    private boolean f8802cr = false;

    static {
        $assertionsDisabled = !LexerSource.class.desiredAssertionStatus();
    }

    public LexerSource(String input, boolean ppvalid) {
        this.reader = new JoinReader(input);
        this.ppvalid = ppvalid;
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    void init(Preprocessor pp) {
        super.init(pp);
        this.digraphs = pp.getFeature(Feature.DIGRAPHS);
        this.reader.init(pp, this);
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    public int getLine() {
        return this.line;
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    public int getColumn() {
        return this.column;
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    boolean isNumbered() {
        return true;
    }

    private void _error(String msg) throws LexerException {
        int _c;
        int _l = this.line;
        int _c2 = this.column;
        if (_c2 == 0) {
            _c = this.lastcolumn;
            _l--;
        } else {
            _c = _c2 - 1;
        }
        super.warning(_l, _c, msg);
    }

    final void warning(String msg) throws LexerException {
        _error(msg);
    }

    void setInclude(boolean b) {
        this.include = b;
    }

    private static boolean isLineSeparator(int c) {
        switch ((char) c) {
            case '\n':
            case AbstractC0877pq.f4599nO /* 11 */:
            case '\f':
            case C0862pb.f4508nu /* 13 */:
            case C0203dE.f1640gN /* 133 */:
            case 8232:
            case 8233:
                return true;
            default:
                return c == -1;
        }
    }

    private int read() throws LexerException {
        int i;
        if (!$assertionsDisabled && this.ucount > 2) {
            throw new AssertionError("Illegal ucount: " + this.ucount);
        }
        switch (this.ucount) {
            case 1:
                this.ucount = 0;
                i = this.f8800u0;
                break;
            case 2:
                this.ucount = 1;
                i = this.f8801u1;
                break;
            default:
                i = this.reader.read();
                break;
        }
        int c = i;
        switch (c) {
            case -1:
                this.f8802cr = false;
                break;
            case 10:
                if (this.f8802cr) {
                    this.f8802cr = false;
                    break;
                }
            case AbstractC0877pq.f4599nO /* 11 */:
            case 12:
            case C0203dE.f1640gN /* 133 */:
            case 8232:
            case 8233:
                this.f8802cr = false;
                this.line++;
                this.lastcolumn = this.column;
                this.column = 0;
                break;
            case C0862pb.f4508nu /* 13 */:
                this.f8802cr = true;
                this.line++;
                this.lastcolumn = this.column;
                this.column = 0;
                break;
            default:
                this.f8802cr = false;
                this.column++;
                break;
        }
        return c;
    }

    private void unread(int c) {
        if (c != -1) {
            if (isLineSeparator(c)) {
                this.line--;
                this.column = this.lastcolumn;
                this.f8802cr = false;
            } else {
                this.column--;
            }
            switch (this.ucount) {
                case 0:
                    this.f8800u0 = c;
                    this.ucount = 1;
                    return;
                case 1:
                    this.f8801u1 = c;
                    this.ucount = 2;
                    return;
                default:
                    throw new IllegalStateException("Cannot unget another character!");
            }
        }
    }

    @NotNull
    private Token ccomment() throws LexerException {
        int d;
        StringBuilder text = new StringBuilder("/*");
        while (true) {
            int d2 = read();
            if (d2 == -1) {
                return new Token(300, text.toString(), "Unterminated comment");
            }
            text.append((char) d2);
            if (d2 == 42) {
                do {
                    d = read();
                    if (d == -1) {
                        return new Token(300, text.toString(), "Unterminated comment");
                    }
                    text.append((char) d);
                } while (d == 42);
                if (d == 47) {
                    return new Token(Token.CCOMMENT, text.toString());
                }
            }
        }
    }

    @NotNull
    private Token cppcomment() throws LexerException {
        StringBuilder text = new StringBuilder("//");
        int i = read();
        while (true) {
            int d = i;
            if (!isLineSeparator(d)) {
                text.append((char) d);
                i = read();
            } else {
                unread(d);
                return new Token(Token.CPPCOMMENT, text.toString());
            }
        }
    }

    private int escape(StringBuilder text) throws LexerException {
        int d = read();
        switch (d) {
            case 34:
                text.append('\"');
                return 34;
            case 39:
                text.append('\'');
                return 39;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                int len = 0;
                int val = 0;
                do {
                    val = (val << 3) + Character.digit(d, 8);
                    text.append((char) d);
                    d = read();
                    len++;
                    if (len < 3) {
                    }
                    unread(d);
                    return val;
                } while (Character.digit(d, 8) != -1);
                unread(d);
                return val;
            case 92:
                text.append('\\');
                return 92;
            case 97:
                text.append('a');
                return 7;
            case 98:
                text.append('b');
                return 8;
            case 102:
                text.append('f');
                return 12;
            case C0234dj.f1919gd /* 110 */:
                text.append('n');
                return 10;
            case C0238dn.f1978gs /* 114 */:
                text.append('r');
                return 13;
            case 116:
                text.append('t');
                return 9;
            case 118:
                text.append('v');
                return 11;
            case C0357g.f2439g /* 120 */:
                text.append((char) d);
                int len2 = 0;
                int val2 = 0;
                while (true) {
                    int i = len2;
                    len2++;
                    if (i < 2) {
                        int d2 = read();
                        if (Character.digit(d2, 16) == -1) {
                            unread(d2);
                        } else {
                            val2 = (val2 << 4) + Character.digit(d2, 16);
                            text.append((char) d2);
                        }
                    }
                }
                return val2;
            default:
                warning("Unnecessary escape character " + ((char) d));
                text.append((char) d);
                return d;
        }
    }

    @NotNull
    private Token string(char open, char close) throws LexerException {
        StringBuilder text = new StringBuilder();
        text.append(open);
        StringBuilder buf = new StringBuilder();
        while (true) {
            int c = read();
            if (c != close) {
                if (c == 92) {
                    text.append('\\');
                    if (!this.include) {
                        char d = (char) escape(text);
                        buf.append(d);
                    }
                } else {
                    if (c == -1) {
                        unread(c);
                        return new Token(300, text.toString(), "End of file in string literal after " + buf);
                    }
                    if (isLineSeparator(c)) {
                        unread(c);
                        return new Token(300, text.toString(), "Unterminated string literal after " + buf);
                    }
                    text.append((char) c);
                    buf.append((char) c);
                }
            } else {
                text.append(close);
                switch (close) {
                    case '\"':
                        return new Token(Token.STRING, text.toString(), buf.toString());
                    case '\'':
                        if (buf.length() == 1) {
                            return new Token(Token.CHARACTER, text.toString(), buf.toString());
                        }
                        return new Token(Token.SQSTRING, text.toString(), buf.toString());
                    case NumericValue.FF_SIZE /* 62 */:
                        return new Token(Token.HEADER, text.toString(), buf.toString());
                    default:
                        throw new IllegalStateException("Unknown closing character " + close);
                }
            }
        }
    }

    @NotNull
    private Token _number_suffix(StringBuilder text, NumericValue value, int d) throws LexerException {
        int flags = 0;
        while (true) {
            if (d == 85 || d == 117) {
                if ((flags & 1) != 0) {
                    warning("Duplicate unsigned suffix " + d);
                }
                flags |= 1;
                text.append((char) d);
                d = read();
            } else if (d != 76 && d != 108) {
                if (d == 73 || d == 105) {
                    if ((flags & 62) != 0) {
                        warning("Multiple length suffixes after " + text);
                    }
                    flags |= 2;
                    text.append((char) d);
                    d = read();
                } else if (d == 70 || d == 102) {
                    if ((flags & 62) != 0) {
                        warning("Multiple length suffixes after " + text);
                    }
                    flags |= 16;
                    text.append((char) d);
                    d = read();
                } else {
                    if (d != 68 && d != 100) {
                        break;
                    }
                    if ((flags & 62) != 0) {
                        warning("Multiple length suffixes after " + text);
                    }
                    flags |= 32;
                    text.append((char) d);
                    d = read();
                }
            } else {
                if ((flags & 62) != 0) {
                    warning("Multiple length suffixes after " + text);
                }
                text.append((char) d);
                int e = read();
                if (e == d) {
                    flags |= 8;
                    text.append((char) e);
                    d = read();
                } else {
                    flags |= 4;
                    d = e;
                }
            }
        }
        if (Character.isUnicodeIdentifierPart(d)) {
            String reason = "Invalid suffix \"" + ((char) d) + "\" on numeric constant";
            while (Character.isUnicodeIdentifierPart(d)) {
                text.append((char) d);
                d = read();
            }
            unread(d);
            return new Token(300, text.toString(), reason);
        }
        unread(d);
        return new Token(Token.NUMBER, text.toString(), value);
    }

    @NotNull
    private String _number_part(StringBuilder text, int base, boolean sign) throws LexerException {
        StringBuilder part = new StringBuilder();
        int d = read();
        if (sign && (d == 43 || d == 45)) {
            text.append((char) d);
            part.append((char) d);
            d = read();
        }
        while (Character.digit(d, base) != -1) {
            text.append((char) d);
            part.append((char) d);
            d = read();
        }
        unread(d);
        return part.toString();
    }

    @NotNull
    private Token number_hex(char x) throws LexerException {
        StringBuilder text = new StringBuilder("0");
        text.append(x);
        String integer = _number_part(text, 16, false);
        NumericValue value = new NumericValue(16, integer);
        int d = read();
        if (d == 46) {
            text.append((char) d);
            String fraction = _number_part(text, 16, false);
            value.setFractionalPart(fraction);
            d = read();
        }
        if (d == 80 || d == 112) {
            text.append((char) d);
            String exponent = _number_part(text, 10, true);
            value.setExponent(2, exponent);
            d = read();
        }
        return _number_suffix(text, value, d);
    }

    private static boolean is_octal(@NotNull String text) {
        if (!text.startsWith("0")) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            if (Character.digit(text.charAt(i), 8) == -1) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    private Token number_decimal() throws LexerException {
        StringBuilder text = new StringBuilder();
        String integer = _number_part(text, 10, false);
        String fraction = null;
        String exponent = null;
        int d = read();
        if (d == 46) {
            text.append((char) d);
            fraction = _number_part(text, 10, false);
            d = read();
        }
        if (d == 69 || d == 101) {
            text.append((char) d);
            exponent = _number_part(text, 10, true);
            d = read();
        }
        int base = 10;
        if (fraction == null && exponent == null && integer.startsWith("0")) {
            if (!is_octal(integer)) {
                warning("Decimal constant starts with 0, but not octal: " + integer);
            } else {
                base = 8;
            }
        }
        NumericValue value = new NumericValue(base, integer);
        if (fraction != null) {
            value.setFractionalPart(fraction);
        }
        if (exponent != null) {
            value.setExponent(10, exponent);
        }
        return _number_suffix(text, value, d);
    }

    @NotNull
    private Token number() throws LexerException {
        Token tok;
        int c = read();
        if (c == 48) {
            int d = read();
            if (d == 120 || d == 88) {
                tok = number_hex((char) d);
            } else {
                unread(d);
                unread(c);
                tok = number_decimal();
            }
        } else if (Character.isDigit(c) || c == 46) {
            unread(c);
            tok = number_decimal();
        } else {
            throw new LexerException("Asked to parse something as a number which isn't: " + ((char) c));
        }
        return tok;
    }

    @NotNull
    private Token identifier(int c) throws LexerException {
        StringBuilder text = new StringBuilder();
        text.append((char) c);
        while (true) {
            int d = read();
            if (!Character.isIdentifierIgnorable(d)) {
                if (Character.isJavaIdentifierPart(d)) {
                    text.append((char) d);
                } else {
                    unread(d);
                    return new Token(Token.IDENTIFIER, text.toString());
                }
            }
        }
    }

    @NotNull
    private Token whitespace(int c) throws LexerException {
        int d;
        StringBuilder text = new StringBuilder();
        text.append((char) c);
        while (true) {
            d = read();
            if ((this.ppvalid && isLineSeparator(d)) || !Character.isWhitespace(d)) {
                break;
            }
            text.append((char) d);
        }
        unread(d);
        return new Token(Token.WHITESPACE, text.toString());
    }

    @NotNull
    private Token cond(char c, int yes, int no) throws LexerException {
        int d = read();
        if (c == d) {
            return new Token(yes);
        }
        unread(d);
        return new Token(no);
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    public Token token() throws LexerException {
        int d;
        Token tok;
        Token tok2 = null;
        int _l = this.line;
        int _c = this.column;
        int c = read();
        switch (c) {
            case -1:
                tok2 = new Token(Token.EOF, _l, _c, "<eof>");
                break;
            case 10:
                if (this.ppvalid) {
                    this.bol = true;
                    if (this.include) {
                        tok = new Token(Token.f8808NL, _l, _c, "\n");
                    } else {
                        int nls = 0;
                        do {
                            nls++;
                            d = read();
                        } while (d == 10);
                        unread(d);
                        char[] text = new char[nls];
                        Arrays.fill(text, '\n');
                        tok = new Token(Token.f8808NL, _l, _c, new String(text));
                    }
                    return tok;
                }
                break;
            case 33:
                tok2 = cond('=', Token.f8807NE, 33);
                break;
            case 34:
                tok2 = string('\"', '\"');
                break;
            case C0965rY.f5110qj /* 35 */:
                tok2 = this.bol ? new Token(Token.HASH) : cond('#', Token.PASTE, 35);
                break;
            case C1011sR.f5290rf /* 37 */:
                int d2 = read();
                if (d2 == 61) {
                    tok2 = new Token(Token.MOD_EQ);
                } else if (this.digraphs && d2 == 62) {
                    tok2 = new Token(125);
                } else if (this.digraphs && d2 == 58) {
                    int d3 = read();
                    if (d3 != 37) {
                        unread(d3);
                        tok2 = new Token(35);
                    } else {
                        int d4 = read();
                        if (d4 != 58) {
                            unread(d4);
                            unread(37);
                            tok2 = new Token(35);
                        } else {
                            tok2 = new Token(Token.PASTE);
                        }
                    }
                } else {
                    unread(d2);
                }
                break;
            case 38:
                int d5 = read();
                if (d5 == 38) {
                    tok2 = cond('=', Token.LAND_EQ, Token.LAND);
                } else if (d5 == 61) {
                    tok2 = new Token(Token.AND_EQ);
                } else {
                    unread(d5);
                }
                break;
            case 39:
                tok2 = string('\'', '\'');
                break;
            case 42:
                tok2 = cond('=', Token.MULT_EQ, 42);
                break;
            case C1011sR.f5292rh /* 43 */:
                int d6 = read();
                if (d6 == 43) {
                    tok2 = new Token(Token.INC);
                } else if (d6 == 61) {
                    tok2 = new Token(Token.PLUS_EQ);
                } else {
                    unread(d6);
                }
                break;
            case 45:
                int d7 = read();
                if (d7 == 45) {
                    tok2 = new Token(Token.DEC);
                } else if (d7 == 61) {
                    tok2 = new Token(Token.SUB_EQ);
                } else if (d7 == 62) {
                    tok2 = new Token(Token.ARROW);
                } else {
                    unread(d7);
                }
                break;
            case 46:
                int d8 = read();
                if (d8 == 46) {
                    tok2 = cond('.', Token.ELLIPSIS, Token.RANGE);
                } else {
                    unread(d8);
                }
                if (Character.isDigit(d8)) {
                    unread(46);
                    tok2 = number();
                }
                break;
            case 47:
                int d9 = read();
                if (d9 == 42) {
                    tok2 = ccomment();
                } else if (d9 == 47) {
                    tok2 = cppcomment();
                } else if (d9 == 61) {
                    tok2 = new Token(Token.DIV_EQ);
                } else {
                    unread(d9);
                }
                break;
            case 58:
                int d10 = read();
                if (this.digraphs && d10 == 62) {
                    tok2 = new Token(93);
                } else {
                    unread(d10);
                }
                break;
            case 60:
                if (this.include) {
                    tok2 = string('<', '>');
                } else {
                    int d11 = read();
                    if (d11 == 61) {
                        tok2 = new Token(Token.f8806LE);
                    } else if (d11 == 60) {
                        tok2 = cond('=', Token.LSH_EQ, Token.LSH);
                    } else if (this.digraphs && d11 == 58) {
                        tok2 = new Token(91);
                    } else if (this.digraphs && d11 == 37) {
                        tok2 = new Token(123);
                    } else {
                        unread(d11);
                    }
                }
                break;
            case 61:
                tok2 = cond('=', Token.f8804EQ, 61);
                break;
            case NumericValue.FF_SIZE /* 62 */:
                int d12 = read();
                if (d12 == 61) {
                    tok2 = new Token(Token.f8805GE);
                } else if (d12 == 62) {
                    tok2 = cond('=', Token.RSH_EQ, Token.RSH);
                } else {
                    unread(d12);
                }
                break;
            case 94:
                tok2 = cond('=', Token.XOR_EQ, 94);
                break;
            case 124:
                int d13 = read();
                if (d13 == 61) {
                    tok2 = new Token(Token.OR_EQ);
                } else if (d13 == 124) {
                    tok2 = cond('=', Token.LOR_EQ, Token.LOR);
                } else {
                    unread(d13);
                }
                break;
        }
        if (tok2 == null) {
            if (Character.isWhitespace(c)) {
                tok2 = whitespace(c);
            } else if (Character.isDigit(c)) {
                unread(c);
                tok2 = number();
            } else if (Character.isJavaIdentifierStart(c)) {
                tok2 = identifier(c);
            } else {
                String text2 = TokenType.getTokenText(c);
                if (text2 == null) {
                    if ((c >>> 16) == 0) {
                        text2 = Character.toString((char) c);
                    } else {
                        text2 = new String(Character.toChars(c));
                    }
                }
                tok2 = new Token(c, text2);
            }
        }
        if (this.bol) {
            switch (tok2.getType()) {
                case Token.CCOMMENT /* 260 */:
                case Token.WHITESPACE /* 294 */:
                    break;
                default:
                    this.bol = false;
                    break;
            }
        }
        tok2.setLocation(_l, _c);
        return tok2;
    }
}
