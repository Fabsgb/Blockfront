package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import com.boehmod.blockfront.AbstractC0223dX;
import com.boehmod.blockfront.C0215dP;
import com.boehmod.blockfront.C0244ds;
import com.boehmod.blockfront.C0245dt;
import com.boehmod.blockfront.C0248dw;
import com.boehmod.blockfront.C0304ez;
import com.boehmod.blockfront.C0358g;
import com.boehmod.blockfront.C0847pL;
import com.boehmod.blockfront.C0885px;
import com.boehmod.blockfront.C0994s;
import com.boehmod.blockfront.C1043sv;
import com.boehmod.blockfront.C1089to;
import foundry.veil.api.client.necromancer.Skeleton;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/Preprocessor.class */
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

    @NotNull
    private Token source_token() throws LexerException {
        Token t;
        if (this.source_token != null) {
            Token tok = this.source_token;
            this.source_token = null;
            return tok;
        }
        while (true) {
            Source s = getSource();
            if (s == null) {
                t = next_source();
                if (t.getType() != 299 || getFeature(Feature.LINEMARKERS)) {
                    break;
                }
            } else {
                Token tok2 = s.token();
                if (tok2.getType() == 265 && s.isAutopop()) {
                    Token mark = pop_source();
                    if (mark != null) {
                        return mark;
                    }
                } else {
                    return tok2;
                }
            }
        }
        return t;
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
                                    case Token.f9194NL /* 284 */:
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
                    case Token.f9194NL /* 284 */:
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
                        case Token.f9194NL /* 284 */:
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
                        case Token.f9194NL /* 284 */:
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
                case C1043sv.f5687sk /* 35 */:
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
                case Token.f9194NL /* 284 */:
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
                        case Token.f9194NL /* 284 */:
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
                        case Token.f9194NL /* 284 */:
                            tokenSource_skipline = tok2;
                            break;
                        default:
                            tokenSource_skipline = source_skipline(false);
                            break;
                    }
                    Token token = tokenSource_skipline;
                    lexer.setInclude(false);
                    return token;
                }
                tok = source_skipline(true);
            }
            if (getFeature(Feature.LINEMARKERS)) {
                Token tokenLine_token = line_token(1, this.source.getName(), " 1");
                lexer.setInclude(false);
                return tokenLine_token;
            }
            Token token2 = tok;
            lexer.setInclude(false);
            return token2;
        } catch (Throwable th) {
            lexer.setInclude(false);
            throw th;
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
                            case Token.f9194NL /* 284 */:
                                break;
                            default:
                                break;
                        }
                    }
                    pragma(tok2);
                    return tok;
                case Token.f9194NL /* 284 */:
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
                case Token.f9194NL /* 284 */:
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
            case C1089to.f5854tg /* 37 */:
            case 42:
            case 47:
                return 11;
            case 38:
                return 6;
            case C1089to.f5856ti /* 43 */:
            case 45:
                return 10;
            case 60:
            case NumericValue.FF_SIZE /* 62 */:
            case Token.f9191GE /* 267 */:
            case Token.f9192LE /* 275 */:
                return 8;
            case 63:
                return 1;
            case 94:
                return 5;
            case 124:
                return 4;
            case Token.f9190EQ /* 266 */:
            case Token.f9193NE /* 283 */:
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

    private long expr(int priority) throws IOException, LexerException {
        long lhs;
        Token op;
        Token tok = expr_token();
        switch (tok.getType()) {
            case 33:
                lhs = expr(11) == 0 ? 1L : 0L;
                break;
            case 40:
                lhs = expr(0);
                Token tok2 = expr_token();
                if (tok2.getType() != 41) {
                    expr_untoken(tok2);
                    error(tok2, "Missing ) in expression. Got " + tok2.getText());
                    return 0L;
                }
                break;
            case 45:
                lhs = -expr(11);
                break;
            case 126:
                lhs = expr(11) ^ (-1);
                break;
            case Token.CHARACTER /* 259 */:
                lhs = expr_char(tok);
                break;
            case Token.IDENTIFIER /* 270 */:
                if (this.warnings.contains(Warning.UNDEF)) {
                    warning(tok, "Undefined token '" + tok.getText() + "' encountered in conditional.");
                }
                lhs = 0;
                break;
            case Token.NUMBER /* 272 */:
                NumericValue value = (NumericValue) tok.getValue();
                lhs = value.longValue();
                break;
            default:
                expr_untoken(tok);
                error(tok, "Bad token in expression: " + tok.getText());
                return 0L;
        }
        while (true) {
            op = expr_token();
            int pri = expr_priority(op);
            if (pri != 0 && priority < pri) {
                long rhs = expr(pri);
                switch (op.getType()) {
                    case C1089to.f5854tg /* 37 */:
                        if (rhs == 0) {
                            error(op, "Modulus by zero");
                            lhs = 0;
                        } else {
                            lhs %= rhs;
                        }
                        break;
                    case 38:
                        lhs &= rhs;
                        break;
                    case 42:
                        lhs *= rhs;
                        break;
                    case C1089to.f5856ti /* 43 */:
                        lhs += rhs;
                        break;
                    case 45:
                        lhs -= rhs;
                        break;
                    case 47:
                        if (rhs == 0) {
                            error(op, "Division by zero");
                            lhs = 0;
                        } else {
                            lhs /= rhs;
                        }
                        break;
                    case 60:
                        lhs = lhs < rhs ? 1L : 0L;
                        break;
                    case NumericValue.FF_SIZE /* 62 */:
                        lhs = lhs > rhs ? 1L : 0L;
                        break;
                    case 63:
                        Token tok3 = expr_token();
                        if (tok3.getType() != 58) {
                            expr_untoken(tok3);
                            error(tok3, "Missing : in conditional expression. Got " + tok3.getText());
                            return 0L;
                        }
                        long falseResult = expr(0);
                        lhs = lhs != 0 ? rhs : falseResult;
                        break;
                        break;
                    case 94:
                        lhs ^= rhs;
                        break;
                    case 124:
                        lhs |= rhs;
                        break;
                    case Token.f9190EQ /* 266 */:
                        lhs = lhs == rhs ? 1L : 0L;
                        break;
                    case Token.f9191GE /* 267 */:
                        lhs = lhs >= rhs ? 1L : 0L;
                        break;
                    case Token.LAND /* 273 */:
                        lhs = (lhs == 0 || rhs == 0) ? 0L : 1L;
                        break;
                    case Token.f9192LE /* 275 */:
                        lhs = lhs <= rhs ? 1L : 0L;
                        break;
                    case Token.LOR /* 277 */:
                        lhs = (lhs == 0 && rhs == 0) ? 0L : 1L;
                        break;
                    case Token.LSH /* 279 */:
                        lhs <<= (int) rhs;
                        break;
                    case Token.f9193NE /* 283 */:
                        lhs = lhs != rhs ? 1L : 0L;
                        break;
                    case Token.RSH /* 289 */:
                        lhs >>= (int) rhs;
                        break;
                    default:
                        error(op, "Unexpected operator " + op.getText());
                        return 0L;
                }
            }
        }
        expr_untoken(op);
        return lhs;
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
                case 11:
                case '\f':
                case C0215dP.f1669hX /* 133 */:
                case 8232:
                case 8233:
                    break;
                case C0885px.f4841pt /* 13 */:
                    cr = true;
                    nls++;
                    continue;
                    break;
                default:
                    continue;
                    break;
            }
            cr = false;
            nls++;
        }
        char[] cbuf = new char[nls];
        Arrays.fill(cbuf, '\n');
        return new Token(Token.WHITESPACE, tok.getLine(), tok.getColumn(), new String(cbuf));
    }

    @NotNull
    private Token _token() throws IOException, LexerException {
        Token tok;
        Token t;
        while (true) {
            if (isNotActive()) {
                Source s = getSource();
                if (s == null) {
                    t = next_source();
                    if (t.getType() != 299 || getFeature(Feature.LINEMARKERS)) {
                    }
                } else {
                    tok = source_token();
                    switch (tok.getType()) {
                        case Token.CCOMMENT /* 260 */:
                        case Token.CPPCOMMENT /* 261 */:
                            if (getFeature(Feature.KEEPALLCOMMENTS)) {
                                return tok;
                            }
                            if (isNotActive()) {
                                return toWhitespace(tok);
                            }
                            if (getFeature(Feature.KEEPCOMMENTS)) {
                                return tok;
                            }
                            return toWhitespace(tok);
                        case Token.EOF /* 265 */:
                        case Token.HASH /* 268 */:
                        case Token.f9194NL /* 284 */:
                            break;
                        case Token.WHITESPACE /* 294 */:
                            return tok;
                        default:
                            return source_skipline(false);
                    }
                }
            } else {
                tok = source_token();
            }
            switch (tok.getType()) {
                case 33:
                case C1089to.f5854tg /* 37 */:
                case 38:
                case 40:
                case 41:
                case 42:
                case C1089to.f5856ti /* 43 */:
                case 44:
                case 45:
                case 46:
                case 47:
                case 58:
                case 59:
                case 60:
                case 61:
                case NumericValue.FF_SIZE /* 62 */:
                case 63:
                case 64:
                case 91:
                case 93:
                case 94:
                case 96:
                case 123:
                case 124:
                case 125:
                case 126:
                case Token.AND_EQ /* 257 */:
                case Token.ARROW /* 258 */:
                case Token.CHARACTER /* 259 */:
                case Token.DEC /* 262 */:
                case Token.DIV_EQ /* 263 */:
                case Token.ELLIPSIS /* 264 */:
                case Token.f9190EQ /* 266 */:
                case Token.f9191GE /* 267 */:
                case Token.HEADER /* 269 */:
                case Token.INC /* 271 */:
                case Token.LAND /* 273 */:
                case Token.f9192LE /* 275 */:
                case Token.LOR /* 277 */:
                case Token.LSH /* 279 */:
                case Token.LSH_EQ /* 280 */:
                case Token.MOD_EQ /* 281 */:
                case Token.MULT_EQ /* 282 */:
                case Token.f9193NE /* 283 */:
                case Token.OR_EQ /* 285 */:
                case Token.PLUS_EQ /* 287 */:
                case Token.RANGE /* 288 */:
                case Token.RSH /* 289 */:
                case Token.RSH_EQ /* 290 */:
                case Token.SQSTRING /* 291 */:
                case Token.STRING /* 292 */:
                case Token.SUB_EQ /* 293 */:
                case Token.XOR_EQ /* 295 */:
                    return tok;
                case 34:
                case C1043sv.f5687sk /* 35 */:
                case 36:
                case 39:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case C0244ds.f1990he /* 56 */:
                case 57:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case C0304ez.f2369je /* 70 */:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 92:
                case 95:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case C0244ds.f1979hd /* 110 */:
                case 111:
                case Skeleton.UNIFORM_STRIDE /* 112 */:
                case 113:
                case C0248dw.f2042hx /* 114 */:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case C0358g.f2490g /* 120 */:
                case 121:
                case 122:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case C0215dP.f1669hX /* 133 */:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case C0244ds.f1978hc /* 173 */:
                case 174:
                case 175:
                case 176:
                case 177:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case AbstractC0223dX.f1766ij /* 190 */:
                case 191:
                case 192:
                case 193:
                case 194:
                case 195:
                case 196:
                case 197:
                case 198:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                case 220:
                case 221:
                case 222:
                case 223:
                case 224:
                case 225:
                case 226:
                case 227:
                case 228:
                case 229:
                case 230:
                case 231:
                case 232:
                case C0248dw.f2040hv /* 233 */:
                case 234:
                case 235:
                case 236:
                case 237:
                case 238:
                case 239:
                case C0847pL.f4563pM /* 240 */:
                case C0245dt.f2006hm /* 241 */:
                case 242:
                case 243:
                case 244:
                case 245:
                case 246:
                case 247:
                case 248:
                case 249:
                case 250:
                case 251:
                case 252:
                case 253:
                case 254:
                case 255:
                case 256:
                case Token.LAND_EQ /* 274 */:
                case Token.LITERAL /* 276 */:
                case Token.LOR_EQ /* 278 */:
                case Token.PASTE /* 286 */:
                case Token.M_ARG /* 296 */:
                case Token.M_PASTE /* 297 */:
                case Token.M_STRING /* 298 */:
                default:
                    throw new AssertionError("Bad token " + tok);
                case Token.CCOMMENT /* 260 */:
                case Token.CPPCOMMENT /* 261 */:
                    return tok;
                case Token.EOF /* 265 */:
                    return tok;
                case Token.HASH /* 268 */:
                    Token tok2 = source_token_nonwhite();
                    switch (tok2.getType()) {
                        case Token.IDENTIFIER /* 270 */:
                            PreprocessorCommand ppcmd = PreprocessorCommand.forText(tok2.getText());
                            if (ppcmd == null) {
                                error(tok2, "Unknown preprocessor directive " + tok2.getText());
                                return source_skipline(false);
                            }
                            switch (C14882.f9189xb3f08209[ppcmd.ordinal()]) {
                                case 1:
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    return define();
                                case 2:
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    return undef();
                                case 3:
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    return include();
                                case 4:
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    if (!getFeature(Feature.INCLUDENEXT)) {
                                        error(tok2, "Directive include_next not enabled");
                                        return source_skipline(false);
                                    }
                                    return include();
                                case 5:
                                case 6:
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    error(tok2, ppcmd == PreprocessorCommand.PP_ERROR);
                                    break;
                                    break;
                                case C0994s.f5462C /* 7 */:
                                    push_state();
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    this.expr_token = null;
                                    this.states.peek().setActive(expr(0) != 0);
                                    Token tok3 = expr_token();
                                    if (tok3.getType() == 284) {
                                        return tok3;
                                    }
                                    return source_skipline(true);
                                case 8:
                                    State state = this.states.peek();
                                    if (state.sawElse()) {
                                        error(tok2, "#elif after #else");
                                        return source_skipline(false);
                                    }
                                    if (!state.isParentActive()) {
                                        return source_skipline(false);
                                    }
                                    if (state.isActive()) {
                                        state.setParentActive(false);
                                        state.setActive(false);
                                        return source_skipline(false);
                                    }
                                    this.expr_token = null;
                                    state.setActive(expr(0) != 0);
                                    Token tok4 = expr_token();
                                    if (tok4.getType() == 284) {
                                        return tok4;
                                    }
                                    return source_skipline(true);
                                case 9:
                                    State state2 = this.states.peek();
                                    if (state2.sawElse()) {
                                        error(tok2, "#else after #else");
                                        return source_skipline(false);
                                    }
                                    state2.setSawElse();
                                    state2.setActive(!state2.isActive());
                                    return source_skipline(this.warnings.contains(Warning.ENDIF_LABELS));
                                case 10:
                                    push_state();
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    Token tok5 = source_token_nonwhite();
                                    if (tok5.getType() != 270) {
                                        error(tok5, "Expected identifier, not " + tok5.getText());
                                        return source_skipline(false);
                                    }
                                    String text = tok5.getText();
                                    boolean exists = this.macros.containsKey(text);
                                    this.states.peek().setActive(exists);
                                    return source_skipline(true);
                                case 11:
                                    push_state();
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    Token tok6 = source_token_nonwhite();
                                    if (tok6.getType() != 270) {
                                        error(tok6, "Expected identifier, not " + tok6.getText());
                                        return source_skipline(false);
                                    }
                                    String text2 = tok6.getText();
                                    boolean exists2 = this.macros.containsKey(text2);
                                    this.states.peek().setActive(!exists2);
                                    return source_skipline(true);
                                case 12:
                                    pop_state();
                                    return source_skipline(this.warnings.contains(Warning.ENDIF_LABELS));
                                case C0885px.f4841pt /* 13 */:
                                    return source_skipline(false);
                                case 14:
                                    if (isNotActive()) {
                                        return source_skipline(false);
                                    }
                                    return pragma();
                                default:
                                    throw new AssertionError("Internal error: Unknown directive " + tok2);
                            }
                            break;
                        case Token.f9194NL /* 284 */:
                            break;
                        default:
                            error(tok2, "Preprocessor directive not a word " + tok2.getText());
                            return source_skipline(false);
                    }
                    break;
                case Token.IDENTIFIER /* 270 */:
                    Macro m = getMacro(tok.getText());
                    if (m == null) {
                        return tok;
                    }
                    if (this.source.isExpanding(m)) {
                        return tok;
                    }
                    if (!macro(m, tok)) {
                        return tok;
                    }
                    break;
                    break;
                case Token.NUMBER /* 272 */:
                    return tok;
                case Token.f9194NL /* 284 */:
                case Token.WHITESPACE /* 294 */:
                    return tok;
                case Token.P_LINE /* 299 */:
                    if (getFeature(Feature.LINEMARKERS)) {
                        return tok;
                    }
                    break;
                case 300:
                    if (getFeature(Feature.CSYNTAX)) {
                        error(tok, String.valueOf(tok.getValue()));
                    }
                    return tok;
            }
        }
        return t;
    }

    /* JADX INFO: renamed from: io.github.ocelot.glslprocessor.lib.anarres.cpp.Preprocessor$2 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/Preprocessor$2.class */
    static /* synthetic */ class C14882 {

        /* JADX INFO: renamed from: $SwitchMap$io$github$ocelot$glslprocessor$lib$anarres$cpp$PreprocessorCommand */
        static final /* synthetic */ int[] f9189xb3f08209 = new int[PreprocessorCommand.values().length];

        static {
            try {
                f9189xb3f08209[PreprocessorCommand.PP_DEFINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_UNDEF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_INCLUDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_INCLUDE_NEXT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_IF.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_ELIF.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_ELSE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_IFDEF.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_IFNDEF.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_ENDIF.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_LINE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f9189xb3f08209[PreprocessorCommand.PP_PRAGMA.ordinal()] = 14;
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
