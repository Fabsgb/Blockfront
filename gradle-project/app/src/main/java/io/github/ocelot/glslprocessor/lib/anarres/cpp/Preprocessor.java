package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import com.boehmod.blockfront.AbstractC0422pq;
import com.boehmod.blockfront.C0407pb;
import com.boehmod.blockfront.dE;
import com.boehmod.blockfront.rY;
import com.boehmod.blockfront.sR;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/Preprocessor.class */
@ApiStatus.Internal
public class Preprocessor {
    private static final Source INTERNAL = new Source() { // from class: io.github.ocelot.glslprocessor.lib.anarres.cpp.Preprocessor.1
        @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
        public Token token() throws LexerException {
            throw new LexerException("Cannot read from " + getName());
        }

        @Override // io.github.ocelot.glslprocessor.lib.anarres.cpp.Source
        public String getName() {
            return "internal data";
        }
    };
    private static final Macro __LINE__ = new Macro(INTERNAL, "__LINE__");
    private static final Macro __FILE__ = new Macro(INTERNAL, "__FILE__");
    private static final Macro __COUNTER__ = new Macro(INTERNAL, "__COUNTER__");
    private final Stack<State> states;
    private Source source;
    private int counter;
    private final Set<Feature> features;
    private final Set<Warning> warnings;
    private Token source_token;

    @Nullable
    private Token expr_token = null;
    private final List<Source> inputs = new ArrayList();
    private final Map<String, Macro> macros = new HashMap();

    public Preprocessor() {
        this.macros.put(__LINE__.getName(), __LINE__);
        this.macros.put(__FILE__.getName(), __FILE__);
        this.macros.put(__COUNTER__.getName(), __COUNTER__);
        this.states = new Stack<>();
        this.states.push(new State());
        this.source = null;
        this.counter = 0;
        this.features = EnumSet.noneOf(Feature.class);
        this.warnings = EnumSet.noneOf(Warning.class);
    }

    public void addFeature(@NotNull Feature f) {
        this.features.add(f);
    }

    public boolean getFeature(@NotNull Feature f) {
        return this.features.contains(f);
    }

    @NotNull
    public Set<Warning> getWarnings() {
        return this.warnings;
    }

    public boolean getWarning(@NotNull Warning w) {
        return this.warnings.contains(w);
    }

    public void addInput(@NotNull Source source) {
        source.init(this);
        this.inputs.add(source);
    }

    protected void error(int line, int column, @NotNull String msg) throws LexerException {
        throw new LexerException("Error at " + line + ":" + column + ": " + msg);
    }

    protected void error(@NotNull Token tok, @NotNull String msg) throws LexerException {
        error(tok.getLine(), tok.getColumn(), msg);
    }

    protected void warning(int line, int column, @NotNull String msg) throws LexerException {
        if (this.warnings.contains(Warning.ERROR)) {
            error(line, column, msg);
            return;
        }
        throw new LexerException("Warning at " + line + ":" + column + ": " + msg);
    }

    protected void warning(@NotNull Token tok, @NotNull String msg) throws LexerException {
        warning(tok.getLine(), tok.getColumn(), msg);
    }

    public void addMacro(@NotNull Macro m) throws LexerException {
        String name = m.getName();
        if ("defined".equals(name)) {
            throw new LexerException("Cannot redefine name 'defined'");
        }
        this.macros.put(m.getName(), m);
    }

    public void addMacro(@NotNull String name, @NotNull String value) throws LexerException {
        Macro m = new Macro(name);
        StringLexerSource s = new StringLexerSource(value);
        while (true) {
            Token tok = s.token();
            if (tok.getType() != 265) {
                m.addToken(tok);
            } else {
                addMacro(m);
                return;
            }
        }
    }

    public void addMacro(@NotNull String name) throws LexerException {
        addMacro(name, "1");
    }

    @NotNull
    public Map<String, Macro> getMacros() {
        return this.macros;
    }

