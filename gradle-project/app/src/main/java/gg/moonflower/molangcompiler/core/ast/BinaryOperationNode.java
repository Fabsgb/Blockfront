package gg.moonflower.molangcompiler.core.ast;

import com.boehmod.blockfront.C0244ds;
import com.boehmod.blockfront.C0885px;
import com.boehmod.blockfront.C0994s;
import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import gg.moonflower.molangcompiler.core.compiler.BytecodeCompiler;
import gg.moonflower.molangcompiler.core.compiler.MolangBytecodeEnvironment;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/BinaryOperationNode.class */
@ApiStatus.Internal
public final class BinaryOperationNode extends Record implements Node {
    private final BinaryOperation operator;
    private final Node left;
    private final Node right;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BinaryOperationNode.class), BinaryOperationNode.class, "operator;left;right", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryOperationNode;->operator:Lgg/moonflower/molangcompiler/core/ast/BinaryOperation;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryOperationNode;->left:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryOperationNode;->right:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BinaryOperationNode.class, Object.class), BinaryOperationNode.class, "operator;left;right", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryOperationNode;->operator:Lgg/moonflower/molangcompiler/core/ast/BinaryOperation;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryOperationNode;->left:Lgg/moonflower/molangcompiler/core/ast/Node;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/BinaryOperationNode;->right:Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public BinaryOperation operator() {
        return this.operator;
    }

    public Node left() {
        return this.left;
    }

    public Node right() {
        return this.right;
    }

    public BinaryOperationNode(BinaryOperation operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        return "(" + this.left + " " + this.operator + " " + this.right + ")";
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        return this.left.isConstant() && (this.operator == BinaryOperation.NULL_COALESCING || this.right.isConstant());
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        float left = this.left.evaluate(environment);
        float right = this.right.evaluate(environment);
        switch (C14721.$SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[this.operator.ordinal()]) {
            case 1:
                return left + right;
            case 2:
                return left - right;
            case 3:
                return left * right;
            case 4:
                return left / right;
            case 5:
                return (left == 0.0f || right == 0.0f) ? 0.0f : 1.0f;
            case 6:
                return (left == 0.0f && right == 0.0f) ? 0.0f : 1.0f;
            case C0994s.f5462C /* 7 */:
                return left < right ? 1.0f : 0.0f;
            case 8:
                return left <= right ? 1.0f : 0.0f;
            case 9:
                return left > right ? 1.0f : 0.0f;
            case 10:
                return left >= right ? 1.0f : 0.0f;
            case 11:
                return left == right ? 1.0f : 0.0f;
            case 12:
                return left != right ? 1.0f : 0.0f;
            case C0885px.f4841pt /* 13 */:
                return left;
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    /* JADX INFO: renamed from: gg.moonflower.molangcompiler.core.ast.BinaryOperationNode$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/BinaryOperationNode$1.class */
    static /* synthetic */ class C14721 {
        static final /* synthetic */ int[] $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation = new int[BinaryOperation.values().length];

        static {
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.MULTIPLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.DIVIDE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.AND.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.OR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.LESS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.LESS_EQUALS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.GREATER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.GREATER_EQUALS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.EQUALS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.NOT_EQUALS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[BinaryOperation.NULL_COALESCING.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        if (environment.optimize() && isConstant()) {
            BytecodeCompiler.writeFloatConst(method, evaluate(environment));
            return;
        }
        switch (C14721.$SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[this.operator.ordinal()]) {
            case 3:
                if (environment.optimize() && tryWriteNegate(method, environment, breakLabel, continueLabel)) {
                    return;
                }
                writeNode(this.left, method, environment, breakLabel, continueLabel);
                writeNode(this.right, method, environment, breakLabel, continueLabel);
                method.visitInsn(106);
                return;
            case 4:
                if (environment.optimize() && tryWriteNegate(method, environment, breakLabel, continueLabel)) {
                    return;
                }
                writeNode(this.left, method, environment, breakLabel, continueLabel);
                writeNode(this.right, method, environment, breakLabel, continueLabel);
                method.visitInsn(C0244ds.f1979hd);
                return;
            case 5:
                Label label_false = new Label();
                Label label_end = new Label();
                writeNode(this.left, method, environment, breakLabel, continueLabel);
                method.visitInsn(11);
                method.visitInsn(149);
                method.visitJumpInsn(153, label_false);
                writeNode(this.right, method, environment, breakLabel, continueLabel);
                method.visitInsn(11);
                method.visitInsn(149);
                method.visitJumpInsn(153, label_false);
                method.visitInsn(12);
                method.visitJumpInsn(167, label_end);
                method.visitLabel(label_false);
                method.visitInsn(11);
                method.visitLabel(label_end);
                return;
            case 6:
                Label label_true = new Label();
                Label label_end2 = new Label();
                writeNode(this.left, method, environment, breakLabel, continueLabel);
                method.visitInsn(11);
                method.visitInsn(149);
                method.visitJumpInsn(154, label_true);
                writeNode(this.right, method, environment, breakLabel, continueLabel);
                method.visitInsn(11);
                method.visitInsn(149);
                method.visitJumpInsn(154, label_true);
                method.visitInsn(11);
                method.visitJumpInsn(167, label_end2);
                method.visitLabel(label_true);
                method.visitInsn(12);
                method.visitLabel(label_end2);
                return;
            case C0994s.f5462C /* 7 */:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                writeNode(this.left, method, environment, breakLabel, continueLabel);
                writeNode(this.right, method, environment, breakLabel, continueLabel);
                switch (C14721.$SwitchMap$gg$moonflower$molangcompiler$core$ast$BinaryOperation[this.operator.ordinal()]) {
                    case 1:
                        method.visitInsn(98);
                        return;
                    case 2:
                        method.visitInsn(102);
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    default:
                        return;
                    case C0994s.f5462C /* 7 */:
                        writeComparision(method, 156);
                        return;
                    case 8:
                        writeComparision(method, 157);
                        return;
                    case 9:
                        writeComparision(method, 158);
                        return;
                    case 10:
                        writeComparision(method, 155);
                        return;
                    case 11:
                        writeComparision(method, 154);
                        return;
                    case 12:
                        writeComparision(method, 153);
                        return;
                }
            case C0885px.f4841pt /* 13 */:
                Node node = this.left;
                if (!(node instanceof VariableGetNode)) {
                    throw new MolangSyntaxException("Expected variable lookup, got " + this.left);
                }
                VariableGetNode lookup = (VariableGetNode) node;
                environment.loadObjectHas(method, lookup.object(), lookup.name());
                Label label_false2 = new Label();
                Label label_end3 = new Label();
                method.visitJumpInsn(153, label_false2);
                writeNode(this.left, method, environment, breakLabel, continueLabel);
                method.visitJumpInsn(167, label_end3);
                method.visitLabel(label_false2);
                writeNode(this.right, method, environment, breakLabel, continueLabel);
                method.visitLabel(label_end3);
                return;
        }
    }

    private boolean tryWriteNegate(MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        if (this.left.isConstant()) {
            float left = this.left.evaluate(environment);
            if (left == -1.0f) {
                this.right.writeBytecode(method, environment, breakLabel, continueLabel);
                method.visitInsn(118);
                return true;
            }
            return false;
        }
        if (this.right.isConstant()) {
            float right = this.right.evaluate(environment);
            if (right == -1.0f) {
                this.left.writeBytecode(method, environment, breakLabel, continueLabel);
                method.visitInsn(118);
                return true;
            }
            return false;
        }
        return false;
    }

    private static void writeNode(Node node, MethodNode method, MolangBytecodeEnvironment environment, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        if (environment.optimize() && node.isConstant()) {
            BytecodeCompiler.writeFloatConst(method, node.evaluate(environment));
        } else {
            node.writeBytecode(method, environment, breakLabel, continueLabel);
        }
    }

    private static void writeComparision(MethodNode method, int success) {
        Label label_false = new Label();
        Label label_end = new Label();
        method.visitInsn(149);
        method.visitJumpInsn(success, label_false);
        method.visitInsn(12);
        method.visitJumpInsn(167, label_end);
        method.visitLabel(label_false);
        method.visitInsn(11);
        method.visitLabel(label_end);
    }
}
