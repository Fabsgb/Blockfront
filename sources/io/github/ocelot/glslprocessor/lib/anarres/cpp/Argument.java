package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/Argument.class */
@ApiStatus.Internal
class Argument extends ArrayList<Token> {
    private List<Token> expansion = null;

    public void addToken(@NotNull Token tok) {
        add(tok);
    }

    void expand(@NotNull Preprocessor p) throws IOException, LexerException {
        if (this.expansion == null) {
            this.expansion = p.expand(this);
        }
    }

    @NotNull
    public Iterator<Token> expansion() {
        return this.expansion.iterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("Argument(");
        buf.append("raw=[ ");
        for (Token value : this) {
            buf.append(value.getText());
        }
        buf.append(" ];expansion=[ ");
        if (this.expansion == null) {
            buf.append("null");
        } else {
            for (Token token : this.expansion) {
                buf.append(token.getText());
            }
        }
        buf.append(" ])");
        return buf.toString();
    }
}
