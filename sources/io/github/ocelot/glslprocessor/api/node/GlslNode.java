package io.github.ocelot.glslprocessor.api.node;

import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.node.constant.GlslBoolConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslDoubleConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslFloatConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslIntConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslIntFormat;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslNode.class */
@ApiStatus.NonExtendable
public interface GlslNode {
    void visit(GlslNodeVisitor glslNodeVisitor);

    GlslNodeType getNodeType();

    Stream<GlslNode> stream();

    default String toSourceString() {
        GlslNodeStringWriter visitor = new GlslNodeStringWriter(true);
        visit(visitor);
        visitor.trimSemicolon();
        return visitor.toString();
    }

    @Nullable
    default GlslSpecifiedType getType() {
        return null;
    }

    default List<GlslNode> toList() {
        return new ArrayList(Collections.singleton(this));
    }

    @Nullable
    default GlslNodeList getBody() {
        return null;
    }

    default boolean setBody(Collection<GlslNode> body) {
        GlslNodeList nodes = getBody();
        if (nodes != null) {
            nodes.clear();
            nodes.addAll(body);
            return true;
        }
        return false;
    }

    default boolean setBody(GlslNode... body) {
        return setBody(Arrays.asList(body));
    }

    static GlslIntConstantNode intConstant(int value) {
        return new GlslIntConstantNode(GlslIntFormat.DECIMAL, true, value);
    }

    static GlslIntConstantNode unsignedIntConstant(int value) {
        return new GlslIntConstantNode(GlslIntFormat.DECIMAL, false, value);
    }

    static GlslFloatConstantNode floatConstant(float value) {
        return new GlslFloatConstantNode(value);
    }

    static GlslDoubleConstantNode doubleConstant(double value) {
        return new GlslDoubleConstantNode(value);
    }

    static GlslBoolConstantNode booleanConstant(boolean value) {
        return new GlslBoolConstantNode(value);
    }

    static GlslNode compound(Collection<GlslNode> nodes) {
        if (nodes.isEmpty()) {
            return GlslEmptyNode.INSTANCE;
        }
        if (nodes.size() == 1) {
            return nodes.iterator().next();
        }
        List<GlslNode> list = new ArrayList<>();
        Iterator<GlslNode> it = nodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GlslNode node = it.next();
            if (!(node instanceof GlslCompoundNode)) {
                list.clear();
                list.addAll(nodes);
                break;
            }
            GlslCompoundNode compoundNode = (GlslCompoundNode) node;
            list.addAll(compoundNode.children);
        }
        return new GlslCompoundNode(list);
    }

    static GlslNode compound(GlslNode... nodes) {
        if (nodes.length == 0) {
            return GlslEmptyNode.INSTANCE;
        }
        if (nodes.length == 1) {
            return nodes[0];
        }
        return new GlslCompoundNode(new ArrayList(Arrays.asList(nodes)));
    }
}
