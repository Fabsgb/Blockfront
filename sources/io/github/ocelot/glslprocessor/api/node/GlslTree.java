package io.github.ocelot.glslprocessor.api.node;

import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslVersionStatement;
import io.github.ocelot.glslprocessor.api.node.branch.GlslIfNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor;
import io.github.ocelot.glslprocessor.api.visitor.GlslTreeStringWriter;
import io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslTree.class */
public final class GlslTree {
    private final GlslVersionStatement versionStatement;
    private final GlslNodeList body;
    private final List<String> directives;
    private final Map<String, GlslNode> markers;
    private final Map<String, String> macros;

    public GlslTree() {
        this.versionStatement = new GlslVersionStatement();
        this.body = new GlslNodeList();
        this.directives = new ArrayList();
        this.markers = Collections.emptyMap();
        this.macros = new HashMap();
    }

    public GlslTree(GlslVersionStatement versionStatement, Collection<GlslNode> body, Collection<String> directives, Map<String, GlslNode> markers) {
        this.versionStatement = versionStatement;
        this.body = new GlslNodeList(body);
        this.directives = new ArrayList(directives);
        this.markers = Collections.unmodifiableMap(markers);
        this.macros = new HashMap();
    }

    private void visit(GlslTreeVisitor visitor, GlslNode node) {
        if (node instanceof GlslFunctionNode) {
            GlslFunctionNode functionNode = (GlslFunctionNode) node;
            GlslNodeVisitor functionVisitor = visitor.visitFunction(functionNode);
            if (functionVisitor != null) {
                functionNode.visit(functionVisitor);
            }
            visitor.visitFunctionEnd(functionNode);
            return;
        }
        if (node instanceof GlslNewFieldNode) {
            GlslNewFieldNode newNode = (GlslNewFieldNode) node;
            visitor.visitNewField(newNode);
        } else if (node instanceof GlslStructDeclarationNode) {
            GlslStructDeclarationNode struct = (GlslStructDeclarationNode) node;
            visitor.visitStructDeclaration(struct);
        } else {
            if (node instanceof GlslVariableDeclarationNode) {
                GlslVariableDeclarationNode declaration = (GlslVariableDeclarationNode) node;
                visitor.visitDeclaration(declaration);
                return;
            }
            throw new AssertionError("Not Possible: " + node.getClass());
        }
    }

    public void visit(GlslTreeVisitor visitor) {
        visitor.visitMarkers(this.markers);
        visitor.visitVersion(this.versionStatement);
        for (String directive : this.directives) {
            visitor.visitDirective(directive);
        }
        for (Map.Entry<String, String> entry : this.macros.entrySet()) {
            visitor.visitMacro(entry.getKey(), entry.getValue());
        }
        for (GlslNode node : this.body) {
            if (!(node instanceof GlslEmptyNode)) {
                if (node instanceof GlslCompoundNode) {
                    GlslCompoundNode compoundNode = (GlslCompoundNode) node;
                    for (GlslNode child : compoundNode.children) {
                        visit(visitor, child);
                    }
                } else {
                    visit(visitor, node);
                }
            }
        }
        visitor.visitTreeEnd(this);
    }

