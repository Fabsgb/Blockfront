package gg.moonflower.molangcompiler.core.object;

import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import gg.moonflower.molangcompiler.core.node.MolangFunctionNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/object/MolangVariableStorage.class */
@ApiStatus.Internal
public class MolangVariableStorage implements MolangObject {
    private final Map<String, MolangExpression> storage;
    private final boolean allowMethods;

    public MolangVariableStorage(boolean allowMethods) {
        this.storage = new HashMap();
        this.allowMethods = allowMethods;
    }

    public MolangVariableStorage(MolangVariableStorage copy) {
        this.storage = new HashMap(copy.storage);
        this.allowMethods = copy.allowMethods;
    }

    public void clear() {
        this.storage.clear();
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public void set(String name, MolangExpression value) throws MolangRuntimeException {
        if (!this.allowMethods && (value instanceof MolangFunctionNode)) {
            throw new MolangRuntimeException("Cannot set functions on objects that do not allow functions");
        }
        this.storage.put(name, value);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public void remove(String name) throws MolangRuntimeException {
        this.storage.remove(name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public MolangExpression get(String name) throws MolangRuntimeException {
        MolangExpression expression = this.storage.get(name);
        if (expression != null) {
            return expression;
        }
        throw new MolangRuntimeException("Unknown MoLang expression: " + name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public boolean has(String name) {
        return this.storage.containsKey(name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public Collection<String> getKeys() {
        return this.storage.keySet();
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public MolangObject getCopy() {
        return new MolangVariableStorage(this);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("MoLang Object\n");
        for (Map.Entry<String, MolangExpression> entry : this.storage.entrySet()) {
            builder.append('\t').append(entry.getKey());
            if (entry.getValue() instanceof MolangFunctionNode) {
                builder.append("()");
            } else {
                builder.append('=').append(entry.getValue());
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
