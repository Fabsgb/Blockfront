package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/Source.class */
@ApiStatus.Internal
public abstract class Source {
    private Source parent = null;
    private boolean autopop = false;
    private boolean werror = false;

    public abstract Token token() throws LexerException;

    void setParent(Source parent, boolean autopop) {
        this.parent = parent;
        this.autopop = autopop;
    }

    final Source getParent() {
        return this.parent;
    }

    void init(Preprocessor pp) {
        this.werror = pp.getWarnings().contains(Warning.ERROR);
    }

    @Nullable
    public String getName() {
        Source parent = getParent();
        if (parent != null) {
            return parent.getName();
        }
        return null;
    }

    public int getLine() {
        Source parent = getParent();
        if (parent == null) {
            return 0;
        }
        return parent.getLine();
    }

    public int getColumn() {
        Source parent = getParent();
        if (parent == null) {
            return 0;
        }
        return parent.getColumn();
    }

    boolean isExpanding(@NotNull Macro m) {
        Source parent = getParent();
        if (parent != null) {
            return parent.isExpanding(m);
        }
        return false;
    }

    boolean isAutopop() {
        return this.autopop;
    }

    boolean isNumbered() {
        return false;
    }

    public Token skipline(boolean white) throws LexerException {
        while (true) {
            Token tok = token();
            switch (tok.getType()) {
                case Token.CCOMMENT /* 260 */:
                case Token.CPPCOMMENT /* 261 */:
                case Token.WHITESPACE /* 294 */:
                    break;
                case Token.EOF /* 265 */:
                    warning(tok.getLine(), tok.getColumn(), "No newline before end of file");
                    return new Token(Token.NL, tok.getLine(), tok.getColumn(), "\n");
                case Token.NL /* 284 */:
                    return tok;
                default:
                    if (white) {
                        warning(tok.getLine(), tok.getColumn(), "Unexpected nonwhite token");
                    }
                    break;
            }
        }
    }

    protected void error(int line, int column, String msg) throws LexerException {
        throw new LexerException("Error at " + line + ":" + column + ": " + msg);
    }

    protected void warning(int line, int column, String msg) throws LexerException {
        if (this.werror) {
            error(line, column, msg);
            return;
        }
        throw new LexerException("Warning at " + line + ":" + column + ": " + msg);
    }
}
