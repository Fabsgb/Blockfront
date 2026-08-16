package gg.moonflower.molangcompiler.api;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.bridge.MolangJavaFunction;
import gg.moonflower.molangcompiler.api.bridge.MolangVariable;
import gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import java.util.function.Supplier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangEnvironmentBuilder.class */
public interface MolangEnvironmentBuilder<V extends MolangEnvironment> {
    MolangEnvironmentBuilder<V> loadLibrary(String str, MolangObject molangObject);

    MolangEnvironmentBuilder<V> unloadLibrary(String str);

    MolangEnvironmentBuilder<V> setQuery(String str, MolangExpression molangExpression);

    MolangEnvironmentBuilder<V> setGlobal(String str, MolangExpression molangExpression);

    MolangEnvironmentBuilder<V> setVariable(String str, MolangExpression molangExpression);

    MolangEnvironmentBuilder<V> removeQuery(String str);

    MolangEnvironmentBuilder<V> removeGlobal(String str);

    MolangEnvironmentBuilder<V> removeVariable(String str);

    MolangEnvironmentBuilder<V> clearLibraries();

    MolangEnvironmentBuilder<V> clearQuery();

    MolangEnvironmentBuilder<V> clearGlobal();

    MolangEnvironmentBuilder<V> clearVariable();

    MolangEnvironmentBuilder<V> copy(MolangEnvironment molangEnvironment);

    V create();

    default MolangEnvironmentBuilder<V> setQuery(String name, float value) {
        return setQuery(name, MolangExpression.m8349of(value));
    }

    default MolangEnvironmentBuilder<V> setQuery(String name, Supplier<Float> value) {
        return setQuery(name, MolangExpression.lazy(value));
    }

    default MolangEnvironmentBuilder<V> setQuery(String name, int params, MolangJavaFunction function) {
        return setQuery(params < 0 ? name : name + "$" + params, MolangExpression.function(params, function));
    }

    default MolangEnvironmentBuilder<V> setGlobal(String name, float value) {
        return setGlobal(name, MolangExpression.m8349of(value));
    }

    default MolangEnvironmentBuilder<V> setGlobal(String name, Supplier<Float> value) {
        return setGlobal(name, MolangExpression.lazy(value));
    }

    default MolangEnvironmentBuilder<V> setGlobal(String name, int params, MolangJavaFunction function) {
        return setGlobal(params < 0 ? name : name + "$" + params, MolangExpression.function(params, function));
    }

    default MolangEnvironmentBuilder<V> setVariable(String name, MolangVariable value) {
        return setVariable(name, MolangExpression.m8353of(value));
    }

    default MolangEnvironmentBuilder<V> setVariable(String name, float value) {
        return setVariable(name, MolangExpression.m8349of(value));
    }

    default MolangEnvironmentBuilder<V> setVariable(String name, Supplier<Float> value) {
        return setVariable(name, MolangExpression.lazy(value));
    }

    default MolangEnvironmentBuilder<V> setVariables(MolangVariableProvider provider) {
        provider.addMolangVariables(new MolangVariableProvider.Context() { // from class: gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder.1
            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void addVariable(String name, MolangVariable value) {
                MolangEnvironmentBuilder.this.setVariable(name, value);
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void addQuery(String name, MolangExpression value) {
                MolangEnvironmentBuilder.this.setQuery(name, value);
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void addQuery(String name, float value) {
                MolangEnvironmentBuilder.this.setQuery(name, value);
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void addQuery(String name, Supplier<Float> value) {
                MolangEnvironmentBuilder.this.setQuery(name, value);
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void addQuery(String name, int params, MolangJavaFunction function) {
                MolangEnvironmentBuilder.this.setQuery(name, params, function);
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void removeQuery(String name) {
                MolangEnvironmentBuilder.this.removeQuery(name);
            }

            @Override // gg.moonflower.molangcompiler.api.bridge.MolangVariableProvider.Context
            public void removeVariable(String name) {
                MolangEnvironmentBuilder.this.removeVariable(name);
            }
        });
        return this;
    }

    default V create(float f) {
        V v = (V) create();
        v.setThisValue(f);
        return v;
    }
}
