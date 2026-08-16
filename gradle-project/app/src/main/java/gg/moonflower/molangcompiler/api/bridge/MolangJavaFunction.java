package gg.moonflower.molangcompiler.api.bridge;

import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/bridge/MolangJavaFunction.class */
@FunctionalInterface
public interface MolangJavaFunction {
    float resolve(Context context) throws MolangRuntimeException;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/api/bridge/MolangJavaFunction$Context.class */
    public static final class Context extends Record {
        private final float[] parameters;

        public Context(float[] parameters) {
            this.parameters = parameters;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Context.class), Context.class, "parameters", "FIELD:Lgg/moonflower/molangcompiler/api/bridge/MolangJavaFunction$Context;->parameters:[F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Context.class), Context.class, "parameters", "FIELD:Lgg/moonflower/molangcompiler/api/bridge/MolangJavaFunction$Context;->parameters:[F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Context.class, Object.class), Context.class, "parameters", "FIELD:Lgg/moonflower/molangcompiler/api/bridge/MolangJavaFunction$Context;->parameters:[F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public float[] parameters() {
            return this.parameters;
        }

        public float get(int parameter) throws MolangRuntimeException {
            if (parameter < 0 || parameter >= this.parameters.length) {
                throw new MolangRuntimeException("Invalid parameter: " + parameter);
            }
            return this.parameters[parameter];
        }

        public int getParameters() {
            return this.parameters.length;
        }
    }
}
