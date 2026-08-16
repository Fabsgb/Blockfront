package io.github.ocelot.glslprocessor.impl;

import io.github.ocelot.glslprocessor.api.GlslSyntaxException;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslTokenReader.class */
@ApiStatus.Internal
public class GlslTokenReader {
    private static final Pattern MARKER_PATTERN = Pattern.compile(" *#\\s*(.+)");
    private final Map<String, Integer> markers;
    private final Map<String, GlslNode> markedNodes;
    private final GlslLexer.Token[] tokens;
    private final String tokenString;
    private int cursor;
    private final List<GlslSyntaxException> errors;
    private final List<GlslSyntaxException> errorsView;

    public GlslTokenReader(String source) throws GlslSyntaxException {
        this.markers = new HashMap();
        this.markedNodes = new HashMap();
        this.tokens = GlslLexer.createTokens(source, (comment, index) -> {
            String value = comment.value().substring(2);
            if (comment.type() == GlslLexer.TokenType.MULTI_COMMENT) {
                value = value.substring(0, value.length() - 2);
            }
            Matcher matcher = MARKER_PATTERN.matcher(value);
            if (matcher.find()) {
                this.markers.put(matcher.group(1).toLowerCase(Locale.ROOT), Integer.valueOf(index));
            }
        });
        this.tokenString = calculateString(source.length() + this.tokens.length, this.tokens);
        this.cursor = 0;
        this.errors = new ArrayList();
        this.errorsView = Collections.unmodifiableList(this.errors);
    }

    public GlslTokenReader(GlslLexer.Token[] tokens) {
        this.markers = Collections.emptyMap();
        this.markedNodes = new HashMap();
        this.tokens = tokens;
        this.tokenString = calculateString(tokens.length * 8, tokens);
        this.cursor = 0;
        this.errors = new ArrayList();
        this.errorsView = Collections.unmodifiableList(this.errors);
    }

    private static String calculateString(int length, GlslLexer.Token[] tokens) {
        StringBuilder builder = new StringBuilder(length);
        for (GlslLexer.Token token : tokens) {
            builder.append(token.value());
        }
        return builder.toString().trim();
    }

    public int getCursorOffset(int cursor) {
        int offset = 0;
        for (int i = 0; i <= Math.min(cursor, this.tokens.length - 1); i++) {
            offset += this.tokens[i].value().length();
        }
        return offset;
    }

    public boolean canRead(int length) {
        return this.cursor + length <= this.tokens.length;
    }

    public boolean canRead() {
        return canRead(1);
    }

    public GlslLexer.Token peek() {
        return peek(0);
    }

    public GlslLexer.Token peek(int amount) {
        if (this.cursor + amount < this.tokens.length) {
            return this.tokens[this.cursor + amount];
        }
        return null;
    }

    public GlslLexer.TokenType peekType(int amount) {
        if (this.cursor + amount < this.tokens.length) {
            return this.tokens[this.cursor + amount].type();
        }
        return null;
    }

    public boolean canConsume(GlslLexer.TokenType token) {
        return canRead() && peek().type() == token;
    }

    public GlslLexer.Token consume(GlslLexer.TokenType token) throws GlslSyntaxException {
        if (!canRead() || peek().type() != token) {
            throw error("Expected " + token);
        }
        this.cursor++;
        return peek(-1);
    }

    public boolean tryConsume(GlslLexer.TokenType... tokens) {
        if (!canRead(tokens.length)) {
            return false;
        }
        for (int i = 0; i < tokens.length; i++) {
            if (peek(i).type() != tokens[i]) {
                return false;
            }
        }
        this.cursor += tokens.length;
        return true;
    }

    public GlslSyntaxException error(String error) {
        return new GlslSyntaxException(error, this.tokenString, getCursorOffset(this.cursor));
    }

    @Contract("->fail")
    public void throwError() throws GlslSyntaxException {
        if (this.errors.isEmpty()) {
            throw new GlslSyntaxException("Failed", this.tokenString, this.cursor);
        }
        int cursor = this.cursor;
        int[] cursors = this.errors.stream().mapToInt((v0) -> {
            return v0.getCursor();
        }).toArray();
        int[] cursorOffsets = new int[cursors.length];
        int offset = 0;
        for (int i = 0; i <= Math.min(Math.max(cursor, IntStream.of(cursors).max().orElse(0)), this.tokens.length - 1); i++) {
            offset += this.tokens[i].value().length();
            if (i == this.cursor) {
                cursor = offset;
            }
            for (int j = 0; j < cursors.length; j++) {
                if (i == cursors[j]) {
                    cursorOffsets[j] = offset;
                }
            }
        }
        GlslSyntaxException exception = new GlslSyntaxException("Failed", this.tokenString, getCursorOffset(this.cursor));
        for (int i2 = 0; i2 < this.errors.size(); i2++) {
            GlslSyntaxException error = this.errors.get(i2);
            error.setCursor(cursorOffsets[i2]);
            exception.addSuppressed(error);
        }
        throw exception;
    }

    public void skip() {
        this.cursor++;
    }

    public void skip(int amount) {
        this.cursor += amount;
    }

    public void markError(String message) {
        for (GlslSyntaxException error : this.errors) {
            if (error.getCursor() == this.cursor && error.getRawMessage().equals(message)) {
                return;
            }
        }
        this.errors.add(new GlslSyntaxException(message, this.tokenString, this.cursor));
    }

    public void markNode(int cursor, GlslNode node) {
        for (Map.Entry<String, Integer> entry : this.markers.entrySet()) {
            if (entry.getValue().intValue() == cursor) {
                this.markedNodes.put(entry.getKey(), node);
            }
        }
    }

    public List<GlslSyntaxException> getErrors() {
        return this.errorsView;
    }

    public int getCursor() {
        return this.cursor;
    }

    public Map<String, GlslNode> getMarkedNodes() {
        return this.markedNodes;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public String toString() {
        return "GlslTokenReader{cursor=" + this.cursor + ", token=" + peek() + "}";
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/impl/GlslTokenReader$Error.class */
    public static final class Error extends Record {
        private final int position;
        private final String message;

        public Error(int position, String message) {
            this.position = position;
            this.message = message;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Error.class), Error.class, "position;message", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslTokenReader$Error;->position:I", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslTokenReader$Error;->message:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Error.class), Error.class, "position;message", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslTokenReader$Error;->position:I", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslTokenReader$Error;->message:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Error.class, Object.class), Error.class, "position;message", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslTokenReader$Error;->position:I", "FIELD:Lio/github/ocelot/glslprocessor/impl/GlslTokenReader$Error;->message:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public int position() {
            return this.position;
        }

        public String message() {
            return this.message;
        }
    }
}
