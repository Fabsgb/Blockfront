package gg.moonflower.molangcompiler.core.compiler;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/TokenReader.class */
@ApiStatus.Internal
public class TokenReader extends StringReader {
    private final MolangLexer.Token[] tokens;

    public TokenReader(MolangLexer.Token[] tokens) {
        super("");
        this.tokens = tokens;
    }

    @Override // gg.moonflower.molangcompiler.core.compiler.StringReader
    public String getString() {
        StringBuilder builder = new StringBuilder();
        for (MolangLexer.Token token : this.tokens) {
            builder.append(token.value());
        }
        return builder.toString();
    }

    @Override // gg.moonflower.molangcompiler.core.compiler.StringReader
    public boolean canRead(int length) {
        return this.cursor + length <= this.tokens.length;
    }

    public int getCursorOffset() {
        int offset = 0;
        for (int i = 0; i <= Math.min(this.cursor, this.tokens.length - 1); i++) {
            offset += this.tokens[i].value().length();
        }
        return offset;
    }

    public MolangLexer.Token peekAfter(int amount) {
        return this.tokens[this.cursor + amount];
    }

    public MolangLexer.Token peek() {
        return this.tokens[this.cursor];
    }
}
