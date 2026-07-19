package foundry.veil.api.event;

import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import net.minecraft.server.packs.resources.ResourceProvider;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilAddShaderPreProcessorsEvent.class */
@FunctionalInterface
public interface VeilAddShaderPreProcessorsEvent {
    void onRegisterShaderPreProcessors(ResourceProvider resourceProvider, Registry registry);

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/event/VeilAddShaderPreProcessorsEvent$Registry.class */
    public interface Registry {
        void addPreprocessorFirst(ShaderPreProcessor shaderPreProcessor, boolean z);

        void addPreprocessor(ShaderPreProcessor shaderPreProcessor, boolean z);

        default void addPreprocessorFirst(ShaderPreProcessor processor) {
            addPreprocessor(processor, true);
        }

        default void addPreprocessor(ShaderPreProcessor processor) {
            addPreprocessor(processor, true);
        }
    }
}
