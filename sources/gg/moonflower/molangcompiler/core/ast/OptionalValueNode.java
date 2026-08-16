package gg.moonflower.molangcompiler.core.ast;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/OptionalValueNode.class */
@ApiStatus.Internal
public interface OptionalValueNode extends Node {
    Node withReturnValue();
}
