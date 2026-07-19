package gg.moonflower.molangcompiler.core.node;

import gg.moonflower.molangcompiler.api.MolangEnvironment;
import gg.moonflower.molangcompiler.api.MolangExpression;
import gg.moonflower.molangcompiler.api.bridge.MolangJavaFunction;
import gg.moonflower.molangcompiler.api.exception.MolangRuntimeException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/molang-compiler-3.1.1.19.jar:gg/moonflower/molangcompiler/core/node/MolangFunctionNode.class */
@ApiStatus.Internal
public class MolangFunctionNode implements MolangExpression {
    private final int params;
    private final MolangJavaFunction consumer;

    public MolangFunctionNode(int params, MolangJavaFunction consumer) {
        this.params = params;
        this.consumer = consumer;
    }

    @Override // gg.moonflower.molangcompiler.api.MolangExpression
    public float get(MolangEnvironment environment) throws MolangRuntimeException {
        float[] parameters;
        if (this.params < 0) {
            parameters = new float[environment.getParameters()];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = environment.getParameter(i);
            }
        } else {
            parameters = new float[this.params];
            for (int i2 = 0; i2 < parameters.length; i2++) {
                if (!environment.hasParameter(i2)) {
                    throw new MolangRuntimeException("Function requires " + parameters.length + " parameters");
                }
                parameters[i2] = environment.getParameter(i2);
            }
        }
        return this.consumer.resolve(new MolangJavaFunction.Context(parameters));
    }
}