    public void markOutputs() {
        final List<GlslNewFieldNode> outputs = new ArrayList<>();
        visit(new GlslTreeVisitor() { // from class: io.github.ocelot.glslprocessor.api.node.GlslTree.1
            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslTreeVisitor
            public void visitNewField(GlslNewFieldNode node) {
                GlslNode expression;
                GlslSpecifiedType type = node.getType();
                boolean valid = false;
                Iterator<GlslTypeQualifier> it = type.getQualifiers().iterator();
                while (it.hasNext()) {
                    if (it.next() == GlslTypeQualifier.StorageType.OUT) {
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    return;
                }
                for (GlslTypeQualifier qualifier : type.getQualifiers()) {
                    if (qualifier instanceof GlslTypeQualifier.Layout) {
                        GlslTypeQualifier.Layout layout = (GlslTypeQualifier.Layout) qualifier;
                        for (GlslTypeQualifier.LayoutId layoutId : layout.layoutIds()) {
                            if ("location".equals(layoutId.identifier()) && (expression = layoutId.expression()) != null) {
                                try {
                                    int location = Integer.parseInt(expression.toSourceString());
                                    if (location == 0) {
                                        outputs.clear();
                                        return;
                                    } else {
                                        valid = false;
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                }
                            }
                        }
                    }
                }
                if (valid) {
                    outputs.add(node);
                }
            }
        });
        for (GlslNewFieldNode output : outputs) {
            output.getType().addLayoutId("location", GlslNode.intConstant(0));
        }
    }

    public Optional<GlslFunctionNode> mainFunction() {
        return functions().filter(node -> {
            return node.getHeader().getName().equals("main");
        }).findFirst();
    }

    public Stream<GlslFunctionNode> functions() {
        return this.body.stream().filter(node -> {
            return node instanceof GlslFunctionNode;
        }).map(node2 -> {
            return (GlslFunctionNode) node2;
        });
    }

    public Optional<GlslNewFieldNode> field(String name) {
        return this.body.stream().filter(node -> {
            if (node instanceof GlslNewFieldNode) {
                GlslNewFieldNode newNode = (GlslNewFieldNode) node;
                if (name.equals(newNode.getName())) {
                    return true;
                }
            }
            return false;
        }).findFirst().map(newNode -> {
            return (GlslNewFieldNode) newNode;
        });
    }

    public Stream<GlslNewFieldNode> fields() {
        return this.body.stream().filter(node -> {
            return node instanceof GlslNewFieldNode;
        }).map(node2 -> {
            return (GlslNewFieldNode) node2;
        });
    }

    public Stream<GlslNewFieldNode> searchField(String name) {
        return this.body.stream().flatMap((v0) -> {
            return v0.stream();
        }).filter(node -> {
            if (node instanceof GlslNewFieldNode) {
                GlslNewFieldNode newNode = (GlslNewFieldNode) node;
                if (name.equals(newNode.getName())) {
                    return true;
                }
            }
            return false;
        }).map(node2 -> {
            return (GlslNewFieldNode) node2;
        });
    }

    public Optional<GlslBlock> containingBlock(GlslNode node) {
        GlslBlock block = containingBlock(this.body, node);
        return (block == null || block.body != this.body) ? Optional.ofNullable(block) : Optional.of(new GlslBlock(mainFunction().orElseThrow().getBody(), 0));
    }

    @Nullable
    private GlslBlock containingBlock(GlslNodeList body, GlslNode node) {
        GlslBlock found;
        for (int i = 0; i < body.size(); i++) {
            GlslNode element = body.get(i);
            if (element == node) {
                return new GlslBlock(body, i);
            }
            if (element instanceof GlslIfNode) {
                GlslIfNode selectionNode = (GlslIfNode) element;
                GlslBlock firstFound = containingBlock(selectionNode.getFirst(), node);
                if (firstFound != null) {
                    return firstFound;
                }
                GlslBlock secondFound = containingBlock(selectionNode.getSecond(), node);
                if (secondFound != null) {
                    return secondFound;
                }
            }
            GlslNodeList elementBody = element.getBody();
            if (elementBody != null && (found = containingBlock(elementBody, node)) != null) {
                return found;
            }
        }
        return null;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock.class */
    public static final class GlslBlock extends Record {
        private final GlslNodeList body;
        private final int index;

        public GlslBlock(GlslNodeList body, int index) {
            this.body = body;
            this.index = index;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GlslBlock.class), GlslBlock.class, "body;index", "FIELD:Lio/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock;->body:Lio/github/ocelot/glslprocessor/api/node/GlslNodeList;", "FIELD:Lio/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock;->index:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GlslBlock.class), GlslBlock.class, "body;index", "FIELD:Lio/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock;->body:Lio/github/ocelot/glslprocessor/api/node/GlslNodeList;", "FIELD:Lio/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock;->index:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GlslBlock.class, Object.class), GlslBlock.class, "body;index", "FIELD:Lio/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock;->body:Lio/github/ocelot/glslprocessor/api/node/GlslNodeList;", "FIELD:Lio/github/ocelot/glslprocessor/api/node/GlslTree$GlslBlock;->index:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public GlslNodeList body() {
            return this.body;
        }

        public int index() {
            return this.index;
        }

        public GlslNode node() {
            return this.body.get(this.index);
        }
    }

    public GlslVersionStatement getVersionStatement() {
        return this.versionStatement;
    }

    public List<String> getDirectives() {
        return this.directives;
    }

    public Map<String, GlslNode> getMarkers() {
        return this.markers;
    }

    public Map<String, String> getMacros() {
        return this.macros;
    }

    public GlslNodeList getBody() {
        return this.body;
    }

    public String toSourceString() {
        GlslTreeStringWriter writer = new GlslTreeStringWriter();
        visit(writer);
        return writer.toString();
    }

    public static void stripGLMacros(Map<String, String> macros) {
        macros.keySet().removeIf(macro -> {
            return macro.startsWith("GL_");
        });
        macros.remove("__VERSION__");
    }

    public String toString() {
        return "GlslTree{version=" + this.versionStatement + ", body=" + this.body + "}";
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslTree glslTree = (GlslTree) o;
        return this.versionStatement.equals(glslTree.versionStatement) && this.body.equals(glslTree.body) && this.directives.equals(glslTree.directives);
    }

    public int hashCode() {
        int result = this.versionStatement.hashCode();
        return (31 * ((31 * result) + this.body.hashCode())) + this.directives.hashCode();
    }
}
