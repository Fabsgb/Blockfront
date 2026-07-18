package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import com.boehmod.blockfront.C0234dj;
import com.boehmod.blockfront.C0965rY;
import com.boehmod.blockfront.C1011sR;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/JoinReader.class */
@ApiStatus.Internal
class JoinReader {

    /* JADX INFO: renamed from: in */
    private final Reader f8799in;
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
        this.f8799in = new StringReader(in);
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
            return this.f8799in.read();
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
                    case C0965rY.f5110qj /* 35 */:
                    case 36:
                    case C1011sR.f5290rf /* 37 */:
                    case 38:
                    case 42:
                    case C1011sR.f5292rh /* 43 */:
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
                    case C0234dj.f1929ge /* 56 */:
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

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e5, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read() throws io.github.ocelot.glslprocessor.lib.anarres.cpp.LexerException {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.ocelot.glslprocessor.lib.anarres.cpp.JoinReader.read():int");
    }

    public String toString() {
        return "JoinReader(nl=" + this.newlines + ")";
    }
}
