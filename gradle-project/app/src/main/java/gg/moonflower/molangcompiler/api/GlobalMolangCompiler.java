package gg.moonflower.molangcompiler.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/GlobalMolangCompiler.class */
public final class GlobalMolangCompiler {
    private static final Map<Integer, MolangCompiler> GLOBAL_COMPILERS = new ConcurrentHashMap();

    public static MolangCompiler get() {
        return get(1);
    }

    public static MolangCompiler get(int flags) {
        return GLOBAL_COMPILERS.computeIfAbsent(Integer.valueOf(flags), (v0) -> {
            return MolangCompiler.create(v0);
        });
    }

    public static void clear() {
        GLOBAL_COMPILERS.clear();
    }
}
