package gg.moonflower.molangcompiler.core.compiler;

import gg.moonflower.molangcompiler.api.exception.MolangSyntaxException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.ApiStatus;
import org.objectweb.asm.tree.MethodNode;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment.class */
@ApiStatus.Internal
public final class MolangBytecodeEnvironment extends Record {
    private final Map<String, Integer> variables;
    private final Set<String> modifiedVariables;
    private final boolean optimize;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, MolangBytecodeEnvironment.class), MolangBytecodeEnvironment.class, "variables;modifiedVariables;optimize", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->variables:Ljava/util/Map;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->modifiedVariables:Ljava/util/Set;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->optimize:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, MolangBytecodeEnvironment.class), MolangBytecodeEnvironment.class, "variables;modifiedVariables;optimize", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->variables:Ljava/util/Map;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->modifiedVariables:Ljava/util/Set;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->optimize:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, MolangBytecodeEnvironment.class, Object.class), MolangBytecodeEnvironment.class, "variables;modifiedVariables;optimize", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->variables:Ljava/util/Map;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->modifiedVariables:Ljava/util/Set;", "FIELD:Lgg/moonflower/molangcompiler/core/compiler/MolangBytecodeEnvironment;->optimize:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Map<String, Integer> variables() {
        return this.variables;
    }

    public Set<String> modifiedVariables() {
        return this.modifiedVariables;
    }

    public boolean optimize() {
        return this.optimize;
    }

    public MolangBytecodeEnvironment(Map<String, Integer> variables, Set<String> modifiedVariables, boolean optimize) {
        this.variables = variables;
        this.modifiedVariables = modifiedVariables;
        this.optimize = optimize;
    }

    public MolangBytecodeEnvironment(MolangBytecodeEnvironment environment) {
        this(new HashMap(environment.variables), new LinkedHashSet(), environment.optimize);
    }

    public MolangBytecodeEnvironment(int flags) {
        this(new HashMap(), new LinkedHashSet(), (flags & 1) > 0);
    }

    public void reset() {
        this.variables.clear();
        this.modifiedVariables.clear();
    }

    public int loadVariable(MethodNode method, String object, String name) {
        String key = object + "." + name;
        Integer index = this.variables.get(key);
        if (index != null) {
            return index.intValue();
        }
        int objectIndex = getObjectIndex(method, object);
        method.visitVarInsn(25, objectIndex);
        method.visitLdcInsn(name);
        method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/object/MolangObject", "get", "(Ljava/lang/String;)Lgg/moonflower/molangcompiler/api/MolangExpression;", true);
        method.visitVarInsn(25, 1);
        method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/MolangExpression", "resolve", "(Lgg/moonflower/molangcompiler/api/MolangEnvironment;)F", true);
        Integer index2 = Integer.valueOf(allocateVariable(key));
        method.visitVarInsn(56, index2.intValue());
        return index2.intValue();
    }

    public int allocateVariable(String name) {
        Integer index = this.variables.get(name);
        if (index != null) {
            return index.intValue();
        }
        Integer index2 = Integer.valueOf(this.variables.size() + 2);
        this.variables.put(name, index2);
        return index2.intValue();
    }

    public int getObjectIndex(MethodNode method, String object) {
        Integer index = this.variables.get(object);
        if (index != null) {
            return index.intValue();
        }
        Integer index2 = Integer.valueOf(allocateVariable(object));
        method.visitVarInsn(25, 1);
        method.visitLdcInsn(object);
        method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/MolangEnvironment", "get", "(Ljava/lang/String;)Lgg/moonflower/molangcompiler/api/object/MolangObject;", true);
        method.visitVarInsn(58, index2.intValue());
        return index2.intValue();
    }

    public void loadObjectHas(MethodNode method, String object, String name) {
        if ("temp".equals(object)) {
            method.visitLdcInsn(Boolean.valueOf(this.variables.containsKey("temp." + name)));
            return;
        }
        String key = object + "." + name + "$has";
        Integer objectHasIndex = this.variables.get(key);
        if (objectHasIndex != null) {
            method.visitVarInsn(21, objectHasIndex.intValue());
            return;
        }
        Integer objectHasIndex2 = Integer.valueOf(allocateVariable(key));
        int objectIndex = getObjectIndex(method, object);
        method.visitVarInsn(25, objectIndex);
        method.visitLdcInsn(name);
        method.visitMethodInsn(185, "gg/moonflower/molangcompiler/api/object/MolangObject", "has", "(Ljava/lang/String;)Z", true);
        method.visitInsn(89);
        method.visitVarInsn(54, objectHasIndex2.intValue());
    }

    public void markDirty(String object, String name) {
        if ("temp".equals(object)) {
            return;
        }
        this.modifiedVariables.add(object + "." + name);
    }

    public void writeModifiedVariables(MethodNode method) throws MolangSyntaxException {
        for (String name : this.modifiedVariables) {
            Integer index = this.variables.get(name);
            if (index == null) {
                throw new MolangSyntaxException("Unknown variable index: " + name);
            }
            String[] parts = name.split("\\.", 2);
            if (parts.length != 2) {
                throw new MolangSyntaxException("Expected 2 variable parts for " + name + ", got " + parts.length);
            }
            int objectIndex = getObjectIndex(method, parts[0]);
            method.visitVarInsn(25, objectIndex);
            method.visitLdcInsn(parts[1]);
            method.visitVarInsn(23, index.intValue());
            method.visitMethodInsn(184, "gg/moonflower/molangcompiler/core/MolangUtil", "setValue", "(Lgg/moonflower/molangcompiler/api/object/MolangObject;Ljava/lang/String;F)V", false);
        }
        this.modifiedVariables.clear();
    }
}