    @Nullable
    public Macro getMacro(@NotNull String name) {
        return this.macros.get(name);
    }

    private void push_state() {
        State top = this.states.peek();
        this.states.push(new State(top));
    }

    private void pop_state() throws LexerException {
        State s = this.states.pop();
        if (this.states.isEmpty()) {
            error(0, 0, "#endif without #if");
            this.states.push(s);
        }
    }

    private boolean isNotActive() {
        State state = this.states.peek();
        return (state.isParentActive() && state.isActive()) ? false : true;
    }

    protected Source getSource() {
        return this.source;
    }

    protected void push_source(@NotNull Source source, boolean autopop) {
        source.init(this);
        source.setParent(this.source, autopop);
        this.source = source;
    }

    @Nullable
    protected Token pop_source() {
        Source s = this.source;
        this.source = s.getParent();
        Source t = getSource();
        if (getFeature(Feature.LINEMARKERS) && s.isNumbered() && t != null) {
            return line_token(t.getLine(), t.getName(), " 2");
        }
        return null;
    }

    @NotNull
    private Token next_source() {
        if (this.inputs.isEmpty()) {
            return new Token(Token.EOF);
        }
        Source s = this.inputs.remove(0);
        push_source(s, true);
        return line_token(s.getLine(), s.getName(), " 1");
    }

