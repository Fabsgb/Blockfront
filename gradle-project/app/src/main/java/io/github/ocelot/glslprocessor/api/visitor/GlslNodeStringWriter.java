package io.github.ocelot.glslprocessor.api.visitor;

import io.github.ocelot.glslprocessor.api.grammar.GlslFunctionHeader;
import io.github.ocelot.glslprocessor.api.grammar.GlslParameterDeclaration;
import io.github.ocelot.glslprocessor.api.grammar.GlslSpecifiedType;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructField;
import io.github.ocelot.glslprocessor.api.grammar.GlslStructSpecifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeQualifier;
import io.github.ocelot.glslprocessor.api.grammar.GlslTypeSpecifier;
import io.github.ocelot.glslprocessor.api.node.GlslNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslCaseLabelNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslForLoopNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslIfNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslJumpNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslReturnNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslSwitchNode;
import io.github.ocelot.glslprocessor.api.node.branch.GlslWhileLoopNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslBoolConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslDoubleConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslFloatConstantNode;
import io.github.ocelot.glslprocessor.api.node.constant.GlslIntConstantNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslAssignmentNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslBitwiseNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslCompareNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslConditionalNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslOperationNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslPrecisionNode;
import io.github.ocelot.glslprocessor.api.node.expression.GlslUnaryNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslInvokeFunctionNode;
import io.github.ocelot.glslprocessor.api.node.function.GlslPrimitiveConstructorNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslGetArrayNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslGetFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslNewFieldNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslStructDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableDeclarationNode;
import io.github.ocelot.glslprocessor.api.node.variable.GlslVariableNode;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/visitor/GlslNodeStringWriter.class */
public final class GlslNodeStringWriter extends GlslNodeVisitor {
    private final String prefix;
    private final String base;
    private final StringBuilder builder;
    private final boolean forceInline;

    public GlslNodeStringWriter(boolean inline) {
        this("", "", new StringBuilder(), inline);
    }

    private GlslNodeStringWriter(String base, String prefix, StringBuilder builder, boolean forceInline) {
        this.base = base;
        this.prefix = prefix;
        this.builder = builder;
        this.forceInline = forceInline;
    }

    @ApiStatus.Internal
    public GlslNodeStringWriter indent() {
        return new GlslNodeStringWriter(this.prefix + this.base, "\t", this.builder, this.forceInline);
    }

    @ApiStatus.Internal
    public GlslNodeStringWriter inline() {
        return new GlslNodeStringWriter("", "", this.builder, true);
    }

    private void accept(CharSequence text, boolean inline, boolean semicolon) {
        this.builder.append(text);
        if (semicolon) {
            this.builder.append(';');
        }
        if (!inline && !this.forceInline) {
            this.builder.append('\n');
        }
    }

    private void addIndent() {
        if (!this.forceInline) {
            this.builder.append(this.base).append(this.prefix);
        }
    }

