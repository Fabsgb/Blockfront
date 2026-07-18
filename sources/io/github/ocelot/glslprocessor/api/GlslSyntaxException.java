package io.github.ocelot.glslprocessor.api;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/GlslSyntaxException.class */
public class GlslSyntaxException extends Exception {
    public static final int CONTEXT_AMOUNT = 64;
    private final String message;
    private final String input;
    private int cursor;

    public GlslSyntaxException(String message, String input, int cursor) {
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

    public int getCursor() {
        return this.cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    private String getContext() {
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
}
