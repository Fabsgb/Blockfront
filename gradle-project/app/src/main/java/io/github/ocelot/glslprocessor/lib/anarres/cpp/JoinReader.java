package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import com.boehmod.blockfront.C0215dP;
import com.boehmod.blockfront.C0244ds;
import com.boehmod.blockfront.C0885px;
import com.boehmod.blockfront.C1043sv;
import com.boehmod.blockfront.C1089to;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/JoinReader.class */
@ApiStatus.Internal
class JoinReader {

    /* JADX INFO: renamed from: in */
    private final Reader f9185in;
    private LexerSource source;
    private boolean warnings;
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean trigraphs = false;
    private int newlines = 0;
    private boolean flushnl = false;
    private final int[] unget = new int[2];
    private int uptr = 0;

    static {
        $assertionsDisabled = !JoinReader.class.desiredAssertionStatus();
    }

    public JoinReader(String in) {
        this.f9185in = new StringReader(in);
    }

    public void setTrigraphs(boolean enable, boolean warnings) {
        this.trigraphs = enable;
        this.warnings = warnings;
    }

    void init(Preprocessor pp, LexerSource s) {
        this.source = s;
        setTrigraphs(pp.getFeature(Feature.TRIGRAPHS), pp.getWarning(Warning.TRIGRAPHS));
    }

    private int __read() {
        if (this.uptr > 0) {
            int[] iArr = this.unget;
            int i = this.uptr - 1;
            this.uptr = i;
            return iArr[i];
        }
        try {
            return this.f9185in.read();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private void _unread(int c) {
        if (c != -1) {
            int[] iArr = this.unget;
            int i = this.uptr;
            this.uptr = i + 1;
            iArr[i] = c;
        }
        if (!$assertionsDisabled && this.uptr > this.unget.length) {
            throw new AssertionError("JoinReader ungets too many characters");
        }
    }

    protected void warning(String msg) throws LexerException {
        if (this.source != null) {
            this.source.warning(msg);
            return;
        }
        throw new LexerException(msg);
    }

    private char trigraph(char raw, char repl) throws LexerException {
        if (this.trigraphs) {
            if (this.warnings) {
                warning("trigraph ??" + raw + " converted to " + repl);
            }
            return repl;
        }
        if (this.warnings) {
            warning("trigraph ??" + raw + " ignored");
        }
        _unread(raw);
        _unread(63);
        return '?';
    }

    private int _read() throws LexerException {
        int c = __read();
        if (c == 63 && (this.trigraphs || this.warnings)) {
            int d = __read();
            if (d == 63) {
                int e = __read();
                switch (e) {
                    case 33:
                        return trigraph('!', '|');
                    case 34:
                    case C1043sv.f5687sk /* 35 */:
                    case 36:
                    case C1089to.f5854tg /* 37 */:
                    case 38:
                    case 42:
                    case C1089to.f5856ti /* 43 */:
                    case 44:
                    case 46:
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
                    case 58:
                    case 59:
                    default:
                        _unread(e);
                        break;
                    case 39:
                        return trigraph('\'', '^');
                    case 40:
                        return trigraph('(', '[');
                    case 41:
                        return trigraph(')', ']');
                    case 45:
                        return trigraph('-', '~');
                    case 47:
                        return trigraph('/', '\\');
                    case 60:
                        return trigraph('<', '{');
                    case 61:
                        return trigraph('=', '#');
                    case NumericValue.FF_SIZE /* 62 */:
                        return trigraph('>', '}');
                }
            }
            _unread(d);
        }
        return c;
    }

    public int read() throws LexerException {
        if (this.flushnl) {
            if (this.newlines > 0) {
                this.newlines--;
                return 10;
            }
            this.flushnl = false;
        }
        while (true) {
            int c = _read();
            switch (c) {
                case -1:
                    if (this.newlines > 0) {
                        this.newlines--;
                        return 10;
                    }
                    break;
                case 10:
                case 11:
                case 12:
                case C0885px.f4841pt /* 13 */:
                case C0215dP.f1669hX /* 133 */:
                case 8232:
                case 8233:
                    this.flushnl = true;
                    return c;
                case 92:
                    int d = _read();
                    switch (d) {
                        case 10:
                            this.newlines++;
                            break;
                        case C0885px.f4841pt /* 13 */:
                            this.newlines++;
                            int e = _read();
                            if (e != 10) {
                                _unread(e);
                            }
                            break;
                        default:
                            _unread(d);
                            return c;
                    }
                    break;
            }
            return c;
        }
    }

    public String toString() {
        return "JoinReader(nl=" + this.newlines + ")";
    }
}
