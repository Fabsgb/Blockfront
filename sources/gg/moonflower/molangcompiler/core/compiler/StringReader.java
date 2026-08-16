package gg.moonflower.molangcompiler.core.compiler;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/StringReader.class */
@ApiStatus.Internal
public class StringReader {
    private final String string;
    protected int cursor;

    public StringReader(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    public int getCursor() {
        return this.cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public boolean canRead(int length) {
        return this.cursor + length <= this.string.length();
    }

    public boolean canRead() {
        return canRead(1);
    }

    public void skip(int amount) {
        this.cursor += amount;
    }

    public void skip() {
        this.cursor++;
    }

    public void skipWhitespace() {
        while (canRead() && Character.isWhitespace(this.string.charAt(this.cursor))) {
            skip();
        }
    }
}
