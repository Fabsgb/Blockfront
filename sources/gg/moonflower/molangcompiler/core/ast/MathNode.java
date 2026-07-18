package gg.moonflower.molangcompiler.core.ast;

import com.boehmod.bflib.cloud.common.ProgressionValues;
import com.boehmod.blockfront.AbstractC0851pQ;
import com.boehmod.blockfront.AbstractC0877pq;
import com.boehmod.blockfront.C0238dn;
import com.boehmod.blockfront.C0862pb;
import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.core.MolangUtil;
import gg.moonflower.molangcompiler.core.compiler.BytecodeCompiler;
import gg.moonflower.molangcompiler.core.compiler.MolangBytecodeEnvironment;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/MathNode.class */
@ApiStatus.Internal
public final class MathNode extends Record implements Node {
    private final MathOperation function;
    private final Node[] arguments;
    private static final float RADIANS_TO_DEGREES = 57.29578f;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MathNode.class), MathNode.class, "function;arguments", "FIELD:Lgg/moonflower/molangcompiler/core/ast/MathNode;->function:Lgg/moonflower/molangcompiler/core/ast/MathOperation;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/MathNode;->arguments:[Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MathNode.class, Object.class), MathNode.class, "function;arguments", "FIELD:Lgg/moonflower/molangcompiler/core/ast/MathNode;->function:Lgg/moonflower/molangcompiler/core/ast/MathOperation;", "FIELD:Lgg/moonflower/molangcompiler/core/ast/MathNode;->arguments:[Lgg/moonflower/molangcompiler/core/ast/Node;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MathOperation function() {
        return this.function;
    }

    public Node[] arguments() {
        return this.arguments;
    }

    public MathNode(MathOperation function, Node... arguments) {
        this.function = function;
        this.arguments = arguments;
    }

    @Override // java.lang.Record, gg.moonflower.molangcompiler.core.ast.Node
    public String toString() {
        if (this.function.getParameters() == 0) {
            return "math." + this.function.getName();
        }
        return "math." + this.function.getName() + "(" + ((String) Arrays.stream(this.arguments).map((v0) -> {
            return v0.toString();
        }).collect(Collectors.joining(", "))) + ")";
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean isConstant() {
        if (!this.function.isDeterministic()) {
            return false;
        }
        for (Node parameter : this.arguments) {
            if (!parameter.isConstant()) {
                return false;
            }
        }
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public boolean hasValue() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public float evaluate(MolangBytecodeEnvironment environment) throws MolangException {
        float[] values = new float[this.arguments.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = this.arguments[i].evaluate(environment);
        }
        switch (C14471.$SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[this.function.ordinal()]) {
            case 1:
                return Math.abs(values[0]);
            case 2:
                return RADIANS_TO_DEGREES * ((float) Math.acos(values[0]));
            case 3:
                return RADIANS_TO_DEGREES * ((float) Math.asin(values[0]));
            case 4:
                return RADIANS_TO_DEGREES * ((float) Math.atan(values[0]));
            case 5:
                return RADIANS_TO_DEGREES * ((float) Math.atan2(values[0], values[1]));
            case 6:
                return (float) Math.ceil(values[0]);
            case 7:
                return MolangUtil.clamp(values[0], values[1], values[2]);
            case 8:
                return (float) Math.cos(0.017453292f * values[0]);
            case C0862pb.f4509nv /* 9 */:
                return (float) Math.sin(0.017453292f * values[0]);
            case 10:
                return (float) Math.exp(values[0]);
            case AbstractC0877pq.f4599nO /* 11 */:
                return (float) Math.floor(values[0]);
            case 12:
                return MolangUtil.hermiteBlend(values[0]);
            case C0862pb.f4508nu /* 13 */:
                return MolangUtil.lerp(values[0], values[1], values[2]);
            case 14:
                return MolangUtil.lerpRotate(values[0], values[1], values[2]);
            case 15:
                return (float) Math.log(values[0]);
            case 16:
                return Math.max(values[0], values[1]);
            case 17:
                return Math.min(values[0], values[1]);
            case 18:
                return MolangUtil.wrapDegrees(values[0]);
            case 19:
                return values[0] % values[1];
            case 20:
                return 3.1415927f;
            case 21:
                return (float) Math.pow(values[0], values[1]);
            case 22:
                return Math.round(values[0]);
            case C0862pb.f4510nw /* 23 */:
                return (float) Math.sqrt(values[0]);
            case 24:
                return (int) values[0];
            case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                return Math.signum(values[0]);
            case 26:
                return MolangUtil.triangleWave(values[0], values[1]);
            default:
                throw new MolangException("Unexpected value: " + this.function);
        }
    }

    /* JADX INFO: renamed from: gg.moonflower.molangcompiler.core.ast.MathNode$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ast/MathNode$1.class */
    static /* synthetic */ class C14471 {
        static final /* synthetic */ int[] $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation = new int[MathOperation.values().length];

        static {
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.ABS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.ACOS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.ASIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.ATAN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.ATAN2.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.CEIL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.CLAMP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.COS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.SIN.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.EXP.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.FLOOR.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.HERMITE_BLEND.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.LERP.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.LERPROTATE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.LN.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.MAX.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.MIN.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.MIN_ANGLE.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.MOD.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.PI.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.POW.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.ROUND.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.SQRT.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.TRUNC.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.SIGN.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.TRIANGLE_WAVE.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.DIE_ROLL.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.DIE_ROLL_INTEGER.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.RANDOM.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                $SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[MathOperation.RANDOM_INTEGER.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
        }
    }

    @Override // gg.moonflower.molangcompiler.core.ast.Node
    public void writeBytecode(MethodNode method, MolangBytecodeEnvironment env, @Nullable Label breakLabel, @Nullable Label continueLabel) throws MolangException {
        switch (C14471.$SwitchMap$gg$moonflower$molangcompiler$core$ast$MathOperation[this.function.ordinal()]) {
            case 1:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(F)F", false);
                break;
            case 2:
            case 3:
            case 4:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(141);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(D)D", false);
                method.visitInsn(144);
                BytecodeCompiler.writeFloatConst(method, RADIANS_TO_DEGREES);
                method.visitInsn(106);
                break;
            case 5:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(141);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(141);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(DD)D", false);
                method.visitInsn(144);
                BytecodeCompiler.writeFloatConst(method, RADIANS_TO_DEGREES);
                method.visitInsn(106);
                break;
            case 6:
            case 10:
            case AbstractC0877pq.f4599nO /* 11 */:
            case 15:
            case C0862pb.f4510nw /* 23 */:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(141);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(D)D", false);
                method.visitInsn(144);
                break;
            case 7:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[2].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "clamp", "(FFF)F", false);
                break;
            case 8:
            case C0862pb.f4509nv /* 9 */:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                BytecodeCompiler.writeFloatConst(method, 0.017453292f);
                method.visitInsn(106);
                method.visitInsn(141);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(D)D", false);
                method.visitInsn(144);
                break;
            case 12:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "hermiteBlend", "(F)F", false);
                break;
            case C0862pb.f4508nu /* 13 */:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[2].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "lerp", "(FFF)F", false);
                break;
            case 14:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[2].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "lerpRotate", "(FFF)F", false);
                break;
            case 16:
            case 17:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(FF)F", false);
                break;
            case 18:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "wrapDegrees", "(F)F", false);
                break;
            case 19:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(C0238dn.f1978gs);
                break;
            case 20:
                BytecodeCompiler.writeFloatConst(method, 3.1415927f);
                break;
            case 21:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(141);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(141);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(DD)D", false);
                method.visitInsn(144);
                break;
            case 22:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "java/lang/Math", this.function.getName(), "(F)I", false);
                method.visitInsn(134);
                break;
            case 24:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                method.visitInsn(134);
                break;
            case ProgressionValues.EXP_PER_INFECTED_ROUNDS_WON /* 25 */:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "java/lang/Math", "signum", "(F)F", false);
                break;
            case 26:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "triangleWave", "(FF)F", false);
                break;
            case 27:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[2].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "dieRoll", "(IFF)F", false);
                break;
            case AbstractC0851pQ.f4482nU /* 28 */:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                method.visitInsn(134);
                this.arguments[2].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                method.visitInsn(134);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "dieRoll", "(IFF)F", false);
                method.visitInsn(139);
                method.visitInsn(134);
                break;
            case 29:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "random", "(FF)F", false);
                break;
            case 30:
                this.arguments[0].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                method.visitInsn(134);
                this.arguments[1].writeBytecode(method, env, breakLabel, continueLabel);
                method.visitInsn(139);
                method.visitInsn(134);
                method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "random", "(FF)F", false);
                method.visitInsn(139);
                method.visitInsn(134);
                break;
        }
    }
}
