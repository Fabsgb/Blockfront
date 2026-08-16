package gg.moonflower.molangcompiler.api.exception;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/exception/MolangSyntaxException.class */
public class MolangSyntaxException extends MolangException {
    public static final int CONTEXT_AMOUNT = 64;
    private final String message;
    private final String input;
    private final int cursor;

    public MolangSyntaxException(String message) {
        super(message);
        this.message = message;
        this.input = null;
        this.cursor = -1;
    }

    public MolangSyntaxException(String message, Throwable t) {
        super(message, t);
        this.message = message;
        this.input = null;
        this.cursor = -1;
    }

    public MolangSyntaxException(String message, String input) {
        this(message, input, input.length());
    }

    public MolangSyntaxException(String message, String input, int cursor) {
        super(message);
        this.message = message;
        this.input = input;
        this.cursor = cursor;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = this.message;
        String context = getContext();
        if (context != null) {
            message = message + " at position " + this.cursor + ": " + context;
        }
        return message;
    }

    public String getRawMessage() {
        return this.message;
    }

    public String getContext() {
        if (this.input == null || this.cursor < 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int cursor = Math.min(this.input.length(), this.cursor);
        if (cursor > 64) {
            builder.append("...");
        }
        builder.append((CharSequence) this.input, Math.max(0, cursor - 64), cursor);
        builder.append("<--[HERE]");
        return builder.toString();
    }

    @Nullable
    public String getInput() {
        return this.input;
    }

    public int getCursor() {
        return this.cursor;
    }
}
