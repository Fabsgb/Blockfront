package gg.moonflower.molangcompiler.api.bridge;

import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.function.Supplier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/bridge/MolangVariableProvider.class */
@FunctionalInterface
public interface MolangVariableProvider {

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/bridge/MolangVariableProvider$Context.class */
    public interface Context {
        void addVariable(String str, MolangVariable molangVariable);

        void addQuery(String str, MolangExpression molangExpression);

        void addQuery(String str, float f);

        void addQuery(String str, Supplier<Float> supplier);

        void addQuery(String str, int i, MolangJavaFunction molangJavaFunction);

        void removeQuery(String str);

        void removeVariable(String str);
    }

    void addMolangVariables(Context context);
}
