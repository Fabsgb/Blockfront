package gg.moonflower.molangcompiler.core.compiler;

import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import gg.moonflower.molangcompiler.core.ast.Node;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.jetbrains.annotations.ApiStatus;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/BytecodeCompiler.class */
@ApiStatus.Internal
public class BytecodeCompiler extends ClassLoader {
    public static final int FLAG_OPTIMIZE = 1;
    public static final int THIS_INDEX = 0;
    public static final int RUNTIME_INDEX = 1;
    public static final int VARIABLE_START = 2;
    private static final Pattern DASH = Pattern.compile("-");
    private final ThreadLocal<MolangBytecodeEnvironment> environment;
    private final boolean writeClasses;

    public BytecodeCompiler(int flags, ClassLoader parent) {
        super(parent);
        this.environment = ThreadLocal.withInitial(() -> {
            return new MolangBytecodeEnvironment(flags);
        });
        this.writeClasses = (flags & 2) > 0;
    }

    public BytecodeCompiler(int flags) {
        this(flags, getSystemClassLoader());
    }

    public MolangExpression build(Node node) throws MolangSyntaxException {
        MolangBytecodeEnvironment environment = this.environment.get();
        environment.reset();
        try {
            if (environment.optimize() && node.isConstant()) {
                return MolangExpression.of(node.evaluate(environment));
            }
            ClassNode classNode = new ClassNode(327680);
            classNode.version = 52;
            classNode.superName = "java/lang/Object";
            classNode.name = "Expression_" + DASH.matcher(UUID.randomUUID().toString()).replaceAll("");
            classNode.access = 1;
            classNode.interfaces.add(MolangExpression.class.getName().replaceAll("\\.", "/"));
            MethodNode init = new MethodNode();
            init.access = 1;
            init.name = "<init>";
            init.desc = "()V";
            init.visitVarInsn(25, 0);
            init.visitMethodInsn(183, "java/lang/Object", "<init>", "()V", false);
            init.visitInsn(177);
            classNode.methods.add(init);
            MethodNode method = new MethodNode();
            method.access = 1;
            method.name = "get";
            method.desc = "(Lgg/moonflower/molangcompiler/api/MolangEnvironment;)F";
            method.exceptions = List.of("gg/moonflower/molangcompiler/api/exception/MolangRuntimeException");
            node.writeBytecode(method, environment, null, null);
            classNode.methods.add(method);
            String compiledSource = node.toString();
            MethodNode equals = new MethodNode();
            Label equalsFail = new Label();
            Label equalsReturn = new Label();
            equals.access = 1;
            equals.name = "equals";
            equals.desc = "(Ljava/lang/Object;)Z";
            equals.visitVarInsn(25, 1);
            equals.visitTypeInsn(193, "gg/moonflower/molangcompiler/api/MolangExpression");
            equals.visitJumpInsn(153, equalsFail);
            equals.visitLdcInsn(compiledSource);
            equals.visitVarInsn(25, 1);
            equals.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;", false);
            equals.visitMethodInsn(182, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false);
            equals.visitJumpInsn(153, equalsFail);
            writeIntConst(equals, 1);
            equals.visitJumpInsn(167, equalsReturn);
            equals.visitLabel(equalsFail);
            writeIntConst(equals, 0);
            equals.visitLabel(equalsReturn);
            equals.visitInsn(172);
            classNode.methods.add(equals);
            MethodNode hashCode = new MethodNode();
            hashCode.access = 1;
            hashCode.name = "hashCode";
            hashCode.desc = "()I";
            writeIntConst(hashCode, compiledSource.hashCode());
            hashCode.visitInsn(172);
            classNode.methods.add(hashCode);
            MethodNode toString = new MethodNode();
            toString.access = 1;
            toString.name = "toString";
            toString.desc = "()Ljava/lang/String;";
            toString.visitLdcInsn(compiledSource);
            toString.visitInsn(176);
            classNode.methods.add(toString);
            ClassWriter cw = new ClassWriter(3);
            classNode.accept(cw);
            byte[] data = cw.toByteArray();
            if (this.writeClasses) {
                Path path = Paths.get(classNode.name + ".class", new String[0]);
                if (!Files.exists(path, new LinkOption[0])) {
                    Files.createFile(path, new FileAttribute[0]);
                }
                Files.write(path, data, new OpenOption[0]);
            }
            return (MolangExpression) defineClass(classNode.name, data, 0, data.length).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable t) {
            throw new MolangSyntaxException("Failed to convert expression '" + node + "' to bytecode", t);
        }
    }

    public static void writeFloatConst(MethodNode method, float value) {
        if (value == 0.0f) {
            method.visitInsn(11);
            return;
        }
        if (value == 1.0f) {
            method.visitInsn(12);
        } else if (value == 2.0f) {
            method.visitInsn(13);
        } else {
            method.visitLdcInsn(Float.valueOf(value));
        }
    }

    public static void writeIntConst(MethodNode method, int value) {
        switch (value) {
            case 0:
                method.visitInsn(3);
                break;
            case 1:
                method.visitInsn(4);
                break;
            case 2:
                method.visitInsn(5);
                break;
            case 3:
                method.visitInsn(6);
                break;
            case 4:
                method.visitInsn(7);
                break;
            case 5:
                method.visitInsn(8);
                break;
            default:
                if (value < 127) {
                    method.visitIntInsn(16, (byte) value);
                } else if (value < 32767) {
                    method.visitIntInsn(17, (short) value);
                } else {
                    method.visitLdcInsn(Integer.valueOf(value));
                }
                break;
        }
    }
}
