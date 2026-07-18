package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import com.boehmod.blockfront.C0862pb;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/MacroTokenSource.class */
@ApiStatus.Internal
class MacroTokenSource extends Source {
    private final Macro macro;
    private final Iterator<Token> tokens;
    private final List<Argument> args;
    private Iterator<Token> arg = null;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !MacroTokenSource.class.desiredAssertionStatus();
    }

    MacroTokenSource(@NotNull Macro m, @NotNull List<Argument> args) {
        this.macro = m;
        this.tokens = m.getTokens().iterator();
        this.args = args;
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    boolean isExpanding(@NotNull Macro m) {
        if (this.macro == m) {
            return true;
        }
        return super.isExpanding(m);
    }

    static void escape(@NotNull StringBuilder buf, @NotNull CharSequence cs) {
        for (int i = 0; i < cs.length(); i++) {
            char c = cs.charAt(i);
            switch (c) {
                case '\n':
                    buf.append("\\n");
                    break;
                case C0862pb.f4508nu /* 13 */:
                    buf.append("\\r");
                    break;
                case '\"':
                    buf.append("\\\"");
                    break;
                case '\\':
                    buf.append("\\\\");
                    break;
                default:
                    buf.append(c);
                    break;
            }
        }
    }

    private void concat(@NotNull StringBuilder buf, @NotNull Argument arg) {
        for (Token tok : arg) {
            buf.append(tok.getText());
        }
    }

    @NotNull
    private Token stringify(@NotNull Token pos, @NotNull Argument arg) {
        StringBuilder buf = new StringBuilder();
        concat(buf, arg);
        StringBuilder str = new StringBuilder("\"");
        escape(str, buf);
        str.append("\"");
        return new Token(Token.STRING, pos.getLine(), pos.getColumn(), str.toString(), buf.toString());
    }

    private boolean isVariadicArgument(int argumentIndex) {
        return this.macro.isVariadic() && argumentIndex == this.args.size() - 1;
    }

    private void paste(@NotNull Token ptok) throws LexerException {
        StringBuilder buf = new StringBuilder();
        int count = 2;
        boolean comma = false;
        int i = 0;
        while (true) {
            if (i < count) {
                if (!this.tokens.hasNext()) {
                    error(ptok.getLine(), ptok.getColumn(), "Paste at end of expansion");
                    buf.append(' ').append(ptok.getText());
                } else {
                    Token tok = this.tokens.next();
                    switch (tok.getType()) {
                        case 44:
                            comma = true;
                            buf.append(tok.getText());
                            continue;
                            i++;
                            break;
                        case Token.CCOMMENT /* 260 */:
                        case Token.CPPCOMMENT /* 261 */:
                            break;
                        case Token.M_ARG /* 296 */:
                            int idx = ((Integer) tok.getValue()).intValue();
                            Argument arg = this.args.get(idx);
                            if (comma && isVariadicArgument(idx) && arg.isEmpty()) {
                                buf.setLength(buf.length() - 1);
                            } else {
                                concat(buf, arg);
                            }
                            break;
                        case Token.M_PASTE /* 297 */:
                            count += 2;
                            ptok = tok;
                            break;
                        default:
                            buf.append(tok.getText());
                            break;
                    }
                    comma = false;
                    i++;
                }
            }
        }
        StringLexerSource sl = new StringLexerSource(buf.toString());
        this.arg = new SourceIterator(sl);
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    public Token token() throws LexerException {
        while (true) {
            if (this.arg != null) {
                if (this.arg.hasNext()) {
                    Token tok = this.arg.next();
                    if ($assertionsDisabled || tok.getType() != 297) {
                        return tok;
                    }
                    throw new AssertionError("Unexpected paste token");
                }
                this.arg = null;
            }
            if (!this.tokens.hasNext()) {
                return new Token(Token.EOF, -1, -1, "");
            }
            Token tok2 = this.tokens.next();
            switch (tok2.getType()) {
                case Token.M_ARG /* 296 */:
                    int idx = ((Integer) tok2.getValue()).intValue();
                    this.arg = this.args.get(idx).expansion();
                    break;
                case Token.M_PASTE /* 297 */:
                    paste(tok2);
                    break;
                case Token.M_STRING /* 298 */:
                    int idx2 = ((Integer) tok2.getValue()).intValue();
                    return stringify(tok2, this.args.get(idx2));
                default:
                    return tok2;
            }
        }
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("expansion of ").append(this.macro.getName());
        Source parent = getParent();
        if (parent != null) {
            buf.append(" in ").append(parent);
        }
        return buf.toString();
    }
}
