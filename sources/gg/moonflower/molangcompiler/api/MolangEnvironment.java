package gg.moonflower.molangcompiler.api;

import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import gg.moonflower.molangcompiler.api.object.MolangObject;
import gg.moonflower.molangcompiler.core.ImmutableMolangEnvironment;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/MolangEnvironment.class */
public interface MolangEnvironment {
    void loadLibrary(String str, MolangObject molangObject, String... strArr);

    void loadAlias(String str, String str2, String... strArr) throws IllegalArgumentException;

    void loadParameter(float f) throws MolangRuntimeException;

    void clearParameters();

    float getThis();

    MolangObject get(String str) throws MolangRuntimeException;

    float getParameter(int i) throws MolangRuntimeException;

    int getParameters();

    Collection<String> getObjects();

    void setThisValue(float f);

    boolean canEdit();

    MolangEnvironmentBuilder<? extends MolangEnvironment> edit() throws IllegalStateException;

    default void loadLibrary(String name, MolangObject object) {
        loadLibrary(name, object, new String[0]);
    }

    default boolean has(String name) {
        return getObjects().contains(name.toLowerCase(Locale.ROOT));
    }

    default boolean hasParameter(int parameter) {
        return parameter >= 0 && parameter < getParameters();
    }

    default MolangEnvironment copy() {
        return MolangRuntime.runtime().copy(this).create(getThis());
    }

    default float resolve(MolangExpression expression) throws MolangRuntimeException {
        return expression.get(this);
    }

    default float safeResolve(MolangExpression expression) {
        try {
            return resolve(expression);
        } catch (Throwable t) {
            t.printStackTrace();
            return 0.0f;
        }
    }

    static MolangEnvironment immutable(MolangEnvironment environment) {
        if (!(environment instanceof ImmutableMolangEnvironment)) {
            return new ImmutableMolangEnvironment(environment);
        }
        ImmutableMolangEnvironment immutableEnvironment = (ImmutableMolangEnvironment) environment;
        return immutableEnvironment;
    }
}
