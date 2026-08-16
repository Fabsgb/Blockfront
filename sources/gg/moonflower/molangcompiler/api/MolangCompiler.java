package gg.moonflower.molangcompiler.api;

import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import gg.moonflower.molangcompiler.core.MolangCompilerImpl;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangCompiler.class */
public interface MolangCompiler {
    public static final int OPTIMIZE_FLAG = 1;
    public static final int WRITE_CLASSES_FLAG = 2;
    public static final int DEFAULT_FLAGS = 1;

    MolangExpression compile(String str) throws MolangSyntaxException;

    static MolangCompiler create() {
        return new MolangCompilerImpl(1);
    }

    static MolangCompiler create(int flags) {
        return new MolangCompilerImpl(flags);
    }

    static MolangCompiler create(int flags, ClassLoader parent) {
        return new MolangCompilerImpl(flags, parent);
    }
}
