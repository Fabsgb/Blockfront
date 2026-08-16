package gg.moonflower.molangcompiler.core;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Collection;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/ImmutableMolangEnvironment.class */
@ApiStatus.Internal
public final class ImmutableMolangEnvironment extends Record implements MolangEnvironment {
    private final MolangEnvironment environment;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ImmutableMolangEnvironment.class), ImmutableMolangEnvironment.class, "environment", "FIELD:Lgg/moonflower/molangcompiler/core/ImmutableMolangEnvironment;->environment:Lgg/moonflower/molangcompiler/api/MolangEnvironment;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ImmutableMolangEnvironment.class), ImmutableMolangEnvironment.class, "environment", "FIELD:Lgg/moonflower/molangcompiler/core/ImmutableMolangEnvironment;->environment:Lgg/moonflower/molangcompiler/api/MolangEnvironment;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ImmutableMolangEnvironment.class, Object.class), ImmutableMolangEnvironment.class, "environment", "FIELD:Lgg/moonflower/molangcompiler/core/ImmutableMolangEnvironment;->environment:Lgg/moonflower/molangcompiler/api/MolangEnvironment;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public MolangEnvironment environment() {
        return this.environment;
    }

    public ImmutableMolangEnvironment(MolangEnvironment environment) {
        this.environment = environment;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void loadLibrary(String name, MolangObject object, String... aliases) {
        this.environment.loadLibrary(name, object, aliases);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void loadAlias(String name, String first, String... aliases) throws IllegalArgumentException {
        this.environment.loadAlias(name, first, aliases);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void loadParameter(float value) throws MolangRuntimeException {
        this.environment.loadParameter(value);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void clearParameters() {
        this.environment.clearParameters();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public float getThis() {
        return this.environment.getThis();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public MolangObject get(String name) throws MolangRuntimeException {
        return this.environment.get(name);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public float getParameter(int parameter) throws MolangRuntimeException {
        return this.environment.getParameter(parameter);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public int getParameters() {
        return this.environment.getParameters();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public Collection<String> getObjects() {
        return this.environment.getObjects();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void setThisValue(float thisValue) {
        this.environment.setThisValue(thisValue);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public boolean canEdit() {
        return false;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public MolangEnvironmentBuilder<? extends MolangEnvironment> edit() throws IllegalStateException {
        throw new IllegalStateException("Immutable MoLang environments cannot be edited");
    }
}
