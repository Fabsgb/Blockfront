package gg.moonflower.molangcompiler.api.object;

import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/object/ImmutableMolangObject.class */
public final class ImmutableMolangObject extends Record implements MolangObject {
    private final MolangObject parent;

    public ImmutableMolangObject(MolangObject parent) {
        this.parent = parent;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ImmutableMolangObject.class), ImmutableMolangObject.class, "parent", "FIELD:Lgg/moonflower/molangcompiler/api/object/ImmutableMolangObject;->parent:Lgg/moonflower/molangcompiler/api/object/MolangObject;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ImmutableMolangObject.class, Object.class), ImmutableMolangObject.class, "parent", "FIELD:Lgg/moonflower/molangcompiler/api/object/ImmutableMolangObject;->parent:Lgg/moonflower/molangcompiler/api/object/MolangObject;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MolangObject parent() {
        return this.parent;
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public void set(String name, MolangExpression value) throws MolangRuntimeException {
        throw new MolangRuntimeException("Cannot set values on an immutable object");
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public void remove(String name) throws MolangRuntimeException {
        throw new MolangRuntimeException("Cannot set values on an immutable object");
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public MolangExpression get(String name) throws MolangRuntimeException {
        return this.parent.get(name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public boolean has(String name) {
        return this.parent.has(name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public Collection<String> getKeys() {
        return this.parent.getKeys();
    }

    @Override // java.lang.Record
    public String toString() {
        return this.parent.toString();
    }
}
