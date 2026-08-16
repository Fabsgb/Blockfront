package foundry.veil.impl.client.render.shader.injection;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/InjectionBodyParser.class */
@ApiStatus.Internal
public final class InjectionBodyParser {
    private static final Pattern VERSION_PATTERN = Pattern.compile("^\\s*#version\\s+(\\d+)\\s*.*$", 8);

    public static Result parse(String code) {
        int version = parseVersion(code);
        String trimmed = code.trim();
        int funcStart = -1;
        boolean isHead = true;
        int bracePos = -1;
        if (trimmed.startsWith("void tail(")) {
            funcStart = 0;
            isHead = false;
            bracePos = trimmed.indexOf(123);
        } else if (trimmed.startsWith("void head(")) {
            funcStart = 0;
            bracePos = trimmed.indexOf(123);
        } else {
            int idx = trimmed.indexOf("\nvoid tail(");
            if (idx >= 0) {
                funcStart = idx + 1;
                isHead = false;
                bracePos = trimmed.indexOf(123, funcStart);
            } else {
                int idx2 = trimmed.indexOf("\nvoid head(");
                if (idx2 >= 0) {
                    funcStart = idx2 + 1;
                    bracePos = trimmed.indexOf(123, funcStart);
                }
            }
        }
        if (bracePos < 0) {
            return new Result("", "", true, version);
        }
        int depth = 0;
        int bodyStart = -1;
        int i = bracePos;
        while (i < trimmed.length()) {
            char c = trimmed.charAt(i);
            int skip = skipIfCommentOrString(trimmed, i);
            if (skip >= 0) {
                i = skip;
            } else if (c == '{') {
                if (depth == 0) {
                    bodyStart = i + 1;
                }
                depth++;
            } else if (c == '}') {
                depth--;
                if (depth == 0) {
                    String bodyStr = trimmed.substring(bodyStart, i).trim();
                    String rawGlobals = trimmed.substring(0, funcStart) + trimmed.substring(i + 1);
                    String globalsStr = stripNonCode(rawGlobals);
                    return new Result(bodyStr, globalsStr, isHead, version);
                }
            } else {
                continue;
            }
            i++;
        }
        return new Result("", "", true, version);
    }

    private static int skipString(CharSequence s, int pos) {
        int i = pos + 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '\\') {
                i++;
            } else if (c == '\"') {
                return i;
            }
            i++;
        }
        return s.length() - 1;
    }

    private static int skipLineComment(CharSequence s, int pos) {
        for (int i = pos + 2; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                return i;
            }
        }
        return s.length() - 1;
    }

    private static int skipBlockComment(CharSequence s, int pos) {
        for (int i = pos + 2; i < s.length() - 1; i++) {
            if (s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                return i + 1;
            }
        }
        return s.length() - 1;
    }

    private static int parseVersion(String code) {
        Matcher m = VERSION_PATTERN.matcher(code);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        return -1;
    }

    private static String stripNonCode(String s) {
        StringBuilder out = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int skip = skipIfCommentOrString(s, i);
            if (skip >= 0) {
                if (s.charAt(i) == '\"') {
                    out.append((CharSequence) s, i, skip + 1);
                }
                i = skip;
            } else {
                out.append(s.charAt(i));
            }
            i++;
        }
        return out.toString().trim();
    }

    private static int skipIfCommentOrString(CharSequence s, int i) {
        char c = s.charAt(i);
        if (c == '\"') {
            return skipString(s, i);
        }
        if (c == '/' && i + 1 < s.length()) {
            char n = s.charAt(i + 1);
            if (n == '/') {
                return skipLineComment(s, i);
            }
            if (n == '*') {
                return skipBlockComment(s, i);
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result.class */
    public static final class Result extends Record {
        private final String body;
        private final String globals;
        private final boolean isHead;
        private final int version;

        public Result(String body, String globals, boolean isHead, int version) {
            this.body = body;
            this.globals = globals;
            this.isHead = isHead;
            this.version = version;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Result.class), Result.class, "body;globals;isHead;version", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->body:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->globals:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->isHead:Z", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->version:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Result.class), Result.class, "body;globals;isHead;version", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->body:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->globals:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->isHead:Z", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->version:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Result.class, Object.class), Result.class, "body;globals;isHead;version", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->body:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->globals:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->isHead:Z", "FIELD:Lfoundry/veil/impl/client/render/shader/injection/InjectionBodyParser$Result;->version:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String body() {
            return this.body;
        }

        public String globals() {
            return this.globals;
        }

        public boolean isHead() {
            return this.isHead;
        }

        public int version() {
            return this.version;
        }
    }
}
