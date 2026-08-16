package gg.moonflower.molangcompiler.api;

import gg.moonflower.molangcompiler.api.exception.MolangException;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.object.ImmutableMolangObject;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import gg.moonflower.molangcompiler.core.object.MolangVariableStorage;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangRuntime.class */
public class MolangRuntime implements MolangEnvironment {
    private float thisValue = 0.0f;
    private final Map<String, MolangObject> objects = new HashMap();
    private final Map<String, String> aliases = new HashMap();
    private final List<Float> parameters;

    private MolangRuntime(MolangObject query, MolangObject global, MolangObject variable, Map<String, MolangObject> libraries) {
        this.objects.putAll(libraries);
        loadLibrary("context", query, "c");
        loadLibrary("query", query, "q");
        loadLibrary("global", global);
        loadLibrary("variable", variable, "v");
        this.parameters = new ArrayList(8);
    }

    private String sanitize(String name) {
        String lowerCase = name.toLowerCase(Locale.ROOT);
        while (true) {
            String name2 = lowerCase;
            if (this.aliases.containsKey(name2)) {
                lowerCase = this.aliases.get(name2).toLowerCase(Locale.ROOT);
            } else {
                return name2;
            }
        }
    }

    public String dump() {
        StringBuilder builder = new StringBuilder("==Start MoLang Runtime Dump==\n\n");
        builder.append("==Start Objects==\n");
        for (Map.Entry<String, MolangObject> entry : this.objects.entrySet()) {
            builder.append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
        }
        builder.deleteCharAt(builder.length() - 2);
        builder.append("==End Objects==\n\n");
        builder.append("==Start Parameters==\n");
        for (int i = 0; i < this.parameters.size(); i++) {
            builder.append("\tParameter ").append(i).append('=').append(this.parameters.get(i)).append('\n');
        }
        builder.append("==End Parameters==\n\n");
        builder.append("==End MoLang Runtime Dump==");
        return builder.toString();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void loadLibrary(String name, MolangObject object, String... aliases) {
        this.objects.put(name.toLowerCase(Locale.ROOT), object);
        for (String alias : aliases) {
            this.aliases.put(alias, name);
        }
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void loadAlias(String name, String first, String... aliases) {
        if (!this.objects.containsKey(name)) {
            throw new IllegalArgumentException("Invalid MoLang library: " + name);
        }
        this.aliases.put(first, name);
        for (String alias : aliases) {
            this.aliases.put(alias, name);
        }
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void loadParameter(float expression) {
        this.parameters.add(Float.valueOf(expression));
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void clearParameters() {
        this.parameters.clear();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public float getThis() {
        return this.thisValue;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public MolangObject get(String name) throws MolangRuntimeException {
        String name2 = sanitize(name);
        MolangObject object = this.objects.get(name2);
        if (object != null) {
            return object;
        }
        throw new MolangRuntimeException("Unknown MoLang object: " + name2);
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public float getParameter(int parameter) throws MolangRuntimeException {
        if (parameter < 0 || parameter >= this.parameters.size()) {
            throw new MolangRuntimeException("No parameter loaded in slot " + parameter);
        }
        return this.parameters.get(parameter).floatValue();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public int getParameters() {
        return this.parameters.size();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public Collection<String> getObjects() {
        return this.objects.keySet();
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public void setThisValue(float thisValue) {
        this.thisValue = thisValue;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public boolean canEdit() {
        return true;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangEnvironment
    public MolangEnvironmentBuilder<MolangRuntime> edit() {
        MolangVariableStorage query = getStorage("query");
        MolangVariableStorage global = getStorage("global");
        MolangVariableStorage variable = getStorage("variable");
        return new EditBuilder(this, query, global, variable);
    }

    private MolangVariableStorage getStorage(String name) {
        MolangObject object = this.objects.get(name);
        if (object == null) {
            throw new IllegalStateException("Missing " + name);
        }
        if (object instanceof ImmutableMolangObject) {
            ImmutableMolangObject immutableObject = (ImmutableMolangObject) object;
            object = immutableObject.parent();
        }
        if (!(object instanceof MolangVariableStorage)) {
            throw new IllegalStateException("Expected " + name + " to be " + MolangVariableStorage.class.getName() + ", was " + object.getClass().getName());
        }
        MolangVariableStorage variableStorage = (MolangVariableStorage) object;
        return variableStorage;
    }

    public static Builder runtime() {
        return new Builder();
    }

    public static Builder runtime(Builder copy) {
        return new Builder(copy);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangRuntime$Builder.class */
    public static class Builder implements MolangEnvironmentBuilder<MolangRuntime> {
        private final MolangVariableStorage query;
        private final MolangVariableStorage global;
        private final MolangVariableStorage variable;
        private final Map<String, MolangObject> libraries;

        public Builder() {
            this.query = new MolangVariableStorage(true);
            this.global = new MolangVariableStorage(true);
            this.variable = new MolangVariableStorage(false);
            this.libraries = new HashMap();
        }

        public Builder(Builder copy) {
            this.query = new MolangVariableStorage(copy.query);
            this.global = new MolangVariableStorage(copy.global);
            this.variable = new MolangVariableStorage(copy.variable);
            this.libraries = new HashMap(copy.libraries);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder loadLibrary(String name, MolangObject object) {
            this.libraries.put(name, object);
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> unloadLibrary(String name) {
            this.libraries.remove(name);
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder setQuery(String name, MolangExpression value) {
            try {
                this.query.set(name, value);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder setGlobal(String name, MolangExpression value) {
            try {
                this.global.set(name, value);
                return this;
            } catch (MolangRuntimeException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder setVariable(String name, MolangExpression value) {
            try {
                this.variable.set(name, value);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder removeQuery(String name) {
            try {
                this.query.remove(name);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder removeGlobal(String name) {
            try {
                this.global.remove(name);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder removeVariable(String name) {
            try {
                this.variable.remove(name);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder clearLibraries() {
            this.libraries.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder clearQuery() {
            this.query.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder clearGlobal() {
            this.global.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public Builder clearVariable() {
            this.variable.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> copy(MolangEnvironment environment) {
            try {
                Iterator<String> it = environment.getObjects().iterator();
                while (it.hasNext()) {
                    String name = it.next().toLowerCase(Locale.ROOT);
                    MolangObject copy = environment.get(name).getCopy();
                    switch (name) {
                        case "query":
                            for (String field : copy.getKeys()) {
                                this.query.set(field, copy.get(field).getCopy());
                            }
                            break;
                        case "global":
                            for (String field2 : copy.getKeys()) {
                                this.global.set(field2, copy.get(field2).getCopy());
                            }
                            break;
                        case "variable":
                            for (String field3 : copy.getKeys()) {
                                this.variable.set(field3, copy.get(field3).getCopy());
                            }
                            break;
                        default:
                            if (this.libraries.containsKey(name)) {
                                MolangObject runtimeObject = environment.get(name);
                                if (runtimeObject.isMutable()) {
                                    for (String field4 : copy.getKeys()) {
                                        runtimeObject.set(field4, copy.get(field4).getCopy());
                                    }
                                    break;
                                }
                            }
                            this.libraries.put(name, copy);
                            break;
                    }
                }
                return this;
            } catch (MolangException e) {
                throw new RuntimeException("Failed to copy environment data", e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangRuntime create() {
            return new MolangRuntime(new ImmutableMolangObject(this.query), new ImmutableMolangObject(this.global), this.variable, this.libraries);
        }

        public MolangObject getQuery() {
            return this.query;
        }

        public MolangObject getGlobal() {
            return this.global;
        }

        public MolangObject getVariable() {
            return this.variable;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder.class */
    private static final class EditBuilder extends Record implements MolangEnvironmentBuilder<MolangRuntime> {
        private final MolangRuntime runtime;
        private final MolangVariableStorage query;
        private final MolangVariableStorage global;
        private final MolangVariableStorage variable;

        private EditBuilder(MolangRuntime runtime, MolangVariableStorage query, MolangVariableStorage global, MolangVariableStorage variable) {
            this.runtime = runtime;
            this.query = query;
            this.global = global;
            this.variable = variable;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EditBuilder.class), EditBuilder.class, "runtime;query;global;variable", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->runtime:Lgg/moonflower/molangcompiler/api/MolangRuntime;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->query:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->global:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->variable:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EditBuilder.class), EditBuilder.class, "runtime;query;global;variable", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->runtime:Lgg/moonflower/molangcompiler/api/MolangRuntime;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->query:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->global:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->variable:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EditBuilder.class, Object.class), EditBuilder.class, "runtime;query;global;variable", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->runtime:Lgg/moonflower/molangcompiler/api/MolangRuntime;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->query:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->global:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;", "FIELD:Lgg/moonflower/molangcompiler/api/MolangRuntime$EditBuilder;->variable:Lgg/moonflower/molangcompiler/core/object/MolangVariableStorage;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public MolangRuntime runtime() {
            return this.runtime;
        }

        public MolangVariableStorage query() {
            return this.query;
        }

        public MolangVariableStorage global() {
            return this.global;
        }

        public MolangVariableStorage variable() {
            return this.variable;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> loadLibrary(String name, MolangObject object) {
            this.runtime.loadLibrary(name, object);
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> unloadLibrary(String name) {
            MolangObject removed = this.runtime.objects.get(name);
            if (removed == this.query || removed == this.global || removed == this.variable) {
                throw new IllegalStateException("Cannot remove query, global, or variable");
            }
            this.runtime.objects.remove(name);
            return this;
        }

        private MolangEnvironmentBuilder<MolangRuntime> set(MolangObject object, String name, MolangExpression value) {
            try {
                object.set(name, value);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        private MolangEnvironmentBuilder<MolangRuntime> remove(MolangObject object, String name) {
            try {
                object.remove(name);
                return this;
            } catch (MolangRuntimeException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> setQuery(String name, MolangExpression value) {
            return set(this.query, name, value);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> setGlobal(String name, MolangExpression value) {
            return set(this.global, name, value);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> setVariable(String name, MolangExpression value) {
            return set(this.variable, name, value);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> removeQuery(String name) {
            return remove(this.query, name);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> removeGlobal(String name) {
            return remove(this.global, name);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> removeVariable(String name) {
            return remove(this.variable, name);
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> clearLibraries() {
            this.runtime.objects.values().retainAll(List.of(this.query, this.global, this.variable));
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> clearQuery() {
            this.query.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> clearGlobal() {
            this.global.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> clearVariable() {
            this.variable.clear();
            return this;
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangEnvironmentBuilder<MolangRuntime> copy(MolangEnvironment environment) {
            try {
                for (String name : environment.getObjects()) {
                    MolangObject copy = environment.get(name).getCopy();
                    if (this.runtime.has(name)) {
                        MolangObject runtimeObject = this.runtime.get(name);
                        if (runtimeObject.isMutable()) {
                            for (String field : copy.getKeys()) {
                                runtimeObject.set(field, copy.get(field).getCopy());
                            }
                        }
                    }
                    this.runtime.objects.put(name, copy);
                }
                return this;
            } catch (MolangException e) {
                throw new RuntimeException("Failed to copy environment data", e);
            }
        }

        @Override // gg.moonflower.molangcompiler.api.MolangEnvironmentBuilder
        public MolangRuntime create() {
            return this.runtime;
        }
    }
}
