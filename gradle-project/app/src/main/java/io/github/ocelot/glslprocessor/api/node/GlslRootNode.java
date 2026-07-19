package io.github.ocelot.glslprocessor.api.node;

import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslRootNode.class */
public interface GlslRootNode extends GlslNode {
    @Nullable
    String getName();

    GlslRootNode setName(@Nullable String str);

    default boolean isDeclaration() {
        return this instanceof GlslVariableDeclarationNode;
    }

    default boolean isFunction() {
        return this instanceof GlslFunctionNode;
    }

    default boolean isField() {
        return this instanceof GlslNewFieldNode;
    }

    default boolean isStruct() {
        return this instanceof GlslStructDeclarationNode;
    }

    default GlslVariableDeclarationNode asDeclaration() {
        if (this instanceof GlslVariableDeclarationNode) {
            GlslVariableDeclarationNode node = (GlslVariableDeclarationNode) this;
            return node;
        }
        throw new IllegalStateException("This node is not a GlslDeclarationNode");
    }

    default GlslFunctionNode asFunction() {
        if (this instanceof GlslFunctionNode) {
            GlslFunctionNode node = (GlslFunctionNode) this;
            return node;
        }
        throw new IllegalStateException("This node is not a GlslFunctionNode");
    }

    default GlslNewFieldNode asField() {
        if (this instanceof GlslNewFieldNode) {
            GlslNewFieldNode node = (GlslNewFieldNode) this;
            return node;
        }
        throw new IllegalStateException("This node is not a GlslNewNode");
    }

    default GlslStructDeclarationNode asStruct() {
        if (this instanceof GlslStructDeclarationNode) {
            GlslStructDeclarationNode node = (GlslStructDeclarationNode) this;
            return node;
        }
        throw new IllegalStateException("This node is not a GlslStructNode");
    }
}
