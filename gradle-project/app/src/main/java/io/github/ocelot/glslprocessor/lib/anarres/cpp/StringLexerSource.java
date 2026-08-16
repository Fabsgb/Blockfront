package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/StringLexerSource.class */
@ApiStatus.Internal
public class StringLexerSource extends LexerSource {
    public StringLexerSource(String string, boolean ppvalid) {
        super(string, ppvalid);
    }

    public StringLexerSource(String string) {
        this(string, false);
    }

    public String toString() {
        return "string literal";
    }
}
