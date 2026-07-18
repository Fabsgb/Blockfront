package gg.moonflower.molangcompiler.core;

import gg.moonflower.molangcompiler.api.MolangCompiler;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import gg.moonflower.molangcompiler.core.ast.Node;
import gg.moonflower.molangcompiler.core.compiler.BytecodeCompiler;
import gg.moonflower.molangcompiler.core.compiler.MolangLexer;
import gg.moonflower.molangcompiler.core.compiler.MolangParser;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/MolangCompilerImpl.class */
@ApiStatus.Internal
public class MolangCompilerImpl implements MolangCompiler {
    private final BytecodeCompiler compiler;

    public MolangCompilerImpl(int flags) {
        this.compiler = new BytecodeCompiler(flags);
    }

    public MolangCompilerImpl(int flags, ClassLoader classLoader) {
        this.compiler = new BytecodeCompiler(flags, classLoader);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangCompiler
    public MolangExpression compile(String input) throws MolangSyntaxException {
        MolangLexer.Token[] tokens = MolangLexer.createTokens(input);
        Node node = MolangParser.parseTokens(tokens);
        return this.compiler.build(node);
    }
}
