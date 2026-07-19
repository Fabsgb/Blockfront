package gg.moonflower.molangcompiler.api.object;

import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.core.node.MolangFunctionNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/object/MolangLibrary.class */
public abstract class MolangLibrary implements MolangObject {
    private final Map<String, MolangExpression> values = new HashMap();

    protected abstract void populate(BiConsumer<String, MolangExpression> biConsumer);

    protected abstract String getName();

    public MolangLibrary() {
        Map<String, MolangExpression> map = this.values;
        Objects.requireNonNull(map);
        populate((v1, v2) -> {
            r1.put(v1, v2);
        });
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public void set(String name, MolangExpression value) throws MolangRuntimeException {
        throw new MolangRuntimeException("Cannot set values to " + getName());
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public void remove(String name) throws MolangRuntimeException {
        throw new MolangRuntimeException("Cannot remove values from " + getName());
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public MolangExpression get(String name) throws MolangRuntimeException {
        MolangExpression expression = this.values.get(name);
        if (expression != null) {
            return expression;
        }
        throw new MolangRuntimeException("Unknown MoLang expression: " + name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public boolean has(String name) {
        return this.values.containsKey(name);
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public Collection<String> getKeys() {
        return this.values.keySet();
    }

    @Override // gg.moonflower.molangcompiler.api.object.MolangObject
    public boolean isMutable() {
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(getName()).append('\n');
        for (Map.Entry<String, MolangExpression> entry : this.values.entrySet()) {
            builder.append('\t').append(entry.getKey());
            if (entry.getValue() instanceof MolangFunctionNode) {
                builder.append("()");
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