    private void acceptClosing() {
        this.builder.append(this.base).append(this.forceInline ? "}" : "}\n");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void visitTypeQualifier(GlslTypeQualifier glslTypeQualifier) {
        if (glslTypeQualifier instanceof GlslTypeQualifier.StorageSubroutine) {
            GlslTypeQualifier.StorageSubroutine storageSubroutine = (GlslTypeQualifier.StorageSubroutine) glslTypeQualifier;
            String[] typeNames = storageSubroutine.typeNames();
            if (typeNames.length > 0) {
                this.builder.append("subroutine(").append(String.join(",", typeNames)).append(")");
                return;
            } else {
                this.builder.append("subroutine");
                return;
            }
        }
        if (!(glslTypeQualifier instanceof GlslTypeQualifier.Layout)) {
            if (glslTypeQualifier instanceof GlslTypeQualifier.Precision) {
                GlslTypeQualifier.Precision precision = (GlslTypeQualifier.Precision) glslTypeQualifier;
                switch (precision) {
                    case HIGH_PRECISION:
                        this.builder.append("highp");
                        break;
                    case MEDIUM_PRECISION:
                        this.builder.append("mediump");
                        break;
                    case LOW_PRECISION:
                        this.builder.append("lowp");
                        break;
                }
                return;
            }
            this.builder.append(((Enum) glslTypeQualifier).name().toLowerCase(Locale.ROOT));
            return;
        }
        GlslTypeQualifier.Layout layout = (GlslTypeQualifier.Layout) glslTypeQualifier;
        GlslNodeVisitor visitor = inline();
        this.builder.append("layout(");
        for (GlslTypeQualifier.LayoutId layoutId : layout.layoutIds()) {
            this.builder.append(layoutId.identifier());
            GlslNode expression = layoutId.expression();
            if (expression != null) {
                this.builder.append(" = ");
                expression.visit(visitor);
            }
            this.builder.append(", ");
        }
        if (!layout.layoutIds().isEmpty()) {
            this.builder.delete(this.builder.length() - 2, this.builder.length());
        }
        this.builder.append(')');
    }

    private void visitArraySuffix(GlslTypeSpecifier specifier) {
        if (specifier instanceof GlslTypeSpecifier.Array) {
            GlslTypeSpecifier.Array array = (GlslTypeSpecifier.Array) specifier;
            GlslNode size = array.getSize();
            if (size != null) {
                this.builder.append('[');
                size.visit(inline());
                trimSemicolon();
                this.builder.append("]");
                return;
            }
            this.builder.append("[]");
        }
    }

    public void trimSemicolon() {
        if (this.builder.codePointAt(this.builder.length() - 1) == 59) {
            this.builder.deleteCharAt(this.builder.length() - 1);
        }
    }

    public void visitTypeSpecifier(GlslTypeSpecifier typeSpecifier) {
        if (!typeSpecifier.isStruct()) {
            this.builder.append(typeSpecifier.getName());
            return;
        }
        GlslStructSpecifier structSpecifier = typeSpecifier.asStructSpecifier();
        addIndent();
        accept(structSpecifier.getName() + " {", false, false);
        for (GlslStructField field : structSpecifier.getFields()) {
            addIndent();
            this.builder.append('\t');
            visitSpecifiedType(field.getType());
            this.builder.append(' ').append(field.getName());
            visitArraySuffix(field.getType().getSpecifier());
            accept("", false, true);
        }
        addIndent();
        accept("}", true, false);
    }

    public void visitSpecifiedType(GlslSpecifiedType type) {
        GlslTypeSpecifier specifier = type.getSpecifier();
        boolean block = false;
        for (GlslTypeQualifier qualifier : type.getQualifiers()) {
            visitTypeQualifier(qualifier);
            this.builder.append(' ');
            if (qualifier == GlslTypeQualifier.StorageType.UNIFORM || qualifier == GlslTypeQualifier.StorageType.BUFFER) {
                block = true;
            }
        }
        if (specifier.isStruct() && !block) {
            this.builder.append("struct ");
        }
        visitTypeSpecifier(specifier);
    }

    public void visitFunctionHeader(GlslFunctionHeader header) {
        GlslSpecifiedType returnType = header.getReturnType();
        visitSpecifiedType(returnType);
        visitArraySuffix(returnType.getSpecifier());
        this.builder.append(' ');
        this.builder.append(header.getName());
        this.builder.append('(');
        List<GlslParameterDeclaration> parameters = header.getParameters();
        for (GlslParameterDeclaration parameter : parameters) {
            String name = parameter.getName();
            GlslSpecifiedType type = parameter.getType();
            visitSpecifiedType(type);
            if (name != null) {
                this.builder.append(' ');
                this.builder.append(name);
            }
            visitArraySuffix(type.getSpecifier());
            this.builder.append(", ");
        }
        if (!parameters.isEmpty()) {
            this.builder.delete(this.builder.length() - 2, this.builder.length());
        }
        this.builder.append(')');
    }

    public void clear() {
        this.builder.setLength(0);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public GlslNodeVisitor visitForLoop(GlslForLoopNode node) {
        GlslNodeStringWriter inline = inline();
        this.builder.append(this.base).append(this.prefix);
        this.builder.append("for(");
        node.getInit().visit(inline);
        trimSemicolon();
        trimSemicolon();
        this.builder.append("; ");
        node.getCondition().visit(inline);
        trimSemicolon();
        this.builder.append(';');
        if (node.getIncrement() != null) {
            this.builder.append(' ');
            node.getIncrement().visit(inline);
            trimSemicolon();
        }
        this.builder.append(this.forceInline ? ") {" : ") {\n");
        return indent();
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitForLoopEnd(GlslForLoopNode node) {
        acceptClosing();
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public GlslNodeVisitor visitWhileLoop(GlslWhileLoopNode node) {
        GlslNodeStringWriter inline = inline();
        this.builder.append(this.base).append(this.prefix);
        this.builder.append("while(");
        node.getCondition().visit(inline);
        trimSemicolon();
        this.builder.append(this.forceInline ? ") {" : ") {\n");
        return indent();
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitWhileLoopEnd(GlslWhileLoopNode node) {
        acceptClosing();
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitJump(GlslJumpNode node) {
        addIndent();
        switch (node) {
            case CONTINUE:
                accept("continue", false, true);
                break;
            case BREAK:
                accept("break", false, true);
                break;
            case DISCARD:
                accept("discard", false, true);
                break;
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitReturn(GlslReturnNode node) {
        addIndent();
        GlslNode value = node.getValue();
        if (value != null) {
            accept("return ", true, false);
            value.visit(new GlslNodeStringWriter("", "", this.builder, true));
        } else {
            accept("return", false, false);
        }
        trimSemicolon();
        accept("", false, true);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public GlslIfVisitor visitIf(GlslIfNode node) {
        addIndent();
        accept("if(", true, false);
        node.getExpression().visit(inline());
        trimSemicolon();
        accept(") {", false, false);
        return new GlslIfVisitor() { // from class: io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter.1
            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslIfVisitor
            public GlslNodeVisitor visitIf() {
                return GlslNodeStringWriter.this.indent();
            }

            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslIfVisitor
            public GlslNodeVisitor visitElse() {
                GlslNodeStringWriter.this.addIndent();
                GlslNodeStringWriter.this.accept("} else {", false, false);
                return GlslNodeStringWriter.this.indent();
            }

            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslIfVisitor
            public void visitIfEnd(GlslIfNode node2) {
                GlslNodeStringWriter.this.addIndent();
                GlslNodeStringWriter.this.accept("}", false, false);
            }
        };
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public GlslSwitchVisitor visitSwitch(GlslSwitchNode node) {
        addIndent();
        accept("switch(", true, false);
        node.getCondition().visit(inline());
        trimSemicolon();
        accept(") {", false, false);
        final GlslNodeStringWriter indent = indent();
        return new GlslSwitchVisitor() { // from class: io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter.2
            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslSwitchVisitor
            public GlslNodeVisitor visitLabel(GlslCaseLabelNode node2) {
                indent.addIndent();
                if (node2.isDefault()) {
                    indent.accept("default:", false, false);
                } else {
                    indent.accept("case ", true, false);
                    node2.getCondition().visit(indent.inline());
                    GlslNodeStringWriter.this.trimSemicolon();
                    indent.accept(":", false, false);
                }
                return indent.indent();
            }

            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslSwitchVisitor
            public void visitSwitchEnd(GlslSwitchNode node2) {
                indent.acceptClosing();
            }
        };
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public GlslBitwiseVisitor visitBitwise(final GlslBitwiseNode node) {
        this.builder.append('(');
        return new GlslBitwiseVisitor() { // from class: io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter.3
            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslBitwiseVisitor
            public GlslNodeVisitor visitNode(int index) {
                if (index != 0) {
                    GlslNodeStringWriter.this.trimSemicolon();
                    GlslNodeStringWriter.this.builder.append(' ').append(node.getOperand().getDelimiter()).append(' ');
                }
                return GlslNodeStringWriter.this.inline();
            }

            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslBitwiseVisitor
            public void visitBitwiseExpressionEnd(GlslBitwiseNode node2) {
                GlslNodeStringWriter.this.trimSemicolon();
                GlslNodeStringWriter.this.builder.append(')');
            }
        };
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitAssign(GlslAssignmentNode node) {
        GlslNodeStringWriter inline = inline();
        addIndent();
        node.getFirst().visit(inline);
        trimSemicolon();
        this.builder.append(' ');
        this.builder.append(node.getOperand().getDelimiter());
        this.builder.append(' ');
        node.getSecond().visit(inline);
        trimSemicolon();
        accept("", false, true);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitOperation(GlslOperationNode node) {
        GlslNodeStringWriter inline = inline();
        addIndent();
        this.builder.append('(');
        node.getFirst().visit(inline);
        trimSemicolon();
        this.builder.append(' ');
        this.builder.append(node.getOperand().getDelimiter());
        this.builder.append(' ');
        node.getSecond().visit(inline);
        trimSemicolon();
        accept(")", false, false);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitCompare(GlslCompareNode node) {
        GlslNodeStringWriter inline = inline();
        addIndent();
        node.getFirst().visit(inline);
        trimSemicolon();
        this.builder.append(' ');
        this.builder.append(node.getOperand().getDelimiter());
        this.builder.append(' ');
        node.getSecond().visit(inline);
        trimSemicolon();
        accept("", false, false);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitCondition(GlslConditionalNode node) {
        GlslNodeStringWriter inline = inline();
        addIndent();
        node.getCondition().visit(inline);
        trimSemicolon();
        this.builder.append(" ? ");
        node.getFirst().visit(inline);
        trimSemicolon();
        this.builder.append(" : ");
        node.getSecond().visit(inline);
        trimSemicolon();
        accept("", false, false);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitPrecision(GlslPrecisionNode node) {
        addIndent();
        this.builder.append("precision ");
        visitTypeQualifier(node.getPrecision());
        this.builder.append(" ");
        visitTypeSpecifier(node.getTypeSpecifier());
        accept("", false, true);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitUnary(GlslUnaryNode node) {
        GlslUnaryNode.Operand operand = node.getOperand();
        GlslNode expression = node.getExpression();
        switch (operand) {
            case PRE_INCREMENT:
            case PRE_DECREMENT:
            case PLUS:
            case DASH:
            case BANG:
            case TILDE:
                this.builder.append(operand.getDelimiter());
                boolean simple = (expression instanceof GlslConstantNode) || (expression instanceof GlslGetArrayNode) || (expression instanceof GlslGetFieldNode) || (expression instanceof GlslVariableNode);
                if (!simple) {
                    this.builder.append('(');
                }
                expression.visit(inline());
                trimSemicolon();
                if (!simple) {
                    this.builder.append(')');
                }
                break;
            case POST_INCREMENT:
            case POST_DECREMENT:
                expression.visit(inline());
                trimSemicolon();
                this.builder.append(operand.getDelimiter());
                break;
        }
    }

    public GlslNodeVisitor visitFunctionDeclaration(GlslFunctionNode node) {
        visitFunctionHeader(node.getHeader());
        accept(" {", false, false);
        if (node.getBody() == null) {
            accept("", false, true);
            return null;
        }
        return indent();
    }

    public void visitFunctionDeclarationEnd(GlslFunctionNode node) {
        acceptClosing();
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public GlslInvokeVisitor visitFunctionInvocation(final GlslInvokeFunctionNode node) {
        return new GlslInvokeVisitor() { // from class: io.github.ocelot.glslprocessor.api.visitor.GlslNodeStringWriter.4
            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslInvokeVisitor
            public void visitHeader() {
                GlslNodeStringWriter.this.addIndent();
                node.getHeader().visit(GlslNodeStringWriter.this.inline());
                GlslNodeStringWriter.this.trimSemicolon();
                GlslNodeStringWriter.this.builder.append('(');
            }

            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslInvokeVisitor
            public GlslNodeVisitor visitParameter(int index) {
                GlslNodeStringWriter.this.trimSemicolon();
                if (index > 0) {
                    GlslNodeStringWriter.this.builder.append(", ");
                }
                return GlslNodeStringWriter.this.inline();
            }

            @Override // io.github.ocelot.glslprocessor.api.visitor.GlslInvokeVisitor
            public void visitInvokeEnd(GlslInvokeFunctionNode node2) {
                GlslNodeStringWriter.this.trimSemicolon();
                GlslNodeStringWriter.this.accept(")", false, true);
            }
        };
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitPrimitiveConstructor(GlslPrimitiveConstructorNode node) {
        addIndent();
        visitTypeSpecifier(node.getPrimitiveType());
        visitArraySuffix(node.getPrimitiveType());
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitConstant(GlslConstantNode node) {
        addIndent();
        if (node instanceof GlslDoubleConstantNode) {
            accept(node.doubleValue() + "lf", false, false);
            return;
        }
        if (node instanceof GlslFloatConstantNode) {
            accept(Float.toString(node.floatValue()), false, false);
            return;
        }
        if (node instanceof GlslBoolConstantNode) {
            accept(Boolean.toString(node.booleanValue()), false, false);
            return;
        }
        if (node instanceof GlslIntConstantNode) {
            GlslIntConstantNode constantNode = (GlslIntConstantNode) node;
            int value = node.intValue();
            switch (constantNode.format()) {
                case HEXADECIMAL:
                    this.builder.append("0x%X".formatted(Integer.valueOf(value)));
                    break;
                case OCTAL:
                    this.builder.append(value > 0 ? "0" : "").append(Integer.toOctalString(value));
                    break;
                case DECIMAL:
                    this.builder.append(value);
                    break;
            }
            if (!constantNode.signed()) {
                this.builder.append('u');
            }
        }
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitVariableDeclaration(GlslVariableDeclarationNode node) {
        addIndent();
        for (GlslTypeQualifier qualifier : node.getTypeQualifiers()) {
            visitTypeQualifier(qualifier);
            this.builder.append(' ');
        }
        for (String name : node.getNames()) {
            this.builder.append(name).append(", ");
        }
        if (!node.getNames().isEmpty()) {
            this.builder.delete(this.builder.length() - 2, this.builder.length());
        }
        trimSemicolon();
        accept("", false, true);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitGetArray(GlslGetArrayNode node) {
        GlslNodeStringWriter inline = inline();
        addIndent();
        node.getExpression().visit(inline);
        trimSemicolon();
        this.builder.append('[');
        node.getIndex().visit(inline);
        trimSemicolon();
        this.builder.append(']');
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitGetField(GlslGetFieldNode node) {
        addIndent();
        node.getExpression().visit(inline());
        trimSemicolon();
        this.builder.append('.');
        this.builder.append(node.getFieldSelection());
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitNewField(GlslNewFieldNode node) {
        addIndent();
        visitSpecifiedType(node.getType());
        String name = node.getName();
        if (name != null) {
            this.builder.append(' ').append(name);
            visitArraySuffix(node.getType().getSpecifier());
            GlslNode initializer = node.getInitializer();
            if (initializer != null) {
                this.builder.append(" = ");
                initializer.visit(inline());
                trimSemicolon();
            }
        }
        accept("", false, true);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitStructDeclaration(GlslStructDeclarationNode node) {
        addIndent();
        visitSpecifiedType(node.getSpecifiedType());
        accept("", false, true);
    }

    @Override // io.github.ocelot.glslprocessor.api.visitor.GlslNodeVisitor
    public void visitVariable(GlslVariableNode node) {
        addIndent();
        this.builder.append(node.getName());
    }

    public String toString() {
        this.builder.trimToSize();
        return this.builder.toString();
    }
}
