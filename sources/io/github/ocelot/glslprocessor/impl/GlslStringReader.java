package io.github.ocelot.glslprocessor.impl;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslStringReader.class */
@ApiStatus.Internal
class GlslStringReader {
    public final String string;
    public final char[] chars;
    public int cursor;

    public GlslStringReader(String string) {
        this.string = string;
        this.chars = string.toCharArray();
    }

    public boolean canRead() {
        return this.cursor < this.chars.length;
    }

    public void skip(int amount) {
        this.cursor += amount;
    }

    public void skip() {
        this.cursor++;
    }

    public void skipWhitespace() {
        while (this.cursor < this.chars.length && Character.isWhitespace(this.chars[this.cursor])) {
            skip();
        }
    }
}
