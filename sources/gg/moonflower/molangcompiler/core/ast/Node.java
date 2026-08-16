package gg.moonflower.molangcompiler.core.ast;

import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.core.compiler.MolangBytecodeEnvironment;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/Node.class */
@ApiStatus.Internal
public interface Node {
    String toString();

    boolean isConstant();

    boolean hasValue();

    default float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        throw new MolangException("Cannot statically evaluate " + getClass().getSimpleName());
    }

    default void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        throw new MolangException("Not implemented (" + getClass().getSimpleName() + " " + this + ")");
    }
}
