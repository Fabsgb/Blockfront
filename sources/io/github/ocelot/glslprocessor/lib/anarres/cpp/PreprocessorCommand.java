package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/PreprocessorCommand.class */
@ApiStatus.Internal
public enum PreprocessorCommand {
    PP_DEFINE("define"),
    PP_ELIF("elif"),
    PP_ELSE("else"),
    PP_ENDIF("endif"),
    PP_ERROR("error"),
    PP_IF("if"),
    PP_IFDEF("ifdef"),
    PP_IFNDEF("ifndef"),
    PP_INCLUDE("include"),
    PP_LINE("line"),
    PP_PRAGMA("pragma"),
    PP_UNDEF("undef"),
    PP_WARNING("warning"),
    PP_INCLUDE_NEXT("include_next"),
    PP_IMPORT("import");

    private final String text;

    PreprocessorCommand(String text) {
        this.text = text;
    }

    @Nullable
    public static PreprocessorCommand forText(@NotNull String text) {
        for (PreprocessorCommand ppcmd : values()) {
            if (ppcmd.text.equals(text)) {
                return ppcmd;
            }
        }
        return null;
    }
}
