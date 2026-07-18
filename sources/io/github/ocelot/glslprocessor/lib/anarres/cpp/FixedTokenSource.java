package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/FixedTokenSource.class */
@ApiStatus.Internal
class FixedTokenSource extends Source {
    private static final Token EOF = new Token(Token.EOF, "<ts-eof>");
    private final List<Token> tokens;
    private int idx = 0;

    FixedTokenSource(Token... tokens) {
        this.tokens = Arrays.asList(tokens);
    }

    FixedTokenSource(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
    public Token token() throws LexerException {
        if (this.idx >= this.tokens.size()) {
            return EOF;
        }
        List<Token> list = this.tokens;
        int i = this.idx;
        this.idx = i + 1;
        return list.get(i);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("constant token stream ").append(this.tokens);
        Source parent = getParent();
        if (parent != null) {
            buf.append(" in ").append(parent);
        }
        return buf.toString();
    }
}
