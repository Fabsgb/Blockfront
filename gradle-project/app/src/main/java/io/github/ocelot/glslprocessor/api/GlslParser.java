package io.github.ocelot.glslprocessor.api;

import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import io.github.ocelot.glslprocessor.impl.GlslLexer;
import io.github.ocelot.glslprocessor.impl.GlslParserImpl;
import io.github.ocelot.glslprocessor.impl.GlslTokenReader;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/GlslParser.class */
public final class GlslParser {
    private GlslParser() {
    }

    public static GlslTree preprocessParse(String input, Map<String, String> macros) throws GlslSyntaxException, LexerException {
        return GlslParserImpl.parse(GlslParserImpl.preprocess(input, macros));
    }

    public static GlslTree parse(String input) throws GlslSyntaxException {
        return GlslParserImpl.parse(input);
    }

    public static GlslNode parseExpression(String input) throws GlslSyntaxException {
        GlslLexer.Token[] tokens = GlslLexer.createTokens(input + ";");
        GlslTokenReader reader = new GlslTokenReader(tokens);
        List<GlslNode> expression = GlslParserImpl.parseStatement(reader);
        if (expression == null) {
            reader.throwError();
        }
        while (reader.canRead() && reader.peek().type() == GlslLexer.TokenType.SEMICOLON) {
            reader.skip();
        }
        if (reader.canRead()) {
            throw reader.error("Too many tokens provided");
        }
        return GlslNode.compound(expression);
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "2.0.0")
    @Deprecated(since = "0.2.0", forRemoval = true)
    public static GlslNode parseExpression(GlslLexer.Token... tokens) throws GlslSyntaxException {
        GlslTokenReader reader = new GlslTokenReader(tokens);
        List<GlslNode> expression = GlslParserImpl.parseStatement(reader);
        if (expression == null) {
            reader.throwError();
        }
        while (reader.canRead() && reader.peek().type() == GlslLexer.TokenType.SEMICOLON) {
            reader.skip();
        }
        if (reader.canRead()) {
            throw reader.error("Too many tokens provided");
        }
        return GlslNode.compound(expression);
    }

    public static List<GlslNode> parseExpressionList(String input) throws GlslSyntaxException {
        GlslLexer.Token[] tokens = GlslLexer.createTokens(input + ";");
        GlslTokenReader reader = new GlslTokenReader(tokens);
        List<GlslNode> expressions = GlslParserImpl.parseStatementList(reader);
        if (reader.canRead()) {
            throw reader.error("Too many tokens provided");
        }
        return expressions;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "2.0.0")
    @Deprecated(since = "0.2.0", forRemoval = true)
    public static List<GlslNode> parseExpressionList(GlslLexer.Token[] tokens) throws GlslSyntaxException {
        GlslTokenReader reader = new GlslTokenReader(tokens);
        List<GlslNode> expressions = GlslParserImpl.parseStatementList(reader);
        if (reader.canRead()) {
            throw reader.error("Too many tokens provided");
        }
        return expressions;
    }
}
