package foundry.veil.impl.client.render.shader.processor;

import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import foundry.veil.api.event.VeilAddShaderPreProcessorsEvent;
import foundry.veil.impl.client.render.shader.ShaderImporterImpl;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/processor/ShaderProcessorList.class */
@ApiStatus.Internal
public class ShaderProcessorList implements VeilAddShaderPreProcessorsEvent.Registry {
    private final ShaderImporterImpl importer;
    private final List<ShaderPreProcessor> processors = new LinkedList();
    private final List<ShaderPreProcessor> importProcessors = new LinkedList();
    private ShaderPreProcessor processor = null;
    private ShaderPreProcessor importProcessor = null;

    public ShaderProcessorList(ResourceProvider provider) {
        this.importer = new ShaderImporterImpl(provider);
    }

    @Override // foundry.veil.api.event.VeilAddShaderPreProcessorsEvent.Registry
    public void addPreprocessorFirst(ShaderPreProcessor processor, boolean modifyImports) {
        this.processors.addFirst(processor);
        this.processor = null;
        if (modifyImports) {
            this.importProcessors.addFirst(processor);
            this.importProcessor = null;
        }
    }

    @Override // foundry.veil.api.event.VeilAddShaderPreProcessorsEvent.Registry
    public void addPreprocessor(ShaderPreProcessor processor, boolean modifyImports) {
        this.processors.addLast(processor);
        this.processor = null;
        if (modifyImports) {
            this.importProcessors.addLast(processor);
            this.importProcessor = null;
        }
    }

    public ShaderPreProcessor getProcessor() {
        if (this.processor == null) {
            this.processor = ShaderPreProcessor.allOf(this.processors);
        }
        return this.processor;
    }

    public ShaderPreProcessor getImportProcessor() {
        if (this.importProcessor == null) {
            this.importProcessor = ShaderPreProcessor.allOf(this.importProcessors);
        }
        return this.importProcessor;
    }

    public ShaderImporterImpl getShaderImporter() {
        return this.importer;
    }
}
