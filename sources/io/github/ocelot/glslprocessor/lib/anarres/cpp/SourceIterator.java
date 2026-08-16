package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/SourceIterator.class */
@ApiStatus.Internal
public class SourceIterator implements Iterator<Token> {
    private final Source source;
    private Token tok = null;

    public SourceIterator(@NotNull Source s) {
        this.source = s;
    }

    private void advance() {
        try {
            if (this.tok == null) {
                this.tok = this.source.token();
            }
        } catch (LexerException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        advance();
        return this.tok.getType() != 265;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Token next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Token t = this.tok;
        this.tok = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