    @NotNull
    private Token line_token(int line, @Nullable String name, @NotNull String extra) {
        StringBuilder buf = new StringBuilder();
        buf.append("#line ").append(line).append(" \"");
        if (name == null) {
            buf.append("<no file>");
        } else {
            MacroTokenSource.escape(buf, name);
        }
        buf.append("\"").append(extra).append("\n");
        return new Token(Token.P_LINE, line, 0, buf.toString(), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        return r0;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.github.ocelot.glslprocessor.lib.anarres.cpp.Token source_token() throws io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException {
        /*
            r3 = this;
            r0 = r3
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Token r0 = r0.source_token
            if (r0 == 0) goto L13
            r0 = r3
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Token r0 = r0.source_token
            r4 = r0
            r0 = r3
            r1 = 0
            r0.source_token = r1
            r0 = r4
            return r0
        L13:
            r0 = r3
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Source r0 = r0.getSource()
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L3a
            r0 = r3
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Token r0 = r0.next_source()
            r5 = r0
            r0 = r5
            int r0 = r0.getType()
            r1 = 299(0x12b, float:4.19E-43)
            if (r0 != r1) goto L38
            r0 = r3
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Feature r1 = io.github.ocelot.glslprocessor.lib.anarres.cpp.Feature.LINEMARKERS
            boolean r0 = r0.getFeature(r1)
            if (r0 != 0) goto L38
            goto L13
        L38:
            r0 = r5
            return r0
        L3a:
            r0 = r4
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Token r0 = r0.token()
            r5 = r0
            r0 = r5
            int r0 = r0.getType()
            r1 = 265(0x109, float:3.71E-43)
            if (r0 != r1) goto L5b
            r0 = r4
            boolean r0 = r0.isAutopop()
            if (r0 == 0) goto L5b
            r0 = r3
            io.github.ocelot.glslprocessor.lib.anarres.cpp.Token r0 = r0.pop_source()
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L13
            r0 = r6
            return r0
        L5b:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.ocelot.glslprocessor.lib.anarres.cpp.Preprocessor.source_token():io.github.ocelot.glslprocessor.lib.anarres.cpp.Token");
    }

    private void source_untoken(Token tok) {
        if (this.source_token != null) {
            throw new IllegalStateException("Cannot return two tokens");
        }
        this.source_token = tok;
    }

    private boolean isWhite(Token tok) {
        int type = tok.getType();
        return type == 294 || type == 260 || type == 261;
    }

    private Token source_token_nonwhite() throws LexerException {
        Token tok;
        do {
            tok = source_token();
        } while (isWhite(tok));
        return tok;
    }

    private Token source_skipline(boolean white) throws LexerException {
        Token mark;
        Source s = getSource();
        Token tok = s.skipline(white);
        if (tok.getType() == 265 && s.isAutopop() && (mark = pop_source()) != null) {
            return mark;
        }
        return tok;
    }

    private boolean macro(Macro m, Token orig) throws IOException, LexerException {
        List<Argument> args;
        boolean z;
        if (m.isFunctionLike()) {
            while (true) {
                Token tok = source_token();
                switch (tok.getType()) {
                    case 40:
                        Token tok2 = source_token_nonwhite();
                        if (tok2.getType() != 41 || m.getArgs() > 0) {
                            args = new ArrayList<>();
                            Argument arg = new Argument();
                            int depth = 0;
                            boolean space = false;
                            while (true) {
                                switch (tok2.getType()) {
                                    case 40:
                                        depth++;
                                        arg.addToken(tok2);
                                        z = false;
                                        continue;
                                        space = z;
                                        tok2 = source_token();
                                        break;
                                    case 41:
                                        if (depth == 0) {
                                            args.add(arg);
                                            if (args.size() != m.getArgs()) {
                                                if (m.isVariadic()) {
                                                    if (args.size() == m.getArgs() - 1) {
                                                        args.add(new Argument());
                                                    } else {
                                                        error(tok2, "variadic macro " + m.getName() + " has at least " + (m.getArgs() - 1) + " parameters but given " + args.size() + " args");
                                                        return false;
                                                    }
                                                } else {
                                                    error(tok2, "macro " + m.getName() + " has " + m.getArgs() + " parameters but given " + args.size() + " args");
                                                    return false;
                                                }
                                            }
                                            for (Argument a : args) {
                                                a.expand(this);
                                            }
                                        } else {
                                            depth--;
                                            arg.addToken(tok2);
                                            z = false;
                                            space = z;
                                            tok2 = source_token();
                                        }
                                        break;
                                    case 44:
                                        if (depth == 0) {
                                            if (m.isVariadic() && args.size() == m.getArgs() - 1) {
                                                arg.addToken(tok2);
                                            } else {
                                                args.add(arg);
                                                arg = new Argument();
                                            }
                                        } else {
                                            arg.addToken(tok2);
                                        }
                                        z = false;
                                        continue;
                                        space = z;
                                        tok2 = source_token();
                                        break;
                                    case Token.CCOMMENT /* 260 */:
                                    case Token.CPPCOMMENT /* 261 */:
                                    case Token.NL /* 284 */:
                                    case Token.WHITESPACE /* 294 */:
                                        z = true;
                                        continue;
                                        space = z;
                                        tok2 = source_token();
                                        break;
                                    case Token.EOF /* 265 */:
                                        error(tok2, "EOF in macro args");
                                        return false;
                                    default:
                                        if (space && !arg.isEmpty()) {
                                            arg.addToken(Token.space);
                                        }
                                        arg.addToken(tok2);
                                        z = false;
                                        continue;
                                        space = z;
                                        tok2 = source_token();
                                        break;
                                }
                            }
                        } else {
                            args = null;
                            break;
                        }
                        break;
                    case Token.CCOMMENT /* 260 */:
                    case Token.CPPCOMMENT /* 261 */:
                    case Token.NL /* 284 */:
                    case Token.WHITESPACE /* 294 */:
                        break;
                    default:
                        source_untoken(tok);
                        return false;
                }
            }
        } else {
            args = null;
        }
        if (m == __LINE__) {
            push_source(new FixedTokenSource(new Token(Token.NUMBER, orig.getLine(), orig.getColumn(), Integer.toString(orig.getLine()), new NumericValue(10, Integer.toString(orig.getLine())))), true);
            return true;
        }
        if (m != __FILE__) {
            if (m == __COUNTER__) {
                int value = this.counter;
                this.counter = value + 1;
                push_source(new FixedTokenSource(new Token(Token.NUMBER, orig.getLine(), orig.getColumn(), Integer.toString(value), new NumericValue(10, Integer.toString(value)))), true);
                return true;
            }
            push_source(new MacroTokenSource(m, args), true);
            return true;
        }
        StringBuilder buf = new StringBuilder("\"");
        String name = getSource().getName();
        if (name == null) {
            name = "<no file>";
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            switch (c) {
                case '\"':
                    buf.append("\\\"");
                    break;
                case '\\':
                    buf.append("\\\\");
                    break;
                default:
                    buf.append(c);
                    break;
            }
        }
        buf.append("\"");
        String text = buf.toString();
        push_source(new FixedTokenSource(new Token(Token.STRING, orig.getLine(), orig.getColumn(), text, text)), true);
        return true;
    }

    @NotNull
    List<Token> expand(@NotNull List<Token> arg) throws IOException, LexerException {
        List<Token> expansion = new ArrayList<>();
        boolean space = false;
        push_source(new FixedTokenSource(arg), false);
        while (true) {
            Token tok = expanded_token();
            switch (tok.getType()) {
                case Token.CCOMMENT /* 260 */:
                case Token.CPPCOMMENT /* 261 */:
                case Token.WHITESPACE /* 294 */:
                    space = true;
                    break;
                case Token.EOF /* 265 */:
                    pop_source();
                    return expansion;
                default:
                    if (space && !expansion.isEmpty()) {
                        expansion.add(Token.space);
                    }
                    expansion.add(tok);
                    space = false;
                    break;
            }
        }
    }

    private Token define() throws LexerException {
        List<String> args;
        int idx;
        Token tok = source_token_nonwhite();
        if (tok.getType() != 270) {
            error(tok, "Expected identifier");
            return source_skipline(false);
        }
        String name = tok.getText();
        if ("defined".equals(name)) {
            error(tok, "Cannot redefine name 'defined'");
            return source_skipline(false);
        }
        Macro m = new Macro(getSource(), name);
        Token tok2 = source_token();
        if (tok2.getType() == 40) {
            Token tok3 = source_token_nonwhite();
            if (tok3.getType() != 41) {
                args = new ArrayList();
                while (true) {
                    switch (tok3.getType()) {
                        case Token.ELLIPSIS /* 264 */:
                            args.add("__VA_ARGS__");
                            source_untoken(tok3);
                            break;
                        case Token.EOF /* 265 */:
                        case Token.NL /* 284 */:
                            error(tok3, "Unterminated macro parameter list");
                            return tok3;
                        case Token.IDENTIFIER /* 270 */:
                            args.add(tok3.getText());
                            break;
                        default:
                            error(tok3, "error in macro parameters: " + tok3.getText());
                            return source_skipline(false);
                    }
                    Token tok4 = source_token_nonwhite();
                    switch (tok4.getType()) {
                        case 41:
                            break;
                        case 44:
                            tok3 = source_token_nonwhite();
                            break;
                        case Token.ELLIPSIS /* 264 */:
                            Token tok5 = source_token_nonwhite();
                            if (tok5.getType() != 41) {
                                error(tok5, "ellipsis must be on last argument");
                            }
                            m.setVariadic(true);
                            break;
                        case Token.EOF /* 265 */:
                        case Token.NL /* 284 */:
                            error(tok4, "Unterminated macro parameters");
                            return tok4;
                        default:
                            error(tok4, "Bad token in macro parameters: " + tok4.getText());
                            return source_skipline(false);
                    }
                }
            } else {
                args = Collections.emptyList();
            }
            m.setArgs(args);
        } else {
            args = Collections.emptyList();
            source_untoken(tok2);
        }
        boolean space = false;
        boolean paste = false;
        Token tokenSource_token_nonwhite = source_token_nonwhite();
        while (true) {
            Token tok6 = tokenSource_token_nonwhite;
            switch (tok6.getType()) {
                case rY.qj /* 35 */:
                    if (space) {
                        m.addToken(Token.space);
                    }
                    space = false;
                    Token la = source_token_nonwhite();
                    if (la.getType() == 270 && (idx = args.indexOf(la.getText())) != -1) {
                        m.addToken(new Token(Token.M_STRING, la.getLine(), la.getColumn(), "#" + la.getText(), Integer.valueOf(idx)));
                    } else {
                        m.addToken(tok6);
                        source_untoken(la);
                    }
                    break;
                case Token.CCOMMENT /* 260 */:
                case Token.CPPCOMMENT /* 261 */:
                case Token.WHITESPACE /* 294 */:
                    if (!paste) {
                        space = true;
                    }
                    break;
                case Token.EOF /* 265 */:
                case Token.NL /* 284 */:
                    addMacro(m);
                    return tok6;
                case Token.IDENTIFIER /* 270 */:
                    if (space) {
                        m.addToken(Token.space);
                    }
                    space = false;
                    paste = false;
                    int idx2 = args.indexOf(tok6.getText());
                    if (idx2 == -1) {
                        m.addToken(tok6);
                    } else {
                        m.addToken(new Token(Token.M_ARG, tok6.getLine(), tok6.getColumn(), tok6.getText(), Integer.valueOf(idx2)));
                    }
                    break;
                case Token.PASTE /* 286 */:
                    space = false;
                    paste = true;
                    m.addPaste(new Token(Token.M_PASTE, tok6.getLine(), tok6.getColumn(), "##", null));
                    break;
                default:
                    if (space) {
                        m.addToken(Token.space);
                    }
                    space = false;
                    paste = false;
                    m.addToken(tok6);
                    break;
            }
            tokenSource_token_nonwhite = source_token();
        }
    }

    @NotNull
    private Token undef() throws LexerException {
        Token tok = source_token_nonwhite();
        if (tok.getType() != 270) {
            error(tok, "Expected identifier, not " + tok.getText());
            if (tok.getType() == 284 || tok.getType() == 265) {
                return tok;
            }
        } else {
            Macro m = getMacro(tok.getText());
            if (m != null) {
                this.macros.remove(m.getName());
            }
        }
        return source_skipline(true);
    }

    @NotNull
    private Token include() throws IOException, LexerException {
        Token tokenSource_skipline;
        Token tok;
        LexerSource lexer = (LexerSource) this.source;
        try {
            lexer.setInclude(true);
            Token tok2 = token_nonwhite();
            if (tok2.getType() == 292) {
                while (true) {
                    tok = token_nonwhite();
                    switch (tok.getType()) {
                        case Token.EOF /* 265 */:
                        case Token.NL /* 284 */:
                            break;
                        case Token.STRING /* 292 */:
                            break;
                        default:
                            warning(tok, "Unexpected token on #include line");
                            Token tokenSource_skipline2 = source_skipline(false);
                            lexer.setInclude(false);
                            return tokenSource_skipline2;
                    }
                }
            } else {
                if (tok2.getType() != 269) {
                    error(tok2, "Expected string or header, not " + tok2.getText());
                    switch (tok2.getType()) {
                        case Token.EOF /* 265 */:
                        case Token.NL /* 284 */:
                            tokenSource_skipline = tok2;
                            break;
                        default:
                            tokenSource_skipline = source_skipline(false);
                            break;
                    }
                    return tokenSource_skipline;
                }
                tok = source_skipline(true);
            }
            if (getFeature(Feature.LINEMARKERS)) {
                Token tokenLine_token = line_token(1, this.source.getName(), " 1");
                lexer.setInclude(false);
                return tokenLine_token;
            }
            Token token = tok;
            lexer.setInclude(false);
            return token;
        } finally {
            lexer.setInclude(false);
        }
    }

    protected void pragma(@NotNull Token name) throws LexerException {
        if (getFeature(Feature.PRAGMA_ONCE) && "once".equals(name.getText())) {
            return;
        }
        warning(name, "Unknown #pragma: " + name.getText());
    }

    @NotNull
    private Token pragma() throws LexerException {
        Token tok;
        while (true) {
            Token tok2 = source_token();
            switch (tok2.getType()) {
                case Token.CCOMMENT /* 260 */:
                case Token.CPPCOMMENT /* 261 */:
                case Token.WHITESPACE /* 294 */:
                    break;
                case Token.EOF /* 265 */:
                    warning(tok2, "End of file in #pragma");
                    return tok2;
                case Token.IDENTIFIER /* 270 */:
                    while (true) {
                        tok = source_token();
                        switch (tok.getType()) {
                            case Token.EOF /* 265 */:
                                warning(tok, "End of file in #pragma");
                                break;
                            case Token.NL /* 284 */:
                                break;
                        }
                    }
                    pragma(tok2);
                    return tok;
                case Token.NL /* 284 */:
                    warning(tok2, "Empty #pragma");
                    return tok2;
                default:
                    warning(tok2, "Illegal #pragma " + tok2.getText());
                    return source_skipline(false);
            }
        }
    }

    private void error(@NotNull Token pptok, boolean is_error) throws LexerException {
        StringBuilder buf = new StringBuilder();
        buf.append('#').append(pptok.getText()).append(' ');
        Token tokenSource_token_nonwhite = source_token_nonwhite();
        while (true) {
            Token tok = tokenSource_token_nonwhite;
            switch (tok.getType()) {
                case Token.EOF /* 265 */:
                case Token.NL /* 284 */:
                    if (is_error) {
                        error(pptok, buf.toString());
                        return;
                    } else {
                        warning(pptok, buf.toString());
                        return;
                    }
                default:
                    buf.append(tok.getText());
                    tokenSource_token_nonwhite = source_token();
                    break;
            }
        }
    }

    @NotNull
    private Token expanded_token() throws IOException, LexerException {
        Token tok;
        Macro m;
        do {
            tok = source_token();
            if (tok.getType() != 270) {
                break;
            }
            m = getMacro(tok.getText());
            if (m == null) {
                return tok;
            }
            if (this.source.isExpanding(m)) {
                return tok;
            }
        } while (macro(m, tok));
        return tok;
    }

    @NotNull
    private Token expanded_token_nonwhite() throws IOException, LexerException {
        Token tok;
        do {
            tok = expanded_token();
        } while (isWhite(tok));
        return tok;
    }

    @NotNull
    private Token expr_token() throws IOException, LexerException {
        Token tok = this.expr_token;
        if (tok != null) {
            this.expr_token = null;
        } else {
            tok = expanded_token_nonwhite();
            if (tok.getType() == 270 && tok.getText().equals("defined")) {
                Token la = source_token_nonwhite();
                boolean paren = false;
                if (la.getType() == 40) {
                    paren = true;
                    la = source_token_nonwhite();
                }
                if (la.getType() != 270) {
                    error(la, "defined() needs identifier, not " + la.getText());
                    tok = new Token(Token.NUMBER, la.getLine(), la.getColumn(), "0", new NumericValue(10, "0"));
                } else if (this.macros.containsKey(la.getText())) {
                    tok = new Token(Token.NUMBER, la.getLine(), la.getColumn(), "1", new NumericValue(10, "1"));
                } else {
                    tok = new Token(Token.NUMBER, la.getLine(), la.getColumn(), "0", new NumericValue(10, "0"));
                }
                if (paren) {
                    Token la2 = source_token_nonwhite();
                    if (la2.getType() != 41) {
                        expr_untoken(la2);
                        error(la2, "Missing ) in defined(). Got " + la2.getText());
                    }
                }
            }
        }
        return tok;
    }

    private void expr_untoken(@NotNull Token tok) {
        if (this.expr_token != null) {
            throw new AssertionError("Cannot unget two expression tokens.");
        }
        this.expr_token = tok;
    }

    private int expr_priority(@NotNull Token op) {
        switch (op.getType()) {
            case sR.rf /* 37 */:
            case 42:
            case 47:
                return 11;
            case 38:
                return 6;
            case sR.rh /* 43 */:
            case 45:
                return 10;
            case 60:
            case NumericValue.FF_SIZE /* 62 */:
            case Token.GE /* 267 */:
            case Token.LE /* 275 */:
                return 8;
            case 63:
                return 1;
            case 94:
                return 5;
            case 124:
                return 4;
            case Token.EQ /* 266 */:
            case Token.NE /* 283 */:
                return 7;
            case Token.LAND /* 273 */:
                return 3;
            case Token.LOR /* 277 */:
                return 2;
            case Token.LSH /* 279 */:
            case Token.RSH /* 289 */:
                return 9;
            default:
                return 0;
        }
    }

    private int expr_char(Token token) {
        Object value = token.getValue();
        if (value instanceof Character) {
            Character character = (Character) value;
            return character.charValue();
        }
        String text = String.valueOf(value);
        if (text.isBlank()) {
            return 0;
        }
        return text.charAt(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0321, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x010e, code lost:
    
        expr_untoken(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long expr(int r6) throws java.io.IOException, io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.ocelot.glslprocessor.lib.anarres.cpp.Preprocessor.expr(int):long");
    }

    @NotNull
    private Token toWhitespace(@NotNull Token tok) {
        String text = tok.getText();
        int len = text.length();
        boolean cr = false;
        int nls = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            switch (c) {
                case '\n':
                    if (cr) {
                        cr = false;
                    }
                    break;
                case AbstractC0422pq.nO /* 11 */:
                case '\f':
                case dE.gN /* 133 */:
                case 8232:
                case 8233:
                    break;
                case C0407pb.nu /* 13 */:
                    cr = true;
                    nls++;
                    continue;
                    break;
                default:
                    break;
            }
            cr = false;
            nls++;
        }
        char[] cbuf = new char[nls];
        Arrays.fill(cbuf, '\n');
        return new Token(Token.WHITESPACE, tok.getLine(), tok.getColumn(), new String(cbuf));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        return r0;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.github.ocelot.glslprocessor.lib.anarres.cpp.Token _token() throws java.io.IOException, io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException {
        /*
            Method dump skipped, instruction units count: 2188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.ocelot.glslprocessor.lib.anarres.cpp.Preprocessor._token():io.github.ocelot.glslprocessor.lib.anarres.cpp.Token");
    }

    /* JADX INFO: renamed from: io.github.ocelot.glslprocessor.lib.anarres.cpp.Preprocessor$2, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/Preprocessor$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand = new int[PreprocessorCommand.values().length];

        static {
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_DEFINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_UNDEF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_INCLUDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_INCLUDE_NEXT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_IF.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_ELIF.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_ELSE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_IFDEF.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_IFNDEF.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_ENDIF.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_LINE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand[PreprocessorCommand.PP_PRAGMA.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    @NotNull
    private Token token_nonwhite() throws IOException, LexerException {
        Token tok;
        do {
            tok = _token();
        } while (isWhite(tok));
        return tok;
    }

    @NotNull
    public Token token() throws IOException, LexerException {
        return _token();
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        Source source = getSource();
        while (true) {
            Source s = source;
            if (s == null) {
                break;
            }
            buf.append(" -> ").append(s).append("\n");
            source = s.getParent();
        }
        Map<String, Macro> macros = new TreeMap<>(getMacros());
        for (Macro macro : macros.values()) {
            buf.append("#").append("macro ").append(macro).append("\n");
        }
        return buf.toString();
    }
}
