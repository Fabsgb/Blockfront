package gg.moonflower.molangcompiler.api.object;

import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import java.util.Collection;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/object/MolangObject.class */
public interface MolangObject {
    MolangExpression get(String str) throws MolangRuntimeException;

    void set(String str, MolangExpression molangExpression) throws MolangRuntimeException;

    void remove(String str) throws MolangRuntimeException;

    boolean has(String str);

    Collection<String> getKeys();

    default MolangObject getCopy() {
        return this;
    }

    default boolean isMutable() {
        return true;
    }
}
